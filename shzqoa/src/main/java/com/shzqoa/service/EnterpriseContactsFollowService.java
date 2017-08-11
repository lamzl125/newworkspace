package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.EnterpriseContactsFollowMapper;
import com.shzqoa.model.EnterpriseContactsFollow;

@Service
public class EnterpriseContactsFollowService {
	@Resource
	private EnterpriseContactsFollowMapper enterpriseContactsFollowMapper;
	
	public List<EnterpriseContactsFollow> getAllFollowList(Map<String,Object> map){
		return enterpriseContactsFollowMapper.getAllFollowList(map);
	}
	
	public Integer getAllFollowListCount(Map<String,Object> map){
		return enterpriseContactsFollowMapper.getAllFollowListCount(map);
	}
	
	public EnterpriseContactsFollow getFollowById(String followId){
		return enterpriseContactsFollowMapper.getFollowById(followId);
	}
	
	public int insertFollow(EnterpriseContactsFollow  info){
		return enterpriseContactsFollowMapper.insertFollow(info);
	}
	
	public int updateFollow(EnterpriseContactsFollow  info){
		return enterpriseContactsFollowMapper.updateFollow(info);
	}
	
	public int delFollow(String followId){
		return enterpriseContactsFollowMapper.delFollow(followId);
	}
	
	
}





