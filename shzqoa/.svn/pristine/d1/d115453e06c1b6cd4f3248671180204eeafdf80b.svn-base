package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shzqoa.model.DemandResumeRelation;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.DemandResumeRelationService;
import com.shzqoa.util.SerialNumber;

@Controller
public class DemandResumeRelationController {
	@Resource
	private DemandResumeRelationService demandResumeRelationService;
	
	@RequestMapping("/saveDemandResumeRelation")
	public ReturnDate saveDemandResumeRelation(
			@RequestParam(value="customerdemandid" ,defaultValue = "") String customerdemandid,
			@RequestParam(value="customercode" ,defaultValue = "") String customercode,
			HttpServletRequest request,HttpServletResponse response
			){
		DemandResumeRelation drr = new DemandResumeRelation();
		drr.setId(SerialNumber.createSerial("drr", 5));
		drr.setCustomerdemandid(customerdemandid);
		drr.setCustomercode(customercode);
		User user = (User) request.getSession().getAttribute("user");
		drr.setOperationcode(user.getUsercode());
		java.util.Date operationtime = new Date();
		drr.setOperationtime(operationtime);
		ReturnDate rd = new ReturnDate();
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("customerdemandid", drr.getCustomerdemandid());
		paraMap.put("customercode", drr.getCustomercode());
		if(demandResumeRelationService.selectSame(paraMap)>0){
			rd.setStatus(1);
			rd.setMsg("该用户已绑定,请勿重复绑定!");
		}else{
			if(demandResumeRelationService.insertDRR(drr)>0){
				rd.setStatus(0);
				rd.setMsg("添加关联成功！");
			}else{
				rd.setStatus(1);
				rd.setMsg("添加关联失败！");
			}
		}
		return rd;
	}

}
