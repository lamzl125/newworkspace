package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.PSOrder;
import com.ying.app.bean.PSOrderBean;

public class PsrecordListRes extends Res{
	private List<PSOrderBean> order=new ArrayList<PSOrderBean>();
	private Long totalPage;
	


	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public List<PSOrderBean> getOrder() {
		return order;
	}

	public void setOrder(List<PSOrderBean> order) {
		this.order = order;
	}
	
}
