package com.ying.app.res;

import java.util.Date;

import com.ying.app.bean.UserInfo;


public class DeliverInfoRes extends Res{
	private String orderNumber;	//订单号
	private String adTime;			//下单时间
	private String distributionTime;	//配送时间
	private String endTime;			//送达时间
	private String songAddress;		//发货地址
	private String shouAddress;		//收货地址
	private String distributionName;	// 配送员姓名，正在配送时有此参数
	private String distributionIphone;	//配送员电话，正在配送时有此参数
	private String orderState;			//1待揽件 2待派件 3已完成 4已派件 5已退货 6已删除
	private String nationalPhone;			//1客服电话
	
	private Date adtime;//下单时间
	private Date dtime;//发货时间
	private Date rtime; //送达时间
	
	
	
	public String getNationalPhone() {
		return nationalPhone+"";
	}
	public void setNationalPhone(String nationalPhone) {
		this.nationalPhone = nationalPhone;
	}
	public String getOrderNumber() {
		return orderNumber+"";
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAdTime() {
		return adTime+"";
	}
	public void setAdTime(String adTime) {
		this.adTime = adTime;
	}
	public String getDistributionTime() {
		return distributionTime+"";
	}
	public void setDistributionTime(String distributionTime) {
		this.distributionTime = distributionTime;
	}
	public String getEndTime() {
		return endTime+"";
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSongAddress() {
		return songAddress+"";
	}
	public void setSongAddress(String songAddress) {
		this.songAddress = songAddress;
	}
	public String getShouAddress() {
		return shouAddress+"";
	}
	public void setShouAddress(String shouAddress) {
		this.shouAddress = shouAddress;
	}
	public String getDistributionName() {
		return distributionName+"";
	}
	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}
	public String getDistributionIphone() {
		return distributionIphone+"";
	}
	public void setDistributionIphone(String distributionIphone) {
		this.distributionIphone = distributionIphone;
	}
	public String getOrderState() {
		return orderState+"";
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	
	
	
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
	
	
}
