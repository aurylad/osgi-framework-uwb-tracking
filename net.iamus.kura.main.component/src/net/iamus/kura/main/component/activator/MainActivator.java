package net.iamus.kura.main.component.activator;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import net.iamus.kura.locations.queries.api.LocationQueriesService;
import net.iamus.kura.models.location.LocationModel;
import net.iamus.kura.models.placed_device.PlacedDeviceModel;
import net.iamus.kura.placed_devices.queries.api.PlacedDeviceQueriesService;

@Component
public class MainActivator {

	private static final Logger s_logger = LoggerFactory.getLogger(MainActivator.class);

	LocationQueriesService locationQueriesService;
	PlacedDeviceQueriesService placedDeviceQueriesService;

	@Activate
	protected void activate(ComponentContext componentContext) {
//		test();
		test2();
	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {

	}

	public void test() {
<<<<<<< HEAD
		LocationModel locationModel = new LocationModel();
		locationModel.setLocationId("updated_name");
		locationModel.setLocationPicture("Picture");
		locationModel.setLocationScale((float) 3.37);

		locationModel.setLocationWidth((float) 543.0);
		locationModel.setLocationHeight((float) 650.0);

		locationModel.setLocationWidth((float) 543);
		locationModel.setLocationHeight((float) 650);

		locationModel.setId((int) 1);

		Map<String, Object> hm = new HashMap<String, Object>();
		hm.put("locationId", locationModel.getLocationId());
		hm.put("locationPicture", locationModel.getLocationPicture());
		hm.put("locationScale", locationModel.getLocationScale());
		hm.put("locationWidth", locationModel.getLocationWidth());
		hm.put("locationHeight", locationModel.getLocationHeight());


		hm.put("id", locationModel.getId());


//		locationQueriesService.insertToLocations(hm);
		
//		For location service queries testing..
//		locationQueriesService.insertToLocations(hm);
//		System.out.println(locationQueriesService.getLocationByLocationId("Name"));
//		System.out.println(locationQueriesService.updateLocation(hm));
//		System.out.println(locationQueriesService.deleteLocationByLocationId("Name3"));

		hm.put("id", locationModel.getId());

//		For location service queries testing..
//		locationQueriesService.insertToLocations(hm);
//		System.out.println(locationQueriesService.getLocationByLocationId("Name"));
//		System.out.println(locationQueriesService.updateLocation(hm));
//		System.out.println(locationQueriesService.deleteLocationByLocationId("Name3"));
=======
>>>>>>> a1f8415c5f71208bdead3b684c9f2598c2d5888d

	}

	public void test2() {
		// for placedDeviceQueriesService testing
//		PlacedDeviceModel placedDeviceModel = new PlacedDeviceModel();
//		placedDeviceModel.setDeviceId(1);
//		placedDeviceModel.setCoordinateX(40);
//		placedDeviceModel.setCoordinateY(30);
//		placedDeviceModel.setLocationId(1);
//
//		Map<String, Object> hm2 = new HashMap<String, Object>();
//		hm2.put("locationId", placedDeviceModel.getLocationId());
//		hm2.put("deviceId", placedDeviceModel.getDeviceId());
//		hm2.put("coordinateX", placedDeviceModel.getCoordinateX());
//		hm2.put("coordinateY", placedDeviceModel.getCoordinateY());

		placedDeviceQueriesService.getPlacedDeviceByDeviceId(1);

	}

	@Reference(unbind = "unbindLocationQueriesService")
	protected void bindLocationQueriesService(LocationQueriesService locationQueriesService) {
		this.locationQueriesService = locationQueriesService;
	}

	protected void unbindLocationQueriesService(LocationQueriesService locationQueriesService) {
		this.locationQueriesService = null;
	}

	@Reference(unbind = "unbindPlacedDeviceQueriesService")
	protected void bindPlacedDeviceQueriesService(PlacedDeviceQueriesService placedDeviceQueriesService) {
		this.placedDeviceQueriesService = placedDeviceQueriesService;
	}

	protected void unbindPlacedDeviceQueriesService(PlacedDeviceQueriesService placedDeviceQueriesService) {
		this.placedDeviceQueriesService = null;
	}

}
