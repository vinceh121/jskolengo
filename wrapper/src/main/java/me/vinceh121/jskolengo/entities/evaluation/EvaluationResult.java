package me.vinceh121.jskolengo.entities.evaluation;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

public class EvaluationResult extends AbstractSkolengoEntity {
	private Float mark;
	private String nonEvaluationReason, comment;

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

	@Override
	public String toString() {
		return "EvaluationResult [mark="
				+ mark
				+ ", nonEvaluationReason="
				+ nonEvaluationReason
				+ ", comment="
				+ comment
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
