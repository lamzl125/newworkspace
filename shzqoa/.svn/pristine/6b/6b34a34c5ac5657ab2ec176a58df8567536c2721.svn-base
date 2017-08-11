package com.shzqoa.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.AreasMapper;
import com.shzqoa.model.Areas;

@Service
public class AreasService {
	@Resource
	private AreasMapper areasMapper;
	
	public List<Areas> getAllAreas(Map<String,Object> map){
		return areasMapper.getAllAreas(map);
	}
	public Integer getAllAreasCount(Map<String,Object> map){
		return areasMapper.getAllAreasCount(map);
	}
	public int addArea(Areas  area){
		return areasMapper.insertArea(area);
	}
	
	public Areas getAreaById(String areaid){
		return areasMapper.getAreasById(areaid);
	}
	
	public int delAreaById(String areaid){
		return areasMapper.delAreaById(areaid);
	}
	 
    public List<Areas> getAreaList(){
    	return areasMapper.getAreaList();
    }
}
