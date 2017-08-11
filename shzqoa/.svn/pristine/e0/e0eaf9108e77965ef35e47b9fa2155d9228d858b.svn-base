package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Agent;
import com.shzqoa.service.AgentService;
import com.shzqoa.service.TrainSchoolService;
import com.shzqoa.service.TripRecordService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/agent")
public class AgentController {
	@Resource
	private AgentService agentService;
	@Resource
	private TripRecordService tripRecordService;
	@Resource
	private TrainSchoolService trainSchoolService;
	
	
	@RequestMapping("/toEditAgent")  
    public ModelAndView toEditAgent(String agentId){
		ModelAndView	mv = new ModelAndView("views/trainschool/agent");
		Agent info = agentService.getAgentById(agentId);
		mv.addObject("map",info);
		List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(new HashMap<String,Object>());
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		mv.addObject("recordlist", recordlist);
		return mv;
	}
	
	@RequestMapping(value="/saveAgent")
	@ResponseBody
	public ResultObject saveAgent(
			@RequestParam(value = "agentId", defaultValue = "") String agentId,
			@RequestParam(value = "endTime", defaultValue = "") String endTime,
    		@RequestParam(value = "startTime", defaultValue = "")  String startTime,
    		@RequestParam(value = "agentName", defaultValue = "") String agentName,
    		@RequestParam(value = "agentSex", defaultValue = "") Integer agentSex,
    		@RequestParam(value = "tripRecordId", defaultValue = "") String tripRecordId,
    		@RequestParam(value = "mobile", defaultValue = "") String mobile,
    		@RequestParam(value = "officeTel", defaultValue = "") String officeTel,
    		@RequestParam(value = "qQ", defaultValue = "") String qQ,
    		@RequestParam(value = "weiXin", defaultValue = "") String weiXin,    		
    		@RequestParam(value = "idCard", defaultValue = "") String idCard,
    		@RequestParam(value = "agentAddr", defaultValue = "") String agentAddr,
    		@RequestParam(value = "signAgreement", defaultValue = "") Integer signAgreement,    		
    		@RequestParam(value = "contractCode", defaultValue = "") String contractCode
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			Agent info = new Agent();
			if(agentId!=null && !"".equals(agentId)){
				info = agentService.getAgentById(agentId);
			}else{
				info.setAgentId(SerialNumber.createSerial("agent", 4));
			}
			info.setTripRecordId(tripRecordId);
			info.setAgentName(agentName);
			info.setAgentSex(agentSex);
			info.setAgentAddr(agentAddr);
			info.setMobile(mobile);
			info.setOfficeTel(officeTel);
			info.setqQ(qQ);
			info.setWeiXin(weiXin);
			info.setIdCard(idCard);
			info.setSignAgreement(signAgreement);
			info.setContractCode(contractCode);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			if(startTime!=null && !"".equals(startTime)){
				info.setStartTime(sf.parse(startTime));
			}
			if(endTime!=null && !"".equals(endTime)){
				info.setEndTime(sf.parse(endTime));
			}
			
			int resultcount = 0;
			if(agentId!=null && !"".equals(agentId)){
				resultcount = agentService.update(info);
			}else{
				resultcount = agentService.save(info);
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
		return result;
	}
	
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
	}
	
}
