package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.ServicerOnLineMapper;
import com.shzqoa.model.ServicerOnLine;

@Service
public class ServicerOnLineService {
	@Resource
	private ServicerOnLineMapper servicerOnLineMapper;
	
	public int insertServicerOnLine(ServicerOnLine  info){
		return servicerOnLineMapper.insertServicerOnLine(info);
	}
	public List<ServicerOnLine> getAllServicerOnLine(Map<String,Object> map){
		return servicerOnLineMapper.getAllServicerOnLine(map);
	}
	public Integer getAllServicerOnLineCount(Map<String,Object> map){
		return servicerOnLineMapper.getAllServicerOnLineCount(map);
	}
	public Integer delServicerOnLineById(String id){
		return servicerOnLineMapper.delServicerOnLineById(id);
	}
	public ServicerOnLine getServicerOnLineById(String id){
		return servicerOnLineMapper.getServicerOnLineById(id);
	}
	public int updateServicerOnLine(ServicerOnLine  info){
		return servicerOnLineMapper.updateServicerOnLine(info);
	}
	
}





