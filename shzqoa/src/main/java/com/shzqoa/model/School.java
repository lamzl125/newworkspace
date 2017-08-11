package com.shzqoa.model;


public class School {
	
	private Integer schoolId;  //学校Id
	private Byte schoolType;  //学校类型（1-培训学校    2-学校）
	private String schoolName;//学校名称
	private String schoolAddr;//学校地址
	private String schoolURL;  // 学校网址
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Byte getSchoolType() {
		return schoolType;
	}
	public void setSchoolType(Byte schoolType) {
		this.schoolType = schoolType;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public String getSchoolURL() {
		return schoolURL;
	}
	public void setSchoolURL(String schoolURL) {
		this.schoolURL = schoolURL;
	}
	
	
	
	
}
