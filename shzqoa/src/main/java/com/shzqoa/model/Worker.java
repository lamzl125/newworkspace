package com.shzqoa.model;

import java.util.Date;


public class Worker {
	
	private String workerId;  //工人Id
	private String workerName;  //姓名
	private String workerPhone;  //电话
	private Integer age;  //年龄
	private String origin;  //籍贯
	private String idCard;//身份证号
	private String reMark; //备注  
	private String reMark1; //备注夜班要求
	private String reMark2; //备注
	private String reMark3; //备注
	private String addPeople;//添加人
	private Date addTime;//添加时间
	private Integer workerStatus;//工人状态（1-登记  2-面试不通过   3-面试通过  4-体检通过  5-体检不通过  6-入职 7-反费）
	
	private Date antiFeeTime;//反费时间
	private Double antiFeePay;//反费金额
	
	private Date registerTime;//登记时间
	private Integer workerSex;//性别（1-男  2-女   3-保密）
	private Integer physicalExamination;//是否体检（1-是   2-否）
	private Date estimateAntiFeeTime;//预计反费时间
	private Integer isSettlement;//是否结清（1-是   2-否）
	
	
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getWorkerName() {
		return workerName;
	}
	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}
	public String getWorkerPhone() {
		return workerPhone;
	}
	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public String getReMark1() {
		return reMark1;
	}
	public void setReMark1(String reMark1) {
		this.reMark1 = reMark1;
	}
	public String getReMark2() {
		return reMark2;
	}
	public void setReMark2(String reMark2) {
		this.reMark2 = reMark2;
	}
	public String getReMark3() {
		return reMark3;
	}
	public void setReMark3(String reMark3) {
		this.reMark3 = reMark3;
	}
	public String getAddPeople() {
		return addPeople;
	}
	public void setAddPeople(String addPeople) {
		this.addPeople = addPeople;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Integer getWorkerStatus() {
		return workerStatus;
	}
	public void setWorkerStatus(Integer workerStatus) {
		this.workerStatus = workerStatus;
	}
	public Date getAntiFeeTime() {
		return antiFeeTime;
	}
	public void setAntiFeeTime(Date antiFeeTime) {
		this.antiFeeTime = antiFeeTime;
	}
	public Double getAntiFeePay() {
		return antiFeePay;
	}
	public void setAntiFeePay(Double antiFeePay) {
		this.antiFeePay = antiFeePay;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Integer getWorkerSex() {
		return workerSex;
	}
	public void setWorkerSex(Integer workerSex) {
		this.workerSex = workerSex;
	}
	public Integer getPhysicalExamination() {
		return physicalExamination;
	}
	public void setPhysicalExamination(Integer physicalExamination) {
		this.physicalExamination = physicalExamination;
	}
	public Date getEstimateAntiFeeTime() {
		return estimateAntiFeeTime;
	}
	public void setEstimateAntiFeeTime(Date estimateAntiFeeTime) {
		this.estimateAntiFeeTime = estimateAntiFeeTime;
	}
	public Integer getIsSettlement() {
		return isSettlement;
	}
	public void setIsSettlement(Integer isSettlement) {
		this.isSettlement = isSettlement;
	}
	
}
