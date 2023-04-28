package me.vinceh121.jskolengo.entities.people;

import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;

// not sure what's the actual JSONAPI type name for this one, so prefixing with x- for now
// on top of that, jsonapi-converter requires there to be a Type annotation for classes used for relationships
@Type("x-abstractperson")
public abstract class AbstractPerson extends AbstractSkolengoEntity {
	private String title, firstName, lastName, photoUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "AbstractPerson ("
				+ getClass()
				+ ") [title="
				+ title
				+ ", firstName="
				+ firstName
				+ ", lastName="
				+ lastName
				+ ", photoUrl="
				+ photoUrl
				+ "]";
	}
}
