package com.cg.hms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.hms.dao.HMSDao;
import com.cg.hms.dao.HMSDaoImpl;
import com.cg.hms.exception.HMSExceptions;
import com.cg.hms.model.Patient;

public class HMSServiceImpl implements HMSService {
	
	
	HMSDao hmsDao =new HMSDaoImpl();
	
	List<String> list= new ArrayList<String>();
	
	/**
	 * 		Method 		: Add patient details
	 * 		Arguments	: Its taking model object as an argument
	 * 		return type	: This method returns the generated id to the user
	 * 		Author		: Capgemini
	 * 		Date		: 14-January-2019
	 *
	 * 
	 * */
	
	@Override
	public boolean validateFeilds(Patient patient) {
		boolean flag=true;
		if(!checkName(patient.getName())){
			list.add("Name must Start with capital and should have minimum 5 characters");
		}
		if(!checkGender(patient.getGender())){
			list.add("Gender should be between 4 to 6 characters");
		}
		if(!checkPhoneNumber(patient.getPhoneNumber())){
			list.add("Phone Number should be 10 digits");
		}
		if(!checkProblem(patient.getDisease())){
			list.add("Problem must be between 4 to 10 characeter");
		}
		if(list.size()>0){
			flag=false;
			System.err.println(list);
			
		}
		
		return flag;
		
	}

	@Override
	public boolean checkName(String name) {
		String nameRegEx="[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegEx, name);
	}
	
	@Override
	public boolean checkGender(String gender) {
		String genderRegEx="male|female|Male|Female|MALE|FEMALE";
		return Pattern.matches(genderRegEx, gender);
	}

	@Override
	public boolean checkPhoneNumber(Long phoneNumber) {
		String phoneNumberRegEx="[6|7|8|9]{1}[0-9]{9}$";
		return Pattern.matches(phoneNumberRegEx, Long.toString(phoneNumber));
	}

	@Override
	public boolean checkProblem(String problem) {
		String problemRegEx="[A-Za-z]{4,10}$";
		return Pattern.matches(problemRegEx, problem);
	}

	@Override
	public int addPatientDetails(Patient patient) throws HMSExceptions{
		
		return hmsDao.addPatientDetails(patient);
	}
	
}
