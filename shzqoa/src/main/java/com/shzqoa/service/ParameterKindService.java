package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.ParameterKindMapper;
import com.shzqoa.model.ParameterKind;

@Service
public class ParameterKindService {
	@Resource
	private ParameterKindMapper parameterKindMapper;
	
	public List<ParameterKind> getAllParameterKind(Map<String,Object> map){
		return parameterKindMapper.getAllParameterKind(map);
	}
	public Integer getAllParameterKindCount(Map<String,Object> map){
		return parameterKindMapper.getAllParameterKindCount(map);
	}
	public int addParameterKind(ParameterKind  info){
		return parameterKindMapper.insertParameterKind(info);
	}
	public ParameterKind getParameterKindById(Long parakindid){
		return parameterKindMapper.getParameterKindById(parakindid);
	}
	public Integer updateParameterKindById(ParameterKind  info){
		return parameterKindMapper.updateParameterKindById(info);
	}
	public List<ParameterKind> getParameterKindByName(String parakindname){
		return parameterKindMapper.getParameterKindByName(parakindname);
	}
	public List<ParameterKind> getParameterKindByIndex(Integer orderindex){
		return parameterKindMapper.getParameterKindByIndex(orderindex);
	}
	public int delParameterKindById(Long parakindid){
		return parameterKindMapper.delParameterKindById(parakindid);
	}
	/*
	 * 是否存在要修改的名称
	 */
	public List<ParameterKind> getExitParameterKindByName(Map<String,Object> map){
		return parameterKindMapper.getExitParameterKindByName(map);
	}
	/*
	 * 是否存在要修改的序号
	 */
	public List<ParameterKind> getExitParameterKindByIndex(Map<String,Object> map){
		return parameterKindMapper.getExitParameterKindByIndex(map);
	}
}
