package com.shzqoa.dao;


import java.util.List;
import java.util.Map;
import com.shzqoa.model.Areas;

public interface AreasMapper {
	List<Areas> getAllAreas(Map<String,Object> map);  //获取所有的地区信息
	
	Integer getAllAreasCount(Map<String,Object> map);  //获取所有的地区信息

	int insertArea(Areas area);
	
	Areas getAreasById(String areaid);
	
	int delAreaById(String areaid);
	
	List<Areas> getAreaList();
}
