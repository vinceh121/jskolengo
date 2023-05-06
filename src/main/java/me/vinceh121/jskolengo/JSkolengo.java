package me.vinceh121.jskolengo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import me.vinceh121.jskolengo.entities.StudentUserInfo;
import me.vinceh121.jskolengo.entities.info.News;

public class JSkolengo extends JSkolengoAnonymous {
	private String bearerToken, schoolId, emsCode, dateFormat = "utc";

	public JSkolengo() {
	}

	public JSkolengo(CloseableHttpClient client, ObjectMapper mapper, ResourceConverter converter) {
		super(client, mapper, converter);
	}

	public JSkolengo(CloseableHttpClient client, ObjectMapper mapper) {
		super(client, mapper);
	}

	public JSONAPIDocument<StudentUserInfo> fetchUserInfo(String userId) throws IOException {
		return this.fetchUserInfo(userId, List.of("school", "students", "students.school"));
	}

	public JSONAPIDocument<StudentUserInfo> fetchUserInfo(String userId, Collection<String> include)
			throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/users-info/")
					.appendPath(userId)
					.addParameter("includes", String.join(",", include));
			HttpGet get = new HttpGet(build.build());
			this.addHeaders(get);
			return this.requestDocument(get, StudentUserInfo.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public JSONAPIDocument<List<News>> fetchSchoolInfo() throws IOException {
		return this.fetchSchoolInfo(
				List.of("illustration", "school", "author", "author.person", "author.technicalUser", "attachments"));
	}

	public JSONAPIDocument<List<News>> fetchSchoolInfo(Collection<String> include) throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/schools-info")
					.addParameter("include", String.join(",", include));
			HttpGet get = new HttpGet(build.build());
			this.addHeaders(get);
			return this.requestDocumentCollection(get, News.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e); // shouldn't happen
		}
	}

	private void addHeaders(HttpRequest req) {
		if (this.bearerToken != null)
			req.addHeader("Authorization", "Bearer " + this.bearerToken);
		if (this.schoolId != null)
			req.addHeader("X-Skolengo-School-Id", this.schoolId);
		if (this.emsCode != null)
			req.addHeader("X-Skolengo-Ems-Code", this.emsCode);
		if (this.dateFormat != null)
			req.addHeader("X-Skolengo-Date-Format", this.dateFormat);
	}

	public String getBearerToken() {
		return bearerToken;
	}

	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getEmsCode() {
		return emsCode;
	}

	public void setEmsCode(String emsCode) {
		this.emsCode = emsCode;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
