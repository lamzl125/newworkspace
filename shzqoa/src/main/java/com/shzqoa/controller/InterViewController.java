package com.shzqoa.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.InterView;
import com.shzqoa.model.InterViews;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.service.InterViewService;

@Controller
@RequestMapping(value = "InterView")
public class InterViewController {
  
	@Resource
	private InterViewService interService;
	@RequestMapping("ViewList")
	public ModelAndView selectViewList(String taskallotid,
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,HttpServletRequest request){
		ModelAndView mv=new ModelAndView("views/taskallot/HR_taskdetails/interView");
		Map<String, Object> map=interService.selectViewList(taskallotid, page, pageSize);
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		int total=(Integer)map.get("total");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		mv.addObject("taskallotid",taskallotid);
		return mv;
	}
	@RequestMapping("updateView")
	@ResponseBody
	public ModelAndView updateView(String id){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		InterViews interView=interService.selectView(id);
		model.put("interView", interView);
		return new ModelAndView("views/taskallot/HR_taskdetails/updateView", model);
	}
	@RequestMapping("updateInterView")
	@ResponseBody
	public  ReturnDate updateInterView(@RequestParam(value = "id",required=true) String  id,
			@RequestParam(value = "realitytime",defaultValue = "") String  realitytime,
			@RequestParam(value = "plantime",defaultValue = "") String  plantime,
			@RequestParam(value = "issuccess", defaultValue = "",required=true) String  issuccess,
			@RequestParam(value = "isentry", defaultValue = "",required=true) String  isentry) throws ParseException{
		return interService.updateInterView(id, realitytime, plantime, issuccess, isentry);
	}
}
