package com.shzqoa.controller;

import java.text.ParseException;
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

import com.shzqoa.model.Group;
import com.shzqoa.service.GroupRightService;
import com.shzqoa.service.GroupService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/group")
public class GroupController {
	@Resource
	private GroupService groupService;
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private GroupRightService groupRightService;
	
	
	
	@RequestMapping("/groupList")  
    public ModelAndView rightsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/group/GroupManage");		
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Group> lsit = groupService.getAllGroup(conMap);
		int total = groupService.getAllGroupCount(conMap);
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
	
	
	@RequestMapping("/saveGroup")  
	@ResponseBody
	public Map<String,Object> saveRight(
			@RequestParam(value = "addgroupname", defaultValue = "") String addgroupname,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		Group info = new Group();
		info.setGroupid(SerialNumber.createSerial("group", 5));
		info.setGroupname(addgroupname);
		if(groupService.addGroup(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加用户组息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加用户组信息失败");
		}
		return resultMap;
	}
	
	
	@RequestMapping("/delGroupById")  
	@ResponseBody
	public Map<String,Object> delGroupById(
			@RequestParam(value = "groupid", defaultValue = "") String groupid){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//判断用户组是否绑定了用户
		int count = userGroupService.getUserGroupCounttByGroupid(groupid);
		if(count>0){
			resultMap.put("status",1);
			resultMap.put("msg", "目前该用户组绑定的有用户，请先解除绑定再试。");
		}else{
			//判断用户组是否绑定了权限
			List list = groupRightService.getGroupRightListByGroupId(groupid);
			if(list==null || list.size()>0){
				resultMap.put("status",1);
				resultMap.put("msg", "目前该用户组绑定的有权限，请先解除绑定再试。");
			}else{
				int delflag = groupService.delGroupById(groupid);
				if(delflag>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "删除用户组信息成功");
				}else{
					resultMap.put("status",1);
					resultMap.put("msg", "删除用户组信息失败");
				}
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/toEditGroupById")  
	public ModelAndView toEditGroupById(
			@RequestParam(value = "groupid", defaultValue = "") String groupid){
		ModelAndView mv = new ModelAndView("views/group/EditGroup");
		Group info = groupService.getGroupById(groupid);
		mv.addObject("info", info);
		return mv;
	}
	
	@RequestMapping("/updateGroupById")  
	@ResponseBody
	public Map<String,Object> updateGroupById(
			@RequestParam(value = "groupid", defaultValue = "") String groupid,
			@RequestParam(value = "groupname", defaultValue = "") String groupname){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Group info = groupService.getGroupById(groupid);
		info.setGroupname(groupname);
		int delflag = groupService.updateGroup(info);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "更新用户组信息成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "更新用户组信息失败");
		}
		return resultMap;
	}
	
	/*
	@RequestMapping("/getMaxRightId")  
	@ResponseBody
	public Map<String,Object> getMaxRightId(
			@RequestParam(value = "addParentId", defaultValue = "") String addParentId,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//根据权限Id查询最大子Id
		Group maxChildRight = rightsService.getMaxRightIdByParentId(addParentId);
		if(maxChildRight!=null){
			resultMap.put("status", 0);
			resultMap.put("msg", "查询信息成功");
			resultMap.put("maxChildRight", maxChildRight);
			resultMap.put("addParentId", addParentId);
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "查询信息失败");
			resultMap.put("addParentId", addParentId);
		}
		return resultMap;
	}
	
	@RequestMapping("/toEditRight")  
	public ModelAndView toEditRight(
			@RequestParam(value = "rightid", defaultValue = "") String rightid,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mv = new ModelAndView("views/rights/EditRight");
		
		List<Group> rightList = rightsService.getAllRights(new HashMap<String,Object>());
		
		Group info = rightsService.getRightById(rightid);
		mv.addObject("info", info);
		mv.addObject("rightList", rightList);
		return mv;
	}
	
	@RequestMapping("/updateParentId")  
	@ResponseBody
	public Map<String,Object> updateParentId(
			@RequestParam(value = "parentid", defaultValue = "") String parentid,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		Group parentRight = rightsService.getRightById(parentid);
		if(parentRight!=null){
			resultMap.put("status", 0);
			resultMap.put("msg", "查询信息成功");
			resultMap.put("parentRight", parentRight);
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "查询信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/updateRightById")  
	@ResponseBody
	public Map<String,Object> updateRightById(
			@RequestParam(value = "rightid", defaultValue = "") String rightid,
			@RequestParam(value = "rightname", defaultValue = "") String rightname,
			@RequestParam(value = "parentid", defaultValue = "") String parentid,
			@RequestParam(value = "url", defaultValue = "") String url,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		Group parentRight = rightsService.getRightById(parentid);
		if(parentRight!=null){
			Group right = rightsService.getRightById(rightid);
			if(right != null){
				right.setRightname(rightname);
				right.setParentid(parentid);
				right.setUrl(url);
				right.setRightlevel(parentRight.getRightlevel()+1);
				if(rightsService.updateRightById(right)>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "更新信息成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "更新信息失败");
				}
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "查询信息失败");
			}
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "查询信息失败");
		}
		return resultMap;
	}
	
	*/
	
	
}
