package com.shzqoa.model;

import java.io.Serializable;
import java.util.Date;

public class Corporatepartners implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 5076479942469603135L;
	
	/** 外派公司名称  */
	private String corpName;
	/** 外派公司编号  */
	private String corpCode;
	/** 开始时间 */
	private Date startTime;
	/** 结束时间 */
	private Date endTime;
	
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getCorpCode() {
		return corpCode;
	}
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
