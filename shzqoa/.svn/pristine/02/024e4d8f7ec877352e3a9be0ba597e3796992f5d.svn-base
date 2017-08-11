package com.shzqoa.controller;

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

import com.shzqoa.model.CustomerCompany;
import com.shzqoa.service.CustomerCompanyService;

@Controller
@RequestMapping("company")
public class CustomerCompanyController {

	@Resource
	private CustomerCompanyService customerCompanyService;
	
	@RequestMapping("initPage")
	public ModelAndView initPage(
    		@RequestParam(value = "customercode", defaultValue = "") String customercode,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,//每页条数
    		HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		List<CustomerCompany> list = customerCompanyService.queryAll(params);
		
		int total = customerCompanyService.queryCustomerCompanyCount();
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		
		model.put("total", total);
		model.put("tatalpage", tatalpage);//总页数
		model.put("currpage", page);//当前页
		model.put("list", list);
		return new ModelAndView("views/customerCompany/checkCompany", model);
	}
	
	@RequestMapping("operCheck")
	@ResponseBody
	public Integer operCheck(String status, String id){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("id", id);
		int n = customerCompanyService.operCheck(params);
		return n;
	}
}






