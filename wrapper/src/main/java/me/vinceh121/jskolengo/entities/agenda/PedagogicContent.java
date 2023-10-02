package me.vinceh121.jskolengo.entities.agenda;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

@Type("pedagogicContent")
public class PedagogicContent extends AbstractSkolengoEntity {
	private String title, url;

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
		return "PedagogicContent [title=" + title + ", url=" + url + ", getId()=" + getId() + "]";
	}
}
