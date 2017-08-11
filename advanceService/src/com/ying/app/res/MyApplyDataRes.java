package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.ApplyYearBean;
import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.UserInfo;


public class MyApplyDataRes extends Res{
	private List<ApplyYearBean> applyYear = new ArrayList<ApplyYearBean>();

	public List<ApplyYearBean> getApplyYear() {
		return applyYear;
	}

	public void setApplyYear(List<ApplyYearBean> applyYear) {
		this.applyYear = applyYear;
	}
	
}
