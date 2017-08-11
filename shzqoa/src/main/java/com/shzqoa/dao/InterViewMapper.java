package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.InterView;
import com.shzqoa.model.InterViews;

public interface InterViewMapper {
	
	public int saveinter(List<Map<String, String>> list); 
	public int deleteinters(List<Map<String, String>> list); 
	
	public List<InterViews> selectinterView(Map<String, Object> map);
	public InterViews selectView(Map<String, Object> map);
	
	public int updateInterView(Map<String, Object> map);
	
	public int selectinterViewCount(Map<String, Object> map);
}
