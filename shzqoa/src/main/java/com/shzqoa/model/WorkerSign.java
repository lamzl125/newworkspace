package com.shzqoa.model;

import java.util.Date;

/**
 * 普工跟踪分配
 *
 */
public class WorkerSign {
	private String signId;  //分配Id
	private String workerId;  //工人Id
	private String userCode;//用户编号
	private Date signedTime; // 分配时间		
	private Integer signStatus;  //状态（1-启用  2-作废）	
	
	
	  
	public String getSignId() {
		return signId;
	}
	public void setSignId(String signId) {
		this.signId = signId;
	}
	
	public String getWorkerId() {
		return workerId;
	}
	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Date getSignedTime() {
		return signedTime;
	}
	public void setSignedTime(Date signedTime) {
		this.signedTime = signedTime;
	}
	public Integer getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}
	
}