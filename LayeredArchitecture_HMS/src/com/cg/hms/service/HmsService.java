package com.cg.hms.service;

import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;

public interface HmsService {

	boolean validateFields(Patient patient) throws HMSException;

	int addPatientDetails(Patient patient) throws HMSException;

}
