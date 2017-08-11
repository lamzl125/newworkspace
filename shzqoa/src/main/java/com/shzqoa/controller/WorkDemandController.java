package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.shzqoa.model.WorkDemand;
import com.shzqoa.model.Worker;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.DemandWorkerService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkDemandService;
import com.shzqoa.service.WorkerService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;



@Controller
@RequestMapping(value = "/workdemand")
public class WorkDemandController {
	private static String FACTORY = "项目工厂";
	private static String DOCKCOMPANY = "项目对接公司";
	
	@Resource
	private WorkDemandService workDemandService;
	@Resource
	private AreasService areasService;
	@Resource
	private DemandWorkerService demandWorkerService;
	@Resource
	private WorkerService workerService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/showworkerlist")  
    public ModelAndView showworkerlist(
    		@RequestParam(value = "usercode", defaultValue = "") String usercode,
    		@RequestParam(value = "optype", defaultValue = "1") Integer optype,
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){	
		ModelAndView	mv = new ModelAndView("views/workdemand/statusworkerlist");
		mv.addObject("currpage", page);	
		mv.addObject("optype", optype);		
		mv.addObject("userlist", userService.getAllUsers());		
		Map<String,Object> map = new HashMap<String,Object>();
		if(startdate!=null && !"".equals(startdate)){
			map.put("startdate", startdate);
			mv.addObject("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate)){
			map.put("enddate", enddate);
			mv.addObject("enddate", enddate);
		}
		if(usercode!=null && !"".equals(usercode)){
			map.put("addPeople", usercode);
			mv.addObject("usercode", usercode);
		}
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		if(optype==2){//意向
			map.put("intentionflag", 2);
		}else if(optype==3){//入职
			map.put("entryflag", 3);
		}
		List<Worker> workerlist = workerService.getWorkerByMap(map);
		int total = workerService.getWorkerCountByMap(map);
		
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
		mv.addObject("list", workerlist);
		
		return mv;
	}
	
	
	@RequestMapping("/toWorkStatistics")  
    public ModelAndView toWorkStatistics(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
    		@RequestParam(value = "enddate", defaultValue = "") String enddate,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){		
		ModelAndView	mv = new ModelAndView("views/workdemand/workstatistics");
		mv.addObject("currpage", page);
		
		mv.addObject("userlist", userService.getAllUsers());		
		Map<String,Object> map = new HashMap<String,Object>();
		if(startdate!=null && !"".equals(startdate)){
			map.put("startdate", startdate);
			mv.addObject("startdate", startdate);
		}
		if(enddate!=null && !"".equals(enddate)){
			map.put("enddate", enddate);
			mv.addObject("enddate", enddate);
		}
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Map<String,Object>> list = workDemandService.workstatistics(map);
		int total = workDemandService.workstatisticscount(map);
		
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
		mv.addObject("list", list);
		return mv;
	}
	
	
	@RequestMapping(value="/saveDemandWorker", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveDemandWorker(
			@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "workerids", defaultValue = "") String workerids){
		ResultObject result = ResultObject.getResultObject();
		try {
			int resultcount = 0;
			//1、获取已经绑定的普工
			List<Map<String,Object>> bindlist = demandWorkerService.getWorkerByDemand(demandId);
			
			//2、更新后的普工
			List<String> workers = new ArrayList<String>();
			if(workerids!=null && !"".equals(workerids)){
				workers = Arrays.asList(workerids.split(","));
			}
			List<Map<String,Object>> dwlist = new ArrayList<Map<String,Object>>();
			
			//3、判断需要删除的(原来有的，现在没有的)
			List<String> delids = new ArrayList<String>();	
			if(bindlist!=null && bindlist.size()>0 && workers!=null && workers.size()>0){
				for(int i=0;i<bindlist.size();i++){
					int count = 0;
					Map<String,Object> oldmap = bindlist.get(i);
					String oldworkerid = (String) oldmap.get("WorkerId");
					for(int j=0;j<workers.size();j++){
						String newstr = workers.get(j);
						if(newstr.equals(oldworkerid)){
							count++;
						}
					}
					if(count==0){
						delids.add(oldworkerid);
					}
				}
			}else if(bindlist==null || bindlist.size()==0){
				for(int j=0;j<workers.size();j++){
					String newstr = workers.get(j);
					Map<String,Object> info = new HashMap<String,Object>();						
					info.put("demandWorkerId", SerialNumber.createSerial("dw", 4));
					info.put("demandId", demandId);
					info.put("workerId", newstr);
					dwlist.add(info);
				}
			}
			
			
			//4、判断需要保存的(现在有的，原来没有的)			
			if(workers!=null && workers.size()>0 && bindlist!=null && bindlist.size()>0){
				for(int i=0;i<workers.size();i++){
					String newstr = workers.get(i);
					int count = 0;
					for(int j=0;j<bindlist.size();j++){
						Map<String,Object> oldmap = bindlist.get(i);
						String oldworkerid = (String) oldmap.get("WorkerId");
						if(newstr.equals(oldworkerid)){
							count++;
						}
					}
					if(count==0){
						Map<String,Object> info = new HashMap<String,Object>();						
						info.put("demandWorkerId", SerialNumber.createSerial("dw", 4));
						info.put("demandId", demandId);
						info.put("workerId", newstr);							
						dwlist.add(info);
					}
				}
			}else if(workers==null || workers.size()==0){
				resultcount = demandWorkerService.deleteByDemandId(demandId);
			}
			
			
			//删除旧的
			if(delids!=null && delids.size()>0){
				Map<String,Object> oldmap = new HashMap<String,Object>();
				oldmap.put("workerId", delids);
				oldmap.put("demandId", demandId);
				resultcount = demandWorkerService.deleteByWorkerId(oldmap);
			}
			
			
			//保存新的
			if(dwlist!=null && dwlist.size()>0){
				resultcount = demandWorkerService.saveList(dwlist);
			}
			if(resultcount>=0){
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
	
	@RequestMapping("/demandWorkerList")  
    public ModelAndView demandWorkerList(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId) {
		ModelAndView mv = new ModelAndView("views/workdemand/demandworkerlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		
		//1、根据Id获取需求
		WorkDemand demand = workDemandService.getWorkDemandById(demandId);
		mv.addObject("demand", demand);
		
		//2、根据需求Id获取普工列表		
		acMap.put("demandId", demandId);
		List<Map<String,Object>> workers = demandWorkerService.getWorkerByDemand(demandId);
		mv.addObject("workers",workers);
		
		//3、获取当前需求绑定的普工以及未绑定需求的普工
		List<Worker> allworkers = workerService.getSelectWorker(demandId);		
		mv.addObject("allworkers", allworkers);
		return mv;
	}
	
	
	
	@RequestMapping("/delWorkDemandById")
	@ResponseBody
	public ResultObject delWorkDemandById(String demandId){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(demandId!=null && !"".equals(demandId)){
				//判断该学校是否有行程存在
				Map<String,Object> conMap= new HashMap<String,Object>();
				conMap.put("demandId", demandId);
				
//				List<Map<String, Object>> recordlist = tripRecordService.getTripRecordByMap(conMap);
//				if(recordlist!=null && recordlist.size()>0){
//					result.setSuccess(false);
//					result.setResultMessage("删除失败,该学校有行程记录");
//				}else{
					int i = workDemandService.deleteById(demandId);
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
	
	
	@RequestMapping("/toEditWorkDemand")  
    public ModelAndView toEditWorkDemand(String demandId){
		ModelAndView	mv = new ModelAndView("views/workdemand/workdemand");
		WorkDemand info = workDemandService.getWorkDemandById(demandId);
		mv.addObject("map",info);
		mv.addObject("zonelist", areasService.getAreaList());
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		mv.addObject("dockcompanylist", parameterService.selectByName(DOCKCOMPANY));
		return mv;
	}
	
	
	@RequestMapping(value="/saveWorkDemand", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject saveWorkDemand(
			@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "demandStatus", defaultValue = "1")  Integer demandStatus,
    		@RequestParam(value = "otherSubsidies", defaultValue = "") String otherSubsidies,    		
    		@RequestParam(value = "fringeBenefit", defaultValue = "") String fringeBenefit,    		
    		@RequestParam(value = "transportationAllowance", defaultValue = "") String transportationAllowance,
    		@RequestParam(value = "accommodation", defaultValue = "") String accommodation,
    		@RequestParam(value = "mealSupplement", defaultValue = "") Double mealSupplement,
    		@RequestParam(value = "overtimePay", defaultValue = "") Double overtimePay,
    		@RequestParam(value = "monthWage", defaultValue = "") Double monthWage,
    		@RequestParam(value = "hourlyWage", defaultValue = "") Double hourlyWage,
    		@RequestParam(value = "workArea", defaultValue = "") String workArea,
    		@RequestParam(value = "workContent", defaultValue = "") String workContent,
    		@RequestParam(value = "workPost", defaultValue = "") String workPost,
    		@RequestParam(value = "factoryId", defaultValue = "") String factoryId,
    		@RequestParam(value = "dockCompany", defaultValue = "") String dockCompany,
    		@RequestParam(value = "recruitment", defaultValue = "") String recruitment,
    		@RequestParam(value = "wageStandard", defaultValue = "") String wageStandard,
    		@RequestParam(value = "residentTeacher", defaultValue = "") String residentTeacher,
    		@RequestParam(value = "teacherEvaluate", defaultValue = "") String teacherEvaluate,
    		@RequestParam(value = "antiFeePayCycle", defaultValue = "")  Integer antiFeePayCycle,
    		@RequestParam(value = "reMark", defaultValue = "") String reMark,
    		HttpServletRequest request){
		ResultObject result = ResultObject.getResultObject();
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("hourlyWage", hourlyWage);
		acMap.put("antiFeePayCycle", antiFeePayCycle);
		acMap.put("residentTeacher", residentTeacher);
		if(demandId!=null && !"".equals(demandId)){
			acMap.put("demandId", demandId);
		}
		int count = workDemandService.getWorkDemandCountByMap(acMap);
		if(count>0){
			result.setSuccess(false);
			result.setResultMessage("保存失败,反费金额："+hourlyWage+"反费周期："+antiFeePayCycle+"驻厂老师："+residentTeacher+"已存在，无需重复添加");
		}else{
			try {
				WorkDemand info = new WorkDemand();
				if(demandId!=null && !"".equals(demandId)){
					info = workDemandService.getWorkDemandById(demandId);
				}else{
					info.setDemandId(SerialNumber.createSerial("demd", 4));
				}
				info.setWorkArea(workArea);
				info.setAccommodation(accommodation);
				info.setAddPeople(user.getUsercode());
				info.setAddTime(new Date());
				info.setDemandStatus(demandStatus);
				info.setWorkPost(workPost);
				info.setWorkContent(workContent);
				info.setHourlyWage(hourlyWage);
				info.setMonthWage(monthWage);
				info.setOvertimePay(overtimePay);
				info.setMealSupplement(mealSupplement);
				info.setTransportationAllowance(transportationAllowance);
				info.setFringeBenefit(fringeBenefit);
				info.setOtherSubsidies(otherSubsidies);
				info.setFactoryId(factoryId);
				info.setDockCompany(dockCompany);
				info.setRecruitment(recruitment);
				info.setWageStandard(wageStandard);
				info.setResidentTeacher(residentTeacher);
				info.setTeacherEvaluate(teacherEvaluate);
				info.setAntiFeePayCycle(antiFeePayCycle);
				info.setReMark(reMark);
				int resultcount = 0;
				if(demandId!=null && !"".equals(demandId)){
					resultcount = workDemandService.update(info);
				}else{
					resultcount = workDemandService.save(info);
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
	
	
	@RequestMapping("/toWorkDemandAdd")  
    public ModelAndView toWorkDemandAdd(){
		ModelAndView	mv = new ModelAndView("views/workdemand/workdemand");
		mv.addObject("zonelist", areasService.getAreaList());		
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		mv.addObject("dockcompanylist", parameterService.selectByName(DOCKCOMPANY));
		return mv;
	}
	
	@RequestMapping("/toWorkDemandList")  
    public ModelAndView toWorkDemandList(
    		@RequestParam(value = "workArea", defaultValue = "") String workArea,
    		@RequestParam(value = "workPost", defaultValue = "") String workPost,
    		@RequestParam(value = "demandStatus", defaultValue = "0") Integer demandStatus,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/workdemand/workDemandManage");
		workArea = URLDecoder.decode(workArea,"UTF-8");
		workPost = URLDecoder.decode(workPost,"UTF-8");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		
		if(workArea!=null && !"".equals(workArea)){
			acMap.put("workArea", workArea);
			mv.addObject("workArea",workArea);
		}
		if(workPost!=null && !"".equals(workPost)){
			acMap.put("workPost", workPost);
			mv.addObject("workPost",workPost);
		}		
		if(demandStatus!=null && demandStatus>0){
			acMap.put("demandStatus", demandStatus);
			mv.addObject("demandStatus",demandStatus);
		}
		
		List<WorkDemand> demandllist = workDemandService.getWorkDemandByMap(acMap);
		int total = workDemandService.getWorkDemandCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("demandllist",demandllist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("zonelist", areasService.getAreaList());
		mv.addObject("factorylist", parameterService.selectByName(FACTORY));
		mv.addObject("dockcompanylist", parameterService.selectByName(DOCKCOMPANY));
		return mv;
	}

	
}
