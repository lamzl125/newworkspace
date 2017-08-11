package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.TrainSchool;


public interface TrainShoolMapper {	
	
	public List<TrainSchool> getAllTrainSchool();
	public TrainSchool getTrainSchoolById(String trainSchoolId);
	public int deleteById(String trainSchoolId);
	public int update(TrainSchool info);
	public int save(TrainSchool info);
	public List<TrainSchool> getTrainSchoolByMap(Map<String,Object> map);
	public int getTrainSchoolCountByMap(Map<String,Object> map);
	
}
