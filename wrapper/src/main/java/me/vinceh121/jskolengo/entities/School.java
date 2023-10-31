package me.vinceh121.jskolengo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jasminb.jsonapi.annotations.Type;

@Type("school")
public class School extends AbstractSkolengoEntity {
	private final List<Service> subscribedServices = new ArrayList<>();
	private String name, addressLine1, addressLine2, addressLine3, zipCode, city, country, homePageUrl, emsCode,
			emsOIDCWellKnownUrl, timeZone, administrativeId;
	private Double distance;
	private SchoolAudience schoolAudience;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public List<String> getAddressLines() {
		List<String> lst = new ArrayList<>();
		lst.add(this.addressLine1);
		lst.add(this.addressLine2);
		lst.add(this.addressLine3);
		return lst;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHomePageUrl() {
		return homePageUrl;
	}

	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}

	public String getEmsCode() {
		return emsCode;
	}

	public void setEmsCode(String emsCode) {
		this.emsCode = emsCode;
	}

	public String getEmsOIDCWellKnownUrl() {
		return emsOIDCWellKnownUrl;
	}

	public void setEmsOIDCWellKnownUrl(String emsOIDCWellKnownUrl) {
		this.emsOIDCWellKnownUrl = emsOIDCWellKnownUrl;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getAdministrativeId() {
		return administrativeId;
	}

	public void setAdministrativeId(String administrativeId) {
		this.administrativeId = administrativeId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public List<Service> getSubscribedServices() {
		return subscribedServices;
	}

	public SchoolAudience getSchoolAudience() {
		return schoolAudience;
	}

	public void setSchoolAudience(SchoolAudience schoolAudience) {
		this.schoolAudience = schoolAudience;
	}

	@Override
	public String toString() {
		return "School [subscribedServices="
				+ subscribedServices
				+ ", name="
				+ name
				+ ", addressLine1="
				+ addressLine1
				+ ", addressLine2="
				+ addressLine2
				+ ", addressLine3="
				+ addressLine3
				+ ", zipCode="
				+ zipCode
				+ ", city="
				+ city
				+ ", country="
				+ country
				+ ", homePageUrl="
				+ homePageUrl
				+ ", emsCode="
				+ emsCode
				+ ", emsOIDCWellKnownUrl="
				+ emsOIDCWellKnownUrl
				+ ", timeZone="
				+ timeZone
				+ ", administrativeId="
				+ administrativeId
				+ ", distance="
				+ distance
				+ ", schoolAudience="
				+ schoolAudience
				+ "]";
	}
}
