package me.vinceh121.jskolengo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTPayload {
	private final List<String> permissions = new ArrayList<>();
	private final List<String> roles = new ArrayList<>();
	private String sub, oauthClientId, clientName, iss, scope, serverIpAddress, longTermAuthenticationRequestTokenUsed,
			state, jti, email, clientIpAddress, authenticationDate, successfulAuthenticationHandlers, profile,
			userAgent, nonce, credentialType, aud, authenticationMethod, geoLocation, scopes;
	@JsonProperty("client_id")
	private String clientId;

	@JsonProperty("grant_type")
	private String grantType;

	@JsonProperty("given_name")
	private String givenName;

	@JsonProperty("family_name")
	private String familyName;

	private long exp, iat;
	@JsonProperty("isFromNewLogin") // jackson will strip the "is" from the property name because of the getter!
	private boolean isFromNewLogin;

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getOauthClientId() {
		return oauthClientId;
	}

	public void setOauthClientId(String oauthClientId) {
		this.oauthClientId = oauthClientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getServerIpAddress() {
		return serverIpAddress;
	}

	public void setServerIpAddress(String serverIpAddress) {
		this.serverIpAddress = serverIpAddress;
	}

	public String getLongTermAuthenticationRequestTokenUsed() {
		return longTermAuthenticationRequestTokenUsed;
	}

	public void setLongTermAuthenticationRequestTokenUsed(String longTermAuthenticationRequestTokenUsed) {
		this.longTermAuthenticationRequestTokenUsed = longTermAuthenticationRequestTokenUsed;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getJti() {
		return jti;
	}

	public void setJti(String jti) {
		this.jti = jti;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public String getAuthenticationDate() {
		return authenticationDate;
	}

	public void setAuthenticationDate(String authenticationDate) {
		this.authenticationDate = authenticationDate;
	}

	public String getSuccessfulAuthenticationHandlers() {
		return successfulAuthenticationHandlers;
	}

	public void setSuccessfulAuthenticationHandlers(String successfulAuthenticationHandlers) {
		this.successfulAuthenticationHandlers = successfulAuthenticationHandlers;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getCredentialType() {
		return credentialType;
	}

	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getAuthenticationMethod() {
		return authenticationMethod;
	}

	public void setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public long getIat() {
		return iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public boolean isFromNewLogin() {
		return isFromNewLogin;
	}

	public void setFromNewLogin(boolean isFromNewLogin) {
		this.isFromNewLogin = isFromNewLogin;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public List<String> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "JWTPayload [permissions="
				+ permissions
				+ ", sub="
				+ sub
				+ ", oauthClientId="
				+ oauthClientId
				+ ", clientName="
				+ clientName
				+ ", iss="
				+ iss
				+ ", scope="
				+ scope
				+ ", serverIpAddress="
				+ serverIpAddress
				+ ", longTermAuthenticationRequestTokenUsed="
				+ longTermAuthenticationRequestTokenUsed
				+ ", state="
				+ state
				+ ", jti="
				+ jti
				+ ", email="
				+ email
				+ ", clientIpAddress="
				+ clientIpAddress
				+ ", authenticationDate="
				+ authenticationDate
				+ ", successfulAuthenticationHandlers="
				+ successfulAuthenticationHandlers
				+ ", profile="
				+ profile
				+ ", userAgent="
				+ userAgent
				+ ", nonce="
				+ nonce
				+ ", credentialType="
				+ credentialType
				+ ", aud="
				+ aud
				+ ", authenticationMethod="
				+ authenticationMethod
				+ ", geoLocation="
				+ geoLocation
				+ ", scopes="
				+ scopes
				+ ", clientId="
				+ clientId
				+ ", grantType="
				+ grantType
				+ ", givenName="
				+ givenName
				+ ", familyName="
				+ familyName
				+ ", exp="
				+ exp
				+ ", iat="
				+ iat
				+ ", isFromNewLogin="
				+ isFromNewLogin
				+ "]";
	}
}
