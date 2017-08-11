package com.shzqoa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Group;
import com.shzqoa.model.GroupRight;
import com.shzqoa.model.Rights;
import com.shzqoa.service.GroupRightService;
import com.shzqoa.service.GroupService;
import com.shzqoa.service.RightsService;


@Controller
@RequestMapping(value = "/groupright")
public class GroupRightController {
	@Resource
	private GroupRightService groupRightService;
	@Resource
	private RightsService rightsService;
	@Resource
	private GroupService groupService;
	
	@RequestMapping("/groupRightList")  
    public ModelAndView groupRightList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/groupright/groupRight");
//		Map<String,Object> conMap= new HashMap<String,Object>();
//		
//		List<Rights> rightList = rightsService.getAllRights(conMap);
//		List<Group> groupList = groupService.getGroupList();
//		mv.addObject("currpage", page);
//		conMap.put("start", (page-1)*pageSize);
//		conMap.put("pageSize", pageSize);
//		
//		
//		List<GroupRight> userGroupList = new ArrayList<GroupRight>();
//		if(groupList!=null && groupList.size()>0){
//			Group group = groupList.get(0);
//			userGroupList = groupRightService.getGroupRightListByGroupId(group.getGroupid());
//		}
//		
//		mv.addObject("list1", groupList);
//		mv.addObject("list2", rightList);
//		mv.addObject("list3", userGroupList);
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
				int c = groupRightService.delGroupRightByGroupId(list1Check);
				if(c>=0){
					resultMap.put("status", 0);
					resultMap.put("msg", "用户组解除绑定成功");
				}
			}catch(Exception e){
				resultMap.put("status", 1);
				resultMap.put("msg", "用户组解除绑定失败");
			}
		}else{
			String[] rightsids = list2Check.split(",");
			if(rightsids==null || rightsids.length==0){
				resultMap.put("status", 1);
				resultMap.put("msg", "请务必选择一个权限");
			}else{
				try{
					int result = groupRightService.setGroupRight(list1Check,rightsids);
					if(result>0){
						resultMap.put("status", 0);
						resultMap.put("msg", "用户组绑定权限设置成功");
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "用户组绑定权限设置失败");
					}
				}catch(Exception e){
					resultMap.put("status", 1);
					resultMap.put("msg", "用户组绑定权限设置失败");
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
		
		List<GroupRight> groupRightList = groupRightService.getGroupRightListByGroupId(list1Check);
		resultMap.put("status", 0);
		resultMap.put("msg", "查询信息成功");
		resultMap.put("getList2", groupRightList);
		resultMap.put("list1Check", list1Check);
		return resultMap;
	}
	
	
	@RequestMapping("/doGetPrivilegeTree")  
	public void doGetPrivilegeTree(@RequestParam(value = "groupid", defaultValue = "") String groupid,
			HttpServletResponse response) throws IOException{
		List<GroupRight> userGroupList = groupRightService.getGroupRightListByGroupId(groupid);
		List<String> lstTree = getRights("-1",userGroupList);
        //利用Json插件将Array转换成Json格式  
        response.getWriter().print(JSONArray.fromObject(lstTree).toString());  
    } 
	
	
	
	@RequestMapping("/doGetGroupTree")  
	public void doGetGroupTree(HttpServletResponse response) throws IOException{
		List<Group> groupList = groupService.getGroupList();
        //利用Json插件将Array转换成Json格式  
		List<String> lstTree = new ArrayList<String>();
		for(Group info:groupList){
			if(lstTree==null || lstTree.size()==0){
				lstTree.add("{id:\""+info.getGroupid()+"\", pId:0, name:\""+info.getGroupname()+"\" , open:true,checked:true}");
			}else{
				lstTree.add("{id:\""+info.getGroupid()+"\", pId:0, name:\""+info.getGroupname()+"\" , open:true}");
			}
		}
        response.getWriter().print(JSONArray.fromObject(lstTree).toString());  
    } 
	
	
	
	
	/*
	 * 递归获取权限
	 */
	List<String> getRights(String parentid,List<GroupRight> userGroupList){
		List<String> strList = new ArrayList<String>();
		List<Rights> listright = new ArrayList<Rights>();
		listright = rightsService.getRightsByParentId(parentid);
		if(listright!=null && listright.size()>0){
			for(Rights info :listright){
				int c = 0;
				for(GroupRight ringhtinfo :userGroupList){
					if(info.getRightid().endsWith(ringhtinfo.getRightid())){
						strList.add("{id:"+info.getRightid()+", pId:"+info.getParentid()+", name:\""+info.getRightname()+"\" , open:true,checked:true}");
						c++;
					}
				}
				if(c==0){
					strList.add("{id:"+info.getRightid()+", pId:"+info.getParentid()+", name:\""+info.getRightname()+"\" , open:true}");
				}
				strList.addAll(getRights(info.getRightid(),userGroupList));
			}
		}
		return strList;
	}
	
}
