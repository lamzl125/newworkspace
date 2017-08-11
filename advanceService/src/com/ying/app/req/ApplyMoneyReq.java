package com.ying.app.req;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.ImageListBean;

public class ApplyMoneyReq extends Req{
	private String uid; //用户id
	private String name; //姓名
	private String company; //公司名字，选填项
	private String companyAddress; //经营地址
	private String address; //负责人住址
	private String tel; //电话
	private String importTel; //紧急联系人电话
	private String regiterTime; //经营时间
	private String professional; //所属行业
	private String turnoverYear; //市编码
	private String sendNumer; //年营业额
	private String idCardUp; //身份证正面图片
	private String idCardDown; //身份证反面图片
	private String idCardHand; //手持身份证图片
	private File[] certificateImages;
	private String supplement; //补充说明   
	private List<ImageListBean> images = new ArrayList<ImageListBean>();   //图片    
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImportTel() {
		return importTel;
	}
	public void setImportTel(String importTel) {
		this.importTel = importTel;
	}
	public String getRegiterTime() {
		return regiterTime;
	}
	public void setRegiterTime(String regiterTime) {
		this.regiterTime = regiterTime;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getTurnoverYear() {
		return turnoverYear;
	}
	public void setTurnoverYear(String turnoverYear) {
		this.turnoverYear = turnoverYear;
	}
	public String getSendNumer() {
		return sendNumer;
	}
	public void setSendNumer(String sendNumer) {
		this.sendNumer = sendNumer;
	}
	public String getIdCardUp() {
		return idCardUp;
	}
	public void setIdCardUp(String idCardUp) {
		this.idCardUp = idCardUp;
	}
	public String getIdCardDown() {
		return idCardDown;
	}
	public void setIdCardDown(String idCardDown) {
		this.idCardDown = idCardDown;
	}
	public String getIdCardHand() {
		return idCardHand;
	}
	public void setIdCardHand(String idCardHand) {
		this.idCardHand = idCardHand;
	}
	public File[] getCertificateImages() {
		return certificateImages;
	}
	public void setCertificateImages(File[] certificateImages) {
		this.certificateImages = certificateImages;
	}
	public String getSupplement() {
		return supplement;
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}
	public List<ImageListBean> getImages() {
		return images;
	}
	public void setImages(List<ImageListBean> images) {
		this.images = images;
	}
	
	
	
	
	
}
