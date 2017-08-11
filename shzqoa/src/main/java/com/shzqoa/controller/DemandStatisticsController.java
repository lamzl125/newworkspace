package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustDemand;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.UserService;
@Controller
@RequestMapping(value = "/demandstatistics")
public class DemandStatisticsController {
	
	@Resource
	private CustomerDemandService customerDemandService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/customerlist")  
    public ModelAndView customerlist(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
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
		if(demandId!=null &&!"".equals(demandId)){
			acMap.put("demandId", demandId);
			mv.addObject("demandId", demandId);
		}
		List<Map<String,Object>> stlist = null;
		int total = 0;
		if(optype==1){
			stlist = customerDemandService.demandresumelist(acMap);
			total = customerDemandService.demandresumelistCount(acMap);
		}else{
			acMap.put("optype", optype);
			stlist = customerDemandService.followstatuslist(acMap);
			total = customerDemandService.followstatuslistCount(acMap);
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
	
	
	@RequestMapping("/demandstatisticslist")  
    public ModelAndView demandstatisticslist(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/demandstatistics");
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
		List<Map<String,Object>> stlist = customerDemandService.demandstatistics(acMap);
		int total = customerDemandService.demandstatisticsCount(acMap);
		
		
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
	
	
	@RequestMapping("/demandaddlist")  
    public ModelAndView demandaddlist(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/demandaddstatistics");
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
		
		
		
		List<CustDemand> stlist = customerDemandService.selectDemand(acMap);
		int total = customerDemandService.selectDemandCount(acMap);
		
		
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
		mv.addObject("userlist", userService.getAllUsers());	
		
		
		List<Map<String, Object>> addlist = customerDemandService.addDemStat(acMap);
		mv.addObject("addlist", addlist);
		return mv;
	}
	
	
}
