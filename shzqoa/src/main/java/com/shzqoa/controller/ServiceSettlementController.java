package com.shzqoa.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shzqoa.model.CustomerCompany;
import com.shzqoa.model.ServiceSettlement;
import com.shzqoa.model.User;
import com.shzqoa.service.ServiceSettlementService;
import com.shzqoa.util.SerialNumber;

@Controller
public class ServiceSettlementController {
	@Resource
	private ServiceSettlementService serviceSettlementService;//注入Service层
	/*
	 * 服务费用合计页面
	 */
	@RequestMapping("/serviceSettlement/selectCost")
	@ResponseBody
	public ModelAndView selectCost(
			@RequestParam(value="page",defaultValue="1") int page,
			@RequestParam(value="pageSize",defaultValue="1") int pageSize
			){
		ModelAndView mv=new ModelAndView("views/customerCompany/serviceSettlement");
		Map<String, Object> conMap=new HashMap<String, Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		List<ServiceSettlement> list= serviceSettlementService.selectCost(conMap);
		
		int total=serviceSettlementService.getCount(conMap);
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
		mv.addObject("list", list);
		return mv;
	}
	/**
	 * 费用凭证页面
	 * @param corpName
	 * @param servicePayCount
	 * @param request
	 * @return
	 */
	@RequestMapping("/expenseVoucher")
	public ModelAndView expenseVoucher(
			@RequestParam(value ="corpName",defaultValue="") String corpName,
			@RequestParam(value="servicePayCount",defaultValue="0") Double servicePayCount,
			@RequestParam(value="settlementMonth",defaultValue="0") String settlementMonth,
			HttpServletRequest request
			){
		ModelAndView mv=new ModelAndView("views/customerCompany/expenseVoucher");
		mv.addObject("corpName",corpName);
		mv.addObject("servicePayCount", servicePayCount);
		mv.addObject("settlementMonth", settlementMonth);
		return mv;
	}
	@RequestMapping(value = "/addCustomercompany")
	@ResponseBody
	public int addCustomercompany(
			@RequestParam(value ="corpName",defaultValue="") String corpName,
			@RequestParam(value="predictCost",defaultValue="0") Double predictCost,
			@RequestParam(value="realityCost",defaultValue="0") Double realityCost,
			@RequestParam(value ="settlementMonth",defaultValue="") String settlementMonth,
			@RequestParam(value ="voucherpath",defaultValue="") String certificate,
			@RequestParam(value ="explain",defaultValue="") String explain,
			HttpServletRequest request) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		CustomerCompany ctcy = new CustomerCompany();
        ctcy.setId(SerialNumber.createSerial("ctcy-", 5));
		String date = sdf.format(new Date());
		Date creatime = sdf.parse(date);
		ctcy.setCreatime(creatime);
		ctcy.setCompanyName(corpName);
		ctcy.setPredictCost(predictCost);
		ctcy.setRealityCost(realityCost);
		User user = (User) request.getSession().getAttribute("user");
		ctcy.setOperator(user.getRealname());
		ctcy.setCertificate(certificate);
		ctcy.setExplain(explain);	
		ctcy.setBalancemonth(settlementMonth);
		ctcy.setStatus(0);
		if(serviceSettlementService.addCustomercompany(ctcy)>0){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 * 处理上传文件
	 */
	@RequestMapping(value = "/uploadVoucher")
	@ResponseBody
	public String uploadResume(@RequestParam(value = "voucher") MultipartFile voucher,
			HttpServletRequest request,HttpServletResponse response){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String contextPath = request.getSession().getServletContext().getRealPath("/");  //项目路径
		String tempPath = File.separator+"fileUpload"+File.separator+sdf.format(today)+"temp"; //临时路径
        String fileName = +new Date().getTime()+voucher.getOriginalFilename();  //保存文件的名称
        File tempFile = new File(contextPath +tempPath, fileName); 
        //临时目录是否存在，如果不存在则重新创建
        if(!tempFile.exists()){  
        	tempFile.mkdirs();  
        }  
        //保存  
        try {  
        	voucher.transferTo(tempFile); 
        } catch (Exception e) {  
            return "";
        }
        return File.separator+"shzqoa"+tempPath+File.separator+ fileName;
	}
}
