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
import com.shzqoa.model.Profession;
import com.shzqoa.service.ProfessionService;

@Controller
@RequestMapping("/profession")
public class ProfessionController {
	@Resource
	private ProfessionService  professiService;
	
	@RequestMapping("/toProfession")  
    public ModelAndView toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/profession/professManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Profession> lsit = professiService.getAllProfess(conMap);
		
		int total = professiService.getAllProfessCount(conMap);
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
	
	@RequestMapping("/saveProfess")  
	@ResponseBody
	public Map<String,Object> saveProfess(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "name", defaultValue = "") String name,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//查询技术编号是否存在
	  Profession isEx = professiService.getProById(id);
		if(isEx !=null){
			resultMap.put("status", 1);
			resultMap.put("msg", "该技术编号已存在");
			
		}else{
			Profession profession = new Profession();
			profession.setId(id);
			profession.setName(name);
			if((professiService.addProfess(profession)>0)){
				resultMap.put("status", 0);
				resultMap.put("msg", "添加技术方向信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "添加技术方向信息失败");
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/delProfessById")  
	@ResponseBody
	public Map<String,Object> delProfessById(
			@RequestParam(value = "id", defaultValue = "") String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int delflag = professiService.delProfessById(id);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除技术方向成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "删除技术方向失败");
		}
		return resultMap;
	}
	
}
