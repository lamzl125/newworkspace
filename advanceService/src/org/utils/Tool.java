package org.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Tool {
	
	/**
	 * MD5
	 * @param inStr
	 * @return
	 */
	public static String MD5(String inStr)
	{
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		byte[] byteArray = null;
		try {
			byteArray = inStr.getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xFF;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	/**
	 * 检查是否是邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		 Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		 Matcher matcher = pattern.matcher(email);
		 return matcher.matches();
	}
	/** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
	/** 
     * 用户号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isuserNum(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[0-9]{3,5}$"); // 验证用户号 
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }   
   /**
    * 根据经纬度计算距离,计算结果为米
    * @param x1
    * @param y1
    * @param x2
    * @param y2
    * @return
    */
    public static String GetDistance(double lng1, double lat1, double lng2, double lat2){
    	String str="";
    	try {
	    	double EARTH_RADIUS = 6378137;
		    double radLat1 = rad(lat1);
		    double radLat2 = rad(lat2);
		    double a = radLat1 - radLat2;
		    double b = rad(lng1) - rad(lng2);
		    double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
		    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
		    s = s * EARTH_RADIUS;
		    s = Math.round(s * 10000) / 10000;
		   
		    if(s>1000){
		    	DecimalFormat df = new DecimalFormat("0.0");
		    	str= df.format(s/1000)+"千米";
		    }else{
		    	str=s+"米";
		    }
    	} catch (Exception e) {
    		Logs.error(e);
		}
	    return str;
     }
    private static double rad(double d){
    	 return d * Math.PI / 180.0;
    }
	public static void main(String[] args) {
		System.out.println(GetDistance(106.503985,29.612454,106.60632,29.665191));
    } 	
	
}
