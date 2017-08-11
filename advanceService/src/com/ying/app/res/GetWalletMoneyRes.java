package com.ying.app.res;

import com.ying.app.bean.UserInfo;

public class GetWalletMoneyRes extends Res {
	private String balance;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
