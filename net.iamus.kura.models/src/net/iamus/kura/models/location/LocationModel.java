package net.iamus.kura.models.location;

public class LocationModel {
	private int id;
	private String locationId;
	private String locationPicture;
	private float locationScale;
	private float locationWidth;
	private float locationHeight;
	
	public LocationModel(){}
	
	LocationModel(int id, String locationId, String locationPicture, float locationScale, float locationWidth,
			float locationHeight, String calibration) {
		this.id = id;
		this.locationId = locationId;
		this.locationPicture = locationPicture;
		this.locationScale = locationScale;
		this.locationWidth = locationWidth;
		this.locationHeight = locationHeight;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationId() {
		return locationId;
	}
	
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	public String getLocationPicture() {
		return locationPicture;
	}
	
	public void setLocationPicture(String locationPicture) {
		this.locationPicture = locationPicture;
	}
	
	public float getLocationScale() {
		return locationScale;
	}

	public void setLocationScale(float locationScale) {
		this.locationScale = locationScale;
	}
	
	public float getLocationWidth() {
		return locationWidth;
	}
	
	public void setLocationWidth(float locationWidth) {
		this.locationWidth = locationWidth;
	}
	
	public float getLocationHeight() {
		return locationHeight;
	}
	
	public void setLocationHeight(float locationHeight) {
		this.locationHeight = locationHeight;
	}

}
