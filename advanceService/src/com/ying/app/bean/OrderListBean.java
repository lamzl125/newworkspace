package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class OrderListBean {
	private String orderNumer;   //订单号
	private Integer status;   //1待揽件 2待派件 3已完成 4退货中 5已退货 6已删除		辅助字段
	private Date adtime;  		//发货时间		辅助字段
	private Date refundtime;  	//送达时间		辅助字段
	private String money;  	//垫付金额			辅助字段
	private String balance;  	//剩余额度		辅助字段
	
	private String deliverName;		//送货    
	private String deliverMoney;	//垫付金额
	private String deliverBalance;	//垫付之后的额度
	private String deliverTime;		//发货时间
	
	private String receiptName;		//送达名称（发货失败/发货成功）	
	private String receiptMoney;	//垫付金额
	private String receiptBalance;	//送达之后垫付额度
	private String receiptTime;		//送达时间
	
	
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getOrderNumer() {
		return orderNumer;
	}
	public void setOrderNumer(String orderNumer) {
		this.orderNumer = orderNumer;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	public Date getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Date refundtime) {
		this.refundtime = refundtime;
	}
	public String getDeliverName() {
		return deliverName;
	}
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	public String getDeliverMoney() {
		return deliverMoney;
	}
	public void setDeliverMoney(String deliverMoney) {
		this.deliverMoney = deliverMoney;
	}
	public String getDeliverBalance() {
		return deliverBalance;
	}
	public void setDeliverBalance(String deliverBalance) {
		this.deliverBalance = deliverBalance;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getReceiptName() {
		return receiptName;
	}
	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}
	public String getReceiptMoney() {
		return receiptMoney;
	}
	public void setReceiptMoney(String receiptMoney) {
		this.receiptMoney = receiptMoney;
	}
	public String getReceiptBalance() {
		return receiptBalance;
	}
	public void setReceiptBalance(String receiptBalance) {
		this.receiptBalance = receiptBalance;
	}
	public String getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}
	
	
	
	
}
