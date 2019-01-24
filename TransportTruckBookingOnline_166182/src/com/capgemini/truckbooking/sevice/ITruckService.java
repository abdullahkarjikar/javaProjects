package com.capgemini.truckbooking.sevice;

import java.util.List;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;

public interface ITruckService {

	List<TruckBean> retrieveTruckDetails() throws BookingException;

	boolean validateCustomerId(String custId);

	boolean validateFields(BookingBean bookingBean, String dateOfTransport);

	int bookTrucks(BookingBean bookingBean) throws BookingException;

}
