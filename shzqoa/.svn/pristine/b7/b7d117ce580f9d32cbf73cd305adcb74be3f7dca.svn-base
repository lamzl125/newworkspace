package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.DemandResumeFollow;


public interface DemandResumeFollowMapper {
	Integer insertDemandResumeFollow(DemandResumeFollow follow);
    List<Map<String,Object>> followOfResume(String demandResumeId);
    List<Map<String,Object>> secondfollowOfResume(String id);
	List<DemandResumeFollow> getdemandresumefollowByid(String id);
	List<DemandResumeFollow> getdemandresumefollowBydemandresumeid(
			String demandresumeid);
	
	List<Map<String,Object>> getDurationByCorp(Map<String,Object> map);
	
	public List<Map<String,Object>> followlistOfDemandResume(Map<String,Object> map);
	
	
	public DemandResumeFollow stllastestfollowBydrid(String demandResumeId);
}
