package com.shzqoa.controller;

import java.util.ArrayList;
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
import com.shzqoa.model.User;
import com.shzqoa.model.UserGroup;
import com.shzqoa.service.GroupService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;


@Controller
@RequestMapping(value = "/usergroup")
public class UserGroupController {
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private UserService userService;
	@Resource
	private GroupService groupService;
	
	@RequestMapping("/userGroupList")  
    public ModelAndView userGroupList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/usergroup/userGroup");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("userstatus", 2);
		List<User> userList = userService.queryCurList(conMap);
		
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Group> groupList = groupService.getGroupList();
		List<UserGroup> userGroupList = new ArrayList<UserGroup>();
		if(userList!=null && userList.size()>0){
			User user = userList.get(0);
			userGroupList = userGroupService.getUserGroupListByUserCode(user.getUsercode());
		}
		
		mv.addObject("list1", userList);
		mv.addObject("list2", groupList);
		mv.addObject("list3", userGroupList);
		return mv;
	}
	
	
	@RequestMapping("/setUserGroup")  
	@ResponseBody
	public Map<String,Object> setUserGroup(
			@RequestParam(value = "list1Check", defaultValue = "") String list1Check,
			@RequestParam(value = "list2Check", defaultValue = "") String list2Check,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if("".equals(list2Check)){
			try{
				//解除绑定关系
				int c = userGroupService.delUserGroupByUserCode(list1Check);
				if(c>=0){
					resultMap.put("status", 0);
					resultMap.put("msg", "用户解除绑定成功");
				}
			}catch(Exception e){
				resultMap.put("status", 1);
				resultMap.put("msg", "用户解除绑定失败");
			}
		}else{
			String[] groupids = list2Check.split(",");
			if(groupids==null || groupids.length==0){
				resultMap.put("status", 1);
				resultMap.put("msg", "请务必选择一个用户组");
			}else{
				try{
					int result = userGroupService.setUserGroup(list1Check,groupids);
					if(result>0){
						resultMap.put("status", 0);
						resultMap.put("msg", "用户绑定用户组设置成功");
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "用户绑定用户组设置失败");
					}
				}catch(Exception e){
					resultMap.put("status", 1);
					resultMap.put("msg", "用户绑定用户组设置失败");
				}
			}
		}
		
		return resultMap;
	}
	
	
	@RequestMapping("/getCheckList2ByCheck1")  
	@ResponseBody
	public Map<String,Object> getCheckList2ByCheck1(
			@RequestParam(value = "list1Check", defaultValue = "") String list1Check,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		List<UserGroup> userGroupList = userGroupService.getUserGroupListByUserCode(list1Check);
		List<Group> groupList = groupService.getGroupList();
		resultMap.put("status", 0);
		resultMap.put("msg", "查询信息成功");
		resultMap.put("getList2", userGroupList);
		resultMap.put("list2", groupList);
		resultMap.put("list1Check", list1Check);
		return resultMap;
	}
	
}
