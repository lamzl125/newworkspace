package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.WorkerMapper;
import com.shzqoa.model.Worker;



@Service
public class WorkerService {
	@Resource
	private WorkerMapper workerMapper;
	
	public List<Worker> getAllWorker(){
		return workerMapper.getAllWorker();
	}	
	public Worker getWorkerById(String demandId){
		return workerMapper.getWorkerById(demandId);
	}
	
	public int deleteById(String workerId){
		return workerMapper.deleteById(workerId);
	}
	public int update(Worker info){
		return workerMapper.update(info);
	}
	public int save(Worker info){
		return workerMapper.save(info);
	}
	public List<Worker> getWorkerByMap(Map<String,Object> map){
		return workerMapper.getWorkerByMap(map);
	}
	public int getWorkerCountByMap(Map<String,Object> map){
		return workerMapper.getWorkerCountByMap(map);
	}
	
	public List<Worker> getSelectWorker(String demandId){
		return workerMapper.getSelectWorker(demandId);
	}
	
	
	public List<Map<String,Object>> getWorkerDemandByMap(Map<String,Object> map){
		return workerMapper.getWorkerDemandByMap(map);
	}
	
}
