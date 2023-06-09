package me.vinceh121.jskolengo.entities.info;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("schoolInfoTechnicalUser")
public class SchoolInfoTechnicalUser extends AbstractSkolengoEntity {
	private String label, logoUrl;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	@Override
	public String toString() {
		return "SchoolInfoTechnicalUser [label=" + label + ", logoUrl=" + logoUrl + ", getId()=" + getId() + "]";
	}
}
