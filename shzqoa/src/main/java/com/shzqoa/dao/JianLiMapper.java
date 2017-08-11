package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.JianLi;
import com.shzqoa.model.ResumeOfOpt;
import com.shzqoa.model.ResumeOfSource;

/**
 * 简历操作接口
 * 
 * @author ThinkPad
 *
 */
public interface JianLiMapper {
	// 根据简历来源--操作员-统计简历数目
	List<JianLi> selectCountByResume(Map<String, Object> map);

	// 统计总数目-分页
	Integer getCount(Map<String, Object> map);
	
	List<ResumeOfSource> selectCountByRes(Map<String, Object> map);
	
	List<ResumeOfOpt> selectCountByOpt(Map<String, Object> map);
	
}
