package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.CycleBean;
import com.ying.app.bean.UserInfo;


public class ReCycleListRes extends Res{
	private List<CycleBean> cycleList = new ArrayList<CycleBean>();
	
	public List<CycleBean> getCycleList() {
		return cycleList;
	}

	public void setCycleList(List<CycleBean> cycleList) {
		this.cycleList = cycleList;
	}
}