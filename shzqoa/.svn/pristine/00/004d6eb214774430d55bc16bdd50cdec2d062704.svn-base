package com.shzqoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.shzqoa.model.ItemManagement;
import com.shzqoa.model.Items;
import com.shzqoa.model.ResumeSource;
import com.shzqoa.model.User;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.ItemsService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource 
	private CustomerInfoService customerinfoService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private UserService userService;// 注入UserService层,外键取值
	
	
	@RequestMapping("/openedit")  
	@ResponseBody
	public ModelAndView openedit(
			@RequestParam(value = "Id", defaultValue = "0") String id){
		ModelAndView mv = new ModelAndView("views/item/modifyitem");
		Map<String,Object> list=itemsService.getItemById(id);
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/openmanageredit")  
	@ResponseBody
	public ModelAndView openmanageredit(
			@RequestParam(value = "Id", defaultValue = "0") String id){
		ModelAndView mv = new ModelAndView("views/item/modifymanageitem");
		Map<String,Object> list=itemsService.getmanagItemById(id);
		mv.addObject("list", list);
		mv.addObject("userlist", userService.getAllUsers());
		mv.addObject("itemlist", customerinfoService.getItemList());
		mv.addObject("cuslist", customerinfoService.getAllcustomerinfo());
		return mv;
	}
	
	@RequestMapping("/itemsList")  
    public ModelAndView itemsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/item/items");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Map<String,Object>> lsit = itemsService.getAllItems(conMap);
		int total = itemsService.getAllItemsCount(conMap);
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
	
	
	@RequestMapping("/saveItem")  
	@ResponseBody
	public Map<String,Object> saveItem(
			@RequestParam(value = "name", defaultValue = "") String name,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		Items info = new Items();
		info.setId(SerialNumber.createSerial("follow", 5));
		info.setName(name);
		if(itemsService.insertItem(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加物资成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加物资失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/saveitemmanagement")  
	@ResponseBody
	public Map<String,Object> saveitemmanagement(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "renttime", defaultValue = "") String renttime,
			@RequestParam(value = "rentitem", defaultValue = "") String rentitem,
			@RequestParam(value = "type1", defaultValue = "") String type1,
			HttpServletRequest request) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User) request.getSession().getAttribute("user");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ItemManagement  info =new ItemManagement();
		info.setId(SerialNumber.createSerial("follow", 5));
		info.setName(name);
		info.setRentitem(rentitem);
		info.setRenttime(sdf.parse(renttime.replaceAll(" +","")));
		info.setHandler(user.getUsercode());
		info.setStatus("1");
		info.setType(type1);
		
		if(itemsService.insertItemmanagement(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加借出信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加借出信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/retttuitem")  
	@ResponseBody
	public Map<String,Object> retttuitem(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "returntime", defaultValue = "") String returntime,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User) request.getSession().getAttribute("user");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ItemManagement  info =itemsService.getItemmanageModelById(id);
		info.setReturntime(sdf.parse(returntime.replaceAll(" +","")));
		info.setStatus("2");
		info.setReturnhandler(user.getUsercode());
		int delflag = itemsService.updatemanagerItemById(info);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "归还成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "归还失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/delmanagerById")  
	@ResponseBody
	public Map<String,Object> delmanagerById(
			@RequestParam(value = "id", defaultValue = "0") String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("id", id);
		//判断简历来源是否使用
		/*int count = customerDetailService.getCustomerinfoCountByCon(resultMap);*/
		//判断物资是否使用
			int delflag = resumeSourceService.delmanagerById(id);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除物资成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除物资失败");
			
		}
		return resultMap;
	}
	@RequestMapping("/delById")  
	@ResponseBody
	public Map<String,Object> delById(
			@RequestParam(value = "id", defaultValue = "0") String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("id", id);
		//判断简历来源是否使用
		/*int count = customerDetailService.getCustomerinfoCountByCon(resultMap);*/
		//判断物资是否使用
		int count=customerinfoService.getitemsById(resultMap);
		if(count>0){
			resultMap.put("status",1);
			resultMap.put("msg", "目前物资有人员使用，无法删除。");
		}else{
			int delflag = itemsService.delItemsById(id);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除物资成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除物资失败");
			}
		}
		return resultMap;
	}
	
	/*@RequestMapping("/modifyitem")  
	public ModelAndView toEditResumeSourceById(
			@RequestParam(value = "id", defaultValue = "0") Integer id){
		ModelAndView mv = new ModelAndView("views/resumeSource/EditResumeSource");
		ResumeSource info = itemsService.getResumeSourceById(id);
		mv.addObject("info", info);
		return mv;
	}*/
	
	@RequestMapping("/updateitem")  
	@ResponseBody
	public Map<String,Object> updateitem(
			@RequestParam(value = "id", defaultValue = "0") String id,
			@RequestParam(value = "name", defaultValue = "") String name){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("id", id);
		//判断简历来源是否使用
		int count=customerinfoService.getitemsById(resultMap);
		if(count>0){
			resultMap.put("status",1);
			resultMap.put("msg", "目前该物资有正在使用的人员，无法修改。");
		}else{
			/*ResumeSource info = itemsService.getResumeSourceById(id);
			info.setResumesourcename(name);*/
			Items  info =itemsService.getItemModelById(id);
			info.setName(name);
			int delflag = itemsService.updateItemById(info);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "更新物资成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "更新物资失败");
			}
		}
		
		return resultMap;
	}
	
	@RequestMapping("/updatemanageitem")  
	@ResponseBody
	public Map<String,Object> updatemanageitem(
			@RequestParam(value = "id", defaultValue = "0") String id,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "renttime", defaultValue = "") String renttime,
			@RequestParam(value = "returntime", defaultValue = "") String returntime,
			@RequestParam(value = "rentitem", defaultValue = "") String rentitem,
			@RequestParam(value = "type", defaultValue = "") String type
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
				resultMap.put("id", id);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			ItemManagement  info =itemsService.getItemmanageModelById(id);
			info.setName(name);
			info.setRentitem(rentitem);
			info.setRenttime(sdf.parse(renttime.replaceAll(" +","")));
			info.setReturntime(sdf.parse(returntime.replaceAll(" +","")));
			info.setType(type);
			int delflag = itemsService.updatemanagerItemById(info);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "更新成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "更新失败");
			}
		
		return resultMap;
	}
	
}
