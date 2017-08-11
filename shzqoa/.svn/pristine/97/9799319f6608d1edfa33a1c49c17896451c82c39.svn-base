package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.AccountArea;
import com.shzqoa.model.Accounts;
import com.shzqoa.model.Areas;
import com.shzqoa.model.ResumeSource;
import com.shzqoa.model.School;
import com.shzqoa.service.SchoolService;
import com.shzqoa.util.ResultObject;
@Controller
@RequestMapping(value = "/school")
public class SchoolController {
	
	@Resource
	private SchoolService schoolService;
	
	
	@RequestMapping(value="/updateSchoolInfo", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject updateSchoolInfo(
			@RequestParam(value = "schoolId", defaultValue = "0") Integer schoolId,
			@RequestParam(value = "schoolType", defaultValue = "0") Byte schoolType,
    		@RequestParam(value = "schoolName", defaultValue = "") String schoolName,
    		@RequestParam(value = "schoolAddr", defaultValue = "") String schoolAddr,
    		@RequestParam(value = "schoolURL", defaultValue = "") String schoolURL
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			School info = schoolService.getSchoolById(schoolId);
			info.setSchoolAddr(schoolAddr);
			info.setSchoolName(schoolName);
			info.setSchoolType(schoolType);
			info.setSchoolURL(schoolURL);
			int res = schoolService.update(info);
			result.setResultData(res);
			if(res>0){
				result.setSuccess(true);
				result.setResultMessage("更新成功");
			}else{
				result.setSuccess(false);
				result.setResultMessage("更新失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/toEditSchool")  
    public ModelAndView toEditSchool(Integer schoolId){
		ModelAndView	mv = new ModelAndView("views/school/schooledit");
		School info = schoolService.getSchoolById(schoolId);
		mv.addObject("info",info);
		return mv;
	}
	
	@RequestMapping(value="/saveSchoolInfo", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveSchoolInfo(
			@RequestParam(value = "schoolType", defaultValue = "0") Byte schoolType,
    		@RequestParam(value = "schoolName", defaultValue = "") String schoolName,
    		@RequestParam(value = "schoolAddr", defaultValue = "") String schoolAddr,
    		@RequestParam(value = "schoolURL", defaultValue = "") String schoolURL
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			School info = new School();
			info.setSchoolAddr(schoolAddr);
			info.setSchoolName(schoolName);
			info.setSchoolType(schoolType);
			info.setSchoolURL(schoolURL);
			int res = schoolService.save(info);
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
	
	@RequestMapping("/toSchoolList")  
    public ModelAndView toSchoolList(
    		@RequestParam(value = "searchschoolname", defaultValue = "") String searchschoolname,
    		@RequestParam(value = "searchschooladdr", defaultValue = "") String searchschooladdr,
    		@RequestParam(value = "searchschoolurl", defaultValue = "") String searchschoolurl,
    		@RequestParam(value = "searchSchollType", defaultValue = "") Integer searchSchollType,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/school/schoollist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(searchschoolname!=null && !"".equals(searchschoolname)){
			acMap.put("schoolName", searchschoolname);
		}
		if(searchschooladdr!=null && !"".equals(searchschooladdr)){
			acMap.put("schoolAddr", searchschooladdr);
		}
		if(searchschoolurl!=null && !"".equals(searchschoolurl)){
			acMap.put("schoolURL", searchschoolurl);
		}
		if(searchSchollType!=null && searchSchollType>0){
			acMap.put("schoolType", searchSchollType);
		}
		
		List<School> schoollist = schoolService.selschool(acMap);
		int total = schoolService.getSchoolCount(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("schoollist",schoollist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("searchschoolname",searchschoolname);
		mv.addObject("searchschooladdr",searchschooladdr);
		mv.addObject("searchschoolurl",searchschoolurl);
		mv.addObject("searchSchollType",searchSchollType);
		return mv;
	}
	
	
	@RequestMapping("/toSchoolAdd")  
    public ModelAndView toSchoolAdd(Byte schoolType){
		ModelAndView	mv = new ModelAndView("views/school/schooladd");
		mv.addObject("schoolType",schoolType);
		return mv;
	}
	
	@RequestMapping("/deleteSchool")
	@ResponseBody
	public ResultObject deleteSchool(Integer schoolId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(schoolId!=null && schoolId>0){
				int i = schoolService.delete(schoolId);
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
	
}
