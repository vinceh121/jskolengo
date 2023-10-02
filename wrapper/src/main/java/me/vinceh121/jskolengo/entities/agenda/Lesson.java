package me.vinceh121.jskolengo.entities.agenda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.people.Teacher;

@Type("lesson")
public class Lesson extends AbstractSkolengoEntity {
	@Relationship("teachers")
	private final List<Teacher> teacher = new ArrayList<>();

	@Relationship("toDoAfterTheLesson")
	private final List<Homework> toDoAfterTheLesson = new ArrayList<>();

	@Relationship("toDoForTheLesson")
	private final List<Homework> toDoForTheLesson = new ArrayList<>();

	@Relationship("contents")
	private final List<LessonContent> contents = new ArrayList<>();

	private LocalDateTime startDateTime, endDateTime;
	private String title, location, locationComplement;
	private boolean canceled, anyHomeworkToDoForTheLesson, anyHomeworkToDoAfterTheLesson, anyContent;

	@Relationship("subject")
	private Subject subject;

	@Relationship("pedagogicContent")
	private PedagogicContent pedagogicContent;

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public List<Homework> getToDoAfterTheLesson() {
		return toDoAfterTheLesson;
	}

	public List<Homework> getToDoForTheLesson() {
		return toDoForTheLesson;
	}

	public List<LessonContent> getContents() {
		return contents;
	}

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

	public boolean isAnyHomeworkToDoForTheLesson() {
		return anyHomeworkToDoForTheLesson;
	}

	public void setAnyHomeworkToDoForTheLesson(boolean anyHomeworkToDoForTheLesson) {
		this.anyHomeworkToDoForTheLesson = anyHomeworkToDoForTheLesson;
	}

	public boolean isAnyHomeworkToDoAfterTheLesson() {
		return anyHomeworkToDoAfterTheLesson;
	}

	public void setAnyHomeworkToDoAfterTheLesson(boolean anyHomeworkToDoAfterTheLesson) {
		this.anyHomeworkToDoAfterTheLesson = anyHomeworkToDoAfterTheLesson;
	}

	public boolean isAnyContent() {
		return anyContent;
	}

	public void setAnyContent(boolean anyContent) {
		this.anyContent = anyContent;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public PedagogicContent getPedagogicContent() {
		return pedagogicContent;
	}

	public void setPedagogicContent(PedagogicContent pedagogicContent) {
		this.pedagogicContent = pedagogicContent;
	}

	@Override
	public String toString() {
		return "Lesson [teacher="
				+ teacher
				+ ", toDoAfterTheLesson="
				+ toDoAfterTheLesson
				+ ", toDoForTheLesson="
				+ toDoForTheLesson
				+ ", contents="
				+ contents
				+ ", startDateTime="
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
				+ ", anyHomeworkToDoForTheLesson="
				+ anyHomeworkToDoForTheLesson
				+ ", anyHomeworkToDoAfterTheLesson="
				+ anyHomeworkToDoAfterTheLesson
				+ ", anyContent="
				+ anyContent
				+ ", subject="
				+ subject
				+ ", pedagogicContent="
				+ pedagogicContent
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
