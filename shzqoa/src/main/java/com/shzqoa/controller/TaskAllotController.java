package com.shzqoa.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Areas;
import com.shzqoa.model.Grade;
import com.shzqoa.model.Profession;
import com.shzqoa.model.Task;
import com.shzqoa.model.User;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.GradeService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.TaskAllotService;
import com.shzqoa.service.TaskService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResultObject;

@RequestMapping("taskallot")
@Controller
public class TaskAllotController {
	
	@Resource
	private ProfessionService professionService;
	
	@Resource
	private AreasService areasService;
	
	@Resource
	private GradeService gradeService;
	
	@Resource
	private CustomerDemandService customerDemandService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private TaskAllotService taskAllotService;
	
	@Resource
	private TaskService taskService;
	
	@RequestMapping("main")
	public ModelAndView main(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "professionid", defaultValue = "") String professionid,
			@RequestParam(value = "areaid", defaultValue = "") String areaid,
			@RequestParam(value = "gradeid", defaultValue = "") String gradeid){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("professionid", professionid);
		params.put("areaid", areaid);
		params.put("gradeid", gradeid);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		List<Map<String, Object>> list = customerDemandService.queryXQByParams(params);
		int total = customerDemandService.queryCountByParams(params);
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
		model.put("professionid", professionid);
		model.put("areaid", areaid);
		model.put("gradeid", gradeid);
		List<Profession> professionList = professionService.queryAll();
		List<Areas> areasList = areasService.getAreaList();
		List<Grade> gradeList = gradeService.queryAll();
		model.put("professionList", professionList);
		model.put("areasList", areasList);
		model.put("gradeList", gradeList);
		return new ModelAndView("views/taskallot/taskallot", model);
	}
	
	@RequestMapping("allotdetails")
	public ModelAndView queryData(String taskData){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			String taskData1 = URLDecoder.decode(taskData, "UTF-8");
			List<User> users = userService.queryUsersByGroup("group16060210264427825");
			model.put("taskData", taskData1);
			model.put("users", users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/taskallot/allotdetails", model);
	}
	
	@RequestMapping("allotTask")
	@ResponseBody
	public ResultObject allotTask(String taskData, String allotTaskData){
		ResultObject result = ResultObject.getResultObject();
		try {
			taskAllotService.allotTask(result, taskData, allotTaskData);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage()); 
		}
		return result;
	}
	
	@RequestMapping("taskdetails")
	public ModelAndView taskdetails(Task task){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list= taskAllotService.queryTaskAllotDetails(task);
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/taskallot/taskdetails", model);
	}
	@RequestMapping(value="/TaskList")
	@ResponseBody
	public ModelAndView DocustomerInfo(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, 
			@RequestParam(value = "opername", defaultValue = "") String opername, 
			HttpServletRequest request){
		Map<String, Object> map=taskAllotService.TaskList(page, pageSize,opername);
		int total=(Integer)map.get("total"); 
		ModelAndView mv=new ModelAndView("views/taskallot/TaskList");
		mv.addObject("opername",opername);
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		return mv;
	}
	@RequestMapping("companyDemand")
	public ModelAndView companyDemand(String professionid, String areaid, String gradeid){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			if(StringUtils.isNotBlank(professionid)){
				params.put("professionid", professionid);
			}
			if(StringUtils.isNotBlank(areaid)){
				params.put("areaid", areaid);
			}
			if(StringUtils.isNotBlank(gradeid)){
				params.put("gradeid", gradeid);
			}
			params.put("state", "0");
			List<Map<String, String>> list = customerDemandService.queryCompanyDemand(params);
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/taskallot/companyDemand", model);
	}
	
}