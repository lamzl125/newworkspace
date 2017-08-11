package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shzqoa.model.DemandResumeRelation;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.DemandResumeRelationService;
import com.shzqoa.util.SerialNumber;

@Controller
@RequestMapping(value="/customerDemand")
public class DemandRelationController {
	
	@Resource
	private DemandResumeRelationService demandResumeRelationService;
	@RequestMapping("/buddingDemand")
	@ResponseBody
	public ReturnDate buddingDemand(
			@RequestParam(value = "customerdemandid", defaultValue = "") String customerdemandid,
			@RequestParam(value = "custcodes[]", defaultValue = "") String[] customercodes,
			HttpServletRequest request){
		ReturnDate rd = new ReturnDate();
        boolean result = true;
		for(String custcode : customercodes){
			DemandResumeRelation drr = new DemandResumeRelation();
			drr.setId(SerialNumber.createSerial("drr", 5));
			drr.setCustomerdemandid(customerdemandid);
			drr.setCustomercode(custcode);
			User user = (User) request.getSession().getAttribute("user");
			drr.setOperationcode(user.getUsercode());
			java.util.Date operationtime = new Date();
			drr.setOperationtime(operationtime);
			Map<String,Object> paraMap = new HashMap<String,Object>();
			paraMap.put("customerdemandid", drr.getCustomerdemandid());
			paraMap.put("customercode", drr.getCustomercode());
			if(demandResumeRelationService.selectSame(paraMap)>0){
				result = false;
				rd.setStatus(1);
				rd.setMsg("绑定失败,请勿重复绑定!");
				break;
			}else{
				if(demandResumeRelationService.insertDRR(drr)<=0)
				{
					result = false;
					rd.setStatus(1);
					rd.setMsg("绑定失败！");
					break;
				}
			}
		}
		if(result){
			rd.setStatus(0);
			rd.setMsg("绑定成功！");
		}
		return rd;
	}

}
