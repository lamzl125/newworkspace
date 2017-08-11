package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustDemand;
import com.shzqoa.model.CustomerDemand;


public interface CustomerDemandMapper {
	
	public List<Map<String, Object>> queryXQByParams(Map<String, Object> params);
		
	public int queryCountByParams(Map<String, Object> params);
	
	public int insertCustomerDemand(CustomerDemand cd);
	
	public int insertCustomerDemandTrack(Map<String, Object> map);
	
	
	public int updateCustomerDemand(CustomerDemand cd);
	
	public List<CustDemand> selectDemand(Map<String, Object> map);
	
	
	public List<Map<String,Object>> selectDemandTrack(Map<String, Object> map);
	
	public int selectDemandTrackCount(Map<String, Object> map);
	
	public int selectDemandCount(Map<String, Object> map);
	
	public List<CustDemand> selectAlldemand(Map<String, Object> map);
	
	public int selectAlldemandCount(Map<String, Object> map);
	public int selectCount(Map<String, Object> map);
	
	public int deleteById(String Id);
	
	public int deleteByCustomId(String customercode);
	
	public int closeDemand(String demandid);
	
	public int openDemand(String demandid);
	
	public List<Map<String, String>> queryCompanyDemand(Map<String, Object> params);
	
	public CustomerDemand selectById(String cdId);
	
	public List<Map<String, Object>> notClosedDemands(Map<String, Object> params);
	
	public int notClosedDemandsCount(Map<String, Object> params);
	
	public List<Map<String,Object>> getDemandDetail(String demandId);
	
	
	//列表页分页未关闭需求
	public List<CustDemand> selectOpenDemand(Map<String,Object> map);
	//列表页分页未关闭需求数量
	public int selectOpenDemandCount(Map<String, Object> map);
	//查询当前用户已经抢取/分配到的需求列表
	public List<CustDemand> selectSignDemandByUser(Map<String,Object> map);
	
	public List<Map<String,Object>> demandstatistics(Map<String,Object> map);
	
	public int demandstatisticsCount(Map<String,Object> map);
	
	
	public List<Map<String,Object>> demandresumelist(Map<String,Object> map);
	public int demandresumelistCount(Map<String,Object> map);
	
	
	public List<Map<String,Object>> followstatuslist(Map<String,Object> map);
	public int followstatuslistCount(Map<String,Object> map);
	
	
	public List<Map<String, Object>> addDemStat(Map<String, Object> params);
	public int addDemStatCount(Map<String, Object> params);
	
	//查询抢取的需求且绑定该简历的需求
	public List<Map<String,Object>> stlDemandByBindUser(Map<String, Object> map);
	
}
