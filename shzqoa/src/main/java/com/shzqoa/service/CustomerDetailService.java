package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.CustomerInfoMapper;
import com.shzqoa.model.CustomerInfo;

@Service
public class CustomerDetailService {
	@Resource
	private CustomerInfoMapper ustomerInfoMapper;
	
	//简历列表-根据开始时间、结束时间、用户、简历来源获取
	public List<Map<String,Object>> resumelistByMap(Map<String,Object> map){
		return ustomerInfoMapper.resumelistByMap(map);
	}
	//简历列表数量-根据开始时间、结束时间、用户、简历来源获取
	public int resumelistCountByMap(Map<String,Object> map){
		return ustomerInfoMapper.resumelistCountByMap(map);
	}
	
	
	//简历列表-可面、面试、面试通过、入项
	public List<Map<String,Object>> sourceresume(Map<String,Object> map){
		return ustomerInfoMapper.sourceresume(map);
	}
	//简历列表数量-可面、面试、面试通过、入项
	public int sourceresumecount(Map<String,Object> map){
		return ustomerInfoMapper.sourceresumecount(map);
	}
	
	
	
	
	
	//简历来源统计
	public List<Map<String,Object>> ressoustat(Map<String,Object> map){
		return ustomerInfoMapper.ressoustat(map);
	}
	//简历数量来源统计
	public int ressoustatcount(Map<String,Object> map){
		return ustomerInfoMapper.ressoustatcount(map);
	}
	
	
	//简历数量统计-录入简历、有效简历、可面简历、面试简历、面试通过、入项
	public List<Map<String,Object>> resumestatistics(Map<String,Object> map){
		return ustomerInfoMapper.resumestatistics(map);
	}
	//简历数量统计-录入简历、有效简历、可面简历、面试简历、面试通过、入项
	public int resumestatisticscount(Map<String,Object> map){
		return ustomerInfoMapper.resumestatisticscount(map);
	}
	
	
	
	public CustomerInfo getCustomerinfoByCode(String customercode) {  
        return ustomerInfoMapper.getCustomerinfoByCode(customercode);  
    } 
	
	public List<CustomerInfo> getCustomerinfoByCon(Map<String,Object> conMap){
		return ustomerInfoMapper.getCustomerinfoByCon(conMap);
	}
	
	public Integer getCustomerinfoCountByCon(Map<String,Object> conMap){
		return ustomerInfoMapper.getCustomerinfoCountByCon(conMap);
	}
	
}
