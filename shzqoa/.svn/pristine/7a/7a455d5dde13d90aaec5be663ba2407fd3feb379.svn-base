package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.GradeMapper;
import com.shzqoa.model.Grade;

@Service
public class GradeService {
	
	@Resource
	private GradeMapper gradeMapper;
	
	public List<Grade> queryAll(){
		return gradeMapper.queryAll();
	}
	
	public int addGrade(Grade grade)
	{
		return gradeMapper.addGrade(grade);
	}
	
	public int deleteGrade(String gradeId){
		return gradeMapper.deleteGrade(gradeId);
	}
	
	public Map<String,Object> getGradeByPage(int start,int page,int pageSize){
		Map<String,Object> pmap = new HashMap<String,Object>();
		pmap.put("start", start);
		pmap.put("pageSize", pageSize);
		Map<String,Object> rmap = new HashMap<String,Object>();
		int total = gradeMapper.getAllGradeCount();
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}	
		rmap.put("total", total);
		rmap.put("tatalpage", tatalpage);
		rmap.put("currpage", page);
		rmap.put("list", gradeMapper.selctByPage(pmap));
		return rmap;
	}
}
