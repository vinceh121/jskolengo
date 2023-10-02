package me.vinceh121.jskolengo.entities.evaluation;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

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
