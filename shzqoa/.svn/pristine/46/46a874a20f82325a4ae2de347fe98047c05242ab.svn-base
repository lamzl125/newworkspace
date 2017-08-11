package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ContactMapper;
import com.shzqoa.model.Contact;
@Service
public class ContactService {
	@Resource
	private ContactMapper contactMapper;
	
	@Transactional
	public int save(Contact info){
		if(info != null){
			return this.contactMapper.save(info);
		}
		return 0;
	}

	@Transactional
	public int delete(Integer contactId){
		if(contactId!=null && contactId > 0){
			return this.contactMapper.deleteById(contactId);
		}
		return 0;
	}
	
	@Transactional
	public int update(Contact info){
		if(info != null){
			return this.contactMapper.update(info);
		}
		return 0;
	}

	public List<Contact> selcontact(Map<String,Object> map){
		return  contactMapper.selcontact(map);
	}
	public Integer getContactCount(Map<String,Object> map){
		return contactMapper.getContactCount(map);
	}
	public Contact getContactById(Integer contactId){
		return this.contactMapper.getContactById(contactId);
	}
	
	
}
