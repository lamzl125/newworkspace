package com.shzqoa.model;

import java.util.Date;



public class UserWeiXin {
	private String userWeiXinId;  //用户微信Id
	private String userCode;  //用户编号
	private String weiXin;//微信
	private Integer statusFlag;//状态（1-启用   2-注销）
	private Date addTime;//添加时间
	private Date nullifyTime;//注销时间	
	
	
	
	
	public String getUserWeiXinId() {
		return userWeiXinId;
	}
	public void setUserWeiXinId(String userWeiXinId) {
		this.userWeiXinId = userWeiXinId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getWeiXin() {
		return weiXin;
	}
	public void setWeiXin(String weiXin) {
		this.weiXin = weiXin;
	}
	public Integer getStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getNullifyTime() {
		return nullifyTime;
	}
	public void setNullifyTime(Date nullifyTime) {
		this.nullifyTime = nullifyTime;
	}
	

	
}