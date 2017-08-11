package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shzqoa.dao.JianLiMapper;
import com.shzqoa.model.JianLi;

@Service
public class JianLiService {
	@Resource
	JianLiMapper jianLiMapper;
	/**
	 * 根据简历来源--操作员-统计简历数目
	 * @param map
	 * @return
	 */
	public List<JianLi> selectCountByResume(Map<String,Object> map){
		return jianLiMapper.selectCountByResume(map);
	}
	/*public List<JianLi> selectCountByResume(JianLi jianli){
		return jianLiMapper.selectCountByResume(jianli);
	}*/
	/**
	 * 统计数据总数-分页
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map){
		return jianLiMapper.getCount(map);
	}
}




