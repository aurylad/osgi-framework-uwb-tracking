package net.iamus.kura.models.device;

public class DeviceModel {
	private int id;
	private String deviceId;
	private String deviceType;
	private int batteryStatus;
	private int assetAccessLevel;
	private String definition;

	DeviceModel(){}
	
	DeviceModel(int id, String deviceId, String deviceType, int batteryStatus, int assetAccessLevel, String definition) {
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.batteryStatus = batteryStatus;
		this.assetAccessLevel = assetAccessLevel;
		this.definition = definition;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public int getBatteryStatus() {
		return batteryStatus;
	}
	public void setBatteryStatus(int batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	public int getAssetAccessLevel() {
		return assetAccessLevel;
	}
	public void setAssetAccessLevel(int assetAccessLevel) {
		this.assetAccessLevel = assetAccessLevel;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}

}
