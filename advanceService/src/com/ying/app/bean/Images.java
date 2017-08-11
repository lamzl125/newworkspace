package com.ying.app.bean;

import java.util.Date;

import org.utils.StringUtils;
import org.utils.SysGlobals;

public class Images {
	private String image;   //图片

	public String getImage() {
		if(image!=null && image!="" && image.indexOf("http://")==-1 && !image.equals("") && !image.equals("null")){
			image=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+image;
		}else if(image !=null && image !="" && image.indexOf("http://")!=-1){
			image=image;
		}
		return image+"";
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
