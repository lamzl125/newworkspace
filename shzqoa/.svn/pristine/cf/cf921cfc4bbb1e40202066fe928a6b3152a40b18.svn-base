package com.shzqoa.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.standard.MediaSize.JIS;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jacob.com.DateUtilities;
import com.shzqoa.model.JianLi;
import com.shzqoa.service.AccountsService;
import com.shzqoa.service.JianLiService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.DateUtils;

@Controller
public class JianLiController {

	@Resource
	private JianLiService jianLiService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private UserService userService;
	@Resource
	private AccountsService accountsService;

	/**
	 * 简历统计页面
	 */
	@RequestMapping("/jianli/CustomerCount")
	@ResponseBody
	public ModelAndView selectCountByResume(
			@RequestParam(value = "resumesource", defaultValue = "0") int resumesource,
			@RequestParam(value = "ocode", defaultValue = "") String ocode,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "starttime", defaultValue = "") String starttime,
			@RequestParam(value = "endtime", defaultValue = "") String endtime,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
		ModelAndView mv = new ModelAndView("views/statistics/jianlitj");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("resumesource", resumesource);
			map.put("ocode", ocode);
			map.put("account", account);
			if (StringUtils.isBlank(starttime)) {
				Calendar c = Calendar.getInstance();
				int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
				if (day_of_week == 0)
					day_of_week = 7;
				c.add(Calendar.DATE, -day_of_week + 1);
				starttime = DateUtils.formatY_M_D2String(c.getTime(),
						DateUtils.FORMAT_Y_M_D);
				Date beginDate = DateUtils.formatY_M_D2Date(starttime, DateUtils.FORMAT_Y_M_D);
				map.put("starttime", beginDate);
			} else {
				if (StringUtils.isNotBlank(starttime)) {
					map.put("starttime", DateUtils.formatY_M_D2Date(starttime,
							DateUtils.FORMAT_Y_M_D));
				}
			}
			if (StringUtils.isBlank(endtime)) {
				Calendar c = Calendar.getInstance();
				int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
				if (day_of_week == 0)
					day_of_week = 7;
				c.add(Calendar.DATE, -day_of_week + 7);
				endtime = DateUtils.formatY_M_D2String(c.getTime(),
						DateUtils.FORMAT_Y_M_D);
				Date endDate = DateUtils.formatY_M_D2Date(endtime, DateUtils.FORMAT_Y_M_D);
				map.put("endtime",endDate);
				
			} else {
				if (StringUtils.isNotBlank(endtime)) {
					map.put("endtime", DateUtils.formatY_M_D2Date(endtime,
							DateUtils.FORMAT_Y_M_D));
				}
			}
			mv.addObject("currpage", page);
			map.put("start", (page - 1) * pageSize);
			map.put("pageSize", pageSize);
			List<JianLi> list = jianLiService.selectCountByResume(map);
			int total = jianLiService.getCount(map);
			int tatalpage = 0;
			if (total != 0) {
				if (total % pageSize != 0) {
					tatalpage = total / pageSize + 1;
				} else {
					tatalpage = total / pageSize;
				}
			}
			mv.addObject("resumesource", resumesource);
			mv.addObject("ocode", ocode);
			mv.addObject("account", account);
			mv.addObject("starttime", starttime);
			mv.addObject("endtime", endtime);
			mv.addObject("total", total);
			mv.addObject("tatalpage", tatalpage);
			mv.addObject("customerInfos", list);
			mv.addObject("users", userService.getAllUsers());
			mv.addObject("accounts", accountsService.selectaccount());
			mv.addObject("resumeSourceList", resumeSourceService
					.getAllResumeSource(new HashMap<String, Object>()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return mv;
	}
}
