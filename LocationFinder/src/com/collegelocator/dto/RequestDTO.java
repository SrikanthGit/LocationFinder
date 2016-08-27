package com.collegelocator.dto;

public class RequestDTO {

	private String latitude;
	private String longitude;
	private String maxDistance;
	private String isRanking;
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the maxDistance
	 */
	public String getMaxDistance() {
		return maxDistance;
	}
	/**
	 * @param maxDistance the maxDistance to set
	 */
	public void setMaxDistance(String maxDistance) {
		this.maxDistance = maxDistance;
	}
	/**
	 * @return the isRanking
	 */
	public String getIsRanking() {
		return isRanking;
	}
	/**
	 * @param isRanking the isRanking to set
	 */
	public void setIsRanking(String isRanking) {
		this.isRanking = isRanking;
	}
	
	
}
