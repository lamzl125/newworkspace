package com.shzqoa.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.support.logging.Log;
import com.shzqoa.dao.CustomerprojectpayMapper;
import com.shzqoa.dao.MonthServicePayMapper;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.MonthServicePay;
import com.shzqoa.util.SerialNumber;

@Service
public class MonthServicePayService {
	@Resource
	private MonthServicePayMapper monthServicePayMapper;
	@Resource
	private CustomerprojectpayMapper customerprojectpayMapper;
	

	/**
	 * 批量生成月服务费\查询服务费
	 * @param monthstr 需设为传入月份
	 * @return
	 */
	public int batchaddmonthservpay(int yearstr,int monthstr,String corpcode,String customercode,Integer page,Integer pageSize,String usercode){
		Map<String,Object> map = new HashMap<String,Object>();
		/*//查询某人某年某月在某公司的服务费用
		Calendar c = Calendar.getInstance();
		
		//某月的开始时间为上个月20号
		c.set(yearstr, monthstr, 20,0,0,0);
		c.add(Calendar.MONTH, -1);		
		Date minDate = c.getTime();
		
		
		//某月的第一天
		c.set(yearstr, monthstr,1,0,0,0);
		Date midDate = c.getTime();
		
		//某月的结束时间为这个月20号
		c.set(yearstr, monthstr,20,0,0,0);
		Date maxDate = c.getTime();
		
		
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		map.put("midDate", midDate);*/
		if(customercode!=null && !"".equals(customercode)){
			map.put("customerCode", customercode);
		}
		if(corpcode!=null && !"".equals(corpcode)){
			map.put("corpCode", corpcode);
		}
		if(page!=null && page>0 && pageSize!=null && pageSize>0){
			map.put("offset", (page-1)*pageSize);
			map.put("pageSize", pageSize);
		}
		Calendar c = Calendar.getInstance();
		//某月的开始时间为当月1号
		c.set(yearstr, monthstr-1, 1,0,0,0);
		Date minDate = c.getTime();
		
		c.set(yearstr, monthstr, 1,0,0,0);
		Date maxDate = c.getTime();
		map.put("minDate", minDate);
		map.put("maxDate", maxDate);
		
		
		//1.查询某人某年某月在某公司产品的服务费
		List<Customerprojectpay> paylist = customerprojectpayMapper.querymonthservpay(map);	
		
		
		//2.查询某人某年某月在某公司已经生成的服务费列表
		map.remove("offset");
		map.remove("pageSize");
		List<MonthServicePay> exitpaylist = monthServicePayMapper.queryMonthServicePay(map);
		
		//遍历是否存在没有生成的服务费
		List<MonthServicePay> addpaylist = new ArrayList<MonthServicePay>();
		Date curdate = new Date();
		int curyear = curdate.getYear()+1900;
		int curmonth = curdate.getMonth()+1;
		if(paylist!=null&&paylist.size()>0 && (exitpaylist==null || exitpaylist.size()==0)){
			//有服务费都没生成
			for(int i=0;i<paylist.size();i++){
				Customerprojectpay info = paylist.get(i);
				MonthServicePay pay  = new MonthServicePay();
				pay.setId(SerialNumber.createSerial("mspm", 4));
				pay.setCustomerProjectPayId(info.getId());
				pay.setMonthIndex(monthstr);				
				pay.setYearIndex(yearstr);
				pay.setPayStatus(1);//付款状态(1-未付款  2-已付款）
				pay.setServicePay(info.getServicePay());
				pay.setSubPay(0.0);
				pay.setRealPay(0.0);
				pay.setAddPeople(usercode);
				pay.setAddTime(new Date());
				
				if((curyear==yearstr && curmonth>monthstr)|| curyear>yearstr){
					addpaylist.add(pay);
				}
			}
		}else if(paylist!=null&&paylist.size()>0 && (exitpaylist!=null || exitpaylist.size()>0)){
			//部分服务费没生成，需遍历查询出没有生成的服务费
			for(int i=0;i<paylist.size();i++){//应有的服务费
				int coun = 0;
				Customerprojectpay info = paylist.get(i);
				for(int j=0;j<exitpaylist.size();j++){//已生成的服务费
					MonthServicePay pay  = exitpaylist.get(j);
					if(info.getId().equals(pay.getCustomerProjectPayId())&&pay.getMonthIndex()==monthstr && pay.getYearIndex()==yearstr){
						coun++;
					}
				}
				if(coun==0){
					MonthServicePay pay  = new MonthServicePay();
					pay.setId(SerialNumber.createSerial("mspm", 4));
					pay.setCustomerProjectPayId(info.getId());
					pay.setMonthIndex(monthstr);				
					pay.setYearIndex(yearstr);
					pay.setPayStatus(1);//付款状态(1-未付款  2-已付款）
					pay.setServicePay(info.getServicePay());
					pay.setSubPay(0.0);
					pay.setRealPay(0.0);
					pay.setAddPeople(usercode);
					pay.setAddTime(new Date());
					if((curyear==yearstr && curmonth>monthstr)|| curyear>yearstr){
						addpaylist.add(pay);
					}
				}
			}
		}
		if(addpaylist!=null && addpaylist.size()>0){
			return monthServicePayMapper.batchaddmonthservpay(addpaylist);
		}else{
			return 0;
		}
	}
	
	public Integer updatemonthservicepay(MonthServicePay ServicePay){
		return monthServicePayMapper.updatemonthservicepay(ServicePay);
    }
	public List<MonthServicePay> queryPayByProjectPayId(Map<String,Object> map){
		return monthServicePayMapper.queryPayByProjectPayId(map);
	}
	public List<Map<String,Object>> queryMapMonthServicePay(Map<String,Object> map){
		return monthServicePayMapper.queryMapMonthServicePay(map);
	}
	
	public int queryMapMonthServicePayCount(Map<String,Object> map){
		return monthServicePayMapper.queryMapMonthServicePayCount(map);
	}
	
	public List<Map<String,Object>> querySumMonthServicePay(Map<String,Object> map){
		return monthServicePayMapper.querySumMonthServicePay(map);
	}
	public int querySumMonthServicePayCount(Map<String,Object> map){
		return monthServicePayMapper.querySumMonthServicePayCount(map);
	}
	
}
