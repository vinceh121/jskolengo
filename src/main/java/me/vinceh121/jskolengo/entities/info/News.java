package me.vinceh121.jskolengo.entities.info;

import java.time.ZonedDateTime;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.School;

@Type("news")
public class News extends AbstractSkolengoEntity {
	private ZonedDateTime publicationDateTime;
	private String title, shortContent, content, url, linkedInfoUrl, linkedWebSiteUrl;
	@Relationship("school")
	private School school;
	@Relationship("author")
	private SchoolInfoAuthor author;
	@Relationship("illustration")
	private SchoolInfoFile illustration;

	public ZonedDateTime getPublicationDateTime() {
		return publicationDateTime;
	}

	public void setPublicationDateTime(ZonedDateTime publicationDateTime) {
		this.publicationDateTime = publicationDateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLinkedInfoUrl() {
		return linkedInfoUrl;
	}

	public void setLinkedInfoUrl(String linkedInfoUrl) {
		this.linkedInfoUrl = linkedInfoUrl;
	}

	public String getLinkedWebSiteUrl() {
		return linkedWebSiteUrl;
	}

	public void setLinkedWebSiteUrl(String linkedWebSiteUrl) {
		this.linkedWebSiteUrl = linkedWebSiteUrl;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public SchoolInfoAuthor getAuthor() {
		return author;
	}

	public void setAuthor(SchoolInfoAuthor author) {
		this.author = author;
	}

	public SchoolInfoFile getIllustration() {
		return illustration;
	}

	public void setIllustration(SchoolInfoFile illustration) {
		this.illustration = illustration;
	}

	@Override
	public String toString() {
		return "News [publicationDateTime="
				+ publicationDateTime
				+ ", title="
				+ title
				+ ", shortContent="
				+ shortContent
				+ ", content="
				+ content
				+ ", url="
				+ url
				+ ", linkedInfoUrl="
				+ linkedInfoUrl
				+ ", linkedWebSiteUrl="
				+ linkedWebSiteUrl
				+ ", school="
				+ school
				+ ", author="
				+ author
				+ ", illustration="
				+ illustration
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
