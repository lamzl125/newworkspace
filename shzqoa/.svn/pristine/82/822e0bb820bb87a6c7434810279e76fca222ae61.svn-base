package com.shzqoa.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shzqoa.dao.CustomerProjectMapper;
import com.shzqoa.model.CustomerProject;

@Service
public class CustomerProjectService {
	private final Logger log = Logger.getLogger(CustomerProjectService.class);
	@Resource
	private CustomerProjectMapper customerProjectMapper;
	
	public int insertList(List<CustomerProject> prolist){
		return customerProjectMapper.insertList(prolist);
	}
	
	public Map<String,Object> getCustProByCustomerCode(String customercode) {  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customercode", customercode);
		
		List<CustomerProject> list = customerProjectMapper.getObjListByMap(map);  
		map.put("list", list);
		return map;
    } 
	
	
    
   
}




