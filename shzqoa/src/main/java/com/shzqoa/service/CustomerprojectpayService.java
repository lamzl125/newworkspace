package com.shzqoa.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.shzqoa.dao.CustomerprojectpayMapper;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.util.DateUtils;

@Service
public class CustomerprojectpayService {

	@Resource
	private CustomerprojectpayMapper customerprojectpayMapper;
	
	public List<Map<String, Object>> queryOutCompany(Map<String, Object> params){
		if(params != null){
			return customerprojectpayMapper.queryOutCompany(params);
		}
		return null;
	}
	public int queryOutCompanyCount(Map<String, Object> params){
		if(params != null){
			return customerprojectpayMapper.queryOutCompanyCount(params);
		}
		return 0;
	}
	@Transactional
	public int save(Customerprojectpay c){
		int i=0;
		if(c != null){
			i = customerprojectpayMapper.save(c);
		}
		return i;
	}
	public List<Customerprojectpay> queryProjectAndPays(Map<String, Object> params){
		List<Customerprojectpay> list = null;
		if(params!=null){
			list = customerprojectpayMapper.queryProjectAndPays(params);
		}
		return list;
	}
	public List<Customerprojectpay> queryProjectAndPaysBycode(Map<String, Object> params){
		List<Customerprojectpay> list = null;
		if(params!=null){
			list = customerprojectpayMapper.queryProjectAndPaysBycode(params);
		}
		return list;
	}
	public List<Customerprojectpay> queryAllByParams(Map<String, Object> params){
		List<Customerprojectpay> list = null;
		if(params!=null){
			list = customerprojectpayMapper.queryAllByParams(params);
		}
		return list;
	}
	public int queryAllCount(Map<String, Object> params){
		int i = 0;
		if(params!=null){
			i = customerprojectpayMapper.queryAllCount(params);
		}
		return i;
	}
	public int deleteById(String id){
		int i = 0;
		if(StringUtils.isNotBlank(id)){
			i = customerprojectpayMapper.deleteById(id);
		}
		return i;
	}
	public Customerprojectpay queryById(String id){
		Customerprojectpay c = null;
		if(StringUtils.isNotBlank(id)){
			c = customerprojectpayMapper.queryById(id);
		}
		return c;
	}
	
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
	public int saveXm(String customerCode,String corpCode,String settledCompany,String corpProjectCode,
			@RequestParam(value = "startTime", defaultValue = "2222") String startTime,String endTime,String settledCycle,
			String salary,String servicePay,int page,int pageSize) throws ParseException {
		int i = 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("customerCode", customerCode);
		params.put("corpCode", corpCode);
		List<Customerprojectpay> list = customerprojectpayMapper.queryAllByParams(params);
		if(list != null && list.size()>0){
			Customerprojectpay cp = list.get(0);
			if(!StringUtils.isNotBlank(cp.getStatus())){
				//update
				customerprojectpayMapper.deleteById(cp.getId());
			}else{
				//add
				UUID uuid = UUID.randomUUID();
				cp.setId(uuid.toString());
			}
			if(StringUtils.isNotBlank(settledCompany)){
				cp.setSettledCompany(settledCompany);
			}else{
				cp.setSettledCompany("");
			}
			if(StringUtils.isNotBlank(corpProjectCode)){
				cp.setCorpProjectCode(corpProjectCode);
			}else{
				cp.setCorpProjectCode("");
			}
			if(StringUtils.isNotBlank(startTime)){
				cp.setStartTime(DateUtils.formatY_M_D2Date(startTime, DateUtils.FORMAT_Y_M_D));
			}else{
				cp.setStartTime(null);
			}
			if(StringUtils.isNotBlank(endTime)){
				cp.setEndTime(DateUtils.formatY_M_D2Date(endTime, DateUtils.FORMAT_Y_M_D));
			}else{
				cp.setEndTime(null);
			}
			if(StringUtils.isNotBlank(settledCycle)){
				cp.setSettledCycle(Integer.parseInt(settledCycle));
			}else{
				cp.setSettledCycle(null);
			}
			if(StringUtils.isNotBlank(salary)){
				cp.setSalary(Double.parseDouble(salary));
			}else{
				cp.setSalary(null);
			}
			if(StringUtils.isNotBlank(servicePay)){
				cp.setServicePay(Double.parseDouble(servicePay));
			}else{
				cp.setServicePay(null);
			}
			cp.setStatus("0");
			i = customerprojectpayMapper.save(cp);
		}
		return i;
	}
	
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateCustomerprojectpay(String id,String settledCompany,String corpProjectCode,String startTime,
								String endTime,String settledCycle,String salary,String servicePay) throws ParseException{
		Customerprojectpay c = customerprojectpayMapper.queryById(id);
		customerprojectpayMapper.deleteById(id);
		if(StringUtils.isNotBlank(settledCompany)){
			c.setSettledCompany(settledCompany);
		}
		if(StringUtils.isNotBlank(corpProjectCode)){
			c.setCorpProjectCode(corpProjectCode);
		}
		if(StringUtils.isNotBlank(startTime)){
			c.setStartTime(DateUtils.formatY_M_D2Date(startTime, DateUtils.FORMAT_Y_M_D));
		}
		if(StringUtils.isNotBlank(endTime)){
			c.setEndTime(DateUtils.formatY_M_D2Date(endTime, DateUtils.FORMAT_Y_M_D));
		}
		if(StringUtils.isNotBlank(settledCycle)){
			c.setSettledCycle(Integer.parseInt(settledCycle));
		}
		if(StringUtils.isNotBlank(salary)){
			c.setSalary(Double.parseDouble(salary));
		}
		if(StringUtils.isNotBlank(servicePay)){
			c.setServicePay(Double.parseDouble(servicePay));
		}
		c.setStatus("0");
		return customerprojectpayMapper.save(c);
	}
	
	
	//查询付费信息
	public List<Customerprojectpay> queryAllPay(Map<String, Object> params){
		List<Customerprojectpay> list = null;
		if(params!=null){
			list = customerprojectpayMapper.queryAllPay(params);
		}
		return list;
	}
	
	public int queryAllPayCount(Map<String, Object> params){
		int i = 0;
		if(params!=null){
			i = customerprojectpayMapper.queryAllPayCount(params);
		}
		return i;
	}
	
	public List<Date> queryAllMonth(Date startdate,Date endDate){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startdate", startdate);
		map.put("endDate", endDate);
		return customerprojectpayMapper.queryAllMonth(map);
	}
	
}
