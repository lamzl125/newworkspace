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
import com.shzqoa.model.DemandNoteStatistics;
import com.shzqoa.model.User;
import com.shzqoa.model.WorkDemand;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.DemandNoteService;
import com.shzqoa.service.DemandNoteStatisticsService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/demandnotestatistics")
public class DemandNoteStatisticsController {
	@Resource
	private DemandNoteService demandNoteService;
	@Resource
	private CorpService corpService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private UserService userService;
	
	@Resource
	private DemandNoteStatisticsService demandNoteStatisticsService;
	
	
	
	@RequestMapping(value="/saveNoteStatistics")
	@ResponseBody
	public ResultObject saveNoteStatistics(
			@RequestParam(value = "statisticsid", defaultValue = "") String statisticsid,
			@RequestParam(value = "demandnoteid", defaultValue = "") String demandnoteid,
			@RequestParam(value = "daypageview", defaultValue = "0") Long daypageview,
    		@RequestParam(value = "allpageview", defaultValue = "0")  Long allpageview,
    		HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();
		User user = (User) request.getSession().getAttribute("user");

		try {
			DemandNoteStatistics info = new DemandNoteStatistics();
			if(statisticsid!=null && !"".equals(statisticsid)){
				info = demandNoteStatisticsService.selectByPrimaryKey(statisticsid);
			}else{
				info.setStatisticsid(SerialNumber.createSerial("stid", 4));
			}
			info.setAddpeople(user.getUsercode());
			info.setAddtime(new Date());
			info.setAllpageview(allpageview);
			info.setDaypageview(daypageview);
			info.setDemandnoteid(demandnoteid);
			int resultcount = 0;
			if(statisticsid!=null && !"".equals(statisticsid)){
				resultcount = demandNoteStatisticsService.updateByPrimaryKey(info);
			}else{
				resultcount = demandNoteStatisticsService.insert(info);
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
	
	
	@RequestMapping("/toNoteStatisticsAdd")  
    public ModelAndView toNoteStatisticsAdd(
    		@RequestParam(value = "demandnoteid", defaultValue = "") String demandnoteid
    		){
		ModelAndView	mv = new ModelAndView("views/demandnote/notestatistics");
		if(demandnoteid!=null && !"".equals(demandnoteid)){
			DemandNote info = demandNoteService.selectByPrimaryKey(demandnoteid);
			mv.addObject("map",info);
			mv.addObject("demandnoteid",demandnoteid);
		}
		
		mv.addObject("notesourcelist", parameterService.selectByName(ResourceUtil.NOTSOURCE));
		mv.addObject("userlist", userService.getAllUsers());
		return mv;
	}
	
	@RequestMapping("/toNoteStatisticsList")  
    public ModelAndView toNoteStatisticsList(
    		@RequestParam(value = "demandnoteid", defaultValue = "") String demandnoteid,
    		@RequestParam(value = "addtime", defaultValue = "") String addtime,
    		@RequestParam(value = "addpeople", defaultValue = "") String addpeople,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) throws UnsupportedEncodingException, ParseException{
		ModelAndView mv = new ModelAndView("views/demandnote/notestatisticslist");
		demandnoteid = URLDecoder.decode(demandnoteid,"UTF-8");
		addtime = URLDecoder.decode(addtime,"UTF-8");
		addpeople = URLDecoder.decode(addpeople,"UTF-8");	
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if(demandnoteid!=null && !"".equals(demandnoteid)){
			acMap.put("demandnoteid", demandnoteid);
			mv.addObject("demandnoteid",demandnoteid);
		}
		if(addtime!=null && !"".equals(addtime)){			
			acMap.put("addtime", sf.parse(addtime));
			mv.addObject("addtime",sf.parse(addtime));
		}
		if(addpeople!=null && !"".equals(addpeople)){
			acMap.put("addpeople", addpeople);
			mv.addObject("addpeople",addpeople);
		}
		List<Map<String, Object>> notestalist = demandNoteStatisticsService.getNoteStatisticsListByMap(acMap);
		int total = demandNoteStatisticsService.getNotesStatisticsCountByMap(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("list",notestalist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		
		return mv;
	}
	
}
