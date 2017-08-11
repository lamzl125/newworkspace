package com.ying.app.res;


import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.AddressListBean;
import com.ying.app.bean.HangyeBean;


public class GetHangyeTypeRes extends Res{
	private List<HangyeBean> HangyeList = new ArrayList<HangyeBean>();

	public List<HangyeBean> getHangyeList() {
		return HangyeList;
	}

	public void setHangyeList(List<HangyeBean> hangyeList) {
		HangyeList = hangyeList;
	}

}
