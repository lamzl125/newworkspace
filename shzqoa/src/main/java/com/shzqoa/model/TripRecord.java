package com.shzqoa.model;

import java.util.Date;


public class TripRecord {
	
	private String tripRecordId;  //行程记录Id
	private String tripWho;  //谁
	private String tripWhoName;//姓名
	private Date tripTime;//行程记录时间
	private String trainSchoolId;//培训学校Id
	private String tripAddr;  // 行程地址
	private String reMark;  //备注
	
	
	
	
	public String getTripRecordId() {
		return tripRecordId;
	}
	public void setTripRecordId(String tripRecordId) {
		this.tripRecordId = tripRecordId;
	}
	public String getTripWho() {
		return tripWho;
	}
	public void setTripWho(String tripWho) {
		this.tripWho = tripWho;
	}
	public String getTripWhoName() {
		return tripWhoName;
	}
	public void setTripWhoName(String tripWhoName) {
		this.tripWhoName = tripWhoName;
	}
	public Date getTripTime() {
		return tripTime;
	}
	public void setTripTime(Date tripTime) {
		this.tripTime = tripTime;
	}
	public String getTrainSchoolId() {
		return trainSchoolId;
	}
	public void setTrainSchoolId(String trainSchoolId) {
		this.trainSchoolId = trainSchoolId;
	}
	public String getTripAddr() {
		return tripAddr;
	}
	public void setTripAddr(String tripAddr) {
		this.tripAddr = tripAddr;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
		
}
