package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustomerProject;

public interface CustomerProjectMapper {
	public int objlistcount(Map<String,Object> map);
	public CustomerProject getObjById(String custProId);
	public int insertObj(CustomerProject info);
	public int updateObjById(CustomerProject info);	
	public List<CustomerProject> getObjListByMap(Map<String,Object> map);
	
	public int insertList(List<CustomerProject> prolist);


}





