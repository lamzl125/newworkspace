package com.shzqoa.model;

import java.util.Date;


public class EnterpriseContactsFollow {
	private String followId;//跟踪Id
	private String enterpriseContactsId;//企业联系人Id
	private String operCode;//跟踪人
	private Date operTime;//操作时间
	private String content;//跟踪内容
	public String getFollowId() {
		return followId;
	}
	public void setFollowId(String followId) {
		this.followId = followId;
	}
	public String getEnterpriseContactsId() {
		return enterpriseContactsId;
	}
	public void setEnterpriseContactsId(String enterpriseContactsId) {
		this.enterpriseContactsId = enterpriseContactsId;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public Date getOperTime() {
		return operTime;
	}
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
