package com.ying.app.req;

public class FeedbackOptionReq extends Req{
	private String uid; //用户id
	private String contentTitle; //反馈标题
	private String content; //反馈内容
	private String type; // 类别  0:关于我们 1:用户端注册协议
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}
