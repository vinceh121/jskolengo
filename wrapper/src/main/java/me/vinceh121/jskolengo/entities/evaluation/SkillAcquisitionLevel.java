package me.vinceh121.jskolengo.entities.evaluation;

public class SkillAcquisitionLevel {
	private String label, shortLabel;
	private AcquisitionLevel level;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}

	public AcquisitionLevel getLevel() {
		return level;
	}

	public void setLevel(AcquisitionLevel level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SkillAcquisitionLevel [label=" + label + ", shortLabel=" + shortLabel + ", level=" + level + "]";
	}
}
