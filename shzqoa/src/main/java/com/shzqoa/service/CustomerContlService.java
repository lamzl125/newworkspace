package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.shzqoa.dao.ContactDateMapper;
import com.shzqoa.model.ContactDate;

@Service
public class CustomerContlService {
	private final Logger log = Logger.getLogger(CustomerContlService.class);
	
	@Resource
	private ContactDateMapper contactDateMapper;
	public Map<String,Object> getContactDateByCustomerCode(String customercode,int page,int pageSize) {  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currpage", page);
		
		page = (page-1)*pageSize;
		map.put("customercode", customercode);
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		log.info("分页查询记录数");
		List<ContactDate> list = contactDateMapper.getContactDateByCustomerCode(map);  
		log.info("查询记录总数");
		int total = contactDateMapper.getContactDateCountByCustomerCode(map);
		
		log.info("计算总页数");
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		
		map.put("list", list);
		map.put("total", total);
		map.put("tatalpage", tatalpage);
		return map;
    } 
	
}
