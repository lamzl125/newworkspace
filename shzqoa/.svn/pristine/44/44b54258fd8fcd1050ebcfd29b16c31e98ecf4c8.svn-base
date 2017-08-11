package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.ProfessionMapper;
import com.shzqoa.model.Areas;
import com.shzqoa.model.Profession;

@Service
public class ProfessionService {

	@Resource
	private ProfessionMapper professionMapper;
	
	public List<Profession> queryAll(){
		return professionMapper.queryAll();
	}
	
	public List<Profession> getAllProfess(Map<String,Object> map){
		return professionMapper.getAllProfess(map);
	}
	public Integer getAllProfessCount(Map<String,Object> map){
		return professionMapper.getAllProfessCount(map);
	}
	
	public int delProfessById(String id){
		return professionMapper.delProfessById(id);
	}
	public Profession getProById(String id){
		return professionMapper.getProById(id);
	}
	public int addProfess(Profession  profession){
		return professionMapper.insertProfess(profession);
	}
	
}
