package com.shzqoa.model;

import java.util.Date;

/**
 * 客户信息表
 * @author kaifa001
 *
 */
public class CustomerInfo {
	private String customercode;  //'客户编号',
	private String customername;  //'客户姓名',
	private Integer customersex;  //'客户性别（0-男，1-女）',
	private String customertel;  //'联系电话',
	private Date customerbirth;  //'出生日期',
	private String customeruniversity;  //'毕业院校',
	private String customerspecialities;  //'所学专业',
	private Date entrytime;  //'入职时间',
	private Integer resumesource;  //  '简历来源（1-51JOb，2-智联,3-其他）',
	private String resumeid;  //'简历ID',
	private Date resumeupdatedate;  //'简历更新时间',
	private String lastvcompanyname;  //'最近公司名称',
	private String technicalexpertise;  // '技术特长',
	private String lastprojectname;  //'最近项目名称',
	private Integer relationshipbyzq;  //'与梓钦关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系   6-入职）',
	private String memo;  //'说明',
	private Integer relationshipbyzh;  //'与郑州公司关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系  6-入职）',
	private Integer entryprobability;  //'入职概率',
	private String resumepath;  //'简历路径',
	private Date zqentrytime;  //'加入梓钦公司的时间'，
	private Date addtime;  //'添加时间',
	private String opertcode;  //'操作员编号',
	private String opertname;  //'操作员真实姓名',
	private String areaid;//'客户所在区域'
	private Date lastconttime; // '最后联系时间',
	private Integer lastupdatestatic; //'最终更新状态',
	private Integer comEvaluate;//沟通评价（沟通评价（1-60 一般、60-80 好，90-100 优秀））
	private Integer proEvaluate;//项目描述评价（1-60 一般、60-80 好，90-100 优秀）
	private Integer synEvaluate;//综合评价（1-60 一般、60-80 好，90-100 优秀）
	private String account;//录入账号
	private Integer expectationSalary; //期望薪资	
	private Date joinProjectTime;//入项时间
	private String professionId;//技术方向
	private Integer  considerChangeJob;//是否考虑换工作（1-考虑   2-不考虑 ）
	private String intentionArea;//意向地区
	
	private Long education;//学历
	private Long englishLevel;//英语水平
	private Long japaneseLevel;//日语水平
	private Double directWorkLife;//某方向工作年限
	
	
	
	public Integer getComEvaluate() {
		return comEvaluate;
	}
	public void setComEvaluate(Integer comEvaluate) {
		this.comEvaluate = comEvaluate;
	}
	public Integer getProEvaluate() {
		return proEvaluate;
	}
	public void setProEvaluate(Integer proEvaluate) {
		this.proEvaluate = proEvaluate;
	}
	public Integer getSynEvaluate() {
		return synEvaluate;
	}
	public void setSynEvaluate(Integer synEvaluate) {
		this.synEvaluate = synEvaluate;
	}
	public String getCustomercode() {
		return customercode;
	}
	public void setCustomercode(String customercode) {
		this.customercode = customercode;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Integer getCustomersex() {
		return customersex;
	}
	public void setCustomersex(Integer customersex) {
		this.customersex = customersex;
	}
	public String getCustomertel() {
		return customertel;
	}
	public void setCustomertel(String customertel) {
		this.customertel = customertel;
	}
	public Date getCustomerbirth() {
		return customerbirth;
	}
	public void setCustomerbirth(Date customerbirth) {
		this.customerbirth = customerbirth;
	}
	public String getCustomeruniversity() {
		return customeruniversity;
	}
	public void setCustomeruniversity(String customeruniversity) {
		this.customeruniversity = customeruniversity;
	}
	public String getCustomerspecialities() {
		return customerspecialities;
	}
	public void setCustomerspecialities(String customerspecialities) {
		this.customerspecialities = customerspecialities;
	}
	public Date getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}
	public Integer getResumesource() {
		return resumesource;
	}
	public void setResumesource(Integer resumesource) {
		this.resumesource = resumesource;
	}
	public String getResumeid() {
		return resumeid;
	}
	public void setResumeid(String resumeid) {
		this.resumeid = resumeid;
	}
	public Date getResumeupdatedate() {
		return resumeupdatedate;
	}
	public void setResumeupdatedate(Date resumeupdatedate) {
		this.resumeupdatedate = resumeupdatedate;
	}
	public String getLastvcompanyname() {
		return lastvcompanyname;
	}
	public void setLastvcompanyname(String lastvcompanyname) {
		this.lastvcompanyname = lastvcompanyname;
	}
	public String getTechnicalexpertise() {
		return technicalexpertise;
	}
	public void setTechnicalexpertise(String technicalexpertise) {
		this.technicalexpertise = technicalexpertise;
	}
	public String getLastprojectname() {
		return lastprojectname;
	}
	public void setLastprojectname(String lastprojectname) {
		this.lastprojectname = lastprojectname;
	}
	public Integer getRelationshipbyzq() {
		return relationshipbyzq;
	}
	public void setRelationshipbyzq(Integer relationshipbyzq) {
		this.relationshipbyzq = relationshipbyzq;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Integer getRelationshipbyzh() {
		return relationshipbyzh;
	}
	public void setRelationshipbyzh(Integer relationshipbyzh) {
		this.relationshipbyzh = relationshipbyzh;
	}
	public Integer getEntryprobability() {
		return entryprobability;
	}
	public void setEntryprobability(Integer entryprobability) {
		this.entryprobability = entryprobability;
	}
	public String getResumepath() {
		return resumepath;
	}
	public void setResumepath(String resumepath) {
		this.resumepath = resumepath;
	}
	public Date getZqentrytime() {
		return zqentrytime;
	}
	public void setZqentrytime(Date zqentrytime) {
		this.zqentrytime = zqentrytime;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public String getOpertcode() {
		return opertcode;
	}
	public void setOpertcode(String opertcode) {
		this.opertcode = opertcode;
	}
	public String getOpertname() {
		return opertname;
	}
	public void setOpertname(String opertname) {
		this.opertname = opertname;
	}
	public String getAreaid() {
		return areaid;
	}
	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	public Date getLastconttime() {
		return lastconttime;
	}
	public void setLastconttime(Date lastconttime) {
		this.lastconttime = lastconttime;
	}
	public Integer getLastupdatestatic() {
		return lastupdatestatic;
	}
	public void setLastupdatestatic(Integer lastupdatestatic) {
		this.lastupdatestatic = lastupdatestatic;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getExpectationSalary() {
		return expectationSalary;
	}
	public void setExpectationSalary(Integer expectationSalary) {
		this.expectationSalary = expectationSalary;
	}
	public Date getJoinProjectTime() {
		return joinProjectTime;
	}
	public void setJoinProjectTime(Date joinProjectTime) {
		this.joinProjectTime = joinProjectTime;
	}
	public String getProfessionId() {
		return professionId;
	}
	public void setProfessionId(String professionId) {
		this.professionId = professionId;
	}
	public Integer getConsiderChangeJob() {
		return considerChangeJob;
	}
	public void setConsiderChangeJob(Integer considerChangeJob) {
		this.considerChangeJob = considerChangeJob;
	}
	public String getIntentionArea() {
		return intentionArea;
	}
	public void setIntentionArea(String intentionArea) {
		this.intentionArea = intentionArea;
	}
	public Long getEducation() {
		return education;
	}
	public void setEducation(Long education) {
		this.education = education;
	}
	public Long getEnglishLevel() {
		return englishLevel;
	}
	public void setEnglishLevel(Long englishLevel) {
		this.englishLevel = englishLevel;
	}
	public Long getJapaneseLevel() {
		return japaneseLevel;
	}
	public void setJapaneseLevel(Long japaneseLevel) {
		this.japaneseLevel = japaneseLevel;
	}
	public Double getDirectWorkLife() {
		return directWorkLife;
	}
	public void setDirectWorkLife(Double directWorkLife) {
		this.directWorkLife = directWorkLife;
	}
	
	
	
	
}