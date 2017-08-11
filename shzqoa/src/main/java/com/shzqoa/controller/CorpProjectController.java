package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.shzqoa.model.CorpContant;
import com.shzqoa.model.CorpProject;
import com.shzqoa.model.User;
import com.shzqoa.service.CorpProjectService;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;
@Controller
@RequestMapping(value = "/corpProject")
public class CorpProjectController {
	@Resource
	private CorpProjectService corpProjectService;
	
	@RequestMapping("/toCorpProjectList")  
    public ModelAndView toCorpProjectList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "corpCode", defaultValue = "") String corpCode
    		) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/corp/corpProjectManage");
		corpCode = URLDecoder.decode(corpCode,"UTF-8");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("corpcode", corpCode);
		List<CorpProject> lsit = corpProjectService.getAllCorpProjectByCropCode(conMap);
		
		int total = corpProjectService.getCorpContantCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("corpcode", corpCode);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", lsit);
		return mv;
	}
	
	@RequestMapping("/togetcorpcontantList")  
    public ModelAndView togetcorpcontantList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "corpCode", defaultValue = "") String corpCode
    		){
		ModelAndView mv = new ModelAndView("views/corp/corpcontantManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("corpcode", corpCode);
		List<CorpContant> lsit = corpProjectService.getAllCorpContantByCropCode(conMap);
		
		int total = corpProjectService.getCorpProjectCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("corpcode", corpCode);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", lsit);
		return mv;
	}
	
	@RequestMapping("/saveCorpProject")  
	@ResponseBody
	public Map<String,Object> saveCorpProject(
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "corpProjectName", defaultValue = "") String corpProjectName,
			@RequestParam(value = "starttime", defaultValue = "") String starttime,
			@RequestParam(value = "endtime", defaultValue = "") String endtime,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		CorpProject info = new CorpProject();
		info.setCorpprojectcode(SerialNumber.createSerial("cstm", 6));
		info.setCorpcode(corpCode);
		info.setCorpprojectname(corpProjectName);
		info.setProjectstartdate(sdf.parse(starttime));
		info.setProjectenddate(sdf.parse(endtime));
		User user = (User) request.getSession().getAttribute("user");
		info.setOpercode(user.getUsercode());
		info.setOpertime(new Date());
		if(corpProjectService.insertCorpProject(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加公司项目信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加公司项目信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/savecorpcontant")  
	@ResponseBody
	public Map<String,Object> savecorpcontant(
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "ContanName", defaultValue = "") String ContanName,
			@RequestParam(value = "ContTel", defaultValue = "") String ContTel,
			@RequestParam(value = "ConPhone", defaultValue = "") String ConPhone,
			@RequestParam(value = "ContOfficeTel", defaultValue = "") String ContOfficeTel,
			@RequestParam(value = "QQ", defaultValue = "") String QQ,
			@RequestParam(value = "WeiXin", defaultValue = "") String WeiXin,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");*/
		CorpContant con= new CorpContant();
		con.setId(SerialNumber.createSerial("cstm", 6));
		con.setCorpcode(corpCode);
		con.setContanname(ContanName);
		con.setConttel(ContTel);
		con.setConphone(ConPhone);
		con.setContofficetel(ContOfficeTel);
		con.setQq(QQ);
		con.setWeixin(WeiXin);
		con.setRemark(Remark);
		User user = (User) request.getSession().getAttribute("user");
		con.setOpercode(user.getUsercode());
		con.setOpertime(new Date());
		
		/*CorpProject info = new CorpProject();
		info.setCorpprojectcode(SerialNumber.createSerial("cstm", 6));
		info.setCorpcode(corpCode);
		info.setCorpprojectname(corpProjectName);
		info.setProjectstartdate(sdf.parse(starttime));
		info.setProjectenddate(sdf.parse(endtime));
		User user = (User) request.getSession().getAttribute("user");
		info.setOpercode(user.getUsercode());
		info.setOpertime(new Date());*/
		if(corpProjectService.insertCorpContant(con)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加公司项目信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加公司项目信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("deletecontent")
	@ResponseBody
	public Map<String,Object> deletecontent(String Id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
	int c=corpProjectService.deletecontent(Id);
	if(c>=0){
		resultMap.put("status", 0);
		resultMap.put("msg", "删除成功");
	}else{
		resultMap.put("status", 1);
		resultMap.put("msg", "删除失败");
	}
		return resultMap;
	}
	
	@RequestMapping("openmodify")
	@ResponseBody
	public ModelAndView openmodify(String Id){
		ModelAndView mv = new ModelAndView("views/corp/modifycorpe");
		Map<String, Object> map=new HashMap<String,Object>();
		map=corpProjectService.selectcorpcontantById(Id);
		mv.addObject("map",map);
		return mv;
	}
	@RequestMapping("modifyCorpcontent")
	@ResponseBody
	public Map<String,Object> modifyCorpcontent(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "ContanName", defaultValue = "") String ContanName,
			@RequestParam(value = "ContTel", defaultValue = "") String ContTel,
			@RequestParam(value = "ConPhone", defaultValue = "") String ConPhone,
			@RequestParam(value = "ContOfficeTel", defaultValue = "") String ContOfficeTel,
			@RequestParam(value = "QQ", defaultValue = "") String QQ,
			@RequestParam(value = "WeiXin", defaultValue = "") String WeiXin,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CorpContant con= corpProjectService.getcorpcontantById(id);
		con.setCorpcode(corpCode);
		con.setContanname(ContanName);
		con.setConttel(ContTel);
		con.setConphone(ConPhone);
		con.setContofficetel(ContOfficeTel);
		con.setQq(QQ);
		con.setWeixin(WeiXin);
		con.setRemark(Remark);
		User user = (User) request.getSession().getAttribute("user");
		con.setOpercode(user.getUsercode());
		con.setOpertime(new Date());
		
		int c=corpProjectService.updatecorpcontant(con);
		if(c>=0){
			resultMap.put("status", 0);
			resultMap.put("msg", "修改成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "修改失败");
		}
			return resultMap;
	}
	@RequestMapping("queryProjectByCorpCode")
	@ResponseBody
	public ResultObject queryProjectByCorpCode(String corpCode){
		ResultObject result = ResultObject.getResultObject();
		try {
			List<CorpProject> list = corpProjectService.queryProjectByCorpCode(corpCode);
			result.setSuccess(true);
			result.setResultData(list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
}
