package me.vinceh121.jskolengo;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

public abstract class AbstractSkolengo implements Closeable, AutoCloseable {
	protected final CloseableHttpClient client;
	protected final ObjectMapper mapper;
	protected final ResourceConverter converter;
	protected String baseUrl = SkolengoConstants.BASE_URL;

	public AbstractSkolengo(CloseableHttpClient client, ObjectMapper mapper) {
		this(client, mapper, new ResourceConverter(mapper, SkolengoConstants.ENTITY_CLASSES));
	}

	public AbstractSkolengo(CloseableHttpClient client, ObjectMapper mapper, ResourceConverter converter) {
		this.client = client;
		this.mapper = mapper;
		this.converter = converter;
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

	public CloseableHttpClient getClient() {
		return this.client;
	}

	public ObjectMapper getMapper() {
		return this.mapper;
	}

	public ResourceConverter getConverter() {
		return this.converter;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public void setBaseUrl(final String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public void close() throws IOException {
		this.client.close();
	}
}
