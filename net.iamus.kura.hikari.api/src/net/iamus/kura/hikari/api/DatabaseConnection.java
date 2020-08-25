package net.iamus.kura.hikari.api;

import java.sql.Connection;

public interface DatabaseConnection {

	public Connection getDbConnection();
	
}
