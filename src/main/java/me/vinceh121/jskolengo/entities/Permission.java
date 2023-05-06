package me.vinceh121.jskolengo.entities;

import java.util.ArrayList;
import java.util.List;

public class Permission {
	private final List<Operation> permittedOperations = new ArrayList<>();
	private String schoolId;
	private Service service;

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Operation> getPermittedOperations() {
		return permittedOperations;
	}

	@Override
	public String toString() {
		return "Permission [permittedOperations="
				+ permittedOperations
				+ ", schoolId="
				+ schoolId
				+ ", service="
				+ service
				+ "]";
	}
}
