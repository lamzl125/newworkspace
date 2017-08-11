package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.ItemManagement;
import com.shzqoa.model.Items;
import com.shzqoa.model.ResumeSource;

public interface ResumeSourceMapper {
	int insertResumeSource(ResumeSource info);
	
	List<ResumeSource> getAllResumeSource(Map<String,Object> map);  
	
	Integer getAllResumeSourceCount(Map<String,Object> map); 

	ResumeSource getResumeSourceById(Integer id);
	
	int updateResumeSourceById(ResumeSource info);
	
	int delResumeSourceById(Integer id);
	
	List<ResumeSource> getResumeSourceList();

	List<Map<String, Object>> getAllItems(Map<String,Object> map);

	Integer getAllItemsCount(Map<String, Object> map);

	Integer delItemsById(String id);

	Map<String, Object> getItemById(String id);

	Items getItemModelById(String id);

	Integer updateItemById(Items info);

	Integer insertItem(Items info);

	Integer delmanagerById(String id);

	Map<String, Object> getmanagItemById(String id);

	ItemManagement getItemmanageModelById(String id);

	Integer updatemanagerItemById(ItemManagement info);

	Integer insertItemmanagement(ItemManagement info);

	//获取未归还物品列表
	public List<Map<String,Object>> getNotReturnList();

	Integer getAllResumeSourceByresumesourceid(String resumesourceid);
}
