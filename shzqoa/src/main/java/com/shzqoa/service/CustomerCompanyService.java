package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.CustomerCompanyMapper;
import com.shzqoa.model.CustomerCompany;

@Service
public class CustomerCompanyService {
	
	@Resource
	private CustomerCompanyMapper customerCompanyMapper;
	
	public List<CustomerCompany> queryAll(Map<String, Object> params){
		return customerCompanyMapper.queryAll(params);
	}
	public int queryCustomerCompanyCount(){
		return customerCompanyMapper.queryCustomerCompanyCount();
	}
	@Transactional
	public int operCheck(Map<String, Object> params){
		return customerCompanyMapper.operCheck(params);
	}
}
