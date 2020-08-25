package net.iamus.kura.models.equipment_type;

public class EquipmentTypeModel {
	private int id;
	private String equipmentName;
	
	EquipmentTypeModel(){}
	
	EquipmentTypeModel(int id, String equipmentName) {
		this.id = id;
		this.equipmentName = equipmentName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

}
