package com.ying.entity;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class Member {
	private Long id;
	private String userIcon;   //头像url
	private String userName;   //用户昵称  默认没有的话 返回 空
	private String userAddress;   //用户地址
	private String balance;		//余额
	private String quota;		//信用额度
	private String quotaRemaining;		//可用额度
	private String phoneNum;	//账户
	private String password;   //用户密码
	private String thirdUid;	//三方ID
	private String recommendedCode;	//推荐码
	private String serviceCode;	//服务码
	private Date adtime;       //添加时间
	private Date servictime;       //服务吗更新时间
	private Integer statue;		//0:禁用  1:可用
	private String token;		//token
	private String tanType;		//0弹窗  1不弹窗
	private String status;   //状态  0待审核    1审核通过  2审核失败 
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTanType() {
		return tanType;
	}
	public void setTanType(String tanType) {
		this.tanType = tanType;
	}
	public String getQuota() {
		return quota;
	}
	public void setQuota(String quota) {
		this.quota = quota;
	}
	public String getQuotaRemaining() {
		return quotaRemaining;
	}
	public void setQuotaRemaining(String quotaRemaining) {
		this.quotaRemaining = quotaRemaining;
	}
	public Date getServictime() {
		return servictime;
	}
	public void setServictime(Date servictime) {
		this.servictime = servictime;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserIcon() {
		return userIcon;
	}
	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	
}
