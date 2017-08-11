package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.MonthServicePayFollowMapper;
import com.shzqoa.model.MonthServicePayFollow;

@Service
public class MonthServicePayFollowService {
	@Resource
	private MonthServicePayFollowMapper monthServicePayFollowMapper;
	//查询所有的预计回款跟踪信息
	public List<MonthServicePayFollow> getAllMonthServicePayFollow(Map<String,Object> map){
		return monthServicePayFollowMapper.getAllMonthServicePayFollow(map);
	}
	
	public List<MonthServicePayFollow> getMonthServicePayFollowBycode(Map<String,Object> map){
		return monthServicePayFollowMapper.getMonthServicePayFollowBycode(map);
	}
	//批量新增预计回款信息跟踪信息
	public int batchaddmonthservpayfollow(List<MonthServicePayFollow> list){
		return monthServicePayFollowMapper.batchaddmonthservpayfollow(list);
	}

	//查询预计回款信息跟踪列表-包含某月已回
	public List<Map<String,Object>> querymonthserpayfollowlist(Map<String,Object> map){
		return monthServicePayFollowMapper.querymonthserpayfollowlist(map);
	}
	//查询预计回款跟踪信息数量
	public int querymonthserpayfollowlistCount(Map<String,Object> map){
		return monthServicePayFollowMapper.querymonthserpayfollowlistCount(map);
	}
	
	//查询实际回款信息跟踪列表
	public List<Map<String,Object>> actualPayfollowlist(Map<String,Object> map){
		return monthServicePayFollowMapper.actualPayfollowlist(map);
	}
	//查询实际回款信息跟踪列表
	public int actualPayfollowCount(Map<String,Object> map){
		return monthServicePayFollowMapper.actualPayfollowCount(map);
	}
	
	
	public List<Map<String,Object>> payofdemandofoper(Map<String,Object> map){
		return monthServicePayFollowMapper.payofdemandofoper(map);
	}
	
}
