package com.cg.mps.presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.mps.exception.MpsException;
import com.cg.mps.model.CustomerDetails;
import com.cg.mps.sevice.CustomerDetaisService;
import com.cg.mps.sevice.CustomerDetaisServiceImpl;

public class Main {
	
	
	
	public static void main(String[] args) throws MpsException {
		
		System.out.println("----****----****----****----Menu----****----****----****----");
		System.out.println("1. Purchase Mobile");
		System.out.println("2. View Entire Stock in Store");
		System.out.println("3. Delete Mobile Details based on MobileID from Mobile_Master");
		System.out.println("4. Search Mobile Phones Based on Price");
		System.out.println("----****----****----****----*******----****----****----****----");
		
		CustomerDetails customerDetails= new CustomerDetails();
		Scanner scanner = new Scanner(System.in);
		CustomerDetaisService customerDetailsService= new CustomerDetaisServiceImpl();
		
		int adminChoice=0;
		
		try {
			System.out.println("Enter your Choice: ");
			adminChoice=scanner.nextInt();
			
			switch (adminChoice) {
			case 1:
				System.out.println("Enter Customer Details");
				System.out.println("Name: ");
				scanner.nextLine();
				String CustomerName= scanner.nextLine();
				boolean nameflag=customerDetailsService.validateName(CustomerName);
				System.out.println("**************" + nameflag);
				if(nameflag){
					System.out.println("Enter E-mail: ");
					String eMailId= scanner.nextLine();
					boolean emailflag=customerDetailsService.validateEmail(eMailId);
					System.out.println("**************" + emailflag);
					if(emailflag){
						System.out.println("Enter Mobile No: ");
						String customerMobileNumber=scanner.nextLine();
						boolean Mobileflag=customerDetailsService.validateMobile(customerMobileNumber);
						System.out.println("**************" + Mobileflag);
						if(Mobileflag){
							System.out.println("Mobile ID: ");
							int mobileId= scanner.nextInt();				
							
							customerDetails.setCustomerMobileNumber(customerMobileNumber);
							customerDetails.setCustomerName(CustomerName);
							customerDetails.seteMailId(eMailId);
							customerDetails.setMobileId(mobileId);
							
							int insertedRecordsCount=customerDetailsService.purchaseMobile(customerDetails);
							System.out.println("in main back");
							System.out.println(insertedRecordsCount + " Records Inserted...");
						}else{
							System.out.println("Mobile Number should have 10 digits (0-9)");
						}
						
					}else{
						System.err.println("Not a valid email Address");
					}
					
				}else{
					System.err.println("First Letter Should be capital and rest in any format with no specail characters...");
				}
				
				break;

			default:
				break;
			}
			
		} catch (InputMismatchException e) {
			System.err.println("Invalid Choice");
			System.err.println("Please Enter your choice between 1 to 4 only...");
		}
		
		
		
		scanner.close();
		
	}
}
