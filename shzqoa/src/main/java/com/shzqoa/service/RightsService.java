package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.RightsMapper;
import com.shzqoa.model.Areas;
import com.shzqoa.model.Rights;

@Service
public class RightsService {
	@Resource
	private RightsMapper rightsMapper;
	
	public List<Rights> getAllRights(Map<String,Object> map){
		return rightsMapper.getAllRights(map);
	}
	public Integer getAllRightsCount(Map<String,Object> map){
		return rightsMapper.getAllRightsCount(map);
	}
	public Rights getRightById(String rightId){
		return rightsMapper.getRightById(rightId);
	}
	public int addRight(Rights  info){
		return rightsMapper.insertRight(info);
	}
	public Rights getMaxRightIdByParentId(String  parentId){
		return rightsMapper.getMaxRightIdByParentId(parentId);
	}
	public Integer updateRightById(Rights  info){
		return rightsMapper.updateRightById(info);
	}
	public List<Rights> getRightsByUserCode(String usercode){
		return rightsMapper.getRightsByUserCode(usercode);
	}
	public List<Rights> getRightsByParentId(String parentid){
		return rightsMapper.getRightsByParentId(parentid);
	}
}
