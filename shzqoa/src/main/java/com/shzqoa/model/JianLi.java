package com.shzqoa.model;

import java.util.Date;

public class JianLi {
	private Integer resumesource;//简历来源
	private Integer count;//本周简历统计数
	private Integer sum1;//成功人数
	private Integer sum2;//入职率超过50%的统计人数
	private Date resumeupdatedate;  //'简历更新时间',
	private String ocode;//操作人员编号
	private String account;//录入账号
	private Date starttime;//开始时间
	private Date endtime;//结束时间	
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public Integer getResumesource() {
		return resumesource;
	}
	public void setResumesource(Integer resumesource) {
		this.resumesource = resumesource;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getSum1() {
		return sum1;
	}
	public void setSum1(Integer sum1) {
		this.sum1 = sum1;
	}
	public Integer getSum2() {
		return sum2;
	}
	public void setSum2(Integer sum2) {
		this.sum2 = sum2;
	}
	public Date getResumeupdatedate() {
		return resumeupdatedate;
	}
	public void setResumeupdatedate(Date resumeupdatedate) {
		this.resumeupdatedate = resumeupdatedate;
	}
	
}
