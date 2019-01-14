package com.cg.mps.dao;

public interface QueryMapper {
	public static final String getMobileIdQuery=
			"SELECT MobileId FROM Mobiles WHERE MobileId=?";
	public static final String insertNewPurchaseDetails = 
			"INSERT INTO PurchaseDetails VALUES(Generate_Purchase_Id.NEXTVAL, ?, ?, ?, SYSDATE, ?)";
	public static final String updateMobileQuantity = 
			"UPDATE Mobiles SET Quantity=(SELECT quantity FROM Mobiles where MobileId=?)-1 WHERE MobileId=?";
}


