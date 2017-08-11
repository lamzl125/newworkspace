package com.shzqoa.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.WorkTaskMapper;
import com.shzqoa.model.WorkTask;

@Service
public class WorkTaskService {
	@Resource
	private WorkTaskMapper workTaskMapper;
	
	public int batchaddWorkTask(List<WorkTask> workTasklist){
		return workTaskMapper.batchaddWorkTask(workTasklist);
	}
	
	/**
	 * 添加工作任务
	 * @param publishid        // 发布者id
	 * @param publishcontent   // 工作任务内容
	 * @param appointuserid    // 指定完成人员id
	 * @return
	 */
	public int insertWorkTask(String publishid,String publishcontent,String appointuserid,String realname){
		WorkTask workTask = new WorkTask();
		workTask.setPublishid(publishid);
		workTask.setPublishcontent(publishcontent);
		workTask.setAppointuserid(appointuserid);
		workTask.setRealname(realname);
		workTask.setPublishtime(new Date());
		int num = workTaskMapper.insertWorkTask(workTask);
		return num;
	}
	
	/**
	 * 确认工作任务
	 * @param taskid
	 * @return
	 */
	public int confirmWork(int taskid){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("taskid", taskid);
		map.put("confirm", new Date());
		return workTaskMapper.confirmWork(map);
		
	}
	
	/**
	 * 工作任务列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
		Map<String,Object> map = new HashMap<String, Object>();
		public Map<String,Object> intoWorkTask(int page,int pageSize,String appointuserid,Date time){
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("appointuserid", appointuserid);
		map.put("publishtime", time);
		List<WorkTask> workTasks = workTaskMapper.seltWorkTasks(map);
		int total = workTaskMapper.sltWorkTaskNum(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			} else {
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("workTasks", workTasks);
		map.put("tatalpage", tatalpage);
		return map;
	}
	
	/**
	 * 未完成的工作任务列表
	 * @return
	 */
	public List<WorkTask> sltNofinish(String userid){
		return workTaskMapper.sltNofinish(userid);
	}
	
	/**
	 * 是否为发布者(发布过任务)
	 * @param publishid
	 * @return
	 */
	public int ispromulgator(String userid){
		return workTaskMapper.ispromulgator(userid);
		
	}
	
	
	public List<Map<String,Object>> sltTaskByUserDay(Map<String,Object> map){
		return workTaskMapper.sltTaskByUserDay(map);
	}
}




