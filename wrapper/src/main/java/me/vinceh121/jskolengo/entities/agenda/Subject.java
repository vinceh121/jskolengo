package me.vinceh121.jskolengo.entities.agenda;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("subject")
public class Subject extends AbstractSkolengoEntity {
	private String label, color;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Subject [label=" + label + ", color=" + color + ", getId()=" + getId() + "]";
	}
}
