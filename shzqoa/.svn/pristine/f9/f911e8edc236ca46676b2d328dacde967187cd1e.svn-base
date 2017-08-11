package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.CustomerInfo;

public interface CustomerInfoMapper {
	CustomerInfo getCustomerinfoByCode(String customercode); 
	
	List<CustInfoAdd> selectCustInfo(Map<String, Object> map);
	
	Integer selectCustCount(Map<String, Object> map);
	
	Integer insertCustomerInfo(CustomerInfo customerinfo);
	
	Integer updateRelationshipByCode(Map<String,Object> map);
	/**根据员工查询客户信息列表 */
	List<CustomerInfo> selectCustInfoByOpertCode(Map<String, Object> map);
	/**根据员工查询客户信息列表 */
	List<CustomerInfo> selectCustInfoByOpertCode2(Map<String, Object> map);
	
	Integer selectCustCountByOpertCode2(Map<String, Object> map);
	/**根据员工查询客户个数**/
	Integer selectCustCountByOpertCode(Map<String, Object> map);
		
	List<CustomerInfo> getCustomerinfoByCon(Map<String, Object> map);
	
	Integer getCustomerinfoCountByCon(Map<String, Object> map);

	List<Map<String,Object>> performanceCount(Map<String,Object> map);// 绩效统计 
	Integer performanceCountNum(Map<String,Object> map);// 绩效统计
	
	List<Map<String,Object>> markSearch(Map<String,Object> opertname);// 绩效搜索
	
	Integer markSearchCount(Map<String,Object> opertname);// 绩效搜索
	
	void updateEvaluate(CustomerInfo customerInfo);//为客户添加评价（即修改客户表的信息）
	
	CustomerInfo selectByCustomercode(String customercode);//根据客户编号找到对应的客户信息
	
	public List<CustomerInfo> queryCustomerDetails(Map<String, Object> params);
	
	public int queryDetailsCount(Map<String, Object> params);
	
	public int queryDetailsCountByTel(String tel);
	
	public int getSameCustomerCount(Map<String, Object> params);
	
	public int checkAccountsIsUse(String accountId);
	
	public List<CustomerInfo> selectCuName();

	public List<CustomerInfo> seltCusOfTask(Map<String, Object> map);

	public List<CustomerInfo> seltCusOfDemand(Map<String, Object> map);
	
	public List<CustomerInfo> selectbyOprecode(Map<String, Object> map);
	
	public List<CustomerInfo> seltCusOftask(Map<String, Object> map);
	public List<Map<String, Object>> notClosedDemands(Map<String, Object> params);
	
	public int notClosedDemandsCount();
	public List<Map<String,Object>> demandResumeOfDemand(String customercode);
	public List<Map<String,Object>> getcoutomerinfodetail(String customercode);
	public int notClosedDemandsCount(String opertcode);

	List<Map<String, Object>> itemSearch(Map<String, Object> name);

	Integer itemSearchCount(Map<String,Object> opertname);

	List<Map<String, Object>> getItemList();

	Integer getitemsById(Map<String, Object> opertname);

	List<Map<String, Object>> getAllcustomerinfo();
	List<Map<String, Object>> getdayranking();
	List<Map<String, Object>> getweekranking();

	List<Map<String, Object>> selectresumeBycorpcode(Map<String, Object> map);

	List<Map<String, Object>> selectresumecount(String customercode);


	List<Map<String, Object>> selectCustInfoanddemand(Map<String, Object> map);
	
	Integer selectCustanddemandCount(Map<String, Object> map);

	
	List<Map<String, Object>> selectbindresumebydemand(Map<String, Object> map);
	
	public Integer selectbindresumebydemandCount(Map<String,Object> map);
	
	public List<Map<String,Object>> selectnobindresumebydemand(Map<String,Object> map);
	
	public Integer selectnobindresumebydemandCount(Map<String,Object> map);
	
	//查询用户跟踪的且非录入的简历
	public List<CustomerInfo> selectfollowresumeByOper(Map<String,Object> map);
	
	
	
	//简历统计-录入简历、有效简历、可面简历、面试简历、面试通过、入项
	public List<Map<String,Object>> resumestatistics(Map<String,Object> map);	
	public int resumestatisticscount(Map<String,Object> map);
	
	
	//简历来源统计
	public List<Map<String,Object>> ressoustat(Map<String,Object> map);
	public int ressoustatcount(Map<String,Object> map);
	
	
	//来源简历列表
	public List<Map<String,Object>> sourceresume(Map<String,Object> map);
	public int sourceresumecount(Map<String,Object> map);
	
	
	
	//简历列表-根据开始时间、结束时间、用户、简历来源获取
	public List<Map<String,Object>> resumelistByMap(Map<String,Object> map);
	//简历列表数量-根据开始时间、结束时间、用户、简历来源获取
	public int resumelistCountByMap(Map<String,Object> map);

}





