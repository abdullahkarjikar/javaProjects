package com.cg.mps.dao;

import com.cg.mps.exception.MpsException;
import com.cg.mps.model.CustomerDetails;

public interface CustomerDao {

	boolean getMobileId(int mobileId)throws MpsException;

	int insertNewPurchaseDetails(CustomerDetails customerDetails) throws MpsException;

	void reduceMobileQuantity(int mobileId);

}
