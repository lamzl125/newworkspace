package com.shzqoa.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.CustomerProject;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.AccountsService;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.TaskService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.SerialNumber;
@Controller
public class AddCustomerInfoController {
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private AccountsService accountsService;
	@Resource
	private AreasService areasService;
	@Resource
	private TaskService taskService;
	@Resource
	private ProfessionService professionService;
	@Resource
	private ParameterService parameterService;
	
	
	@RequestMapping("/addCustomerInfo")  
    public ModelAndView addCustomerInfo(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/xinxi_luru");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		mv.addObject("taskList", taskService.queryTaskAllotByUser(user.getUsercode()));
		mv.addObject("areaList", areasService.getAreaList());
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		mv.addObject("accountList", accountsService.selectUsableAccount());		
		mv.addObject("professList",professionService.queryAll());
		mv.addObject("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		mv.addObject("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		mv.addObject("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		mv.addObject("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		return mv;
		
	}
	
	@RequestMapping("/saveCustomerInfo")  
	@ResponseBody
	synchronized public ReturnDate saveCustomerInfo(
			/*@RequestParam(value = "taskid", defaultValue = "") String taskallotid,*/
			@RequestParam(value = "customername", defaultValue = "") String customername,
			@RequestParam(value = "customersex", defaultValue = "0") Integer customersex,
			@RequestParam(value = "areaid", defaultValue = "0") String areaid,
			@RequestParam(value = "customertel", defaultValue = "") String customertel,
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,
			@RequestParam(value = "resumeupdatedate", defaultValue = "") String resumeupdatedate,
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,
			@RequestParam(value = "relationshipbyzq", defaultValue = "0") Integer relationshipbyzq,
			@RequestParam(value = "memo", defaultValue = "") String memo,
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,
			@RequestParam(value = "entryprobability", defaultValue = "0") Integer entryprobability,
			@RequestParam(value = "resumepath", defaultValue = "") String resumepath,
			@RequestParam(value = "zqentrytime", defaultValue = "") String zqentrytime,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "expectationSalary", defaultValue = "0") Integer expectationSalary,
			@RequestParam(value = "professionId", defaultValue = "") String professionId,
			
			@RequestParam(value = "education", defaultValue = "") Long education,
			@RequestParam(value = "englishLevel", defaultValue = "") Long englishLevel,
			@RequestParam(value = "japaneseLevel", defaultValue = "") Long japaneseLevel,
			@RequestParam(value = "directWorkLife", defaultValue = "") Double directWorkLife,
			@RequestParam(value = "prolist", defaultValue = "") String prolist,
			HttpServletRequest request,HttpServletResponse response
			) throws Exception{
		ReturnDate data =  new ReturnDate();
		List<CustomerProject> proListArr = new ArrayList<CustomerProject>();
		if(!"[]".equals(prolist)){
			Map<String,String> postData = new HashMap<String,String>();
			proListArr = JSON.parseArray(prolist, CustomerProject.class);
		}
		
		
		//int telcount = customerInfoService.queryDetailsCountByTel(customertel);
		HashMap<String, Object> paras = new HashMap<String, Object>();
		paras.put("resumeid", resumeid);			
		paras.put("customertel", customertel);
		//paras.put("customername", customername);
		//paras.put("lastprojectname", lastprojectname);
		int count = customerInfoService.getSameCustomerCount(paras);
		if(count>0){
			data.setStatus(1);
			data.setMsg("客户信息已存在！");
			return data;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			java.util.Date addtime = new Date();
			CustomerInfo customerinfo = new CustomerInfo();
			customerinfo.setCustomercode(SerialNumber.createSerial("cstm", 5));
			customerinfo.setCustomername(customername.replaceAll(" +",""));
			customerinfo.setCustomersex(customersex);
			customerinfo.setAreaid(areaid);
			customerinfo.setCustomertel(customertel.replaceAll(" +",""));
			customerinfo.setAccount(account);
			customerinfo.setCustomerbirth(sdf.parse(customerbirth.replaceAll(" +","")));
			customerinfo.setCustomeruniversity(customeruniversity.replaceAll(" +",""));
			customerinfo.setCustomerspecialities(customerspecialities.replaceAll(" +",""));
			if(!entrytime.equals("")){//如果入职时间为空
				customerinfo.setEntrytime(sdf.parse(entrytime.replaceAll(" +","")));
			}
			customerinfo.setResumesource(resumesource);
			customerinfo.setResumeid(resumeid.replaceAll(" +",""));
			customerinfo.setResumeupdatedate(sdf.parse(resumeupdatedate.replaceAll(" +","")));
			if(!lastvcompanyname.equals("")){//如果最近公司名称为空
				customerinfo.setLastvcompanyname(lastvcompanyname.replaceAll(" +",""));
			}
			customerinfo.setTechnicalexpertise(technicalexpertise);
			if(!lastprojectname.equals("")){//如果最近项目名称为空
				customerinfo.setLastprojectname(lastprojectname.replaceAll(" +",""));
			}	
			customerinfo.setRelationshipbyzq(relationshipbyzq);
			customerinfo.setMemo(memo.replaceAll(" +",""));
			customerinfo.setRelationshipbyzh(relationshipbyzh);
			customerinfo.setEntryprobability(entryprobability);
			customerinfo.setResumepath(resumepath);
			if(!zqentrytime.equals("")){
				customerinfo.setZqentrytime(sdf.parse(zqentrytime));
			}
			customerinfo.setAddtime(addtime);
			User user = (User) request.getSession().getAttribute("user");
			customerinfo.setOpertcode(user.getUsercode());
			customerinfo.setOpertname(user.getRealname());
			customerinfo.setLastconttime(addtime);
			customerinfo.setLastupdatestatic(5);
			customerinfo.setExpectationSalary(expectationSalary);
			customerinfo.setProfessionId(professionId);
			customerinfo.setEducation(education);
			customerinfo.setEnglishLevel(englishLevel);
			customerinfo.setJapaneseLevel(japaneseLevel);
			customerinfo.setDirectWorkLife(directWorkLife);
			
			if(/*taskService.saveInter(taskallotid,customerinfo.getCustomercode()) && */customerInfoService.saveNewCustomerInfo(customerinfo, proListArr)>0){
				data.setStatus(0);
				data.setMsg("添加成功！");
				return data;
			}else{
				data.setStatus(1);
				data.setMsg("添加客户信息失败！");
				return data;
			}
		}
	}
	/**
	 * 兼职人员打开录入界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/partaddCustomerInfo")  
    public ModelAndView partaddCustomerInfo(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/parttimejob/xinxi_luru");
		mv.addObject("areaList", areasService.getAreaList());
		mv.addObject("professList",professionService.queryAll());
		mv.addObject("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		mv.addObject("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		mv.addObject("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		mv.addObject("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		return mv;
	}
	/**
	 * 兼职人员录入信息
	 * 
	 */
	@RequestMapping("/partsaveCustomerInfo")  
	@ResponseBody
	synchronized public ReturnDate partsaveCustomerInfo(
			/*@RequestParam(value = "taskid", defaultValue = "") String taskallotid,*/
			@RequestParam(value = "customername", defaultValue = "") String customername,
			@RequestParam(value = "customersex", defaultValue = "0") Integer customersex,
			@RequestParam(value = "areaid", defaultValue = "0") String areaid,
			@RequestParam(value = "customertel", defaultValue = "") String customertel,
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,
			@RequestParam(value = "resumeupdatedate", defaultValue = "") String resumeupdatedate,
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,
			@RequestParam(value = "relationshipbyzq", defaultValue = "0") Integer relationshipbyzq,
			@RequestParam(value = "memo", defaultValue = "") String memo,
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,
			@RequestParam(value = "entryprobability", defaultValue = "0") Integer entryprobability,
			@RequestParam(value = "resumepath", defaultValue = "") String resumepath,
			@RequestParam(value = "zqentrytime", defaultValue = "") String zqentrytime,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "expectationSalary", defaultValue = "0") Integer expectationSalary,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ReturnDate data =  new ReturnDate();
		HashMap<String, Object> paras = new HashMap<String, Object>();
		paras.put("resumeid", customertel);			
		paras.put("customertel", customertel);
		int count = customerInfoService.getSameCustomerCount(paras);
		if(count>0){
			data.setStatus(1);
			data.setMsg("客户信息已存在！");
			return data;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			java.util.Date addtime = new Date();
			CustomerInfo customerinfo = new CustomerInfo();
			customerinfo.setCustomercode(SerialNumber.createSerial("cstm", 5));
			customerinfo.setCustomername(customername.replaceAll(" +",""));
			customerinfo.setCustomersex(customersex);
			customerinfo.setAreaid(areaid);
			customerinfo.setAccount(account);
			customerinfo.setCustomertel(customertel.replaceAll(" +",""));
			customerinfo.setCustomerbirth(sdf.parse(customerbirth.replaceAll(" +","")));
			customerinfo.setCustomeruniversity(customeruniversity.replaceAll(" +",""));
			customerinfo.setCustomerspecialities(customerspecialities.replaceAll(" +",""));
			if(!entrytime.equals("")){//如果入职时间为空
				customerinfo.setEntrytime(sdf.parse(entrytime.replaceAll(" +","")));
			}
			customerinfo.setResumesource(resumesource);
			customerinfo.setResumeid(customertel.replaceAll(" +",""));
			customerinfo.setResumeupdatedate(sdf.parse(resumeupdatedate.replaceAll(" +","")));
			if(!lastvcompanyname.equals("")){//如果最近公司名称为空
				customerinfo.setLastvcompanyname(lastvcompanyname.replaceAll(" +",""));
			}
			customerinfo.setTechnicalexpertise(technicalexpertise);
			if(!lastprojectname.equals("")){//如果最近项目名称为空
				customerinfo.setLastprojectname(lastprojectname.replaceAll(" +",""));
			}	
			customerinfo.setRelationshipbyzq(relationshipbyzq);
			customerinfo.setMemo(memo.replaceAll(" +",""));
			customerinfo.setRelationshipbyzh(relationshipbyzh);
			customerinfo.setEntryprobability(entryprobability);
			customerinfo.setResumepath(resumepath);
			if(!zqentrytime.equals("")){
				customerinfo.setZqentrytime(sdf.parse(zqentrytime));
			}
			customerinfo.setAddtime(addtime);
			User user = (User) request.getSession().getAttribute("user");
			customerinfo.setOpertcode(user.getUsercode());
			customerinfo.setOpertname(user.getRealname());
			customerinfo.setLastconttime(addtime);
			customerinfo.setLastupdatestatic(5);
			customerinfo.setExpectationSalary(expectationSalary);
			
			if(/*taskService.saveInter(taskallotid,customerinfo.getCustomercode()) && */customerInfoService.saveCustomerInfo(customerinfo)>0){
				data.setStatus(0);
				data.setMsg("添加成功！");
				return data;
			}else{
				data.setStatus(1);
				data.setMsg("添加客户信息失败！");
				return data;
			}
		}
	}
	/**
	 * 处理上传文件
	 */
	@RequestMapping(value = "/uploadResume")
	@ResponseBody
	public String uploadResume(@RequestParam(value = "resume") MultipartFile resume,
			HttpServletRequest request,HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("user");
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String contextPath = request.getSession().getServletContext().getRealPath("/");  //项目路径
		String tempPath = File.separator+"fileUpload"+File.separator+sdf.format(today)+"temp"; //临时路径
//        String fileName = new Date().getTime()+resume.getOriginalFilename();  //保存文件的名称
		String sufprex = resume.getOriginalFilename().substring(resume.getOriginalFilename().lastIndexOf("."));
        
        String fileName = new Date().getTime()+user.getUsercode()+resume.getSize()+"resume"+sufprex;  //保存文件的名称
        File tempFile = new File(contextPath +tempPath, fileName); 
        //临时目录是否存在，如果不存在则重新创建
        if(!tempFile.exists()){  
        	tempFile.mkdirs();  
        }  
        //保存  
        try {  
        	resume.transferTo(tempFile); 
        } catch (Exception e) {  
            return "";
        }
        return File.separator+"shzqoa"+tempPath+File.separator+ fileName;
	}
}
