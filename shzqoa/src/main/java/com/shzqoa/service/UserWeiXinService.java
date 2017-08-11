package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.UserWeiXinMapper;
import com.shzqoa.model.UserWeiXin;

@Service
public class UserWeiXinService {
	@Resource
	private UserWeiXinMapper userWeiXinMapper;
	
	public UserWeiXin getUserWeiXinById(String userWeiXinId){
		return userWeiXinMapper.getUserWeiXinById(userWeiXinId);
	}
	
	
	public List<UserWeiXin> getUserWeiXinListByMap(Map<String,Object> map){
		return  userWeiXinMapper.getUserWeiXinListByMap(map);
	}
	public int getUserWeiXinCountByMap(Map<String,Object> map){
		return  userWeiXinMapper.getUserWeiXinCountByMap(map);
	}
	public int insertUserWeiXin(UserWeiXin info){
		return  userWeiXinMapper.insertUserWeiXin(info);
	}
	
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public int insertUserWeiXinList(List<UserWeiXin> list){
		return  userWeiXinMapper.insertUserWeiXinList(list);
	}
	public int update(UserWeiXin info){
		return  userWeiXinMapper.update(info);
	}
	 
    
}
