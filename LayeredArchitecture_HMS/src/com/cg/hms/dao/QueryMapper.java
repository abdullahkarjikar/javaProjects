package com.cg.hms.dao;

public interface QueryMapper {

	public static final String insertPatientDetails = "INSERT INTO patients_master VALUES(hms_sequence.nextval,?,?,?,sysdate,?)";

	public static final String getpatientId = "SELECT hms_sequence.CURRVAL FROM dual";

}
