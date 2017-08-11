package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
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

import com.shzqoa.model.Enterprise;
import com.shzqoa.model.EnterpriseContacts;
import com.shzqoa.model.EnterpriseContactsFollow;
import com.shzqoa.model.User;
import com.shzqoa.service.EnterpriseContactsFollowService;
import com.shzqoa.service.EnterpriseContactsService;
import com.shzqoa.service.EnterpriseService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.SerialNumber;




@Controller
@RequestMapping(value = "/enterprise")
public class EnterpriseController {
	@Resource
	private EnterpriseService enterpriseService;
	@Resource
	private EnterpriseContactsService enterpriseContactsService;
	@Resource
	private EnterpriseContactsFollowService enterpriseContactsFollowService;
	@Resource
	private UserService userService;
	
	@RequestMapping("/saveFollowInfo")  
	@ResponseBody
	public Map<String,Object> saveFollowInfo(
			@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId,
			@RequestParam(value = "content", defaultValue = "") String content,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User) request.getSession().getAttribute("user");
		EnterpriseContactsFollow follow = new EnterpriseContactsFollow();
		follow.setFollowId(SerialNumber.createSerial("fol", 4));
		follow.setContent(content);		
		follow.setEnterpriseContactsId(enterpriseContactsId);		
		follow.setOperCode(user.getUsercode());
		follow.setOperTime(new Date());
		if(enterpriseContactsFollowService.insertFollow(follow)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "跟踪成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "跟踪失败");
		}
		return resultMap;
	}
	
	//进入新增跟踪页面
	@RequestMapping("/toFollowInfoAdd")  
    public ModelAndView toFollowInfoAdd(
    		@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId,
    		HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/company/comanyfollowadd");
		User user = (User) request.getSession().getAttribute("user");
		mv.addObject("user", user);
		mv.addObject("enterpriseContactsId", enterpriseContactsId);
		return mv;
	}
	
	//企业联系人跟踪列表
	@RequestMapping("/toContactsFollowList")  
    public ModelAndView toContactsFollowList(
    		@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/company/companyfollowlist");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(enterpriseContactsId!=null && !"".equals(enterpriseContactsId)){
			conMap.put("enterpriseContactsId", enterpriseContactsId);
			mv.addObject("enterpriseContactsId",enterpriseContactsId);
		}
		
		List<EnterpriseContactsFollow> lsit = enterpriseContactsFollowService.getAllFollowList(conMap);		
		int total = enterpriseContactsFollowService.getAllFollowListCount(conMap); 
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		
		EnterpriseContacts info = enterpriseContactsService.getEnterpriseContactsById(enterpriseContactsId);
		mv.addObject("contactInfo", info);
		
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist", userlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("followlist", lsit);
		return mv;
	}
	
	//进入编辑页面
	@RequestMapping("/toEditEnterpriseContacts")  
    public ModelAndView toEditEnterpriseContacts(
    		@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId){
		ModelAndView mv = new ModelAndView("views/company/companycontentedit");
		EnterpriseContacts info = enterpriseContactsService.getEnterpriseContactsById(enterpriseContactsId);
		mv.addObject("info", info);
		return mv;
	}
	
	
	//删除联系信息
	@RequestMapping("/delEnterpriseContacts")  
	@ResponseBody
	public Map<String,Object> delEnterpriseContacts(
			@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		if(enterpriseContactsService.delEnterpriseContacts(enterpriseContactsId)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "删除信息失败");
		}
		return resultMap;
	}
	
	//保存企业联系人信息
	@RequestMapping("/saveContactsInfo")  
	@ResponseBody
	public Map<String,Object> saveContactsInfo(
			@RequestParam(value = "enterpriseContactsId", defaultValue = "") String enterpriseContactsId,
			@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId,
			@RequestParam(value = "contactsName", defaultValue = "") String contactsName,
			@RequestParam(value = "contactsPhone", defaultValue = "") String contactsPhone,			
			@RequestParam(value = "contactsTel", defaultValue = "") String contactsTel,
			@RequestParam(value = "contactsQQ", defaultValue = "") String contactsQQ,			
			@RequestParam(value = "contactsWeiXin", defaultValue = "") String contactsWeiXin,
			@RequestParam(value = "job", defaultValue = "") String job,
			@RequestParam(value = "contactsStatus", defaultValue = "1") Integer contactsStatus,		
			@RequestParam(value = "abateResource", defaultValue = "") String abateResource,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		EnterpriseContacts ec = null;
		if(enterpriseContactsId!=null && !"".equals(enterpriseContactsId)){//
			ec = enterpriseContactsService.getEnterpriseContactsById(enterpriseContactsId);
		}else{//
			ec = new EnterpriseContacts();
			ec.setEnterpriseContactsId(SerialNumber.createSerial("econ", 4));
		}
		ec.setEnterpriseId(enterpriseId);
		ec.setContactsName(contactsName);
		ec.setContactsPhone(contactsPhone);
		ec.setContactsTel(contactsTel);
		ec.setContactsQQ(contactsQQ);
		ec.setContactsWeiXin(contactsWeiXin);
		ec.setContactsStatus(contactsStatus);
		ec.setJob(job);
		ec.setAbateResource(abateResource);
		if(enterpriseContactsId!=null && !"".equals(enterpriseContactsId)){//
			if(enterpriseContactsService.updateEnterpriseContacts(ec)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "保存信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "保存信息失败");
			}
		}else{//
			if(enterpriseContactsService.insertEnterpriseContacts(ec)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "保存信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "保存信息失败");
			}
		}
		return resultMap;
	}
	
	//进入新增企业联系人信息
	@RequestMapping("/toAddEnterpriseContacts")  
    public ModelAndView toAddEnterpriseContacts(
    		@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId){
		ModelAndView mv = new ModelAndView("views/company/companycontentadd");
		mv.addObject("enterpriseId", enterpriseId);
		return mv;
	}
	
	
	//企业联系人列表
	@RequestMapping("/toContactsInfoList")  
    public ModelAndView toContactsInfoList(
    		@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId,
    		@RequestParam(value = "searchname", defaultValue = "") String searchname,
    		@RequestParam(value = "searchcontactTel", defaultValue = "") String searchcontactTel,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/company/companycontentlist");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(enterpriseId!=null && !"".equals(enterpriseId)){
			conMap.put("enterpriseId", enterpriseId);
			mv.addObject("enterpriseId", enterpriseId);
		}
		if(searchname!=null && !"".equals(searchname)){
			conMap.put("contactsName", searchname);
			mv.addObject("searchname", searchname);
		}
		if(searchcontactTel!=null && !"".equals(searchcontactTel)){
			conMap.put("contactsTel", searchcontactTel);
			mv.addObject("searchcontactTel", searchcontactTel);
		}
		
		List<EnterpriseContacts> lsit = enterpriseContactsService.getAllEnterpriseContacts(conMap);		
		int total = enterpriseContactsService.getAllEnterpriseContactsCount(conMap); 
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
		return mv;
	}
	
	//启用
	@RequestMapping("/modifystatus")  
	@ResponseBody
	public Map<String,Object> modifystatus(
			@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId,
			@RequestParam(value = "enterpriseStatus", defaultValue = "0") Integer enterpriseStatus,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Enterprise isEx = enterpriseService.getEnterpriseById(enterpriseId);
		isEx.setEnterpriseStatus(enterpriseStatus);		
		if(enterpriseService.updateEnterprise(isEx)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "启用/不启用信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "启用/不启用信息失败");
		}
		return resultMap;
	}
	
	//删除信息
	@RequestMapping("/delEnterprise")  
	@ResponseBody
	public Map<String,Object> delEnterprise(
			@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		if(enterpriseService.delEnterprise(enterpriseId)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "删除信息失败");
		}
		return resultMap;
	}
	
	//进入编辑页面
	@RequestMapping("/toEditEnterprise")  
    public ModelAndView toEditEnterprise(
    		@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId){
		ModelAndView mv = new ModelAndView("views/company/companyedit");
		Enterprise info = enterpriseService.getEnterpriseById(enterpriseId);
		mv.addObject("info", info);
		return mv;
	}
	
	
	//保存企业信息
	@RequestMapping("/saveEnterprise")  
	@ResponseBody
	public Map<String,Object> saveEnterprise(
			@RequestParam(value = "enterpriseId", defaultValue = "") String enterpriseId,
			@RequestParam(value = "enterpriseName", defaultValue = "") String enterpriseName,
			@RequestParam(value = "enterpriseScale", defaultValue = "") String enterpriseScale,
			@RequestParam(value = "enterpriseProfile", defaultValue = "") String enterpriseProfile,
			@RequestParam(value = "enterpriseURL", defaultValue = "") String enterpriseURL,
			@RequestParam(value = "enterpriseAddr", defaultValue = "") String enterpriseAddr,
			@RequestParam(value = "enterpriseStatus", defaultValue = "1") Integer enterpriseStatus,
			@RequestParam(value = "abateResource", defaultValue = "") String abateResource,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//查询企业是否存在
		Enterprise isEx = null;
		if(enterpriseId!=null && !"".equals(enterpriseId)){//
			isEx = enterpriseService.getEnterpriseById(enterpriseId);
		}else{//
			isEx = new Enterprise();
			isEx.setEnterpriseId(SerialNumber.createSerial("ent", 4));
		}
		isEx.setEnterpriseName(enterpriseName);
		isEx.setEnterpriseScale(enterpriseScale);
		isEx.setEnterpriseProfile(enterpriseProfile);
		isEx.setEnterpriseURL(enterpriseURL);
		isEx.setEnterpriseAddr(enterpriseAddr);
		isEx.setEnterpriseStatus(enterpriseStatus);
		isEx.setAbateResource(abateResource);
		if(enterpriseId!=null && !"".equals(enterpriseId)){//
			if(enterpriseService.updateEnterprise(isEx)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "保存信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "保存信息失败");
			}
		}else{//
			if(enterpriseService.insertEnterprise(isEx)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "保存信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "保存信息失败");
			}
		}
		return resultMap;
	}
	
	//进入新增页面
	@RequestMapping("/toAddEnterprise")  
    public ModelAndView toAddEnterprise(){
		ModelAndView mv = new ModelAndView("views/company/companyadd");
		return mv;
	}
	
	//企业列表
	@RequestMapping("/allEnterpriseList")  
    public ModelAndView allEnterpriseList(
    		@RequestParam(value = "enterpriseName", defaultValue = "") String enterpriseName,
    		@RequestParam(value = "enterpriseURL", defaultValue = "") String enterpriseURL,
			@RequestParam(value = "enterpriseAddr", defaultValue = "") String enterpriseAddr,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/company/companylist");
		enterpriseName = URLDecoder.decode(enterpriseName,"UTF-8");
		enterpriseURL = URLDecoder.decode(enterpriseURL,"UTF-8");
		enterpriseAddr = URLDecoder.decode(enterpriseAddr,"UTF-8");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(enterpriseName!=null && !"".equals(enterpriseName)){
			conMap.put("enterpriseName", enterpriseName);
			mv.addObject("enterpriseName", enterpriseName);
		}
		if(enterpriseURL!=null && !"".equals(enterpriseURL)){
			conMap.put("enterpriseURL", enterpriseURL);
			mv.addObject("enterpriseURL", enterpriseURL);
		}
		if(enterpriseAddr!=null && !"".equals(enterpriseAddr)){
			conMap.put("enterpriseAddr", enterpriseAddr);
			mv.addObject("enterpriseAddr", enterpriseAddr);
		}
		
		List<Enterprise> lsit = enterpriseService.getAllEnterprise(conMap);		
		int total = enterpriseService.getAllEnterpriseCount(conMap); 
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
		return mv;
	}
	
}
