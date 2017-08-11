package com.ying.app.res;


import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.AddressListBean;
import com.ying.app.bean.CustomerListBean;


public class PscustomerListRes extends Res{
	private Long totalPage;
	private List<CustomerListBean> customerList = new ArrayList<CustomerListBean>();

	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public List<CustomerListBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerListBean> customerList) {
		this.customerList = customerList;
	}
	

}
