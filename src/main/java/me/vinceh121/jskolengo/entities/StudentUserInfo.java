package me.vinceh121.jskolengo.entities;

import java.util.ArrayList;
import java.util.List;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("studentUserInfo")
public class StudentUserInfo extends AbstractSkolengoEntity {
	private final List<Permission> permissions = new ArrayList<>();
	private String className, dateOfBirth, regime, lastName, firstName, photoUrl, externalMail, mobilePhone;
	@Relationship("school")
	private School school;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getRegime() {
		return regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getExternalMail() {
		return externalMail;
	}

	public void setExternalMail(String externalMail) {
		this.externalMail = externalMail;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "StudentUserInfo [permissions="
				+ permissions
				+ ", className="
				+ className
				+ ", dateOfBirth="
				+ dateOfBirth
				+ ", regime="
				+ regime
				+ ", lastName="
				+ lastName
				+ ", firstName="
				+ firstName
				+ ", photoUrl="
				+ photoUrl
				+ ", externalMail="
				+ externalMail
				+ ", mobilePhone="
				+ mobilePhone
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
