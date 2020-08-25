package net.iamus.kura.models.equipment_report;

public class EquipmentReport {
	private int id;
	private int deviceId;
	private int equipmentId;
	
	EquipmentReport(){}
	
	EquipmentReport(int id, int deviceId, int equipmentId) {
		this.id = id;
		this.deviceId = deviceId;
		this.equipmentId = equipmentId;
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
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}

}
