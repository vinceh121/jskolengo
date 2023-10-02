package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.agenda.Subject;
import me.vinceh121.jskolengo.entities.people.AbstractPerson;

public class EvaluationService extends AbstractSkolengoEntity {
	private final List<AbstractPerson> teachers = new ArrayList<>();
	private Float coefficient, average, scale, studentAverage;
	private Subject subject;

	public Float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Float coefficient) {
		this.coefficient = coefficient;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Float getScale() {
		return scale;
	}

	public void setScale(Float scale) {
		this.scale = scale;
	}

	public Float getStudentAverage() {
		return studentAverage;
	}

	public void setStudentAverage(Float studentAverage) {
		this.studentAverage = studentAverage;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<AbstractPerson> getTeachers() {
		return teachers;
	}

	@Override
	public String toString() {
		return "EvaluationService [teachers="
				+ teachers
				+ ", coefficient="
				+ coefficient
				+ ", average="
				+ average
				+ ", scale="
				+ scale
				+ ", studentAverage="
				+ studentAverage
				+ ", subject="
				+ subject
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
