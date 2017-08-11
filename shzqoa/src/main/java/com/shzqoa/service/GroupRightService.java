package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.GroupRightMapper;
import com.shzqoa.model.GroupRight;
import com.shzqoa.model.UserGroup;

@Service
public class GroupRightService {
	@Resource
	private GroupRightMapper groupRightMapper;
	
	 
    public List<GroupRight> getGroupRightList(){
    	return groupRightMapper.getGroupRightList();
    }
    
    public List<GroupRight> getGroupRightListByGroupId(String groupid){
    	return groupRightMapper.getGroupRightListByGroupId(groupid);
    }
    
    public int delGroupRightByGroupId(String groupid){
    	return groupRightMapper.delGroupRightByGroupId(groupid);
    }
    
    public int getGroupRightCountByRightId(String rightid){
    	return groupRightMapper.getGroupRightCountByRightId(rightid);
    }
    
    
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int setGroupRight(String groupid,String[] rightids){
    	Map<String,Object> conMap = new HashMap<String,Object>();
    	int delCount = groupRightMapper.delGroupRightByGroupId(groupid);
    	conMap.put("groupid", groupid);
    	conMap.put("rightids", rightids);
    	int upCount = groupRightMapper.insertGroupRightList(conMap);
    	if (upCount == 0) {
            throw new RuntimeException("upCount is 0;");
        }
    	return upCount;
    }
    
}
