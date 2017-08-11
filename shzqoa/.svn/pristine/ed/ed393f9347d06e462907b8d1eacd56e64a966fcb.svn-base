package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.TrainSchool;
import com.shzqoa.model.TripRecord;
import com.shzqoa.model.User;
import com.shzqoa.service.AgentService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.TrainSchoolService;
import com.shzqoa.service.TripRecordService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;
@Controller
@RequestMapping(value = "/trainschool")
public class TrainSchoolController {
	private static String LEVELNAME = "学校级别";
	private static String ZONENAME = "学校区域";
	@Resource
	private TrainSchoolService trainSchoolService;
	@Resource
	private TripRecordService tripRecordService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private UserService userService;
	@Resource
	private AgentService agentService;
	
	@RequestMapping("/delTripRecordById")
	@ResponseBody
	public ResultObject delTripRecordById(String tripRecordId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(tripRecordId!=null && !"".equals(tripRecordId)){
				//判断该行程是否有代理人
				Map<String,Object> conMap= new HashMap<String,Object>();
				conMap.put("tripRecordId", tripRecordId);
				List<Map<String, Object>> agentlist = agentService.getAgentByMap(conMap);
				if(agentlist!=null && agentlist.size()>0){
					result.setSuccess(false);
					result.setResultMessage("删除失败,该行程存在代理人。");
				}else{
					int i = tripRecordService.deleteById(tripRecordId);
					result.setResultData(i);
					if(i>0){
						result.setSuccess(true);
						result.setResultMessage("删除成功");
					}else{
						result.setSuccess(false);
						result.setResultMessage("删除失败");
					}
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
	
	
	@RequestMapping("/toEditTripRecord")  
    public ModelAndView toEditTripRecord(String tripRecordId){
		ModelAndView mv = new ModelAndView("views/trainschool/triprecord");
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("userstatus", 2);
		TripRecord info = tripRecordService.getTripRecordById(tripRecordId);
		mv.addObject("map",info);
		mv.addObject("info",trainSchoolService.getTrainSchoolById(info.getTrainSchoolId()));
		mv.addObject("userlist", userService.queryCurList(conMap));
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		return mv;
	}
	
	@RequestMapping(value="/saveTripRecord")
	@ResponseBody
	public ResultObject saveTripRecord(
			@RequestParam(value = "trainSchoolId", defaultValue = "") String trainSchoolId,
    		@RequestParam(value = "tripRecordId", defaultValue = "")  String tripRecordId,
    		@RequestParam(value = "tripWho", defaultValue = "") String tripWho,    		
    		@RequestParam(value = "tripTime", defaultValue = "") String tripTime,
    		@RequestParam(value = "tripAddr", defaultValue = "") String tripAddr){
		ResultObject result = ResultObject.getResultObject();
		try {
			TripRecord info = new TripRecord();
			if(tripRecordId!=null && !"".equals(tripRecordId)){
				info = tripRecordService.getTripRecordById(tripRecordId);
			}else{
				info.setTripRecordId(SerialNumber.createSerial("trre", 4));
			}
			User user = userService.getUserByUserCode(tripWho);
			info.setTripWho(tripWho);
			info.setTripWhoName(user.getRealname());
			info.setTrainSchoolId(trainSchoolId);
			info.setTripAddr(tripAddr);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			info.setTripTime(sf.parse(tripTime));
			int resultcount = 0;
			if(tripRecordId!=null && !"".equals(tripRecordId)){
				resultcount = tripRecordService.update(info);
			}else{
				resultcount = tripRecordService.save(info);
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
	
	
	@RequestMapping("/toTripRecordAdd")  
    public ModelAndView toTripRecordAdd(String trainSchoolId){
		ModelAndView	mv = new ModelAndView("views/trainschool/triprecord");
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("userstatus", 2);
		mv.addObject("userlist", userService.queryCurList(conMap));
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		mv.addObject("info", trainSchoolService.getTrainSchoolById(trainSchoolId));
		return mv;
	}
	
	
	@RequestMapping("/toTripRecordList")  
    public ModelAndView toTripRecordList(
    		@RequestParam(value = "trainSchoolId", defaultValue = "") String trainSchoolId,
    		@RequestParam(value = "tripWho", defaultValue = "") String tripWho,
    		@RequestParam(value = "tripTime", defaultValue = "") String tripTime,
    		@RequestParam(value = "tripAddr", defaultValue = "") String tripAddr,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/trainschool/tripRecordManage");
		trainSchoolId = URLDecoder.decode(trainSchoolId,"UTF-8");
		tripWho = URLDecoder.decode(tripWho,"UTF-8");
		tripTime = URLDecoder.decode(tripTime,"UTF-8");
		tripAddr = URLDecoder.decode(tripAddr,"UTF-8");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(trainSchoolId!=null && !"".equals(trainSchoolId)){
			acMap.put("trainSchoolId", trainSchoolId);
			mv.addObject("trainSchoolId",trainSchoolId);
			TrainSchool info = trainSchoolService.getTrainSchoolById(trainSchoolId);
			mv.addObject("map",info);
		}
		if(tripWho!=null && !"".equals(tripWho)){
			acMap.put("tripWhoName", tripWho);
			mv.addObject("tripWhoName",tripWho);
		}
		if(tripTime!=null && !"".equals(tripTime)){
			acMap.put("tripTime", tripTime);
			mv.addObject("tripTime",tripTime);
		}
		if(tripAddr!=null && !"".equals(tripAddr)){
			acMap.put("tripAddr", tripAddr);
			mv.addObject("tripAddr",tripAddr);
		}
		List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(acMap);
		int total = tripRecordService.getTripRecordCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("recordlist",recordlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("schoollist", trainSchoolService.getAllTrainSchool());
		return mv;
	}
	
	
	
	
	@RequestMapping("/toEditTrainSchool")  
    public ModelAndView toEditTrainSchool(String trainSchoolId){
		ModelAndView	mv = new ModelAndView("views/trainschool/trainschool");
		TrainSchool info = trainSchoolService.getTrainSchoolById(trainSchoolId);
		mv.addObject("map",info);
		mv.addObject("levellist", parameterService.selectByName(LEVELNAME));
		mv.addObject("zonelist", parameterService.selectByName(ZONENAME));
		return mv;
	}
	
	@RequestMapping("/delTrainSchoolById")
	@ResponseBody
	public ResultObject delTrainSchoolById(String trainSchoolId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(trainSchoolId!=null && !"".equals(trainSchoolId)){
				//判断该学校是否有行程存在
				Map<String,Object> conMap= new HashMap<String,Object>();
				conMap.put("trainSchoolId", trainSchoolId);
				
				List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(conMap);
				if(recordlist!=null && recordlist.size()>0){
					result.setSuccess(false);
					result.setResultMessage("删除失败,该学校有行程记录");
				}else{
					int i = trainSchoolService.deleteById(trainSchoolId);
					result.setResultData(i);
					if(i>0){
						result.setSuccess(true);
						result.setResultMessage("删除成功");
					}else{
						result.setSuccess(false);
						result.setResultMessage("删除失败");
					}
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
	
	
	@RequestMapping(value="/saveTrainSchool", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveTrainSchool(
			@RequestParam(value = "trainSchoolId", defaultValue = "") String trainSchoolId,
    		@RequestParam(value = "trainSchoolLevel", defaultValue = "")  Long trainSchoolLevel,
    		@RequestParam(value = "trainSchoolZone", defaultValue = "") Long trainSchoolZone,
    		@RequestParam(value = "trainSchoolName", defaultValue = "") String trainSchoolName,
    		@RequestParam(value = "trainSchoolAddr", defaultValue = "") String trainSchoolAddr,
    		@RequestParam(value = "trainSchoolURL", defaultValue = "") String trainSchoolURL,
    		@RequestParam(value = "trainSchoolStatus", defaultValue = "") Integer trainSchoolStatus
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			TrainSchool info = new TrainSchool();
			if(trainSchoolId!=null && !"".equals(trainSchoolId)){
				info = trainSchoolService.getTrainSchoolById(trainSchoolId);
			}else{
				info.setTrainSchoolId(SerialNumber.createSerial("trsc", 4));
			}
			info.setTrainSchoolLevel(trainSchoolLevel);
			info.setTrainSchoolZone(trainSchoolZone);
			info.setTrainSchoolName(trainSchoolName);
			info.setTrainSchoolAddr(trainSchoolAddr);
			info.setTrainSchoolURL(trainSchoolURL);
			info.setTrainSchoolStatus(trainSchoolStatus==null?0:trainSchoolStatus);
			int resultcount = 0;
			if(trainSchoolId!=null && !"".equals(trainSchoolId)){
				resultcount = trainSchoolService.update(info);
			}else{
				resultcount = trainSchoolService.save(info);
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
	
	
	
	@RequestMapping("/toTrainSchoolAdd")  
    public ModelAndView toTrainSchoolAdd(){
		ModelAndView	mv = new ModelAndView("views/trainschool/trainschool");
		mv.addObject("levellist", parameterService.selectByName(LEVELNAME));
		mv.addObject("zonelist", parameterService.selectByName(ZONENAME));
		return mv;
	}
	
	@RequestMapping("/toTrainSchoolList")  
    public ModelAndView toTrainSchoolList(
    		@RequestParam(value = "trainSchoolLevel", defaultValue = "") Long trainSchoolLevel,
    		@RequestParam(value = "trainSchoolZone", defaultValue = "") Long trainSchoolZone,
    		@RequestParam(value = "trainSchoolName", defaultValue = "") String trainSchoolName,
    		@RequestParam(value = "trainSchoolAddr", defaultValue = "") String trainSchoolAddr,
    		@RequestParam(value = "trainSchoolURL", defaultValue = "") String trainSchoolURL,
    		@RequestParam(value = "trainSchoolStatus", defaultValue = "") Integer trainSchoolStatus,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/trainschool/trainSchoolManage");
		trainSchoolName = URLDecoder.decode(trainSchoolName,"UTF-8");
		trainSchoolAddr = URLDecoder.decode(trainSchoolAddr,"UTF-8");
		trainSchoolURL = URLDecoder.decode(trainSchoolURL,"UTF-8");		
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(trainSchoolLevel!=null && trainSchoolLevel>0){
			acMap.put("trainSchoolLevel", trainSchoolLevel);
			mv.addObject("trainSchoolLevel",trainSchoolLevel);
		}
		if(trainSchoolZone!=null && trainSchoolZone>0){
			acMap.put("trainSchoolZone", trainSchoolZone);
			mv.addObject("trainSchoolZone",trainSchoolZone);
		}
		if(trainSchoolName!=null && !"".equals(trainSchoolName)){
			acMap.put("trainSchoolName", trainSchoolName);
			mv.addObject("trainSchoolName",trainSchoolName);
		}
		if(trainSchoolAddr!=null && !"".equals(trainSchoolAddr)){
			acMap.put("trainSchoolAddr", trainSchoolAddr);
			mv.addObject("trainSchoolAddr",trainSchoolAddr);
		}
		if(trainSchoolURL!=null && !"".equals(trainSchoolURL)){
			acMap.put("trainSchoolURL", trainSchoolURL);
			mv.addObject("trainSchoolURL",trainSchoolURL);
		}
		if(trainSchoolStatus!=null && trainSchoolStatus>=0){
			acMap.put("trainSchoolStatus", trainSchoolStatus);
			mv.addObject("trainSchoolStatus",trainSchoolStatus);
		}
		
		List<TrainSchool> trainschoollist = trainSchoolService.getTrainSchoolByMap(acMap);
		int total = trainSchoolService.getTrainSchoolCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("trainschoollist",trainschoollist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("levellist", parameterService.selectByName(LEVELNAME));
		mv.addObject("zonelist", parameterService.selectByName(ZONENAME));
		return mv;
	}
	
	
}
