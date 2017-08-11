package com.ying.app.req;

public class HandleAdressReq extends Req{
	private String receiverid; //地址id
	private String uid; //用户id
	public String getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
