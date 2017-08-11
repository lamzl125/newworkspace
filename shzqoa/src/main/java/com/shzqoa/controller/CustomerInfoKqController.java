package com.shzqoa.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerInfoKq;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.CustomerInfoKqService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.DateUtils;
import com.shzqoa.util.ResultObject;

@Controller
@RequestMapping("/CustomerInfoKq")
public class CustomerInfoKqController {
	@Resource
	private CustomerInfoKqService customerInfoKqService;// 注入Service层
	@Resource
	private CustomerInfoService customerInfoService;// 注入CustomerInfoService层，外键取值
	@Resource
	private UserService userService;// 注入UserService层,外键取值
	
	/**
	 * 跳转到人员考勤列表信息页面
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/customerInfoKqList")
	public ModelAndView customerInfoKqList(
			@RequestParam(value = "beginTime", defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", defaultValue = "") String endTime,
			@RequestParam(value = "customerCode", defaultValue = "") String customerCode,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "usercode", defaultValue = "") String usercode
			) throws ParseException {
		ModelAndView mv = new ModelAndView(	"views/customerInfoKq/customerInfoKqlist");
		mv.addObject("currpage", page);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", (page - 1) * pageSize);
		map.put("pageSize", pageSize);
		if(usercode!=null && !"".equals(usercode)){
			map.put("usercode", usercode);
			mv.addObject("usercode", usercode);
		}
		if(customerCode!=null && !"".equals(customerCode)){
			map.put("customerCode", customerCode);
			mv.addObject("customerCode", customerCode);
		}
		if (StringUtils.isBlank(beginTime) && StringUtils.isBlank(endTime)) {
			Calendar c = Calendar.getInstance();
			c.set(Calendar.DAY_OF_MONTH, 1);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
			Date beginDate = c.getTime();
			c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
			c.add(Calendar.SECOND, -1);
			Date endDate = c.getTime();
			map.put("beginTime", beginDate);
			map.put("endTime", endDate);
			beginTime = DateUtils.formatY_M_D2String(beginDate,	DateUtils.FORMAT_Y_M_D);
			endTime = DateUtils.formatY_M_D2String(endDate,DateUtils.FORMAT_Y_M_D);
		} else {
			if (StringUtils.isNotBlank(beginTime)) {
				map.put("beginTime", DateUtils.formatY_M_D2Date(beginTime,DateUtils.FORMAT_Y_M_D));
			}
			if (StringUtils.isNotBlank(endTime)) {
				map.put("endTime", DateUtils.formatY_M_D2Date(endTime,	DateUtils.FORMAT_Y_M_D));
			}
		}
		List<CustomerInfoKq> kqlist = customerInfoKqService.selectCustomerInfoKqByMap(map);
		int total = customerInfoKqService.getCountByMap(map);
		int tatalpage = 0;
		if (total != 0) {
			if (total % pageSize != 0) {
				tatalpage = total / pageSize + 1;
			} else {
				tatalpage = total / pageSize;
			}
		}
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", kqlist);
		mv.addObject("customerinfos", customerInfoService	.queryCustomerDetails(new HashMap<String, Object>()));
		mv.addObject("users", userService.getAllUsers());
		mv.addObject("beginTime", beginTime);
		mv.addObject("endTime", endTime);
		return mv;
	}

	/**
	 * 跳转到录入人员考勤信息页面
	 * 
	 * @return
	 */
	@RequestMapping("/addCustomerInfoKq")
	public ModelAndView addCustomerInfoKq(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "customerCode", defaultValue = "") String customerCode) {
		ModelAndView mv = new ModelAndView(
				"views/customerInfoKq/addCustomerInfoKq");
		mv.addObject("customerInfos", customerInfoService
				.queryCustomerDetails(new HashMap<String, Object>()));
		mv.addObject("users", userService.getAllUsers());
		mv.addObject("cuskq",
				customerInfoKqService.selectCustomerInfoKqById(id));
		mv.addObject("customerCode", customerCode);
		return mv;
	}

	/**
	 * 执行录入考勤信息操作
	 * 
	 * @param customerInfoKq
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/saveCustomerInfoKq")
	@ResponseBody
	public ReturnDate saveCustomerInfoKq(
			@RequestParam(value = "customerCode", defaultValue = "") String customerCode,
			@RequestParam(value = "kqtimeStr", defaultValue = "") String kqtimeStr,
			CustomerInfoKq customerInfoKq, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ReturnDate data = new ReturnDate();
		customerInfoKq.setAddtime(new Date());
		UUID uuid = UUID.randomUUID();
		customerInfoKq.setId(uuid.toString());
		customerInfoKq.setStatus(1);
		try {
			customerInfoKq.setKqtime(DateUtils.formatY_M_D2Date(kqtimeStr,
					DateUtils.FORMAT_Y_M_D));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User user = (User) request.getSession().getAttribute("user");
		customerInfoKq.setUsercode(user.getUsercode());
		customerInfoKq.setCustomerCode(customerCode);
		if (customerInfoKqService.insertCustomerInfoKq(customerInfoKq) > 0) {
			data.setStatus(0);
			data.setMsg("添加成功！");
			return data;
		} else {
			data.setStatus(1);
			data.setMsg("添加考勤信息失败！");
			return data;
		}
	}

	/**
	 * 显示所有行考勤人员信息-对比
	 * 
	 * @return
	 */
	@RequestMapping("/selectCustomerInfoKq")
	@ResponseBody
	public ModelAndView selectCustomerInfoKq(
			@RequestParam(value = "customerCode", defaultValue = "") String customerCode,
			@RequestParam(value = "beginTime", defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", defaultValue = "") String endTime,
			@RequestParam(value = "ifZZ", defaultValue = "0") Integer ifZZ,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mv = new ModelAndView(
				"views/customerInfoKq/customerInfoKqShow");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("customerCode", customerCode);
			if (StringUtils.isBlank(beginTime) && StringUtils.isBlank(endTime)) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_MONTH, 1);
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
				Date beginDate = c.getTime();
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
				c.add(Calendar.SECOND, -1);
				Date endDate = c.getTime();
				map.put("beginTime", beginDate);
				map.put("endTime", endDate);
				beginTime = DateUtils.formatY_M_D2String(beginDate,
						DateUtils.FORMAT_Y_M_D);
				endTime = DateUtils.formatY_M_D2String(endDate,
						DateUtils.FORMAT_Y_M_D);
			} else {
				if (StringUtils.isNotBlank(beginTime)) {
					map.put("beginTime", DateUtils.formatY_M_D2Date(beginTime,
							DateUtils.FORMAT_Y_M_D));
				}
				if (StringUtils.isNotBlank(endTime)) {
					map.put("endTime", DateUtils.formatY_M_D2Date(endTime,
							DateUtils.FORMAT_Y_M_D));
				}
			}
			map.put("ifZZ", ifZZ);
			map.put("usercode", usercode);
			mv.addObject("currpage", page);
			map.put("start", (page - 1) * pageSize);
			map.put("pageSize", pageSize);
			List<CustomerInfoKq> customerInfoKqs = customerInfoKqService
					.selectCustomerInfoKq(map);
			int total = customerInfoKqService.getCount(map);
			int tatalpage = 0;
			if (total != 0) {
				if (total % pageSize != 0) {
					tatalpage = total / pageSize + 1;
				} else {
					tatalpage = total / pageSize;
				}
			}
			mv.addObject("customerCode", customerCode);
			mv.addObject("beginTime", beginTime);
			mv.addObject("endTime", endTime);
			mv.addObject("ifZZ", ifZZ);
			mv.addObject("usercode", usercode);
			mv.addObject("total", total);
			mv.addObject("tatalpage", tatalpage);
			mv.addObject("customerInfoKqs", customerInfoKqs);
			mv.addObject("customerinfos", customerInfoService
					.queryCustomerDetails(new HashMap<String, Object>()));
			mv.addObject("users", userService.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 显示所有出错的考勤信息
	 * 
	 * @return
	 */
	@RequestMapping("selectCustomerInfoKqIsNot")
	@ResponseBody
	public ModelAndView selectCustomerInfoKqIsNot(
			@RequestParam(value = "beginTime", defaultValue = "") String beginTime,
			@RequestParam(value = "endTime", defaultValue = "") String endTime,
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mv = new ModelAndView(
				"views/customerInfoKq/customerInfoKqShowWrong");

		try {
			Map<String, Object> map = new HashMap<String, Object>();
			//得到当前月的上一个月
			if (StringUtils.isBlank(beginTime) && StringUtils.isBlank(endTime)) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.DAY_OF_MONTH, 1);
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
				Date beginDate = c.getTime();
				c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
				c.add(Calendar.SECOND, -1);
				Date endDate = c.getTime();
				map.put("beginTime", beginDate);
				map.put("endTime", endDate);
				beginTime = DateUtils.formatY_M_D2String(beginDate,
						DateUtils.FORMAT_Y_M_D);
				endTime = DateUtils.formatY_M_D2String(endDate,
						DateUtils.FORMAT_Y_M_D);
			} else {
				if (StringUtils.isNotBlank(beginTime)) {
					map.put("beginTime", DateUtils.formatY_M_D2Date(beginTime,
							DateUtils.FORMAT_Y_M_D));
				}
				if (StringUtils.isNotBlank(endTime)) {
					map.put("endTime", DateUtils.formatY_M_D2Date(endTime,
							DateUtils.FORMAT_Y_M_D));
				}
			}
			//

			map.put("start", (page - 1) * pageSize);
			map.put("pageSize", pageSize);
			List<CustomerInfoKq> customerInfoKqsWrong = customerInfoKqService
					.selectCustomerInfoKqIsNot(map);
			int total = customerInfoKqService.getCountWrong(map);
			int tatalpage = 0;
			if (total != 0) {
				if (total % pageSize != 0) {
					tatalpage = total / pageSize + 1;
				} else {
					tatalpage = total / pageSize;
				}
			}
			mv.addObject("beginTime", beginTime);
			mv.addObject("endTime", endTime);
			mv.addObject("currpage", page);
			mv.addObject("total", total);
			mv.addObject("tatalpage", tatalpage);
			mv.addObject("customerInfoKqsWrong", customerInfoKqsWrong);
			mv.addObject("customerinfos", customerInfoService
					.queryCustomerDetails(new HashMap<String, Object>()));
			mv.addObject("users", userService.getAllUsers());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 修改错误考勤信息
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("updateCustomerInfoKq")
	@ResponseBody
	public ReturnDate updateCustomerInfoKq(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "status", defaultValue = "0") Integer status) {
		ReturnDate data = new ReturnDate();
		CustomerInfoKq customerInfoKq = customerInfoKqService
				.selectCustomerInfoKqById(id);
		customerInfoKq.setStatus(0);
		if (customerInfoKqService.updateCustomerInfoKq(customerInfoKq) > 0) {
			data.setStatus(0);
			data.setMsg("请重新录入该人员信息！");
			return data;
		} else {
			data.setStatus(1);
			data.setMsg("更新考勤信息失败！");
			return data;
		}
	}
}
