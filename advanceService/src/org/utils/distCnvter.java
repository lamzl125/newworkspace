package org.utils;

public class distCnvter {
	 private final static double PI = 3.14159265358979323; // 圆周率
	    private final static double R = 6371229; // 地球的半径

	    public static double getDistance(double longt1, double lat1, double longt2,double lat2) {
	        double x, y, distance;
	        x = (longt2 - longt1) * PI * R
	                * Math.cos(((lat1 + lat2) / 2) * PI / 180) / 180;
	        y = (lat2 - lat1) * PI * R / 180;
	        distance = Math.hypot(x, y);
	        return distance;
	    }
	    //两点距离计算  测试
	    public static void main(String[] args)
	    {
	    	double dd=getDistance(113.725306, 34.752317, 113.79947, 34.765603);
	    	System.out.println(dd);
	    }
}
