package me.vinceh121.jskolengo.entities.evaluation;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("subSkillEvaluationResult")
public class SubSkillEvaluationResult extends AbstractSkolengoEntity {
	private String level;
	private SubSkill subSkill;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public SubSkill getSubSkill() {
		return subSkill;
	}

	public void setSubSkill(SubSkill subSkill) {
		this.subSkill = subSkill;
	}

	@Override
	public String toString() {
		return "SubSkillEvaluationResult [level=" + level + ", subSkill=" + subSkill + ", getId()=" + getId() + "]";
	}
}
