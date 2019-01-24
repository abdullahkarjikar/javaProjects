package com.capgemini.truckbooking.dao.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.dao.ITruckDao;
import com.capgemini.truckbooking.dao.TruckDao;
import com.capgemini.truckbooking.exception.BookingException;

public class TruckDaoTest {
	ResultSet resultset = null;
	ITruckDao dao=null;
	@Before
	public void setUp() throws Exception {
		dao =new TruckDao();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
	}

	@Test
	public final void testRetrieveTruckDetails() {
		List<TruckBean> list= new ArrayList<TruckBean>();
		int output=0;
		try {
			list=
					dao.retrieveTruckDetails();
		} catch (BookingException e) {
			System.err.println("Error");
		}if(list.size()>0){
			output=1;
		}
		assertEquals(1, output);
		
	}


	@Test
	public final void testBookTrucks() {
		int id=0;
		int output=0;
		BookingBean bookingBean =new BookingBean();
		bookingBean.setCustId("A111111");
		bookingBean.setCustMobile(9764133903l);
		
		
		bookingBean.setTruckId(1001);
		try {
			id=dao.bookTrucks(bookingBean);
		} catch (BookingException e) {
			
		}
		if(id>=0){
			output=1;
		}
		assertEquals(1, output);
	}

}
