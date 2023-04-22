package me.vinceh121.jskolengo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import me.vinceh121.jskolengo.entities.School;

public class JSkolengo {
	public static final String BASE_URL = "https://api.skolengo.com/api/v1/bff-sko-app";
	private final HttpClient client;
	private final ObjectMapper mapper;
	private final ResourceConverter converter;
	private School currentSchool;

	public static void main(String[] args) throws IOException {
		JSkolengo skolengo = new JSkolengo();
		JSONAPIDocument<List<School>> coll = skolengo.searchSchools("pierre", 10, 0);
		System.out.println(coll.get());
	}

	public JSkolengo() {
		this(HttpClients.createDefault(), new ObjectMapper());
	}

	public JSkolengo(HttpClient client, ObjectMapper mapper) {
		this(client, mapper, new ResourceConverter(mapper, School.class));
	}

	public JSkolengo(HttpClient client, ObjectMapper mapper, ResourceConverter converter) {
		this.client = client;
		this.mapper = mapper;
		this.converter = converter;
	}

	public JSONAPIDocument<List<School>> searchSchools(String text, int limit, int offset) throws IOException {
		try {
			List<NameValuePair> params = new ArrayList<>(3);
			params.add(new BasicNameValuePair("filter[text]", text));
			params.add(new BasicNameValuePair("page[limit]", String.valueOf(limit)));
			params.add(new BasicNameValuePair("page[offset]", String.valueOf(offset)));
			URIBuilder build = new URIBuilder(BASE_URL).appendPath("/schools")
					.addParameter("filter[text]", text)
					.addParameter("page[limit]", String.valueOf(limit))
					.addParameter("page[offset]", String.valueOf(offset));
			HttpGet get = new HttpGet(build.build());
			return this.requestDocumentCollection(get, School.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e); // shouldn't happen
		}
	}

	public <T> JSONAPIDocument<T> requestDocument(HttpUriRequest request, Class<T> type) throws IOException {
		JSONAPIDocument<T> collection = this.client.execute(request, res -> {
			byte[] data = EntityUtils.toByteArray(res.getEntity());
			JSONAPIDocument<T> obj = converter.readDocument(data, type);
			return obj;
		});
		return collection;
	}

	public <T> JSONAPIDocument<List<T>> requestDocumentCollection(HttpUriRequest request, Class<T> type)
			throws IOException {
		JSONAPIDocument<List<T>> collection = this.client.execute(request, res -> {
			byte[] data = EntityUtils.toByteArray(res.getEntity());
			JSONAPIDocument<List<T>> obj = converter.readDocumentCollection(data, type);
			return obj;
		});
		return collection;
	}
}
