package com.ying.app.bean;

import java.util.Date;

public class PSOrderListBean {
    private String orderNumber; //订单号
    private Date dateTime; //订单时间
    private Date deliverTime; //发货时间
    private String senderAddress; //发货人地址 
    private String senderName;//发货人名字
    private String senderTel; //发货人电话
    private String reciverAddress;//收货人地址 
    private String reciverName; //收货人名字
    private String reciverTel; //收货人电话
    private String logisticsCost;//物流费用
    private String collectionDelivery;
    private String orderState; //1待揽件 2待派件 3已完成 4已派件 5已退货 6已删除 
    
    
	public Date getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(Date deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
	public String getLogisticsCost() {
		return logisticsCost;
	}
	public void setLogisticsCost(String logisticsCost) {
		this.logisticsCost = logisticsCost;
	}
	public String getCollectionDelivery() {
		return collectionDelivery;
	}
	public void setCollectionDelivery(String collectionDelivery) {
		this.collectionDelivery = collectionDelivery;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
    
}
