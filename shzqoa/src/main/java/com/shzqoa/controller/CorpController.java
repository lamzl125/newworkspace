package com.shzqoa.controller;

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

import com.shzqoa.model.Corp;
import com.shzqoa.model.User;
import com.shzqoa.service.CorpService;
@Controller
@RequestMapping(value = "/corp")
public class CorpController {
	@Resource
	private CorpService corpService;
	
	@RequestMapping("/toAddCorp")  
    public ModelAndView toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "seaCorpName", defaultValue = "") String seaCorpName,
    		@RequestParam(value = "seaCorpStatus", defaultValue = "") Integer seaCorpStatus
    		){
		ModelAndView mv = new ModelAndView("views/corp/corpManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		mv.addObject("seaCorpName", seaCorpName);
		mv.addObject("seaCorpStatus", seaCorpStatus);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(seaCorpName!=null && !"".equals(seaCorpName)){
			conMap.put("corpname", seaCorpName);
		}
		if(seaCorpStatus!=null && seaCorpStatus>0){
			conMap.put("corpStatus", seaCorpStatus);
		}
		
		List<Corp> lsit = corpService.getAllCorp(conMap);
		
		int total = corpService.getAllCoropsCount(conMap);
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
		mv.addObject("cp", corpService.overdueCue());
		mv.addObject("list", lsit);
		return mv;
	}
	
	@RequestMapping("/saveCorp")  
	@ResponseBody
	public Map<String,Object> saveAreas(
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "corpName", defaultValue = "") String corpName,
			@RequestParam(value = "starttime", defaultValue = "") String starttime,
			@RequestParam(value = "endtime", defaultValue = "") String endtime,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		//查询地区编号是否存在
		Corp isEx = corpService.getCorpById(corpCode);
		if(isEx !=null){
			resultMap.put("status", 1);
			resultMap.put("msg", "该公司编号已存在");
		}else{
			Corp info = new Corp();
			info.setCorpcode(corpCode);
			info.setCorpname(corpName);
			info.setStarttime(sdf.parse(starttime));
			info.setEndtime(sdf.parse(endtime));
			if(corpService.insertCorp(info)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "添加公司信息成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "添加公司信息失败");
			}
		}
		return resultMap;
	}
	
	/**
	 * 过期合作公司提示
	 * @return
	 */
	@RequestMapping("overdueCue")
	public ModelAndView overdueCue(){
		ModelAndView mv = new ModelAndView("views/corp/cue");
		List<Map<String,Object>> list = corpService.overdueCue();
		mv.addObject("list", list);
		return mv;
		
	}
	
	
	@RequestMapping("/toCloseCorp")
	public ModelAndView toCloseCorp(String corpcode){
		ModelAndView mv = new ModelAndView("views/corp/closecorp");
		mv.addObject("corpcode", corpcode);
		return mv;
		
	}
	
	
	
	@RequestMapping("/closeCorp")  
	@ResponseBody
	public Map<String,Object> closeCorp(
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "closeReason", defaultValue = "") String closeReason,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User)request.getSession().getAttribute("user");
		//查询地区编号是否存在
		Corp isEx = corpService.getCorpById(corpcode);
		isEx.setCorpStatus(2);
		isEx.setClosePeople(user.getUsercode());
		isEx.setCloseReason(closeReason);
		isEx.setCloseTime(new Date());
		
		
		if(corpService.closeCorp(isEx)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "关闭公司信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "关闭公司信息失败");
		}
		return resultMap;
	}
	
}
