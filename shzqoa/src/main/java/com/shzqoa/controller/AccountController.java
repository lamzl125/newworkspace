package com.shzqoa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.AccountArea;
import com.shzqoa.model.Accounts;
import com.shzqoa.model.Areas;
import com.shzqoa.model.ResumeSource;
import com.shzqoa.service.AccountsService;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.util.ResultObject;
@Controller
@RequestMapping(value = "/account")
public class AccountController {
	
	@Resource
	private AccountsService accountsService;
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private AreasService areasService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@RequestMapping("/toAccount")  
    public ModelAndView toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/account/accounts");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		List<AccountArea> list = accountsService.selaccount(acMap);
		List<Areas> areasList = areasService.getAreaList();
		List<ResumeSource>  resumeList= resumeSourceService.getResumeSourseList();
		int total = accountsService.getAllAreasCount(acMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("areasList",areasList);
		mv.addObject("resumeList", resumeList);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("accountList", list);
		return mv;
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject save(Accounts accounts){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(accounts != null){
				int i = 0;
				if(accounts.getAid() != null){
					//update
					i = accountsService.update(accounts);
				}else{
					//insert
					i = accountsService.save(accounts);
				}
				result.setResultData(i);
				if(i>0){
					result.setSuccess(true);
					result.setResultMessage("保存成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("保存失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	@RequestMapping("delete")
	@ResponseBody
	public ResultObject delete(String aid){
		ResultObject result = ResultObject.getResultObject();
		try {
			if(StringUtils.isNotBlank(aid)){
				int n = customerInfoService.checkAccountsIsUse(aid);
				if(n>0){
					result.setResultData(-1);
					result.setSuccess(false);
					result.setResultMessage("该账户已使用，无法删除！");
				}else{
					int i = accountsService.delete(aid);
					result.setResultData(i);
					if(i>0){
						result.setSuccess(true);
						result.setResultMessage("删除成功");
					}else{
						result.setSuccess(false);
						result.setResultMessage("删除失败");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
}
