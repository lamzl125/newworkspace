package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.shzqoa.model.Rights;
import com.shzqoa.service.GroupRightService;
import com.shzqoa.service.RightsService;
@Controller
@RequestMapping(value = "/rights")
public class RightController {
	@Resource
	private RightsService rightsService;
	@Resource
	private GroupRightService groupRightService;
	
	/**
	 * 进入权限列表
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/rightsList")  
    public ModelAndView rightsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "searchrightid", defaultValue = "") String searchrightid,
    		@RequestParam(value = "searchrightname", defaultValue = "") String searchrightname,
    		@RequestParam(value = "searchParentRightId", defaultValue = "") String searchParentRightId
    		) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/rights/rightManage");
		searchrightname = URLDecoder.decode(searchrightname,"UTF-8");
		Map<String,Object> conMap= new HashMap<String,Object>();
		List<Rights> allrightList = rightsService.getAllRights(conMap);
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		if(searchrightid!=null && !"".equals(searchrightid)){
			conMap.put("rightid", searchrightid);
			mv.addObject("searchrightid", searchrightid);
		}
		if(searchrightname!=null && !"".equals(searchrightname)){
			conMap.put("rightname", searchrightname);
			mv.addObject("searchrightname", searchrightname);
		}
		if(searchParentRightId!=null && !"".equals(searchParentRightId)){
			conMap.put("parentRightid", searchParentRightId);
			mv.addObject("searchParentRightId", searchParentRightId);
		}
		
		List<Rights> lsit = rightsService.getAllRights(conMap);
		int total = rightsService.getAllRightsCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("allrightList", allrightList);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", lsit);
		return mv;
	}
	
	/**
	 * 新增权限
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/saveRight")  
	@ResponseBody
	public Map<String,Object> saveRight(
			@RequestParam(value = "addParentId", defaultValue = "") String addParentId,
			@RequestParam(value = "addRightId", defaultValue = "") String addRightId,
			@RequestParam(value = "addRightname", defaultValue = "") String addRightname,
			@RequestParam(value = "addRightURL", defaultValue = "") String addRightURL,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(addParentId==""){
			resultMap.put("status", 1);
			resultMap.put("msg", "父菜单不能为空");
			return resultMap;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		//查询权限编号是否存在
		Rights isEx = rightsService.getRightById(addRightId);
		if(isEx !=null){
			resultMap.put("status", 1);
			resultMap.put("msg", "该权限编号已存在");
		}else{
			Rights info = new Rights();
			info.setParentid(addParentId);
			info.setRightid(addRightId);
			if(!"-1".equals(addParentId)){
				Rights parentRight = rightsService.getRightById(addParentId);
				info.setRightlevel(parentRight.getRightlevel()+1);
			}else{
				info.setRightlevel(1);
			}
			info.setRightname(addRightname);
			info.setUrl(addRightURL);
			if(rightsService.addRight(info)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "添加权限信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "添加权限信息失败");
			}
		}
		return resultMap;
	}
	
	
	/**
	 * 根据权限Id查询最大子Id
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getMaxRightId")  
	@ResponseBody
	public Map<String,Object> getMaxRightId(
			@RequestParam(value = "addParentId", defaultValue = "") String addParentId,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//根据权限Id查询最大子Id
		Rights maxChildRight = rightsService.getMaxRightIdByParentId(addParentId);
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
	
	
	/**
	 * 进入编辑权限
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toEditRight")  
	public ModelAndView toEditRight(
			@RequestParam(value = "rightid", defaultValue = "") String rightid,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ModelAndView mv = new ModelAndView("views/rights/EditRight");
		
		List<Rights> rightList = rightsService.getAllRights(new HashMap<String,Object>());
		
		Rights info = rightsService.getRightById(rightid);
		mv.addObject("info", info);
		mv.addObject("rightList", rightList);
		return mv;
	}
	
	
	/**
	 * 更改父权限-根据父权限ID查询父权限
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/updateParentId")  
	@ResponseBody
	public Map<String,Object> updateParentId(
			@RequestParam(value = "parentid", defaultValue = "") String parentid,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		Rights parentRight = rightsService.getRightById(parentid);
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
	
	
	/**
	 * 更改权限信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
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
		//判断权限是否有绑定用户组
		int isFlag = groupRightService.getGroupRightCountByRightId(rightid);
		if(isFlag>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "该权限有绑定到某用户组，请先解除绑定关系后再试");
		}else{
			Rights parentRight = new Rights();
			Rights right = rightsService.getRightById(rightid);
			if(right != null){
				right.setRightname(rightname);
				right.setParentid(parentid);
				right.setUrl(url);
				if("-1".equals(parentid)){
					right.setRightlevel(1);
				}else{
					parentRight = rightsService.getRightById(parentid);
					if(parentRight!=null){
						right.setRightlevel(parentRight.getRightlevel()+1);
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "查询信息失败");
					}
				}
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
		}
		return resultMap;
	}
	
	
	
	
}
