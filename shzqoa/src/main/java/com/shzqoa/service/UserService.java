package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.shzqoa.dao.UserMapper;
import com.shzqoa.model.ResumeSource;
import com.shzqoa.model.User;

@Service
public class UserService {
	@Resource
	private UserMapper userMapper;
	
	public List<User> getAllUsers(){
		return userMapper.getAllUsers();
	}
	
	
	public List<User> queryUsersByGroup(String groupid){
		if(StringUtils.isNotBlank(groupid)){
			return userMapper.queryUsersByGroup(groupid);
		}
		return null;
	}
	
	public List<User> queryUsersByGroupName(String groupname){
		return userMapper.queryUsersByGroupName(groupname);
	}
	
	
	/**
	 * 查询离职人员列表
	 */
	public List<User> queryDessionList(Map<String,Object> map){
		return userMapper.queryDessionList(map);
	}
	
	
	/**
	 * 查询在职人员列表
	 */
	public List<User> queryCurList(Map<String,Object> map){
		return userMapper.queryCurList(map);
	}
	
	public int queryDessionListCount(Map<String,Object> map){
		return userMapper.queryDessionListCount(map);
	}
	
	
	public User getUserByUserCode(String userCode){
		return userMapper.getUserByCode(userCode);
	}
	
	public int updateUser(User info){
		return userMapper.updateUser(info);
	}
	
	
	//查询某组在职人员
	public List<User> getGroupInUsers(Map<String,Object> map){
		return userMapper.getGroupInUsers(map);
	}
}






