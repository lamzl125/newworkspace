package com.shzqoa.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.DemandResumeRelationMapper;
import com.shzqoa.model.DemandResumeRelation;

@Service
public class DemandResumeRelationService {
	@Resource
	private DemandResumeRelationMapper demandResumeRelationMapper;

	public int insertDRR(DemandResumeRelation demandResumeRelation){
		return  demandResumeRelationMapper.insertDemandResumeRelation(demandResumeRelation);
	}
	
	public int selectSame(Map<String,Object> map){
		return demandResumeRelationMapper.selectSame(map);
	}
}
