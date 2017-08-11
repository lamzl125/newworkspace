package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.EnterpriseContactsMapper;
import com.shzqoa.model.EnterpriseContacts;

@Service
public class EnterpriseContactsService {
	@Resource
	private EnterpriseContactsMapper enterpriseContactsMapper;
	
	
	public List<EnterpriseContacts> getAllEnterpriseContacts(Map<String,Object> map){
		return enterpriseContactsMapper.getAllEnterpriseContacts(map);
	}
	public Integer getAllEnterpriseContactsCount(Map<String,Object> map){
		return enterpriseContactsMapper.getAllEnterpriseContactsCount(map);
	}
	public EnterpriseContacts getEnterpriseContactsById(String enterpriseContactsId){
		return enterpriseContactsMapper.getEnterpriseContactsById(enterpriseContactsId);
	}
	public int insertEnterpriseContacts(EnterpriseContacts  info){
		int result = 0;
		if(info.getContactsStatus()==1){
			enterpriseContactsMapper.updateContactsStatusByEnterprise(info.getEnterpriseId());
		}
		result = enterpriseContactsMapper.insertEnterpriseContacts(info);
		return result;		
	}
	public int updateEnterpriseContacts(EnterpriseContacts  info){
		return enterpriseContactsMapper.updateEnterpriseContacts(info);
	}
	public int delEnterpriseContacts(String enterpriseContactsId){
		return enterpriseContactsMapper.delEnterpriseContacts(enterpriseContactsId);
	}
}





