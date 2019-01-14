package com.cg.hms.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.hms.dao.HmsDAO;
import com.cg.hms.dao.HmsDAOIpml;
import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;

import oracle.net.aso.p;

public class HmsDAOIpmlTest {

	HmsDAO dao = null;

	@Before
	public void setUp() throws Exception {
		dao = new HmsDAOIpml();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}
	
	@Test
	public void testAddPatientDetailsIsNull() {

		Patient patient = new Patient();
		patient.setName("Steve");
		patient.setGender("male");
		patient.setPhoneNumber(9346765152l);
		patient.setProblem("fever");

		try {
			int id = dao.addPatientDetails(patient);
			assertNull(id);
		} catch (HMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddPatientDetailsIsNotNull() {

		Patient patient = new Patient();
		patient.setName("Steve");
		patient.setGender("male");
		patient.setPhoneNumber(9346765152l);
		patient.setProblem("fever");

		try {
			int id = dao.addPatientDetails(patient);
			assertNotNull(id);
		} catch (HMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddPatientDetails() {

		Patient patient = new Patient();
		patient.setName("Steve");
		patient.setGender("male");
		patient.setPhoneNumber(9346765152l);
		patient.setProblem("fever");

		try {
			int id = dao.addPatientDetails(patient);
			assertEquals(102, id);
		} catch (HMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
