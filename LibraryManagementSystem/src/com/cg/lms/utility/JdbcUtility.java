package com.cg.lms.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.lms.exception.LMSException;

public class JdbcUtility {
	static Connection connection = null;

	public static Connection getConnection() throws LMSException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new LMSException("Class not loaded");
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system", "corp123");
		} catch (SQLException e) {
			throw new LMSException("Not connected to database");
		}
		return connection;

	}
}
