package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.EnterpriseContactsFollow;

public interface EnterpriseContactsFollowMapper {
	public List<EnterpriseContactsFollow> getAllFollowList(Map<String,Object> map);
	
	public Integer getAllFollowListCount(Map<String,Object> map);
	
	public EnterpriseContactsFollow getFollowById(String followId);
	
	public int insertFollow(EnterpriseContactsFollow  info);
	
	public int updateFollow(EnterpriseContactsFollow  info);
	
	public int delFollow(String followId);
	
}



