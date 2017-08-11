package com.shzqoa.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shzqoa.model.Customerprojectpay;

public interface CustomerprojectpayMapper {
	
	public List<Map<String, Object>> queryOutCompany(Map<String, Object> params);
	
	public int queryOutCompanyCount(Map<String, Object> params);
	
	public int save(Customerprojectpay c);
	
	public List<Customerprojectpay> queryProjectAndPays(Map<String, Object> params);
	
	public List<Customerprojectpay> queryAllByParams(Map<String, Object> params);
	
	public int queryAllCount(Map<String, Object> params);
	
	public int deleteById(String id);
	
	public Customerprojectpay queryById(String id);
	
	public List<Customerprojectpay> queryAllPay(Map<String, Object> params);
	
	public List<Date> queryAllMonth(Map<String,Object> map);
	
	public int queryAllPayCount(Map<String, Object> params);
	
	//查询某人某年某月在某公司产生多少服务费
	public List<Customerprojectpay> querymonthservpay(Map<String, Object> params);

	public List<Customerprojectpay> queryProjectAndPaysBycode(
			Map<String, Object> params);
	
}
