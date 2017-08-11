/**
 * 
 */
package com.ying.app.req;

/** 
 * @ClassName: GetChargeReq 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author luwenjie 
 * @date 2016-1-14 上午9:32:20 
 * @version 1.0 
 */

public class GetChargeReq {
	
    private int amount;//int 类型，表示支付的金额，以分为单位。
    private String ordermoney;//余额支付传金额
    private String ordernum;//String 类型，表示订单号，由字母和数字组成8-20位。
    private String channel;//String 类型，表示支付渠道。	/wx:微信  alipay:支付宝  lq:零钱支付
    private String body;
    
    
	public String getOrdermoney() {
		return ordermoney;
	}
	public void setOrdermoney(String ordermoney) {
		this.ordermoney = ordermoney;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
    
    
    
	
}
