package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.EnterpriseMapper;
import com.shzqoa.model.Enterprise;

@Service
public class EnterpriseService {
	@Resource
	private EnterpriseMapper enterpriseMapper;
	
	public List<Enterprise> getAllEnterprise(Map<String,Object> map){
		return enterpriseMapper.getAllEnterprise(map);
	}
	public Integer getAllEnterpriseCount(Map<String,Object> map){
		return enterpriseMapper.getAllEnterpriseCount(map);
	}
	public Enterprise getEnterpriseById(String enterpriseId){
		return enterpriseMapper.getEnterpriseById(enterpriseId);
	}
	public int insertEnterprise(Enterprise  info){
		return enterpriseMapper.insertEnterprise(info);
	}
	public int updateEnterprise(Enterprise  info){
		return enterpriseMapper.updateEnterprise(info);
	}
	public int delEnterprise(String enterpriseId){
		return enterpriseMapper.delEnterprise(enterpriseId);
	}
}





