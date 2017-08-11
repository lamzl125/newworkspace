package com.ying.app.req;

public class ServiceCodeReq extends Req{
	private String uid; //用户id
	private String serviceCode; //服务码
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
}
