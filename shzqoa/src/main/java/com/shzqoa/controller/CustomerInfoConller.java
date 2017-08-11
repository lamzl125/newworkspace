package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.User;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.ItemsService;
import com.shzqoa.service.LoginUserService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.UserService;

@Controller
public class CustomerInfoConller {

	@Resource 
	private CustomerInfoService customerinfoService;
	@Resource
	private LoginUserService loginUserService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private UserService userService;// 注入UserService层,外键取值
	@Resource
	private ItemsService itemsService;
	/**
	 * 查询页面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/DocustomerInfo")
	@ResponseBody
	public ModelAndView DocustomerInfo(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, 
			@RequestParam(value = "customername", defaultValue = "") String customername,  //'客户姓名',
			@RequestParam(value = "customersex", defaultValue = "-1") Integer customersex,  //'客户性别（0-男，1-女）',
			@RequestParam(value = "customertel", defaultValue = "") String customertel,  //'联系电话',
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,  //'出生日期',
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,  //'毕业院校',
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,  //'所学专业',
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,  //'入职时间',
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,  //  '简历来源（1-51JOb，2-智联,3-其他）',
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,  //'简历ID',
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,   //'最近公司名称',
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,    //'最近项目名称',
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,   // '技术特长',
			@RequestParam(value = "relationshipbyzq", defaultValue = "") Integer relationshipbyzq,  //'与梓钦关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系）',
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,  //'与郑州公司关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系）',
			@RequestParam(value = "entryprobability", defaultValue = "") Integer entryprobability,    //'入职概率',
			@RequestParam(value = "lastupdatestatic", defaultValue = "") Integer lastupdatestatic,    //'入职概率',
			HttpServletRequest request) throws UnsupportedEncodingException{
		customername = URLDecoder.decode(customername, "UTF-8");
		customertel = URLDecoder.decode(customertel, "UTF-8");
		customeruniversity = URLDecoder.decode(customeruniversity, "UTF-8");
		customerspecialities = URLDecoder.decode(customerspecialities, "UTF-8");
		lastprojectname = URLDecoder.decode(lastprojectname, "UTF-8");
		resumeid = URLDecoder.decode(resumeid, "UTF-8");
		technicalexpertise = URLDecoder.decode(technicalexpertise, "UTF-8");
		if(customersex==-1){
			customersex=null;
		}
		Map<String, Object> map=customerinfoService.CustomerInfoList(page, pageSize, customername.replaceAll(" +",""), customersex, 
				customertel.replaceAll(" +",""), customerbirth.replaceAll(" +",""), customeruniversity.replaceAll(" +",""), customerspecialities.replaceAll(" +",""), entrytime.replaceAll(" +",""), resumesource, 
				resumeid.replaceAll(" +",""), lastvcompanyname.replaceAll(" +",""), lastprojectname.replaceAll(" +",""), technicalexpertise.replaceAll(" +",""), relationshipbyzq, relationshipbyzh, entryprobability,lastupdatestatic);
		int total=(Integer)map.get("total"); 
		ModelAndView mv=new ModelAndView("views/search_end");
		mv.addObject("customername",customername);
		mv.addObject("customersex",customersex);
		mv.addObject("customertel",customertel);
		mv.addObject("customerbirth",customerbirth);
		mv.addObject("customeruniversity",customeruniversity);
		mv.addObject("customerspecialities",customerspecialities);
		mv.addObject("entrytime",entrytime);
		mv.addObject("resumesource",resumesource);
		mv.addObject("resumeid",resumeid);
		mv.addObject("lastvcompanyname",lastvcompanyname);
		mv.addObject("lastprojectname",lastprojectname);
		mv.addObject("technicalexpertise",technicalexpertise);
		mv.addObject("relationshipbyzq",relationshipbyzq);
		mv.addObject("relationshipbyzh",relationshipbyzh);
		mv.addObject("entryprobability",entryprobability);
		mv.addObject("lastupdatestatic",lastupdatestatic);
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		return mv;
	}
	
	/**
	 * 兼职
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value="/partDocustomerInfo")
	@ResponseBody
	public ModelAndView partDocustomerInfo(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, 
			@RequestParam(value = "customertel", defaultValue = "") String customertel,  //'联系电话',
			@RequestParam(value = "projecttype", defaultValue = "") String projecttype,    //'入职概率',
			HttpServletRequest request) throws UnsupportedEncodingException{
		
		Map<String, Object> map=customerinfoService.selectCustInfoanddemand(page, pageSize,customertel.replaceAll(" +",""),projecttype);
		int total=(Integer)map.get("total"); 
		ModelAndView mv=new ModelAndView("views/parttimejob/resumelist");
		mv.addObject("customertel",customertel);
		
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		return mv;
	}
	
	/**
	 * 跳转查询页面
	 * @return
	 */
	@RequestMapping(value="/inquiry")
	public ModelAndView inquiry(HttpServletRequest request){
		request.getSession().getAttribute("user");
		ModelAndView rd = new ModelAndView("views/search");
		rd.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		return rd;
	}
	
	/**
	 * 绩效统计
	 * @return
	 */
	@RequestMapping(value="/user/count")
	public ModelAndView performanceCount(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/statistics/jixiao");
		Map<String,Object> mapsearch = new HashMap<String,Object>();
		mv.addObject("currpage", page);
		mapsearch.put("page", (page-1)*pageSize);
		mapsearch.put("pageSize", pageSize);
		List<Map<String,Object>> list = customerinfoService.performanceCount(mapsearch);
		int total = customerinfoService.markSearchCount(mapsearch);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		for(Map<String,Object> map:list){
			int total1= Integer.parseInt(map.get("tongji").toString());
			int sucCount=Integer.parseInt(map.get("zhruzhiCount").toString())+Integer.parseInt(map.get("zqruzhiCount").toString());
			if(total1==0){
				map.put("succes",0);
			}else{
				map.put("succes",(double) (Math.round(sucCount*100)/(total1*100.0)));
			}		
		}
		mv.addObject("userCount", list);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		return mv;
	}
	
	/**
	 * 绩效搜索
	 * @param opertname
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/user/search")
	public ModelAndView markSearch(String opertname,
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String,Object> mapsearch = new HashMap<String,Object>();
		opertname = java.net.URLDecoder.decode(opertname,"UTF-8");
		ModelAndView mv = new ModelAndView("views/statistics/jixiao");
		mapsearch.put("opertname", opertname.replaceAll(" +", ""));
		mv.addObject("currpage", page);
		mapsearch.put("page", (page-1)*pageSize);
		mapsearch.put("pageSize", pageSize);
		List<Map<String,Object>> list = customerinfoService.markSearch(mapsearch);
		int total = customerinfoService.markSearchCount(mapsearch);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		if(list.size() != 0){
			for(Map<String,Object> map:list){
				int total1= Integer.parseInt(map.get("tongji").toString());
				int sucCount=Integer.parseInt(map.get("zhruzhiCount").toString())+Integer.parseInt(map.get("zqruzhiCount").toString());
				if(total1==0){
					map.put("succes",0);
				}else{
					map.put("succes",(double) (Math.round(sucCount*100)/(total1*100.0)));
				}		
			}
		}else{
			mv.addObject("msg", "没有数据!");
		}
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		mv.addObject("opertname", opertname);
		mv.addObject("userCount", list);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		return mv;
	}
	@RequestMapping(value="/item/itemmanagement")
	public ModelAndView itemmanagement(
			@RequestParam(value = "name", defaultValue = "") String name, 
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String,Object> mapsearch = new HashMap<String,Object>();
		name = java.net.URLDecoder.decode(name,"UTF-8");
		ModelAndView mv = new ModelAndView("views/item/itemmanagement");
		mapsearch.put("name", name.replaceAll(" +", ""));
		mv.addObject("currpage", page);
		mapsearch.put("page", (page-1)*pageSize);
		mapsearch.put("pageSize", pageSize);
		List<Map<String,Object>> list = customerinfoService.itemSearch(mapsearch);
		int total = customerinfoService.itemSearchCount(mapsearch);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("opertname", name);
		mv.addObject("userCount", list);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("userlist", userService.getAllUsers());
		mv.addObject("itemlist", customerinfoService.getItemList());
		mv.addObject("cuslist", customerinfoService.getAllcustomerinfo());
		return mv;
	}
	@RequestMapping(value="/selectbyOprecode")
	public ModelAndView selectbyOprecode(
			@RequestParam(value = "taskid", defaultValue = "")String taskid,
			@RequestParam(value = "opertcode", defaultValue = "")String opertcode){
		ModelAndView mv = new ModelAndView("views/taskallot/merInfo");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("taskid",taskid);
		map.put("opertcode", opertcode);
		List<CustomerInfo> custList =customerinfoService.selectbyOprecode(map);
		mv.addObject("custList",custList);
		return mv;
	}
	@RequestMapping(value="/seltCusBytask")
	public ModelAndView seltCusOftask(
			@RequestParam(value = "taskid", defaultValue = "")String taskid,
			@RequestParam(value = "opertcode", defaultValue = "")String opertcode,
			@RequestParam(value = "isentry", defaultValue = "")String isentry){
		ModelAndView mv = new ModelAndView("views/taskallot/merInfo");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("taskid",taskid);
		map.put("opertcode", opertcode);
		map.put("isentry", isentry);
		List<CustomerInfo> custList=customerinfoService.seltCusBytask(map);
		mv.addObject("custList",custList);
		return mv;
	}
}






