package me.vinceh121.jskolengo.entities.evaluation;

import java.time.ZonedDateTime;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("period")
public class Period extends AbstractSkolengoEntity {
	private String label;
	private ZonedDateTime startDate, endDate;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ZonedDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(ZonedDateTime startDate) {
		this.startDate = startDate;
	}

	public ZonedDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(ZonedDateTime endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Period [label="
				+ label
				+ ", startDate="
				+ startDate
				+ ", endDate="
				+ endDate
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
