package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.JianLiMapper;
import com.shzqoa.dao.ResumeSourceMapper;
import com.shzqoa.model.ItemManagement;
import com.shzqoa.model.Items;
import com.shzqoa.model.ResumeOfOpt;
import com.shzqoa.model.ResumeOfSource;
import com.shzqoa.model.ResumeSource;

@Service
public class ItemsService {
	@Resource
	private ResumeSourceMapper resumeSourceMapper;
	@Resource
	private JianLiMapper jianLiMapper;
	
	public List<ResumeSource> getAllResumeSource(Map<String,Object> map){
		return resumeSourceMapper.getAllResumeSource(map);
	}
	public Integer getAllResumeSourceCount(Map<String,Object> map){
		return resumeSourceMapper.getAllResumeSourceCount(map);
	}
	public Integer insertResumeSource(ResumeSource  info){
		return resumeSourceMapper.insertResumeSource(info);
	}
	
	public ResumeSource getResumeSourceById(Integer id){
		return resumeSourceMapper.getResumeSourceById(id);
	}
	
	public Integer delResumeSourceById(Integer id){
		return resumeSourceMapper.delResumeSourceById(id);
	}
	public Integer updateResumeSourceById(ResumeSource  info){
		return resumeSourceMapper.updateResumeSourceById(info);
	}
	 
    public List<ResumeSource> getResumeSourseList(){
    	return resumeSourceMapper.getResumeSourceList();
    }
    
    public List<ResumeOfSource> selectCountByRes(Map<String,Object> map){
    	return 	jianLiMapper.selectCountByRes(map);
    }
    
    public List<ResumeOfOpt> selectCountByOpt(Map<String,Object> map){
    	return 	jianLiMapper.selectCountByOpt(map);
    }
    public List<Map<String,Object>> getAllItems(Map<String,Object> map){
    	return resumeSourceMapper.getAllItems(map);
    }
    public Integer getAllItemsCount(Map<String,Object> map){
		return resumeSourceMapper.getAllItemsCount(map);
	}
    public Integer delItemsById(String id){
		return resumeSourceMapper.delItemsById(id);
	}
    public Map<String,Object> getItemById(String id){
		return resumeSourceMapper.getItemById(id);
	}
    public Items getItemModelById(String id){
		return resumeSourceMapper.getItemModelById(id);
	}
    
    public Integer updateItemById(Items  info){
		return resumeSourceMapper.updateItemById(info);
	}
    
    public Integer insertItem(Items  info){
		return resumeSourceMapper.insertItem(info);
	}
    public Map<String,Object> getmanagItemById(String id){
		return resumeSourceMapper.getmanagItemById(id);
	}
    
    public ItemManagement getItemmanageModelById(String id){
  		return resumeSourceMapper.getItemmanageModelById(id);
  	}
    public Integer updatemanagerItemById(ItemManagement  info){
		return resumeSourceMapper.updatemanagerItemById(info);
	}
    public Integer insertItemmanagement(ItemManagement  info){
		return resumeSourceMapper.insertItemmanagement(info);
	}
    //获取未归还物品列表
    public List<Map<String,Object>> getNotReturnList(){
		return resumeSourceMapper.getNotReturnList();
	}
}
