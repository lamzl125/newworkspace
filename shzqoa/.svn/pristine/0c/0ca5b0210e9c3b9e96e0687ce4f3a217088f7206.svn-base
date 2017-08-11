package com.shzqoa.controller;

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

import com.shzqoa.model.User;
import com.shzqoa.service.UserService;


@Controller
@RequestMapping(value = "/demisssion")
public class DemissionController {
	@Resource
	private UserService userService;
	
	//添加离职人员
	@RequestMapping("/demisssionUser")  
	@ResponseBody
	public Map<String,Object> saveResumeSource(
			@RequestParam(value = "infoname", defaultValue = "") String infoname,
			@RequestParam(value = "userstatus", defaultValue = "1") Integer userstatus,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		User info = userService.getUserByUserCode(infoname);
		info.setUserstatus(userstatus);//用户状态（1-正常 2-离职 ）
		
		if(userService.updateUser(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加/恢复离职人员信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加/恢复离职人员信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/demisssionList")  
    public ModelAndView demisssionList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/demission/demissionmanage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("userstatus", 2);
		List<User> lsit = userService.queryDessionList(conMap);
		int total = userService.queryDessionListCount(conMap);
		
		
		//在职人员列表
		List<User> curuser = userService.queryCurList(conMap);
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
		mv.addObject("curuser", curuser);
		return mv;
	}
}
