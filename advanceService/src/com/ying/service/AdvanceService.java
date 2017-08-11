package com.ying.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;

import com.ying.app.bean.AddressListBean;
import com.ying.app.bean.ApplyInfoBean;
import com.ying.app.bean.ApplyYearBean;
import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.CycleBean;
import com.ying.app.bean.MessageBean;
import com.ying.app.bean.MoneyListBean;
import com.ying.app.bean.OrderDealInfo;
import com.ying.app.bean.OrderListBean;
import com.ying.app.bean.PSOrderList;
import com.ying.app.req.AddAddressReq;
import com.ying.app.req.ApplyMoneyReq;
import com.ying.app.req.FeedbackOptionReq;
import com.ying.app.req.GetOrderDetailReq;
import com.ying.app.req.GetapplyMoneyReq;
import com.ying.app.req.MerchantWithDrawReq;
import com.ying.app.req.OrderListReq;
import com.ying.app.req.SearchOrderInfoReq;
import com.ying.app.req.UserInfoDeatilReq;
import com.ying.app.res.ConfirmTheDeliveryInfoRes;
import com.ying.app.res.DeliverInfoRes;
import com.ying.app.res.DeliveryDetailRes;
import com.ying.app.res.GetBoundageRes;
import com.ying.app.res.GetHangyeTypeRes;
import com.ying.app.res.GetQuotaTypeRes;
import com.ying.dao.IadvanceDao;

@Service
@Transactional
public class AdvanceService implements IadvanceService {
	@Autowired
	private IadvanceDao dao;

	// 1.0 轮播图
	@Override
	public List<CycleBean> reCycleList() {
		return dao.reCycleList();
	}

	// 1.2我的账户金额
	@Override
	public String getWalletMoney(String uid) {
		return dao.getWalletMoney(uid);
	}

	// 1.2.1 用户所需要支付的手续费
	@Override
	public String getText(String uid) {
		return dao.getText(uid);
	}

	// 1.3 添加/编辑发货/收货地址
	@Override
	public boolean addAddress(AddAddressReq req) {
		return dao.addAddress(req);
	}

	// 1.5 删除地址
	@Override
	public boolean handleAdress(String receiverid) {
		return dao.handleAdress(receiverid);
	}

	// 1.6 绑定服务码
	@Override
	public boolean servicecode(String serviceCode, String uid) {
		return dao.servicecode(serviceCode, uid);
	}

	// 1.8保存个人信息
	@Override
	public boolean commitUserInfoDeatil(UserInfoDeatilReq req) {
		return dao.commitUserInfoDeatil(req);
	}

	// 补：保存用户头像
	@Override
	public boolean saveUserPhoto(String uid, String usericon) {
		return dao.saveUserPhoto(uid, usericon);
	}

	// 1.9 我的发货地址列表
	@Override
	public List<AddressListBean> getSendAdressListInfo(String uid) {
		return dao.getSendAdressListInfo(uid);
	}

	// 2.1 意见反馈
	@Override
	public boolean feedbackOption(FeedbackOptionReq req) {
		return dao.feedbackOption(req);
	}

	// 2.0 关于我们
	@Override
	public String aboutUs(String type) {
		return dao.aboutUs(type);
	}

	// 2.2 客服电话
	@Override
	public String merchantService() {
		return dao.merchantService();
	}

	// 1.获取手续费接口
	@Override
	public String getPoundageMoney(String proviceCode, String advances) {
		return dao.getPoundageMoney(proviceCode, advances);
	}

	// 2.获取物流公司
	@Override
	public List<CompanyBean> getLogisticsCompany(String areaCode) {
		return dao.getLogisticsCompany(areaCode);
	}

	// 1.获取手续费接口
	@Override
	public GetBoundageRes getBoundage() {
		return dao.getBoundage();
	}

	// 1.1 确认发货
	@Override
	public String confirmTheDeliveryInfo(GetOrderDetailReq req) {
		return dao.confirmTheDeliveryInfo(req);
	}

	// 2.2 确认发货订单的详情页
	@Override
	public DeliveryDetailRes confirmTheDeliveryDetail(String orderId) {
		return dao.confirmTheDeliveryDetail(orderId);
	}

	// 4.0申请额度
	@Override
	public boolean applyMoney(ApplyMoneyReq req) {
		return dao.applyMoney(req);
	}

	// 4.1.0 获取用户申请资料
	@Override
	public ApplyInfoBean getapplyMoney(String uid) {
		return dao.getapplyMoney(uid);
	}

	// 4.5 消息列表
	@Override
	public Page<MessageBean> getMessageList(Page<MessageBean> page,
			List<PropertyFilter> filters, String uid) {
		return dao.getMessageList(page, filters, uid);
	}

	// 4.3收支明细
	@Override
	public Page<MoneyListBean> getWalletInfo(Page<MoneyListBean> page,
			List<PropertyFilter> filters, String uid) {
		return dao.getWalletInfo(page, filters, uid);
	}

	// 4.4 提现
	@Override
	public String merchantWithDraw(MerchantWithDrawReq req) {
		return dao.merchantWithDraw(req);
	}

	// 4.1.2 获取日期
	@Override
	public List<ApplyYearBean> myApplyData(String uid) {
		return dao.myApplyData(uid);
	}

	// 4.1.3 根据年份查询查询订单列表
	@Override
	public Page<OrderListBean> myApplyOrder(Page<OrderListBean> page,
			List<PropertyFilter> filters, GetapplyMoneyReq req) {
		return dao.myApplyOrder(page, filters, req);
	}

	// 3.0订单列表界面
	@Override
	public Page<PSOrderList> orderList(Page<PSOrderList> page,
			List<PropertyFilter> filters, OrderListReq req) {
		return dao.orderList(page, filters, req);
	}

	// 3.3订单查询
	@Override
	public Page<PSOrderList> searchOrderInfo(Page<PSOrderList> page,
			List<PropertyFilter> filters, SearchOrderInfoReq req) {
		return dao.searchOrderInfo(page, filters, req);
	}

	// 3.1详细的订单详情
	@Override
	public OrderDealInfo orderDetailInfo(String orderId) {
		return dao.orderDetailInfo(orderId);
	}

	// 3.2 配送信息
	@Override
	public DeliverInfoRes deliverInfo(String orderId) {
		return dao.deliverInfo(orderId);
	}

	// 5.获取用户行业类别
	@Override
	public GetHangyeTypeRes getHangyeType() {
		return dao.getHangyeType();
	}

	// 7.将用户的弹窗状态改为1不弹窗
	@Override
	public boolean getTanType(String uid) {
		return dao.getTanType(uid);
	}

}
