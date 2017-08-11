package com.shzqoa.model;

import java.util.Date;


public class QuestionFollow {
	private String questionFollowId;//问题跟踪情况Id
	private String questionId;//问题Id
	private Integer questionStatus;//问题状态（1-未处理  2-处理中  3-已解决）
	private String questionFollowContent;//问题跟踪情况说明
	private String reMark;//备注
	private String followPeople;//跟踪人
	private Date  followTime;//跟踪时间
	
	public String getQuestionFollowId() {
		return questionFollowId;
	}
	public void setQuestionFollowId(String questionFollowId) {
		this.questionFollowId = questionFollowId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public Integer getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(Integer questionStatus) {
		this.questionStatus = questionStatus;
	}
	public String getQuestionFollowContent() {
		return questionFollowContent;
	}
	public void setQuestionFollowContent(String questionFollowContent) {
		this.questionFollowContent = questionFollowContent;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public String getFollowPeople() {
		return followPeople;
	}
	public void setFollowPeople(String followPeople) {
		this.followPeople = followPeople;
	}
	public Date getFollowTime() {
		return followTime;
	}
	public void setFollowTime(Date followTime) {
		this.followTime = followTime;
	}
	
	
}
