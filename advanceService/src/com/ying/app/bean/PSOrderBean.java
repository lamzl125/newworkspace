package com.ying.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PSOrderBean {
	private String orderdate;
	private List<PSOrderList> orderList=new ArrayList<PSOrderList>();






	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public List<PSOrderList> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<PSOrderList> orderList) {
		this.orderList = orderList;
	}
	
}
