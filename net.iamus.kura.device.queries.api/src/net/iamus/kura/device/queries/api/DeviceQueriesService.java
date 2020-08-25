package net.iamus.kura.device.queries.api;

import java.util.Map;

public interface DeviceQueriesService {

	public Map<String, Object> getDeviceByDeviceId(String deviceId);

	boolean deleteFromDevicesByDeviceId(String deviceId);
	
	boolean insertToDevices(); //boolean insertToDevices(Map<String, String> deviceProperties);
	
	boolean updateDevice(String deviceId);
}
