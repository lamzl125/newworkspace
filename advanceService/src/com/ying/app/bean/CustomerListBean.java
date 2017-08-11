package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class CustomerListBean {
	private String img;   //客户头像
	private String customerId;   //收货地址id,
	private String name;   //名字
	private Date adtime;   
	private String registerTime;   //加入的时间
	private String area;   //所在地区
	public String getImg() {
		if(img!=null && img!="" && img.indexOf("http://")==-1 && !img.equals("") && !img.equals("null")){
			img=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+img;
		}else if(img !=null && img !="" && img.indexOf("http://")!=-1){
			img=img;
		}
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCustomerId() {
		return customerId+"";
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name+"";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegisterTime() {
		return registerTime+"";
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getArea() {
		return area+"";
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Date getAdtime() {
		return adtime;
	}
	public void setAdtime(Date adtime) {
		this.adtime = adtime;
	}
	
	
	
}
