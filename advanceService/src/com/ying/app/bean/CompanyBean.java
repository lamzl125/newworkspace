package com.ying.app.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class CompanyBean {
	private String id;   //物流公司id
	private String name;   //物流公司名称
	private List<CompanyName> companyList = new ArrayList<CompanyName>();   //物流公司站点
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CompanyName> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyName> companyList) {
		this.companyList = companyList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
