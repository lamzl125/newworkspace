package com.shzqoa.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.shzqoa.dao.TaskAllotMapper;
import com.shzqoa.dao.TaskMapper;
import com.shzqoa.dao.UserMapper;
import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.Task;
import com.shzqoa.model.TaskAllot;
import com.shzqoa.model.Taskcensus;
import com.shzqoa.model.User;
import com.shzqoa.util.ResultObject;

@Service
public class TaskAllotService {
	
	@Resource
	private TaskAllotMapper taskAllotMapper;
	
	@Resource
	private TaskMapper taskMapper;
	
	@Resource
	private UserMapper userMapper;
	
	@Transactional
	public void allotTask(ResultObject result, String taskData, String allotTaskData) throws IllegalAccessException, InvocationTargetException{
		List<Task> taskList = JSON.parseArray(taskData, Task.class);
		List<TaskAllot> allotTaskList = JSON.parseArray(allotTaskData, TaskAllot.class);
		if(taskList != null && taskList.size()>0 && allotTaskList != null && allotTaskList.size()>0){
			List<Task> listTask = new ArrayList<Task>();
			List<TaskAllot> list = new ArrayList<TaskAllot>();
			Map<String, Object> params = new HashMap<String, Object>();
			for(int i=0;i<taskList.size();i++){
				Task t = taskList.get(i);
				t.setStatus("1");
				Task task = taskMapper.queryByTask(t);
				if(task != null && StringUtils.isNotBlank(task.getId())){
					t = task;
					params.put("taskid", t.getId());
				}else{
					UUID uuid = UUID.randomUUID();
					t.setId(uuid.toString());
					listTask.add(t);
				}
				for(int j=0;j<allotTaskList.size();j++){
					TaskAllot ta = allotTaskList.get(j);
					if(params.get("taskid") != null){
						params.put("userid", ta.getUserid());
						List<TaskAllot> item = taskAllotMapper.queryByParams(params);
						if(item != null && item.size()>0){
							//该员工已经添加过该任务
						}else{
							ta.setTaskid(t.getId());
							TaskAllot ta1 = new TaskAllot();
							BeanUtils.copyProperties(ta1, ta);
							list.add(ta1);
						}
					}else{
						ta.setTaskid(t.getId());
						TaskAllot ta1 = new TaskAllot();
						BeanUtils.copyProperties(ta1, ta);
						list.add(ta1);
					}
				}
				params.clear();
			}
			if(listTask.size()>0){
				taskMapper.saveTasks(listTask);
			}
			for(int i=0;i<list.size();i++){
				TaskAllot ta = list.get(i);
				UUID id = UUID.randomUUID();
				ta.setId(id.toString());
				ta.setStatus("0");
			}
			if(list.size()>0){
				int m = this.saveTaskAllots(list);
				if(m>0){
					result.setSuccess(true);
					result.setResultMessage("任务分配成功！"); 
				}else{
					taskMapper.deleteTasks(taskList);
					result.setSuccess(false);
					result.setResultMessage("任务分配失败！"); 
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("该人员已分配过此任务！"); 
			}
		}else{
			result.setSuccess(false);
			result.setResultMessage("任务分配失败！");
		}
	}

	@Transactional
	public int saveTaskAllots(List<TaskAllot> list){
		if(list != null && list.size()>0){
			return taskAllotMapper.saveTaskAllots(list);
		}
		return 0;
	}
	
	public List<Map<String, Object>> queryTaskAllotDetails(Task task){
		if(task != null){
			return taskAllotMapper.queryTaskAllotDetails(task);
		}
		return null;
	}
	public Map<String, Object> TaskList(int page,int pageSize,String opername) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("opername", opername);
		List<User> userlist = userMapper.getAllUsers();
		List<Taskcensus> TaskList=taskAllotMapper.selectAllTask(map);
		int total = taskAllotMapper.selectAllTaskCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("userlist", userlist);
		map.put("total", total);
		map.put("TaskList", TaskList);
		map.put("tatalpage", tatalpage);
		return map;	
	}
}
