package com.shzqoa.model;

import java.util.Date;

public class DemandResumeRelation {
	private String id;   //'关系表id',
	private String customerdemandid;   //'客户需求id',
	private String customercode;   //'人员简历Id',
	private String Operationcode;  //'操作人ID',
	private Date operationtime;    //'操作时间',
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerdemandid() {
		return customerdemandid;
	}
	public void setCustomerdemandid(String customerdemandid) {
		this.customerdemandid = customerdemandid;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getOperationcode() {
		return Operationcode;
	}
	public void setOperationcode(String operationcode) {
		Operationcode = operationcode;
	}
	public Date getOperationtime() {
		return operationtime;
	}
	public void setOperationtime(Date operationtime) {
		this.operationtime = operationtime;
	}

}
