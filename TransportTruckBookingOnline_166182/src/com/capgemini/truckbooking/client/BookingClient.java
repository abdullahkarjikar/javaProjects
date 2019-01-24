package com.capgemini.truckbooking.client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.truckbooking.bean.BookingBean;
import com.capgemini.truckbooking.bean.TruckBean;
import com.capgemini.truckbooking.exception.BookingException;
import com.capgemini.truckbooking.sevice.ITruckService;
import com.capgemini.truckbooking.sevice.TruckService;


public class BookingClient {
	static Logger logger = Logger.getLogger(BookingClient.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		Scanner scanner= new Scanner(System.in);
		boolean choiceFlag=false;
		List<TruckBean> list= new ArrayList<TruckBean>();
		ITruckService service= new TruckService();
		int choice=0;
		BookingBean bookingBean= new BookingBean();
		boolean validateCustomerIdFlag=false;
		boolean validateFieldsFlag= false;
		String dateOfTransport="";
		String custId="";
		
		
		do {
			
			
			System.out.println("Menu");
			System.out.println("1. Book Trucks");
			System.out.println("2. Exit");
			System.out.println("Enter Your Choice: ");
			try {
				
				choice=scanner.nextInt();
				choiceFlag=true;
				
				switch (choice) {
				case 1:
					scanner.nextLine();
					do {
						System.out.println("Enter Customer Id");
						custId= scanner.nextLine();
						validateCustomerIdFlag=service.validateCustomerId(custId);
						if(!validateCustomerIdFlag){
							System.err.println("Customer Id should Start with Capital Alphabet Followed by 6 Digits");
						}
					} while (!validateCustomerIdFlag);
					bookingBean.setCustId(custId);
					
					try {
						list= service.retrieveTruckDetails();
						if(list.size()>0){	
							System.out.println("TruckId    TruckType    Origin    Destination   Charge    Available Nos");
							for (TruckBean truckBean : list) {
								System.out.println(truckBean.getTruckID()+"   "+truckBean.getTruckType()+"   "+truckBean.getOrigin()+"   "+truckBean.getDestination()+"   "+truckBean.getCharges()+"   "+truckBean.getAvailablenos());
							}
							
							do{
							System.out.println("Please Enter the truckId: ");
							int truckId=scanner.nextInt();
							System.out.println("Enter Number of Trucks: ");
							int noOfTrucks=scanner.nextInt();
							System.out.println("Enter Customer Mobile: ");
							long custMobile=scanner.nextLong();
							System.out.println("Enter Date of transportation(Format YYYY-MM-DD): ");
							scanner.nextLine();
							dateOfTransport=scanner.nextLine();
							
							bookingBean.setTruckId(truckId);
							bookingBean.setNoOfTrucks(noOfTrucks);
							bookingBean.setCustMobile(custMobile);
							
							
							validateFieldsFlag=service.validateFields(bookingBean,dateOfTransport );
								
								
							}while(!validateFieldsFlag);
							DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
							LocalDate localDate =LocalDate.parse(dateOfTransport, dateTimeFormatter);
							bookingBean.setDatgeOfTransport(localDate);
							int bookingId=service.bookTrucks(bookingBean);
							System.out.println("Thank you. Your booking Id is "+bookingId);
							
							
							System.out.println("Enter Customer Id: ");
							
						}else{
							System.out.println("Sorry No Truck Available");
						}
						
					} catch (BookingException e) {
						System.err.println("Error Please try Again.");
					}
					
					choiceFlag=true;
					break;
				case 2:
					
					return;
				default:
					System.err.println("Invalid Choice. Please Try Again");
					choiceFlag=false;
					break;
				}
				
				
				
			} catch (InputMismatchException e) {
				System.out.println("Only Digits Allowed. Please Try Again");
				choiceFlag=false;
			}
			
			
		} while (!choiceFlag);
		scanner.close();
	}
}
