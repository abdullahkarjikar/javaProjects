package com.cg.mps.sevice;

import java.util.regex.Pattern;

import com.cg.mps.dao.CustomerDao;
import com.cg.mps.dao.CustomerDaoImpl;
import com.cg.mps.exception.MpsException;
import com.cg.mps.model.CustomerDetails;

public class CustomerDetaisServiceImpl implements CustomerDetaisService {
	CustomerDetails customerDetails= new CustomerDetails();
	
	CustomerDao customerDao= new CustomerDaoImpl();
	
	@Override
	public int purchaseMobile(CustomerDetails customerDetails) throws MpsException {
		int insertedRecords=0;
		
		boolean mobileId=customerDao.getMobileId(customerDetails.getMobileId());
			insertedRecords=customerDao.insertNewPurchaseDetails(customerDetails);
			customerDao.reduceMobileQuantity(customerDetails.getMobileId());
			
		
		return insertedRecords;
	}

	@Override
	public boolean validateName(String customerName) {
		String customerNameRegEx="[A-Z]{1}[a-zA-Z\\s]{1,19}$";
		boolean nameflag=false;
		nameflag=Pattern.matches(customerNameRegEx, customerName);
		return nameflag;
	}

	@Override
	public boolean validateEmail(String eMailId) {
		//String[] splittedString=eMailId.split(".");
		//int count=splittedString.length;
		//count=count-1;
		//String check=splittedString[count];
		String eMailIdRegEx="[A-Za-z.]*@[A-za-z]*\\.[A-za-z]*";
		boolean eMailIdflag=false;
		eMailIdflag=Pattern.matches(eMailIdRegEx, eMailId);
		
		
		return eMailIdflag;
	}

	@Override
	public boolean validateMobile(String customerMobileNumber) {
		String mobileNumberRegEx="[0-9]{10}$";
		boolean mobileNumber=false;
		mobileNumber=Pattern.matches(mobileNumberRegEx, customerMobileNumber);
		return mobileNumber;
	}
}
