package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.TemplateMapper;
@Service
public class TemplateService {
	@Resource
	private TemplateMapper templateMapper;
	
	public List<Map<String, Object>> getTemplateListByMap(Map<String, Object> map){
		return templateMapper.getTemplateListByMap(map);
	}
	
	public Integer getTemplateCountByMap(Map<String, Object> map){
		return templateMapper.getTemplateCountByMap(map);
	}
	
	
	
}
