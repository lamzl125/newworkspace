package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ShoolMapper;
import com.shzqoa.dao.TrainShoolMapper;
import com.shzqoa.dao.TripRecordMapper;
import com.shzqoa.model.School;
import com.shzqoa.model.TrainSchool;
import com.shzqoa.model.TripRecord;
@Service
public class TripRecordService {
	@Resource
	private TripRecordMapper tripRecordMapper;
	
	public int save(TripRecord info){
		return tripRecordMapper.save(info);
	}
	public int deleteById(String tripRecordId){
		return tripRecordMapper.deleteById(tripRecordId);
	}
	public int update(TripRecord info){
		return tripRecordMapper.update(info);
	}
	public List<Map<String, Object>> getTripRecordByMap(Map<String, Object> map){
		return tripRecordMapper.getTripRecordByMap(map);
	}
	public Integer getTripRecordCountByMap(Map<String, Object> map){
		return tripRecordMapper.getTripRecordCountByMap(map);
	}
	public TripRecord getTripRecordById(String tripRecordId){
		return tripRecordMapper.getTripRecordById(tripRecordId);
	}
	public List<TripRecord> getAllTripRecord(){
		return tripRecordMapper.getAllTripRecord();
	}
}
