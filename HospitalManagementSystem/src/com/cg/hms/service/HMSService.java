package com.cg.hms.service;

import com.cg.hms.exception.HMSExceptions;
import com.cg.hms.model.Patient;

public interface HMSService {

	boolean validateFeilds(Patient patient) throws HMSExceptions;
	
	boolean checkName(String name);
	boolean checkGender(String gender);
	boolean checkPhoneNumber(Long phoneNumber);
	boolean checkProblem(String problem);

	int addPatientDetails(Patient patient) throws HMSExceptions;

}
