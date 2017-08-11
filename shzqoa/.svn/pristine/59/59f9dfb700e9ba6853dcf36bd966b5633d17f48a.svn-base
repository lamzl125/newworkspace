package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.model.UserGroup;

public interface UserGroupMapper {
//	List<Group> getAllGroup(Map<String,Object> map);  //获取所有的地区信息
	
//	Integer getAllGroupCount(Map<String,Object> map);  //获取所有的地区信息
//
//	int insertGroup(Group info);
//	
//	Group getGroupById(String groupid);
//	
	int delUserGroupByUserCode(String usercode);
	
	List<UserGroup> getUserGroupList();
	
	int getUserGroupCounttByGroupid(String groupid);
	
	List<UserGroup> getUserGroupListByUserCode(String usercode);
	
	@Transactional
	int insertUserGroupList(Map<String,Object> conMap);
	
//	int updateGroup(Group  info);
	
	List<Map<String,Object>> getUserGroupMapByUsercode(Map<String,Object> map);
}
