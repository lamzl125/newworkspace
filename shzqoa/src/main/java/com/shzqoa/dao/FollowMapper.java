package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.Follow;

public interface FollowMapper {	
	public int save(Follow info);
	public int deleteById(Integer followId);
	public int update(Follow info);	
	public List<Follow> selFollow(Map<String, Object> map);
	public Integer getFollowCount(Map<String, Object> map);
	public Follow getFollowById(Integer followId);
	
	public List<Object> selLastOperTime();
}
