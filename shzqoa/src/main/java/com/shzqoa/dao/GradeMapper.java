package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.Grade;

public interface GradeMapper {
	
	public List<Grade> queryAll();
	
	public int addGrade(Grade grade);
	
	public int deleteGrade(String gradeId);
	
	public List<Grade> selctByPage(Map<String,Object> paraMap);
	
	public int getAllGradeCount();
}
