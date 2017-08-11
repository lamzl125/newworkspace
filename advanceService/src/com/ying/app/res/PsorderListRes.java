package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.PSOrderList;

public class PsorderListRes extends Res{
	private List<PSOrderList> orderList=new ArrayList<PSOrderList>();
	private Long	totalPage;
	


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

