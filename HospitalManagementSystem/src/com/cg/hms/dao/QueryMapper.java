package com.cg.hms.dao;

public interface QueryMapper {

	public static final String insertPatientDetails = "INSERT INTO PATIENT_DETAILS VALUES(patient_sequence_id.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
	String getpatientId="SELECT patient_sequence_id.currval from dual";

}
