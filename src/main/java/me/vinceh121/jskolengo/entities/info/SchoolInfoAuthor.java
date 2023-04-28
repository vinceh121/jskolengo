package me.vinceh121.jskolengo.entities.info;

import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;

import me.vinceh121.jskolengo.entities.AbstractSkolengoEntity;
import me.vinceh121.jskolengo.entities.people.AbstractPerson;

@Type("schoolInfoAuthor")
public class SchoolInfoAuthor extends AbstractSkolengoEntity {
	@Relationship("technicalUser")
	private SchoolInfoTechnicalUser technicalUser;
	@Relationship("person")
	private AbstractPerson person;
	private String additionalInfo;

	public SchoolInfoTechnicalUser getTechnicalUser() {
		return technicalUser;
	}

	public void setTechnicalUser(SchoolInfoTechnicalUser technicalUser) {
		this.technicalUser = technicalUser;
	}

	public AbstractPerson getPerson() {
		return person;
	}

	public void setPerson(AbstractPerson person) {
		this.person = person;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "SchoolInfoAuthor [technicalUser="
				+ technicalUser
				+ ", person="
				+ person
				+ ", additionalInfo="
				+ additionalInfo
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
