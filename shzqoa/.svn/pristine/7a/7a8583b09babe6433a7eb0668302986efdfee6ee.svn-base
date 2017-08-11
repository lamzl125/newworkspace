package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.MonthServicePay;

public interface MonthServicePayMapper {
	//批量添加某人某人某月某公司的服务费
	public int batchaddmonthservpay(List<MonthServicePay> list);
	
	//查询已经生成的某年某月某人在某公司的服务费
	public List<MonthServicePay> queryMonthServicePay(Map<String,Object> map);
	
	public List<Map<String,Object>> queryMapMonthServicePay(Map<String,Object> map);
	
	public int queryMapMonthServicePayCount(Map<String,Object> map);
	
	public List<Map<String,Object>> querySumMonthServicePay(Map<String,Object> map);
	
	public int querySumMonthServicePayCount(Map<String,Object> map);

	public List<MonthServicePay> queryPayByProjectPayId(Map<String, Object> map);

	public Integer updatemonthservicepay(MonthServicePay servicePay);
}
