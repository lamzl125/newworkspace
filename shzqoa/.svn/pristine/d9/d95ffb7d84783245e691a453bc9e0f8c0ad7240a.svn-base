package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.WorkerSignMapper;
import com.shzqoa.model.Worker;
import com.shzqoa.model.WorkerSign;
@Service
public class WorkerSignService {
	@Resource
	private WorkerSignMapper workerSignMapper;
	
	public int save(WorkerSign info){
		return workerSignMapper.save(info);
	}
	public int deleteById(String signId){
		return workerSignMapper.deleteById(signId);
	}
	public int update(WorkerSign info){
		return workerSignMapper.update(info);
	}
	public WorkerSign getResultById(String signId){
		return workerSignMapper.getResultById(signId);
	}
	public List<WorkerSign> getAllResult(){
		return workerSignMapper.getAllResult();
	}
	
	//1、查询满足未关闭需求的技术方向且n天未跟踪的简历
	public List<Map<String,Object>> demteworkerlist(Map<String,Object> map){
		return workerSignMapper.demteworkerlist(map);
	}
	
	//超期无效
	public int updateOverdue(Map<String,Object> map){
		return workerSignMapper.updateOverdue(map);
	}
	
	public int addList(List<WorkerSign> list){
		return workerSignMapper.addList(list);
	}
	
	//查询待跟踪的列表
	public List<Worker> followworkerlist(Map<String,Object> map){
		return workerSignMapper.followworkerlist(map);
	}
	public int followworkerlistcount(Map<String,Object> map){
		return workerSignMapper.followworkerlistcount(map);
	}
	
	//查询昨日放弃的普工
	public List<Map<String,Object>> giveupworkerlist(Map<String,Object> map){
		return workerSignMapper.giveupworkerlist(map);
	}
}
