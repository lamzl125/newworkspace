package com.shzqoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.shzqoa.model.DailyLog;
import com.shzqoa.model.DailyLogResumeCount;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.model.UserWeiXin;
import com.shzqoa.model.WorkTask;
import com.shzqoa.model.Worker;
import com.shzqoa.service.ContactDateService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.DailyLogService;
import com.shzqoa.service.DemandResumeFollowService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.service.UserWeiXinService;
import com.shzqoa.service.WorkTaskService;
import com.shzqoa.service.WorkerService;

/**
 * 工作日志
 * @author Auser
 *
 */
@Controller
@RequestMapping(value = "/log")
public class DailyLogController {
	
	@Resource 
	private CustomerInfoService customerinfoService;

	@Resource
	private DailyLogService dailyLogService;
	
	@Resource
	private WorkTaskService workTaskService;
	
	@Resource
	private ResumeSourceService resumeSourceService;
	
	@Resource
	private UserService userService;
	@Resource
	private ContactDateService contactDateService;
	@Resource 
	private UserGroupService userGroupService;
	@Resource 
	private WorkerService workerService;
	@Resource
	private UserWeiXinService userWeiXinService;
	@Resource
	private CustomerDemandService customerDemandService;
	@Resource
	private DemandResumeFollowService demandResumeFollowService;
	
	
	@RequestMapping(value = "/checkdailylog")
	@ResponseBody
	public ReturnDate checkdailylog(
			@RequestParam(value = "dailylogid", defaultValue = "") Integer dailylogid){
		ReturnDate rd = new ReturnDate();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dailylogid", dailylogid);
		map.put("taskstatus", 4);//任务状态0-未完成  1-已完成  2-处理中 3-已处理  4-已校验
		int count = dailyLogService.updatedailylogbyid(map);
		if(count>0){
			rd.setMsg("校验成功");
			rd.setStatus(0);
		}else{
			rd.setMsg("校验失败");
			rd.setStatus(1);
		}
		return rd;
	}
	
	@RequestMapping(value = "/showUserDaiyLog")
	public ModelAndView showUserDaiyLog(
			@RequestParam(value = "userid", defaultValue = "") String userid,
			@RequestParam(value = "logdate", defaultValue = "") String logdate
			){
		//1、查询某人某天的任务
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("appointuserid", userid);
		map.put("logdate", logdate);
		List<Map<String,Object>> workTasks = workTaskService.sltTaskByUserDay(map);
		ModelAndView mv = new ModelAndView("views/work/dailyloginfo");
		mv.addObject("workTasks", workTasks);
		mv.addObject("userinfo", userService.getUserByUserCode(userid));
		mv.addObject("logdate", logdate);
		return mv;
		
	}
	
	
	/**
	 * 添加工作日志
	 * @param taskid
	 * @param userid
	 * @param realname
	 * @param logcontent
	 * @param propose
	 * @return
	 */
	@RequestMapping(value = "/addLog")
	@ResponseBody
	public ReturnDate addWorkLog(
			@RequestParam(value = "taskid", defaultValue = "1") Integer taskid,
			@RequestParam(value = "publishcontent", defaultValue = "1") String publishcontent,
			@RequestParam(value = "userid", defaultValue = "1") String userid,
			@RequestParam(value = "realname", defaultValue = "1") String realname,
			@RequestParam(value = "logcontent", defaultValue = "1") String logcontent,
			@RequestParam(value = "propose", defaultValue = "") String propose,
			@RequestParam(value = "isaddj", defaultValue = "0") int isaddj,
			@RequestParam(value = "addresumecount", defaultValue = "") String addresumecount,
			@RequestParam(value = "taskstatus", defaultValue = "") Integer taskstatus,
			
			@RequestParam(value = "weixin", defaultValue = "") String weixin,
			@RequestParam(value = "lastCount", defaultValue = "") String lastCount,
			@RequestParam(value = "addCount", defaultValue = "") String addCount,
			@RequestParam(value = "addDynamic", defaultValue = "") String addDynamic			
			){
		ReturnDate rd = new ReturnDate();
		if(dailyLogService.addWorkLog(taskid, publishcontent,userid, realname, logcontent.replace("\n", "<br/>"), propose.replace("\n", "<br/>"),
				isaddj,addresumecount,taskstatus,weixin,lastCount,addCount,addDynamic) > 0){
			rd.setStatus(1);
			rd.setMsg("工作日志提交成功!");
		}
		return rd;
		
	}
	@RequestMapping(value = "/getAllResumeSourceByresumesourceid")
	@ResponseBody
	public ReturnDate getAllResumeSourceByresumesourceid(
			@RequestParam(value = "resumesourceid", defaultValue = "0") String resumesourceid){
		/*ModelAndView mv = new ModelAndView("views/work/dailyLog");*/
		ReturnDate rd = new ReturnDate();
		int count=resumeSourceService.getAllResumeSourceByresumesourceid(resumesourceid);
		rd.setData(count);
		/*mv.addObject("count",count);*/
		return rd;
	}
	
	
	/**
	 * 进入工作日志页面
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/enter")
	public ModelAndView jinWorkLog(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "logdate", defaultValue = "") String logdate,
			HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/work/dailyLog");
		/*resumeSourceService.getAllResumeSourceByresumesourceid()*/
		User user = (User) request.getSession().getAttribute("user");
		String userid = user.getUsercode();
		List<Map<String, Object>> resumelist=customerinfoService.selectresumecount(userid);
		List<WorkTask> workTasks = workTaskService.sltNofinish(userid);
		mv.addObject("workTasks", workTasks);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = null;
		if(logdate.length() > 0 ){
			try {
				time = sf.parse(logdate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Map<String,Object> map = null;
		if(workTaskService.ispromulgator(userid) > 0){
			map = dailyLogService.dailyLogList(page, pageSize,"",time);
		} else {
			map = dailyLogService.dailyLogList(page, pageSize,userid,time);
		}
		int total=(Integer)map.get("total"); 
		if (request.getQueryString() != null) // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		mv.addObject("logdate", logdate);
		mv.addObject("resumelist", resumelist);
		mv.addObject("resumeSourceList", resumeSourceService
				.getAllResumeSource(new HashMap<String, Object>()));
		
		//查询联系记录
		Map<String,Object> conmap = new HashMap<String,Object>();
		conmap.put("usercode", userid);
		conmap.put("contacktime", new Date());
		List<Map<String,Object>> contlist = contactDateService.selContactDateByUserToday(conmap);
		mv.addObject("contlist", contlist);
		
		Map<String,Object> usermap = new HashMap<String,Object>();
		//判断当前用户是否是人事组
		usermap.put("usercode", user.getUsercode());
		usermap.put("groupname", "人事");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			mv.addObject("rsflag", 1);
		}else{
			mv.addObject("rsflag", 0);
		}
		
		//判断当前用户是否是工厂招聘组
		usermap.put("groupname", "工厂招聘组");
		groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			mv.addObject("gczpflag", 1);
			//获取当日用户录入的工人信息以及当前用户跟踪的工人信息
			usermap.put("addPeople", user.getUsercode());
			usermap.put("addTime", new Date());
			List<Worker> worklist = workerService.getWorkerByMap(usermap);
			mv.addObject("worklist", worklist);
		}else{
			mv.addObject("gczpflag", 0);
		}
		
		//判断当前用户是否是人事管理员组
		usermap.put("groupname", "人事管理员组");
		groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			mv.addObject("rgflag", 1);
			//获取当日用户录入的需求信息
			usermap.put("ocode", user.getUsercode());
			usermap.put("addTime", new Date());
			
			List<Map<String, Object>> adddemandlist = customerDemandService.notClosedDemands(usermap);
			mv.addObject("adddemandlist", adddemandlist);
			
			List<Map<String,Object>> follist = demandResumeFollowService.followlistOfDemandResume(usermap);
			mv.addObject("follist", follist);
		}else{
			mv.addObject("rgflag", 0);
		}
		
		
		
		
		//查询当前用户微信
		Map<String,Object> curuw = new HashMap<String,Object>();
		curuw.put("userCode", user.getUsercode());
		curuw.put("statusFlag", 1);		
		List<UserWeiXin> uwxlist = userWeiXinService.getUserWeiXinListByMap(curuw);
		mv.addObject("uwxlist", uwxlist);		
		return mv;
	}
	
	/**
	 * 单条日志详情
	 * @param dailylogid
	 * @return
	 */
	@RequestMapping(value = "/dailyid")
	public ModelAndView sltdailylogbyid(
			@RequestParam(value = "dailylogid", defaultValue = "1") int dailylogid){
		DailyLog daily = dailyLogService.sltdailylogbyid(dailylogid);
		List<DailyLogResumeCount> rescount = dailyLogService.getResumeCount(dailylogid);
		ModelAndView mv = new ModelAndView("views/work/dailylogbyid");
		mv.addObject("daily", daily);
		mv.addObject("rescountlist", rescount);
		mv.addObject("resumeSourceList", resumeSourceService
				.getAllResumeSource(new HashMap<String, Object>()));
		
		
		
		//1、查询某人某天的任务
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("appointuserid", daily.getUserid());
		map.put("logdate", daily.getLogdate());
		List<Map<String,Object>> workTasks = workTaskService.sltTaskByUserDay(map);
		mv.addObject("workTasks", workTasks);
		return mv;
		
	}
	
	/**
	 * 转入回复日志页面
	 * @param dailylogid
	 * @return
	 */
	@RequestMapping(value = "/toreplylog")
	public ModelAndView toreplylog(
			@RequestParam(value = "dailylogid", defaultValue = "1") int dailylogid){
		DailyLog daily = dailyLogService.sltdailylogbyid(dailylogid);
		List<DailyLogResumeCount> rescount = dailyLogService.getResumeCount(dailylogid);
		ModelAndView mv = new ModelAndView("views/work/replylog");
		mv.addObject("daily", daily);
		mv.addObject("rescountlist", rescount);
		mv.addObject("resumeSourceList", resumeSourceService
				.getAllResumeSource(new HashMap<String, Object>()));
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist", userlist);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/replyLog")
	@ResponseBody
	public ReturnDate replyLog(
			@RequestParam(value = "dailylogid", defaultValue = "0") Integer dailylogid,
			@RequestParam(value = "replyinfo", defaultValue = "") String replyinfo,
			@RequestParam(value = "repalyuser", defaultValue = "") String repalyuser,
			HttpServletRequest request){
		ReturnDate rd = new ReturnDate();
		User user = (User) request.getSession().getAttribute("user");
		if(dailylogid==null || dailylogid ==0){
			rd.setStatus(0);
			rd.setMsg("未查询到日志信息无法进行回复操作");
		}
		if(replyinfo==null || "".equals(replyinfo)){
			rd.setStatus(0);
			rd.setMsg("回复信息不能为空");
		}
		if(repalyuser==null || "".equals(repalyuser)){
			rd.setStatus(0);
			rd.setMsg("回复指定人员不能为空");
		}
		try{
			if(dailyLogService.replyWorkLog(dailylogid, replyinfo,repalyuser,user) > 0){
				rd.setStatus(1);
				rd.setMsg("工作日志回复成功!");
			}	
		}catch(Exception e){
			rd.setStatus(0);
			rd.setMsg("工作日志回复失败!");
		}
		
		return rd;
	}
	@RequestMapping(value="/problems")
	public ModelAndView problems(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			@RequestParam(value = "starttime", defaultValue = "") String starttime,
			@RequestParam(value = "endtime", defaultValue = "") String endtime,
			@RequestParam(value = "keywords", defaultValue = "") String keywords,
			HttpServletRequest request) throws ParseException{
		ModelAndView mv = new ModelAndView("views/work/problems");
		mv.addObject("usercode", usercode);
		mv.addObject("starttime", starttime);
		mv.addObject("endtime", endtime);
		mv.addObject("keywords", keywords);
		User curruser = (User) request.getSession().getAttribute("user");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date stardate = null;
		Date enddate = null;
		if(starttime.length() > 0 ){
			try {
				stardate = sf.parse(starttime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(endtime.length() > 0 ){
			try {
				enddate = sf.parse(endtime);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String,Object> map = null;
		List<User> userlist = new ArrayList<User>();
		if(workTaskService.ispromulgator(curruser.getUsercode()) > 0){//发布者
			userlist = userService.getAllUsers();
			map = dailyLogService.ProblemList(page, pageSize,stardate,enddate,keywords,usercode);
		} else {
			userlist.add(curruser);
			map = dailyLogService.ProblemList(page, pageSize,stardate,enddate,keywords,curruser.getUsercode());
		}
		int total=(Integer)map.get("total"); 
		if (request.getQueryString() != null) // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		mv.addObject("userlist",userlist);
		mv.addObject("resumeSourceList", resumeSourceService
				.getAllResumeSource(new HashMap<String, Object>()));
		return mv;
	}
}




