package com.collegelocator.dto;

import java.util.ArrayList;

public class ResponseDTO {

	private ArrayList<College>  collegeLocResult;
	private String status;
	/**
	 * @return the collegeLocResult
	 */
	public ArrayList<College> getCollegeLocResult() {
		return collegeLocResult;
	}
	/**
	 * @param collegeLocResult the collegeLocResult to set
	 */
	public void setCollegeLocResult(ArrayList<College> collegeLocResult) {
		this.collegeLocResult = collegeLocResult;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
