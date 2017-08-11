package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.SalarySet;

public interface SalarySetMapper {
	int insertSalarySet(SalarySet info);
	
	List<SalarySet> getAllSalarySet(Map<String,Object> map);  
	
	Integer getAllSalarySetCount(Map<String,Object> map); 

	SalarySet getSalarySetById(String id);
	
	int updateSalarySetById(SalarySet info);
	
	int delSalarySetById(String id);
	
	int updateStatusByCustomerCode(String customerCode);
	
	List<Map<String,Object>> getSalaryList(Map<String,Object> map);
	
	int getSalaryListCount(Map<String,Object> map);
	
}
