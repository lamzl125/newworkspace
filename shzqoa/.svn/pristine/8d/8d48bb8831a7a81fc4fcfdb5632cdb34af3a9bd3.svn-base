package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.shzqoa.dao.CorpPrjectMapper;
import com.shzqoa.model.CorpContant;
import com.shzqoa.model.CorpProject;

@Service
public class CorpProjectService {
	@Resource
	private CorpPrjectMapper corpPrjectMapper;
	
    public List<CorpProject> getAllCorpProjectByCropCode(Map<String,Object> map){
    	return corpPrjectMapper.getAllCorpProjectByCropCode(map);
    }
    public List<CorpContant> getAllCorpContantByCropCode(Map<String,Object> map){
    	return corpPrjectMapper.getAllCorpContantByCropCode(map);
    }
    public Integer getCorpProjectCount(Map<String,Object> map){
		return corpPrjectMapper.getCorpProjectCount(map);
	}
    public Integer getCorpContantCount(Map<String,Object> map){
		return corpPrjectMapper.getCorpContantCount(map);
	}
    
    public int insertCorpProject(CorpProject  info){
		return corpPrjectMapper.insertCorpProject(info);
	}
    
    public int insertCorpContant(CorpContant  info){
		return corpPrjectMapper.insertCorpContant(info);
	}
    
    public List<CorpProject> queryProjectByCorpCode(String corpCode){
    	List<CorpProject> list = null;
    	if(StringUtils.isNotBlank(corpCode)){
    		list = corpPrjectMapper.queryProjectByCorpCode(corpCode);
    	}
    	return list;
    }
    public int deletecontent(String Id){
    	return corpPrjectMapper.deletecontent(Id);
    }
    public Map<String, Object> selectcorpcontantById(String Id){
    	return corpPrjectMapper.selectcorpcontantById(Id).get(0);
    }
    public int updatecorpcontant(CorpContant info){
    	return corpPrjectMapper.updatecorpcontant(info);
    }
    public CorpContant getcorpcontantById(String Id){
    	return corpPrjectMapper.getcorpcontantById(Id);
    }
    
}
