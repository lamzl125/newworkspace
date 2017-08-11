package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.User;
import com.shzqoa.service.CustomerprojectpayService;
import com.shzqoa.util.ResultObject;

@Controller
@RequestMapping("paydetail")
public class CustomerprojectpayController {

	@Resource
	private CustomerprojectpayService customerprojectpayService;
	
	@RequestMapping("queryOutCompany")
	public ModelAndView queryOutCompany(@RequestParam(value = "cid", defaultValue = "") String cid,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,//每页条数
    		HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		params.put("cid", cid);
		List<Map<String, Object>> list = customerprojectpayService.queryOutCompany(params);
		int total = customerprojectpayService.queryOutCompanyCount(params);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		model.put("cid", cid);
		model.put("total", total);
		model.put("tatalpage", tatalpage);//总页数
		model.put("currpage", page);//当前页
		model.put("list", list);
		return new ModelAndView("views/customerCompany/serverMoneyEdit", model);
	}
	
	@RequestMapping("saveWp")
	@ResponseBody
	public ResultObject saveWp(Customerprojectpay c, HttpServletRequest request){
		ResultObject resultObject = ResultObject.getResultObject();
		try {
			UUID uuid = UUID.randomUUID();
			c.setId(uuid.toString());
			User user = (User) request.getSession().getAttribute("user");
			c.setOperCode(user.getUsercode());
			c.setOperTime(new Date());
			int i = customerprojectpayService.save(c);
			resultObject.setResultData(i);
			if(i>0){
				resultObject.setSuccess(true);
				resultObject.setResultMessage("添加成功");
			}else{
				resultObject.setSuccess(false);
				resultObject.setResultMessage("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultObject.setSuccess(false);
			resultObject.setResultMessage(e.getMessage());
		}
		return resultObject;
	}
	
	@RequestMapping("queryAllByParams")
	@ResponseBody
	public ModelAndView queryAllByParams(@RequestParam(value = "customerCode", defaultValue = "") String customerCode,
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,//每页条数
    		HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("customerCode", customerCode);
		params.put("corpCode", corpCode);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		List<Customerprojectpay> list = customerprojectpayService.queryProjectAndPays(params);
		int total = customerprojectpayService.queryAllCount(params);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		model.put("customerCode", customerCode);
		model.put("corpCode", corpCode);
		model.put("total", total);
		model.put("tatalpage", tatalpage);//总页数
		model.put("currpage", page);//当前页
		model.put("list", list);
		return new ModelAndView("views/customerCompany/projectDetails", model);
	}
	
	@RequestMapping("saveXm")
	@ResponseBody
	public ResultObject saveXm(@RequestParam(value = "customerCode", defaultValue = "") String customerCode,
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "settledCompany", defaultValue = "") String settledCompany,
			@RequestParam(value = "corpProjectCode", defaultValue = "") String corpProjectCode,
			@RequestParam(value = "startTime", defaultValue = "2222") String startTime,
			@RequestParam(value = "endTime", defaultValue = "") String endTime,
			@RequestParam(value = "settledCycle", defaultValue = "") String settledCycle,
			@RequestParam(value = "salary", defaultValue = "") String salary,
			@RequestParam(value = "servicePay", defaultValue = "") String servicePay,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,//每页条数
    		HttpServletRequest request) {
		ResultObject resultObject = ResultObject.getResultObject();
		try {
			int i = customerprojectpayService.saveXm(customerCode, corpCode, settledCompany, corpProjectCode, startTime, endTime, settledCycle, salary, servicePay, page, pageSize);
			resultObject.setResultData(i);
			if(i>0){
				resultObject.setSuccess(true);
				resultObject.setResultMessage("添加成功");
			}else{
				resultObject.setSuccess(false);
				resultObject.setResultMessage("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultObject.setSuccess(false);
			resultObject.setResultMessage(e.getMessage());
		}
		return resultObject;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResultObject updateCustomerprojectpay(String id,String settledCompany,String corpProjectCode,String startTime,
								String endTime,String settledCycle,String salary,String servicePay){
		ResultObject result = ResultObject.getResultObject();
		try {
			int i = customerprojectpayService.updateCustomerprojectpay(id,settledCompany,corpProjectCode,startTime,
					endTime,settledCycle,salary,servicePay);
			result.setResultData(i);
			if(i>0){
				result.setSuccess(true);
				result.setResultMessage("修改成功");
			}else{
				result.setSuccess(false);
				result.setResultMessage("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
}
