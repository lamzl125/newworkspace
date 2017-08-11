package com.ying.app.res;

import com.ying.app.bean.UserInfo;


public class GetQuotaTypeRes extends Res{
	private String quotaType;		//0审核通过  1其他
	private String quota;			//审批额度
	private String tanType;			//0弹窗  1不弹窗
	public String getQuotaType() {
		return quotaType+"";
	}
	public void setQuotaType(String quotaType) {
		this.quotaType = quotaType;
	}
	public String getQuota() {
		return quota+"";
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getTanType() {
		return tanType+"";
	}
	public void setTanType(String tanType) {
		this.tanType = tanType;
	}

	
}
