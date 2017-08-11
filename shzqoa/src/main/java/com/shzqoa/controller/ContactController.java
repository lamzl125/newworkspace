package com.shzqoa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Contact;
import com.shzqoa.model.School;
import com.shzqoa.service.ContactService;
import com.shzqoa.service.FollowService;
import com.shzqoa.service.SchoolService;
import com.shzqoa.util.ResultObject;
@Controller
@RequestMapping(value = "/contact")
public class ContactController {
	@Resource
	private FollowService followService;
	@Resource
	private ContactService contactService;
	@Resource
	private SchoolService schoolService;
	
	
	@RequestMapping("/toDepartInfoAdd")  
    public ModelAndView toDepartInfoAdd(Integer schoolId){
		ModelAndView	mv = new ModelAndView("views/school/schooldepartadd");
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
	
	
	@RequestMapping(value="/saveTrainInfo", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveTrainInfo(
			@RequestParam(value = "contactId", defaultValue = "0") Integer contactId,
			@RequestParam(value = "direction", defaultValue = "") String direction,
    		@RequestParam(value = "contactTel", defaultValue = "") String contactTel,
    		@RequestParam(value = "contactName", defaultValue = "") String contactName,
    		@RequestParam(value = "officeTel", defaultValue = "") String officeTel,
    		@RequestParam(value = "qq", defaultValue = "") String qq,
    		@RequestParam(value = "schoolId", defaultValue = "") Integer schoolId,
    		@RequestParam(value = "contactSex", defaultValue = "") Byte contactSex,
    		@RequestParam(value = "jobName", defaultValue = "") String jobName,
    		@RequestParam(value = "isEngross", defaultValue = "0") Byte isEngross
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			Contact info = null;
			if(contactId!=null && contactId > 0){
				info = contactService.getContactById(contactId);
			}else{
				info = new Contact();
			}
			
			info.setContactName(contactName);
			info.setContactSex(contactSex);
			info.setContactTel(contactTel);
			info.setDirection(direction);
			info.setSchoolId(schoolId);
			info.setIsEngross(isEngross);
			info.setOfficeTel(officeTel);
			info.setQq(qq);
			info.setJobName(jobName);
			int res = 0;
			if(contactId!=null && contactId > 0){
				res = contactService.update(info);
			}else{
				res = contactService.save(info);
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
	
	@RequestMapping("/toDepartmentsList")  
    public ModelAndView toDepartmentsList(
    		@RequestParam(value = "searchdirection", defaultValue = "") String searchdirection,
    		@RequestParam(value = "searchcontactTel", defaultValue = "") String searchcontactTel,
    		@RequestParam(value = "searchcontactName", defaultValue = "") String searchcontactName,
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
		if(searchdirection!=null && !"".equals(searchdirection)){
			acMap.put("direction", searchdirection);
		}
		if(searchcontactTel!=null && !"".equals(searchcontactTel)){
			acMap.put("contactTel", searchcontactTel);
		}
		if(searchcontactName!=null && !"".equals(searchcontactName)){
			acMap.put("contactName", searchcontactName);
		}
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
		mv.addObject("searchdirection", searchdirection);
		mv.addObject("searchcontactTel", searchcontactTel);
		mv.addObject("searchcontactName", searchcontactName);
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
	
	@RequestMapping("/toTrainInfoList")  
    public ModelAndView toTrainInfoList(
    		@RequestParam(value = "searchdirection", defaultValue = "") String searchdirection,
    		@RequestParam(value = "searchcontactTel", defaultValue = "") String searchcontactTel,
    		@RequestParam(value = "searchcontactName", defaultValue = "") String searchcontactName,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "schoolId", defaultValue = "0") Integer schoolId){
		ModelAndView mv = new ModelAndView("views/school/schooltrainlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		acMap.put("schoolId", schoolId);
		if(searchdirection!=null && !"".equals(searchdirection)){
			acMap.put("direction", searchdirection);
		}
		if(searchcontactTel!=null && !"".equals(searchcontactTel)){
			acMap.put("contactTel", searchcontactTel);
		}
		if(searchcontactName!=null && !"".equals(searchcontactName)){
			acMap.put("contactName", searchcontactName);
		}
		List<Contact> contactlist = contactService.selcontact(acMap);
		int total = contactService.getContactCount(acMap);		
		List<School> schoolList = schoolService.getAllSchool();
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		List<Object> lasttimelist = followService.selLastOperTime();
		mv.addObject("schoolId",schoolId);
		mv.addObject("schoolList",schoolList);
		mv.addObject("contactlist",contactlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("searchdirection", searchdirection);
		mv.addObject("searchcontactTel", searchcontactTel);
		mv.addObject("searchcontactName", searchcontactName);
		mv.addObject("lasttimelist", lasttimelist);
		return mv;
	}
	
}
