package com.collegelocator.integration;

import java.util.Iterator;

import com.collegelocator.dto.College;
import com.collegelocator.dto.RequestDTO;
import com.collegelocator.dto.ResponseDTO;
import com.collegelocator.utils.DBUtils;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;

public class CollegeLocatorIntegrationImpl implements ICollegeLocatorIntegration{

	public BasicDBList getColleges(RequestDTO requestDTO){
		ResponseDTO responseDTO = null;
		
		CommandResult commandResult=DBUtils.getGeospatialResult(requestDTO.getLatitude(), requestDTO.getLongitude(),requestDTO.getMaxDistance());
		
		BasicDBList results = (BasicDBList)commandResult.get("results");
		
		return results;
	}
}
