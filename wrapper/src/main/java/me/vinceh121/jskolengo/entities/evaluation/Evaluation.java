package me.vinceh121.jskolengo.entities.evaluation;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.agenda.Subject;
import me.vinceh121.jskolengo.entities.people.AbstractPerson;

@Type("evaluation")
public class Evaluation extends AbstractSkolengoEntity {
	private final List<EvaluationDetail> evaluations = new ArrayList<>();
	private final List<AbstractPerson> teachers = new ArrayList<>();
	private Float average, scale, coefficient, min, max;
	private ZonedDateTime dateTime;
	private Subject subject;
	private String title, topic;

	@Relationship("subSkills")
	private final List<SubSkill> subSkills = new ArrayList<>();

	@Relationship("evaluationResult")
	private EvaluationResult evaluationResult;

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

	public Float getMin() {
		return min;
	}

	public void setMin(Float min) {
		this.min = min;
	}

	public Float getMax() {
		return max;
	}

	public void setMax(Float max) {
		this.max = max;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public ZonedDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(ZonedDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<EvaluationDetail> getEvaluations() {
		return evaluations;
	}

	public List<AbstractPerson> getTeachers() {
		return teachers;
	}

	public List<SubSkill> getSubSkills() {
		return subSkills;
	}

	public EvaluationResult getEvaluationResult() {
		return evaluationResult;
	}

	public void setEvaluationResult(EvaluationResult evaluationResult) {
		this.evaluationResult = evaluationResult;
	}

	@Override
	public String toString() {
		return "Evaluation [evaluations="
				+ evaluations
				+ ", teachers="
				+ teachers
				+ ", average="
				+ average
				+ ", scale="
				+ scale
				+ ", coefficient="
				+ coefficient
				+ ", min="
				+ min
				+ ", max="
				+ max
				+ ", dateTime="
				+ dateTime
				+ ", subject="
				+ subject
				+ ", title="
				+ title
				+ ", topic="
				+ topic
				+ ", subSkills="
				+ subSkills
				+ ", evaluationResult="
				+ evaluationResult
				+ "]";
	}

}
