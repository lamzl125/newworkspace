package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.SalaryMapper;
import com.shzqoa.model.Salary;

@Service
public class SalaryService {
	@Resource
	private SalaryMapper salaryMapper;
	
	public List<Salary> getSalaryByMonth(Map<String,Object> map){
		return salaryMapper.getSalaryByMonth(map);
	}
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public Integer insertSalaryList(List<Salary> list){
		int sult = salaryMapper.insertSalaryList(list);
		if (sult == 0) {
            throw new RuntimeException("插入失败");
        }
		return sult;
	}
	public List<Map<String,Object>> getSalaryList(Map<String,Object> map){
		return salaryMapper.getSalaryList(map);
	}
	public Integer getSalaryListCount(Map<String,Object> map){
		return salaryMapper.getSalaryListCount(map);
	}
  
}
