package com.shzqoa.model;

import java.util.Date;

public class Question {
	private String questionId;//问题Id
	private String questionContent;//问题描述
	private String personLiable;//责任人
	private String urgencyLevel;//紧急程度
	private Date estimatedSettlingTime;//预计解决时间
	private Date actualSettlementTime;//实际解决时间
	private Integer questionStatus;//问题状态（1-未处理  2-处理中  3-已解决）
	private String reMark;//备注
	private String addPeople;//问题添加人
	private Date addTime;//问题添加时间
	private String problemMaker;//问题提出人
	private Date reflectProblemTime;//反映问题时间
	
	
	
	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	public String getUrgencyLevel() {
		return urgencyLevel;
	}
	public void setUrgencyLevel(String urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	public Date getEstimatedSettlingTime() {
		return estimatedSettlingTime;
	}
	public void setEstimatedSettlingTime(Date estimatedSettlingTime) {
		this.estimatedSettlingTime = estimatedSettlingTime;
	}
	public Date getActualSettlementTime() {
		return actualSettlementTime;
	}
	public void setActualSettlementTime(Date actualSettlementTime) {
		this.actualSettlementTime = actualSettlementTime;
	}
	public Integer getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(Integer questionStatus) {
		this.questionStatus = questionStatus;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
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
	public String getProblemMaker() {
		return problemMaker;
	}
	public void setProblemMaker(String problemMaker) {
		this.problemMaker = problemMaker;
	}
	public Date getReflectProblemTime() {
		return reflectProblemTime;
	}
	public void setReflectProblemTime(Date reflectProblemTime) {
		this.reflectProblemTime = reflectProblemTime;
	}
	
	
	
}
