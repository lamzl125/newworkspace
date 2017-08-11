package com.shzqoa.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.shzqoa.dao.InterViewMapper;
import com.shzqoa.model.InterView;
import com.shzqoa.model.InterViews;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.util.DateUtils;
@Service
public class InterViewService {
	@Resource
	private InterViewMapper interMapper;
	
	public Map<String, Object> selectViewList(String taskallotid,int page,int pageSize) {  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("taskallotid", taskallotid);
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);
		List<InterViews> interViewList=interMapper.selectinterView(map);
		int total = interMapper.selectinterViewCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("list", interViewList);
		map.put("tatalpage", tatalpage);
		return map;
	}
	public InterViews selectView(String id) {  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		return interMapper.selectView(map);
	}
	
	public ReturnDate updateInterView(String  id, String  realitytime, String  plantime, String  issuccess, String  isentry) throws ParseException{
		ReturnDate rd=new ReturnDate();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("isentry", isentry);
		if(StringUtils.isNotBlank(plantime)){
			map.put("plantime", DateUtils.formatY_M_D2Date(plantime, DateUtils.FORMAT_Y_M_D));
		}
		if(StringUtils.isNotBlank(realitytime)){
			map.put("realitytime", DateUtils.formatY_M_D2Date(realitytime, DateUtils.FORMAT_Y_M_D));
		}
		map.put("issuccess", issuccess);
		int result=interMapper.updateInterView(map);
		if(result>0){
			rd.setStatus(0);
			rd.setMsg("更新成功！");
		}else{
			rd.setStatus(1);
			rd.setMsg("更新失败！");
		}
		return rd;
	}
}
