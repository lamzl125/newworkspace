package com.shzqoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.DemandResumeMapper;
import com.shzqoa.model.DemandResume;
import com.shzqoa.util.SerialNumber;

@Service
public class DemandResumeService {
	@Resource
	private DemandResumeMapper demandResumeMapper;
	public List<Map<String,Object>> laststatusdemandResume(String demandId){
		return demandResumeMapper.laststatusdemandResume(demandId);
	}
	
	public List<Map<String,Object>> demandResumeOfDemand(String demandId){
		return demandResumeMapper.demandResumeOfDemand(demandId);
	}
	
	public List<Map<String,Object>> demandResumeOfDemandMap(Map<String,Object> map){
		return demandResumeMapper.demandResumeOfDemandMap(map);
	}
	
	public int demandResumeOfDemandCount(Map<String,Object> map){
		return demandResumeMapper.demandResumeOfDemandCount(map);
	}

	public List<DemandResume> selectDemandResumeBySignId(String demandSignId){
		return demandResumeMapper.selectDemandResumeBySignId(demandSignId);
	}
	
	public List<Map<String,Object>> selectDemandResumeByDemand(String demandId){
		return demandResumeMapper.selectDemandResumeByDemand(demandId);
	}
	
	public DemandResume stlObjectById(String id){
		return demandResumeMapper.stlObjectById(id);
	}
	
	
	/*public List<DemandResume> getDemandResumeList(){
    	return demandResumeMapper.getDemandResumeList();
    }
	
	public List<DemandResume> getDemandResumeListByUserCode(String demandSignId){
    	return demandResumeMapper.getDemandResumeListByUserCode(demandSignId);
    }
	
	public int getDemandResumeCounttByResume(String customerCode){
    	return demandResumeMapper.getDemandResumeCounttByResume(customerCode);
    }*/
	
	public int delDemandResumeByDemandSign(String demandSignId){
    	return demandResumeMapper.delDemandResumeByDemandSign(demandSignId);
    }
    
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public int setDemandResume(String demandSignId,String[] resumecodes,String userCode){
    	Map<String,Object> conMap = new HashMap<String,Object>();
//    	int delCount = demandResumeMapper.delDemandResumeByDemandSign(demandSignId);    	
    	List<DemandResume> list = new ArrayList<DemandResume>();
    	if(resumecodes!=null && resumecodes.length>0){
    		for(int i=0;i<resumecodes.length;i++){
    			DemandResume info = new DemandResume();
    			info.setBindPeople(userCode);
    			info.setBindTime(new Date());
    			info.setCustomerCode(resumecodes[i]);
    			info.setDemandSignId(demandSignId);
    			info.setId(SerialNumber.createSerial("dere", 5));
    			list.add(info);
    		}
    		int upCount = demandResumeMapper.insertDemandResumeList(list);
        	if (upCount == 0) {
                throw new RuntimeException("upCount is 0;");
            }
        	return upCount;
    	}
    	return 0;
    }
    /* 
   public List<Map<String,Object>> getUserGroupMapByUsercode(Map<String,Object> map){
    	return userGroupMapper.getUserGroupMapByUsercode(map);
    }*/
	
}
