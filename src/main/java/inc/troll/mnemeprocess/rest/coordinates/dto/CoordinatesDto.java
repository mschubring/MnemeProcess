package inc.troll.mnemeprocess.rest.coordinates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoordinatesDto {

	@JsonProperty("id")
	private long id;

	@JsonProperty("created_at")
	private String createdAt;

	@JsonProperty("last_update")
	private String lastUpdate;

	@JsonProperty("mac_address")
	private String macAddress;

	@JsonProperty("signal_strength")
	private int signalStrength;

	@JsonProperty("latitude")
	private float latitude;

	@JsonProperty("longitude")
	private float longitude;

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

	public int getSignalStrength() {
		return signalStrength;
	}
	public void setSignalStrength(int signalStrength) {
		this.signalStrength = signalStrength;
	}

	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
}
