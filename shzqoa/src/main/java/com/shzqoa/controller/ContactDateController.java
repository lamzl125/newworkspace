package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shzqoa.model.ContactDate;
import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.DemandResume;
import com.shzqoa.model.DemandSign;
import com.shzqoa.model.User;
import com.shzqoa.service.ContactDateService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerprojectpayService;
import com.shzqoa.service.DemandResumeService;
import com.shzqoa.service.DemandSignService;
import com.shzqoa.util.SerialNumber;

@Controller
@RequestMapping(value = "/contactDate")
public class ContactDateController {
	private final Logger log = Logger.getLogger(ContactDateController.class);
	
	@Resource
	private ContactDateService contactDateService;
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private CustomerDemandService customerDemandService;
	@Resource
	private DemandResumeService demandResumeService;
	@Resource
	private DemandSignService demandSignService;
	@Resource
	private CustomerprojectpayService customerprojectpayService;
	
	@RequestMapping("/addContactDate") 
	@ResponseBody
    public Map<String,Object>  toCustomerDatailInfo(
    		@RequestParam(value = "customercode", defaultValue = "") String customercode,
    		@RequestParam(value = "currusercode", defaultValue = "") String currusercode,
    		@RequestParam(value = "newcontmemo", defaultValue = "") String newcontmemo,
    		@RequestParam(value = "newentprobability", defaultValue = "") Integer newentprobability,
    		@RequestParam(value = "newrelationshipbyzh", defaultValue = "") Integer newrelationshipbyzh,
    		@RequestParam(value = "newrelationshipbyzq", defaultValue = "") Integer newrelationshipbyzq,
    		@RequestParam(value = "updateStatus", defaultValue = "") Integer updateStatus,
    		@RequestParam(value = "joinprojecttime", defaultValue = "") String joinprojecttime,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
    		@RequestParam(value = "considerChangeJob", defaultValue = "") Integer considerChangeJob,
    		@RequestParam(value = "intentionArea", defaultValue = "") String intentionArea,
    		@RequestParam(value = "joindemand", defaultValue = "") String joindemand,
    		HttpServletRequest request
    		) throws Exception {
		log.info("新增联系信息开始");
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> result = new HashMap<String,Object>();
		DemandResume dr = null;
		DemandSign ds = null;
		CustomerDemand cd = null;
		if(joindemand != null && !"".equals(joindemand)){
			dr = demandResumeService.stlObjectById(joindemand);
			ds = demandSignService.selectObjectById(dr.getDemandSignId());
			cd = customerDemandService.selectById(ds.getDemandId());
		}
		
//		CustomerInfo info = customerDetailService.getCustomerinfoByCode(customercode);
//		if(info.getComEvaluate()!=null & info.getProEvaluate()!=null & info.getProEvaluate()!=null ){
			ContactDate contactDate = new ContactDate();
			String serrialno = SerialNumber.createSerial("shzq", 6);
			contactDate.setContactdatecode(serrialno);
			contactDate.setContacttime(new Date());
			contactDate.setContactusercode(currusercode);
			contactDate.setContactcustomercode(customercode);
			contactDate.setEntryprobability(newentprobability);
			contactDate.setMemo(newcontmemo);
			contactDate.setUpdatestatic(updateStatus);
			contactDate.setConsiderChangeJob(considerChangeJob);
			contactDate.setIntentionArea(intentionArea);
			int addrestut = contactDateService.addContactDate(contactDate,customercode,newentprobability,newrelationshipbyzh,newrelationshipbyzq,joinprojecttime);
			if(addrestut<1){
				result.put("status", 1);
				result.put("errormsg", "添加更新信息失败");
			}else{
				if(joindemand != null && !"".equals(joindemand)){
					Customerprojectpay cpp = new Customerprojectpay();
					UUID uuid = UUID.randomUUID();
					cpp.setId(uuid.toString());
					cpp.setCustomerCode(dr.getCustomerCode());
					cpp.setCorpCode(cd.getCorpcode());
					cpp.setOperCode(user.getUsercode());
					cpp.setOperTime(new Date());
					int i = customerprojectpayService.save(cpp);
					if(i>0){
						result.put("status", 0);
						result.put("rightmsg", "添加更新信息成功");
					}else{
						result.put("status", 1);
						result.put("rightmsg", "添加更新信息失败");
					}
				}else{
					result.put("status", 0);
					result.put("rightmsg", "添加更新信息成功");
				}
			}
			return result;
//		}else{
//			result.put("status", 1);
//			result.put("errormsg", "请先对该简历人员进行评价");
//			return result;
//		}
		
    }  

}
