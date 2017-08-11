package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.CustomerInfoKqMapper;
import com.shzqoa.model.CustomerInfoKq;
/**
 * 添加人员考勤信息业务层
 * @author ThinkPad
 *
 */
@Service
public class CustomerInfoKqService {
	@Resource
	CustomerInfoKqMapper customerInfoKqMapper;//注入dao层
	/**
	 * 添加人员考勤信息
	 * @param customerInfoKq
	 * @return
	 */
	public Integer insertCustomerInfoKq(CustomerInfoKq customerInfoKq){
		return customerInfoKqMapper.insertCustomerInfoKq(customerInfoKq);
	}
	/**
	 * 显示人员考勤信息
	 * @param map
	 * @return
	 */
	public List<CustomerInfoKq> selectCustomerInfoKq(Map<String, Object> map){
		return customerInfoKqMapper.selectCustomerInfoKq(map);
	}
	/**
	 * 统计人员考勤信息总数-分页
	 * @param map
	 * @return
	 */
	public Integer getCount(Map<String, Object> map){
		return customerInfoKqMapper.getCount(map);
	}
	/**
	 * 修改考勤信息状态(0 错误，1 正确，2 未对比)
	 * @param customerInfoKq
	 * @return
	 */
	public Integer updateCustomerInfoKq(CustomerInfoKq customerInfoKq){
		return customerInfoKqMapper.updateCustomerInfoKq(customerInfoKq);
	}
	/**
	 * 根据考勤编号查询对应的人员信息
	 * @param id
	 * @return
	 */
	public CustomerInfoKq selectCustomerInfoKqById(String id){
		return customerInfoKqMapper.selectCustomerInfoKqById(id);
	}
	/**
	 * 显示人员考勤信息出现差异的数据
	 * @param map
	 * @return
	 */
	public List<CustomerInfoKq> selectCustomerInfoKqIsNot(Map<String, Object> map){
		return customerInfoKqMapper.selectCustomerInfoKqIsNot(map);
	}
	/**
	 * 统计所有错误的考勤信息-分页
	 * @param map
	 * @return
	 */
	public Integer getCountWrong(Map<String, Object> map){
		return customerInfoKqMapper.getCountWrong(map);
	}
	
	
	public List<CustomerInfoKq> selectCustomerInfoKqByMap(Map<String, Object> map){
		return customerInfoKqMapper.selectCustomerInfoKqByMap(map);
	}
	public Integer getCountByMap(Map<String, Object> map){
		return customerInfoKqMapper.getCountByMap(map);
	}
}
