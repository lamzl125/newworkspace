package com.ying.service;
import java.util.List;

import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import com.ying.app.bean.CustomerListBean;
import com.ying.app.bean.MessageBean;
import com.ying.app.bean.PSOrder;
import com.ying.app.bean.PSOrderList;
import com.ying.app.bean.PSOrderListBean;
import com.ying.app.bean.User;
import com.ying.app.bean.UserInfo;
import com.ying.app.req.ConfiFinishReq;
import com.ying.app.req.PseditUserInfoDeatilReq;
import com.ying.app.req.PsforgetPasswordReq;
import com.ying.app.req.PsorderDetailReq;
import com.ying.app.req.PsrecordListReq;
import com.ying.app.req.PsuerLoginReq;
import com.ying.app.res.PsuserRecordRes;
import com.ying.entity.Order;



	public interface IUserService {
		
		
	// 根据mobile 查询 
	public User queryByMobielOrEmail(String str);
	
	
	// 根据 用户id 查询
	public User queryByUserId(String str);
	
	
	//1.0 商家端用户注册(包含身份证及资质证明) 
	public void saveSubmitInfo(PsuerLoginReq req);
	
	
	public boolean updatephone(PsforgetPasswordReq req);
	
	
	public boolean updateinfo(PseditUserInfoDeatilReq req);
	
	
	public boolean saveUserIcon(String uid,String icon);
	
	
	public boolean updatepassword(String phone,String password);
	
	
	public Page<PSOrderListBean> psorderList(Page<PSOrderListBean> page,List<PropertyFilter> filters,String logistics,String type,String logName);
	
	
	public Page<PSOrder> psrecordList(Page<PSOrder> page,List<PropertyFilter> filters,Long uid,String type);
	
	
	public List<PSOrderListBean> psorderListinfo(String date,PsrecordListReq req);
	
	
	//3.5 派件
	public boolean paiOrder(String orderId,String uid);
	
	
	//2.0删除订单
	public boolean psdeleteOrderId(String orderId);
	
	
	//1.1.0 获取个人记录
	public PsuserRecordRes psuserRecord(String uid);
	
	
	//3.1 我的客户
	public Page<CustomerListBean> pscustomerList(Page<CustomerListBean> page,List<PropertyFilter> filters,String uid);


	//2.1订单详情-揽件
	public boolean psorderDetailInfoRevive(PsorderDetailReq req);
	
	
	//2.2订单详情-确认完成和退款
	public boolean psorderDetailInfoConfiFinish(ConfiFinishReq req);
	
	
	//根据订单号查询订单数据
	public Order getOrder(String orderId);
	
	
	
	
}
