package com.ying.app.res;

import com.ying.app.bean.ApplyInfoBean;
import com.ying.app.bean.UserInfo;


public class GetapplyMoneyRes extends Res{
	private String status; //状态  0待审核    1审核通过  2审核失败 
	private ApplyInfoBean applyInfo;

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApplyInfoBean getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfoBean applyInfo) {
		this.applyInfo = applyInfo;
	}

	
	
}
