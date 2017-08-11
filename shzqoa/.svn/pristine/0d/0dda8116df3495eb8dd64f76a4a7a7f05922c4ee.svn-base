package com.shzqoa.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.DemandNoteMapper;
import com.shzqoa.dao.DemandNoteStatisticsMapper;
import com.shzqoa.model.DemandNote;
import com.shzqoa.model.DemandNoteStatistics;
@Service
public class DemandNoteStatisticsService {
	@Resource
	private DemandNoteStatisticsMapper demandNoteStatisticsMapper;
	@Resource
	private DemandNoteMapper demandNoteMapper;
	
	public int deleteByPrimaryKey(String statisticsid){
		return demandNoteStatisticsMapper.deleteByPrimaryKey(statisticsid);
	}

	@Transactional
	public int insert(DemandNoteStatistics record){
    	int uprsout =  demandNoteStatisticsMapper.insert(record);
    	DemandNote dn = demandNoteMapper.selectByPrimaryKey(record.getDemandnoteid());
    	dn.setDaypageview(record.getDaypageview());
    	dn.setAllpageview(record.getAllpageview());
    	demandNoteMapper.updateByPrimaryKey(dn);
    	return uprsout;
    }

	public int insertSelective(DemandNoteStatistics record){
    	return demandNoteStatisticsMapper.insertSelective(record);
    }

    public DemandNoteStatistics selectByPrimaryKey(String statisticsid){
    	return demandNoteStatisticsMapper.selectByPrimaryKey(statisticsid);
    }

    public  int updateByPrimaryKeySelective(DemandNoteStatistics record){
    	return demandNoteStatisticsMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DemandNoteStatistics record){
    	return demandNoteStatisticsMapper.updateByPrimaryKey(record);
    }
    
    public List<Map<String, Object>> getNoteStatisticsListByMap(Map<String,Object> map){
    	return demandNoteStatisticsMapper.getNoteStatisticsListByMap(map);
    }
    public int getNotesStatisticsCountByMap(Map<String,Object> map){
    	return demandNoteStatisticsMapper.getNotesStatisticsCountByMap(map);
    }
    
    
    public List<Map<String, Object>> getNoteDayPageViewByMap(Map<String,Object> map){
    	return demandNoteStatisticsMapper.getNoteDayPageViewByMap(map);
    }
    public int getNoteDayPageViewCountByMap(Map<String,Object> map){
    	return demandNoteStatisticsMapper.getNoteDayPageViewCountByMap(map);
    }
	
}
