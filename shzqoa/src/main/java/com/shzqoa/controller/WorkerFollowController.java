package com.shzqoa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Contact;
import com.shzqoa.model.Follow;
import com.shzqoa.model.School;
import com.shzqoa.model.User;
import com.shzqoa.model.Worker;
import com.shzqoa.model.WorkerFollow;
import com.shzqoa.service.ContactService;
import com.shzqoa.service.FollowService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.SchoolService;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkerFollowService;
import com.shzqoa.service.WorkerService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;
@Controller
@RequestMapping(value = "/workerfollow")
public class WorkerFollowController {
	private static String FACTORY = "项目工厂";
	@Resource
	private WorkerFollowService workerFollowService;
	@Resource
	private WorkerService workerService;
	@Resource
	private UserService userService;
	@Resource
	private ParameterService parameterService;
	
	
	@RequestMapping("/tofollowAdd")  
    public ModelAndView tofollowAdd(Integer followType,String objectId,HttpServletRequest request){
		ModelAndView	mv = new ModelAndView("views/workdemand/workerfollow");
		User user = (User)request.getSession().getAttribute("user");
		mv.addObject("followType",followType);
		mv.addObject("objectId",objectId);
		mv.addObject("user",user);
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		return mv;
	}
	
	
	@RequestMapping("/toWorkerFollowList")  
    public ModelAndView toWorkerFollowList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "followType", defaultValue = "0") Integer followType,
    		@RequestParam(value = "objectId", defaultValue = "") String objectId
    		){
		ModelAndView mv = new ModelAndView("views/workdemand/workerfollowlist");		
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("followType", followType);
		acMap.put("objectId", objectId);
		List<WorkerFollow> workerfollowlist = workerFollowService.selWorkerFollow(acMap);
		Worker worker = new Worker();
		if(objectId!=null && !"".equals(objectId)){
			worker = workerService.getWorkerById(objectId);
		}
		int total = workerFollowService.getWorkerFollowCount(acMap);		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		List<User> userlist = userService.getAllUsers();
		mv.addObject("workerfollowlist",workerfollowlist);
		mv.addObject("worker",worker);
		mv.addObject("followType",followType);
		mv.addObject("objectId",objectId);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("userlist", userlist);
		return mv;
	}
	
	@RequestMapping(value="/saveWorkerFollow", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveWorkerFollow(
			@RequestParam(value = "followType", defaultValue = "") Integer followType,
    		@RequestParam(value = "objectId", defaultValue = "") String objectId,
    		@RequestParam(value = "followTime", defaultValue = "") String followTime,
    		@RequestParam(value = "objectStatus", defaultValue = "") Integer objectStatus,
    		@RequestParam(value = "content", defaultValue = "") String content,    		
    		@RequestParam(value = "factoryId", defaultValue = "") Long factoryId,
    		@RequestParam(value = "intentionFactory", defaultValue = "") String intentionFactory,
    		@RequestParam(value = "intentionUserCode", defaultValue = "") String intentionUserCode,
    		@RequestParam(value = "giveUpFlag", defaultValue = "") Integer giveUpFlag,
    		HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		ResultObject result = ResultObject.getResultObject();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			WorkerFollow info = new WorkerFollow();
			info.setFollowId(SerialNumber.createSerial("wofo", 4));
			if(followTime!=null && !"".equals(followTime)){
				info.setFollowTime(sf.parse(followTime));
			}
			info.setFollowType(followType);
			info.setObjectId(objectId);
			info.setObjectStatus(objectStatus);
			info.setContent(content);
			info.setAddPeople(user.getUsercode());
			info.setAddTime(new Date());
			info.setFactoryId(factoryId);
			info.setIntentionFactory(intentionFactory);
			info.setIntentionUserCode(intentionUserCode);
			info.setGiveUpFlag(giveUpFlag);
			int res = workerFollowService.save(info);
			if(res>0){
				result.setSuccess(true);
				result.setResultMessage("保存成功");
			}else{
				result.setSuccess(false);
				result.setResultMessage("保存失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
}
