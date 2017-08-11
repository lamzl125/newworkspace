package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.ParameterKind;


public interface ParameterKindMapper {
	
	List<ParameterKind> getAllParameterKind(Map<String,Object> map);
	
	Integer getAllParameterKindCount(Map<String,Object> map); 
	
	int insertParameterKind(ParameterKind info);
	
	ParameterKind getParameterKindById(Long parakindid);
	
	int updateParameterKindById(ParameterKind info);
	
	int delParameterKindById(Long parakindid);
	
	List<ParameterKind> getParameterKindByName(String parakindname);
	
	List<ParameterKind> getParameterKindByIndex(Integer orderindex);
	
	List<ParameterKind> getExitParameterKindByName(Map<String,Object> map);
	
	List<ParameterKind> getExitParameterKindByIndex(Map<String,Object> map);
}
