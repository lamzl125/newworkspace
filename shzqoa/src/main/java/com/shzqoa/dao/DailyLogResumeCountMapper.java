package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.model.DailyLogResumeCount;


public interface DailyLogResumeCountMapper {
	@Transactional
	int addInfoList(List<DailyLogResumeCount> list);
	
	List<DailyLogResumeCount> getAllList(Map<String,Object> map);
}



