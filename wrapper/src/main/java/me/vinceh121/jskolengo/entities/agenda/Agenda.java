package me.vinceh121.jskolengo.entities.agenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("agenda")
public class Agenda extends AbstractSkolengoEntity {
	@Relationship("lessons")
	private final List<Lesson> lessons = new ArrayList<>();
	@Relationship("homeworkAssignments")
	private final List<Homework> homeworkAssignments = new ArrayList<>();
	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public List<Homework> getHomeworkAssignments() {
		return homeworkAssignments;
	}

	@Override
	public String toString() {
		return "Agenda [lessons="
				+ lessons
				+ ", homeworkAssignments="
				+ homeworkAssignments
				+ ", date="
				+ date
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
