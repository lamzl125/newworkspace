package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.CustomerSignMapper;
import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.CustomerSign;
@Service
public class CustomerSignService {
	@Resource
	private CustomerSignMapper customerSignMapper;
	
	public int save(CustomerSign info){
		return customerSignMapper.save(info);
	}
	public int deleteById(String signId){
		return customerSignMapper.deleteById(signId);
	}
	public int update(CustomerSign info){
		return customerSignMapper.update(info);
	}
	public CustomerSign getResultById(String signId){
		return customerSignMapper.getResultById(signId);
	}
	public List<CustomerSign> getAllResult(){
		return customerSignMapper.getAllResult();
	}
	
	//1、查询满足未关闭需求的技术方向且n天未跟踪的简历
	public List<Map<String,Object>> demteresmelist(Map<String,Object> map){
		return customerSignMapper.demteresmelist(map);
	}
	public int demteresmelistcount(Map<String,Object> map){
		return customerSignMapper.demteresmelistcount(map);
	}
	
	//超期无效
	public int updateOverdue(Map<String,Object> map){
		return customerSignMapper.updateOverdue(map);
	}
	
	public int addList(List<CustomerSign> list){
		return customerSignMapper.addList(list);
	}
	
	//查询待跟踪的列表
	public List<CustInfoAdd> followresmelist(Map<String,Object> map){
		return customerSignMapper.followresmelist(map);
	}
	public int followresmelistcount(Map<String,Object> map){
		return customerSignMapper.followresmelistcount(map);
	}
}
