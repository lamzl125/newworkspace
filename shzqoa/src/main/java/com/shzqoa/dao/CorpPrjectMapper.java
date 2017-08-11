package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.controller.CorporatepartnersController;
import com.shzqoa.model.CorpContant;
import com.shzqoa.model.CorpProject;


public interface CorpPrjectMapper {
	
	List<CorpProject> getAllCorpProjectByCropCode(Map<String,Object> map);
	List<CorpContant> getAllCorpContantByCropCode(Map<String,Object> map);
	
	Integer getCorpProjectCount(Map<String,Object> map); 
	
	int insertCorpProject(CorpProject info);
	int insertCorpContant(CorpContant info);
	
	public List<CorpProject> queryProjectByCorpCode(String corpCode);
	Integer getCorpContantCount(Map<String, Object> map);
	public int deletecontent(String Id);
	public List<Map<String,Object>> selectcorpcontantById(String Id);
	 public int updatecorpcontant(CorpContant info);
	 public CorpContant getcorpcontantById(String Id);
}
