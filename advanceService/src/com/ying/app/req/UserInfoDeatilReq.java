package com.ying.app.req;

public class UserInfoDeatilReq extends Req{
	private String uid; //用户id
	private String userName; //电话
	private String userAddress; //详细地址
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
	
}
