package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class AddressListBean {
	private String sendId;   //收货地址id,
	private String sendSelected;   //是否为默认，1为默认，0为非默认
	private String sendName;   //收货人姓名
	private String sendPhone;   //收货人电话
	private String sendDetailAddress;   //收货人人街道
	private String sendPostcode;   //邮编
	private String provinceCode; //省编码
	private String cityCode; //市编码
	private String areaCode; //区编码
	
	
	public String getProvinceCode() {
		return provinceCode+"";
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public String getSendSelected() {
		return sendSelected;
	}
	public void setSendSelected(String sendSelected) {
		this.sendSelected = sendSelected;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}
	public String getSendDetailAddress() {
		return sendDetailAddress;
	}
	public void setSendDetailAddress(String sendDetailAddress) {
		this.sendDetailAddress = sendDetailAddress;
	}
	public String getSendPostcode() {
		return sendPostcode;
	}
	public void setSendPostcode(String sendPostcode) {
		this.sendPostcode = sendPostcode;
	}
	
	
	
}
