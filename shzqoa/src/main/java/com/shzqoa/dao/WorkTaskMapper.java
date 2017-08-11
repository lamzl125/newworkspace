package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.WorkTask;

public interface WorkTaskMapper {
	public WorkTask stlWorkTaskById(Integer taskid);
	
	public int updateWorkTaskById(WorkTask info); 
	
	public int batchaddWorkTask(List<WorkTask> workTasklist);

	int insertWorkTask(WorkTask workTask); // 添加工作任务
	
	int confirmWork(Map<String,Object> map); // 确认工作任务
	
	List<WorkTask> seltWorkTasks(Map<String,Object> map); // 查询工作任务列表
	
	int sltWorkTaskNum(Map<String,Object> map);//查询工作任务数量
	
	List<WorkTask> sltNofinish(String userid);  // 未完成工作任务列表 
	
	int ispromulgator(String userid);// 是否为发布者(发布过任务)
	
	
	public List<Map<String,Object>> sltTaskByUserDay(Map<String,Object> map);//查询某人某天的任务
}




