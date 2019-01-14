package com.cg.hms.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.hms.exceptions.HMSException;
import com.cg.hms.model.Patient;
import com.cg.hms.service.HmsService;
import com.cg.hms.service.HmsServiceImpl;

import oracle.net.aso.p;

public class UIClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		PropertyConfigurator.configure("resources/log4j.properties");

		Scanner scanner = null;
		int choice = 0;
		boolean choiceFlag = false;

		HmsService service = null;

		do {

			scanner = new Scanner(System.in);
			System.out.println("******* Hospital Management System *********");
			System.out.println("1.Book Appointement");
			System.out.println("2.Get Appointement Details");
			System.out.println("3.View All booked Appointements");
			System.out.println("4.Exit");

			System.out.println("Enter your choice");

			try {
				choice = scanner.nextInt();
				choiceFlag = true;

				switch (choice) {
				case 1:

					scanner.nextLine();
					System.out.println("Enter Name:");
					String name = scanner.nextLine();
					System.out.println("Enter Gender");
					String gender = scanner.nextLine();
					System.out.println("Enter Phone Number");
					long PhoneNo = scanner.nextLong();
					scanner.nextLine();
					System.out.println("Enter Problem:");
					String problem = scanner.nextLine();

					Patient patient = new Patient();
					patient.setGender(gender);
					patient.setName(name);
					patient.setPhoneNumber(PhoneNo);
					patient.setProblem(problem);

					service = new HmsServiceImpl();
					try {
						boolean validateFlag = service.validateFields(patient);
						if (validateFlag) {
							int id = service.addPatientDetails(patient);
							System.out.println("ur appointment fixed with the given id: " + id);
						}

					} catch (HMSException e) {
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
					choiceFlag = false;
					System.out.println("input should be in the range of (1-4)");
					System.out.println("Enter ur input again");
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("input should contain only digits");
				System.out.println("Enter ur input again");
			}
		} while (!choiceFlag);
	}
}
