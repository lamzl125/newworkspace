package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.PlantHeader;


public interface PlantHeaderMapper {
	public int save(PlantHeader info);
	public int deleteById(String plantHeaderId);
	public int update(PlantHeader info);
	public List<Map<String, Object>> getResultByMap(Map<String, Object> map);
	public Integer getResultCountByMap(Map<String, Object> map);
	public PlantHeader getResultById(String plantHeaderId);
	public List<PlantHeader> getAllResult();
	

}