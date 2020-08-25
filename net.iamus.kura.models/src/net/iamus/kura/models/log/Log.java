package net.iamus.kura.models.log;

import java.sql.Date;

public class Log {
	private int logId;
	private String deviceId;
	private String locationId;
	private float coordinateX;
	private float coordinateY;
	private Date logTimeStamp;

	Log(){}
	
	Log(int logId, String deviceId, String locationId, float coordinateX, float coordinateY) {
		this.logId = logId;
		this.deviceId = deviceId;
		this.locationId = locationId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	
	public int logId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public float getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(float coordinateX) {
		this.coordinateX = coordinateX;
	}
	public float getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(float coordinateY) {
		this.coordinateY = coordinateY;
	}

	public Date getLogTimeStamp() {
		return logTimeStamp;
	}

	public void setLogTimeStamp(Date logTimeStamp) {
		this.logTimeStamp = logTimeStamp;
	}
	
}
