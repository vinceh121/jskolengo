package me.vinceh121.jskolengo.entities.info;

import com.github.jasminb.jsonapi.annotations.Type;

@Type("announcement")
public class Announcement extends News {
	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Announcement [level="
				+ level
				+ ", getAttachments()="
				+ getAttachments()
				+ ", getPublicationDateTime()="
				+ getPublicationDateTime()
				+ ", getTitle()="
				+ getTitle()
				+ ", getShortContent()="
				+ getShortContent()
				+ ", getContent()="
				+ getContent()
				+ ", getUrl()="
				+ getUrl()
				+ ", getLinkedInfoUrl()="
				+ getLinkedInfoUrl()
				+ ", getLinkedWebSiteUrl()="
				+ getLinkedWebSiteUrl()
				+ ", getSchool()="
				+ getSchool()
				+ ", getAuthor()="
				+ getAuthor()
				+ ", getIllustration()="
				+ getIllustration()
				+ ", getId()="
				+ getId()
				+ "]";
	}
	
	public enum Level { // XXX fill up
		INFO;
	}
}
