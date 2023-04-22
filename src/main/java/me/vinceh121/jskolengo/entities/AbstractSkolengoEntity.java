package me.vinceh121.jskolengo.entities;

import com.github.jasminb.jsonapi.annotations.Id;

public abstract class AbstractSkolengoEntity {
	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
