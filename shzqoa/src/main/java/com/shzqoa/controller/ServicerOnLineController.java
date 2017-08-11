package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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

import com.shzqoa.model.ServicerOnLine;
import com.shzqoa.service.ServicerOnLineService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;
@Controller
@RequestMapping(value = "/serviceronline")
public class ServicerOnLineController {
	@Resource
	private ServicerOnLineService servicerOnLineService;
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/effectiveServicerOnLine")
	@ResponseBody
	public ResultObject effectiveServicerOnLine(String id){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(id!=null && !"".equals(id)){
				ServicerOnLine info = servicerOnLineService.getServicerOnLineById(id);
				info.setServicerStatus(1);
				int i = servicerOnLineService.updateServicerOnLine(info);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("启用成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("启用失败");
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("启用失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 不启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/invalidServicerOnLine")
	@ResponseBody
	public ResultObject invalidServicerOnLine(String id){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(id!=null && !"".equals(id)){
				ServicerOnLine info = servicerOnLineService.getServicerOnLineById(id);
				info.setServicerStatus(2);
				int i = servicerOnLineService.updateServicerOnLine(info);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("不启用成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("不启用失败");
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("不启用失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/toEditServicerOnLine")  
    public ModelAndView toEditServicerOnLine(
    		@RequestParam(value = "id", defaultValue = "") String id){
		ModelAndView mv = new ModelAndView("views/serviceronline/serviceradd");
		ServicerOnLine info = servicerOnLineService.getServicerOnLineById(id);
		mv.addObject("info", info);
		return mv;
	}
	
	@RequestMapping("/deleteServicerOnLine")
	@ResponseBody
	public ResultObject deleteServicerOnLine(String id){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(id!=null && !"".equals(id)){
				int i = servicerOnLineService.delServicerOnLineById(id);
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
	
	@RequestMapping("/saveServicerOnLine")  
	@ResponseBody
	public Map<String,Object> saveServicerOnLine(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "serviceName", defaultValue = "") String serviceName,
			@RequestParam(value = "qQ", defaultValue = "") String qQ,
			@RequestParam(value = "weiXin", defaultValue = "") String weiXin,
			HttpServletRequest request,HttpServletResponse response
			) throws UnsupportedEncodingException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//查询服务名称、qq是否存在
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("serviceName", serviceName);	
		if(id!=null && !"".equals(id)){
			conMap.put("id", id);	
		}
		int count = servicerOnLineService.getAllServicerOnLineCount(conMap);
		if(count>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "该在线客服名称已存在");
		}else{
			conMap.remove("serviceName");
			conMap.put("qQ", qQ);
			if(id!=null && !"".equals(id)){
				conMap.put("id", id);	
			}
			count = servicerOnLineService.getAllServicerOnLineCount(conMap);
			if(count>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "该QQ已存在");
			}else{
				ServicerOnLine info = new ServicerOnLine();
				if(id!=null && !"".equals(id)){
					info = servicerOnLineService.getServicerOnLineById(id);
				}else{
					info.setId(SerialNumber.createSerial("sol",4));
				}				
				info.setqQ(qQ);
				info.setReMark("");
				info.setServiceName(serviceName);
				info.setServicerStatus(1);
				info.setWeiXin(weiXin);
				int resultcount = 0;
				if(id!=null && !"".equals(id)){
					resultcount = servicerOnLineService.updateServicerOnLine(info);
				}else{
					resultcount = servicerOnLineService.insertServicerOnLine(info);
				}
				if(resultcount>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "添加/更新在线客服信息成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "添加/更新在线客服信息失败");
				}
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/toAddServicerOnLine")  
    public ModelAndView toAddServicerOnLine(){
		ModelAndView mv = new ModelAndView("views/serviceronline/serviceradd");
		return mv;
	}
	
	@RequestMapping("/servicerOnLineList")  
    public ModelAndView servicerOnLineList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "serviceName", defaultValue = "") String serviceName,
			@RequestParam(value = "qQ", defaultValue = "") String qQ,
			@RequestParam(value = "weiXin", defaultValue = "") String weiXin) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/serviceronline/servicerlist");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		serviceName = URLDecoder.decode(serviceName, "UTF-8");
		qQ = URLDecoder.decode(qQ, "UTF-8");
		weiXin = URLDecoder.decode(weiXin, "UTF-8");
		
		if(serviceName!=null && !"".equals(serviceName)){
			conMap.put("serviceName", serviceName);
			mv.addObject("serviceName", serviceName);
		}
		if(qQ!=null && !"".equals(qQ)){
			conMap.put("qQ", qQ);
			mv.addObject("qQ", qQ);
		}
		if(weiXin!=null && !"".equals(weiXin)){
			conMap.put("weiXin", weiXin);
			mv.addObject("weiXin", weiXin);
		}
		
		List<ServicerOnLine> lsit = servicerOnLineService.getAllServicerOnLine(conMap);		
		int total = servicerOnLineService.getAllServicerOnLineCount(conMap);
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
