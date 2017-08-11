package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class MessageBean {
	private String messageId;   //消息id
	private String messageTitle;   //消息标题
	private String messageTime;   //消息时间
	private Date adtime;   //消息时间
	private String messageContent;   //消息内容
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}

	
}
