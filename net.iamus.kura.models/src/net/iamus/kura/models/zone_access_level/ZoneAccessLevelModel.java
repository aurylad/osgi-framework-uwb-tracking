package net.iamus.kura.models.zone_access_level;

import java.sql.Date;

public class ZoneAccessLevelModel {
	private int id;
	private String zoneRuleId;
	private int zoneRuleVersion;
	private int requiredEquipment;
	private Date allowedTime;
	private int assignedAccessLevel;
	
	ZoneAccessLevelModel(){}
	
	ZoneAccessLevelModel(int id, String zoneRuleId, int zoneRuleVersion, int requiredEquipment, Date allowedTime,
			int assignedAccessLevel) {
		this.id = id;
		this.zoneRuleId = zoneRuleId;
		this.zoneRuleVersion = zoneRuleVersion;
		this.requiredEquipment = requiredEquipment;
		this.allowedTime = allowedTime;
		this.assignedAccessLevel = assignedAccessLevel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZoneRuleId() {
		return zoneRuleId;
	}
	public void setZoneRuleId(String zoneRuleId) {
		this.zoneRuleId = zoneRuleId;
	}
	public int getZoneRuleVersion() {
		return zoneRuleVersion;
	}
	public void setZoneRuleVersion(int zoneRuleVersion) {
		this.zoneRuleVersion = zoneRuleVersion;
	}
	public int getRequiredEquipment() {
		return requiredEquipment;
	}
	public void setRequiredEquipment(int requiredEquipment) {
		this.requiredEquipment = requiredEquipment;
	}
	public Date getAllowedTime() {
		return allowedTime;
	}
	public void setAllowedTime(Date allowedTime) {
		this.allowedTime = allowedTime;
	}
	public int getAssignedAccessLevel() {
		return assignedAccessLevel;
	}
	public void setAssignedAccessLevel(int assignedAccessLevel) {
		this.assignedAccessLevel = assignedAccessLevel;
	}

}
