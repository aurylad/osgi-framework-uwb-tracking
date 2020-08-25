package net.iamus.kura.placed_devices.queries.api;

import net.iamus.kura.models.placed_device.PlacedDeviceModel;

public interface PlacedDeviceQueriesService {

	boolean insertToPlacedDevice(PlacedDeviceModel placedDeviceModel);

	public boolean deletePlacedDeviceByDeviceId(int deviceId);

	public PlacedDeviceModel getPlacedDeviceByDeviceId(int deviceId);

	public boolean updatePlacedDevice(PlacedDeviceModel placedDeviceModel);
}
