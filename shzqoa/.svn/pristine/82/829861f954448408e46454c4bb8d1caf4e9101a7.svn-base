package com.shzqoa.service;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.ContactDateMapper;
import com.shzqoa.dao.CustomerDemandMapper;
import com.shzqoa.dao.CustomerInfoMapper;
import com.shzqoa.model.ContactDate;
import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.CustomerProject;
import com.shzqoa.util.SerialNumber;

@Service
public class CustomerInfoService {
	private final Logger log = Logger.getLogger(CustomerContlService.class);
	@Resource
	private CustomerDemandMapper customerDemandMapper;
	@Resource
	CustomerInfoMapper customerInfoMapper;
	@Resource
	ContactDateMapper contactDateMapper;
	@Resource
	CustomerProjectService customerProjectService;
	
	/**
	 * 查询人员信息列表
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param customersex
	 * @param customertel
	 * @param customerbirth
	 * @param customeruniversity
	 * @param customerspecialities
	 * @param entrytime
	 * @param resumesource
	 * @param resumeid
	 * @param lastvcompanyname
	 * @param lastprojectname
	 * @param technicalexpertise
	 * @param relationshipbyzq
	 * @param relationshipbyzh
	 * @param entryprobability
	 * @return
	 */
	public Map<String, Object> CustomerInfoList(int page,int pageSize,String customername,Integer customersex,String customertel,
			String customerbirth,String customeruniversity,String customerspecialities,String entrytime,Integer resumesource,
			String resumeid,String lastvcompanyname,String lastprojectname,String technicalexpertise,Integer relationshipbyzq,
			Integer relationshipbyzh,Integer entryprobability,Integer lastupdatestatic) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize); 
		map.put("customername", customername); 
		map.put("customersex", customersex);
		map.put("customertel", customertel);  
		map.put("customerbirth",customerbirth);
		map.put("customeruniversity", customeruniversity);  
		map.put("customerspecialities", customerspecialities); 
		map.put("entrytime",entrytime);
		map.put("resumesource", resumesource); 
		map.put("resumeid", resumeid);  
		map.put("lastvcompanyname", lastvcompanyname);  
		map.put("lastprojectname", lastprojectname); 
		map.put("technicalexpertise", technicalexpertise);  
		map.put("relationshipbyzq", relationshipbyzq);  
		map.put("relationshipbyzh", relationshipbyzh);  
		map.put("entryprobability", entryprobability);  
		map.put("lastupdatestatic", lastupdatestatic);
		log.info("查询人员分页列表");
		List<CustInfoAdd> customerInfoList=customerInfoMapper.selectCustInfo(map);
		log.info("查询人员记录数");
		int total = customerInfoMapper.selectCustCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("customerInfoList", customerInfoList);
		map.put("tatalpage", tatalpage);
		return map;	
	}
	/**
	 * 兼职
	 * @return
	 */
	public Map<String, Object> selectCustInfoanddemand(int page,int pageSize,String customertel,String projecttype) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize); 
		map.put("customertel", customertel); 
		map.put("projecttype", projecttype);
		log.info("查询人员分页列表");
		List<Map<String, Object>> customerInfoList=customerInfoMapper.selectCustInfoanddemand(map);
		log.info("查询人员记录数");
		int total = customerInfoMapper.selectCustanddemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("customerInfoList", customerInfoList);
		map.put("tatalpage", tatalpage);
		return map;	
	}
	/**
	 * 增加人员信息
	 * @param customerinfo
	 * @return
	 */
    public Integer saveCustomerInfo(CustomerInfo customerinfo){
    	 ContactDate contactDate = new ContactDate();
    	 String serrialno = SerialNumber.createSerial("shzq", 6);
 		 contactDate.setContactdatecode(serrialno);
 		 contactDate.setContacttime(new Date());
 		 contactDate.setContactusercode(customerinfo.getOpertcode());
 		 contactDate.setContactcustomercode(customerinfo.getCustomercode());
 		 contactDate.setEntryprobability(0);
 		 contactDate.setUpdatestatic(5);
 		 contactDate.setMemo("录入人员信息");
 		 if(customerInfoMapper.insertCustomerInfo(customerinfo)>0){
    		 return contactDateMapper.insertContactDate(contactDate);
    	 }else{
    		 return -1;
    	 }
    	
    }
    
    @Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer saveNewCustomerInfo(CustomerInfo customerinfo,List<CustomerProject> prolist) throws Exception{
    	 ContactDate contactDate = new ContactDate();
    	 String serrialno = SerialNumber.createSerial("shzq", 6);
 		 contactDate.setContactdatecode(serrialno);
 		 contactDate.setContacttime(new Date());
 		 contactDate.setContactusercode(customerinfo.getOpertcode());
 		 contactDate.setContactcustomercode(customerinfo.getCustomercode());
 		 contactDate.setEntryprobability(0);
 		 contactDate.setUpdatestatic(5);
 		 contactDate.setMemo("录入人员信息");
 		 
 		 for(CustomerProject proinfo : prolist){
 			proinfo.setCustProId(SerialNumber.createSerial("pro", 4));
 			proinfo.setCustomerCode(customerinfo.getCustomercode());
 		 }
 		 
 		 int addcusflag = customerInfoMapper.insertCustomerInfo(customerinfo);
 		 int addconflag = contactDateMapper.insertContactDate(contactDate);
 		 int addproflag = customerProjectService.insertList(prolist);
 		 if(addcusflag>0&&addconflag>0&&addproflag>0){
 			return addconflag;
    	 }else{
    		 throw new Exception("添加失败");
    	 }
    	
    }
    
    public Map<String, Object> selectCustInfoByOpertCode(int page,int pageSize,String opertCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);   
		map.put("opertcode", opertCode);  
		log.info("查询人员分页列表");
		List<CustomerInfo> customerInfoList=customerInfoMapper.selectCustInfoByOpertCode(map);
		log.info("查询人员记录数");
		int total = customerInfoMapper.selectCustCountByOpertCode(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("customerInfoList", customerInfoList);
		map.put("tatalpage", tatalpage);
		return map;	
	}
    
    
    public List<Map<String, Object>> selectresumeBycorpcode(String corpcode,String MonthIndex,String YearIndex) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("corpcode", corpcode);
    	map.put("MonthIndex", MonthIndex);
    	map.put("YearIndex", YearIndex);
		return customerInfoMapper.selectresumeBycorpcode(map);
    }
    
    public Map<String, Object> selectCustInfoByOpertCode(int page,int pageSize,String opertCode,String customername,String technologydirection,String projectlocation,String demandyears,String ocode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);   
		map.put("opertcode", opertCode);  
		map.put("customername", customername);
		map.put("technologydirection", technologydirection);
		map.put("projectlocation", projectlocation);
		map.put("demandyears", demandyears);
		map.put("ocode", ocode);
		log.info("查询人员分页列表");
		List<CustomerInfo> customerInfoList=customerInfoMapper.selectCustInfoByOpertCode2(map);
		log.info("查询人员记录数");
		int total = customerInfoMapper.selectCustCountByOpertCode2(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("customerInfoList", customerInfoList);
		map.put("tatalpage", tatalpage);
		return map;	
	}
    
    public List<CustomerInfo> seltCusBytask(Map<String,Object> map){
    	return customerInfoMapper.seltCusOftask(map);
    }
    
    /**
     * 绩效统计
     * @return
     */
    public List<Map<String,Object>> performanceCount(Map<String,Object> map){
    	return customerInfoMapper.performanceCount(map);
    }
    public Integer performanceCountNum(Map<String,Object> map){
    	return customerInfoMapper.performanceCountNum(map);
    }
    
    /**
     * 绩效搜索
     * @param opertcode
     * @return
     */
    public List<Map<String,Object>> markSearch(Map<String,Object> opertname){
		return customerInfoMapper.markSearch(opertname);
    }
    
    public Integer markSearchCount(Map<String,Object> opertname){
		return customerInfoMapper.markSearchCount(opertname);
    }
    
    /**
     * 为客户添加评价
     */
    public void updateEvaluate(CustomerInfo customerInfo){
    	customerInfoMapper.updateEvaluate(customerInfo);
    }
    /*
     * 通过客户编号找到对应的客户信息
     */
    public CustomerInfo selectByCustomercode(String customercode){
    	return customerInfoMapper.selectByCustomercode(customercode);
    }
    public List<Map<String,Object>> demandResumeOfDemand(String customercode){
		return customerInfoMapper.demandResumeOfDemand(customercode);
	}
    public List<Map<String,Object>> selectCustInfoanddemand(Map<String,Object> map){
		return customerInfoMapper.selectCustInfoanddemand(map);
	}
    public List<Map<String,Object>> selectresumecount(String customercode){
		return customerInfoMapper.selectresumecount(customercode);
	}

    public Map<String,Object> getcoutomerinfodetail(String customercode){
    	List<Map<String,Object>> list= customerInfoMapper.demandResumeOfDemand(customercode);
    	if(list!=null && list.size()>0){
    		return list.get(0);
    	}
    	return null;
	}
    public List<CustomerInfo> selectbyOprecode(Map<String,Object> map){
    	return customerInfoMapper.selectbyOprecode(map);
    }
    public List<CustomerInfo> queryCustomerDetails(Map<String, Object> params){
		return customerInfoMapper.queryCustomerDetails(params);
    }
    public List<Map<String, Object>> notClosedDemands(Map<String, Object> params){
		return customerDemandMapper.notClosedDemands(params);
	}
	public int notClosedDemandsCount(Map<String, Object> params){
		return customerDemandMapper.notClosedDemandsCount(params);
	}
    
    public int queryDetailsCount(Map<String, Object> params){
    	return customerInfoMapper.queryDetailsCount(params);
    }
    
    public int queryDetailsCountByTel(String tel){
    	return customerInfoMapper.queryDetailsCountByTel(tel);
    }
    
    public int getSameCustomerCount(Map<String, Object> params){
    	return customerInfoMapper.getSameCustomerCount(params);
    }
    
    public int checkAccountsIsUse(String accountId){
    	return customerInfoMapper.checkAccountsIsUse(accountId);
    }
    public List<CustomerInfo> selectCuName(){
    	return customerInfoMapper.selectCuName();
    }
    public List<CustomerInfo> seltCusOfTask(Map<String, Object> map){
    	return customerInfoMapper.seltCusOfTask(map);
    }
    public List<CustomerInfo> seltCusOfDemand (Map<String, Object> map){
    	return customerInfoMapper.seltCusOfDemand(map);
    }
    public int notClosedDemandsCount(String opertcode){
    	return customerInfoMapper.notClosedDemandsCount(opertcode);
    };
    public List<Map<String,Object>> itemSearch(Map<String,Object> name){
  		return customerInfoMapper.itemSearch(name);
      }
    public Integer itemSearchCount(Map<String,Object> opertname){
		return customerInfoMapper.itemSearchCount(opertname);
    }
    public List<Map<String,Object>> getItemList(){
    	return customerInfoMapper.getItemList();
    }
    public Integer getitemsById(Map<String,Object> opertname){
  		return customerInfoMapper.getitemsById(opertname);
      }
    public List<Map<String,Object>> getAllcustomerinfo(){
    	return customerInfoMapper.getAllcustomerinfo();
    }
    public List<Map<String,Object>> getdayranking(){
    	return customerInfoMapper.getdayranking();
    }
    public List<Map<String,Object>> getweekranking(){
    	return customerInfoMapper.getweekranking();
    }
    
    
    public List<Map<String,Object>> selectbindresumebydemand(Map<String,Object> map){
    	return customerInfoMapper.selectbindresumebydemand(map);
    }
    public Integer selectbindresumebydemandCount(Map<String,Object> map){
    	return customerInfoMapper.selectbindresumebydemandCount(map);
    }
    public List<Map<String,Object>> selectnobindresumebydemand(Map<String,Object> map){
    	return customerInfoMapper.selectnobindresumebydemand(map);
    }
    public Integer selectnobindresumebydemandCount(Map<String,Object> map){
    	return customerInfoMapper.selectnobindresumebydemandCount(map);
    }
    
    //查询用户跟踪的且非录入的简历
    public List<CustomerInfo> selectfollowresumeByOper(Map<String,Object> map){
    	return customerInfoMapper.selectfollowresumeByOper(map);
    }
    
   
}




