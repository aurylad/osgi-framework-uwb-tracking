package net.iamus.kura.models.placed_device;

public class PlacedDeviceModel {
	private int id;
	private int deviceId;
	private float coordinateX;
	private float coordinateY;
	private int locationId;
	
	public PlacedDeviceModel(){}
	
	PlacedDeviceModel(int id, int deviceId, float coordinateX, float coordinateY, int locationId) {
		this.id = id;
		this.deviceId = deviceId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.locationId = locationId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeviceId() {
		return deviceId;
	}	
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
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
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
}
