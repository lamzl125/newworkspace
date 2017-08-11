package com.ying.app.bean;

import org.utils.SysGlobals;

public class User {
    private Long uid;   //用户ID
    private String userName;   //用户昵称
    private String password;
    private String userIcon;   //用户头像
    private String phoneNum;  //手机号码
    private String reviveNum; //揽件记录
    private String sendNum;//派件记录
    private String finishNum; //完成记录
    private String chargebackNum; //退件记录 
    private String recommendNum; //推荐码 
    private String logistics;//物流
    private String logName;//物流站点名称
    
    
    public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	private int state;
    
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
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
	public String getRecommendNum() {
		return recommendNum;
	}
	public void setRecommendNum(String recommendNum) {
		this.recommendNum = recommendNum;
	}
    
}
