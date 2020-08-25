package net.iamus.kura.device.queries.service;

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

import net.iamus.kura.device.queries.api.DeviceQueriesService;
import net.iamus.kura.hikari.api.DatabaseConnection;

@Component(service = DeviceQueriesService.class)
public class DeviceQueries implements DeviceQueriesService {

	private static final Logger s_logger = LoggerFactory.getLogger(DeviceQueries.class);

	Connection connection;

	@Activate
	protected void activate(ComponentContext componentContext) {

	}

	@Deactivate
	protected void deactivate(ComponentContext componentContext) {

	}

	private Map<String, Object> getDeviceData(Object identifier, String query) {
		Map<String, Object> deviceData = new HashMap<>();
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
				ResultSetMetaData columns = resultSet.getMetaData();
				for (int i = columns.getColumnCount(); i > 0; i--) {
					deviceData.put(columns.getColumnName(i), resultSet.getObject(i));
				}
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
		return deviceData;

	}

	@Override
	public Map<String, Object> getDeviceByDeviceId(String id) {
		String query = "SELECT * FROM devices WHERE device_id LIKE ?";
		return this.getDeviceData(id, query);
	}

	@Override
	public boolean deleteFromDevicesByDeviceId(String id) {
		boolean success = true;
		String query = "DELETE FROM devices WHERE device_id = ?";
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setString(1, id);
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}
		return success;
	}
	
	@Override
	public boolean insertToDevices() {
		boolean success = true;
		String query = "INSERT INTO public.devices( device_id, device_type, battery_status, definition) VALUES (?, ?, ?, ?);";
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
			preparedStatement.setString(1, "BBbB");
			preparedStatement.setString(2, "anchor");
			preparedStatement.setInt(3, 100);
			preparedStatement.setString(4, "worker");
			preparedStatement.executeQuery();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());
			success = false;
		}
		return success;
	}
	
	@Override
	public boolean updateDevice(String deviceId) {
//		boolean success = true;
//		String query = "UPDATE devices SET device_type = ?, definition = ? WHERE device_id = ?";
//		try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
//			preparedStatement.setString(1, "tag");
//			preparedStatement.setString(2, "worker");
//			preparedStatement.setString(3, deviceId);
//			preparedStatement.executeLargeUpdate();
//		} catch (SQLException e) {
//			s_logger.error(e.getMessage());
//			success = false;
//		}
		return true; //success;
	}

	@Reference (unbind="unbindDbConnection")
	protected void bindDatabaseConnectionService(DatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getDbConnection();
	}
	
	protected void unbindDbConnection(DatabaseConnection databaseConnection) {
		this.connection = null;
	}


}
