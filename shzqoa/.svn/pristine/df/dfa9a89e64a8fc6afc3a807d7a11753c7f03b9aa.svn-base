package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.ParameterMapper;
import com.shzqoa.model.Parameter;

@Service
public class ParameterService {
	@Resource
	private ParameterMapper parameterMapper;
	
	public List<Parameter> getAllParameter(Map<String,Object> map){
		return parameterMapper.getAllParameter(map);
	}
	public Integer getAllParameterCount(Map<String,Object> map){
		return parameterMapper.getAllParameterCount(map);
	}
	public int addParameter(Parameter  info){
		return parameterMapper.insertParameter(info);
	}
	public Parameter getParameterById(Long id){
		return parameterMapper.getParameterById(id);
	}
	public Integer updateParameterById(Parameter  info){
		return parameterMapper.updateParameterById(info);
	}
	public List<Parameter> getParameterByName(Map<String,Object> map){
		return parameterMapper.getParameterByName(map);
	}
	public List<Parameter> getParameterByIndex(Map<String,Object> map){
		return parameterMapper.getParameterByIndex(map);
	}
	public int delParameterById(Long id){
		return parameterMapper.delParameterById(id);
	}
	/*
	 * 是否存在要修改的名称
	 */
	public List<Parameter> getExitParameterByName(Map<String,Object> map){
		return parameterMapper.getExitParameterByName(map);
	}
	/*
	 * 是否存在要修改的序号
	 */
	public List<Parameter> getExitParameterByIndex(Map<String,Object> map){
		return parameterMapper.getExitParameterByIndex(map);
	}
	/*
	 * 根据基本种类名称获取参数
	 */
	public List<Parameter> selectByName(String paraname){
		return parameterMapper.selectByName(paraname);
	}
}
