package com.shzqoa.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Corp;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.User;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.CustomerprojectpayService;
import com.shzqoa.service.ItemsService;
import com.shzqoa.service.MonthServicePayService;
import com.shzqoa.service.SalarySetService;
import com.shzqoa.service.UserService;

@Controller
@RequestMapping(value = "/customerAllInfoDatail")
public class CustomerAllInfoDetailController {
	private final Logger log = Logger.getLogger(CustomerAllInfoDetailController.class);
	
	@Resource
	private CustomerprojectpayService customerprojectpayService;
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private CorpService corpService;
	@Resource
	private UserService userService;
	@Resource
	private SalarySetService salarySetService;
	@Resource
	private ItemsService itemsService;
	@Resource
	private MonthServicePayService  monthServicePayService;
	
	@RequestMapping("/queryCustomerDetails")
	public ModelAndView queryCustomerDetails(
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customersex", defaultValue = "") String customersex,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "1") int pageSize,//每页条数
    		HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			customername = URLDecoder.decode(customername, "UTF-8");
			if(StringUtils.isNotBlank(customername)){
				params.put("customername", customername.replaceAll(" +", ""));
			}
			if(StringUtils.isNotBlank(customersex)){
				params.put("customersex", customersex);
			}
			params.put("offset", (page-1)*pageSize);
			params.put("pageSize", pageSize);
			List<CustomerInfo> list = customerInfoService.selectCuName();
			
			
			//查询签约信息
			List<Customerprojectpay> cplist = customerprojectpayService.queryAllPay(params);
			int total = customerprojectpayService.queryAllPayCount(params);
			int tatalpage = 0;
			if(total != 0){
				if(total%pageSize!=0){
					tatalpage = total/pageSize+1;
				}else{
					tatalpage = total/pageSize;
				}
			}
			
			
			//查询月份
			Map<String,List<Date>> monthpay = new HashMap<String,List<Date>>();//查询月份列表
			List<Map<String,Object>> allsalarylist = new ArrayList<Map<String,Object>>();//查询工资信息
			List<Map<String,Object>> allpaylist = new ArrayList<Map<String,Object>>();//查询付款信息
			if(cplist!=null && cplist.size()>0){
				for(int i=0;i<cplist.size();i++ ){
					Customerprojectpay info = cplist.get(i);
					//查询所有月份
					List<Date> monthlist = customerprojectpayService.queryAllMonth(info.getStartTime(), info.getEndTime());
					monthpay.put(info.getId(), monthlist);
					
					//查询考勤信息
					if(monthlist!=null && monthlist.size()>0){
						for(int j=0;j<monthlist.size();j++){
							Date date = monthlist.get(j);
							Calendar cal = Calendar.getInstance();
							cal.set(date.getYear(),date.getMonth(), date.getDay(),date.getHours(), date.getMinutes(), date.getSeconds());
							cal.add(Calendar.MONTH, 1);
							
							Map<String,Object> map = new HashMap<String,Object>();
							map.put("month", cal.getTime());//下个月
							map.put("searchcustomercode", info.getCustomerCode());
							map.put("start",0);
							map.put("pageSize", 1);
							List<Map<String,Object>> salarylist = salarySetService.getSalaryList(map);
							allsalarylist.addAll(salarylist);
						}
					}
					
					//查询付款信息
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("corpCode", info.getCorpCode());
					map.put("customerProjectPayId", info.getId());
					map.put("customerCode", info.getCustomerCode());
					List<Map<String,Object>> paylist = monthServicePayService.queryMapMonthServicePay(map);
					allpaylist.addAll(paylist);
				}
			}
			model.put("customername", customername);
			model.put("customersex", customersex);
			model.put("total", total);
			model.put("tatalpage", tatalpage);//总页数
			model.put("currpage", page);//当前页
			model.put("list", list);
			model.put("cplist", cplist);
			model.put("monthpay", monthpay);
			model.put("allsalarylist", allsalarylist);
			model.put("allpaylist", allpaylist);
			
			//查询客户公司信息
			List<Corp> corplist = corpService.getCorpList();
			model.put("corplist", corplist);
			
			//查询人事列表
			List<User> userlist = userService.getAllUsers();
			model.put("userlist", userlist);
			
			//查询未归还物品列表
			List<Map<String,Object>> noreturnlist = itemsService.getNotReturnList();
			model.put("noreturnlist", noreturnlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/customerallinfodetail/customerallinfolist",model);
	}
	
}
