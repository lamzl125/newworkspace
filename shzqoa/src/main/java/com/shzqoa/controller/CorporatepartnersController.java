package com.shzqoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shzqoa.model.Corporatepartners;
import com.shzqoa.service.CorporatepartnersService;
import com.shzqoa.util.ResultObject;

@Controller
@RequestMapping("Corporatepartner")
public class CorporatepartnersController {

	@Resource
	private CorporatepartnersService corporatepartnersService;
	
	@RequestMapping("queryAll")
	@ResponseBody
	public ResultObject queryAll(){
		ResultObject resultObject = ResultObject.getResultObject();
		try {
			List<Corporatepartners> list = corporatepartnersService.queryAll();
			if(list!=null){
				resultObject.setSuccess(true);
				resultObject.setResultData(list);
			}else{
				resultObject.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultObject.setSuccess(false);
			resultObject.setResultMessage(e.getMessage());
		}
		return resultObject;
	}
	
}
