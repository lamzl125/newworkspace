package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.model.GroupRight;

public interface GroupRightMapper {
	int delGroupRightByGroupId(String groupid);
	
	List<GroupRight> getGroupRightList();
	
	List<GroupRight> getGroupRightListByGroupId(String groupid);
	
	int getGroupRightCountByRightId(String rightid);
	
	@Transactional
	int insertGroupRightList(Map<String,Object> conMap);
	
}
