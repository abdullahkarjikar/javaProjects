package com.cg.hms.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cg.hms.exception.HMSExceptions;

public class JdbcUtility {
	static Connection connection = null;

	public static Connection getConnection() throws HMSExceptions {
		File file = null;
		FileInputStream fileInputStream = null;
		Properties properties = new Properties();

		file = new File("resources/jdbc.properties");
		try {
			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);

			String driver = properties.getProperty("db.driver");
			String url = properties.getProperty("db.url");
			String username = properties.getProperty("db.username");
			String password = properties.getProperty("db.password");

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);

		} catch (FileNotFoundException e) {
			throw new HMSExceptions("File Not Found");
		} catch (IOException e) {
			throw new HMSExceptions("Unable to Read File");
		} catch (ClassNotFoundException e) {
			throw new HMSExceptions("Class Not Found Exception");
		} catch (SQLException e) {
			throw new HMSExceptions("SQL Exception");
		}

		return connection;

	}
}
