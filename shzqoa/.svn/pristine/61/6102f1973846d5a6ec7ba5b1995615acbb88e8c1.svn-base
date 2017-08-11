package com.shzqoa.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.shzqoa.dao.CustomerDemandMapper;
import com.shzqoa.dao.CustomerInfoMapper;
import com.shzqoa.model.CustDemand;
import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.CustomerInfo;

@Service
public class CustomerDemandService {
	@Resource
	private CustomerDemandMapper customerDemandMapper;
	@Resource
	private CustomerInfoMapper customerInfoMapper;
	public List<Map<String, Object>> queryXQByParams(Map<String, Object> params){
		if(params != null){
			return customerDemandMapper.queryXQByParams(params);
		}
		return null;
	}
	
	public int queryCountByParams(Map<String, Object> params){
		if(params != null){
			return customerDemandMapper.queryCountByParams(params);
		}
		return 0;
	}
	
	public int insertCustomerDemand(CustomerDemand cd){
		return customerDemandMapper.insertCustomerDemand(cd);
	}
	public int insertCustomerDemandTrack(Map<String,Object> map){
		return customerDemandMapper.insertCustomerDemandTrack(map);
	}
	
	public int updateCustomerDemand(CustomerDemand cd){
		return customerDemandMapper.updateCustomerDemand(cd);
	}
	/**
	 * 列表页分页查询
	 * @param map
	 * @return
	 */
	public List<CustDemand> selectDemand(Map<String,Object> map) {
		return customerDemandMapper.selectDemand(map);
	}
	/**
	 * 列表页分页未关闭需求
	 * @param map
	 * @return
	 */
	public List<CustDemand> selectOpenDemand(Map<String,Object> map) {
		return customerDemandMapper.selectOpenDemand(map);
	}
	/**
	 * 列表页未关闭需求数量
	 * @param map
	 * @return
	 */
	public int selectOpenDemandCount(Map<String, Object> map){
		return customerDemandMapper.selectOpenDemandCount(map);
	}
	/**
	 * 列表页数量
	 * @param map
	 * @return
	 */
	public int selectDemandCount(Map<String, Object> map){
		return customerDemandMapper.selectDemandCount(map);
	}
	
	
	
	/*
	 * 查询跟踪信息
	 */
	public List<Map<String,Object>> selectDemandTrack(Map<String, Object> map){
		return customerDemandMapper.selectDemandTrack(map);
	}
	public int selectDemandTrackCount(Map<String, Object> map){
		return customerDemandMapper.selectDemandTrackCount(map);
	}
	/**
	 * 绑定页面查询
	 * @param map
	 * @return
	 */
	public List<CustDemand> selectAlldemand(Map<String,Object> map) {
		return customerDemandMapper.selectAlldemand(map);
	}
	/**
	 * 绑定页面数量
	 * @param map
	 * @return
	 */
	public int selectAlldemandCount(Map<String, Object> map){
		return customerDemandMapper.selectAlldemandCount(map);
	}
	public int selectCount(Map<String, Object> map){
		return customerDemandMapper.selectAlldemandCount(map);
	}
	public int deleteById(String Id){ 
		return customerDemandMapper.deleteById(Id);
	}
	public int deleteByCustomId(String customercode){
		return customerDemandMapper.deleteByCustomId(customercode);
	}
	public List<Map<String,Object>> custOfDemand(Map<String, Object> map){
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		List<CustDemand> demandList=selectAlldemand(map);
		for(CustDemand ad : demandList){
			Map<String,Object> paramap = new HashMap<String, Object>();
			paramap.put("demandId", ad.getId());
			List<CustomerInfo> custList = customerInfoMapper.seltCusOfDemand(paramap);
			Map<String,Object> rmap = new HashMap<String, Object>();
			rmap.put("custDemand",ad);
			rmap.put("custList", custList);
			mapList.add(rmap);
		}
		return mapList;	
	}
	/**
	 * 关闭需求
	 * @param demandid
	 * @return
	 */
	public int closeDemand(String demandid){
		return customerDemandMapper.closeDemand(demandid);
	}
	/**
	 * 恢复需求
	 * @param demandid
	 * @return
	 */
	public int openDemand(String demandid){
		return customerDemandMapper.openDemand(demandid);
	}
	
	public List<Map<String, String>> queryCompanyDemand(Map<String, Object> params){
		if(params!=null){
			return customerDemandMapper.queryCompanyDemand(params);
		}
		return null;
	}
	
	public CustomerDemand selectById(String cdId){
		return customerDemandMapper.selectById(cdId);
	}
	
	public List<Map<String, Object>> notClosedDemands(Map<String, Object> params){
		return customerDemandMapper.notClosedDemands(params);
	}
	public int notClosedDemandsCount(Map<String, Object> params){
		return customerDemandMapper.notClosedDemandsCount(params);
	}
	
	public Map<String, Object> getDemandDetail(String demandId){
		return customerDemandMapper.getDemandDetail(demandId).get(0);
	}
	
	/**
	 * 查询当前用户已经抢取/分配到的需求列表
	 * @param map
	 */
	public List<CustDemand> selectSignDemandByUser(Map<String,Object> map) {
		return customerDemandMapper.selectSignDemandByUser(map);
	}
	
	
	public List<Map<String,Object>> demandstatistics(Map<String,Object> map) {
		return customerDemandMapper.demandstatistics(map);
	}
	
	
	public int demandstatisticsCount(Map<String,Object> map){
		return customerDemandMapper.demandstatisticsCount(map);
	}
	
	
	public List<Map<String,Object>> demandresumelist(Map<String,Object> map) {
		return customerDemandMapper.demandresumelist(map);
	}
	
	
	public int demandresumelistCount(Map<String,Object> map){
		return customerDemandMapper.demandresumelistCount(map);
	}
	
	
	
	public List<Map<String,Object>> followstatuslist(Map<String,Object> map) {
		return customerDemandMapper.followstatuslist(map);
	}
	public int followstatuslistCount(Map<String,Object> map){
		return customerDemandMapper.followstatuslistCount(map);
	}
	
	
	
	public List<Map<String, Object>> addDemStat(Map<String, Object> params){
		return customerDemandMapper.addDemStat(params);
	}
	public int addDemStatCount(Map<String, Object> params){
		return customerDemandMapper.addDemStatCount(params);
	}
	
	
	
	//查询抢取的需求且绑定该简历的需求
	public List<Map<String,Object>> stlDemandByBindUser(Map<String, Object> map){
		return customerDemandMapper.stlDemandByBindUser(map);
	}
	
}
