package com.shzqoa.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Method;



import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class SalaryPOIUtil {
	private static final Logger logger = Logger.getLogger(SalaryPOIUtil.class);
	private static final String[] ReportHeader = { "序号", "姓名","是否转正", "实际出勤", "法定出勤", 
		"工资", "加班小时", "请假天数", "迟到早退",
		"扣工资", "实际工资", "实际出勤", "法定出勤",
		"入项实际工资", "工资合计", "税金", "扣借款" ,"扣住宿","报销","保险","补助","实发工资"};

	private static final String[] ReportHeaderCode = { "CustomerName","IfZZ", "XzTime", "XzFdTime", 
		"info4","JbHover", "QjTime","CdTime", 
		"info8","info9","SjTime", "FdTime", 
		"info12","info13","Sj", "Kjk", "Kzs","Bxiao","Bxian", "Bz","info20"};


	public static boolean CreateExcel(String templateFileName,
			String reportFileName, String report_title, Map reportData,OutputStream os) {
//		os = null;
//		try {
//			os = new FileOutputStream(reportFileName);
//		} catch (FileNotFoundException e) {
//			System.out.println("文件不存在");
//			e.printStackTrace();
//		}
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
	    if (templateFileName.endsWith("reportTemplateSalary.xls")) {
			wb.setSheetName(0, report_title);
			HSSFRow row = sheet.createRow((short) 0);
			row.setHeight((short)700);
			// 表头字体
			HSSFCellStyle cellstyle = wb.createCellStyle();
			cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
			HSSFFont fontHeader = wb.createFont();
			fontHeader.setFontName("黑体");
			fontHeader.setFontHeightInPoints((short) 24);
			cellstyle.setFont(fontHeader);
			for (int i = 0; i < ReportHeader.length; i++) {// 头文件
				if (i == 0) {
					HSSFCell cell11 = row.createCell(0);
					cell11.setCellValue(report_title);
					cell11.setCellStyle(cellstyle);
				} else {
					HSSFCell cellheader = row.createCell(i);
					cellheader.setCellValue("");
				}
			}
			CellRangeAddress cra=new CellRangeAddress(0, 0, 0, 21);
			sheet.addMergedRegion(cra);
			

				// 第二行
			HSSFRow row1 = sheet.createRow(1);
			row1.setHeight((short) 350);
			for (int m = 0; m < ReportHeader.length; m++) {// 头文件
				createCell(wb, row1,m, ReportHeader[m]);// 头文件
				if(m==0){
					sheet.setColumnWidth(m, 1200);
				}else{
					sheet.setColumnWidth(m, 2400);
				}
				
			}
			sheet.createFreezePane(0, 2);
			
			// 数据 信息
			List<Map<String,Object>> list = (List<Map<String,Object>>) reportData.get("list");
			if (list != null || list.size() > 0) {
				for (int k = 0; k < list.size(); k++) {
					Map<String,Object> info = (Map<String,Object>) list.get(k);
					HSSFRow rowData = sheet.createRow((short) (k + 2));
					rowData.setHeight((short) 300);
					String ss0 = (k + 1) + "";
					createCell(wb, rowData, 0, ss0);
					for (int j = 0; j < ReportHeaderCode.length; j++) {
						if(j==4){
							String info1 = new java.text.DecimalFormat("#.00").format((Double)info.get("IdleSalary")/(Double)info.get("XzFdTime")*(Double)info.get("XzTime"));
							createCell(wb, rowData, (short) (j + 1), info1);
						}else if(j==8){
							Integer info1 = (Integer)info.get("CdTime")*10;
							createCell(wb, rowData, (short) (j + 1), info1+"");
						}else if(j==9){
							String info1 = new java.text.DecimalFormat("#.00").format((Double)info.get("IdleSalary")/(Double)info.get("XzFdTime")*(Double)info.get("XzTime")-(Integer)info.get("CdTime")*10);
							createCell(wb, rowData, (short) (j + 1), info1);
						}else if(j==12){
							String info1 = new java.text.DecimalFormat("#.00").format((Double)info.get("ProbationarySalary")/(Double)info.get("SyqFdTime")*(Double)info.get("SyqTime")+(Double)info.get("RegularSalary")/(Double)info.get("FdTime")*(Double)info.get("SjTime"));
							createCell(wb, rowData, (short) (j + 1), info1);
						}else if(j==13){
							String info1 =new java.text.DecimalFormat("#.00").format((Double)info.get("IdleSalary")/(Double)info.get("XzFdTime")*(Double)info.get("XzTime")-(Integer)info.get("CdTime")*10 +(Double)info.get("ProbationarySalary")/(Double)info.get("SyqFdTime")*(Double)info.get("SyqTime")+(Double)info.get("RegularSalary")/(Double)info.get("FdTime")*(Double)info.get("SjTime"));
							createCell(wb, rowData, (short) (j + 1), info1);
						}else if(j==20){
							String info1 =new java.text.DecimalFormat("#.00").format((Double)info.get("IdleSalary")/(Double)info.get("XzFdTime")*(Double)info.get("XzTime")-(Integer)info.get("CdTime")*10+(Double)info.get("ProbationarySalary")/(Double)info.get("SyqFdTime")*(Double)info.get("SyqTime") +(Double)info.get("RegularSalary")/(Double)info.get("FdTime")*(Double)info.get("SjTime")-(Double)info.get("Sj")-(Double)info.get("Kjk")-(Double)info.get("Kzs")+(Double)info.get("Bxiao")+(Double)info.get("Bxian")+(Double)info.get("Bz"));
							createCell(wb, rowData, (short) (j + 1), info1);
						}else{
							try {
								Object obj = info.get(ReportHeaderCode[j]);
								createCell(wb, rowData, (short) (j + 1), obj+"");
							} catch (SecurityException e) {
								e.printStackTrace();
								return false;
							} 
						}
						
					}
				}
			}
			/*
			// 合计行
			HSSFRow endrow = sheet.createRow((short) (list.size() + 2));
			for (int n = 0; n < ReportHeader.length; n++) {// 头文件
				if (n == 0) {
					createCell(wb, endrow, (short) 0, "合计");
				} else if (n == 10) {
				} else if (n == 11) {
				} else {
					createCell(wb, endrow, (short) n, " ");
				}
			}	*/
			try {
				if(os!=null){
					if(!"".equals(os)){
						wb.write(os);
					}
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	    return true;
	 }
		 


	private static boolean createCell(HSSFWorkbook wb, HSSFRow row, int col,
			String val) {
		HSSFCell cell = row.createCell(col);
		if(null==val||"".equals(val)){
			cell.setCellValue(" ");
			return true;
		}else{
			cell.setCellValue(val);
			return true;
		}
//		HSSFCellStyle cellstyle = wb.createCellStyle();
//		cellstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//		cellstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//		cellstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		cellstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
//		cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
//		cell.setCellStyle(cellstyle);
	}

	private void newFile(String fileName) {
		HSSFWorkbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}



