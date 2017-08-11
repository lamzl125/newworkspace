package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.Worker;
import com.shzqoa.model.WorkerSign;


public interface WorkerSignMapper {
	public int save(WorkerSign info);
	public int addList(List<WorkerSign> list);
	public int deleteById(String signId);
	public int update(WorkerSign info);
	public WorkerSign getResultById(String signId);
	public List<WorkerSign> getAllResult();
	public int updateOverdue(Map<String,Object> map);	
	
	//1、查询n天未跟踪的简历
	public List<Map<String,Object>> demteworkerlist(Map<String,Object> map);
	
	
	//查询待跟踪的列表
	public List<Worker> followworkerlist(Map<String,Object> map);
	public int followworkerlistcount(Map<String,Object> map);
	
	//查询待跟踪的列表
	public List<Map<String,Object>> giveupworkerlist(Map<String,Object> map);
	
	

}