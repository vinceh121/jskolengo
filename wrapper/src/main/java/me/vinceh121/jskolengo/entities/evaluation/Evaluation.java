package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.agenda.Subject;
import me.vinceh121.jskolengo.entities.people.AbstractPerson;

@Type("evaluation")
public class Evaluation extends AbstractSkolengoEntity {
	private final List<EvaluationDetail> evaluations = new ArrayList<>();
	private final List<AbstractPerson> teachers = new ArrayList<>();
	private float coefficient;
	private Float average, scale;
	private Subject subject;

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<EvaluationDetail> getEvaluations() {
		return evaluations;
	}

	public List<AbstractPerson> getTeachers() {
		return teachers;
	}

	@Override
	public String toString() {
		return "Evaluation [teachers="
				+ teachers
				+ ", coefficient="
				+ coefficient
				+ ", average="
				+ average
				+ ", scale="
				+ scale
				+ ", subject="
				+ subject
				+ ", getId()="
				+ getId()
				+ "]";
	}

}
