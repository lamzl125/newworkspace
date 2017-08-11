package com.shzqoa.model;

import java.util.Date;

public class Notice {
	private String noticeId;//通知Id
	private String noticeTo;//通知到
	private String noticeFrom;//通知来源
    private Date noticeTime;//通知时间
    private Integer noticeType;//通知类型（1-面试通知  2-入项通知）
    private String  noticeContent;//通知内容
    private String  reMark;//备注
    private String reMark1;//备注
    
    private Date sureTime;//查看时间
    private Integer noticeStatus;//公告状态（0-未查看  1-已查看）
    
    
    
    
	public String getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeTo() {
		return noticeTo;
	}
	public void setNoticeTo(String noticeTo) {
		this.noticeTo = noticeTo;
	}
	public String getNoticeFrom() {
		return noticeFrom;
	}
	public void setNoticeFrom(String noticeFrom) {
		this.noticeFrom = noticeFrom;
	}
	public Date getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	public Integer getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
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
	public Date getSureTime() {
		return sureTime;
	}
	public void setSureTime(Date sureTime) {
		this.sureTime = sureTime;
	}
	public Integer getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(Integer noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
    
    

	
    
}
