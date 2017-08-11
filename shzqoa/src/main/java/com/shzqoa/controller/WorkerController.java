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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.User;
import com.shzqoa.model.Worker;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkerService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;



@Controller
@RequestMapping(value = "/worker")
public class WorkerController {
	@Resource
	private WorkerService workerService;
	@Resource
	private UserService userService;
	
	
	
	@RequestMapping("/toEditWorker")  
    public ModelAndView toEditWorker(String workerId){
		ModelAndView	mv = new ModelAndView("views/workdemand/worker");
		Worker info = workerService.getWorkerById(workerId);
		mv.addObject("map",info);
		return mv;
	}
	
	
	
	@RequestMapping(value="/saveWorker", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveWorker(
			@RequestParam(value = "workerId", defaultValue = "") String workerId,
    		@RequestParam(value = "workerStatus", defaultValue = "1")  Integer workerStatus,
    		@RequestParam(value = "workerName", defaultValue = "") String workerName,    		
    		@RequestParam(value = "workerPhone", defaultValue = "") String workerPhone,    		
    		@RequestParam(value = "origin", defaultValue = "") String origin,
    		@RequestParam(value = "idCard", defaultValue = "") String idCard,
    		@RequestParam(value = "age", defaultValue = "") Integer age,
    		@RequestParam(value = "antiFeePay", defaultValue = "") Double antiFeePay,
    		@RequestParam(value = "antiFeeTime", defaultValue = "") String antiFeeTime,
    		@RequestParam(value = "registerTime", defaultValue = "") String registerTime,
    		@RequestParam(value = "workerSex", defaultValue = "") Integer workerSex,
    		@RequestParam(value = "physicalExamination", defaultValue = "") Integer physicalExamination,
    		@RequestParam(value = "estimateAntiFeeTime", defaultValue = "") String estimateAntiFeeTime,
    		@RequestParam(value = "isSettlement", defaultValue = "") Integer isSettlement,
    		@RequestParam(value = "reMark", defaultValue = "") String reMark,
    		@RequestParam(value = "reMark1", defaultValue = "") String reMark1,
    		HttpServletRequest request){
		ResultObject result = ResultObject.getResultObject();
		User user = (User) request.getSession().getAttribute("user");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> acMap= new HashMap<String,Object>();
		if(workerId!=null && !"".equals(workerId)){
			acMap.put("workerId", workerId);
		}
		
		int phonecount = 0;
		int idcardcount = 0;
		//判断电话是否存在
		if(workerPhone!=null && !"".equals(workerPhone)){
			acMap.put("allPhone", workerPhone);
			phonecount = workerService.getWorkerCountByMap(acMap);
			if(phonecount>0){
				result.setSuccess(false);
				result.setResultMessage("保存失败,该电话客户已存在");
				return result;
			}
		}
		
		
		//判断身份证是否存在
		if(idCard!=null && !"".equals(idCard)){
			acMap.remove("allPhone");
			acMap.put("allidCard", idCard);
			idcardcount = workerService.getWorkerCountByMap(acMap);
			if(idcardcount>0){
				result.setSuccess(false);
				result.setResultMessage("保存失败,该身份证客户已存在");
				return result;
			}
		}
		if(phonecount==0 && idcardcount==0){
			try {
				Worker info = new Worker();
				if(workerId!=null && !"".equals(workerId)){
					info = workerService.getWorkerById(workerId);
				}else{
					info.setWorkerId(SerialNumber.createSerial("work", 4));
				}
				info.setWorkerName(workerName);
				info.setWorkerPhone(workerPhone);
				info.setAge(age);
				info.setOrigin(origin);
				info.setIdCard(idCard);
				if(workerId==null || "".equals(workerId)){
					info.setAddPeople(user.getUsercode());
					info.setAddTime(new Date());
				}
				
				info.setWorkerStatus(workerStatus);
				info.setAntiFeePay(antiFeePay);
				if(antiFeeTime!=null && !"".equals(antiFeeTime)){
					info.setAntiFeeTime(sf.parse(antiFeeTime));
				}
				if(registerTime!=null && !"".equals(registerTime)){
					info.setRegisterTime(sf.parse(registerTime));
				}
				info.setWorkerSex(workerSex);
				info.setPhysicalExamination(physicalExamination);
				if(estimateAntiFeeTime!=null && !"".equals(estimateAntiFeeTime)){
					info.setEstimateAntiFeeTime(sf.parse(estimateAntiFeeTime));
				}
				info.setIsSettlement(isSettlement);
				info.setReMark(reMark);
				info.setReMark1(reMark1);
				
				int resultcount = 0;
				if(workerId!=null && !"".equals(workerId)){
					resultcount = workerService.update(info);
				}else{
					resultcount = workerService.save(info);
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
	
	@RequestMapping("/toWorkerAdd")  
    public ModelAndView toWorkerAdd(){
		ModelAndView	mv = new ModelAndView("views/workdemand/worker");
		return mv;
	}
	
	@RequestMapping("/toWorkerList")  
    public ModelAndView toWorkerList(
    		@RequestParam(value = "workerName", defaultValue = "") String workerName,
    		@RequestParam(value = "workerPhone", defaultValue = "") String workerPhone,
    		@RequestParam(value = "age", defaultValue = "0") Integer age,
    		@RequestParam(value = "origin", defaultValue = "") String origin,
    		@RequestParam(value = "idCard", defaultValue = "") String idCard,
    		@RequestParam(value = "workerStatus", defaultValue = "0") Integer workerStatus,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/workdemand/workerManage");
		workerName = URLDecoder.decode(workerName,"UTF-8");
		workerPhone = URLDecoder.decode(workerPhone,"UTF-8");
		origin = URLDecoder.decode(origin,"UTF-8");
		idCard = URLDecoder.decode(idCard,"UTF-8");		
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		
		if(workerName!=null && !"".equals(workerName)){
			acMap.put("workerName", workerName);
			mv.addObject("workerName",workerName);
		}
		if(workerPhone!=null && !"".equals(workerPhone)){
			acMap.put("workerPhone", workerPhone);
			mv.addObject("workerPhone",workerPhone);
		}		
		if(age!=null && age>0){
			acMap.put("age", age);
			mv.addObject("age",age);
		}
		if(origin!=null && !"".equals(origin)){
			acMap.put("origin", origin);
			mv.addObject("origin",origin);
		}	
		if(idCard!=null && !"".equals(idCard)){
			acMap.put("idCard", idCard);
			mv.addObject("idCard",idCard);
		}
		if(workerStatus!=null && workerStatus>0){
			acMap.put("workerStatus", workerStatus);
			mv.addObject("workerStatus",workerStatus);
		}
		List<Worker> workerlist = workerService.getWorkerByMap(acMap);
		int total = workerService.getWorkerCountByMap(acMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		List<User> userlist = userService.getAllUsers();
		mv.addObject("workerlist",workerlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("userlist",userlist);
		
		//获取普工需求厂区
		List<Map<String,Object>> workerdemandlist = workerService.getWorkerDemandByMap(new HashMap<String,Object>());
		mv.addObject("workerdemandlist",workerdemandlist);
		return mv;
	}
	
	@RequestMapping("/delWorkerById")
	@ResponseBody
	public ResultObject delWorkerById(String workerId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(workerId!=null && !"".equals(workerId)){
				//判断该学校是否有行程存在
				Map<String,Object> conMap= new HashMap<String,Object>();
				conMap.put("workerId", workerId);
				
//				List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(conMap);
//				if(recordlist!=null && recordlist.size()>0){
//					result.setSuccess(false);
//					result.setResultMessage("删除失败,该学校有行程记录");
//				}else{
					int i = workerService.deleteById(workerId);
					result.setResultData(i);
					if(i>0){
						result.setSuccess(true);
						result.setResultMessage("删除成功");
					}else{
						result.setSuccess(false);
						result.setResultMessage("删除失败");
					}
//				}
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
