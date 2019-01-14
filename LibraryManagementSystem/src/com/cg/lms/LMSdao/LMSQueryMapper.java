package com.cg.lms.LMSdao;

public interface LMSQueryMapper {
	public static final String createQuery = 
			"CREATE TABLE Library_Management_System (Id NUMBER PRIMARY KEY, Name VARCHAR2(20), Author VARCHAR2(20), Cost DECIMAL(8,4))";
	public static final String insertQuery = 
			"INSERT INTO Library_Management_System VALUES(Generate_Book_Id.NEXTVAL,?,?,?)";
	public static final String createSequence = 
			"CREATE SEQUENCE Generate_Book_Id START WITH 101";
	public static final String updateQuery = 
			"UPDATE Library_Management_System SET Cost=? WHERE Id=?";

}
