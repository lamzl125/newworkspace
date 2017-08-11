package com.shzqoa.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.shzqoa.model.DayResumeCount;



public interface DayResumeCountMapper {
	List<DayResumeCount> getAllList(Map<String,Object> map);
	Integer getAllListCount(Map<String,Object> map);
	
	int insertDayResumeCount(DayResumeCount info);
	
	int delDayResumeCount(String id);
	
	DayResumeCount getDayResumeCountById(String id); 
	
	int updateDayResumeCount(DayResumeCount info);
	
	List<Date> getAllRecordDate();
}
