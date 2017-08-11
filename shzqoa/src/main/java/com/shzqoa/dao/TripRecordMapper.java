package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.TripRecord;

public interface TripRecordMapper {	
	public int save(TripRecord info);
	public int deleteById(String tripRecordId);
	public int update(TripRecord info);	
	public List<Map<String, Object>> getTripRecordByMap(Map<String, Object> map);
	public Integer getTripRecordCountByMap(Map<String, Object> map);
	public TripRecord getTripRecordById(String tripRecordId);
	public List<TripRecord> getAllTripRecord();
	
}
