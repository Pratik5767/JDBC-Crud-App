package com.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {
	// so that no object should be created
	private JdbcUtil() {};

	// loading and register the class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	// Establish the connection
	public static Connection getJdbcConnection() throws SQLException, IOException {
		HikariConfig config = new HikariConfig("src\\com\\properties\\application.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource.getConnection();
	}
}