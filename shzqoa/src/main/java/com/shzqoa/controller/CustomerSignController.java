package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.User;
import com.shzqoa.service.CustomerSignService;


@Controller
@RequestMapping(value = "/customersign")
public class CustomerSignController {
	@Resource
	private CustomerSignService customerSignService;
	
	
	@RequestMapping("/toFollowResumeList")  
    public ModelAndView toFollowResumeList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/followresume/followresume");
//		tripRecordId = URLDecoder.decode(tripRecordId,"UTF-8");		
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("userCode", user.getUsercode());
		acMap.put("signStatus", 1);
		List<CustInfoAdd> followlist = customerSignService.followresmelist(acMap);
		int total = customerSignService.followresmelistcount(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("followlist",followlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		return mv;
	}
	
	
}
