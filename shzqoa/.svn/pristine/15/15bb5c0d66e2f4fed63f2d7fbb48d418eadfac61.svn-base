package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.DemandSign;


public interface DemandSignMapper {
	public List<DemandSign> selectDemandSignByMap(Map<String,Object> map);
	
	public int selectMaxIndexByDemand(String demandId);
	
	public int insertDemandSign(DemandSign info);
	
	//当前用户分配到的需求
	public List<Map<String,Object>> selectDemandSignByUserMap(Map<String,Object> map);
	
	
	public DemandSign selectObjectById(String id);
}
