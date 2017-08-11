package com.shzqoa.model;

public class JianLiDetails {
	private String opertCode;//操作人员编号
	private Integer jlCount;//简历详情统计
	private Integer resumeSource;//简历来源
	public String getOpertCode() {
		return opertCode;
	}
	public void setOpertCode(String opertCode) {
		this.opertCode = opertCode;
	}
	public Integer getJlCount() {
		return jlCount;
	}
	public void setJlCount(Integer jlCount) {
		this.jlCount = jlCount;
	}
	public Integer getResumeSource() {
		return resumeSource;
	}
	public void setResumeSource(Integer resumeSource) {
		this.resumeSource = resumeSource;
	}
	
}
