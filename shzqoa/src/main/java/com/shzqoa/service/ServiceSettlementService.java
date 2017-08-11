package com.shzqoa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.CustomerCompanyMapper;
import com.shzqoa.dao.ServiceSettlementMapper;
import com.shzqoa.model.CustomerCompany;
import com.shzqoa.model.ServiceSettlement;

@Service
public class ServiceSettlementService {
	@Resource
	ServiceSettlementMapper serviceSettlementMapper;//注入Dao层
	@Resource
	CustomerCompanyMapper customerCompanyMapper;
	/**
	 * 服务费用结算统计
	 * @param map
	 * @return
	 */
	public List<ServiceSettlement> selectCost(Map<String, Object> map){
		return serviceSettlementMapper.selectCost(map);
	}
	/**
	 * 服务费用结算统计数据总数目
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map){
		return serviceSettlementMapper.getCount(map);
	}
	/**
	 * 添加结算审核信息
	 * @param ctcy
	 * @return
	 */
	public int addCustomercompany(CustomerCompany ctcy){
		return customerCompanyMapper.insertCustomerCompany(ctcy);
	}
}
