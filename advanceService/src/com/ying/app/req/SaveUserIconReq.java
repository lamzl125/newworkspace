package com.ying.app.req;

public class SaveUserIconReq extends Req {
    private String uid; //保存头像的用户ID
    private String imgUrl; //头像图片
    private String orderId; //订单id
    private String nowPage; //当前页
    
    
    
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
    
}
