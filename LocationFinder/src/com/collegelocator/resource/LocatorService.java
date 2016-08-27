package com.collegelocator.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.collegelocator.domain.CollegeLocatorDomainImpl;
import com.collegelocator.dto.RequestDTO;
import com.collegelocator.dto.ResponseDTO;



@Path("/CollegeLocator")
public class LocatorService {

	@POST
	@Path("/getColleges")
	@Produces("application/json;charset=UTF-8")
	public ResponseDTO getCollegeLocations(@FormParam("latitude") String latitude,
			@FormParam("longitude") String longitude,@FormParam("distance") String  distance,@FormParam("ranking") String ranking )
			 {
			ResponseDTO responseDTO=new ResponseDTO();
			RequestDTO requestDTO=new RequestDTO();
			requestDTO.setLatitude(latitude);
			requestDTO.setLongitude(longitude);
			requestDTO.setMaxDistance(distance);
			requestDTO.setIsRanking(ranking);
			try{
			CollegeLocatorDomainImpl domainImpl=new CollegeLocatorDomainImpl();
			responseDTO=domainImpl.getColleges(requestDTO);
			}
			catch (Exception e){
				responseDTO.setStatus("error");
			}
			
			/*try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
			
		return responseDTO;

	}

	
	
}