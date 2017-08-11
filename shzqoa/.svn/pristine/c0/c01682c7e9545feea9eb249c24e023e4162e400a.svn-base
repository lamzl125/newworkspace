package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.AgentMapper;
import com.shzqoa.model.Agent;
@Service
public class AgentService {
	@Resource
	private AgentMapper agentMapper;
	
	public List<Agent> getAllAgent(){
		return agentMapper.getAllResult();
	}
	public Agent getAgentById(String agentId){
		return agentMapper.getResultById(agentId);
	}
	public Integer getAgentCountByMap(Map<String, Object> map){
		return agentMapper.getResultCountByMap(map);
	}
	public List<Map<String, Object>> getAgentByMap(Map<String, Object> map){
		return agentMapper.getResultByMap(map);
	}
	public int update(Agent info){
		return agentMapper.update(info);
	}
	public int deleteById(String agentId){
		return agentMapper.deleteById(agentId);
	}
	public int save(Agent info){
		return agentMapper.save(info);
	}
}
