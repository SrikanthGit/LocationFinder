package com.collegelocator.domain;

import com.collegelocator.dto.RequestDTO;
import com.collegelocator.dto.ResponseDTO;

public interface ICollegeLocatorDomain {

	public ResponseDTO getColleges(RequestDTO requestDTO); 
}
