package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class MoneyListBean {
	private String moneySoure;   //钱的来源：0提现、1垫付、2退货
	private String moneyNum;  //钱的金额
	private String moneyTime;   //消息时间
	private Date adtime;   //消息时间   辅助字段
	public String getMoneySoure() {
		return moneySoure;
	}
	public void setMoneySoure(String moneySoure) {
		this.moneySoure = moneySoure;
	}
	public String getMoneyNum() {
		return moneyNum;
	}
	public void setMoneyNum(String moneyNum) {
		this.moneyNum = moneyNum;
	}
	public String getMoneyTime() {
		return moneyTime;
	}
	public void setMoneyTime(String moneyTime) {
		this.moneyTime = moneyTime;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	
	
	
	
}
