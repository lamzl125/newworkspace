package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.ApplyYearBean;
import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.OrderListBean;
import com.ying.app.bean.UserInfo;


public class MyApplyOrderRes extends Res{
	private Long totalPage;			//总页数
	private List<OrderListBean> orderList = new ArrayList<OrderListBean>();

	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public List<OrderListBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderListBean> orderList) {
		this.orderList = orderList;
	}

	
}
