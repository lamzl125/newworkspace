package com.shzqoa.controller;

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

import com.shzqoa.model.Parameter;
import com.shzqoa.model.ParameterKind;
import com.shzqoa.service.ParameterKindService;
import com.shzqoa.service.ParameterService;
@Controller
@RequestMapping(value = "/basepara")
public class BaseParController {
	@Resource
	private ParameterKindService parameterKindService;
	@Resource
	private ParameterService parameterService;
	
	/**
	 * 参数种类
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/paraKindList")  
    public ModelAndView paraKindList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "searchid", defaultValue = "0") Long searchid,
    		@RequestParam(value = "searchname", defaultValue = "") String searchname
    		){
		ModelAndView mv = new ModelAndView("views/baseParameter/parameterKindManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		if(searchid!=null && searchid!=0){
			conMap.put("parakindid", searchid);
			mv.addObject("searchid", searchid);
		}
		if(searchname!=null && !"".equals(searchname)){
			conMap.put("parakindname", searchname);
			mv.addObject("searchname", searchname);
		}
		List<ParameterKind> lsit = parameterKindService.getAllParameterKind(conMap);
		int total = parameterKindService.getAllParameterKindCount(conMap);
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
	
	/**
	 * 新增参数种类
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/saveParaKind")  
	@ResponseBody
	public Map<String,Object> saveParaKind(
			@RequestParam(value = "parakindid", defaultValue = "") Long parakindid,
			@RequestParam(value = "parakindname", defaultValue = "") String parakindname,
			@RequestParam(value = "orderindex", defaultValue = "0") Integer orderindex,
			HttpServletRequest request,HttpServletResponse response
			) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(parakindid==0){//新增
			List<ParameterKind> exitlist = parameterKindService.getParameterKindByName(parakindname);
			if(exitlist!=null && exitlist.size()>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "参数种类名称已存在");
			}else if(orderindex!=null && orderindex!=0){
				exitlist = parameterKindService.getParameterKindByIndex(orderindex);
				if(exitlist!=null && exitlist.size()>0){
					resultMap.put("status", 1);
					resultMap.put("msg", "参数种类顺序已存在");
				}else{
					ParameterKind info = new ParameterKind();
					info.setParakindname(parakindname);
					info.setOrderindex(orderindex);
					
					if(parameterKindService.addParameterKind(info)>0){
						resultMap.put("status", 0);
						resultMap.put("msg", "添加成功");
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "添加失败");
					}
				}
			}
		}else{//修改
			Map<String,Object> flagMap = new HashMap<String,Object>();
			flagMap.put("parakindid", parakindid);
			List<Parameter> exitParalist = parameterService.getExitParameterByName(flagMap);
			if(exitParalist!=null && exitParalist.size()>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "该种类的参数存在，请先删除参数再进行此操作");
			}else{
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("orderindex", orderindex);
				map.put("parakindname", parakindname);
				map.put("parakindid", parakindid);
				List<ParameterKind> exitlist = parameterKindService.getExitParameterKindByName(map);
				if(exitlist!=null && exitlist.size()>0){
					resultMap.put("status", 1);
					resultMap.put("msg", "要修改的参数种类名称已存在");
				}else if(orderindex!=null && orderindex!=0){
					exitlist = parameterKindService.getExitParameterKindByIndex(map);
					if(exitlist!=null && exitlist.size()>0){
						resultMap.put("status", 1);
						resultMap.put("msg", "要修改的参数种类顺序已存在");
					}else{
						ParameterKind info = parameterKindService.getParameterKindById(parakindid);
						info.setParakindname(parakindname);
						info.setOrderindex(orderindex);
						if(parameterKindService.updateParameterKindById(info)>0){
							resultMap.put("status", 0);
							resultMap.put("msg", "修改成功");
						}else{
							resultMap.put("status", 1);
							resultMap.put("msg", "修改失败");
						}
					}
				}
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/delparaKindById")  
	@ResponseBody
	public Map<String,Object> delparaKindById(
			@RequestParam(value = "id", defaultValue = "0") Long id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> flagMap = new HashMap<String,Object>();
		flagMap.put("parakindid", id);
		List<Parameter> exitParalist = parameterService.getExitParameterByName(flagMap);
		if(exitParalist!=null && exitParalist.size()>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "该种类的参数存在，请先删除参数再进行此操作");
		}else{
			int delflag = parameterKindService.delParameterKindById(id);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除参数种类信息成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除参数种类信息失败");
			}
		}
		
		return resultMap;
	}
	
	
	/**
	 * 进入编辑参数种类
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toEditInfo")  
	public ModelAndView toEditInfo(
			@RequestParam(value = "id", defaultValue = "0") Long id,
			HttpServletRequest request,HttpServletResponse response
			) {
		ModelAndView mv = new ModelAndView("/views/baseParameter/EditParameterKind");
		ParameterKind info = parameterKindService.getParameterKindById(id); 
		
		mv.addObject("status", 0);
		mv.addObject("info", info);
		return mv;
	}
	
	
	/**
	 * 参数
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/parasList")  
    public ModelAndView parasList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "parakindid", defaultValue = "0") Long parakindid,
    		@RequestParam(value = "searchid", defaultValue = "0") Long searchid,
    		@RequestParam(value = "searchname", defaultValue = "") String searchname
    		){
		ModelAndView mv = new ModelAndView("views/baseParameter/parameterManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		
		List<ParameterKind> paraKindlsit = parameterKindService.getAllParameterKind(conMap);
		mv.addObject("paraKindlsit", paraKindlsit);
		mv.addObject("currpage", page);
		mv.addObject("parakindid", parakindid);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("parakindid", parakindid);
		
		if(searchid!=null && searchid!=0){
			conMap.put("id", searchid);
			mv.addObject("searchid", searchid);
		}
		if(searchname!=null && !"".equals(searchname)){
			conMap.put("name", searchname);
			mv.addObject("searchname", searchname);
		}
		
		List<Parameter> lsit = parameterService.getAllParameter(conMap);
		int total = parameterService.getAllParameterCount(conMap);
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
	
	/**
	 * 进入编辑参数
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toEditPara")  
	public ModelAndView toEditPara(
			@RequestParam(value = "id", defaultValue = "0") Long id,
			@RequestParam(value = "addflag", defaultValue = "0") int addflag,
			HttpServletRequest request,HttpServletResponse response
			) {
		ModelAndView mv = new ModelAndView("/views/baseParameter/EditParameter");
		Parameter info = new Parameter(); 
		if(id!=null && id!=0){
			info = parameterService.getParameterById(id);
		}
		List<ParameterKind> paraKindlsit = parameterKindService.getAllParameterKind(new HashMap<String,Object>());
		mv.addObject("paraKindlsit", paraKindlsit);
		mv.addObject("addflag", addflag);
		mv.addObject("status", 0);
		mv.addObject("info", info);
		return mv;
	}
	
	
	/**
	 * 新增参数种类
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/savePara")  
	@ResponseBody
	public Map<String,Object> savePara(
			@RequestParam(value = "id", defaultValue = "") Long id,
			@RequestParam(value = "parakindid", defaultValue = "") Long parakindid,
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "orderindex", defaultValue = "0") Integer orderindex,
			HttpServletRequest request,HttpServletResponse response
			) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> searchMap = new HashMap<String,Object>();
		searchMap.put("parakindid", parakindid);
		if(id==0){//新增
			searchMap.put("name", name);
			List<Parameter> exitlist = parameterService.getParameterByName(searchMap);
			if(exitlist!=null && exitlist.size()>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "参数名称已存在");
			}else if(orderindex!=null && orderindex!=0){
				searchMap.put("orderindex", orderindex);
				exitlist = parameterService.getParameterByIndex(searchMap);
				if(exitlist!=null && exitlist.size()>0){
					resultMap.put("status", 1);
					resultMap.put("msg", "参数顺序已存在");
				}else{
					Parameter info = new Parameter();
					info.setName(name);
					info.setOrderindex(orderindex);
					info.setParakindid(parakindid);
					
					if(parameterService.addParameter(info)>0){
						resultMap.put("status", 0);
						resultMap.put("msg", "添加成功");
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "添加失败");
					}
				}
			}
		}else{//保存
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("orderindex", orderindex);
			map.put("name", name);
			map.put("parakindid", parakindid);
			map.put("id", id);
			List<Parameter> exitlist = parameterService.getExitParameterByName(map);
			if(exitlist!=null && exitlist.size()>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "要修改的参数名称已存在");
			}else if(orderindex!=null && orderindex!=0){
				exitlist = parameterService.getExitParameterByIndex(map);
				if(exitlist!=null && exitlist.size()>0){
					resultMap.put("status", 1);
					resultMap.put("msg", "要修改的参数顺序已存在");
				}else{
					Parameter info = parameterService.getParameterById(id);
					info.setName(name);
					info.setOrderindex(orderindex);
					info.setParakindid(parakindid);
					if(parameterService.updateParameterById(info)>0){
						resultMap.put("status", 0);
						resultMap.put("msg", "修改成功");
					}else{
						resultMap.put("status", 1);
						resultMap.put("msg", "修改失败");
					}
				}
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/delparaById")  
	@ResponseBody
	public Map<String,Object> delparaById(
			@RequestParam(value = "id", defaultValue = "0") Long id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int delflag = parameterService.delParameterById(id);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除参数信息成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "删除参数信息失败");
		}
		return resultMap;
	}
	
	
	
}
