package com.ying.alipay.util;

public class Alipay {

	//服务器异步通知页面路径
	private String notify_url;
	//需http://格式的完整路径，不能加?id=123这类自定义参数

	//页面跳转同步通知页面路径
	private String call_back_url;
	//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

	//操作中断返回地址
	private String merchant_url;
	//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数
	
	//卖家支付宝帐户
	private String seller_email;
	//必填
	
	// 合作身份者ID，即PID,以2088开头由16位纯数字组成的字符串
	public String partner;
	//必填
	
	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
	private String key;
	//必填
	
	//商户订单号
	private String out_trade_no;
	//商户网站订单系统中唯一订单号，必填

	//订单名称
	private String subject;
	//必填

	//付款金额
	private String total_fee;
	//必填

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getCall_back_url() {
		return call_back_url;
	}

	public void setCall_back_url(String call_back_url) {
		this.call_back_url = call_back_url;
	}

	public String getMerchant_url() {
		return merchant_url;
	}

	public void setMerchant_url(String merchant_url) {
		this.merchant_url = merchant_url;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

}
