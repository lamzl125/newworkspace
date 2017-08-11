package com.ying.service;

import java.util.Date; 
import java.util.List;

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


public interface IadvanceService {
	
	//1.0 轮播图
	public List<CycleBean> reCycleList();
	
	
	//1.2我的账户金额
	public String getWalletMoney(String uid);
	
	
	//1.3 添加/编辑发货/收货地址
	public boolean addAddress(AddAddressReq req);
	
	
	//1.5 删除地址
	public boolean handleAdress(String receiverid);
	
	
	//1.6 绑定服务码
	public boolean servicecode(String serviceCode,String uid);
	
	
	//1.8保存个人信息
	public boolean commitUserInfoDeatil(UserInfoDeatilReq req);
	
	
	//补：保存用户头像
	public boolean saveUserPhoto(String uid,String usericon);
	
	
	//1.9 我的发货地址列表
	public List<AddressListBean> getSendAdressListInfo(String uid);
	
	
	//2.1 意见反馈
	public boolean feedbackOption(FeedbackOptionReq req);
	
	
	//2.0 关于我们
	public String aboutUs(String type);
	
	
	//2.2 客服电话
	public String merchantService();
	
	
	//1.获取手续费接口
	public String getPoundageMoney(String proviceCode,String advances);
	
	
	//2.获取物流公司
	public List<CompanyBean> getLogisticsCompany(String areaCode);
	
	
	//1.获取手续费接口
	public GetBoundageRes getBoundage();
	
	
	//1.1 确认发货
	public String confirmTheDeliveryInfo(GetOrderDetailReq req);
	
	
	//2.2 确认发货订单的详情页
	public DeliveryDetailRes confirmTheDeliveryDetail(String orderId);
	
	
	//4.0申请额度
	public boolean applyMoney(ApplyMoneyReq req);
	
	
	//4.1.0 获取用户申请资料
	public ApplyInfoBean getapplyMoney(String uid);
	
	
	//4.5 消息列表
	public Page<MessageBean> getMessageList(Page<MessageBean> page,List<PropertyFilter> filters,String uid);
	
	
	//4.3收支明细
	public Page<MoneyListBean> getWalletInfo(Page<MoneyListBean> page,List<PropertyFilter> filters,String uid);
	
	
	//4.4 提现
	public String merchantWithDraw(MerchantWithDrawReq req);
	
	
	//4.1.2 获取日期
	public List<ApplyYearBean> myApplyData(String uid);
	
	
	//4.1.3 根据年份查询查询订单列表
	public Page<OrderListBean> myApplyOrder(Page<OrderListBean> page,List<PropertyFilter> filters,GetapplyMoneyReq req);
	
	
	//3.0订单列表界面
	public Page<PSOrderList> orderList(Page<PSOrderList> page,List<PropertyFilter> filters,OrderListReq req);
	
	
	//3.3订单查询
	public Page<PSOrderList> searchOrderInfo(Page<PSOrderList> page,List<PropertyFilter> filters,SearchOrderInfoReq req);
	
	
	//3.1详细的订单详情
	public OrderDealInfo orderDetailInfo(String orderId);
	
	
	//3.2 配送信息
	public DeliverInfoRes deliverInfo(String orderId);
	
	
	//5.获取用户行业类别
	public GetHangyeTypeRes getHangyeType();
	
	
	//7.将用户的弹窗状态改为1不弹窗
	public boolean getTanType(String uid);

	//查询用户所需要支付的手续费
	public String getText(String uid);
}
