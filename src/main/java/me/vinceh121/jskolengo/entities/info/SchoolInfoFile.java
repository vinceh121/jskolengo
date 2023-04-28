package me.vinceh121.jskolengo.entities.info;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("schoolInfoFile")
public class SchoolInfoFile extends AbstractSkolengoEntity {
	private String name, mimeType, mimeTypeLabel, url, alternativeText;
	private Long size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getMimeTypeLabel() {
		return mimeTypeLabel;
	}

	public void setMimeTypeLabel(String mimeTypeLabel) {
		this.mimeTypeLabel = mimeTypeLabel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAlternativeText() {
		return alternativeText;
	}

	public void setAlternativeText(String alternativeText) {
		this.alternativeText = alternativeText;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "SchoolInfoFile [name="
				+ name
				+ ", mimeType="
				+ mimeType
				+ ", mimeTypeLabel="
				+ mimeTypeLabel
				+ ", url="
				+ url
				+ ", alternativeText="
				+ alternativeText
				+ ", size="
				+ size
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
