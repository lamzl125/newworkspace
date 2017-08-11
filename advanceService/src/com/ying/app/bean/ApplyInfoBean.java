package com.ying.app.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class ApplyInfoBean {
	private String name; //姓名
	private String status; //状态  0待审核    1审核通过  2审核失败 
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
	private String supplement; //补充说明   
	private List<Images> certificateImages = new ArrayList<Images>();   //图片 
	
	
	public String getStatus() {
		return status+"";
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name+"";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company+"";
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyAddress() {
		return companyAddress+"";
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getAddress() {
		return address+"";
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel+"";
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getImportTel() {
		return importTel+"";
	}
	public void setImportTel(String importTel) {
		this.importTel = importTel;
	}
	public String getRegiterTime() {
		return regiterTime+"";
	}
	public void setRegiterTime(String regiterTime) {
		this.regiterTime = regiterTime;
	}
	public String getProfessional() {
		return professional+"";
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public String getTurnoverYear() {
		return turnoverYear+"";
	}
	public void setTurnoverYear(String turnoverYear) {
		this.turnoverYear = turnoverYear;
	}
	public String getSendNumer() {
		return sendNumer+"";
	}
	public void setSendNumer(String sendNumer) {
		this.sendNumer = sendNumer;
	}
	public String getIdCardUp() {
		if(idCardUp!=null && idCardUp!="" && idCardUp.indexOf("http://")==-1 && !idCardUp.equals("") && !idCardUp.equals("null")){
			idCardUp=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+idCardUp;
		}else if(idCardUp !=null && idCardUp !="" && idCardUp.indexOf("http://")!=-1){
			idCardUp=idCardUp;
		}
		return idCardUp+"";
	}
	public void setIdCardUp(String idCardUp) {
		this.idCardUp = idCardUp;
	}
	public String getIdCardDown() {
		if(idCardDown!=null && idCardDown!="" && idCardDown.indexOf("http://")==-1 && !idCardDown.equals("") && !idCardDown.equals("null")){
			idCardDown=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+idCardDown;
		}else if(idCardDown !=null && idCardDown !="" && idCardDown.indexOf("http://")!=-1){
			idCardDown=idCardDown;
		}
		return idCardDown+"";
	}
	public void setIdCardDown(String idCardDown) {
		this.idCardDown = idCardDown;
	}
	public String getIdCardHand() {
		if(idCardHand!=null && idCardHand!="" && idCardHand.indexOf("http://")==-1 && !idCardHand.equals("") && !idCardHand.equals("null")){
			idCardHand=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+idCardHand;
		}else if(idCardHand !=null && idCardHand !="" && idCardHand.indexOf("http://")!=-1){
			idCardHand=idCardHand;
		}
		return idCardHand+"";
	}
	public void setIdCardHand(String idCardHand) {
		this.idCardHand = idCardHand;
	}
	public String getSupplement() {
		return supplement+"";
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}
	public List<Images> getCertificateImages() {
		return certificateImages;
	}
	public void setCertificateImages(List<Images> certificateImages) {
		this.certificateImages = certificateImages;
	}
	
	
	
	
}
