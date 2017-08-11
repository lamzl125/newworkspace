package com.shzqoa.model;

public class ReturnDate {
	private int status;//状态,0正常,其他错误
	
	private String msg;//消息
	
	private String usercode;	//用户编号
	
	private Object data;//数据

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	
	
}




