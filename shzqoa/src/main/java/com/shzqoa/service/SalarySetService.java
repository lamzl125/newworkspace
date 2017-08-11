package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.SalarySetMapper;
import com.shzqoa.model.SalarySet;

@Service
public class SalarySetService {
	@Resource
	private SalarySetMapper salarySetMapper;
	
	public List<SalarySet> getAllSalarySet(Map<String,Object> map){
		return salarySetMapper.getAllSalarySet(map);
	}
	public Integer getAllSalarySetCount(Map<String,Object> map){
		return salarySetMapper.getAllSalarySetCount(map);
	}
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public Integer insertSalarySet(SalarySet  info){
		int sult = salarySetMapper.updateStatusByCustomerCode(info.getCustomercode());
		sult = salarySetMapper.insertSalarySet(info);
		if (sult == 0) {
            throw new RuntimeException("插入失败");
        }
		return sult;
	}
	
	public SalarySet getSalarySetById(String id){
		return salarySetMapper.getSalarySetById(id);
	}
	
	public Integer delSalarySetById(String id){
		return salarySetMapper.delSalarySetById(id);
	}
	public Integer updateSalarySetById(SalarySet  info){
		return salarySetMapper.updateSalarySetById(info);
	}
	public List<Map<String,Object>> getSalaryList(Map<String,Object> map){
		return salarySetMapper.getSalaryList(map);
	}
	public Integer getSalaryListCount(Map<String,Object> map){
		return salarySetMapper.getSalaryListCount(map);
	}
  
}
