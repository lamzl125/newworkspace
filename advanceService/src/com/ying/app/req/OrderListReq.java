package com.ying.app.req;

public class OrderListReq extends Req{
	private String uid;
	private String type;	//1.全部 2.待揽件 3.已揽件 4.已收货 5.退件
	private String nowPage;	//(当前页数，每页10条)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}

	
	
	
}
