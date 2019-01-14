package com.cg.hms.dao;

import com.cg.hms.exception.HMSExceptions;
import com.cg.hms.model.Patient;

public interface HMSDao {

	int addPatientDetails(Patient patient) throws HMSExceptions;

}
