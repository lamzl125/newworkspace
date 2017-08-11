package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.DemandNoteStatistics;

public interface DemandNoteStatisticsMapper {
    int deleteByPrimaryKey(String statisticsid);

    int insert(DemandNoteStatistics record);

    int insertSelective(DemandNoteStatistics record);

    DemandNoteStatistics selectByPrimaryKey(String statisticsid);

    int updateByPrimaryKeySelective(DemandNoteStatistics record);

    int updateByPrimaryKey(DemandNoteStatistics record);
    
    public List<Map<String, Object>> getNoteStatisticsListByMap(Map<String,Object> map);
    
    
    public int getNotesStatisticsCountByMap(Map<String,Object> map);
    
    
    
    public List<Map<String, Object>> getNoteDayPageViewByMap(Map<String,Object> map);
    public int getNoteDayPageViewCountByMap(Map<String,Object> map);
    
    
    public List<Map<String, Object>> getUserNotePVByMap(Map<String,Object> map);
    public int getUserNotePVCountByMap(Map<String,Object> map);
    
}