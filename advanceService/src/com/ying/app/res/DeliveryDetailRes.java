package com.ying.app.res;

import java.util.Date;

import com.ying.app.bean.UserInfo;


public class DeliveryDetailRes extends Res{
	private String uid; //用户id
	private String senderAddress; //发货人地址 
	private String senderName; //发货人名字
	private String senderTel; //发货人电话
	private String senderPostCode; //发货人邮编
	private String reciverAddress; //收货人地址 
	private String reciverName; //收货人名字
	private String reciverTel; //收货人电话
	private String reciverPostCode; //区编码
	private String goods; //货物名称
	private String volume; //体积平方米
	private String weight; //重量20kg
	private String payGoods; //货款
	private String paymentAmount; //垫付金额
	private String poundage; //手续费
	private String logisticsCollecting; //1.代收 0：不代收
	private String advances; //1物流垫付 0：不垫付
	private String logisticsCompanyName; //物流名字
	private String logisticsOrder; // 物流单号，此处可以选填，空就是用户没有填写
	private String hisPay; //1.自付 2.到付
	private String orderNumber; //订单号
	private String orderNum; //订单时间
	private String orderTime; //订单时间
	private Date adtime; //订单时间
	
	
	
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderTel() {
		return senderTel;
	}
	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}
	public String getSenderPostCode() {
		return senderPostCode;
	}
	public void setSenderPostCode(String senderPostCode) {
		this.senderPostCode = senderPostCode;
	}
	public String getReciverAddress() {
		return reciverAddress;
	}
	public void setReciverAddress(String reciverAddress) {
		this.reciverAddress = reciverAddress;
	}
	public String getReciverName() {
		return reciverName;
	}
	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}
	public String getReciverTel() {
		return reciverTel;
	}
	public void setReciverTel(String reciverTel) {
		this.reciverTel = reciverTel;
	}
	public String getReciverPostCode() {
		return reciverPostCode;
	}
	public void setReciverPostCode(String reciverPostCode) {
		this.reciverPostCode = reciverPostCode;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPayGoods() {
		return payGoods;
	}
	public void setPayGoods(String payGoods) {
		this.payGoods = payGoods;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPoundage() {
		return poundage;
	}
	public void setPoundage(String poundage) {
		this.poundage = poundage;
	}
	public String getLogisticsCollecting() {
		return logisticsCollecting;
	}
	public void setLogisticsCollecting(String logisticsCollecting) {
		this.logisticsCollecting = logisticsCollecting;
	}
	public String getAdvances() {
		return advances;
	}
	public void setAdvances(String advances) {
		this.advances = advances;
	}
	public String getLogisticsCompanyName() {
		return logisticsCompanyName;
	}
	public void setLogisticsCompanyName(String logisticsCompanyName) {
		this.logisticsCompanyName = logisticsCompanyName;
	}
	public String getLogisticsOrder() {
		return logisticsOrder;
	}
	public void setLogisticsOrder(String logisticsOrder) {
		this.logisticsOrder = logisticsOrder;
	}
	public String getHisPay() {
		return hisPay;
	}
	public void setHisPay(String hisPay) {
		this.hisPay = hisPay;
	}

	
	
}
