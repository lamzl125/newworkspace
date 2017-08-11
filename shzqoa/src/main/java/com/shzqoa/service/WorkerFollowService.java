package com.shzqoa.service;

import java.util.List;
import java.util.Map;




import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.WorkerFollowMapper;
import com.shzqoa.dao.WorkerMapper;
import com.shzqoa.model.Worker;
import com.shzqoa.model.WorkerFollow;
@Service
public class WorkerFollowService {
	@Resource
	private WorkerFollowMapper workerFollowMapper;
	@Resource
	private WorkerMapper workerMapper;
	
	@Transactional
	public int save(WorkerFollow info){
		int resultcount = 0;
		if(info != null){
			resultcount = workerFollowMapper.save(info);
			if(resultcount>0){
				Worker worker = workerMapper.getWorkerById(info.getObjectId());
				worker.setWorkerStatus(info.getObjectStatus());
				resultcount = workerMapper.update(worker);
			}
		}
		return resultcount;
	}
	public int deleteById(String followId){
		if(followId!=null && !"".equals(followId)){
			return this.workerFollowMapper.deleteById(followId);
		}
		return 0;
	}
	public int update(WorkerFollow info){
		if(info != null){
			return workerFollowMapper.update(info);
		}
		return 0;
	}
	public List<WorkerFollow> selWorkerFollow(Map<String, Object> map){
		return workerFollowMapper.selWorkerFollow(map);
	}
	public Integer getWorkerFollowCount(Map<String, Object> map){
		return workerFollowMapper.getWorkerFollowCount(map);
	}
	public WorkerFollow getWorkerFollowById(String followId){
		return workerFollowMapper.getWorkerFollowById(followId);
	}
	
}
