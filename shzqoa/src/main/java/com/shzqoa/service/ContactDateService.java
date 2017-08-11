package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ContactDateMapper;
import com.shzqoa.dao.CustomerInfoMapper;
import com.shzqoa.model.Contact;
import com.shzqoa.model.ContactDate;

@Service
public class ContactDateService {
	private final Logger log = Logger.getLogger(ContactDateService.class);
	@Resource
	ContactDateMapper contactDateMapper;
	@Resource
	CustomerInfoMapper customerInfoMapper;
	
	public List<Map<String,Object>> selContactDateByUserToday(Map<String,Object> map){
		return  contactDateMapper.selContactDateByUserToday(map);
	}
	
	
	@Transactional
	public int addContactDate(ContactDate contactDate,String customercode,Integer newentprobability,Integer newrelationshipbyzh,Integer newrelationshipbyzq,String joinprojecttime) throws Exception{
		int addrest = contactDateMapper.insertContactDate(contactDate);
		if(addrest<1){
			log.info("添加跟踪联系信息失败");
			throw new Exception();
		}else{
			log.info("更新与公司关系");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("customercode", customercode); 
			map.put("newrelationshipbyzh", newrelationshipbyzh); 
			map.put("newrelationshipbyzq", newrelationshipbyzq); 
			map.put("newentprobability", newentprobability); 
			map.put("updatestatic", contactDate.getUpdatestatic()); 
			map.put("joinprojecttime", joinprojecttime);
			map.put("considerChangeJob", contactDate.getConsiderChangeJob());
			map.put("intentionArea", contactDate.getIntentionArea());
			int uprest = customerInfoMapper.updateRelationshipByCode(map);
			if(uprest<1){
				log.info("更新与公司关系信息失败");
				throw new Exception();
			}
		}
		return addrest;	
	}

}
