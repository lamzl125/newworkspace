package com.shzqoa.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.dao.CustomerprojectpayMapper;
import com.shzqoa.dao.MonthServicePayMapper;
import com.shzqoa.model.Corp;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.Items;
import com.shzqoa.model.MonthServicePay;
import com.shzqoa.model.MonthServicePayFollow;
import com.shzqoa.model.User;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.CustomerprojectpayService;
import com.shzqoa.service.MonthServicePayFollowService;
import com.shzqoa.service.MonthServicePayService;
import com.shzqoa.service.SalarySetService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.SerialNumber;
/**
 * 服务费用统计
 * @author Auser
 *
 */
@Controller
@RequestMapping(value = "/servicepaysummary")
public class ServicePaySummaryController {
	private final Logger log = Logger.getLogger(ServicePaySummaryController.class);
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
	private MonthServicePayService monthServicePayService;
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private MonthServicePayFollowService monthServicePayFollowService;
	@Resource
	private MonthServicePayMapper monthServicePayMapper;
	@Resource
	private CustomerprojectpayMapper customerprojectpayMapper;
	//实际回款 
	@RequestMapping("/actualpayment")
	public ModelAndView actualpayment(
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,//每页条数
    		@RequestParam(value = "yearstr", defaultValue = "0") int yearstr,
    		@RequestParam(value = "monthstr", defaultValue = "0") int monthstr,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("views/monthservicepay/actualpaylist");
		mv.addObject("currpage", page);
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(corpcode)){
			params.put("corpCode", corpcode);
			mv.addObject("corpCode", corpcode);
		}
		mv.addObject("yearIndex", yearstr);
		mv.addObject("monthIndex", monthstr);
		
		params.put("yearIndex", yearstr);
		params.put("monthIndex", monthstr);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		params.put("isReceivedPayments", 1);
		
		List<Map<String,Object>> lsit = monthServicePayFollowService.actualPayfollowlist(params);
		int total = monthServicePayFollowService.actualPayfollowCount(params);
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
		mv.addObject("list", lsit);
		//查询合作公司列表
		List<Corp> corplist = corpService.getCorpList();
		mv.addObject("corplist", corplist);
		
		List<Map<String,Object>> payoperlist = monthServicePayFollowService.payofdemandofoper(new HashMap<String,Object>());
		mv.addObject("payoperlist", payoperlist);
		return mv;
	}
	
	
	
	//预计回款 
	@RequestMapping("/expectedreturn")
	public ModelAndView expectedreturn(
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,//每页条数
    		@RequestParam(value = "yearstr", defaultValue = "0") int yearstr,
    		@RequestParam(value = "monthstr", defaultValue = "0") int monthstr,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/monthservicepay/corpmonthservicepaylist");
		mv.addObject("currpage", page);
		//1.查询回款信息
		List<Map<String,Object>> list = monthServicePayService.querySumMonthServicePay(new HashMap<String,Object>());
		//2.查询已经生成的预计回款信息
		List<MonthServicePayFollow>  yjlist = monthServicePayFollowService.getAllMonthServicePayFollow(new HashMap<String,Object>());
		
		//3.比对回款信息和预计回款信息,并生成预计回款信息
		List<MonthServicePayFollow> addlist = new ArrayList<MonthServicePayFollow>();//需新增的预计回款
		if(list!=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				Map<String,Object> mapinfo = list.get(i);
				if(yjlist!=null && yjlist.size()>0){//生成过预计回款
					int count = 0;
					for(int j=0;j<yjlist.size();j++){
						MonthServicePayFollow mf = yjlist.get(j);
						boolean flag = mf.getCorpCode().equals((String)mapinfo.get("CorpCode"));
						flag = flag && mf.getServicePayYearr().equals((Integer)mapinfo.get("YearIndex"));
						flag = flag && mf.getServicePayMonth().equals((Integer)mapinfo.get("MonthIndex"));
						if(flag){
							count++;
						}
					}
					if(count==0){
						MonthServicePayFollow addinfo = new MonthServicePayFollow();
						addinfo.setId(SerialNumber.createSerial("mspf", 5));
						addinfo.setCorpCode((String)mapinfo.get("CorpCode"));
						addinfo.setServicePayYearr((Integer)mapinfo.get("YearIndex"));
						addinfo.setServicePayMonth((Integer)mapinfo.get("MonthIndex"));
						addinfo.setServiceTitle((Integer)mapinfo.get("YearIndex")+"年"+(Integer)mapinfo.get("MonthIndex")+"月费用");
						addinfo.setAmount((Double)mapinfo.get("TotalServicePay"));
						addinfo.setIsReceivedPayments(0);//是否回款（0-否  1-是）
						addlist.add(addinfo);
					}
				}else{//未生成预计回款信息					
					MonthServicePayFollow addinfo = new MonthServicePayFollow();
					addinfo.setId(SerialNumber.createSerial("mspf", 5));
					addinfo.setCorpCode((String)mapinfo.get("CorpCode"));
					addinfo.setServicePayYearr((Integer)mapinfo.get("YearIndex"));
					addinfo.setServicePayMonth((Integer)mapinfo.get("MonthIndex"));
					addinfo.setServiceTitle((Integer)mapinfo.get("YearIndex")+"年"+(Integer)mapinfo.get("MonthIndex")+"月费用");
					addinfo.setAmount((Double)mapinfo.get("TotalServicePay"));
					addinfo.setIsReceivedPayments(0);//是否回款（0-否  1-是）
					addlist.add(addinfo);
				}
			}
			if(addlist!=null && addlist.size()>0){
				monthServicePayFollowService.batchaddmonthservpayfollow(addlist);
			}
		}
		//3.查询回款列表
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(corpcode)){
			params.put("corpCode", corpcode);
			mv.addObject("corpCode", corpcode);
		}
		mv.addObject("yearIndex", yearstr);
		mv.addObject("monthIndex", monthstr);
		
		params.put("yearIndex", yearstr);
		params.put("monthIndex", monthstr);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		params.put("isReceivedPayments", 0);
		List<Map<String,Object>> lsit = monthServicePayFollowService.querymonthserpayfollowlist(params);
		int total = monthServicePayFollowService.querymonthserpayfollowlistCount(params);
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
		mv.addObject("list", lsit);
		
		//查询合作公司列表
		List<Corp> corplist = corpService.getCorpList();
		mv.addObject("corplist", corplist);
		return mv;
	}
	
	@RequestMapping("/insureopenservicepayedit")  
	@ResponseBody
	public  Map<String,Object> insureopenservicepayedit(
			@RequestParam(value = "CorpCode", defaultValue = "0") String CorpCode,
			@RequestParam(value = "ServicePayYearr", defaultValue = "0") String ServicePayYearr,
			@RequestParam(value = "ServicePayMonth", defaultValue = "0") String ServicePayMonth,
			@RequestParam(value = "Amount", defaultValue = "0") String Amount){
		Map<String,Object> resultMap=new HashMap<String, Object>();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("CorpCode",CorpCode);
		map.put("ServicePayYearr",ServicePayYearr);
		map.put("ServicePayMonth",ServicePayMonth);
		List<MonthServicePayFollow> list2=monthServicePayFollowService.getMonthServicePayFollowBycode(map);
		
		if(list2.get(0).getIsReceivedPayments()==1){
			resultMap.put("status", 1);
			resultMap.put("msg", "不需要跟踪");
		}else{
			resultMap.put("status", 0);
			resultMap.put("msg", "需要跟踪");
		}
		
		return resultMap;
	}
	
	@RequestMapping("/openservicepayedit")  
	@ResponseBody
	public ModelAndView openservicepayedit(
			@RequestParam(value = "CorpCode", defaultValue = "0") String CorpCode,
			@RequestParam(value = "ServicePayYearr", defaultValue = "0") String ServicePayYearr,
			@RequestParam(value = "ServicePayMonth", defaultValue = "0") String ServicePayMonth,
			@RequestParam(value = "Amount", defaultValue = "0") String Amount){
		ModelAndView mv = new ModelAndView("views/monthservicepay/modifymonthservice");
		
		List<Map<String, Object>> list1=customerInfoService.selectresumeBycorpcode(CorpCode,ServicePayMonth,ServicePayYearr);
			mv.addObject("CorpCode", CorpCode);
			mv.addObject("ServicePayYearr", ServicePayYearr);
			mv.addObject("ServicePayMonth", ServicePayMonth);
			mv.addObject("Amount", Amount);
			mv.addObject("list1", list1);
			
			return mv;
		
		
	}
	
	@RequestMapping("/suresalary")  
	@ResponseBody
	public Map<String,Object> suresalary(
			@RequestParam(value = "ServicePayMonth", defaultValue = "") String ServicePayMonth,
			@RequestParam(value = "ServicePayYearr", defaultValue = "") String ServicePayYearr,
			@RequestParam(value = "Amount", defaultValue = "") String Amount,
			@RequestParam(value = "monthpayremark", defaultValue = "") String monthpayremark,
			@RequestParam(value = "CorpCode", defaultValue = "") String CorpCode,
			@RequestParam(value = "SubPay", defaultValue = "") String SubPay,
			@RequestParam(value = "CustomerCode", defaultValue = "") String CustomerCode,
			HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("CorpCode", CorpCode);
		params.put("CustomerCode", CustomerCode);    
		List<Customerprojectpay> list=customerprojectpayService.queryProjectAndPaysBycode(params);
		Map<String, Object> params1 = new HashMap<String, Object>();
		params1.put("CustomerProjectPayId", list.get(0).getId());
		params1.put("YearIndex", ServicePayYearr);
		params1.put("MonthIndex", ServicePayMonth);
		List<MonthServicePay> monthlist=monthServicePayService.queryPayByProjectPayId(params1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("customerCode", CustomerCode);
		map.put("corpCode", CorpCode);
		Calendar c = Calendar.getInstance();
		//某月的开始时间为当月1号
		c.set(Integer.parseInt(ServicePayYearr), Integer.parseInt(ServicePayMonth)-1, 1,0,0,0);
		Date minDate = c.getTime();
		
		c.set(Integer.parseInt(ServicePayYearr), Integer.parseInt(ServicePayMonth), 1,0,0,0);
		Date maxDate = c.getTime();
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		List<Customerprojectpay> paylist = customerprojectpayMapper.querymonthservpay(map);	
		if(monthlist.size()>0){
			MonthServicePay month= monthlist.get(0);
			month.setSubPay(Double.parseDouble(SubPay));
			month.setRealPay(monthlist.get(0).getServicePay()-Double.parseDouble(SubPay));
			month.setSubContent(monthpayremark);
			month.setUpdatePeople(user.getUsercode());
			month.setUpdateTime(new Date());
			month.setSubContent(monthpayremark);
			month.setAddPeople(monthlist.get(0).getAddPeople());
			month.setAddTime(month.getAddTime());
			
			if(monthServicePayService.updatemonthservicepay(month)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "确认成功");
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "确认失败");
			}
			
		}else{
			List<MonthServicePay> addpaylist = new ArrayList<MonthServicePay>();
			MonthServicePay month= new MonthServicePay();
			month.setId(SerialNumber.createSerial("mspm", 4));
			month.setCustomerProjectPayId(list.get(0).getId());
			month.setYearIndex(Integer.parseInt(ServicePayYearr));
			month.setMonthIndex(Integer.parseInt(ServicePayMonth));
			month.setPayStatus(1);
			
			month.setServicePay(paylist.get(0).getServicePay());
			month.setSubPay(Double.parseDouble(SubPay));
			month.setSubContent(monthpayremark);
			month.setRealPay(paylist.get(0).getServicePay()-Double.parseDouble(SubPay));
			month.setAddPeople(user.getUsercode());
			month.setAddTime(new Date());
			addpaylist.add(month);
			if(monthServicePayMapper.batchaddmonthservpay(addpaylist)>0){
				resultMap.put("status", 0);
				resultMap.put("msg", "确认成功");
			}
			else{
				resultMap.put("status", 1);
				resultMap.put("msg", "确认失败");
			}
		}
		return resultMap;
	}
	
	@RequestMapping("/saveservicepayfollow")  
	@ResponseBody
	public Map<String,Object> saveservicepayfollow(
			@RequestParam(value = "CorpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "ServicePayMonth", defaultValue = "") String ServicePayMonth,
			@RequestParam(value = "ServicePayYearr", defaultValue = "") String ServicePayYearr,
			@RequestParam(value = "ServiceTitle", defaultValue = "") String ServiceTitle,
			@RequestParam(value = "Amount", defaultValue = "") String Amount,
			@RequestParam(value = "PlanrRceivedPaymentsDate", defaultValue = "") String PlanrRceivedPaymentsDate,
			@RequestParam(value = "IsSureReceivedDate", defaultValue = "") Integer IsSureReceivedDate,
			@RequestParam(value = "FollowContent", defaultValue = "") String FollowContent,
			@RequestParam(value = "IsReceivedPayments", defaultValue = "") Integer IsReceivedPayments,
			@RequestParam(value = "RceivedPayments", defaultValue = "") Double RceivedPayments,
			@RequestParam(value = "AccountReceivable", defaultValue = "") Integer AccountReceivable,
			@RequestParam(value = "PaymentContent", defaultValue = "") String PaymentContent,
			@RequestParam(value = "PaymentDate", defaultValue = "") String PaymentDate,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			HttpServletRequest request,HttpServletResponse response
			) throws IOException, ParseException {
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> resultMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		MonthServicePayFollow follow=new MonthServicePayFollow();
		follow.setId(SerialNumber.createSerial("mspf", 5));
		   
		   follow.setCorpCode(corpCode);
		   follow.setServicePayMonth(Integer.parseInt(ServicePayMonth));
		   follow.setServicePayYearr(Integer.parseInt(ServicePayYearr));
		   follow.setServiceTitle(ServiceTitle);
		   follow.setAmount(Double.parseDouble(Amount));
		   follow.setPlanrRceivedPaymentsDate(sdf.parse(PlanrRceivedPaymentsDate.replaceAll(" +","")));
		   follow.setIsSureReceivedDate(IsSureReceivedDate);
		   follow.setFollowDate(new Date());
		   follow.setFollowPeople(user.getUsercode());
		   follow.setFollowContent(FollowContent);
		   follow.setIsReceivedPayments(IsReceivedPayments);
		   follow.setRceivedPayments(RceivedPayments);
		   follow.setAccountReceivable(AccountReceivable);
		   follow.setPaymentContent(PaymentContent);
		   follow.setPaymentDate(sdf.parse(PaymentDate.replaceAll(" +","")));
		   follow.setRemark(Remark);
		   List<MonthServicePayFollow> addlist = new ArrayList<MonthServicePayFollow>();
		   addlist.add(follow);
		   
		if(monthServicePayFollowService.batchaddmonthservpayfollow(addlist)>0){
			List<Map<String, Object>> list1=customerInfoService.selectresumeBycorpcode(corpCode,ServicePayMonth,ServicePayYearr);
			for(Map<String, Object> info:list1){
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("CorpCode", corpCode);
				params.put("CustomerCode", info.get("CustomerCode"));  
				List<Customerprojectpay> list=customerprojectpayService.queryProjectAndPaysBycode(params);
				Map<String, Object> params1 = new HashMap<String, Object>();
				params1.put("CustomerProjectPayId", list.get(0).getId());
				params1.put("YearIndex", ServicePayYearr);
				params1.put("MonthIndex", ServicePayMonth);
				List<MonthServicePay> monthlist=monthServicePayService.queryPayByProjectPayId(params1);
				
				if(Double.parseDouble(info.get("RealPay").toString())==0){
					if(monthlist.size()>0){
						MonthServicePay month= monthlist.get(0);
						month.setRealPay(monthlist.get(0).getServicePay());
						month.setAddPeople(user.getUsercode());
						month.setAddTime(new Date());
						month.setUpdatePeople(user.getUsercode());
						month.setUpdateTime(new Date());
						monthServicePayService.updatemonthservicepay(month);
				   }
				}
			}
			resultMap.put("status", 0);
			resultMap.put("msg", "保存成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "保存失败");
		}
		return resultMap;
	}
	
	
	
	//服务费用汇总
	@RequestMapping("/queryServicePaySumList")
	public ModelAndView queryServicePaySumList(
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,//每页条数
    		@RequestParam(value = "yearstr", defaultValue = "0") int yearstr,
    		@RequestParam(value = "monthstr", defaultValue = "0") int monthstr,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		log.info("开始查询服务费用");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currpage", page);
		User user = (User)request.getSession().getAttribute("user");
		//生成服务费用
		if(yearstr==0||monthstr==0){
			Date date = new Date();
			yearstr = date.getYear()+1900;
			monthstr = date.getMonth()+1;
		}
		corpcode = URLDecoder.decode(corpcode, "UTF-8");		
		int count = monthServicePayService.batchaddmonthservpay(yearstr, monthstr, corpcode, null, null, null, user.getUsercode());
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(corpcode)){
			params.put("corpCode", corpcode);
			model.put("corpCode", corpcode);
		}
		model.put("yearstr", yearstr);
		model.put("monthstr", monthstr);
		
		params.put("yearIndex", yearstr);
		params.put("monthIndex", monthstr);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		
		//查询服务费用
		List<Map<String,Object>> list = monthServicePayService.querySumMonthServicePay(params);
		int total = monthServicePayService.querySumMonthServicePayCount(params);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		model.put("total", total);
		model.put("tatalpage", tatalpage);
		model.put("list", list);
		
		//查询合作公司列表
		List<Corp> corplist = corpService.getCorpList();
		model.put("corplist", corplist);
		return new ModelAndView("views/monthservicepay/monthservicepaysumlist",model);
	}
	
	//查询利润
	@RequestMapping("/queryServiceProfitsList")
	public ModelAndView queryServiceProfitsList(
			@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "1") int pageSize,//每页条数
    		@RequestParam(value = "corpname", defaultValue = "") String corpname) throws UnsupportedEncodingException{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currpage", page);
		customername = URLDecoder.decode(customername, "UTF-8");
		corpname = URLDecoder.decode(corpname, "UTF-8");
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(customername)){
			params.put("customername", customername.replaceAll(" +", ""));
			model.put("customername", customername);
		}
		if(StringUtils.isNotBlank(corpname)){
			params.put("corpCode", corpname);
			model.put("corpCode", corpname);
		}
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		List<CustomerInfo> list1 = customerInfoService.selectCuName();
		
		//查询服务费用
			List<Map<String,Object>> list = monthServicePayService.queryMapMonthServicePay(params);
			model.put("list", list);
			
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
			List<Map<String, Object>> profitList = new ArrayList<Map<String, Object>>();//查询利润总和
			List<Map<String, Object>> compareList = new ArrayList<Map<String, Object>>();//利润/投资总额
			if(cplist!=null && cplist.size()>0){
				for(int i=0;i<cplist.size();i++ ){
					Customerprojectpay info = cplist.get(i);
					//查询所有月份
					List<Date> monthlist = customerprojectpayService.queryAllMonth(info.getStartTime(), info.getEndTime());
					monthpay.put(info.getId(), monthlist);
					
					/*//查询截止到选择时间所有月份
					Calendar calendar=Calendar.getInstance();
				       calendar.set(yearstr, monthstr, 20);  //年月日  也可以具体到时分秒如calendar.set(2015, 10, 12,11,32,52); 
				       Date endtdate=calendar.getTime();//date就是你需要的时间
					List<Date> selectmonthlist = customerprojectpayService.queryAllMonth(info.getStartTime(), endtdate);*/
					
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
					
					//查询利润总和
					if(monthlist!=null && monthlist.size()>0){
						Map<String,Object> compare = new HashMap<String,Object>();
						Map<String,Object> comparefit = new HashMap<String,Object>();
						Double profit=0.0;
						Double servicepay=0.0;
						
						//循环月份计算利润总和
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
							
							Map<String,Object> map1 = new HashMap<String,Object>();
							map1.put("corpCode", info.getCorpCode());
							map1.put("customerProjectPayId", info.getId());
							map1.put("yearIndex", date.getYear());
							map1.put("monthIndex", date.getMonth());
							map1.put("customerCode", info.getCustomerCode());
							List<Map<String,Object>> paylist = monthServicePayService.queryMapMonthServicePay(map1);
							if(paylist!=null && paylist.size()!=0){
								servicepay+=(Double)paylist.get(0).get("RealPay");
							}
							
							if(salarylist!=null && salarylist.size()!=0){
								Double IdleSalary=(Double)salarylist.get(0).get("IdleSalary");
								Double XzFdTime=(Double)salarylist.get(0).get("XzFdTime");
								Double XzTime=(Double)salarylist.get(0).get("XzTime");
								Integer CdTime=(Integer)salarylist.get(0).get("CdTime");
								Double ProbationarySalary=(Double)salarylist.get(0).get("ProbationarySalary");
								Double SyqFdTime=(Double)salarylist.get(0).get("SyqFdTime");
								Double SyqTime=(Double)salarylist.get(0).get("SyqTime");
								Double RegularSalary=(Double)salarylist.get(0).get("RegularSalary");
								Double FdTime=(Double)salarylist.get(0).get("FdTime");
								Double SjTime=(Double)salarylist.get(0).get("SjTime");
								Double Sj=(Double)salarylist.get(0).get("Sj");
								Double Kjk=(Double)salarylist.get(0).get("Kjk");
								Double Kzs=(Double)salarylist.get(0).get("Kzs");
								Double Bxiao=(Double)salarylist.get(0).get("Bxiao");
								Double Bxian=(Double)salarylist.get(0).get("Bxian");
								Double Bz=(Double)salarylist.get(0).get("Bz");
								profit+=IdleSalary/XzFdTime*XzTime-CdTime*10+ProbationarySalary/SyqFdTime*SyqTime+
								RegularSalary/FdTime*SjTime-Sj-Kjk-Kzs+Bxiao+Bxian+Bz;
							}
							
							allsalarylist.addAll(salarylist);
						}
						/*singleprofit.put(info.getId(),profit);*/
						comparefit.put(info.getId(),servicepay-profit);
						compare.put(info.getId(),(servicepay-profit)+"/"+servicepay);
						profitList.add(comparefit);
						compareList.add(compare);
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
			
		//查询在项人员信息列表
		List<CustomerInfo> cuslist = customerDetailService.getCustomerinfoByCon(new HashMap<String,Object>());
		model.put("cuslist", cuslist);
		
		//查询合作公司列表
		List<Corp> corplist = corpService.getCorpList();
		model.put("total", total);
		model.put("tatalpage", tatalpage);
		model.put("currpage", page);
		model.put("corplist", corplist);
		model.put("profitList", profitList);
		model.put("allsalarylist", allsalarylist);
		model.put("allpaylist", allpaylist);
		model.put("compareList", compareList);
		model.put("monthpay", monthpay);
		model.put("cplist", cplist);
		model.put("list1", list1);
		return new ModelAndView("views/monthservicepay/monthserviceprofitslist",model);
		
	}
			
	//月服务费用查询
	@RequestMapping("/queryServicePayList")
	public ModelAndView queryServicePayList(
    		@RequestParam(value = "customercode", defaultValue = "") String customercode,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,//每页条数
    		@RequestParam(value = "yearstr", defaultValue = "0") int yearstr,
    		@RequestParam(value = "monthstr", defaultValue = "0") int monthstr,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		log.info("开始查询服务费用");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("currpage", page);
		User user = (User)request.getSession().getAttribute("user");
		//生成服务费用
		if(yearstr==0||monthstr==0){
			Date date = new Date();
			yearstr = date.getYear()+1900;
			monthstr = date.getMonth()+1;
		}
		customercode = URLDecoder.decode(customercode, "UTF-8");
		corpcode = URLDecoder.decode(corpcode, "UTF-8");		
		int count = monthServicePayService.batchaddmonthservpay(yearstr, monthstr, corpcode, customercode, null, null, user.getUsercode());
		
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(customercode)){
			params.put("customerCode", customercode.replaceAll(" +", ""));
			model.put("customerCode", customercode);
		}
		if(StringUtils.isNotBlank(corpcode)){
			params.put("corpCode", corpcode);
			model.put("corpCode", corpcode);
		}
		model.put("yearstr", yearstr);
		model.put("monthstr", monthstr);
		
		params.put("yearIndex", yearstr);
		params.put("monthIndex", monthstr);
		params.put("offset", (page-1)*pageSize);
		params.put("pageSize", pageSize);
		
		//查询服务费用
		List<Map<String,Object>> list = monthServicePayService.queryMapMonthServicePay(params);
		int total = monthServicePayService.queryMapMonthServicePayCount(params);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		model.put("total", total);
		model.put("tatalpage", tatalpage);
		model.put("list", list);
		
		//查询在项人员信息列表
		List<CustomerInfo> cuslist = customerDetailService.getCustomerinfoByCon(new HashMap<String,Object>());
		model.put("cuslist", cuslist);
		
		//查询合作公司列表
		List<Corp> corplist = corpService.getCorpList();
		model.put("corplist", corplist);
		return new ModelAndView("views/monthservicepay/monthservicepaylist",model);
	}
}
