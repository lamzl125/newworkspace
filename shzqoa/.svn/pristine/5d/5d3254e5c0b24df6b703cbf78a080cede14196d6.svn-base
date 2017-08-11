package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.DemandSignMapper;
import com.shzqoa.model.DemandResumeRelation;
import com.shzqoa.model.DemandSign;

@Service
public class DemandSignService {
	@Resource
	private DemandSignMapper demandSignMapper;

	public List<DemandSign> selectDemandSignByMap(Map<String,Object> map){
		return demandSignMapper.selectDemandSignByMap(map);
	}
	
	public int selectMaxIndexByDemand(String demandId){
		return demandSignMapper.selectMaxIndexByDemand(demandId);
	}
	
	public int insertDemandSign(DemandSign info){
		return  demandSignMapper.insertDemandSign(info);
	}
	
	//当前用户分配到的需求
	public List<Map<String,Object>> selectDemandSignByUserMap(Map<String,Object> map){
		return demandSignMapper.selectDemandSignByUserMap(map);
	}
	
	
	public DemandSign selectObjectById(String id){
		return demandSignMapper.selectObjectById(id);
	}
}
