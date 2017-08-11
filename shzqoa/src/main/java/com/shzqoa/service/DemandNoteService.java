package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.DemandNoteMapper;
import com.shzqoa.model.DemandNote;
@Service
public class DemandNoteService {
	@Resource
	private DemandNoteMapper demandNoteMapper;
	
	public int deleteByPrimaryKey(String demandnoteid){
		return demandNoteMapper.deleteByPrimaryKey(demandnoteid);
	}

	public int insert(DemandNote record){
    	return demandNoteMapper.insert(record);
    }

	public int insertSelective(DemandNote record){
    	return demandNoteMapper.insertSelective(record);
    }

    public DemandNote selectByPrimaryKey(String demandnoteid){
    	return demandNoteMapper.selectByPrimaryKey(demandnoteid);
    }

    public  int updateByPrimaryKeySelective(DemandNote record){
    	return demandNoteMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(DemandNote record){
    	return demandNoteMapper.updateByPrimaryKey(record);
    }
    
    public List<Map<String, Object>> getNoteListByMap(Map<String,Object> map){
    	return demandNoteMapper.getNoteListByMap(map);
    }
    public int getNotesCountByMap(Map<String,Object> map){
    	return demandNoteMapper.getNotesCountByMap(map);
    }
	
}
