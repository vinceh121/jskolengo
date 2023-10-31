package me.vinceh121.jskolengo.entities;

public class SchoolAudience {
	private boolean enabled;
	private String audienceId, projectId;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAudienceId() {
		return audienceId;
	}

	public void setAudienceId(String audienceId) {
		this.audienceId = audienceId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "SchoolAudience [enabled=" + enabled + ", audienceId=" + audienceId + ", projectId=" + projectId + "]";
	}
}
