package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import org.utils.SysGlobals;

import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.UserInfo;


public class SaveUserPhotoRes extends Res{
	private String userIcon;   //头像url

	public String getUserIcon() {
		if(userIcon!=null && userIcon!="" && userIcon.indexOf("http://")==-1 && !userIcon.equals("") && !userIcon.equals("null")){
			userIcon=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/icon/"+userIcon;
		}else if(userIcon !=null && userIcon !="" && userIcon.indexOf("http://")!=-1){
			userIcon=userIcon;
		}
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}


	
	
}
