package com.ying.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PSOrder {
	private Date orderdate;
	private List<PSOrderList> orderList=new ArrayList<PSOrderList>();





	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public List<PSOrderList> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<PSOrderList> orderList) {
		this.orderList = orderList;
	}
	
}
