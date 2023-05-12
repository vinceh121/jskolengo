package me.vinceh121.jskolengo.entities.agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("homework")
public class Homework extends AbstractSkolengoEntity {
	private String title, html, onlineDeliveryUrl;
	private LocalDateTime dueDateTime;
	private LocalDate dueDate;
	private boolean done, deliverWorkOnline;
	@Relationship("subject")
	private Subject subject;

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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Homework [title="
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
				+ ", subject="
				+ subject
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
