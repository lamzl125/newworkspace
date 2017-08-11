package com.shzqoa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.shzqoa.dao.AllotjoincustomerMapper;
import com.shzqoa.dao.InterViewMapper;
import com.shzqoa.dao.TaskMapper;
import com.shzqoa.dao.TaskjoinCustomerMapper;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.InterView;
import com.shzqoa.model.Task;
import com.shzqoa.model.TaskjoinCustomer;

@Service
public class TaskService {
	
	@Resource
	private TaskMapper taskMapper;
	@Resource
	private TaskjoinCustomerMapper taskjoinMapper; 
	@Resource
	private InterViewMapper interMapper;
	@Resource
	private AllotjoincustomerMapper allotjoincustomerMapper;

	@Transactional
	public int saveTasks(List<Task> list){
		if(list != null && list.size()>0){
			return taskMapper.saveTasks(list);
		}
		return 0;
	}
	
	@Transactional
	public int deleteTasks(List<Task> list){
		if(list != null && list.size()>0){
			return taskMapper.deleteTasks(list);
		}
		return 0;
	}
	
	public List<Task> queryByParams(Map<String, Object> params){
		if(params != null){
			return taskMapper.queryByParams(params);
		}
		return null;
	}

	public Task queryByTask(Task task){
		if(task != null){
			return taskMapper.queryByTask(task);
		}
		return null;
	}
	
	public List<Map<String, Object>> queryTaskAllotByUserCode(Map<String, Object> params){
		if(params != null){
			return this.taskMapper.queryTaskAllotByUserCode(params);
		}
		return null;
	}
	
	public int queryCountByUserCode(Map<String, Object> params){
		int i = 0;
		if(params != null){
			i = this.taskMapper.queryCountByUserCode(params);
		}
		return i;
	}
	
	public List<CustomerInfo> queryCustomerInterview(Map<String, Object> params){
		if(params != null){
			return taskMapper.queryCustomerInterview(params);
		}
		return null;
	}
	
//	public int saveTaskJoin(String  taskallotid,String customercode){
//		Map<String, Object> map=new HashMap<String, Object>();
//		Map<String, Object> Nmap=new HashMap<String, Object>();
//		List<String> list=Arrays.asList(customercode.split(","));
//		Nmap.put("list", list);
//		List<InterView> customercode1=taskjoinMapper.selectTaskJoin(Nmap);
//		map.put("customercode",customercode1);
//		map.put("taskallotid", taskallotid);
//		return taskjoinMapper.saveTaskjoins(map);
//	}
	@Transactional
	public boolean saveInter(String taskallotid, String  customercodes){
		List<String> list1=Arrays.asList(customercodes.split(","));
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		List<Map<String, String>> taskjoincustomerList = new ArrayList<Map<String,String>>();
		for(int i=0;i<list1.size();i++){
			UUID uuid = UUID.randomUUID();
			String customercode = list1.get(i);
			String issuccess = "0";
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", uuid.toString());
			map.put("taskallotid", taskallotid);
			map.put("customercode", customercode);
			map.put("issuccess", issuccess);
			list.add(map);
		}
		for(int i=0;i<list.size();i++){
			String interviewid = list.get(i).get("id");
			Map<String, String> map = new HashMap<String, String>();
			map.put("interviewid", interviewid);
			map.put("taskallotid", taskallotid);
			taskjoincustomerList.add(map);
		} 
		allotjoincustomerMapper.saveList(list);
		int n = taskjoinMapper.saveTaskjoins(taskjoincustomerList);
		if(n>0){
			int m = interMapper.saveinter(list);
			return true;
		}else{
			int d = interMapper.deleteinters(list);
			return false;
		}
	}
	public List<Map<String, Object>> queryTaskAllotByUser(String userid){
		if(userid != null){
			return this.taskMapper.queryTaskAllotByUser(userid);
		}
		return null;
	}
}
