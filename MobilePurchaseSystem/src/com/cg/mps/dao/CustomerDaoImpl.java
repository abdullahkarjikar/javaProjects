package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.mps.exception.MpsException;
import com.cg.mps.model.CustomerDetails;
import com.cg.mps.utility.JdbcUtility;

public class CustomerDaoImpl implements CustomerDao {
	
	Connection connection= null;
	PreparedStatement preparedStatement=null;
	boolean result=false;
	@Override
	public boolean getMobileId(int mobileId) throws MpsException {
		connection=JdbcUtility.getConnection();
		
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.getMobileIdQuery);
			preparedStatement.setInt(1, mobileId);
			System.out.println("id in");
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			int checkMobileId=resultSet.getInt("mobileid");
			
			System.out.println(checkMobileId);
			
			if(mobileId==checkMobileId){
				result=true;
			}
		} catch (SQLException e) {
			e.getStackTrace();
			System.err.println("Get mobile ID::Prepared Statement Not Created");
		}
		return result;
	}
	@Override
	public int insertNewPurchaseDetails(CustomerDetails customerDetails)
			throws MpsException {
		connection=JdbcUtility.getConnection();
		//System.out.println("In insert new purchase");
		int countInsertedRecords=0;
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.insertNewPurchaseDetails);
			preparedStatement.setString(1, customerDetails.getCustomerName());
			preparedStatement.setString(2, customerDetails.geteMailId());
			preparedStatement.setString(3, customerDetails.getCustomerMobileNumber());
			preparedStatement.setInt(4, customerDetails.getMobileId());
			
			countInsertedRecords=preparedStatement.executeUpdate();
			//System.out.println("insert new purchase successfully");
		} catch (SQLException e) {
			System.out.println("Prepared Statement Failed");
		}
		return countInsertedRecords;
		
	}
	@Override
	public void reduceMobileQuantity(int mobileId) {
		try {
			System.out.println("in reduce count");
			connection=JdbcUtility.getConnection();
			System.out.println("connection success in reduce");
			int countUpdatedRecords=0;
			
			try {
				preparedStatement=connection.prepareStatement(QueryMapper.updateMobileQuantity);
				preparedStatement.setInt(1, mobileId);
				preparedStatement.setInt(2, mobileId);
				countUpdatedRecords=preparedStatement.executeUpdate();
				System.out.println("Query executed successfully reduce count");
				System.out.println(countUpdatedRecords + " Record Updated(Quantity Reduced)");
				System.out.println("MobileID: " + mobileId + " Quantity Reduced By 1");
			} catch (SQLException e) {
				System.out.println("Reduce Mobile Count: Prepared Statement Not created");
			}
		} catch (MpsException e1) {
			System.out.println("Connection failed");
		}
		
		
		
	}

}
