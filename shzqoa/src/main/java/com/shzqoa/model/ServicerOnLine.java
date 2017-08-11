package com.shzqoa.model;

import java.io.Serializable;


public class ServicerOnLine implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;//在线客服Id
	private String serviceName;//客服名称
	private String qQ;//QQ
	
	private String qq;
	
	private String weiXin;//微信号
	private Integer servicerStatus;//状态（1-启用  2-未启用）
	private String reMark;//备注
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getqQ() {
		return qQ;
	}
	public void setqQ(String qQ) {
		this.qQ = qQ;
	}
	public String getWeiXin() {
		return weiXin;
	}
	public void setWeiXin(String weiXin) {
		this.weiXin = weiXin;
	}
	public Integer getServicerStatus() {
		return servicerStatus;
	}
	public void setServicerStatus(Integer servicerStatus) {
		this.servicerStatus = servicerStatus;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
	
	
	
	
	
}