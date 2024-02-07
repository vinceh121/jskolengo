package me.vinceh121.jskolengo.entities.evaluation;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("subSkill")
public class SubSkill extends AbstractSkolengoEntity {
	private String shortLabel;

	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}

	@Override
	public String toString() {
		return "SubSkill [shortLabel=" + shortLabel + ", getId()=" + getId() + "]";
	}
}
