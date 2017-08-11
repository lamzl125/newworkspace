package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.MessageBean;
import com.ying.app.bean.PSOrderList;
import com.ying.app.bean.UserInfo;


public class OrderListRes extends Res{
	private Long totalPage;			//总页数
	private List<PSOrderList> orderList = new ArrayList<PSOrderList>();
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public List<PSOrderList> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<PSOrderList> orderList) {
		this.orderList = orderList;
	}
	
	
}
