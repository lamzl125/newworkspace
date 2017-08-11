package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.UserInfo;


public class GetLogisticsCompanyRes extends Res{
	private List<CompanyBean> companyInfoList = new ArrayList<CompanyBean>();

	public List<CompanyBean> getCompanyInfoList() {
		return companyInfoList;
	}

	public void setCompanyInfoList(List<CompanyBean> companyInfoList) {
		this.companyInfoList = companyInfoList;
	}

	
	
}
