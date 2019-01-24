package com.capgemini.truckbooking.dao;

import java.util.List;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;

public interface ITruckDao {

	List<TruckBean> retrieveTruckDetails() throws BookingException;

	List<TruckBean> validateTruckId(int truckId) throws BookingException;

	int bookTrucks(BookingBean bookingBean) throws BookingException;

}
