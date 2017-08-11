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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.DemandNote;
import com.shzqoa.model.User;
import com.shzqoa.model.WorkDemand;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.DemandNoteService;
import com.shzqoa.service.DemandNoteStatisticsService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkDemandService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/demandnote")
public class DemandNoteController {
	@Resource
	private DemandNoteService demandNoteService;
	@Resource
	private CorpService corpService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private UserService userService;
	@Resource
	private CustomerDemandService customerDemandService;
	@Resource
	private WorkDemandService workDemandService;
	@Resource
	private DemandNoteStatisticsService demandNoteStatisticsService;
	
	@Resource
	private UserGroupService userGroupService;
	
	
	@RequestMapping("/userstapv")  
    public ModelAndView userstapv(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
			@RequestParam(value = "enddate", defaultValue = "") String enddate,
			@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws ParseException{
		ModelAndView	mv = new ModelAndView("views/demandnote/usernotepvmanage");		
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		Date stardated = new Date();
		Date enddated = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(startdate !=null && !"".equals(startdate)){
			stardated = sf.parse(startdate);
			
		}
		acMap.put("startdate", stardated);
		mv.addObject("startdate", stardated);
		
		if(enddate !=null && !"".equals(enddate)){
			enddated = sf.parse(enddate);
		}
		acMap.put("enddate", enddated);
		mv.addObject("enddate", enddated);
		acMap.put("usergroupflag", 1);
		List<Map<String, Object>> notelist = demandNoteStatisticsService.getNoteDayPageViewByMap(acMap);
		int total = demandNoteStatisticsService.getNoteDayPageViewCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("list",notelist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		
		return mv;
	}
	
	
	@RequestMapping("/checkInfoById")
	@ResponseBody
	public ResultObject checkInfoById(String demandnoteid){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(demandnoteid!=null && !"".equals(demandnoteid)){
				DemandNote info = demandNoteService.selectByPrimaryKey(demandnoteid);
				info.setNotestatus(3);
				int i = demandNoteService.updateByPrimaryKey(info);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("关闭成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("关闭失败");
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
	
	
	@RequestMapping("/daypageviews")  
    public ModelAndView daypageviews(
    		@RequestParam(value = "startdate", defaultValue = "") String startdate,
			@RequestParam(value = "enddate", defaultValue = "") String enddate,
			@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws ParseException{
		ModelAndView	mv = new ModelAndView("views/demandnote/daynotepageviewmanage");		
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		Date stardated = new Date();
		Date enddated = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		if(startdate !=null && !"".equals(startdate)){
			stardated = sf.parse(startdate);
			
		}
		acMap.put("startdate", stardated);
		mv.addObject("startdate", stardated);
		
		if(enddate !=null && !"".equals(enddate)){
			enddated = sf.parse(enddate);
		}
		acMap.put("enddate", enddated);
		mv.addObject("enddate", enddated);
		List<Map<String, Object>> notelist = demandNoteStatisticsService.getNoteDayPageViewByMap(acMap);
		int total = demandNoteStatisticsService.getNoteDayPageViewCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("list",notelist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		
		return mv;
	}
	
	
	@RequestMapping("/closeInfoById")
	@ResponseBody
	public ResultObject closeInfoById(String demandnoteid){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(demandnoteid!=null && !"".equals(demandnoteid)){
				DemandNote info = demandNoteService.selectByPrimaryKey(demandnoteid);
				info.setNotestatus(2);
				int i = demandNoteService.updateByPrimaryKey(info);
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("关闭成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("关闭失败");
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
	
	@RequestMapping("/toEditInfo")  
    public ModelAndView toEditInfo(String demandnoteid){
		ModelAndView	mv = new ModelAndView("views/demandnote/demandnote");
		DemandNote info = demandNoteService.selectByPrimaryKey(demandnoteid);
		mv.addObject("map",info);
		mv.addObject("notesourcelist", parameterService.selectByName(ResourceUtil.NOTSOURCE));
		mv.addObject("userlist", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping(value="/saveDemandNote")
	@ResponseBody
	public ResultObject saveDemandNote(
			@RequestParam(value = "demandnoteid", defaultValue = "") String demandnoteid,
			@RequestParam(value = "customerdemandid", defaultValue = "") String customerdemandid,
			@RequestParam(value = "workdemandid", defaultValue = "") String workdemandid,
    		@RequestParam(value = "notesourceid", defaultValue = "")  Long notesourceid,
    		@RequestParam(value = "notename", defaultValue = "") String notename,
    		@RequestParam(value = "noteaddtime", defaultValue = "") String noteaddtime,
    		@RequestParam(value = "noteaddpeople", defaultValue = "") String noteaddpeople,
    		HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();
		User user = (User) request.getSession().getAttribute("user");

		try {
			DemandNote info = new DemandNote();
			if(demandnoteid!=null && !"".equals(demandnoteid)){
				info = demandNoteService.selectByPrimaryKey(demandnoteid);
			}else{
				info.setDemandnoteid(SerialNumber.createSerial("deno", 4));
			}
			if(customerdemandid!=null && !"".equals(customerdemandid)){
				info.setCustomerdemandid(customerdemandid);
				CustomerDemand cd = customerDemandService.selectById(customerdemandid);
				info.setCorpcode(cd.getCorpcode());
			}
			if(workdemandid!=null && !"".equals(workdemandid)){
				info.setWorkdemandid(workdemandid);
				WorkDemand wd = workDemandService.getWorkDemandById(workdemandid);
				info.setFactoryid(Long.parseLong(wd.getFactoryId()));
			}
			info.setNotesourceid(notesourceid);
			info.setNotename(notename);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			if(noteaddtime!=null && !"".equals(noteaddtime)){
				info.setNoteaddtime(sf.parse(noteaddtime));
			}
			info.setNoteaddpeople(noteaddpeople);
			info.setAddtime(new Date());
			info.setAddpeople(user.getUsercode());
			info.setDaypageview(0L);
			info.setAllpageview(0L);
			info.setNotestatus(1);//帖子状态（1-正常  2-待关闭   3-关闭）
			int resultcount = 0;
			if(demandnoteid!=null && !"".equals(demandnoteid)){
				resultcount = demandNoteService.updateByPrimaryKey(info);
			}else{
				resultcount = demandNoteService.insert(info);
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
	
	
	@RequestMapping("/toDemandNoteAdd")  
    public ModelAndView toDemandNoteAdd(
    		@RequestParam(value = "customerdemandid", defaultValue = "") String customerdemandid,
    		@RequestParam(value = "workdemandid", defaultValue = "") String workdemandid
    		){
		ModelAndView	mv = new ModelAndView("views/demandnote/demandnote");
		if(workdemandid!=null && !"".equals(workdemandid)){
			mv.addObject("workdemandid",workdemandid);
		}
		if(customerdemandid!=null && !"".equals(customerdemandid)){
			mv.addObject("customerdemandid",customerdemandid);
		}
		mv.addObject("notesourcelist", parameterService.selectByName(ResourceUtil.NOTSOURCE));
		mv.addObject("userlist", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping("/toDemanNoteList")  
    public ModelAndView toDemanNoteList(
    		@RequestParam(value = "customerdemandid", defaultValue = "") String customerdemandid,
    		@RequestParam(value = "workdemandid", defaultValue = "") String workdemandid,
    		@RequestParam(value = "factoryid", defaultValue = "") Long factoryid,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		@RequestParam(value = "notename", defaultValue = "") String notename,
    		@RequestParam(value = "noteaddpeople", defaultValue = "") String noteaddpeople,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/demandnote/demandnotemanage");
		customerdemandid = URLDecoder.decode(customerdemandid,"UTF-8");
		workdemandid = URLDecoder.decode(workdemandid,"UTF-8");
		corpcode = URLDecoder.decode(corpcode,"UTF-8");	
		notename = URLDecoder.decode(notename,"UTF-8");	
		noteaddpeople = URLDecoder.decode(noteaddpeople,"UTF-8");			
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		if(customerdemandid!=null && !"".equals(customerdemandid)){
			acMap.put("customerdemandid", customerdemandid);
			mv.addObject("customerdemandid",customerdemandid);
		}
		if(workdemandid!=null && !"".equals(workdemandid)){
			acMap.put("workdemandid", workdemandid);
			mv.addObject("workdemandid",workdemandid);
		}
		if(factoryid !=null && Long.valueOf(factoryid)>0){
			acMap.put("factoryid", factoryid);
			mv.addObject("factoryid",factoryid);
		}
		if(corpcode!=null && !"".equals(corpcode)){
			acMap.put("corpcode", corpcode);
			mv.addObject("corpcode",corpcode);
		}
		if(notename!=null && !"".equals(notename)){
			acMap.put("notename", notename);
			mv.addObject("notename",notename);
		}
		if(noteaddpeople!=null && !"".equals(noteaddpeople)){
			acMap.put("noteaddpeople", noteaddpeople);
			mv.addObject("noteaddpeople",noteaddpeople);
		}
		List<Map<String, Object>> notelist = demandNoteService.getNoteListByMap(acMap);
		int total = demandNoteService.getNotesCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("list",notelist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		mv.addObject("corplist", corpService.getCorpList());
		mv.addObject("factorylist", parameterService.selectByName(ResourceUtil.FACTORY));
		mv.addObject("notesourcelist", parameterService.selectByName(ResourceUtil.NOTSOURCE));
		mv.addObject("userlist", userService.getAllUsers());
		
		//判断当前用户是否是行政组
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> usermap = new HashMap<String,Object>();
		usermap.put("usercode", user.getUsercode());
		usermap.put("groupname", "行政组");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			mv.addObject("xzflag", 1);
		}else{
			mv.addObject("xzflag", 0);
		}
		
		return mv;
	}
	
	@RequestMapping("/delInfoById")
	@ResponseBody
	public ResultObject delInfoById(String demandnoteid){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(demandnoteid!=null && !"".equals(demandnoteid)){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("demandnoteid", demandnoteid);
				int rcount = demandNoteStatisticsService.getNotesStatisticsCountByMap(map);
				if(rcount>0){
					result.setSuccess(false);
					result.setResultMessage("删除失败,该帖子有统计信息，无法删除");
				}else{
					int i = demandNoteService.deleteByPrimaryKey(demandnoteid);
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
}
