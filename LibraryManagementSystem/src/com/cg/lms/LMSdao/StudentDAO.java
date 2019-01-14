package com.cg.lms.LMSdao;

import com.cg.lms.exception.LMSException;
import com.cg.lms.model.Students;

public interface StudentDAO {

	int insertBookRecord(Students employee) throws LMSException;

	void createTable() throws LMSException;

	int updateRecords(Students bookdetails) throws LMSException;

}
