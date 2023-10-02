package me.vinceh121.jskolengo.entities.agenda;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.Attachment;

@Type("lessonContent")
public class LessonContent extends AbstractSkolengoEntity {
	@Relationship("attachments")
	private final List<Attachment> attachments = new ArrayList<>();
	private String html, title, url;

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LessonContent [attachment="
				+ attachments
				+ ", html="
				+ html
				+ ", title="
				+ title
				+ ", url="
				+ url
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
