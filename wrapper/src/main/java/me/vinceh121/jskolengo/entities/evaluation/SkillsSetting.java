package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("skillsSetting")
public class SkillsSetting extends AbstractSkolengoEntity {
	private final List<SkillAcquisitionLevel> skillAcquisitionLevels = new ArrayList<>();

	public List<SkillAcquisitionLevel> getSkillAcquisitionLevels() {
		return this.skillAcquisitionLevels;
	}

	@Override
	public String toString() {
		return "SkillsSetting [skillAcquisitionLevels=" + skillAcquisitionLevels + ", getId()=" + getId() + "]";
	}
}
