package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

public class EvaluationDetail extends AbstractSkolengoEntity {
	private final List<SubSkill> subSkills = new ArrayList<>();
	private String title, topic;
	private float coefficient;
	private Float min, max, average, scale;
	private EvaluationService evaluationService;
	private EvaluationResult evaluationResult;

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

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
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

	public EvaluationService getEvaluationService() {
		return evaluationService;
	}

	public void setEvaluationService(EvaluationService evaluationService) {
		this.evaluationService = evaluationService;
	}

	public EvaluationResult getEvaluationResult() {
		return evaluationResult;
	}

	public void setEvaluationResult(EvaluationResult evaluationResult) {
		this.evaluationResult = evaluationResult;
	}

	public List<SubSkill> getSubSkills() {
		return subSkills;
	}

	@Override
	public String toString() {
		return "EvaluationDetails [subSkills="
				+ subSkills
				+ ", title="
				+ title
				+ ", topic="
				+ topic
				+ ", coefficient="
				+ coefficient
				+ ", min="
				+ min
				+ ", max="
				+ max
				+ ", average="
				+ average
				+ ", scale="
				+ scale
				+ ", evaluationService="
				+ evaluationService
				+ ", evaluationResult="
				+ evaluationResult
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
