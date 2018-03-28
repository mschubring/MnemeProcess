package inc.troll.mnemeprocess.rest.networks.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NetworkDto {

	@JsonProperty("id")
	private long id;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("last_update")
	private String lastUpdate;

	@JsonProperty("mac_address")
	private String macAddress;

	@JsonProperty("ssid")
	private String ssid;

	@JsonProperty("frequency")
	private int frequency;

	@JsonProperty("capabilities")
	private String capabilities;

	@JsonProperty("update_count")
	private int updateCount;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getSsid() {
		return ssid;
	}
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public String getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(String capabilities) {
		this.capabilities = capabilities;
	}

	public int getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}
}
