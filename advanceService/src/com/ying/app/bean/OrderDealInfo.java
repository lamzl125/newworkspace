package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class OrderDealInfo {
	private String orderNumber;   //订单单号
	private String distributionState;   //1待揽件 2待派件 3已完成 4已派件 5已退货 6已删除
	private String senderName;   //发货人姓名
	private String senderPhone;  //发货人电话
	private String senderAddress;   //发货人地址
	private String senderPostcode; //发货人邮编
	private String reciverName; //收货人电话
	private String reciverPhone; //收货人姓名
	private String reciverAddress; //收货人地址
	private String reciverPostCode; //收货人邮编
	private String goods; //货物名称
	private String volume; //体积平方米
	private String weight; //重量20kg
	private String payGoods; //货款
	private String logisticsCollecting; //1.代收 0：不代收
	private String advances; //1物流垫付 0：不垫付
	private String logisticsCompanyName; //物流名字
	private String hisPay; //1.自付 2.到付
	private String payTime;//下单时间
	private String deliverTime;//发货时间
	private String reciveTime; //送达时间
	private String logisticsOrder; //物流单号
	private String payInsteadReceiving; //代收货款
	private String payLogistics; //物流费用 
	private String paymentAmount; //垫付金额
	private String poundage; //手续费
	private String yuMoney; //余款
	private String tuiMoney; //退款
	
	
	private Date adtime;//下单时间
	private Date dtime;//发货时间
	private Date rtime; //送达时间
	
	
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	public Date getDtime() {
		return dtime;
	}
	public void setDtime(Date dtime) {
		this.dtime = dtime;
	}
	public Date getRtime() {
		return rtime;
	}
	public void setRtime(Date rtime) {
		this.rtime = rtime;
	}
	public String getOrderNumber() {
		return orderNumber+"";
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getDistributionState() {
		return distributionState+"";
	}
	public void setDistributionState(String distributionState) {
		this.distributionState = distributionState;
	}
	public String getSenderName() {
		return senderName+"";
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderPhone() {
		return senderPhone+"";
	}
	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}
	public String getSenderAddress() {
		return senderAddress+"";
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	public String getSenderPostcode() {
		return senderPostcode+"";
	}
	public void setSenderPostcode(String senderPostcode) {
		this.senderPostcode = senderPostcode;
	}
	public String getGoods() {
		return goods+"";
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public String getVolume() {
		return volume+"";
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getWeight() {
		return weight+"";
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPayGoods() {
		return payGoods+"";
	}
	public void setPayGoods(String payGoods) {
		this.payGoods = payGoods;
	}
	public String getLogisticsCollecting() {
		return logisticsCollecting+"";
	}
	public void setLogisticsCollecting(String logisticsCollecting) {
		this.logisticsCollecting = logisticsCollecting;
	}
	public String getAdvances() {
		return advances+"";
	}
	public void setAdvances(String advances) {
		this.advances = advances;
	}
	public String getLogisticsCompanyName() {
		return logisticsCompanyName+"";
	}
	public void setLogisticsCompanyName(String logisticsCompanyName) {
		this.logisticsCompanyName = logisticsCompanyName;
	}
	public String getHisPay() {
		return hisPay+"";
	}
	public void setHisPay(String hisPay) {
		this.hisPay = hisPay;
	}
	public String getPayTime() {
		return payTime+"";
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getDeliverTime() {
		return deliverTime+"";
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getReciveTime() {
		return reciveTime+"";
	}
	public void setReciveTime(String reciveTime) {
		this.reciveTime = reciveTime;
	}
	public String getLogisticsOrder() {
		return logisticsOrder+"";
	}
	public void setLogisticsOrder(String logisticsOrder) {
		this.logisticsOrder = logisticsOrder;
	}
	public String getPayInsteadReceiving() {
		return payInsteadReceiving+"";
	}
	public void setPayInsteadReceiving(String payInsteadReceiving) {
		this.payInsteadReceiving = payInsteadReceiving;
	}
	public String getPayLogistics() {
		return payLogistics+"";
	}
	public void setPayLogistics(String payLogistics) {
		this.payLogistics = payLogistics;
	}
	public String getReciverName() {
		return reciverName+"";
	}
	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}
	public String getReciverPhone() {
		return reciverPhone+"";
	}
	public void setReciverPhone(String reciverPhone) {
		this.reciverPhone = reciverPhone;
	}
	public String getReciverAddress() {
		return reciverAddress+"";
	}
	public void setReciverAddress(String reciverAddress) {
		this.reciverAddress = reciverAddress;
	}
	public String getReciverPostCode() {
		return reciverPostCode+"";
	}
	public void setReciverPostCode(String reciverPostCode) {
		this.reciverPostCode = reciverPostCode;
	}
	public String getPaymentAmount() {
		return paymentAmount+"";
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPoundage() {
		return poundage+"";
	}
	public void setPoundage(String poundage) {
		this.poundage = poundage;
	}
	public String getYuMoney() {
		return yuMoney+"";
	}
	public void setYuMoney(String yuMoney) {
		this.yuMoney = yuMoney;
	}
	public String getTuiMoney() {
		return tuiMoney+"";
	}
	public void setTuiMoney(String tuiMoney) {
		this.tuiMoney = tuiMoney;
	}
	
	
	
	
}
