package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustomerCompany;

public interface CustomerCompanyMapper {
	
	public List<CustomerCompany> queryNoCheck(int status);
	
	public List<CustomerCompany> queryAll(Map<String, Object> params);
	
	public int queryCustomerCompanyCount();
	
	public int operCheck(Map<String, Object> params);
	/**添加审核数据*/
	public int insertCustomerCompany(CustomerCompany customerCompany);
	
}
