package com.cg.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.hms.exception.HMSExceptions;
import com.cg.hms.model.Patient;
import com.cg.hms.utility.JdbcUtility;

public class HMSDaoImpl implements HMSDao {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	Logger logger = Logger.getLogger(HMSDaoImpl.class);
	
	/**
	 * 		method 		: Add patient details
	 * 		Arguments	: Its taking model object as an argument
	 * 		return type	: This method returns the generated id to the user
	 * 		Author		: Capgemini
	 * 		Date		: 14-January-2019
	 *
	 * 
	 * */

	@Override
	public int addPatientDetails(Patient patient) throws HMSExceptions {
		
		logger.info("In add patient method");

		connection = JdbcUtility.getConnection();
		
		logger.info("Connection obj created");
		int id = 0;
		try {
			statement = connection
					.prepareStatement(QueryMapper.insertPatientDetails);
			logger.debug("statement object Created");
			statement.setString(1, patient.getName());
			statement.setString(2, patient.getGender());
			statement.setLong(3, patient.getPhoneNumber());
			statement.setString(4, patient.getDisease());

			statement.executeUpdate();
			
			logger.info("execute update called");
			
			statement = connection.prepareStatement(QueryMapper.getpatientId);
			
			logger.info("statement created to get id");
			
			resultSet = statement.executeQuery();
			
			logger.info("result set obj created");
			resultSet.next();
			id = resultSet.getInt(1);
			
			logger.info("generated id is"+ id);
			
		} catch (SQLException e) {
			throw new HMSExceptions("Prepared statement not created");
		}finally{
			try {
				connection.close();
				logger.info("connection closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSExceptions("Prob Connection close");
			}
			try {
				resultSet.close();
				logger.info("resultset closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSExceptions("Prob resultset close");
			}
			try {
				statement.close();
				logger.info("prepared statement closed");
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new HMSExceptions("Prob prepared Statement close");
			}
		}
		
		return id;
	}

}
