package com.ying.app.res;

import com.ying.app.bean.UserInfo;


public class GetBoundageRes extends Res{
	private String payInProvinceBoundage;//垫付省内手续费
	private String payOutProvinceBoundage;//垫付省外手续费
	private String noPayInProvinceBoundage;//不垫付省内手续费
	private String noPayOutProvinceBoundage;//不垫付省外手续费
	public String getPayInProvinceBoundage() {
		return payInProvinceBoundage;
	}
	public void setPayInProvinceBoundage(String payInProvinceBoundage) {
		this.payInProvinceBoundage = payInProvinceBoundage;
	}
	public String getPayOutProvinceBoundage() {
		return payOutProvinceBoundage;
	}
	public void setPayOutProvinceBoundage(String payOutProvinceBoundage) {
		this.payOutProvinceBoundage = payOutProvinceBoundage;
	}
	public String getNoPayInProvinceBoundage() {
		return noPayInProvinceBoundage;
	}
	public void setNoPayInProvinceBoundage(String noPayInProvinceBoundage) {
		this.noPayInProvinceBoundage = noPayInProvinceBoundage;
	}
	public String getNoPayOutProvinceBoundage() {
		return noPayOutProvinceBoundage;
	}
	public void setNoPayOutProvinceBoundage(String noPayOutProvinceBoundage) {
		this.noPayOutProvinceBoundage = noPayOutProvinceBoundage;
	}

	
	
}
