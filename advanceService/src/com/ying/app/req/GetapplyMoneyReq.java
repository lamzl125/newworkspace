package com.ying.app.req;

public class GetapplyMoneyReq extends Req{
	private String uid; //用户id
	private String year; //年
	private String nowPage; //当前页数
	
	
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
