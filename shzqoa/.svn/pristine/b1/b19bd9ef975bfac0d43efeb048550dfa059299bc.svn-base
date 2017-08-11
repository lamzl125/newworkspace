package com.shzqoa.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.service.CustomerInfoService;

/*
 * 添加评价
 */
@Controller
@RequestMapping(value="/PingJia")
public class PingJiaController {
	@Resource
	CustomerInfoService customerInfoService;//注入Service层
	/*
	 * 进入添加评价的页面
	 */
	@RequestMapping("edit")
	public String eidt(String customercode,Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) throws IOException{
		CustomerInfo customerInfo=customerInfoService.selectByCustomercode(customercode);
		model.put("customerInfo", customerInfo);
		return "views/PingJia/addPingJia";
	}
	/*
	 * 执行添加评价的操作
	 */
	@RequestMapping("update")
	public void update(CustomerInfo customerInfo,Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) throws IOException{
		customerInfoService.updateEvaluate(customerInfo);
		response.sendRedirect("/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customerInfo.getCustomercode());
	}
}
