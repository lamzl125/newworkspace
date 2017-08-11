package com.shzqoa.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static final String FORMAT_Y_M_D = "yyyy-MM-dd";
	
	public static Date formatY_M_D2Date(String dateStr, String formatStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.parse(dateStr);
	}
	public static String formatY_M_D2String(Date date, String formatStr){
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
}
