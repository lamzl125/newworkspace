package com.ying.app.res;

import com.ying.app.bean.UserInfo;


public class MerchantWithDrawRes extends Res{
	private String money;
	private String merChatExpectDate;
	private String balance;
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMerChatExpectDate() {
		return merChatExpectDate;
	}
	public void setMerChatExpectDate(String merChatExpectDate) {
		this.merChatExpectDate = merChatExpectDate;
	}

	
}
