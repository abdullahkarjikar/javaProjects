package com.cg.mps.sevice;

import com.cg.mps.exception.MpsException;
import com.cg.mps.model.CustomerDetails;

public interface CustomerDetaisService {

	int purchaseMobile(CustomerDetails customerDetails)throws MpsException;

	boolean validateName(String customerName);

	boolean validateEmail(String eMailId);

	boolean validateMobile(String customerMobileNumber);

}
