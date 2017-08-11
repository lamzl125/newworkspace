package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.DemandWorkerMapper;



@Service
public class DemandWorkerService {
	@Resource
	DemandWorkerMapper demandWorkerMapper;
	
	
	public int saveList(List<Map<String,Object>> list){
		return demandWorkerMapper.saveList(list);
	}
	public int deleteById(String demandWorkerId){
		return demandWorkerMapper.deleteById(demandWorkerId);
	}
	
	public int deleteByDemandId(String demandId){
		return demandWorkerMapper.deleteByDemandId(demandId);
	}
	public int deleteByWorkerId(Map<String,Object> map){
		return demandWorkerMapper.deleteByWorkerId(map);
	}
	
	
	public List<Map<String,Object>> getWorkerByDemand(String demandId){
		return demandWorkerMapper.getWorkerByDemand(demandId);
	}
	public int  getWorkerCountByDemand(String demandId){
		return demandWorkerMapper.getWorkerCountByDemand(demandId);
	}

}
