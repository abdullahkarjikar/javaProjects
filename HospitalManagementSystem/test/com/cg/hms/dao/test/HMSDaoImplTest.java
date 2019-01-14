package com.cg.hms.dao.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.hms.model.Patient;

public class HMSDaoImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddPatientDetails() {
		Patient patient= new Patient();
		patient.setName("Steve");
		patient.setDisease("FeverProblem");
		patient.setGender("Male");
		patient.setPhoneNumber(9764133903l);
		
		
		
	}

}
