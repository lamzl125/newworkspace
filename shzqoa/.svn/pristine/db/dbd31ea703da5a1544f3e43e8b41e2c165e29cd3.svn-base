package com.shzqoa.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.service.CustomerInfoService;

@Controller
public class PerfomanceDetailController {
	@Resource 
	private CustomerInfoService customerinfoService;
	/**
	 * 根据员工code获取详细客户列表
	 * @param page
	 * @param pageSize
	 * @param opertCode
	 * @param request
	 * @return
	 */
	@RequestMapping(value="PerfomanceDetail")
	public ModelAndView SelectCustByOpertCode(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, 
			@RequestParam(value = "opertCode", defaultValue = "") String opertCode,  //'员工code',
			HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/statistics/jixiaoxq");
		Map<String, Object> map=customerinfoService.selectCustInfoByOpertCode(page, pageSize, opertCode);
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		mv.addAllObjects(map);
		return mv;
	}
}
