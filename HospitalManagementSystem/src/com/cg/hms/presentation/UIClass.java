package com.cg.hms.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hms.exception.HMSExceptions;
import com.cg.hms.model.Patient;
import com.cg.hms.service.HMSService;
import com.cg.hms.service.HMSServiceImpl;

public class UIClass {

	static Logger logger = Logger.getLogger(UIClass.class);

	public static void main(String[] args) {

		boolean flag = false;
		int choice = 0;

		PropertyConfigurator.configure("resources/log4j.properties");

		Scanner scanner = null;
		HMSService hmsService = null;
		Patient patient=null;
		do {
			scanner=new Scanner(System.in);
			System.out
					.println("----$$$$----Hospital Management System----$$$$----");
			System.out.println("1. Book Appointment");
			System.out.println("2. Get Appointment Details");
			System.out.println("3. View All Booked Appointments");
			System.out.println("4. Exit");

			System.out.println("Enter your choice: ");
			try {
				choice = scanner.nextInt();
				flag = true;

				switch (choice) {
				case 1:
					System.out.println("Enter Patient Details");
					System.out.println("Enter Name: ");
					scanner.nextLine();
					String patientName = scanner.nextLine();
					System.out.println("Enter Gender: ");
					String gender = scanner.nextLine();
					System.out.println("Enter Phone Number:");
					Long phoneNumber = scanner.nextLong();
					System.out.println("Your Problem: ");
					scanner.nextLine();
					String problem= scanner.nextLine();
					
					patient=new Patient();
					
					patient.setName(patientName);
					patient.setDisease(problem);
					patient.setPhoneNumber(phoneNumber);
					patient.setGender(gender);
					
					hmsService=new HMSServiceImpl();
					try {
						boolean validate=hmsService.validateFeilds(patient);
						if(validate){
							int id=hmsService.addPatientDetails(patient);
							System.out.println("Appointment Confirmed with Id = "+id);
						}
						
						
					} catch (HMSExceptions e) {
						System.err.println(e.getMessage());
					}
					
					
					
					

					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;

				default:
					flag = false;
					System.err
							.println("Invalid Choice...\nEnter Digits(1 to 4)");
					break;
				}

			} catch (InputMismatchException e) {
				System.err.println("Enter only Digits(1 to 4)");
				flag=false;
			}

		} while (!flag);

		scanner.close();

	}
}
