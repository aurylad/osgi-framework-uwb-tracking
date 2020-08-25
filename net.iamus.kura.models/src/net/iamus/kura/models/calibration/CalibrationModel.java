package net.iamus.kura.models.calibration;

public class CalibrationModel {
	private int id;
	private int locationId;
	private float coordinateX;
	private float coordinateY;
	
	CalibrationModel(){}
	
	CalibrationModel(int id, int locationId, float coordinateX, float coordinateY) {
		this.id = id;
		this.locationId = locationId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
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

}
