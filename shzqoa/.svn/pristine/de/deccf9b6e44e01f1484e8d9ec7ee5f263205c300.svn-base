package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.TaskService;

@RequestMapping("taskallotdetails")
@Controller
public class TaskAllotDetailsController {
	
	@Resource
	private TaskService taskService;
	
	@RequestMapping("queryTaskAllotDetails")
	public ModelAndView queryTaskAllotDetails(HttpSession session,
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		params.put("userid", user.getUsercode());
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		List<Map<String, Object>> list = taskService.queryTaskAllotByUserCode(params);
		int total = taskService.queryCountByUserCode(params);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		model.put("total", total);
		model.put("tatalpage", tatalpage);//总页数
		model.put("currpage", page);//当前页
		model.put("list", list);
		return new ModelAndView("views/taskallot/HR_taskdetails/hr_taskdetails", model);
	}
	
	@RequestMapping("customerdetails")
	public ModelAndView customerdetails(HttpSession session,String taskallotid){
		Map<String, Object> model = new HashMap<String, Object>();
		User user = (User) session.getAttribute("user");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", user.getUsercode());
		params.put("taskallotid", taskallotid);
		List<CustomerInfo> list = taskService.queryCustomerInterview(params);
		model.put("list", list);
		model.put("taskallotid", taskallotid);
		return new ModelAndView("views/taskallot/HR_taskdetails/customerdetails", model);
	}
	@RequestMapping("saveJoinCustomer")
	@ResponseBody
	public ReturnDate saveJoinCustomer(
			@RequestParam(value = "customercode", defaultValue = "",required=true) String  customercode,
			@RequestParam(value = "taskallotid",required=true) String  taskallotid){
		ReturnDate rd=new ReturnDate();
		boolean result=taskService.saveInter(taskallotid,customercode);
		if(result){
			rd.setStatus(0);
			rd.setMsg("绑定成功！");
		}else{
			rd.setStatus(1);
			rd.setMsg("绑定失败！");
		}
		return rd;
	}
}