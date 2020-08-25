package net.iamus.kura.hikari.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSource {

	private static Properties properties;
	private static HikariConfig config;
	private static HikariDataSource ds;

	static {
		properties = new Properties();
		properties.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
		properties.setProperty("dataSource.user", "postgres");
		properties.setProperty("dataSource.password", "test123");
		properties.setProperty("dataSource.databaseName", "tracking_db");
		properties.setProperty("dataSource.serverName", "localhost");
		config = new HikariConfig(properties);
		ds = new HikariDataSource(config);
	}
	
    private DataSource() {}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void closeConnection() {
		ds.close();
	}
}
