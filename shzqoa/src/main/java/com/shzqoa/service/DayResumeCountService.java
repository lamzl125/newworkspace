package com.shzqoa.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.DayResumeCountMapper;
import com.shzqoa.model.DayResumeCount;
@Service
public class DayResumeCountService {
	@Resource
	private DayResumeCountMapper dayResumeCountMapper;
	
	public List<DayResumeCount> getAllList(Map<String,Object> map){
		return  dayResumeCountMapper.getAllList(map);
	}
	public Integer getAllListCount(Map<String,Object> map){
		return dayResumeCountMapper.getAllListCount(map);
	}
	
	public int addDayresumeCount(DayResumeCount  info){
		return dayResumeCountMapper.insertDayResumeCount(info);
	}
	public int delete(String aid){
		return dayResumeCountMapper.delDayResumeCount(aid);
	}
	public DayResumeCount getDayResumeCountById(String id){
		return dayResumeCountMapper.getDayResumeCountById(id);
	}
	public int updateDayResumeCount(DayResumeCount  info){
		return dayResumeCountMapper.updateDayResumeCount(info);
	}
	public List<Date> getAllRecordDate(){
		return dayResumeCountMapper.getAllRecordDate();
	}
}
