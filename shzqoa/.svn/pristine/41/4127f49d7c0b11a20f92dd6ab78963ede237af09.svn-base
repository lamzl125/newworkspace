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

import com.shzqoa.model.User;
import com.shzqoa.model.Worker;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkerService;
import com.shzqoa.service.WorkerSignService;


@Controller
@RequestMapping(value = "/workersign")
public class WorkerSignController {
	@Resource
	private WorkerService workerService;
	@Resource
	private WorkerSignService workerSignService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/toFollowWorkerList")  
    public ModelAndView toFollowResumeList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/followworker/followworker");
//		tripRecordId = URLDecoder.decode(tripRecordId,"UTF-8");		
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("userCode", user.getUsercode());
		acMap.put("signStatus", 1);
		List<Worker> followlist = workerSignService.followworkerlist(acMap);
		int total = workerSignService.followworkerlistcount(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("workerlist",followlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist",userlist);
		
		List<Map<String,Object>> workerdemandlist = workerService.getWorkerDemandByMap(new HashMap<String,Object>());
		mv.addObject("workerdemandlist",workerdemandlist);
		return mv;
	}
	
	
}
