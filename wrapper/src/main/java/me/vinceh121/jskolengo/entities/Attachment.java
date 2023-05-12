package me.vinceh121.jskolengo.entities;

import com.github.jasminb.jsonapi.annotations.Type;

public class Attachment extends AbstractSkolengoEntity {
	private String name, mimeType, mimeTypeLabel, url, alternativeText;
	private long size;

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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Attachment [name="
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
