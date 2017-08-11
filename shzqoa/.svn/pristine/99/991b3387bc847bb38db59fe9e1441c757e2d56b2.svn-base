package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.model.UserWeiXin;

public interface UserWeiXinMapper {
	public UserWeiXin getUserWeiXinById(String userWeiXinId);
	public List<UserWeiXin> getUserWeiXinListByMap(Map<String,Object> map);
	public int getUserWeiXinCountByMap(Map<String,Object> map);
	public int insertUserWeiXin(UserWeiXin info);	
	
	@Transactional
	public int insertUserWeiXinList(List<UserWeiXin> list);
	public int update(UserWeiXin info);
	
}
