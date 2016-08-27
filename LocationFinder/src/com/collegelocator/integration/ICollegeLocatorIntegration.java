package com.collegelocator.integration;

import com.collegelocator.dto.RequestDTO;
import com.collegelocator.dto.ResponseDTO;
import com.mongodb.BasicDBList;

public interface ICollegeLocatorIntegration {

	public BasicDBList getColleges(RequestDTO requestDTO); 
	
}
