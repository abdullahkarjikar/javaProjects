package com.capgemini.truckbooking.sevice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.dao.ITruckDao;
import com.capgemini.truckbooking.dao.TruckDao;
import com.capgemini.truckbooking.exception.BookingException;

public class TruckService implements ITruckService {
	ITruckDao dao= new TruckDao();
	List<String> validationList= null;
	List<TruckBean> truckBeanList= new ArrayList<TruckBean>();
	

	@Override
	public List<TruckBean> retrieveTruckDetails() throws BookingException {
		return dao.retrieveTruckDetails();
	}


	@Override
	public boolean validateCustomerId(String custId) {
		String custIdRegEx="[A-Z]{1}[0-9]{6}";	
		boolean validateCustomerIdFlag=Pattern.matches(custIdRegEx, custId);
		return validateCustomerIdFlag;
	}


	@Override
	public boolean validateFields(BookingBean bookingBean,
			String dateOfTransport) {
		boolean validationFlag=true;
		validationList= new ArrayList<String>();
		int truckid=0;
		int availabeNos=0;
		try {
			truckBeanList=dao.validateTruckId(bookingBean.getTruckId());
			for (TruckBean truckBean : truckBeanList) {
				truckid=truckBean.getTruckID();
				availabeNos=truckBean.getAvailablenos();
			}
		} catch (BookingException e) {
			System.err.println("big error");
		}
		if(truckid!=bookingBean.getTruckId()){
			validationList.add("Invalid truck id");
		}
		if(availabeNos<0){
			validationList.add("No Truck available");
		}
		if(!validateMobileNumber(bookingBean.getCustMobile())){
			validationList.add("Invalid Mobile Number");
		}
		try {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			@SuppressWarnings("unused")
			LocalDate localDate =LocalDate.parse(dateOfTransport, dateTimeFormatter);
		} catch (Exception e) {
			validationList.add("Invalid Date Format");
		}
		if(validationList.size()>0){
			System.err.println(validationList);
			validationFlag=false;
		}

		return validationFlag;
	}
	
	
	public boolean validateMobileNumber(long mobileNumber){
		String custIdRegEx="[0-9]{10}";	
		boolean validateMobileNumberFlag=Pattern.matches(custIdRegEx, Long.toString(mobileNumber));
		return validateMobileNumberFlag;
		
	}


	@Override
	public int bookTrucks(BookingBean bookingBean) throws BookingException {
		return dao.bookTrucks(bookingBean);
	}

}
