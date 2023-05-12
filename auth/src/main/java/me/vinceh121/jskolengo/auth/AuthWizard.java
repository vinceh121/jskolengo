package me.vinceh121.jskolengo.auth;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.browser.CefMessageRouter;
import org.cef.handler.CefLoadHandlerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formdev.flatlaf.FlatDarkLaf;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.oauth2.sdk.AuthorizationCodeGrant;
import com.nimbusds.oauth2.sdk.ParseException;
import com.nimbusds.oauth2.sdk.ResponseType;
import com.nimbusds.oauth2.sdk.Scope;
import com.nimbusds.oauth2.sdk.TokenRequest;
import com.nimbusds.oauth2.sdk.TokenResponse;
import com.nimbusds.oauth2.sdk.auth.ClientAuthentication;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.oauth2.sdk.id.State;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import com.nimbusds.openid.connect.sdk.AuthenticationResponseParser;
import com.nimbusds.openid.connect.sdk.Nonce;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponse;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponseParser;
import com.nimbusds.openid.connect.sdk.op.OIDCProviderMetadata;
import com.nimbusds.openid.connect.sdk.token.OIDCTokens;

import me.friwi.jcefmaven.CefAppBuilder;
import me.friwi.jcefmaven.CefInitializationException;
import me.friwi.jcefmaven.UnsupportedPlatformException;
import me.vinceh121.jskolengo.JSkolengo;
import me.vinceh121.jskolengo.SkolengoConstants;

public class AuthWizard extends JDialog {
	private static final long serialVersionUID = 3438454344613099083L;
	private final ObjectMapper mapper = new ObjectMapper();
	private final JSkolengo skolengo;
	private final HttpClient client;
	private final JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
	private final JTabbedPane tabbedPane = new JTabbedPane();
	private final SchoolSelectionPanel pnlSchoolSelect;
	private final JPanel pnlBrowser = new JPanel(new BorderLayout());
	private final JTextArea txtTokens = new JTextArea();
	private final CefApp cefApp;
	private final CefClient cefClient;
	private CefBrowser browser;
	private OIDCProviderMetadata oidcProviderMetadata;
	private OIDCTokens tokens;

	public static void main(String[] args) {
		FlatDarkLaf.setup();
		JSkolengo sko = new JSkolengo();

		try {
			AuthWizard wiz = new AuthWizard(sko);
			wiz.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			wiz.setVisible(true);
		} catch (IOException | UnsupportedPlatformException | InterruptedException | CefInitializationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public AuthWizard(JSkolengo skolengo)
			throws IOException, UnsupportedPlatformException, InterruptedException, CefInitializationException {
		this.skolengo = skolengo;
		this.client = HttpClients.createDefault();

		this.setSize(500, 400);
		this.setLayout(new BorderLayout(5, 5));

		this.tabbedPane.setEnabled(false);
		this.add(this.tabbedPane, BorderLayout.CENTER);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(e -> this.dispose());
		this.panelButtons.add(btnCancel);

		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(e -> {
			this.tabbedPane.setSelectedIndex(this.tabbedPane.getSelectedIndex() - 1);
			btnPrevious.setEnabled(this.tabbedPane.getSelectedIndex() != 0);
		});
		this.panelButtons.add(btnPrevious);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(e -> this.nextStep());
		this.panelButtons.add(btnNext);

		this.add(this.panelButtons, BorderLayout.SOUTH);

		this.pnlSchoolSelect = new SchoolSelectionPanel(skolengo);
		this.tabbedPane.addTab("School selection", this.pnlSchoolSelect);

		CefAppBuilder cefBuilder = new CefAppBuilder();
		cefBuilder.getCefSettings().windowless_rendering_enabled = false;
		cefBuilder.install();
		this.cefApp = cefBuilder.build();

		this.cefClient = this.cefApp.createClient();

		// huh apparently this is required, even though it looks unused
		CefMessageRouter router = CefMessageRouter.create();
		this.cefClient.addMessageRouter(router);

		this.cefClient.addLoadHandler(new CefLoadHandlerAdapter() {
			@Override
			public void onLoadEnd(CefBrowser browser, CefFrame frame, int httpStatusCode) {
				String url = browser.getURL();
				if (url.startsWith(SkolengoConstants.OIDC_CALLBACK)) {
					handleOIDCCallback(url);
				}
			};
		});

		this.tabbedPane.addTab("Authorization", this.pnlBrowser);

		this.tabbedPane.addTab("Tokens", this.txtTokens);
	}

	private void nextStep() {
		try {
			switch (this.tabbedPane.getSelectedIndex()) {
			case 0:
				if (this.pnlSchoolSelect.getSelectedSchool() == null) {
					JOptionPane.showMessageDialog(null, "Select a school");
					return;
				} else {
					this.performAuthHandshake();
				}
				break;
			}

			this.tabbedPane.setSelectedIndex(
					Math.min(this.tabbedPane.getSelectedIndex() + 1, this.tabbedPane.getTabCount() - 1));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	private void performAuthHandshake() throws ParseException, IOException {
		try {
			this.oidcProviderMetadata = this.fetchMetadata();

			ClientID clientId = new ClientID(SkolengoConstants.OIDC_CLIENT_ID);
			URI callback = new URI(SkolengoConstants.OIDC_CALLBACK);
			State state = new State();
			Nonce nonce = new Nonce();

			AuthenticationRequest req = new AuthenticationRequest.Builder(new ResponseType("code"), new Scope("openid"),
					clientId, callback).state(state)
							.nonce(nonce)
							.endpointURI(this.oidcProviderMetadata.getAuthorizationEndpointURI())
							.build();

			this.browser = this.cefClient.createBrowser(req.toURI().toString(), false, false);
			this.pnlBrowser.add(this.browser.getUIComponent(), BorderLayout.CENTER);
		} catch (URISyntaxException e) { // shouldn't happen
			throw new RuntimeException(e);
		}
	}

	private OIDCProviderMetadata fetchMetadata() throws IOException, ParseException {
		HttpGet get = new HttpGet(this.pnlSchoolSelect.getSelectedSchool().getEmsOIDCWellKnownUrl());
		String str = this.client.execute(get, new BasicHttpClientResponseHandler());
		return OIDCProviderMetadata.parse(str);
	}

	private void handleOIDCCallback(String uri) {
		try {
			this.handleOIDCCallback0(uri);
		} catch (ParseException | URISyntaxException | IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e);
		}
	}

	private void handleOIDCCallback0(String uri) throws ParseException, URISyntaxException, IOException {
		AuthenticationResponse authRes = AuthenticationResponseParser.parse(new URI(uri));
		AuthorizationCode code = authRes.toSuccessResponse().getAuthorizationCode();
		AuthorizationCodeGrant codeGrant = new AuthorizationCodeGrant(code, new URI(SkolengoConstants.OIDC_CALLBACK));

		ClientID clientId = new ClientID(SkolengoConstants.OIDC_CLIENT_ID);
		Secret secret = new Secret(SkolengoConstants.OIDC_CLIENT_SECRET);
		ClientAuthentication clientAuth = new ClientSecretBasic(clientId, secret);

		TokenRequest req = new TokenRequest(this.oidcProviderMetadata.getTokenEndpointURI(), clientAuth, codeGrant);
		TokenResponse res = OIDCTokenResponseParser.parse(req.toHTTPRequest().send());
		if (!res.indicatesSuccess()) {
			throw new RuntimeException(res.toErrorResponse().getErrorObject().getDescription());
		}

		OIDCTokenResponse sucRes = (OIDCTokenResponse) res.toSuccessResponse();
		this.tokens = sucRes.getOIDCTokens();
		this.txtTokens.setText(this.mapper.readTree(this.tokens.toJSONObject().toJSONString()).toPrettyString()); // dirty
																													// shit

		this.nextStep();
	}
}
