package com.cg.lms.LMSdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.lms.exception.LMSException;
import com.cg.lms.model.Students;
import com.cg.lms.utility.JdbcUtility;


public class StudentDAOImpl implements StudentDAO {
	
	PreparedStatement statement= null;
	Connection connection= null;
	int result=0;
	
	@Override
	public void createTable() throws LMSException{
		connection= JdbcUtility.getConnection();
		try {
			statement=connection.prepareStatement(LMSQueryMapper.createQuery);
			statement.execute();
			System.out.println("Table Created");
		} catch (SQLException e) {
			System.out.println("Table Prepared Statement not Created...");
		}
		try {
			statement=connection.prepareStatement(LMSQueryMapper.createSequence);
			statement.execute();
			System.out.println("Sequence Created...");
		} catch (SQLException e) {
			System.out.println("Sequence Prepared Statement not Created...");
		}
	}

	@Override
	public int insertBookRecord(Students bookDetails) throws LMSException {
		connection = JdbcUtility.getConnection();
		try {
			statement=connection.prepareStatement(LMSQueryMapper.insertQuery);
			statement.setString(1, bookDetails.getBookName());
			statement.setString(2, bookDetails.getAuthorName());
			statement.setDouble(3, bookDetails.getBookCost());
			result=statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Prepared Statement not Created");
		}
		return result;
	}

	@Override
	public int updateRecords(Students bookdetails) throws LMSException {		
		connection= JdbcUtility.getConnection();
		try {
			statement=connection.prepareStatement(LMSQueryMapper.updateQuery);
			statement.setDouble(1, bookdetails.getBookCost());
			statement.setInt(2, bookdetails.getId());
			result=statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Perpared Statement not Created");
		}
		return result;
	}


	

}
