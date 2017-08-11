package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.Task;
import com.shzqoa.model.TaskAllot;
import com.shzqoa.model.Taskcensus;

public interface TaskAllotMapper {

	public int saveTaskAllots(List<TaskAllot> list);
	
	public List<TaskAllot> queryByParams(Map<String, Object> params);
	
	public List<Map<String, Object>> queryTaskAllotDetails(Task task);
	
	public List<Taskcensus> selectAllTask(Map<String, Object> params);
	
	public int selectAllTaskCount(Map<String, Object> params);
	
}
