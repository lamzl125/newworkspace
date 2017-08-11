package com.shzqoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.service.CustomerContlService;
import com.shzqoa.service.CustomerDetailService;

@Controller
@RequestMapping(value = "/resume")
public class ResumeStatisticsController {
	private final Logger log = Logger.getLogger(ResumeStatisticsController.class);
	
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private CustomerContlService customerContlService;
	
	
	@RequestMapping("/customerlist")  
    public ModelAndView customerlist(
    		@RequestParam(value = "resumeSourceId", defaultValue = "") Integer resumeSourceId,
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "userCode", defaultValue = "") String userCode,
    		@RequestParam(value = "optype", defaultValue = "") Integer optype,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/customerlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		mv.addObject("optype", optype);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(startdate!=null &&!"".equals(startdate)){
			acMap.put("startdate", startdate);
			mv.addObject("startdate", startdate);
		}
		if(enddate!=null &&!"".equals(enddate)){
			acMap.put("enddate", enddate);
			mv.addObject("enddate", enddate);
		}
		if(userCode!=null &&!"".equals(userCode)){
			acMap.put("userCode", userCode);
			mv.addObject("userCode", userCode);
		}
		if(resumeSourceId!=null && resumeSourceId >= 0){
			acMap.put("resumeSourceId", resumeSourceId);
			mv.addObject("resumeSourceId", resumeSourceId);
		}
		List<Map<String,Object>> stlist = null;
		int total = 0;
		if(optype==1){
			stlist = customerDetailService.resumelistByMap(acMap);
			total = customerDetailService.resumelistCountByMap(acMap);
		}else{
			acMap.put("optype", optype);
			stlist = customerDetailService.sourceresume(acMap);
			total = customerDetailService.sourceresumecount(acMap);
		}
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("stlist", stlist);
		return mv;
	}
	
	
	
	@RequestMapping("/customersourcelist")  
    public ModelAndView customersourcelist(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "userCode", defaultValue = "") String userCode,
    		@RequestParam(value = "optype", defaultValue = "") Integer optype,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/customersourcelist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		mv.addObject("optype", optype);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(startdate!=null &&!"".equals(startdate)){
			acMap.put("startdate", startdate);
			mv.addObject("startdate", startdate);
		}
		if(enddate!=null &&!"".equals(enddate)){
			acMap.put("enddate", enddate);
			mv.addObject("enddate", enddate);
		}
		if(userCode!=null &&!"".equals(userCode)){
			acMap.put("usercode", userCode);
			mv.addObject("userCode", userCode);
		}
		List<Map<String,Object>> stlist = null;
		int total = 0;
		if(optype==1){
			stlist = customerDetailService.ressoustat(acMap);
			total = customerDetailService.ressoustatcount(acMap);
		}
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("stlist", stlist);
		return mv;
	}
	
	
	
	@RequestMapping("/resumestatisticslist")  
    public ModelAndView resumestatisticslist(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/resumestatistics");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(startdate!=null &&!"".equals(startdate)){
			acMap.put("startdate", startdate);
			mv.addObject("startdate", startdate);
		}
		if(enddate!=null &&!"".equals(enddate)){
			acMap.put("enddate", enddate);
			mv.addObject("enddate", enddate);
		}
		List<Map<String,Object>> stlist = customerDetailService.resumestatistics(acMap);
		int total = customerDetailService.resumestatisticscount(acMap);
		
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("stlist", stlist);
		return mv;
	}
	
	
	
	@RequestMapping("/toResumeByResourceAndTime")  
    public ModelAndView  toResumeByResourceAndTime(
    		@RequestParam(value = "starttime", defaultValue = "") String starttime,//开始时间
    		@RequestParam(value = "endtime", defaultValue = "") String endtime,//结束时间
    		@RequestParam(value = "resource", defaultValue = "0") Integer resource,//简历来源
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws ParseException {  
		ModelAndView mv = new ModelAndView("views/statistics/xqye");
		
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		log.info("根据开始时间、结束时间、简历来源查询信息");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if(starttime !=null && !"".equals(starttime)){
			conMap.put("starttime", sf.parse(starttime));
		}
		if(endtime !=null && !"".equals(endtime)){
			Calendar c = Calendar.getInstance();  
			Date endDate = null;  
	        try {  
	        	endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endtime);  
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        c.setTime(endDate);  
	        int day = c.get(Calendar.DATE);  
	        c.set(Calendar.DATE, day + 1);  
			conMap.put("endtime", c.getTime());
		}
		if(resource!=null && resource !=0){
			conMap.put("resource", resource);
		}
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		List<CustomerInfo> list = customerDetailService.getCustomerinfoByCon(conMap);
		
		int total = customerDetailService.getCustomerinfoCountByCon(conMap);
		log.info("计算总页数");
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", list);
		mv.addObject("starttime", starttime);
		mv.addObject("endtime", endtime);
		mv.addObject("resource", resource);
        return mv;  
    }  

}
