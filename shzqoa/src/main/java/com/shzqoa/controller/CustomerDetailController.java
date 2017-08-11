package com.shzqoa.controller;

import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.User;
import com.shzqoa.service.AccountsService;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CustomerCompanyService;
import com.shzqoa.service.CustomerContlService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.CustomerProjectService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.Word2PdfUtil;

@Controller
@RequestMapping(value = "/customerDatailInfo")
public class CustomerDetailController {
	private final Logger log = Logger.getLogger(CustomerDetailController.class);
	
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private CustomerContlService customerContlService;
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private CustomerCompanyService customerCompanyService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private AreasService areasService;
	@Resource
	private CustomerProjectService customerProjectService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private ProfessionService professionService;
	@Resource
	private AccountsService accountsService;
	@Resource
	private CustomerDemandService customerDemandService;
	
	@RequestMapping("/toCustomerDatailInfo")  
    public ModelAndView  toCustomerDatailInfo(
    		@RequestParam(value = "customercode", defaultValue = "") String customercode,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) {  
		ModelAndView mv = new ModelAndView("views/ygxq");
		User user = (User) request.getAttribute("user");
		if(user != null){
			mv.addObject("user", user);
		}
		
		log.info("开始查询客户详细信息");
		CustomerInfo info = customerDetailService.getCustomerinfoByCode(customercode);
		log.info("开始查询客户更新列表信息");
		Map<String,Object> map = customerContlService.getContactDateByCustomerCode(customercode,page,pageSize);
		mv.addAllObjects(map);
		mv.addObject("customerInfo", info);
		mv.addObject("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		mv.addObject("arealist", areasService.getAreaList());
		
		
		log.info("开始查询客户项目经验信息");
		Map<String,Object> promap = customerProjectService.getCustProByCustomerCode(customercode);
		mv.addObject("prolist", promap.get("list"));
		
		
		
		String contextPath = request.getSession().getServletContext().getRealPath("/");
		String path = contextPath.substring(0, contextPath.lastIndexOf("\\"))+info.getResumepath();
		String realPath = path.replaceAll("\\\\", "/");
		String pdfpath = "";
		if(info.getResumepath()!=null && !"".equals(info.getResumepath())){
			pdfpath = contextPath.substring(0, contextPath.lastIndexOf("\\"))+"/shzqoa/fileUpload"+info.getResumepath().substring(info.getResumepath().lastIndexOf("/"),info.getResumepath().lastIndexOf("."))+".pdf";
		}
		
		/**
		 * 判断转换的文件是否存在
		 */
		if(pdfpath!=null && !"".equals(pdfpath)){
			File pdffile = new File(pdfpath);
			if(pdffile.exists()){//文件存在
				mv.addObject("pdffilename", pdfpath.substring(pdfpath.indexOf("/shzqoa")));
			}else{
				log.info("开始进行转换");
				boolean flag = Word2PdfUtil.word2pdf(realPath, pdfpath.replaceAll("\\\\", "/"));
				if(!flag){
					map.put("status", 1);
					map.put("filename", "查看文档出错");
				}else{
					mv.addObject("pdffilename", pdfpath.substring(pdfpath.indexOf("/shzqoa")));
				}
			}
		}
		mv.addObject("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		mv.addObject("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		mv.addObject("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		mv.addObject("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		
		mv.addObject("professionlist", professionService.queryAll());
		mv.addObject("accountlist", accountsService.selectaccount());
		
		//查询抢取的需求且绑定该简历的需求
		Map<String,Object> umap = new HashMap<String,Object>();
		umap.put("customercode", customercode);
		List<Map<String,Object>> delist = customerDemandService.stlDemandByBindUser(umap);
		mv.addObject("delist", delist);
		
        return mv;  
    }  

	@RequestMapping("queryCustomerDetails")
	public ModelAndView queryCustomerDetails(
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customersex", defaultValue = "") String customersex,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,//每页条数
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
			List<CustomerInfo> list = customerInfoService.queryCustomerDetails(params);
			int total = customerInfoService.queryDetailsCount(params);
			int tatalpage = 0;
			if(total != 0){
				if(total%pageSize!=0){
					tatalpage = total/pageSize+1;
				}else{
					tatalpage = total/pageSize;
				}
			}
			model.put("customername", customername);
			model.put("customersex", customersex);
			model.put("total", total);
			model.put("tatalpage", tatalpage);//总页数
			model.put("currpage", page);//当前页
			model.put("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("views/customerCompany/serverMoney",model);
	}
	
	@RequestMapping(value="updateCustomer",method = RequestMethod.POST)
	@ResponseBody
	public String updateCustomer(String customercode,String entryCompanyDate,String entryCompany,String lastCompany,String unitPrice,String mathPeriod,String salary){
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(model);
		return "ok";
	}
}
