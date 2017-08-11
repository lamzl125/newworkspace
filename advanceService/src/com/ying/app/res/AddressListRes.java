package com.ying.app.res;


import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.AddressListBean;


public class AddressListRes extends Res{
	private List<AddressListBean> addressList = new ArrayList<AddressListBean>();

	public List<AddressListBean> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressListBean> addressList) {
		this.addressList = addressList;
	}

	

}
