package com.capgemini.truckbooking.dao;

public interface QueryMapper {

	String retrieveTruckDetailsQuery = "SELECT * FROM TruckDetails";
	String getTruckId = "SELECT * FROM TruckDetails WHERE TRUCKID=?";
	String bookTrucksQuery = "INSERT INTO bookingDetails values(booking_id_seq.nextval,?,?,?,?,?)";
	String getBookingId = "select bookingId from bookingDetails where custId=?";

}
