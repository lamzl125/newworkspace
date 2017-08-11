package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class ApplyMoneyInfo {
	private String credit;   //信用额度
	private String advances;   //垫付余额
	private String remaining;   //剩余额度	
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getAdvances() {
		return advances;
	}
	public void setAdvances(String advances) {
		this.advances = advances;
	}
	public String getRemaining() {
		return remaining;
	}
	public void setRemaining(String remaining) {
		this.remaining = remaining;
	}
	
	
}
