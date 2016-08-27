package com.collegelocator.domain;

import java.util.ArrayList;

import com.collegelocator.dto.Address;
import com.collegelocator.dto.College;
import com.collegelocator.dto.Contact;
import com.collegelocator.dto.RequestDTO;
import com.collegelocator.dto.ResponseDTO;
import com.collegelocator.integration.CollegeLocatorIntegrationImpl;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

public class CollegeLocatorDomainImpl implements ICollegeLocatorDomain{

	public ResponseDTO getColleges(RequestDTO requestDTO){
		ResponseDTO responseDTO = new ResponseDTO();
		ArrayList<College> collegeLocResult=new ArrayList<College>();
		
		CollegeLocatorIntegrationImpl integration=new CollegeLocatorIntegrationImpl();
		
		BasicDBList results=integration.getColleges(requestDTO);
		
		for( Object result : results )
		{	College college=new College();
		    
		    college.setDistance(((BasicDBObject) result).getString("dis"));
		    
		    BasicDBObject dbo = (BasicDBObject) ((BasicDBObject) result).get("obj");
		    college.setName(dbo.getString("NAME"));
		    college.setRanking(dbo.getString("Ranking"));
		    college.setCode(dbo.getString("CODE"));
		    college.setWebsite(dbo.getString("WEBSITE"));
		    college.setSpecialNote(dbo.getString("SPECIALNOTE"));
		    college.setDetails(dbo.getString("DETAILS"));
		    
		    Address addressMap=new Address();
		    addressMap.setCity(dbo.getString("CITY"));
		    addressMap.setCountry(dbo.getString("COUNTRY"));
		    addressMap.setState(dbo.getString("STATE"));
		    addressMap.setLine1(dbo.getString("LINE1"));
		    addressMap.setLine2(dbo.getString("LINE2"));
		    addressMap.setZip(dbo.getString("ZIPCODE"));
		    
		    college.setAddressMap(addressMap);
		    String address="";
		    address+=dbo.getString("LINE1")!=null?dbo.getString("LINE1")+" ":"";
		    address+=dbo.getString("LINE2")!=null?dbo.getString("LINE2")+" ":"";
		    address+=dbo.getString("CITY")!=null?dbo.getString("CITY")+" ":"";
		    address+=dbo.getString("STATE")!=null?dbo.getString("STATE")+" ":"";
		    address+=dbo.getString("COUNTRY")!=null?dbo.getString("COUNTRY")+" ":"";
		    address+=dbo.getString("ZIPCODE")!=null?dbo.getString("ZIPCODE"):"";
		    college.setAddress(address);
		    
		    Contact contactDetails=new Contact();
		    
		    contactDetails.setEmail(dbo.getString("EMAIL"));
		    contactDetails.setPhone(dbo.getString("PHONE"));
		    contactDetails.setFax(dbo.getString("FAX"));
		    
		    college.setContactDetails(contactDetails);
		    
		    BasicDBObject dbObject=(BasicDBObject) dbo.get("LOCATION");
		    ArrayList coordinate=(ArrayList) dbObject.get("coordinates");
		    String latitude=(String)coordinate.get(0).toString();
		    String longitude=(String)coordinate.get(1).toString();
		    
		    college.setLatitude(latitude);
		    college.setLongitude(longitude);
		    
		    collegeLocResult.add(college);
		}
		
		if(collegeLocResult!=null && collegeLocResult.size()>0){
		responseDTO.setCollegeLocResult(collegeLocResult);
		responseDTO.setStatus("success");
		}
		else{
			responseDTO.setStatus("error");
		}
		return responseDTO;
	}
}
