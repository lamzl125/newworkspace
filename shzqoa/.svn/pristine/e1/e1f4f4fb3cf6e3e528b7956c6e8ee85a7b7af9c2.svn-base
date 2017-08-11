package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.CustomerSign;


public interface CustomerSignMapper {
	public int save(CustomerSign info);
	public int deleteById(String signId);
	public int update(CustomerSign info);
	public CustomerSign getResultById(String signId);
	public List<CustomerSign> getAllResult();
	
	//1、查询满足未关闭需求的技术方向且n天未跟踪的简历
	public List<Map<String,Object>> demteresmelist(Map<String,Object> map);
	public int demteresmelistcount(Map<String,Object> map);
	
	public int updateOverdue(Map<String,Object> map);
	
	
	public int addList(List<CustomerSign> list);
	
	public List<CustInfoAdd> followresmelist(Map<String,Object> map);
	public int followresmelistcount(Map<String,Object> map);
	
	

}