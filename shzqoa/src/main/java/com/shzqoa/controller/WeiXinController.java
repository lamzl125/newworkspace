package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.shzqoa.service.DailyLogService;



@Controller
@RequestMapping(value = "/weixin")
public class WeiXinController {
	@Resource
	private DailyLogService dailyLogService;
	
	
	@RequestMapping("/weixinlist")  
    public ModelAndView weixinlistcon(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/weixin/weixinlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		
		
		List<Map<String,Object>> list = dailyLogService.getWeiXinListByMap(acMap);		
		int total = dailyLogService.getWeiXinListCountByMap(acMap);
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
		mv.addObject("weixinlist", list);
		return mv;
	}
}
