package me.vinceh121.jskolengo.entities;

import java.util.Objects;

import com.github.jasminb.jsonapi.annotations.Type;

@Type("skoAppConfig")
public class SkoAppConfig extends AbstractSkolengoEntity {
	private String latestDeployedSkoAppVersion, latestSupportedSkoAppVersion, skoAppDeploymentInfoUrl;
	private int apiCallRetryDelay, apiCallMaxRetries;

	public String getLatestDeployedSkoAppVersion() {
		return latestDeployedSkoAppVersion;
	}

	public void setLatestDeployedSkoAppVersion(String latestDeployedSkoAppVersion) {
		this.latestDeployedSkoAppVersion = latestDeployedSkoAppVersion;
	}

	public String getLatestSupportedSkoAppVersion() {
		return latestSupportedSkoAppVersion;
	}

	public void setLatestSupportedSkoAppVersion(String latestSupportedSkoAppVersion) {
		this.latestSupportedSkoAppVersion = latestSupportedSkoAppVersion;
	}

	public String getSkoAppDeploymentInfoUrl() {
		return skoAppDeploymentInfoUrl;
	}

	public void setSkoAppDeploymentInfoUrl(String skoAppDeploymentInfoUrl) {
		this.skoAppDeploymentInfoUrl = skoAppDeploymentInfoUrl;
	}

	public int getApiCallRetryDelay() {
		return apiCallRetryDelay;
	}

	public void setApiCallRetryDelay(int apiCallRetryDelay) {
		this.apiCallRetryDelay = apiCallRetryDelay;
	}

	public int getApiCallMaxRetries() {
		return apiCallMaxRetries;
	}

	public void setApiCallMaxRetries(int apiCallMaxRetries) {
		this.apiCallMaxRetries = apiCallMaxRetries;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiCallMaxRetries, apiCallRetryDelay, latestDeployedSkoAppVersion,
				latestSupportedSkoAppVersion, skoAppDeploymentInfoUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SkoAppConfig other = (SkoAppConfig) obj;
		return apiCallMaxRetries == other.apiCallMaxRetries && apiCallRetryDelay == other.apiCallRetryDelay
				&& Objects.equals(latestDeployedSkoAppVersion, other.latestDeployedSkoAppVersion)
				&& Objects.equals(latestSupportedSkoAppVersion, other.latestSupportedSkoAppVersion)
				&& Objects.equals(skoAppDeploymentInfoUrl, other.skoAppDeploymentInfoUrl);
	}

	@Override
	public String toString() {
		return "SkoAppConfig [latestDeployedSkoAppVersion="
				+ latestDeployedSkoAppVersion
				+ ", latestSupportedSkoAppVersion="
				+ latestSupportedSkoAppVersion
				+ ", skoAppDeploymentInfoUrl="
				+ skoAppDeploymentInfoUrl
				+ ", apiCallRetryDelay="
				+ apiCallRetryDelay
				+ ", apiCallMaxRetries="
				+ apiCallMaxRetries
				+ ", getId()="
				+ getId()
				+ "]";
	}
}
