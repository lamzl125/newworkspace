package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shzqoa.dao.JianLiDetailsMapper;
import com.shzqoa.model.JianLiDetails;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class JianLiDetailsService {
	@Resource
	JianLiDetailsMapper jianLiDetailsMapper;
	/*
	 * 根据操作人员统计各大平台简历信息详情
	 */
	public Map<String,  Object> selectJianLiDetails(String opertCode){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("opertCode", opertCode);
		List<JianLiDetails> jianLiDetails=jianLiDetailsMapper.selectJianLiDetails(map);
		map.put("jianLiDetails", jianLiDetails);
		return map;
	}
}
