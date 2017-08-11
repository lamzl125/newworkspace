package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.model.DemandResume;


public interface DemandResumeMapper {
	
	public List<Map<String,Object>> demandResumeOfDemand(String demandId);
	
	public List<Map<String,Object>> demandResumeOfDemandMap(Map<String,Object> map);
	
	public int demandResumeOfDemandCount(Map<String,Object> map);
	
	public List<DemandResume> selectDemandResumeBySignId(String demandSignId);
	
	public List<Map<String,Object>> selectDemandResumeByDemand(String demandId);
	
	/*public List<DemandResume> getDemandResumeList();
	
	public List<DemandResume> getDemandResumeListByUserCode(String demandSignId);
	
	public int getDemandResumeCounttByResume(String customerCode);*/
	
	public int delDemandResumeByDemandSign(String demandSignId);
	
	@Transactional
	int insertDemandResumeList(List<DemandResume> list);
	
	
	public List<Map<String,Object>> laststatusdemandResume(String demandId);
	
	
	public DemandResume stlObjectById(String id);
	
}
