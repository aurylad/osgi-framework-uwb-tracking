package net.iamus.kura.location.queries.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import net.iamus.kura.hikari.api.DatabaseConnection;
import net.iamus.kura.locations.queries.api.LocationQueriesService;
import net.iamus.kura.models.location.LocationModel;

@Component(service = LocationQueriesService.class)
public class LocationQueries implements LocationQueriesService {

	private static final Logger s_logger = LoggerFactory.getLogger(LocationQueries.class);

	Connection connection;
	LocationModel locationModel;

	@Activate
	protected void activate(ComponentContext componentContext) {
		getAllLocations();
	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {

	}

	private LocationModel getLocationData(Object identifier, String query) {
		locationModel = new LocationModel();
		ResultSet resultSet = null;
		int firstColumn = 1;

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			if (identifier.getClass().equals(String.class)) {
				preparedStatement.setString(firstColumn, (String) identifier);
			} else if (identifier.getClass().equals(Integer.class)) {
				preparedStatement.setInt(firstColumn, (Integer) identifier);
			}
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				locationModel.setId(resultSet.getInt(1));
				locationModel.setLocationId(resultSet.getString(2));
				locationModel.setLocationPicture(resultSet.getString(3));
				locationModel.setLocationScale(resultSet.getFloat(4));
				locationModel.setLocationWidth(resultSet.getFloat(5));
				locationModel.setLocationHeight(resultSet.getFloat(6));
			}
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				s_logger.error(e.getMessage());
			}
		}
		return locationModel;
	}

	@Override
	public boolean insertToLocations(LocationModel locationProperties) {
		boolean success = true;
		String query = "INSERT INTO locations (location_id, location_picture, location_scale, location_width, location_height) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {





			preparedStatement.setString(1, (String) locationProperties.get("locationId"));
			preparedStatement.setString(2, (String) locationProperties.get("locationPicture"));
			preparedStatement.setFloat(3, (float) locationProperties.get("locationScale"));
			preparedStatement.setFloat(4, (float) locationProperties.get("locationWidth"));
			preparedStatement.setFloat(5, (float) locationProperties.get("locationHeight"));

			preparedStatement.setString(1, locationProperties.getLocationId());
			preparedStatement.setString(2, locationProperties.getLocationPicture());
			preparedStatement.setFloat(3, locationProperties.getLocationScale());
			preparedStatement.setFloat(4, locationProperties.getLocationWidth());
			preparedStatement.setFloat(5, locationProperties.getLocationHeight());

			preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}
		return success;
	}

	@Override
	public LocationModel getLocationByLocationId(String locationId) {
		String query = "SELECT * FROM locations WHERE location_id LIKE ?";
		return this.getLocationData(locationId, query);
	}

	@Override
	public List<LocationModel> getAllLocations() {
		String query = "SELECT * FROM locations";
		locationModel = new LocationModel();
		List<LocationModel> locations = new ArrayList<>();
		ResultSet resultSet;

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				locationModel.setId(resultSet.getInt(1));
				locationModel.setLocationId(resultSet.getString(2));
				locationModel.setLocationPicture(resultSet.getString(3));
				locationModel.setLocationScale(resultSet.getFloat(4));
				locationModel.setLocationWidth(resultSet.getFloat(5));
				locationModel.setLocationHeight(resultSet.getFloat(6));

				locations.add(locationModel);
			}
			System.out.println(locations);
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
		}

		return locations;
	}

	@Override
	public boolean updateLocation(LocationModel locationModel) {
		boolean success = true;
		String query = "UPDATE locations SET location_id = ?, location_picture = ?, location_scale = ?, location_width = ?, location_height = ?  WHERE _id_ = ?";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setString(1, locationModel.getLocationId());
			preparedStatement.setString(2, locationModel.getLocationPicture());
			preparedStatement.setFloat(3, locationModel.getLocationScale());
			preparedStatement.setFloat(4, locationModel.getLocationWidth());
			preparedStatement.setFloat(5, locationModel.getLocationHeight());
			preparedStatement.setInt(6, locationModel.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}
		return success;
	}

	@Override
	public boolean deleteLocationByLocationId(String locationId) {
		boolean success = true;
		String query = "DELETE FROM locations WHERE location_id = ?";
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setString(1, locationId);
			preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}

		return success;
	}

	@Reference(unbind = "unbindDbConnection")
	protected void bindDatabaseConnectionService(DatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getDbConnection();
	}

	protected void unbindDbConnection(DatabaseConnection databaseConnection) {
		this.connection = null;
	}

}
