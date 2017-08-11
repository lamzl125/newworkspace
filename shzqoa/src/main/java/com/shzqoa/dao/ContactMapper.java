package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.Contact;

public interface ContactMapper {	
	public int save(Contact info);
	public int deleteById(Integer contactId);
	public int update(Contact info);	
	public List<Contact> selcontact(Map<String, Object> map);
	public Integer getContactCount(Map<String, Object> map);
	public Contact getContactById(Integer contactId);
	
	
}
