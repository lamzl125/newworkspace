package com.shzqoa.dao;


import java.util.List;
import java.util.Map;

import com.shzqoa.model.Rights;


public interface RightsMapper {
	List<Rights> getAllRights(Map<String,Object> map);  //获取所有的地区信息
	
	Integer getAllRightsCount(Map<String,Object> map); 
	
	Rights getRightById(String rightId);
	
	int insertRight(Rights info);
	
	Rights getMaxRightIdByParentId(String parentId);
	
	int updateRightById(Rights info);
	
	List<Rights> getRightsByUserCode(String usercode);
	
	List<Rights> getRightsByParentId(String parentid);
}
