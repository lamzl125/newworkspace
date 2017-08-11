package com.shzqoa.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.service.JianLiDetailsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
/*
 *根据操作员编号统计各大平台简历信息详情
 */
@Controller
public class JianLiDetailsController {
	@Resource
	JianLiDetailsService jianLiDetailsService;
	/*
	 * 简历统计
	 */
	@RequestMapping("/jianLiDetails/selectJianLiDetails")
	public ModelAndView selectJianLiDetails(
			@RequestParam(value="opertCode",defaultValue="") String opertCode,
			HttpServletRequest request){
		Map<String, Object> map=jianLiDetailsService.selectJianLiDetails(opertCode);
		ModelAndView mv=new ModelAndView("views/statistics/jianlidetails");
		mv.addAllObjects(map);
		return mv;
	}
}
