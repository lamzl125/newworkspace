package com.ying.entity;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class Tlogistics {
	private String id;   //物流公司表id
	private String log_name;   //物流名称
	private String balance;   //物流公司保证金
	private Date adtime;       //添加时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	
}
