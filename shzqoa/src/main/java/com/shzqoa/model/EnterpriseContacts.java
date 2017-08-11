package com.shzqoa.model;


public class EnterpriseContacts {
	private String enterpriseContactsId;//企业联系人Id
	private String enterpriseId;//企业Id
	private String contactsName;//姓名
	private String contactsPhone;//联系人电话
	private String contactsTel;//联系人电话
	private String contactsQQ;//QQ
	private String contactsWeiXin;//微信号
	private String remark;//备注
	private Integer contactsStatus;//状态（1-启用  2-不启用）
	private String abateResource;//失效原因
	private String job;//职位
	
	
	
	
	public String getEnterpriseContactsId() {
		return enterpriseContactsId;
	}
	public void setEnterpriseContactsId(String enterpriseContactsId) {
		this.enterpriseContactsId = enterpriseContactsId;
	}
	public String getContactsName() {
		return contactsName;
	}
	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}
	public String getContactsPhone() {
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}
	public String getContactsTel() {
		return contactsTel;
	}
	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}
	public String getContactsQQ() {
		return contactsQQ;
	}
	public void setContactsQQ(String contactsQQ) {
		this.contactsQQ = contactsQQ;
	}
	public String getContactsWeiXin() {
		return contactsWeiXin;
	}
	public void setContactsWeiXin(String contactsWeiXin) {
		this.contactsWeiXin = contactsWeiXin;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getContactsStatus() {
		return contactsStatus;
	}
	public void setContactsStatus(Integer contactsStatus) {
		this.contactsStatus = contactsStatus;
	}
	public String getAbateResource() {
		return abateResource;
	}
	public void setAbateResource(String abateResource) {
		this.abateResource = abateResource;
	}
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
