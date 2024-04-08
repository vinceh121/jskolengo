package me.vinceh121.jskolengo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import me.vinceh121.jskolengo.entities.School;
import me.vinceh121.jskolengo.entities.SkoAppConfig;
import me.vinceh121.jskolengo.pagination.JSONAPIPaginatedCollection;

public class JSkolengoAnonymous extends AbstractSkolengo {
	public JSkolengoAnonymous() {
		super(HttpClients.custom().setRetryStrategy(new SkolengoRetryStrategy()).setUserAgent("jskolengo/0.0.1-SNAPSHOT").build(),
				new ObjectMapper().registerModule(new JavaTimeModule()));
	}

	public JSkolengoAnonymous(CloseableHttpClient client, ObjectMapper mapper, ResourceConverter converter) {
		super(client, mapper, converter);
	}

	public JSkolengoAnonymous(CloseableHttpClient client, ObjectMapper mapper) {
		super(client, mapper);
	}

	public JSONAPIDocument<SkoAppConfig> fetchConfig() throws IOException {
		try {
			URIBuilder build = new URIBuilder(this.baseUrl).appendPath("/sko-app-configs/current");
			HttpGet get = new HttpGet(build.build());
			return this.requestDocument(get, SkoAppConfig.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e); // shouldn't happen
		}
	}

	public JSONAPIPaginatedCollection<School> searchSchools(double lat, double lon) {
		return new JSONAPIPaginatedCollection<School>((limit, offset) -> searchSchools(lat, lon, limit, offset));
	}

	public JSONAPIDocument<List<School>> searchSchools(double lat, double lon, int limit, int offset)
			throws IOException {
		try {
			URIBuilder build = new URIBuilder(this.baseUrl).appendPath("/schools")
					.addParameter("filter[lat]", String.valueOf(lat))
					.addParameter("filter[lon]", String.valueOf(lon))
					.addParameter("page[limit]", String.valueOf(limit))
					.addParameter("page[offset]", String.valueOf(offset));
			HttpGet get = new HttpGet(build.build());
			return this.requestDocumentCollection(get, School.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e); // shouldn't happen
		}
	}

	public JSONAPIPaginatedCollection<School> searchSchools(String text) {
		return new JSONAPIPaginatedCollection<School>((limit, offset) -> searchSchools(text, limit, offset));
	}

	public JSONAPIDocument<List<School>> searchSchools(String text, int limit, int offset) throws IOException {
		try {
			URIBuilder build = new URIBuilder(this.baseUrl).appendPath("/schools")
					.addParameter("filter[text]", text)
					.addParameter("page[limit]", String.valueOf(limit))
					.addParameter("page[offset]", String.valueOf(offset));
			HttpGet get = new HttpGet(build.build());
			return this.requestDocumentCollection(get, School.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e); // shouldn't happen
		}
	}
}
