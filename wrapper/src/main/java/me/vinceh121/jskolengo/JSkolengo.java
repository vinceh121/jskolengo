package me.vinceh121.jskolengo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.net.URIBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import me.vinceh121.jskolengo.entities.JWTPayload;
import me.vinceh121.jskolengo.entities.StudentUserInfo;
import me.vinceh121.jskolengo.entities.agenda.Agenda;
import me.vinceh121.jskolengo.entities.evaluation.Evaluation;
import me.vinceh121.jskolengo.entities.evaluation.EvaluationsSetting;
import me.vinceh121.jskolengo.entities.info.News;
import me.vinceh121.jskolengo.pagination.JSONAPIPaginatedCollection;

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

	public JSONAPIPaginatedCollection<EvaluationsSetting> fetchEvaluationsSetting() {
		return this.fetchEvaluationsSetting(this.readPayload().getSub());
	}

	public JSONAPIPaginatedCollection<EvaluationsSetting> fetchEvaluationsSetting(String studentId) {
		return this.fetchEvaluationsSetting(studentId,
				List.of("periods", "skillsSetting", "skillsSetting.skillAcquisitionColors"));
	}

	public JSONAPIPaginatedCollection<EvaluationsSetting> fetchEvaluationsSetting(String studentId,
			Collection<String> includes) {
		return new JSONAPIPaginatedCollection<>(
				(limit, offset) -> this.fetchEvaluationsSetting(studentId, limit, offset, includes));
	}

	public JSONAPIDocument<List<EvaluationsSetting>> fetchEvaluationsSetting(String studentId, int limit, int offset)
			throws IOException {
		return this.fetchEvaluationsSetting(studentId, limit, offset,
				List.of("periods", "skillsSetting", "skillsSetting.skillAcquisitionColors"));
	}

	public JSONAPIDocument<List<EvaluationsSetting>> fetchEvaluationsSetting(String studentId, int limit, int offset,
			Collection<String> includes) throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/evaluations-settings")
					.addParameter("filter[student.id]", studentId)
					.addParameter("page[limit]", Integer.toString(limit))
					.addParameter("page[offset]", Integer.toString(offset))
					.addParameter("include", String.join(",", includes));
			HttpGet get = new HttpGet(build.build());
			this.addHeaders(get);
			return this.requestDocumentCollection(get, EvaluationsSetting.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public JSONAPIPaginatedCollection<Evaluation> fetchEvaluations(String periodId) {
		return this.fetchEvaluations(this.readPayload().getSub(), periodId);
	}

	public JSONAPIPaginatedCollection<Evaluation> fetchEvaluations(String studentId, String periodId) {
		return this.fetchEvaluations(studentId, periodId,
				List.of("subject", "evaluations", "evaluations.evaluationResult",
						"evaluations.evaluationResult.subSkillsEvaluationResults",
						"evaluations.evaluationResult.subSkillsEvaluationResults.subSkill", "evaluations.subSkills",
						"teachers"));
	}

	public JSONAPIPaginatedCollection<Evaluation> fetchEvaluations(String studentId, String periodId,
			Collection<String> includes) {
		return new JSONAPIPaginatedCollection<>(
				(limit, offset) -> this.fetchEvaluations(studentId, periodId, limit, offset, includes));
	}

	public JSONAPIDocument<List<Evaluation>> fetchEvaluations(String studentId, String periodId, int limit, int offset,
			Collection<String> includes) throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/evaluation-services")
					.addParameter("filter[student.id]", studentId)
					.addParameter("filter[period.id]", periodId)
					.addParameter("page[limit]", Integer.toString(limit))
					.addParameter("page[offset]", Integer.toString(offset))
					.addParameter("include", String.join(",", includes));
			HttpGet get = new HttpGet(build.build());
			this.addHeaders(get);
			return this.requestDocumentCollection(get, Evaluation.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public JSONAPIPaginatedCollection<Agenda> fetchAgendas(LocalDate start, LocalDate end) {
		return this.fetchAgendas(this.readPayload().getSub(), start, end);
	}

	public JSONAPIPaginatedCollection<Agenda> fetchAgendas(String userId, LocalDate start, LocalDate end) {
		return new JSONAPIPaginatedCollection<>(
				(limit, offset) -> this.fetchAgendas(userId, start, end, limit, offset, List.of("lessons",
						"lessons.subject", "lessons.teachers", "homeworkAssignments", "homeworkAssignments.subject")));
	}

	public JSONAPIPaginatedCollection<Agenda> fetchAgendas(String userId, LocalDate start, LocalDate end,
			Collection<String> include) {
		return new JSONAPIPaginatedCollection<>(
				(limit, offset) -> this.fetchAgendas(userId, start, end, limit, offset, include));
	}

	public JSONAPIDocument<List<Agenda>> fetchAgendas(String userId, LocalDate start, LocalDate end, int limit,
			int offset, Collection<String> include) throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/agendas")
					.addParameter("include", String.join(",", include))
					.addParameter("filter[student.id]", userId)
					.addParameter("filter[date][GE]", start.toString())
					.addParameter("filter[date][LE]", end.toString())
					.addParameter("page[limit]", Integer.toString(limit))
					.addParameter("page[offset]", Integer.toString(offset));
			HttpGet get = new HttpGet(build.build());
			this.addHeaders(get);
			return this.requestDocumentCollection(get, Agenda.class);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public JSONAPIDocument<StudentUserInfo> fetchUserInfo() throws IOException {
		return this.fetchUserInfo(this.readPayload().getSub());
	}

	public JSONAPIDocument<StudentUserInfo> fetchUserInfo(String userId) throws IOException {
		return this.fetchUserInfo(userId, List.of("school", "students", "students.school"));
	}

	public JSONAPIDocument<StudentUserInfo> fetchUserInfo(String userId, Collection<String> include)
			throws IOException {
		try {
			URIBuilder build = new URIBuilder(SkolengoConstants.BASE_URL).appendPath("/users-info/")
					.appendPath(userId)
					.addParameter("include", String.join(",", include));
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

	public JWTPayload readPayload() {
		String[] parts = this.bearerToken.split(Pattern.quote("."));
		String payloadB64 = parts[1];
		byte[] payload = Base64.getDecoder().decode(payloadB64);
		try {
			return this.mapper.readValue(payload, JWTPayload.class);
		} catch (IOException e) {
			throw new RuntimeException(e); // XXX shouldn't happen?
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
