package com.shzqoa.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户公司实体类
 * createTime: 2015-05-27
 * @author zhanggh
 *
 */
public class CustomerCompany implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 主键id */
	private String id;
	/** 客户公司名称 */
	private String companyName;
	/** 所需支付费用 */
	private Double predictCost;
	/** 实际支付费用 */
	private Double realityCost;
	/** 备注说明 */
	private String explain;
	/** 凭证 */
	private String certificate;
	/** 审核人 */
	private String operator;
	/** 审核时间 */
	private Date checktime;
	/** 信息录入时间 */
	private Date creatime;
	/**费用结算时间*/
	private String balancemonth;
	/** 状态（0为为审核，1为已审核） */
	private Integer status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Double getPredictCost() {
		return predictCost;
	}
	public void setPredictCost(Double predictCost) {
		this.predictCost = predictCost;
	}
	public Double getRealityCost() {
		return realityCost;
	}
	public void setRealityCost(Double realityCost) {
		this.realityCost = realityCost;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBalancemonth() {
		return balancemonth;
	}
	public void setBalancemonth(String balancemonth) {
		this.balancemonth = balancemonth;
	}
}