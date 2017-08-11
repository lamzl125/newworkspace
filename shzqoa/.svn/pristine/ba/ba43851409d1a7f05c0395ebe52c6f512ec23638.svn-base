package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustomerInfoKq;
/**
 * 添加人员考勤信息接口
 * @author ThinkPad
 *
 */
public interface CustomerInfoKqMapper {
	/**
	 * 添加人员考勤信息
	 * @param customerInfoKq
	 * @return
	 */
	Integer insertCustomerInfoKq(CustomerInfoKq customerInfoKq);
	/**
	 * 显示人员考勤信息
	 * @param map
	 * @return
	 */
	List<CustomerInfoKq> selectCustomerInfoKq(Map<String, Object> map);
	/**
	 * 统计人员考勤信息总数-分页
	 * @param map
	 * @return
	 */
	Integer getCount(Map<String, Object> map);
	/**
	 * 修改考勤信息状态(0 错误，1 正确，2 未对比)
	 * @param customerInfoKq
	 * @return
	 */
	Integer updateCustomerInfoKq(CustomerInfoKq customerInfoKq);
	/**
	 * 根据考勤编号查询对应的人员信息
	 * @param id
	 * @return
	 */
	CustomerInfoKq selectCustomerInfoKqById(String id);
	/**
	 * 显示人员考勤信息出现差异的数据
	 * @param map
	 * @return
	 */
	List<CustomerInfoKq> selectCustomerInfoKqIsNot(Map<String, Object> map);
	/**
	 * 统计所有错误的考勤信息-分页
	 * @param map
	 * @return
	 */
	Integer getCountWrong(Map<String, Object> map);
	
	public List<CustomerInfoKq> selectCustomerInfoKqByMap(Map<String, Object> map);
	
	public Integer getCountByMap(Map<String, Object> map);
	
}
