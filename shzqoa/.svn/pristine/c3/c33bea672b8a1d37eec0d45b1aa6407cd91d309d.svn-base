package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Template;
import com.shzqoa.service.TemplateService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/template")
public class TemplateController {
	@Resource
	private TemplateService templateService;
	@Resource
	private UserService userService;
	
	
	
	@RequestMapping(value="/saveDemandTemplate")
	@ResponseBody
	public ResultObject saveDemandTemplate(
			@RequestParam(value = "templateName", defaultValue = "") String templateName,
			@RequestParam(value = "templateFile", defaultValue = "") String templateFile
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			Template info = new Template();
			info.setTemplateId(SerialNumber.createSerial("temp", 4));
			info.setTemplateName(templateName);
			info.setTemplateFile(templateFile);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			private int templateOrder;//模版顺序
//			private String customerDemandId;//简历需求ID
//			private String workDemandId;//普工项目Id
//			private int templateStatus;//模版状态（1-启用  2-作废）
//			private Date addTime;//添加时间
//			private String addPeople;//添加人
//			private Date invalidTime;//作废时间
//			private String invalidPeople;//作废人
//			private String reMark;//备注
//			private String reMark1;//备注
//			private String reMark2;//备注
//			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			if(startTime!=null && !"".equals(startTime)){
//				info.setStartTime(sf.parse(startTime));
//			}
//			if(endTime!=null && !"".equals(endTime)){
//				info.setEndTime(sf.parse(endTime));
//			}
			
			int resultcount = 0;
//			if(agentId!=null && !"".equals(agentId)){
//				resultcount = agentService.update(info);
//			}else{
//				resultcount = agentService.save(info);
//			}
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
		return result;
	}
	
	@RequestMapping("/demandtemplatelist")  
    public ModelAndView demandtemplatelist(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView	mv = new ModelAndView("views/customerDemand/demandlist");
		mv.addObject("currpage", page);
		mv.addObject("demandId", demandId);
		Map<String,Object> acMap = new HashMap<String,Object>();
		acMap.put("cusdemandId", demandId);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		List<Map<String, Object>> tmlist = templateService.getTemplateListByMap(acMap);		
		int total = templateService.getTemplateCountByMap(acMap);
		
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
		mv.addObject("list",tmlist);
		mv.addObject("allusers",userService.getAllUsers());
		return mv;
	}
	
	
	/*
	
	
	
	@RequestMapping("/toAgentAdd")  
    public ModelAndView toAgentAdd(){
		ModelAndView	mv = new ModelAndView("views/trainschool/agent");
		List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(new HashMap<String,Object>());
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		mv.addObject("recordlist", recordlist);
		return mv;
	}
	
	@RequestMapping("/toAgentList")  
    public ModelAndView toAgentList(
    		@RequestParam(value = "tripRecordId", defaultValue = "") String tripRecordId,
    		@RequestParam(value = "agentName", defaultValue = "") String agentName,
    		@RequestParam(value = "mobile", defaultValue = "") String mobile,
    		@RequestParam(value = "idCard", defaultValue = "") String idCard,
    		@RequestParam(value = "signAgreement", defaultValue = "") Integer signAgreement,
    		@RequestParam(value = "contractCode", defaultValue = "") String contractCode,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/trainschool/agentManage");
		tripRecordId = URLDecoder.decode(tripRecordId,"UTF-8");
		agentName = URLDecoder.decode(agentName,"UTF-8");
		mobile = URLDecoder.decode(mobile,"UTF-8");	
		idCard = URLDecoder.decode(idCard,"UTF-8");	
		contractCode = URLDecoder.decode(contractCode,"UTF-8");			
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(tripRecordId!=null && !"".equals(tripRecordId)){
			acMap.put("tripRecordId", tripRecordId);
			mv.addObject("tripRecordId",tripRecordId);
		}
		if(agentName!=null && !"".equals(agentName)){
			acMap.put("agentName", agentName);
			mv.addObject("agentName",agentName);
		}
		if(mobile!=null && !"".equals(mobile)){
			acMap.put("mobile", mobile);
			mv.addObject("mobile",mobile);
		}
		if(idCard!=null && !"".equals(idCard)){
			acMap.put("idCard", idCard);
			mv.addObject("idCard",idCard);
		}
		if(signAgreement!=null && signAgreement>=0){
			acMap.put("signAgreement", signAgreement);
			mv.addObject("signAgreement",signAgreement);
		}
		if(contractCode!=null && !"".equals(contractCode)){
			acMap.put("contractCode", contractCode);
			mv.addObject("contractCode",contractCode);
		}
		List<Map<String, Object>> agentlist = agentService.getAgentByMap(acMap);
		int total = agentService.getAgentCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("agentlist",agentlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(new HashMap<String,Object>());
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		mv.addObject("recordlist", recordlist);
		return mv;
	}
	
	@RequestMapping("/delAgentById")
	@ResponseBody
	public ResultObject delAgentById(String agentId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(agentId!=null && !"".equals(agentId)){
				int i = agentService.deleteById(agentId);
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
	}*/
	
}
