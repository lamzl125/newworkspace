package org.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期时间处理工具
 * 
 * @author 
 * 
 */
public class DateTimeUtil {

	
	public static void main(String[] args){
		Date d1 = new Date();
		System.out.println(DateTimeUtil
				.dateConvtoFmt(d1, "yyyy-MM-dd HH:mm:ss"));
		Date d2 = DateTimeUtil.setLastTime(d1);
		System.out.println(DateTimeUtil
				.dateConvtoFmt(d2, "yyyy-MM-dd HH:mm:ss"));
	}
	
	/**
	 * @Title: getCurrentDate
	 * @Description: TODO(获得当前日期)
	 * @param @return 设定文件
	 * @return Date 返回类型
	 * @throws
	 */
	public static Date getCurrDate() {
		Date date = new Date();
		return date;
	}

	/**
	 * 格式化日期
	 * 
	 * @param format
	 *            格式(如：yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String dateFormat(String format,Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dt = sdf.format(date);
		return dt;
	}
	
	/**
	 * 得到本月的第一天
	 * 
	 * @return
	 */     
	public static String getMonthFirstDay() {      
	    Calendar calendar = Calendar.getInstance();      
	    calendar.set(Calendar.DAY_OF_MONTH, calendar      
	            .getActualMinimum(Calendar.DAY_OF_MONTH));      
	     
	    return dateFormat("yyyy-MM-dd", calendar.getTime());      
	}      
	     
	/**
	 * 得到本月的最后一天
	 * 
	 * @return
	 */     
	public static String getMonthLastDay() {      
	    Calendar calendar = Calendar.getInstance();      
	    calendar.set(Calendar.DAY_OF_MONTH, calendar      
	            .getActualMaximum(Calendar.DAY_OF_MONTH));      
	    return dateFormat("yyyy-MM-dd", calendar.getTime());      
	} 
	
	/**
	 * 得到本月的最后一天
	 * 
	 * @return
	 */     
	public static String getMonthLastDay(String format) {      
		Calendar calendar = Calendar.getInstance();      
		calendar.set(Calendar.DAY_OF_MONTH, calendar      
				.getActualMaximum(Calendar.DAY_OF_MONTH));      
		return dateFormat(format, calendar.getTime());      
	} 
	
	/**
	 * 
	 * @param year
	 *            int 年份
	 * @param month
	 *            int 月份
	 * 
	 * @return int 某年某月的最后一天
	 */  
    private int getLastDayOfMonth(int year, int month) {   
        Calendar cal = Calendar.getInstance();   
        cal.set(Calendar.YEAR, year);   
        cal.set(Calendar.MONTH, month);   
		// 某年某月的最后一天
        return cal.getActualMaximum(Calendar.DATE);   
    }	
	
	/**
	 * 设置某日期Time为23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date setLastTime(Date date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		return calendar.getTime();
	}	
	
	
	/**
	 * 某日期上添加x天
	 * 
	 * @param date
	 * @param intDate
	 * @return
	 */
	public static Date addDay(Date date, int intDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, intDate);
		return calendar.getTime();
	}
	
	/**
	 * 当前日期上添加x天
	 * 
	 * @param intDate
	 * @return
	 */
	public static Date addDay(int intDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, intDate);
		return calendar.getTime();
	}

	/**
	 * 某日期上添加x月
	 * 
	 * @param date
	 * @param intDate
	 * @return
	 */
	public static Date addMonth(Date date, int intMonth) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, intMonth);
		return calendar.getTime();
	}
	
	/**
	 * 某日期上添加x月
	 * 
	 * @param date
	 * @param intDate
	 * @return
	 */
	public static Date addMonth(int intMonth) {
		Date date = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, intMonth);
		return calendar.getTime();
	}

	/**
	 * 某日期上添加x时间段
	 * 
	 * @param date
	 * @param iType
	 *            如Calendar.DAY_OF_MONTH
	 * @param iValue
	 * @return
	 */
	public static Date add(Date date, int iType, int iValue) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(iType, iValue);
		return calendar.getTime();
	}

	/**
	 * 取系统当前日期时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * 取系统当前日期时间
	 * 
	 * @param format
	 *            格式(如：yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String getDateTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * 日期字符串转换为指定格式日期字符串
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param outFormat
	 *            返回格式(如：yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String getDateTime(String strDate, String outFormat) {
		Date tmpDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat(outFormat);
		tmpDate = new Date(strDate);
		return sdf.format(tmpDate);
	}

	/**
	 * 日期字符串格式化
	 * 
	 * @param date
	 * @param oldPattern
	 * @param newPattern
	 * @return
	 */
	public static String stringPattern(String date, String oldPattern,
			String newPattern) {
		if (date == null || oldPattern == null || newPattern == null)
			return "";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern); // 实例化模板对象
		SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern); // 实例化模板对象
		Date d = null;
		try {
			d = sdf1.parse(date); // 将给定的字符串中的日期提取出来
		} catch (Exception e) { // 如果提供的字符串格式有错误，则进行异常处理
			e.printStackTrace(); // 打印异常信息
		}
		return sdf2.format(d);
	}

	/**
	 * 将指定日期以短格式显示
	 * 
	 * @param date
	 * @return
	 */
	public static String shortFmt(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(date);
	}

	/**
	 * 将指定日期以以指定格式返回
	 * 
	 * @param date
	 * @return
	 */
	public static String dateConvtoFmt(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 将日期字符串(yyyy-MM-dd HH:mm:ss或yyyy-MM-dd)转换成日期
	 * 
	 * @param date
	 * @return
	 */		
	public static Date parse(String dtvalue) {
		Date date = null;
		SimpleDateFormat sdf = null;
		try {
			if (dtvalue == null)
				return date;
			if (dtvalue.length() == 8) {
				sdf = new SimpleDateFormat("yyyyMMdd");
			}else if(dtvalue.length() == 10) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			}else if(dtvalue.length() == 14) {
				sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			}else if(dtvalue.length() == 19) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else
				return date;
			date = sdf.parse(dtvalue);
		} catch (ParseException ex) {
		}
		return date;
	}


	/**
	 * 将日期字符串转换成日期
	 * 
	 * @param dtValue
	 *            日期字符串
	 * @param dtFormat
	 *            日期字符串的格式
	 * @return
	 */	
	public static Date parse(String dtValue, String dtFormat) throws ParseException{
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dtFormat);
		date = sdf.parse(dtValue);
		return date;
	}

	/**
	 * 判断当前时间是否在时间dtValue之前
	 * 
	 * @param dtValue
	 * @return
	 */
	public static boolean isBefore(String dtValue) {
		try {
			Date currDate = new Date();
			DateFormat df = DateFormat.getDateTimeInstance();
			return currDate.before(df.parse(dtValue));
		} catch (ParseException e) {
			System.out.print("[SYS] " + e.getMessage());
			return false;
		}
	}
	
	public static boolean isToday(Date theDate){
		boolean bRes = false;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String d1 = df.format(new Date());
		String d2 = df.format(theDate);
		if(d1.equals(d2)){
			bRes = true;
		}
		return bRes;
	}	
	
	  /**
	 * @param date1
	 *            需要比较的时间 不能为空(null),需要正确的日期格式 ,如：2009-09-12
	 * @param date2
	 *            被比较的时间 为空(null)则为当前时间
	 * @param stype
	 *            返回值类型 0为多少天，1为多少个月，2为多少年
	 * @return 举例： compareDate("2009-09-12", null, 0);//比较天
	 *         compareDate("2009-09-12", null, 1);//比较月
	 *         compareDate("2009-09-12", null, 2);//比较年
	 */
	public static int compareDate(String startDay, String endDay, int stype) {
		int n = 0;
		String[] u = { "天", "月", "年" };
		String formatStyle = stype == 1 ? "yyyy-MM" : "yyyy-MM-dd";

		endDay = endDay == null ? getDateTime("yyyy-MM-dd") : endDay;

		DateFormat df = new SimpleDateFormat(formatStyle);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		try {
			c1.setTime(df.parse(startDay));
			c2.setTime(df.parse(endDay));
		} catch (Exception e3) {
			System.out.println("wrong occured");
		}
		// List list = new ArrayList();
		while (!c1.after(c2)) { // 循环对比，直到相等，n 就是所要的结果
			// list.add(df.format(c1.getTime())); // 这里可以把间隔的日期存到数组中 打印出来
			n++;
			if (stype == 1) {
				c1.add(Calendar.MONTH, 1); // 比较月份，月份+1
			} else {
				c1.add(Calendar.DATE, 1); // 比较天数，日期+1
			}
		}
		n = n - 1;
		if (stype == 2) {
			n = (int) n / 365;
		}

		return n;
	}

	public static String CaculateWeekDay(int y, int m, int d) {
		if (m == 1) {
			m = 13;
		}
		if (m == 2) {
			m = 14;
		}
		int week = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
		String weekstr = "";
		switch (week) {
		case 0:
			weekstr = "星期一";
			break;
		case 1:
			weekstr = "星期二";
			break;
		case 2:
			weekstr = "星期三";
			break;
		case 3:
			weekstr = "星期四";
			break;
		case 4:
			weekstr = "星期五";
			break;
		case 5:
			weekstr = "星期六";
			break;
		case 6:
			weekstr = "星期日";
			break;
		}
		return weekstr;
	}



}