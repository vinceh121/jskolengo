package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("evaluationsSetting")
public class EvaluationsSetting extends AbstractSkolengoEntity {
	@Relationship("periods")
	private final List<Period> periods = new ArrayList<>();
	@Relationship("skillsSetting")
	private SkillsSetting skillsSetting;
	private boolean periodicReportsEnabled, evaluationsDetailsAvailable, skillsEnabled;

	public boolean isPeriodicReportsEnabled() {
		return periodicReportsEnabled;
	}

	public void setPeriodicReportsEnabled(boolean periodicReportsEnabled) {
		this.periodicReportsEnabled = periodicReportsEnabled;
	}

	public boolean isEvaluationsDetailsAvailable() {
		return evaluationsDetailsAvailable;
	}

	public void setEvaluationsDetailsAvailable(boolean evaluationsDetailsAvailable) {
		this.evaluationsDetailsAvailable = evaluationsDetailsAvailable;
	}

	public boolean isSkillsEnabled() {
		return skillsEnabled;
	}

	public void setSkillsEnabled(boolean skillsEnabled) {
		this.skillsEnabled = skillsEnabled;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public SkillsSetting getSkillsSetting() {
		return skillsSetting;
	}

	public void setSkillsSetting(SkillsSetting skillsSetting) {
		this.skillsSetting = skillsSetting;
	}

	@Override
	public String toString() {
		return "EvaluationsSetting [periods="
				+ periods
				+ ", skillsSetting="
				+ skillsSetting
				+ ", periodicReportsEnabled="
				+ periodicReportsEnabled
				+ ", evaluationsDetailsAvailable="
				+ evaluationsDetailsAvailable
				+ ", skillsEnabled="
				+ skillsEnabled
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
