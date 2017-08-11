package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.JianLiMapper;
import com.shzqoa.dao.ResumeSourceMapper;
import com.shzqoa.model.ResumeOfOpt;
import com.shzqoa.model.ResumeOfSource;
import com.shzqoa.model.ResumeSource;

@Service
public class ResumeSourceService {
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
	public Integer getAllResumeSourceByresumesourceid(String resumesourceid){
		return resumeSourceMapper.getAllResumeSourceByresumesourceid(resumesourceid);
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
    
    public Integer delmanagerById(String id){
		return resumeSourceMapper.delmanagerById(id);
	}
}
