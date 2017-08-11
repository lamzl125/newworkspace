package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.WorkDemandMapper;
import com.shzqoa.model.WorkDemand;



@Service
public class WorkDemandService {
	@Resource
	private WorkDemandMapper workDemandMapper;
	
	public List<WorkDemand> getAllWorkDemand(){
		return workDemandMapper.getAllWorkDemand();
	}	
	public WorkDemand getWorkDemandById(String demandId){
		return workDemandMapper.getWorkDemandById(demandId);
	}
	public int deleteById(String demandId){
		return workDemandMapper.deleteById(demandId);
	}
	public int update(WorkDemand info){
		return workDemandMapper.update(info);
	}
	public int save(WorkDemand info){
		return workDemandMapper.save(info);
	}
	public List<WorkDemand> getWorkDemandByMap(Map<String,Object> map){
		return workDemandMapper.getWorkDemandByMap(map);
	}
	public int getWorkDemandCountByMap(Map<String,Object> map){
		return workDemandMapper.getWorkDemandCountByMap(map);
	}
	
	
	
	public List<Map<String,Object>> workstatistics(Map<String,Object> map){
		return workDemandMapper.workstatistics(map);
	}
	public int workstatisticscount(Map<String,Object> map){
		return workDemandMapper.workstatisticscount(map);
	}
	
}
