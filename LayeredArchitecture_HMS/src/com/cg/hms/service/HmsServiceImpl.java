package com.cg.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.hms.dao.HmsDAO;
import com.cg.hms.dao.HmsDAOIpml;
import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;

public class HmsServiceImpl implements HmsService {

	List<String> list = new ArrayList<>();
	HmsDAO hmsDao = new HmsDAOIpml();

	@Override
	public boolean validateFields(Patient patient) throws HMSException {

		boolean validateFlag = false;

		if (!checkName(patient.getName())) {
			list.add("Name msut start with Capital letter and the length should be in between 5 to 20 \n");
		}

		if (!checkGender(patient.getGender())) {
			list.add("gender length should be in between 4 to 6 \n");
		}

		if (!checkPhonenumber(patient.getPhoneNumber())) {
			list.add("phone number should contain exactly 10 digits and must start with 6 | 7 | 8 | 9");
		}

		if (!list.isEmpty()) {
			throw new HMSException(list + "");
		} else {
			validateFlag = true;
		}
		return validateFlag;
	}

	public boolean checkName(String name) {
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegEx, name);
	}

	public boolean checkGender(String gender) {
		String genderRegEx = "male|female";
		return Pattern.matches(genderRegEx, gender);
	}

	public boolean checkPhonenumber(Long phoneNumber) {
		String phoneRegEx = "[6|7|8|9]{1}[0-9]{9}";
		return Pattern.matches(phoneRegEx, String.valueOf(phoneNumber));
	}

	/**
	 * 			method	  :  addpatientDetails
	 *			argument   :  it's taking model object as an argument
	 *			return type :  this method returns the generated id to the user
	 *			Author		   :  Capgemini
	 *			Date			   :  14-Jan-2019
	 * 
	 * */
	@Override
	public int addPatientDetails(Patient patient) throws HMSException {
		return hmsDao.addPatientDetails(patient);
	}
}
