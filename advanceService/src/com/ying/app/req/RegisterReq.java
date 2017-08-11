package com.ying.app.req;

public class RegisterReq extends Req{
	private String phoneNum; //用户电话
	private String password; //密码
	private String recommendedCode; //密码
	private String serviceCode; //密码
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRecommendedCode() {
		return recommendedCode;
	}
	public void setRecommendedCode(String recommendedCode) {
		this.recommendedCode = recommendedCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	

	
}
