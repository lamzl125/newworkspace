package com.shzqoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.shzqoa.model.DayResumeCount;
import com.shzqoa.service.DayResumeCountService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/dayrescount")
public class DayResumeCountController {
	@Resource
	private DayResumeCountService dayResumeCountService;
	
	@Resource
	private ResumeSourceService resumeSourceService;
	
	@RequestMapping("/dayrescountlist")  
    public ModelAndView dayrescountlist(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/dayresumecount/dayrescountlist");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<DayResumeCount> lsit = dayResumeCountService.getAllList(conMap);
		int total = dayResumeCountService.getAllListCount(conMap);
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
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		return mv;
	}
	
	@RequestMapping("/toadddayrescount")  
    public ModelAndView toadddayrescount(){
		ModelAndView mv = new ModelAndView("views/dayresumecount/adddayrescount");
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		return mv;
	}
	@RequestMapping("/savedayrescount")  
	@ResponseBody
	public Map<String,Object> savedayrescount(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "recodeday", defaultValue = "") String recodeday,
			@RequestParam(value = "resource", defaultValue = "0") int resource,
			@RequestParam(value = "count", defaultValue = "0") int count,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		DayResumeCount info = null;
		if(id==null || "".equals(id)){//新增
			info = new DayResumeCount();
			info.setId(SerialNumber.createSerial("drc", 4));
		}else{//修改
			info = dayResumeCountService.getDayResumeCountById(id);
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = null;
		if(recodeday.length() > 0 ){
			try {
				time = sf.parse(recodeday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		info.setRecorddate(time);
		info.setResumesource(resource);
		info.setCount(count);
		
		int result = 0;
		if(id==null || "".equals(id)){//新增
			result = dayResumeCountService.addDayresumeCount(info);
		}else{//修改
			result = dayResumeCountService.updateDayResumeCount(info);
		}
		if(result>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "日简历统计信息保存成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "日简历统计信息保存失败");
		}
		return resultMap;
	}
	@RequestMapping("/delete")  
	@ResponseBody
	public Map<String,Object> delete(
			@RequestParam(value = "aid", defaultValue = "") String aid){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int delflag = dayResumeCountService.delete(aid);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除日简历统计信息成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "删除日简历统计信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/toupdaedayrescount")  
    public ModelAndView toupdaedayrescount(@RequestParam(value = "aid", defaultValue = "") String aid){
		ModelAndView mv = new ModelAndView("views/dayresumecount/adddayrescount");
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		DayResumeCount info = dayResumeCountService.getDayResumeCountById(aid);
		mv.addObject("info",info);
		return mv;
	}
	/**
	 * 简历数量统计
	 */
	@RequestMapping("/toperiodrescountlist")  
    public ModelAndView toperiodrescountlist(){
		ModelAndView mv = new ModelAndView("views/dayresumecount/periodresumecount");
		List<Date> datelist = dayResumeCountService.getAllRecordDate();
		mv.addObject("datelist", datelist);
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		return mv;
	}
	
	@RequestMapping("/selectCountByGroup")
	@ResponseBody
	public ResultObject selectCountByGroup(
			@RequestParam(value="starttime", defaultValue="")String starttime,
			@RequestParam(value="endtime", defaultValue="") String endtime,
			@RequestParam(value="groupparam",defaultValue="")String groupparam){
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("starttime", starttime);
		paraMap.put("endtime", endtime);
		ResultObject result = new ResultObject();
		if("resumeSource".equals(groupparam)){
			result.setResultData(resumeSourceService.selectCountByRes(paraMap));
			result.setResultMessage("resumeSource");
			result.setSuccess(true);
		}else if("opert".equals(groupparam)){
			result.setResultData(resumeSourceService.selectCountByOpt(paraMap));
			result.setResultMessage("opert");
			result.setSuccess(true);
		}
		return result;
	}
	
}
