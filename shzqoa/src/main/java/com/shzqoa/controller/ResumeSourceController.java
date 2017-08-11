package com.shzqoa.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.ResumeSource;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.ResumeSourceService;


@Controller
@RequestMapping(value = "/resumeSource")
public class ResumeSourceController {
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private CustomerDetailService customerDetailService;
	
	
	
	@RequestMapping("/resumeSourceList")  
    public ModelAndView resumeSourceList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/resumeSource/ResumeSourceManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<ResumeSource> lsit = resumeSourceService.getAllResumeSource(conMap);
		int total = resumeSourceService.getAllResumeSourceCount(conMap);
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
		mv.addObject("list", lsit);
		return mv;
	}
	
	
	@RequestMapping("/saveResumeSource")  
	@ResponseBody
	public Map<String,Object> saveResumeSource(
			@RequestParam(value = "infoname", defaultValue = "") String infoname,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		ResumeSource info = new ResumeSource();
		info.setResumesourcename(infoname);
		if(resumeSourceService.insertResumeSource(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加简历来源信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加简历来源信息失败");
		}
		return resultMap;
	}
	
	
	@RequestMapping("/delResumeSourceById")  
	@ResponseBody
	public Map<String,Object> delResumeSourceById(
			@RequestParam(value = "id", defaultValue = "0") Integer id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("resource", id);
		//判断简历来源是否使用
		int count = customerDetailService.getCustomerinfoCountByCon(resultMap);
		if(count>0){
			resultMap.put("status",1);
			resultMap.put("msg", "目前该简历来源有人员信息，无法删除。");
		}else{
			int delflag = resumeSourceService.delResumeSourceById(id);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除简历来源信息成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除简历来源组信息失败");
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/toEditResumeSourceById")  
	public ModelAndView toEditResumeSourceById(
			@RequestParam(value = "id", defaultValue = "0") Integer id){
		ModelAndView mv = new ModelAndView("views/resumeSource/EditResumeSource");
		ResumeSource info = resumeSourceService.getResumeSourceById(id);
		mv.addObject("info", info);
		return mv;
	}
	
	@RequestMapping("/updateResumeSourceById")  
	@ResponseBody
	public Map<String,Object> updateResumeSourceById(
			@RequestParam(value = "resumesourceid", defaultValue = "0") Integer resumesourceid,
			@RequestParam(value = "resumesourcename", defaultValue = "") String resumesourcename){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("resource", resumesourceid);
		//判断简历来源是否使用
		int count = customerDetailService.getCustomerinfoCountByCon(resultMap);
		if(count>0){
			resultMap.put("status",1);
			resultMap.put("msg", "目前该简历来源有人员信息，无法修改。");
		}else{
			ResumeSource info = resumeSourceService.getResumeSourceById(resumesourceid);
			info.setResumesourcename(resumesourcename);
			int delflag = resumeSourceService.updateResumeSourceById(info);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "更新简历来源信息成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "更新简历来源信息失败");
			}
		}
		
		return resultMap;
	}
	
	
	
}
