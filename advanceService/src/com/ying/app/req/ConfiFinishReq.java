package com.ying.app.req;

public class ConfiFinishReq extends Req{
	private String type; //0是确认完成   1是退款
	private String orderId; //订单ID
	private String orderNumber; //物流单号
	private String channel; //0.支付宝  1.微信 2.其他支付
	private String refundDes; //退货备注
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getRefundDes() {
		return refundDes;
	}
	public void setRefundDes(String refundDes) {
		this.refundDes = refundDes;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	
	
}
