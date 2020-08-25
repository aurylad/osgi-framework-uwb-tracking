package net.iamus.kura.models.equipment_rule;

public class EquipmentRuleModel {
	private int id;
	private String equipmentRuleId;
	private int equipmentRuleVersion;
	private int equipmentTypeId;
	
	EquipmentRuleModel(){}
	EquipmentRuleModel(int id, String equipmentRuleId, int equipmentRuleVersion, int equipmentTypeId) {
		this.id = id;
		this.equipmentRuleId = equipmentRuleId;
		this.equipmentRuleVersion = equipmentRuleVersion;
		this.equipmentTypeId = equipmentTypeId;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipmentRuleId() {
		return equipmentRuleId;
	}
	public void setEquipmentRuleId(String equipmentRuleId) {
		this.equipmentRuleId = equipmentRuleId;
	}
	public int getEquipmentRuleVersion() {
		return equipmentRuleVersion;
	}
	public void setEquipmentRuleVersion(int equipmentRuleVersion) {
		this.equipmentRuleVersion = equipmentRuleVersion;
	}
	public int getEquipmentTypeId() {
		return equipmentTypeId;
	}
	public void setEquipmentTypeId(int equipmentTypeId) {
		this.equipmentTypeId = equipmentTypeId;
	}
	
}
