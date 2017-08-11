package com.shzqoa.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.shzqoa.model.CustDemand;
import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Grade;
import com.shzqoa.model.Profession;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CorporatepartnersService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.GradeService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.SerialNumber;

@Controller
@RequestMapping(value="/customerDemand")
public class CustomerDemandController {
	@Resource 
	private CustomerInfoService customerinfoService;
	@Resource
	CustomerDemandService customerDemandService;
	@Resource
	GradeService gradeService;
	@Resource
	AreasService areasService;
	@Resource
	CorpService corpService;
	@Resource  
	ProfessionService professionService;
	@Resource
	private UserService userService;// 注入UserService层,外键取值
	@Resource  
	CorporatepartnersService corporateService;
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private ParameterService parameterService;
	@RequestMapping("/addCustomerDemand")
	public ModelAndView addCustomerDemand(){
		ModelAndView mv = new ModelAndView("/views/customerDemand/addCustomerDemand");
		mv.addObject("areaList", areasService.getAreaList());
		mv.addObject("corpList", corpService.getCorpList());
		mv.addObject("gradList",gradeService.queryAll());
		mv.addObject("imporList", parameterService.selectByName("重要程度"));
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		mv.addObject("professList",professionService.queryAll());
		return mv;			
	}
	@RequestMapping("/saveCustomerDemand") 
	@ResponseBody
	public ReturnDate saveCustomerDemand(
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
			@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
			@RequestParam(value = "education", defaultValue = "") String education,
			@RequestParam(value = "demandnumber", defaultValue = "") String demandnumber,
			@RequestParam(value = "specificrequirement", defaultValue = "") String specificrequirement,
			@RequestParam(value = "projecttype", defaultValue = "") String projecttype,
			@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
			//@RequestParam(value = "operationuser", defaultValue = "") String operationuser,
			@RequestParam(value = "remarks", defaultValue = "") String remarks,
			@RequestParam(value = "state", defaultValue = "0") Integer state,
			@RequestParam(value = "address", defaultValue = "0") String address,
			@RequestParam(value = "importantlevel", defaultValue = "0") Integer importantlevel,
			
			@RequestParam(value = "industry", defaultValue = "") Long industry,
			@RequestParam(value = "technicalRequirement", defaultValue = "") String technicalRequirement,
			@RequestParam(value = "directWorkLife", defaultValue = "0") Double directWorkLife,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("corpcode", corpcode);
		map.put("technologydirection", technologydirection);
		map.put("demandyears", demandyears);
		map.put("projectlocation", projectlocation);
		map.put("projecttype", projecttype);
		ReturnDate data = new ReturnDate();
		if(customerDemandService.selectCount(map)!=0){
			data.setStatus(0);
			data.setMsg("客户需求已存在！");
			return data;
		}else{
		CustomerDemand cd = new CustomerDemand();
		cd.setId(SerialNumber.createSerial("demand", 5));
		cd.setCorpcode(corpcode);
		cd.setTechnologydirection(technologydirection);
		cd.setDemandyears(demandyears);
		cd.setEducation(education.replaceAll(" +",""));
		cd.setDemandnumber(demandnumber.replaceAll(" +",""));
		cd.setSpecificrequirement(specificrequirement.replace("\r\n", "<br/>"));
		cd.setProjecttype(projecttype);
		cd.setProjectlocation(projectlocation);
		//cd.setOperationuser(operationuser);
		cd.setRemarks(remarks.replace("\r\n", "<br/>"));
		cd.setState(state);
		cd.setAddress(address.replace("\r\n", "<br/>"));
		cd.setImportantlevel(importantlevel);
		User user = (User) request.getSession().getAttribute("user");
		cd.setOperationuser(user.getUsercode());
		cd.setAddtime(new Date());
		cd.setIndustry(industry);
		cd.setTechnicalRequirement(technicalRequirement);
		cd.setDirectWorkLife(directWorkLife);
		
		if(customerDemandService.insertCustomerDemand(cd)>0){
			data.setStatus(0);
			data.setMsg("添加客户需求成功！");
		}else{
			data.setStatus(0);
			data.setMsg("添加客户需求失败！");
		}
		
		return data;
		}
		
	}
	
	
	@RequestMapping("/editCustomerDemand")
	public ModelAndView editCustomerDemand(
			@RequestParam(value = "custDemandId", defaultValue = "") String custDemandId,
			int coper
			){
		ModelAndView mv = new ModelAndView("/views/customerDemand/editCustomerDemand");
		mv.addObject("customerDemand",customerDemandService.selectById(custDemandId));
		mv.addObject("areaList", areasService.getAreaList());
		mv.addObject("corpList", corpService.getCorpList());
		mv.addObject("gradList",gradeService.queryAll());
		mv.addObject("professList",professionService.queryAll());
		mv.addObject("imporList", parameterService.selectByName("重要程度"));
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		mv.addObject("coper",coper);
		return mv;			
	}
	@RequestMapping("/updateCustomerDemand") 
	@ResponseBody
	public ReturnDate updateCustomerDemand(
			@RequestParam(value = "custDemandId", defaultValue = "") String custDemandId,
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
			@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
			@RequestParam(value = "education", defaultValue = "") String education,
			@RequestParam(value = "demandnumber", defaultValue = "") String demandnumber,
			@RequestParam(value = "specificrequirement", defaultValue = "") String specificrequirement,
			@RequestParam(value = "projecttype", defaultValue = "") String projecttype,
			@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
			//@RequestParam(value = "operationuser", defaultValue = "") String operationuser,
			@RequestParam(value = "remarks", defaultValue = "") String remarks,
			@RequestParam(value = "state", defaultValue = "0") Integer state,
			@RequestParam(value = "address", defaultValue = "0") String address,
			@RequestParam(value = "importantlevel", defaultValue = "0") Integer importantlevel,
			@RequestParam(value = "industry", defaultValue = "") Long industry,
			@RequestParam(value = "technicalRequirement", defaultValue = "") String technicalRequirement,
			@RequestParam(value = "directWorkLife", defaultValue = "0") Double directWorkLife
			){
		CustomerDemand cd = customerDemandService.selectById(custDemandId);
		cd.setCorpcode(corpcode);
		cd.setTechnologydirection(technologydirection);
		cd.setDemandyears(demandyears);
		cd.setEducation(education.replaceAll(" +",""));
		cd.setDemandnumber(demandnumber.replaceAll(" +",""));
		cd.setSpecificrequirement(specificrequirement);
		cd.setProjecttype(projecttype);
		cd.setProjectlocation(projectlocation);
		//cd.setOperationuser(operationuser);
		cd.setRemarks(remarks);
		cd.setState(state);
		cd.setAddress(address);
		cd.setImportantlevel(importantlevel);
		cd.setIndustry(industry);
		cd.setDirectWorkLife(directWorkLife);
		cd.setTechnicalRequirement(technicalRequirement);
		ReturnDate data = new ReturnDate();
		if(customerDemandService.updateCustomerDemand(cd)>0){
			data.setStatus(0);
			data.setMsg("修改客户需求成功！");
		}else{
			data.setStatus(0);
			data.setMsg("修改客户需求失败！");
		}
		
		return data;
	}
	/**
	 * 需求列表页面
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @return
	 */
	@RequestMapping("/toCustDemandList")  
    public ModelAndView toCustDemandList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears){
		ModelAndView mv = new ModelAndView("views/customerDemand/custDemandList");
		Map<String,Object> map= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("customername", customername);
		map.put("technologydirection", technologydirection);
		map.put("projectlocation", projectlocation);
		map.put("demandyears", demandyears);
		map.put("ocode", ocode);
		List<Profession> profession=professionService.queryAll();
		List<Areas> arealist=areasService.getAreaList();
		List<Grade> grade=gradeService.queryAll();
		List<CustDemand> custList=customerDemandService.selectDemand(map);
		/*List<CustomerInfo> userlist=customerinfoService.selectCuName();;*/
		int total=customerDemandService.selectDemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("corporList",corporateService.queryAll());
		mv.addObject("grade",grade);
		mv.addObject("profession",profession);
		mv.addObject("arealist", arealist);
		mv.addObject("customername",customername);
		mv.addObject("technologydirection",technologydirection);
		mv.addObject("projectlocation",projectlocation);
		mv.addObject("demandyears",demandyears);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("custList", custList);
		/*mv.addObject("userlist", userlist);*/
		mv.addObject("userlist", userService.getAllUsers());
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		return mv;
	}
	/**
	 * 需求跟踪列表页面
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @return
	 */
	@RequestMapping("/toCustDemandTrackList")  
    public ModelAndView toCustDemandTrackList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "trackFlag", defaultValue = "") String trackFlag,
    		HttpServletRequest request
    		){
		ModelAndView mv = new ModelAndView("views/customerDemand/custDemandTrackList");
		Map<String,Object> map= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		/*
		 * 获取当前登录用户所属组
		 */
		
		User user = (User)request.getSession().getAttribute("user");
		map.put("usercode", user.getUsercode());
		map.put("groupname", "人事");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(map);
		
		
		List<Map<String,Object>> custList= new ArrayList<Map<String,Object>>();
		int total = 0;
		if(groups!=null && groups.size()>0){//人事需要传递参数操作员
			map.put("opercode", user.getUsercode());
			mv.addObject("operflag", 0);
		}else{//非人事查询所有，无需要传递参数操作员
			map.put("opercode", null);
			mv.addObject("operflag", 1);
		}
		custList = customerDemandService.selectDemandTrack(map);
		total=customerDemandService.selectDemandTrackCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("corporList",corporateService.queryAll());
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("custList", custList);
		mv.addObject("trackFlag", trackFlag);
		return mv;
	}
	@RequestMapping("/trackCustomerDemand")
	public ModelAndView trackCustomerDemand(
			@RequestParam(value = "Id", defaultValue = "") String Id
			){
		ModelAndView mv = new ModelAndView("/views/customerDemand/TrackCustomerDemand");
		mv.addObject("DemandresumeRelationId",Id);
//		mv.addObject("areaList", areasService.getAreaList());
//		mv.addObject("corpList", corpService.getCorpList());
//		mv.addObject("gradList",gradeService.queryAll());
//		mv.addObject("professList",professionService.queryAll());
//		mv.addObject("coper",coper);
		return mv;			
	}
	@RequestMapping("/saveCustomerDemandTrack") 
	@ResponseBody
	public ReturnDate saveCustomerDemandTrack(
			@RequestParam(value = "demandresumeRelationId", defaultValue = "") String demandresumeRelationId,
			@RequestParam(value = "TrackResult", defaultValue = "") String TrackResult,			@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			HttpServletRequest request
			){
		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", SerialNumber.createSerial("track", 4));
		map.put("demandresumerelationid", demandresumeRelationId);
		map.put("trackresult", TrackResult);
		map.put("remark", Remark);
		map.put("opercode",user.getUsercode());
		ReturnDate data = new ReturnDate();
		if(customerDemandService.insertCustomerDemandTrack(map)>0){
			data.setStatus(0);
			data.setMsg("跟踪需求信息成功！");
		}else{
			data.setStatus(0);
			data.setMsg("添跟踪需求信息失败！");
		}
		
		return data;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/deleteCusdemand")
	public ReturnDate deleteCusdemand(@RequestParam(value = "Id", defaultValue = "") String Id,
    		HttpServletRequest request){
		ReturnDate data = new ReturnDate();
		
			int result=customerDemandService.deleteById(Id);
			if(result <= 0){
				data.setStatus(1);
				data.setMsg("删除需求失败！");
			}else{
				data.setStatus(0);
				data.setMsg("删除需求成功！");
			}
		
		return data;
	}
	/**
	 * 绑定页面
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/toCustDemand")  
    public ModelAndView toCustDemand(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears){
		ModelAndView mv = new ModelAndView("views/customerDemand/requirement");
		Map<String,Object> map= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("technologydirection", technologydirection);
		map.put("projectlocation", projectlocation);
		map.put("demandyears", demandyears);
		Map<String,Object> paramap= new HashMap<String,Object>();
//		paramap.put("professionid", technologydirection);
//		paramap.put("areaid", projectlocation);
//		paramap.put("gradeid", demandyears);
		List<CustomerInfo> customName=customerinfoService.seltCusOfTask(paramap);
 //	    List<CustomerDemand> demandList=customerDemandService.selectAlldemand(map);
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		mapList=customerDemandService.custOfDemand(map);
		List<Profession> profession=professionService.queryAll();
		List<Areas> arealist=areasService.getAreaList();
		List<Grade> grade=gradeService.queryAll();
		int total=customerDemandService.selectAlldemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("customName",customName);
		mv.addObject("technologydirection",technologydirection);
		mv.addObject("projectlocation",projectlocation);
		mv.addObject("demandyears",demandyears);
		mv.addObject("grade",grade);
		mv.addObject("profession",profession);
		mv.addObject("arealist", arealist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("demandList", mapList);
		return mv;
	}
	/**
	 * 关闭需求
	 * @param demandid
	 * @return
	 */
	@RequestMapping("/closeDemand")
	@ResponseBody
	public ReturnDate closeDemand(
			@RequestParam(value = "demandid", defaultValue = "") String demandid){
		ReturnDate rd = new ReturnDate();
		if(demandid!="" && customerDemandService.closeDemand(demandid)>0){
			rd.setStatus(0);
			rd.setMsg("该需求关闭成功！");
			return rd;
		}else{
			rd.setStatus(1);
			rd.setMsg("需求关闭失败！");
			return rd;
		}
	}
	@RequestMapping("/openDemand")
	@ResponseBody
	public ReturnDate openDemand(
			@RequestParam(value="demandid",defaultValue ="") String demandid){
		ReturnDate rd = new ReturnDate();
		if(demandid!="" && customerDemandService.openDemand(demandid)>0){
			rd.setStatus(0);
			rd.setMsg("该需求恢复成功！");
			return rd;
		}
		else{
			rd.setStatus(1);
			rd.setMsg("该需求恢复失败！");
			return rd;
		}
	}
}
