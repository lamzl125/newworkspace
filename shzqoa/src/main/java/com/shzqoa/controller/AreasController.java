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

import com.shzqoa.model.Areas;
import com.shzqoa.service.AreasService;
@Controller
@RequestMapping(value = "/areas")
public class AreasController {
	@Resource
	private AreasService areasService;
	
	@RequestMapping("/toAddAreas")  
    public ModelAndView toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/areas/areaManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Areas> lsit = areasService.getAllAreas(conMap);
		
		int total = areasService.getAllAreasCount(conMap);
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
	
	@RequestMapping("/saveAreas")  
	@ResponseBody
	public Map<String,Object> saveAreas(
			@RequestParam(value = "areaid", defaultValue = "") String areaid,
			@RequestParam(value = "areaname", defaultValue = "") String areaname,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//查询地区编号是否存在
		Areas isEx = areasService.getAreaById(areaid);
		if(isEx !=null){
			resultMap.put("status", 1);
			resultMap.put("msg", "该地区编号已存在");
			
		}else{
			Areas area = new Areas();
			area.setAreaid(areaid);
			area.setAreaname(areaname);
			if(areasService.addArea(area)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "添加地区信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "添加地区信息失败");
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/delAreasById")  
	@ResponseBody
	public Map<String,Object> delAreasById(
			@RequestParam(value = "areaid", defaultValue = "") String areaid){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(areaid==null || "".equals(areaid)){
			resultMap.put("status", 1);
			resultMap.put("msg", "删除地区信息失败，地区Id不能为空");
		}else{
			int delflag = areasService.delAreaById(areaid);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除地区信息成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除地区信息失败");
			}
		}
		return resultMap;
	}
	
}
