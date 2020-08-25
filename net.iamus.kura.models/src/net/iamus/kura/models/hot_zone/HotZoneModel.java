package net.iamus.kura.models.hot_zone;

public class HotZoneModel {
	private int id;
	private String hotZoneId;
	private int locationId;
	private float zoneCoordinateX;
	private float zoneCoordinateY;
	private int hotZoneRuleId;
	
	HotZoneModel(){}
	
	HotZoneModel(int id, String hotZoneId, int locationId, float zoneCoordinateX, float zoneCoordinateY,
			int hotZoneRuleId) {
		this.id = id;
		this.hotZoneId = hotZoneId;
		this.locationId = locationId;
		this.zoneCoordinateX = zoneCoordinateX;
		this.zoneCoordinateY = zoneCoordinateY;
		this.hotZoneRuleId = hotZoneRuleId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotZoneId() {
		return hotZoneId;
	}
	public void setHotZoneId(String hotZoneId) {
		this.hotZoneId = hotZoneId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public float getZoneCoordinateX() {
		return zoneCoordinateX;
	}
	public void setZoneCoordinateX(float zoneCoordinateX) {
		this.zoneCoordinateX = zoneCoordinateX;
	}
	public float getZoneCoordinateY() {
		return zoneCoordinateY;
	}
	public void setZoneCoordinateY(float zoneCoordinateY) {
		this.zoneCoordinateY = zoneCoordinateY;
	}
	public int getHotZoneRuleId() {
		return hotZoneRuleId;
	}
	public void setHotZoneRuleId(int hotZoneRuleId) {
		this.hotZoneRuleId = hotZoneRuleId;
	}

}
