package com.ying.app.res;

import org.utils.SysGlobals;

import com.ying.app.bean.UserInfo;


public class PsuserRecordRes extends Res{
	private String reviveNum;		//揽件记录
	private String sendNum;			//派件记录
	private String finishNum;		//完成记录
	private String chargebackNum;	//退件记录 
	private String userName;	//用户昵称
	private String userIcon;	//用户头像
	public String getReviveNum() {
		return reviveNum;
	}
	public void setReviveNum(String reviveNum) {
		this.reviveNum = reviveNum;
	}
	public String getSendNum() {
		return sendNum;
	}
	public void setSendNum(String sendNum) {
		this.sendNum = sendNum;
	}
	public String getFinishNum() {
		return finishNum;
	}
	public void setFinishNum(String finishNum) {
		this.finishNum = finishNum;
	}
	public String getChargebackNum() {
		return chargebackNum;
	}
	public void setChargebackNum(String chargebackNum) {
		this.chargebackNum = chargebackNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserIcon() {
		if(userIcon!=null && userIcon!="" && userIcon.indexOf("http://")==-1 && !userIcon.equals("") && !userIcon.equals("null")){
			userIcon=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+userIcon;
		}else if(userIcon !=null && userIcon !="" && userIcon.indexOf("http://")!=-1){
			userIcon=userIcon;
		}
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}
	
	
	
}
