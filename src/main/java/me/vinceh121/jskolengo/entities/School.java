package me.vinceh121.jskolengo.entities;

import java.util.List;

import com.github.jasminb.jsonapi.annotations.Type;

@Type("school")
public class School extends AbstractSkolengoEntity {
	private String name, addressLine1, addressLine2, addressLine3, zipCode, city, country, homePageUrl, emsCode,
			emsOIDCWellKnownUrl;
	private Double distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getAddressLines() {
		return List.of(this.getAddressLine1(), this.getAddressLine2(), this.getAddressLine3());
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

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "School [id="
				+ this.getId()
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
				+ "]";
	}
}
