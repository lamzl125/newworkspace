package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Task;

public interface TaskMapper {

	public int saveTasks(List<Task> list);

	public int deleteTasks(List<Task> list);
	
	public List<Task> queryByParams(Map<String, Object> params);
	
	public Task queryByTask(Task task);
	
	public List<Map<String, Object>> queryTaskAllotByUserCode(Map<String, Object> params);
	
	public int queryCountByUserCode(Map<String, Object> params);
	
	public List<CustomerInfo> queryCustomerInterview(Map<String, Object> params);
	
	public List<Map<String,Object>> queryTaskAllotByUser(String userid);
}
