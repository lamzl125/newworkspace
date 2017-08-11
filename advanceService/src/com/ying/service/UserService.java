package com.ying.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import com.ying.app.bean.CustomerListBean;
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
import com.ying.dao.IMemberDao;
import com.ying.dao.IUserDao;
import com.ying.entity.Order;
@Transactional
@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDao dao;
	// 根据mobile 查询 
	public User queryByMobielOrEmail(String str){
		return dao.queryByMobielOrEmail(str);
	}
	
	
	// 根据 用户id 查询
	public User queryByUserId(String str){
		return dao.queryByUserId(str);
	}

	
	@Override
	public void saveSubmitInfo(PsuerLoginReq req) {
		dao.saveSubmitInfo(req);
	}
	
	@Override
	public boolean updatephone(PsforgetPasswordReq req){
		return  dao.updatephone(req);
	}
	
	
	@Override
	public boolean updateinfo(PseditUserInfoDeatilReq req){
		return dao.updateinfo(req);
	}
	
	@Override
	public boolean saveUserIcon(String uid,String icon){
		return dao.saveUserIcon(uid, icon);
	}
	
	
	@Override
	public boolean updatepassword(String phone,String password){
		return dao.updatepassword(phone, password);
	}
	
	@Override
	public Page<PSOrderListBean> psorderList(Page<PSOrderListBean> page,List<PropertyFilter> filters,String logistics,String type,String logName){
		return dao.psorderList(page, filters, logistics,type,logName);
	}
	
	
	@Override
	public Page<PSOrder> psrecordList(Page<PSOrder> page,List<PropertyFilter> filters,Long uid,String type){
		return dao.psrecordList(page, filters, uid,type);
	}
	
	
	@Override
	public List<PSOrderListBean>psorderListinfo(String date,PsrecordListReq req){
		return dao.psorderListinfo(date, req);
	}
	
	
	//3.5 派件
	@Override
	public boolean paiOrder(String orderId,String uid) {
		return dao.paiOrder(orderId,uid);
	}
	
	
	//2.0删除订单
	@Override
	public boolean psdeleteOrderId(String orderId) {
		return dao.psdeleteOrderId(orderId);
	}
	
	
	//1.1.0 获取个人记录
	@Override
	public PsuserRecordRes psuserRecord(String uid) {
		return dao.psuserRecord(uid);
	}
	
	
	//3.1 我的客户
	@Override
	public Page<CustomerListBean> pscustomerList(Page<CustomerListBean> page,List<PropertyFilter> filters,String uid){
		return dao.pscustomerList(page, filters, uid);
	}
	
	
	//2.1订单详情-揽件
	@Override
	public boolean psorderDetailInfoRevive(PsorderDetailReq req) {
		return dao.psorderDetailInfoRevive(req);
	}
	
	
	//2.2订单详情-确认完成和退款
	@Override
	public boolean psorderDetailInfoConfiFinish(ConfiFinishReq req) {
		return dao.psorderDetailInfoConfiFinish(req);
	}
	
	
	//根据订单号查询订单数据
	@Override
	public Order getOrder(String orderId) {
		return dao.getOrder(orderId);
	}
	
	
}
