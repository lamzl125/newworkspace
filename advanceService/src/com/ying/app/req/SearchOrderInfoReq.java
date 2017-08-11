package com.ying.app.req;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.ImageListBean;

public class SearchOrderInfoReq extends Req{
	private String keywords; //查询的关键词
	private String orderId; //订单号
	private String uid; //用户id
	private String nowPage; //当前页
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	
	
	
	
	
}
