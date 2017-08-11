package com.ying.app.req;

public class MerchantWithDrawReq extends Req{
	private String uid; //用户id
	private String type; // 0 支付宝 1 微信 2银行卡
	private String money; //提现金额
	private String account; //提取到的账户（支付宝 微信 银行卡卡号）
	private String realName; //开户人姓名（银行卡）
	private String bankName; //开户银行名称(银行卡)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	
	
	
}
