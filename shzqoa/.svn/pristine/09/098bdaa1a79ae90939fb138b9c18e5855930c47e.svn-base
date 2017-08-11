package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.PlantHeader;
import com.shzqoa.model.User;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.PlantHeaderService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/plantheader")
public class PlantHeaderController {
	private static String FACTORY = "项目工厂";
	@Resource
	private PlantHeaderService plantHeaderService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private UserService userService;
	
	//查询某厂区的负责人列表
	@RequestMapping("/stlHeaderByPlant")
	@ResponseBody
	public ResultObject stlHeaderByPlant(
			@RequestParam(value = "plantId", defaultValue = "") Long plantId,
			HttpServletRequest request){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(plantId!=null && !"".equals(plantId)){
				Map<String,Object> acMap= new HashMap<String,Object>();
				acMap.put("statusFlag", 1);
				acMap.put("plantId", plantId);
				List<Map<String, Object>> list = plantHeaderService.getResultByMap(acMap);
				if(list!=null && list.size()>=0){
					result.setSuccess(true);
					result.setResultData(list);
				}else{
					result.setSuccess(false);
					result.setResultMessage("查询厂区负责人失败");
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("查询厂区负责人失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	
	@RequestMapping("/showPlantHeader")  
    public ModelAndView showPlantHeader(String plantHeaderId){
		ModelAndView	mv = new ModelAndView("views/plantheader/plantheader");
		PlantHeader info = plantHeaderService.getResultById(plantHeaderId);
		mv.addObject("map",info);
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("userstatus", 2);
		mv.addObject("userlist", userService.queryCurList(acMap));
		return mv;
	}
	
	
	@RequestMapping("/toPlantHeaderList")  
    public ModelAndView toPlantHeaderList(
    		@RequestParam(value = "plantId", defaultValue = "") Long plantId,
    		@RequestParam(value = "userCode", defaultValue = "") String userCode,
    		@RequestParam(value = "statusFlag", defaultValue = "") Integer statusFlag,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/plantheader/plantheaderManage");
		userCode = URLDecoder.decode(userCode,"UTF-8");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(plantId!=null && plantId > 0){
			acMap.put("plantId", plantId);
			mv.addObject("plantId",plantId);
		}
		if(userCode!=null && !"".equals(userCode)){
			acMap.put("userCode", userCode);
			mv.addObject("userCode",userCode);
		}
		if(statusFlag!=null){
			acMap.put("statusFlag", statusFlag);
			mv.addObject("statusFlag",statusFlag);
		}
		
		List<Map<String, Object>> list = plantHeaderService.getResultByMap(acMap);
		int total = plantHeaderService.getResultCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("list",list);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		acMap.put("userstatus", 2);
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		mv.addObject("userlist", userService.queryCurList(acMap));
		return mv;
	}
	
	
	
	@RequestMapping(value="/savePlantHeader")
	@ResponseBody
	public ResultObject savePlantHeader(
			@RequestParam(value = "plantId", defaultValue = "") Long plantId,
			@RequestParam(value = "userCode", defaultValue = "") String userCode,
			@RequestParam(value = "plantHeaderId", defaultValue = "") String plantHeaderId,
			@RequestParam(value = "statusFlag", defaultValue = "1") Integer statusFlag,
			@RequestParam(value = "cancellationTime", defaultValue = "") String cancellationTime,
			@RequestParam(value = "invalid", defaultValue = "") String invalid,
			HttpServletRequest request){
		ResultObject result = ResultObject.getResultObject();
		User user = (User)request.getSession().getAttribute("user");
		//根据厂区负责人查询是否存在正常状态
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("plantId", plantId);
		acMap.put("userCode", userCode);
		acMap.put("statusFlag", 1);
		Integer c = plantHeaderService.getResultCountByMap(acMap);
		if(c!=null && c>0){
			result.setSuccess(false);
			result.setResultMessage("该厂区该负责人已存在，无需再次添加");
		}else{
			try {
				PlantHeader info = new PlantHeader();
				if(plantHeaderId!=null && !"".equals(plantHeaderId)){
					info = plantHeaderService.getResultById(plantHeaderId);
				}else if(plantHeaderId==null || "".equals(plantHeaderId)){
					info.setPlantHeaderId(SerialNumber.createSerial("plhd", 4));
					info.setAddPeople(user.getUsercode());
					info.setAddTime(new Date());
				}
				info.setPlantId(plantId);
				info.setUserCode(userCode);
				info.setStatusFlag(statusFlag);
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if(cancellationTime!=null && !"".equals(cancellationTime)){
					info.setCancellationTime(sf.parse(cancellationTime));
				}
				if(invalid!=null && !"".equals(invalid)){
					info.setInvalid(invalid);
				}
				
				int resultcount = 0;
				if(plantHeaderId!=null && !"".equals(plantHeaderId)){
					resultcount = plantHeaderService.update(info);
				}else{
					resultcount = plantHeaderService.save(info);
				}
				if(resultcount>0){
					result.setSuccess(true);
					result.setResultMessage("保存成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("保存失败");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setResultMessage(e.getMessage());
			}
		}     
		return result;
	}
	
	
	
	
	@RequestMapping("/delPlantHeader")
	@ResponseBody
	public ResultObject delPlantHeader(
			@RequestParam(value = "plantHeaderId", defaultValue = "") String plantHeaderId,
			HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		ResultObject result = ResultObject.getResultObject();
		try {
			if(plantHeaderId!=null && !"".equals(plantHeaderId)){
				PlantHeader info = plantHeaderService.getResultById(plantHeaderId);
				info.setStatusFlag(2);
				info.setInvalid(user.getUsercode());
				info.setCancellationTime(new Date());
				int i = plantHeaderService.update(info);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("作废成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("作废失败");
				}
			}else{
				result.setSuccess(false);
				result.setResultMessage("作废失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
}
