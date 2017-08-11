package com.shzqoa.dao;

import java.util.Map;

import com.shzqoa.model.DemandResumeRelation;

public interface DemandResumeRelationMapper {
	public int insertDemandResumeRelation(DemandResumeRelation demandResumeRelation);

	public int selectSame(Map<String,Object> map);
}
