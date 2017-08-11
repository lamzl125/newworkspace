package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.Corp;

public interface CorpMapper {
	List<Corp> getAllCorp(Map<String,Object> map);  //获取所有的地区信息
	
	Integer getAllCoropsCount(Map<String,Object> map);  //获取所有的地区信息

	int insertCorp(Corp area);
	
	Corp getCorpById(String areaid);
	
	List<Corp> getCorpList();
	
	List<Map<String,Object>> overdueCue(); // 过期合作公司提示
	
	public int closeCorp(Corp  info);
	
}



