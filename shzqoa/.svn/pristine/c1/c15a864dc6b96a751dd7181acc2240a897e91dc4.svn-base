package com.shzqoa.dao;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import com.shzqoa.model.Salary;




public interface SalaryMapper {
	List<Salary> getSalaryByMonth(Map<String,Object> map);  
	
	
	@Transactional
	int insertSalaryList(List<Salary> list);
	
	List<Map<String,Object>> getSalaryList(Map<String,Object> map);
	
	
	int getSalaryListCount(Map<String,Object> map);
}
