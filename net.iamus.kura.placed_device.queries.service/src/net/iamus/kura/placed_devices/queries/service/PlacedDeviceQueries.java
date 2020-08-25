package net.iamus.kura.placed_devices.queries.service;

import net.iamus.kura.hikari.api.DatabaseConnection;
import net.iamus.kura.models.placed_device.PlacedDeviceModel;
import net.iamus.kura.placed_devices.queries.api.PlacedDeviceQueriesService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = PlacedDeviceQueriesService.class)
public class PlacedDeviceQueries implements PlacedDeviceQueriesService {
	private static final Logger s_logger = LoggerFactory.getLogger(PlacedDeviceQueries.class);

	private static final String APP_ID = "net.iamus.kura.placed_devices.service";

	Connection connection;
	PlacedDeviceModel placedDeviceModel;

	@Activate
	protected void activate(ComponentContext componentContext) {

		s_logger.info("Bundle " + APP_ID + " has started!");

		s_logger.debug(APP_ID + ": This is a debug message.");

	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {

		s_logger.info("Bundle " + APP_ID + " has stopped!");

	}
	
	private  PlacedDeviceModel getPlacedDeviceData(Object identifier, String query) {
		placedDeviceModel = new PlacedDeviceModel();
		
		ResultSet resultSet = null;
		int firstColumn = 1;
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			if (identifier.getClass().equals(String.class)) {
				preparedStatement.setString(firstColumn, (String) identifier);
			} else if (identifier.getClass().equals(Integer.class)) {
				preparedStatement.setInt(firstColumn, (Integer) identifier);
			}

			resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			if (resultSet.next()) {
				placedDeviceModel.setId(resultSet.getInt(1));
				placedDeviceModel.setDeviceId(resultSet.getInt(2));
				placedDeviceModel.setCoordinateX(resultSet.getFloat(3));
				placedDeviceModel.setCoordinateY(resultSet.getFloat(4));
				placedDeviceModel.setLocationId(resultSet.getInt(5));				
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
		return placedDeviceModel;
	}

	@Override
	public boolean insertToPlacedDevice(PlacedDeviceModel placedDeviceModel) {
		boolean success = true;
		String query = "INSERT INTO public.placed_devices(device_id, coordinate_x, coordinate_y, loocation_id)VALUES (?, ?, ?, ?);";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {

			preparedStatement.setInt(1, placedDeviceModel.getDeviceId());
			preparedStatement.setFloat(2, placedDeviceModel.getCoordinateX());
			preparedStatement.setFloat(3, placedDeviceModel.getCoordinateY());
			preparedStatement.setInt(4, placedDeviceModel.getLocationId());
			preparedStatement.executeQuery();

		} catch (SQLException e) {

			s_logger.error(e.getMessage());
			success = false;
		}

		return success;
	}
	@Override
	public boolean deletePlacedDeviceByDeviceId(int deviceId) {
		boolean success = true;
		String query = "DELETE FROM placed_devices WHERE device_id = ?";
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setInt(1, deviceId);
			preparedStatement.executeQuery();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}

		return success;
	}
	public boolean updatePlacedDevice(PlacedDeviceModel placedDeviceModel) {
		boolean success = true;
		String query = "UPDATE placed_devices SET device_id = ?, coordinate_x = ?, coordinate_y = ?, loocation_id = ?";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setInt(1, placedDeviceModel.getDeviceId());
			preparedStatement.setFloat(2, placedDeviceModel.getCoordinateX());
			preparedStatement.setFloat(3, placedDeviceModel.getCoordinateY());
			preparedStatement.setInt(4, placedDeviceModel.getLocationId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}
		return success;
	}
	
	public PlacedDeviceModel getPlacedDeviceByDeviceId(int deviceId){
		String query = "SELECT * FROM placed_devices WHERE device_id LIKE ?";
		return this.getPlacedDeviceData(deviceId, query);
	}
	

	@Reference(unbind = "unbindDbConnection")
	protected void bindDatabaseConnectionService(DatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getDbConnection();
	}

	protected void unbindDbConnection(DatabaseConnection databaseConnection) {
		this.connection = null;
	}
}
