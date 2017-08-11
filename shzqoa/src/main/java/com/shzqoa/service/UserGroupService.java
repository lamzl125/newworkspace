package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.UserGroupMapper;
import com.shzqoa.model.UserGroup;

@Service
public class UserGroupService {
	@Resource
	private UserGroupMapper userGroupMapper;
	
	 
    public List<UserGroup> getUserGroupList(){
    	return userGroupMapper.getUserGroupList();
    }
    
    public List<UserGroup> getUserGroupListByUserCode(String usercode){
    	return userGroupMapper.getUserGroupListByUserCode(usercode);
    }
    
    public int getUserGroupCounttByGroupid(String groupid){
    	return userGroupMapper.getUserGroupCounttByGroupid(groupid);
    }
    
    public int delUserGroupByUserCode(String userCode){
    	return userGroupMapper.delUserGroupByUserCode(userCode);
    }
    
    
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int setUserGroup(String userCode,String[] groupids){
    	Map<String,Object> conMap = new HashMap<String,Object>();
    	int delCount = userGroupMapper.delUserGroupByUserCode(userCode);
    	conMap.put("userCode", userCode);
    	conMap.put("groupids", groupids);
    	int upCount = userGroupMapper.insertUserGroupList(conMap);
    	if (upCount == 0) {
            throw new RuntimeException("upCount is 0;");
        }
    	return upCount;
    }
    
   public List<Map<String,Object>> getUserGroupMapByUsercode(Map<String,Object> map){
    	return userGroupMapper.getUserGroupMapByUsercode(map);
    }
    
}
