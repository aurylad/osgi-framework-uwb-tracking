package net.iamus.kura.locations.queries.api;

import java.util.List;

import net.iamus.kura.models.location.LocationModel;

public interface LocationQueriesService {

	boolean insertToLocations(LocationModel locationPropertie);

	public LocationModel getLocationByLocationId(String locationId);
	
	public List<LocationModel> getAllLocations();
		
	boolean deleteLocationByLocationId(String locationId);

	boolean updateLocation(LocationModel locationModel);

}
