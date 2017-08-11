package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.ServiceSettlement;

/*
 * 服务费用结算对应的接口
 */
public interface ServiceSettlementMapper {
	/*
	 * 服务费用统计
	 */
	List<ServiceSettlement> selectCost(Map<String,Object> map);
	
	/*
	 * 统计数据数目
	 */
	Integer getCount(Map<String,Object> map);
}
