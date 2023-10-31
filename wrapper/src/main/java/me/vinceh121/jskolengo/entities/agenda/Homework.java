package me.vinceh121.jskolengo.entities.agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.Attachment;
import me.vinceh121.jskolengo.entities.people.Teacher;

@Type("homework")
public class Homework extends AbstractSkolengoEntity {
	@Relationship("attachments")
	private final List<Attachment> attachments = new ArrayList<>();

	private String title, html, onlineDeliveryUrl;
	private LocalDateTime dueDateTime;
	private LocalDate dueDate;
	private boolean done, deliverWorkOnline, submissionAllowed;

	@Relationship("subject")
	private Subject subject;

	@Relationship("teacher")
	private Teacher teacher;

	@Relationship("commonCorrectedWork")
	private CorrectedWork commonCorrectedWork;

	@Relationship("audio")
	private Audio audio;

	@Relationship("pedagogicContent")
	private PedagogicContent pedagogicContent;

	@Relationship("individualCorrectedWork")
	private CorrectedWork invididualCorrectedWork;

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getOnlineDeliveryUrl() {
		return onlineDeliveryUrl;
	}

	public void setOnlineDeliveryUrl(String onlineDeliveryUrl) {
		this.onlineDeliveryUrl = onlineDeliveryUrl;
	}

	public LocalDateTime getDueDateTime() {
		return dueDateTime;
	}

	public void setDueDateTime(LocalDateTime dueDateTime) {
		this.dueDateTime = dueDateTime;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isDeliverWorkOnline() {
		return deliverWorkOnline;
	}

	public void setDeliverWorkOnline(boolean deliverWorkOnline) {
		this.deliverWorkOnline = deliverWorkOnline;
	}

	public boolean isSubmissionAllowed() {
		return submissionAllowed;
	}

	public void setSubmissionAllowed(boolean submissionAllowed) {
		this.submissionAllowed = submissionAllowed;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public CorrectedWork getCommonCorrectedWork() {
		return commonCorrectedWork;
	}

	public void setCommonCorrectedWork(CorrectedWork commonCorrectedWork) {
		this.commonCorrectedWork = commonCorrectedWork;
	}

	public Audio getAudio() {
		return audio;
	}

	public void setAudio(Audio audio) {
		this.audio = audio;
	}

	public PedagogicContent getPedagogicContent() {
		return pedagogicContent;
	}

	public void setPedagogicContent(PedagogicContent pedagogicContent) {
		this.pedagogicContent = pedagogicContent;
	}

	public CorrectedWork getInvididualCorrectedWork() {
		return invididualCorrectedWork;
	}

	public void setInvididualCorrectedWork(CorrectedWork invididualCorrectedWork) {
		this.invididualCorrectedWork = invididualCorrectedWork;
	}

	@Override
	public String toString() {
		return "Homework [attachments="
				+ attachments
				+ ", title="
				+ title
				+ ", html="
				+ html
				+ ", onlineDeliveryUrl="
				+ onlineDeliveryUrl
				+ ", dueDateTime="
				+ dueDateTime
				+ ", dueDate="
				+ dueDate
				+ ", done="
				+ done
				+ ", deliverWorkOnline="
				+ deliverWorkOnline
				+ ", submissionAllowed="
				+ submissionAllowed
				+ ", subject="
				+ subject
				+ ", teacher="
				+ teacher
				+ ", commonCorrectedWork="
				+ commonCorrectedWork
				+ ", audio="
				+ audio
				+ ", pedagogicContent="
				+ pedagogicContent
				+ ", invididualCorrectedWork="
				+ invididualCorrectedWork
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
