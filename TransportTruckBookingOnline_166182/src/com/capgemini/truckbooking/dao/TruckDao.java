package com.capgemini.truckbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;
import com.capgemini.truckbooking.utility.JdbcUtility;


public class TruckDao implements ITruckDao {
	
	static Logger logger = Logger.getLogger(TruckDao.class);
	
	Connection connection= null;
	PreparedStatement preparedStatement= null;
	List<TruckBean> truckBeanList= null;
	ResultSet resultSet= null;
	

	/**
	 * 		Method 		: retrieveTruckDetails
	 * 		Arguments	: No arguments
	 * 		return type	: This method returns list to the user
	 * 		Author		: Capgemini
	 * 		Date		: 21-January-2019
	 * 
	 * */
	
	
	@Override
	public List<TruckBean> retrieveTruckDetails() throws BookingException {
		logger.info("Entered reretrieveTruckDetails method");
		connection= JdbcUtility.getConnection();
		logger.info("Connection Established");
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.retrieveTruckDetailsQuery);
			logger.info("Prepared Statement Created");
			resultSet= preparedStatement.executeQuery();
			logger.info("Result Set Created");
			truckBeanList= new ArrayList<TruckBean>();
			while(resultSet.next()){
				TruckBean truckBean= new TruckBean();
				
				int truckID= resultSet.getInt(1);
				String truckType= resultSet.getString(2);
				String origin= resultSet.getString(3);
				String destination= resultSet.getString(4);
				float charges= resultSet.getFloat(5);
				int availablenos= resultSet.getInt(6);
				
				truckBean.setTruckID(truckID);
				truckBean.setTruckType(truckType);
				truckBean.setOrigin(origin);
				truckBean.setDestination(destination);
				truckBean.setCharges(charges);
				truckBean.setAvailablenos(availablenos);
				logger.info("All retrive data: "+truckBean);
				
				truckBeanList.add(truckBean);
				
			}
		} catch (SQLException e) {
			logger.error("Error : "+e.getMessage());
			throw new BookingException("Prepared Statement Not Created");
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Connection Not Closed");
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Prepared Statement Not Closed");
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Result Set Not Closed");
			}
			
		}
		return truckBeanList;
	}


	/**
	 * 		Method 		: validateTruckId
	 * 		Arguments	: arguments TruckBean
	 * 		return type	: This method returns list to the user
	 * 		Author		: Capgemini
	 * 		Date		: 21-January-2019
	 * 
	 * */
	
	@Override
	public List<TruckBean> validateTruckId(int truckId) throws BookingException {
		logger.info("Entered validateTruckId method");
		connection= JdbcUtility.getConnection();
		logger.info("Connection Established");
		try {
			preparedStatement= connection.prepareStatement(QueryMapper.getTruckId);
			logger.info("Prepared Statement Created");
			preparedStatement.setInt(1, truckId);
			resultSet= preparedStatement.executeQuery();
			logger.info("Result Set Created");
			truckBeanList= new ArrayList<TruckBean>();
			if(resultSet.next()){
				TruckBean bean= new TruckBean();
				int noOfTrucks= resultSet.getInt(6);
				bean.setTruckID(truckId);
				bean.setAvailablenos(noOfTrucks);
				
				truckBeanList.add(bean);
				logger.info("All retrive data: "+bean);
			}
		} catch (SQLException e) {
			logger.error("Error : "+e.getMessage());
			throw new BookingException("Prepared Statement Not Created");
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Connection Not Closed");
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Prepared Statement Not Closed");
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Result Set Not Closed");
			}
			
		}
		return truckBeanList;
	}


	@Override
	public int bookTrucks(BookingBean bookingBean) throws BookingException {
		logger.info("Entered bookTrucks method");
		connection= JdbcUtility.getConnection();
		int bookingId=0;
		Date date= Date.valueOf(bookingBean.getDatgeOfTransport());
		try {
			preparedStatement= connection.prepareStatement(QueryMapper.bookTrucksQuery);
			logger.info("Prepared Statement Created");

			preparedStatement.setString(1, bookingBean.getCustId());
			preparedStatement.setLong(2, bookingBean.getCustMobile());
			preparedStatement.setInt(3, bookingBean.getTruckId());
			preparedStatement.setInt(4, bookingBean.getNoOfTrucks());
			preparedStatement.setDate(5, date);
			preparedStatement.executeUpdate();
			
			
			preparedStatement= connection.prepareStatement(QueryMapper.getBookingId);
			logger.info("Prepared Statement Created");

			preparedStatement.setString(1, bookingBean.getCustId());
			resultSet=preparedStatement.executeQuery();
			logger.info("Result Set Created");

			if(resultSet.next()){
				bookingId=resultSet.getInt(1);
				logger.info("booking id is"+bookingId);
			}
			
			
		} catch (SQLException e) {
			throw new BookingException("Prepared Statement Not Created");
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Connection Not Closed");
			}
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Prepared Statement Not Closed");
			}
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Error : "+e.getMessage());
				throw new BookingException("Result Set Not Closed");
			}
			
		}
		return bookingId;
	}

}
