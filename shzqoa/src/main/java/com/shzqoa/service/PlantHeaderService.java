package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.PlantHeaderMapper;
import com.shzqoa.model.PlantHeader;
@Service
public class PlantHeaderService {
	@Resource
	private PlantHeaderMapper plantHeaderMapper;
	
	public List<PlantHeader> getAllResult(){
		return plantHeaderMapper.getAllResult();
	}
	public PlantHeader getResultById(String plantHeaderId){
		return plantHeaderMapper.getResultById(plantHeaderId);
	}
	public Integer getResultCountByMap(Map<String, Object> map){
		return plantHeaderMapper.getResultCountByMap(map);
	}
	public List<Map<String, Object>> getResultByMap(Map<String, Object> map){
		return plantHeaderMapper.getResultByMap(map);
	}
	public int update(PlantHeader info){
		return plantHeaderMapper.update(info);
	}
	public int deleteById(String plantHeaderId){
		return plantHeaderMapper.deleteById(plantHeaderId);
	}
	public int save(PlantHeader info){
		return plantHeaderMapper.save(info);
	}
	
}
