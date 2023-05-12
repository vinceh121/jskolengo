package me.vinceh121.jskolengo.entities.agenda;

import java.time.LocalDateTime;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.people.Teacher;

@Type("lesson")
public class Lesson extends AbstractSkolengoEntity {
	private LocalDateTime startDateTime, endDateTime;
	private String title, location, locationComplement;
	private boolean canceled;
	@Relationship("teacher")
	private Teacher teacher;
	@Relationship("subject")
	private Subject subject;

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationComplement() {
		return locationComplement;
	}

	public void setLocationComplement(String locationComplement) {
		this.locationComplement = locationComplement;
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Lesson [startDateTime="
				+ startDateTime
				+ ", endDateTime="
				+ endDateTime
				+ ", title="
				+ title
				+ ", location="
				+ location
				+ ", locationComplement="
				+ locationComplement
				+ ", canceled="
				+ canceled
				+ ", teacher="
				+ teacher
				+ ", subject="
				+ subject
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
