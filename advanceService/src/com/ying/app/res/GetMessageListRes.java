package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.MessageBean;
import com.ying.app.bean.UserInfo;


public class GetMessageListRes extends Res{
	private Long totalPage;			//总页数
	private List<MessageBean> messageList = new ArrayList<MessageBean>();
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public List<MessageBean> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<MessageBean> messageList) {
		this.messageList = messageList;
	}
	
	
}
