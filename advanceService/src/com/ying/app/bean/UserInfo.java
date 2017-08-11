package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class UserInfo {
	private Long uid;     //用户id
	private String userIcon;   //头像url
	private String userName;   //用户昵称  默认没有的话 返回 空
	private String userAddress;   //用户地址
	private String balance;
	private String phoneNum;	//账户
	private String password;   //用户密码
	private String thirdUid;	//三方ID
	private String recommendedCode;	//推荐码
	private String serviceCode;	//服务码
    private String reviveNum;//揽件记录
    private String sendNum;//派件记录
    private String finishNum;//完成记录
    private String chargebackNum; //退件记录 
	private Date adtime;       //添加时间
	private Integer statue;		//0:禁用  1:可用
	private String userTel;		//0:禁用  1:可用
	
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
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getThirdUid() {
		return thirdUid;
	}
	public void setThirdUid(String thirdUid) {
		this.thirdUid = thirdUid;
	}
	public String getRecommendedCode() {
		return recommendedCode;
	}
	public void setRecommendedCode(String recommendedCode) {
		this.recommendedCode = recommendedCode;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	public Integer getStatue() {
		return statue;
	}
	public void setStatue(Integer statue) {
		this.statue = statue;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
}
