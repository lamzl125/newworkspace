package com.ying.app.req;

public class SaveUserPhotoReq extends Req{
	private String uid; //用户id
	private String imgUrl; //头像图片
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
