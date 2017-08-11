package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.MonthServicePay;
import com.shzqoa.model.MonthServicePayFollow;

public interface MonthServicePayFollowMapper {
	public List<MonthServicePayFollow> getAllMonthServicePayFollow(Map<String,Object> map);
	//批量添加某年某月某公司的服务费
	public int batchaddmonthservpayfollow(List<MonthServicePayFollow> list);
	
	public List<Map<String,Object>> querymonthserpayfollowlist(Map<String,Object> map);
	
	public int querymonthserpayfollowlistCount(Map<String,Object> map);
	
	
	//查询实际回款信息跟踪列表
	public List<Map<String,Object>> actualPayfollowlist(Map<String,Object> map);
	
	
	//查询实际回款信息跟踪列表
	public int actualPayfollowCount(Map<String,Object> map);
	
	
	public List<Map<String,Object>> payofdemandofoper(Map<String,Object> map);
	public List<MonthServicePayFollow> getMonthServicePayFollowBycode(
			Map<String, Object> map);
	
}
