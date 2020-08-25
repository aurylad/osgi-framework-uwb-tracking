package net.iamus.kura.models.asset_access_level;

public class AssetAccessLevel {
	private int id;
	private int assetLevel;
	private String definition;
	
	AssetAccessLevel(){}
	
	AssetAccessLevel(int id, int assetLevel, String definition) {
		this.id = id;
		this.assetLevel = assetLevel;
		this.definition = definition;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAssetLevel() {
		return assetLevel;
	}
	public void setAssetLevel(int assetLevel) {
		this.assetLevel = assetLevel;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
}
