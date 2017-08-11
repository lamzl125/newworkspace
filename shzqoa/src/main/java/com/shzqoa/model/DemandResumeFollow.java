package com.shzqoa.model;

import java.util.Date;

public class DemandResumeFollow {
	private String id;
	private String demandResumeId;
	private String trackingPeople;
    private Date trackingTime;
    private Integer sendResumeStatus;
    private Integer screeningResumesStatus;
    private Integer noticeInterviewStatus;
    private Integer interviewResultStatus;
    private String  PicUrl;
    private String  remark;
    private Integer retestStatus;
    private Integer arrangeEntryStatus;
    private Integer retestResultStatus;    
    private Date interviewTime;
    private Date joinProjectTime;
    
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDemandResumeId() {
		return demandResumeId;
	}
	public void setDemandResumeId(String demandResumeId) {
		this.demandResumeId = demandResumeId;
	}
	public String getTrackingPeople() {
		return trackingPeople;
	}
	public void setTrackingPeople(String trackingPeople) {
		this.trackingPeople = trackingPeople;
	}
	public Date getTrackingTime() {
		return trackingTime;
	}
	public void setTrackingTime(Date trackingTime) {
		this.trackingTime = trackingTime;
	}
	public Integer getSendResumeStatus() {
		return sendResumeStatus;
	}
	public void setSendResumeStatus(Integer sendResumeStatus) {
		this.sendResumeStatus = sendResumeStatus;
	}
	public Integer getScreeningResumesStatus() {
		return screeningResumesStatus;
	}
	public void setScreeningResumesStatus(Integer screeningResumesStatus) {
		this.screeningResumesStatus = screeningResumesStatus;
	}
	public Integer getNoticeInterviewStatus() {
		return noticeInterviewStatus;
	}
	public void setNoticeInterviewStatus(Integer noticeInterviewStatus) {
		this.noticeInterviewStatus = noticeInterviewStatus;
	}
	public Integer getInterviewResultStatus() {
		return interviewResultStatus;
	}
	public void setInterviewResultStatus(Integer interviewResultStatus) {
		this.interviewResultStatus = interviewResultStatus;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRetestStatus() {
		return retestStatus;
	}
	public void setRetestStatus(Integer retestStatus) {
		this.retestStatus = retestStatus;
	}
	public Integer getArrangeEntryStatus() {
		return arrangeEntryStatus;
	}
	public void setArrangeEntryStatus(Integer arrangeEntryStatus) {
		this.arrangeEntryStatus = arrangeEntryStatus;
	}
	public Integer getRetestResultStatus() {
		return retestResultStatus;
	}
	public void setRetestResultStatus(Integer retestResultStatus) {
		this.retestResultStatus = retestResultStatus;
	}
	public Date getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(Date interviewTime) {
		this.interviewTime = interviewTime;
	}
	public Date getJoinProjectTime() {
		return joinProjectTime;
	}
	public void setJoinProjectTime(Date joinProjectTime) {
		this.joinProjectTime = joinProjectTime;
	}
	
    
}