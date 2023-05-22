package me.vinceh121.jskolengo.entities.evaluation;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("skillAcquisitionColors")
public class SkillAcquisitionColors extends AbstractSkolengoEntity {
	private final List<ColorLevel> colorLevelMappings = new ArrayList<>();

	public List<ColorLevel> getColorLevelMappings() {
		return this.colorLevelMappings;
	}

	@Override
	public String toString() {
		return "SkillAcquisitionColors [colorLevelMappings=" + colorLevelMappings + ", getId()=" + getId() + "]";
	}
}
