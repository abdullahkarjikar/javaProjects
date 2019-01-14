package com.cg.lms.service;

import com.cg.lms.exception.LMSException;
import com.cg.lms.model.Students;

public interface StudentValidate {

	boolean validate(Students student) throws LMSException;

}
