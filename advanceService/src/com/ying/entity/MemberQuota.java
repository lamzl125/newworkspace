package com.ying.entity;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class MemberQuota {
	private String uid;   //用户id
	private String status;   //状态  0待审核    1审核通过  2审核失败 
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
