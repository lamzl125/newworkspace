package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.GroupMapper;
import com.shzqoa.model.Group;

@Service
public class GroupService {
	@Resource
	private GroupMapper groupMapper;
	
	public List<Group> getAllGroup(Map<String,Object> map){
		return groupMapper.getAllGroup(map);
	}
	public Integer getAllGroupCount(Map<String,Object> map){
		return groupMapper.getAllGroupCount(map);
	}
	public int addGroup(Group  info){
		return groupMapper.insertGroup(info);
	}
	
	public Group getGroupById(String groupid){
		return groupMapper.getGroupById(groupid);
	}
	
	public int delGroupById(String groupid){
		return groupMapper.delGroupById(groupid);
	}
	 
    public List<Group> getGroupList(){
    	return groupMapper.getGroupList();
    }
    
    public int updateGroup(Group  info){
		return groupMapper.updateGroup(info);
	}
}
