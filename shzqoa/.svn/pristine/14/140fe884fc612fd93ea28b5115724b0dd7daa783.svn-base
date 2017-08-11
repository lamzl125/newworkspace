package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.DemandNote;

public interface DemandNoteMapper {
    int deleteByPrimaryKey(String demandnoteid);

    int insert(DemandNote record);

    int insertSelective(DemandNote record);

    DemandNote selectByPrimaryKey(String demandnoteid);

    int updateByPrimaryKeySelective(DemandNote record);

    int updateByPrimaryKey(DemandNote record);
    
    List<Map<String, Object>> getNoteListByMap(Map<String,Object> map);
    
    int getNotesCountByMap(Map<String,Object> map);
}