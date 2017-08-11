package com.shzqoa.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Salary;
import com.shzqoa.model.SalarySet;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.SalaryService;
import com.shzqoa.service.SalarySetService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.SalaryPOIUtil;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/salary")
public class SalaryController {
	@Resource
	private SalarySetService salarySetService;
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private SalaryService salaryService;
	@Resource
	private CustomerInfoService customerInfoService;// 注入CustomerInfoService层，外键取值
	@Resource
	private UserService userService;// 注入UserService层,外键取值
	
	
	@RequestMapping("/salaryListSet")  
    public ModelAndView salaryListSet(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "id", defaultValue = "") String id,
    		@RequestParam(value = "searchcustomercode", defaultValue = "") String searchcustomercode,
    		@RequestParam(value = "searchstatus", defaultValue = "-1") Integer searchstatus,
    		@RequestParam(value = "listflag", defaultValue = "") String listflag
    		){
		ModelAndView mv = new ModelAndView("views/salary/salaryListSet");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		List<CustomerInfo> custList = customerInfoService.queryCustomerDetails(conMap);
		mv.addObject("custList", custList);
		mv.addObject("userlist", userService.getAllUsers());
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(searchcustomercode!=null && !"".equals(searchcustomercode)){
			conMap.put("searchcustomercode", searchcustomercode);
			mv.addObject("searchcustomercode", searchcustomercode);
		}
		if(searchstatus!=null && searchstatus!=-1){
			conMap.put("searchstatus", searchstatus);
			mv.addObject("searchstatus", searchstatus);
		}
		
		if(id!=null && !"".equals(id)){
			SalarySet info = salarySetService.getSalarySetById(id);
			mv.addObject("info", info);
		}
		List<SalarySet> lsit = salarySetService.getAllSalarySet(conMap);
		int total = salarySetService.getAllSalarySetCount(conMap);
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
		mv.addObject("listflag", listflag);
		return mv;
	}
	@RequestMapping("/saveSalarySet")  
	@ResponseBody
	public Map<String,Object> saveSalarySet(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "addCustomerCode", defaultValue = "") String addCustomerCode,
			@RequestParam(value = "addIdleSalary", defaultValue = "") Double addIdleSalary,
			@RequestParam(value = "addRegularSalary", defaultValue = "") Double addRegularSalary,
			@RequestParam(value = "addProbationarySalary", defaultValue = "") Double addProbationarySalary,
			@RequestParam(value = "addInsuranceCost", defaultValue = "") Double addInsuranceCost,
			@RequestParam(value = "idleSocialSecurity", defaultValue = "") Double idleSocialSecurity,
			@RequestParam(value = "idleSubsidy", defaultValue = "") Double idleSubsidy,
			@RequestParam(value = "probationaryStartDate", defaultValue = "") String probationaryStartDate,
			@RequestParam(value = "probationaryEndDate", defaultValue = "") String probationaryEndDate,
			@RequestParam(value = "regularSocialSecurity", defaultValue = "") Double regularSocialSecurity,
			@RequestParam(value = "regularSubsidy", defaultValue = "") Double regularSubsidy,
			@RequestParam(value = "contractStartDate", defaultValue = "") String contractStartDate,
			@RequestParam(value = "contractEndDate", defaultValue = "") String contractEndDate,
			@RequestParam(value = "fileAddr", defaultValue = "") String fileAddr,
			@RequestParam(value = "probationarySubsidy", defaultValue = "") Double probationarySubsidy
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		SalarySet info = new SalarySet();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(id!=null && !"".equals(id)){
			info = salarySetService.getSalarySetById(id);
			info.setCustomercode(addCustomerCode);
			info.setIdlesalary(addIdleSalary);
			info.setInsurancecost(addInsuranceCost);
			info.setProbationarysalary(addProbationarySalary);
			info.setRegularsalary(addRegularSalary);
			info.setIdlesocialsecurity(idleSocialSecurity);
			info.setIdlesubsidy(idleSubsidy);
			info.setProbationarystartdate(sdf.parse(probationaryStartDate.replaceAll(" +","")));
			info.setProbationaryenddate(sdf.parse(probationaryEndDate.replaceAll(" +","")));
			info.setRegularsocialsecurity(regularSocialSecurity);
			info.setRegularsubsidy(regularSubsidy);
			info.setContractstartdate(sdf.parse(contractStartDate.replaceAll(" +","")));
			info.setContractenddate(sdf.parse(contractEndDate.replaceAll(" +","")));
			info.setFileaddr(fileAddr);
			info.setProbationarySubsidy(probationarySubsidy);
			if(salarySetService.updateSalarySetById(info)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "修改人员基数信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "修改人员基数信息失败");
			}
		}else{
			info.setId(SerialNumber.createSerial("basesalary", 4));
			info.setCustomercode(addCustomerCode);
			info.setIdlesalary(addIdleSalary);
			info.setInsurancecost(addInsuranceCost);
			info.setProbationarysalary(addProbationarySalary);
			info.setRegularsalary(addRegularSalary);
			info.setIdlesocialsecurity(idleSocialSecurity);
			info.setIdlesubsidy(idleSubsidy);
			info.setProbationarystartdate(sdf.parse(probationaryStartDate.replaceAll(" +","")));
			info.setProbationaryenddate(sdf.parse(probationaryEndDate.replaceAll(" +","")));
			info.setRegularsocialsecurity(regularSocialSecurity);
			info.setRegularsubsidy(regularSubsidy);
			info.setContractstartdate(sdf.parse(contractStartDate.replaceAll(" +","")));
			info.setContractenddate(sdf.parse(contractEndDate.replaceAll(" +","")));
			info.setFileaddr(fileAddr);
			info.setStatus(1);
			info.setProbationarySubsidy(probationarySubsidy);
			if(salarySetService.insertSalarySet(info)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "添加人员基数信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "添加人员基数信息失败");
			}
		}
		return resultMap;
	}
	
	
	@RequestMapping("/delSalarySetById")  
	@ResponseBody
	public Map<String,Object> delSalarySetById(
			@RequestParam(value = "id", defaultValue = "0") String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("resource", id);
		//判断简历来源是否使用
//		int count = customerDetailService.getCustomerinfoCountByCon(resultMap);
//		if(count>0){
//			resultMap.put("status",1);
//			resultMap.put("msg", "目前该简历来源有人员信息，无法删除。");
//		}else{
			int delflag = salarySetService.delSalarySetById(id);
			if(delflag>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "删除人员基数信息成功");
			}else{
				resultMap.put("status",1);
				resultMap.put("msg", "删除人员基数信息失败");
			}
//		}
		return resultMap;
	}
	
	@RequestMapping("/salaryList")  
    public ModelAndView salaryList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "searchcustomercode", defaultValue = "") String searchcustomercode,
    		@RequestParam(value = "month", defaultValue = "") String month
    		) throws ParseException{
		ModelAndView mv = new ModelAndView("views/salary/salaryList");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> conMap= new HashMap<String,Object>();
		List<CustomerInfo> custList = customerDetailService.getCustomerinfoByCon(conMap);
		mv.addObject("custList", custList);
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(searchcustomercode!=null && !"".equals(searchcustomercode)){
			conMap.put("searchcustomercode", searchcustomercode);
			mv.addObject("searchcustomercode", searchcustomercode);
		}
		
		Calendar c = Calendar.getInstance();
		if(month!=null && !"".equals(month)){
			c.set(Integer.parseInt(month.substring(0, 4)),Integer.parseInt(month.substring(5)),1);
	        c.add(Calendar.MONTH, -1);
	        conMap.put("month", c.getTime());;
			mv.addObject("month", month);
		}else{
	        conMap.put("month", new Date());;
		}
		
		List<Salary> list = salaryService.getSalaryByMonth(conMap);
		if(list==null || list.size()==0){//工资未计算
			List<Map<String,Object>> lsit = salarySetService.getSalaryList(conMap);
			if(lsit!=null && lsit.size()>0){
				list = new ArrayList<Salary>();
				for(Map<String,Object> info :lsit){
					Salary indexInfo = new Salary();
					indexInfo.setSalaryid(SerialNumber.createSerial("salary", 4));
					indexInfo.setSalarysetid(info.get("basesalaryId").toString());	
					indexInfo.setCustomerinfokqid(info.get("Id").toString());
					indexInfo.setKqtime(fmt.parse(info.get("KqTime").toString()));
					list.add(indexInfo);
				}
				salaryService.insertSalaryList(list);
			}
			int total = salarySetService.getSalaryListCount(conMap);
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
		}else{//工资已计算
			List<Map<String,Object>> lsit = salaryService.getSalaryList(conMap);
			int total = salaryService.getSalaryListCount(conMap);
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
		}
		return mv;
	}
	
	@RequestMapping("/downSalaryList")  
	@ResponseBody
    public Map<String,Object> downSalaryList(
    		@RequestParam(value = "searchcustomercode", defaultValue = "") String searchcustomercode,
    		@RequestParam(value = "month", defaultValue = "") String month,
    		HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException{
		response.setHeader("Content-type", "text/html;charset=utf-8");  
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("salaries.xls", "UTF-8"));
		//解决HTTPS不能下载的问题
		response.setHeader("Cache-Control","public");
		OutputStream os = response.getOutputStream();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> conMap= new HashMap<String,Object>();
		
		if(searchcustomercode!=null && !"".equals(searchcustomercode)){
			conMap.put("searchcustomercode", searchcustomercode);
		}
		
		Calendar c = Calendar.getInstance();
		if(month!=null && !"".equals(month)){
			c.set(Integer.parseInt(month.substring(0, 4)),Integer.parseInt(month.substring(5)),1);
	        c.add(Calendar.MONTH, -1);
	        conMap.put("month", c.getTime());;
		}else{
	        conMap.put("month", new Date());;
		}
		
		List<Salary> list = salaryService.getSalaryByMonth(conMap);
		List<Map<String,Object>> lsit = new ArrayList<Map<String,Object>>();
		int total = 0;
		if(list==null || list.size()==0){//工资未计算
			lsit = salarySetService.getSalaryList(conMap);
			list = new ArrayList<Salary>();
			for(Map<String,Object> info :lsit){
				Salary indexInfo = new Salary();
				indexInfo.setSalaryid(SerialNumber.createSerial("salary", 4));
				indexInfo.setSalarysetid(info.get("basesalaryId").toString());	
				indexInfo.setCustomerinfokqid(info.get("Id").toString());
				indexInfo.setKqtime(fmt.parse(info.get("KqTime").toString()));
				list.add(indexInfo);
			}
			salaryService.insertSalaryList(list);
			total = salarySetService.getSalaryListCount(conMap);
		}else{//工资已计算
			lsit = salaryService.getSalaryList(conMap);
			total = salaryService.getSalaryListCount(conMap);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("TotalRowSize",list.size());//共几条记录
		map.put("list",list);//结果集
		map.put("fileName", "salaries.xls");
		map.put("list", lsit);
		map.put("total", total);
		boolean flag = SalaryPOIUtil.CreateExcel("reportTemplateSalary.xls","salaries.xls","工资表",map,os);
		return null;
	}
	
	
	
}
