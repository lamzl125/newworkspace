package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class CycleBean {
	private String id;   //当前轮播的ID
	private String imgUrl;   //图片的 url
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImgUrl() {
		if(imgUrl!=null && imgUrl!="" && imgUrl.indexOf("http://")==-1 && !imgUrl.equals("") && !imgUrl.equals("null")){
			imgUrl=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+imgUrl;
		}else if(imgUrl !=null && imgUrl !="" && imgUrl.indexOf("http://")!=-1){
			imgUrl=imgUrl;
		}
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	
}
