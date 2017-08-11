package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ShoolMapper;
import com.shzqoa.model.School;
@Service
public class SchoolService {
	@Resource
	private ShoolMapper shoolMapper;
	
	@Transactional
	public int save(School info){
		if(info != null){
			return this.shoolMapper.save(info);
		}
		return 0;
	}
	@Transactional
	public int delete(Integer schoolId){
		if(schoolId!=null && schoolId > 0){
			return this.shoolMapper.deleteById(schoolId);
		}
		return 0;
	}
	
	@Transactional
	public int update(School info){
		if(info != null){
			return this.shoolMapper.update(info);
		}
		return 0;
	}
	
	public List<School> selschool(Map<String,Object> map){
		return  shoolMapper.selschool(map);
	}
	public Integer getSchoolCount(Map<String,Object> map){
		return shoolMapper.getSchoolCount(map);
	}
	public School getSchoolById(Integer schoolId){
		return this.shoolMapper.getSchoolById(schoolId);
	}
	public List<School> getAllSchool(){
		return  shoolMapper.getAllSchool();
	}
	
}
