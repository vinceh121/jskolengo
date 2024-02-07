package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("evaluationResult")
public class EvaluationResult extends AbstractSkolengoEntity {
	private Float mark;
	private String nonEvaluationReason, comment;

	@Relationship("subSkillsEvaluationResults")
	private final List<SubSkillEvaluationResult> subSkillsEvaluationResults = new ArrayList<>();

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public String getNonEvaluationReason() {
		return nonEvaluationReason;
	}

	public void setNonEvaluationReason(String nonEvaluationReason) {
		this.nonEvaluationReason = nonEvaluationReason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<SubSkillEvaluationResult> getSubSkillsEvaluationResults() {
		return subSkillsEvaluationResults;
	}

	@Override
	public String toString() {
		return "EvaluationResult [mark="
				+ mark
				+ ", nonEvaluationReason="
				+ nonEvaluationReason
				+ ", comment="
				+ comment
				+ ", subSkillsEvaluationResults="
				+ subSkillsEvaluationResults
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
