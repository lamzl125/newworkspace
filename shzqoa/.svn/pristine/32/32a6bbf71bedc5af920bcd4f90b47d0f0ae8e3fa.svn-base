package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.DailyLog;

public interface DailyLogMapper {
	
	int addWorkLog(DailyLog dailyLog); //添加工作日志
	
	List<DailyLog> sltDailyLogs(Map<String,Object> map); // 工作日志列表
	
	int sltDailyLogNum(Map<String,Object> map); // 工作日志数量
	
	DailyLog sltdailylogbyid(Integer dailylogid);// 单条日志详情
	
	int updateWorkLog(Map<String,Object> map);
	
	//问题建议列表
	List<Map<String,Object>> sltProblems(Map<String,Object> map);
	
	int sltProblemscount(Map<String,Object> map);
	
	
	public List<Map<String,Object>> getWeiXinListByMap(Map<String,Object> map);
	public int getWeiXinListCountByMap(Map<String,Object> map);
}



