package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.Parameter;


public interface ParameterMapper {
	
	List<Parameter> getAllParameter(Map<String,Object> map);
	
	Integer getAllParameterCount(Map<String,Object> map); 
	
	int insertParameter(Parameter info);
	
	Parameter getParameterById(Long id);
	
	int updateParameterById(Parameter info);
	
	int delParameterById(Long id);
	
	List<Parameter> getParameterByName(Map<String,Object> map);
	
	List<Parameter> getParameterByIndex(Map<String,Object> map);
	
	List<Parameter> getExitParameterByName(Map<String,Object> map);
	
	List<Parameter> getExitParameterByIndex(Map<String,Object> map);
	
	List<Parameter> selectByName(String paraname);
}
