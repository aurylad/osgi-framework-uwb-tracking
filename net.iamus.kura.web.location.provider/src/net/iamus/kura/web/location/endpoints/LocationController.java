package net.iamus.kura.web.location.endpoints;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import net.iamus.kura.locations.queries.api.LocationQueriesService;
import net.iamus.kura.models.location.LocationModel;

@Api
@Component(service = LocationController.class)
@Path("/web")
public class LocationController {

	private static final Logger s_logger = LoggerFactory.getLogger(LocationController.class);

	LocationQueriesService locationQueriesService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/locations")
	@ApiOperation(value = "Get list of all registered locations")
	public List<LocationModel> getLocationsList() {

		return locationQueriesService.getAllLocations();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/location")
	@ApiOperation(value = "Get specific location by location id")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Invalid ID supplied"), })
	public Map<String, Object> getLocationByLocationId(@QueryParam("locationId") String locationId) {

		return null;//locationQueriesService.getLocationByLocationId(locationId);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addLocation")
	@ApiOperation(value = "Add new location")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Invalid ID supplied"), })
	public LocationModel addLocation(LocationModel locationModel) {

		return locationModel;
	}

	@Reference(unbind = "unbindLocationQueriesService")
	protected void bindLocationQueriesService(LocationQueriesService locationQueriesService) {
		this.locationQueriesService = locationQueriesService;
	}

	protected void unbindLocationQueriesService(LocationQueriesService locationQueriesService) {
		this.locationQueriesService = null;
	}

}
