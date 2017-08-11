package com.shzqoa.dao;


import java.util.List;
import java.util.Map;
import com.shzqoa.model.Group;

public interface GroupMapper {
	List<Group> getAllGroup(Map<String,Object> map);  //获取所有的地区信息
	
	Integer getAllGroupCount(Map<String,Object> map);  //获取所有的地区信息

	int insertGroup(Group info);
	
	Group getGroupById(String groupid);
	
	int delGroupById(String groupid);
	
	List<Group> getGroupList();
	
	int updateGroup(Group  info);
}
