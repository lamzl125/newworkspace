package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.WorkerFollow;

public interface WorkerFollowMapper {	
	public int save(WorkerFollow info);
	public int deleteById(String followId);
	public int update(WorkerFollow info);	
	public List<WorkerFollow> selWorkerFollow(Map<String, Object> map);
	public Integer getWorkerFollowCount(Map<String, Object> map);
	public WorkerFollow getWorkerFollowById(String followId);
	
}
