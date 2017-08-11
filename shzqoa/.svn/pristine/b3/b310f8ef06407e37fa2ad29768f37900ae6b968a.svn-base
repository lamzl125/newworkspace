package com.shzqoa.controller;

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
import com.shzqoa.service.ContactService;
import com.shzqoa.service.FollowService;
import com.shzqoa.service.SchoolService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResultObject;
@Controller
@RequestMapping(value = "/follow")
public class FollowController {
	@Resource
	private FollowService followService;
	@Resource
	private ContactService contactService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private UserService userService;
	
	
	
	@RequestMapping(value="/saveFollowInfo", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveFollowInfo(
			@RequestParam(value = "followId", defaultValue = "") Integer followId,
    		@RequestParam(value = "contactId", defaultValue = "") Integer contactId,
    		@RequestParam(value = "memo", defaultValue = "") String memo,
    		HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		ResultObject result = ResultObject.getResultObject();
		try {
			Follow info = null;
			if(followId!=null && followId > 0){
				info = followService.getFollowById(followId);
			}else{
				info = new Follow();
			}
			
			info.setContactId(contactId);
			info.setMemo(memo);
			info.setOperCode(user.getUsercode());
			info.setOperTime(new Date());
			int res = 0;
			if(followId!=null && followId > 0){
				res = followService.update(info);
			}else{
				res = followService.save(info);
			}
			result.setResultData(res);
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
	
	@RequestMapping("/toFollowInfoAdd")  
    public ModelAndView toFollowInfoAdd(Integer contactId,HttpServletRequest request){
		ModelAndView	mv = new ModelAndView("views/school/schooltrainfollowadd");
		User user = (User)request.getSession().getAttribute("user");
		mv.addObject("contactId",contactId);
		mv.addObject("user",user);
		return mv;
	}
	
	
	@RequestMapping("/toFollowList")  
    public ModelAndView toFollowList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "contactId", defaultValue = "0") Integer contactId){
		ModelAndView mv = new ModelAndView("views/school/schooltrainfollowlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("contactId", contactId);		
		List<Follow> followlist = followService.selcontact(acMap);
		Contact contactInfo = new Contact();
		if(contactId!=null && contactId>0){
			contactInfo = contactService.getContactById(contactId);
		}
		School schoolINfo = new School();
		if(contactInfo!=null && contactInfo.getSchoolId()>0){
			schoolINfo = schoolService.getSchoolById(contactInfo.getSchoolId());
		}
		int total = followService.getFollowCount(acMap);		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		List<User> userlist = userService.getAllUsers();
		mv.addObject("schoolINfo",schoolINfo);
		mv.addObject("contactInfo",contactInfo);
		mv.addObject("followlist",followlist);
		mv.addObject("contactId",contactId);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("userlist", userlist);
		return mv;
	}
	
	
	/*
	
	
	@RequestMapping("/deleteContact")
	@ResponseBody
	public ResultObject deleteContact(Integer contactId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(contactId!=null && contactId>0){
				int i = contactService.delete(contactId);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("删除成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("删除失败");
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/toEditContact")  
    public ModelAndView toEditContact(Integer contactId){
		ModelAndView	mv = new ModelAndView("views/school/schooltrainedit");
		Contact info = contactService.getContactById(contactId);
		School schoolInfo = schoolService.getSchoolById(info.getSchoolId());
		List<School> schoolList = schoolService.getAllSchool();
		mv.addObject("schoolInfo",schoolInfo);
		mv.addObject("allSchoolList",schoolList);
		mv.addObject("info",info);
		return mv;
	}
	
	
	
	
	@RequestMapping("/toDepartmentsList")  
    public ModelAndView toDepartmentsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "schoolId", defaultValue = "0") Integer schoolId){
		ModelAndView	mv = new ModelAndView("views/school/schooldepartlist");
		List<School> schoolList = new ArrayList<School>();
		if(schoolId!=null && schoolId>0){
			schoolList.add(schoolService.getSchoolById(schoolId));
		}else{
			schoolList = schoolService.getAllSchool();
		}
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("schoolId", schoolId);
		List<Contact> contactlist = contactService.selcontact(acMap);
		int total = contactService.getContactCount(acMap);		
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
		mv.addObject("contactlist",contactlist);
		mv.addObject("schoolId",schoolId);
		mv.addObject("allSchoolList",schoolList);
		return mv;
	}
	
	
	@RequestMapping("/toTrainInfoAdd")  
    public ModelAndView toTrainInfoAdd(Integer schoolId){
		ModelAndView	mv = new ModelAndView("views/school/schooltrainadd");
		List<School> schoolList = new ArrayList<School>();
		if(schoolId!=null && schoolId>0){
			schoolList.add(schoolService.getSchoolById(schoolId));
		}else{
			schoolList = schoolService.getAllSchool();
		}
		mv.addObject("schoolId",schoolId);
		mv.addObject("allSchoolList",schoolList);
		return mv;
	}
	
	*/
	
}
