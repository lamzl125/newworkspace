package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.JianLiDetails;

/*
 * 简历详情统计接口
 */
public interface JianLiDetailsMapper {
	List<JianLiDetails> selectJianLiDetails(Map<String, Object> map);//根据用户ID统计出对应的简历详情
}
