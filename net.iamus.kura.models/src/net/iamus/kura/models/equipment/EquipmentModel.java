package net.iamus.kura.models.equipment;

public class EquipmentModel {
	private int id;
	private String equipmentId;
	private String equipmentType;
	
	EquipmentModel(){}
	
	EquipmentModel(int id, String equipmentId, String equipmentType) {
		this.id = id;
		this.equipmentId = equipmentId;
		this.equipmentType = equipmentType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

}
