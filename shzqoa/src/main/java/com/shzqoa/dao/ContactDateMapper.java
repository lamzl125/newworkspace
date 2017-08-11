package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.ContactDate;


public interface ContactDateMapper {
	public List<Map<String,Object>> selContactDateByUserToday(Map<String,Object> map);
	
	List<ContactDate> getContactDateByCustomerCode(Map<String,Object> map); 
	
	int getContactDateCountByCustomerCode(Map<String,Object> map); 
	
	int insertContactDate(ContactDate contactDate);

}
