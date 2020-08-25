package net.iamus.kura.hikari.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import net.iamus.kura.hikari.api.DatabaseConnection;

@Component(service = DatabaseConnection.class)
public class Hikari implements DatabaseConnection {

	private static final Logger s_logger = LoggerFactory.getLogger(Hikari.class);

	private static final String APP_ID = "org.eclipse.kura.example.hello_osgi";

	@Activate
	protected void activate(ComponentContext componentContext) {

		s_logger.info("Bundle POSTGRES CONNECTION has STARTED ");
		System.out.println(getDbConnection());

	}
	
	@Deactivate
	protected void deactivate(ComponentContext componentContext) {

		s_logger.info("Bundle POSTGRES CONNECTION has STOPED ");

	}

	@Override
	public Connection getDbConnection() {

		Connection connection = null;
		try {
			connection = DataSource.getConnection();
		} catch (SQLException e) {
			s_logger.error(e.getMessage());

		}
		s_logger.info("", connection);
		return connection;
	}

}
