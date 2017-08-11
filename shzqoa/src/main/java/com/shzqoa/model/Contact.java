package com.shzqoa.model;


public class Contact {
	private Integer contactId;  //联系方式Id	
	private String direction;//院系/培训内容
	private String contactTel;//联系电话
	private String contactName;  //联系人		
	private Integer schoolId;  //学校Id
	private Byte contactSex;  //性别（1-男   2-女）
	private Byte isEngross;//是否独占(0-否  1-是)
	private String officeTel;
	private String qq;
	private String jobName;
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Byte getContactSex() {
		return contactSex;
	}
	public void setContactSex(Byte contactSex) {
		this.contactSex = contactSex;
	}
	public Byte getIsEngross() {
		return isEngross;
	}
	public void setIsEngross(Byte isEngross) {
		this.isEngross = isEngross;
	}
	public String getOfficeTel() {
		return officeTel;
	}
	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
}
