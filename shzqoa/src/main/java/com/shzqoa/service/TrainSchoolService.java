package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ShoolMapper;
import com.shzqoa.dao.TrainShoolMapper;
import com.shzqoa.model.School;
import com.shzqoa.model.TrainSchool;
@Service
public class TrainSchoolService {
	@Resource
	private TrainShoolMapper trainShoolMapper;
	
	
	public List<TrainSchool> getAllTrainSchool(){
		return trainShoolMapper.getAllTrainSchool();
	}
	public TrainSchool getTrainSchoolById(String trainSchoolId){
		return trainShoolMapper.getTrainSchoolById(trainSchoolId);
	}
	public int deleteById(String trainSchoolId){
		return trainShoolMapper.deleteById(trainSchoolId);
	}
	public int update(TrainSchool info){
		return trainShoolMapper.update(info);
	}
	public int save(TrainSchool info){
		return trainShoolMapper.save(info);
	}
	public List<TrainSchool> getTrainSchoolByMap(Map<String,Object> map){
		return trainShoolMapper.getTrainSchoolByMap(map);
	}
	public int getTrainSchoolCountByMap(Map<String,Object> map){
		return trainShoolMapper.getTrainSchoolCountByMap(map);
	}
}
