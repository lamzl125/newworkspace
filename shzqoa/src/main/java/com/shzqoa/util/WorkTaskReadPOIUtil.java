package com.shzqoa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkTaskReadPOIUtil{
	private static final Logger logger = Logger.getLogger(WorkTaskReadPOIUtil.class);
	private static final String[] HeaderCode = {"publishContent","appointUser","confirm"};
	
	
	 public static List<Map<String,Object>> readXml(String fileName) throws EncryptedDocumentException, InvalidFormatException{  
		 List<Map<String,Object>> datalist = new ArrayList<Map<String,Object>>();
		 boolean isE2007 = false;
	        if(fileName.endsWith("xlsx"))  
	            isE2007 = true;  
	        try {  
	            InputStream input = new FileInputStream(fileName);  
	            Workbook wb  = null;  
	            if(isE2007){
	            	wb = new XSSFWorkbook(input);  
	            }else{
	            	wb = new HSSFWorkbook(input); 
	            }
	            Sheet sheet = wb.getSheetAt(0);
	            Iterator<Row> rows = sheet.rowIterator();
	            while (rows.hasNext()) {  
	                Row row = rows.next();
	                if(row.getRowNum()>0){
	                	Map<String,Object> map = new HashMap<String,Object>();
	                	Iterator<Cell> cells = row.cellIterator();
		                while (cells.hasNext()) {  
		                    Cell cell = cells.next();
		                    switch (cell.getCellType()) {
			                    case HSSFCell.CELL_TYPE_NUMERIC: 
			                    	if(HSSFDateUtil.isCellDateFormatted(cell)){
			                            map.put(HeaderCode[cell.getColumnIndex()], HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
				                        break; 
			                        }
			                    case HSSFCell.CELL_TYPE_STRING:  
			                        map.put(HeaderCode[cell.getColumnIndex()], cell.getStringCellValue());
			                        break;  
			                    case HSSFCell.CELL_TYPE_BOOLEAN:  
			                        map.put(HeaderCode[cell.getColumnIndex()], cell.getBooleanCellValue());
			                        break;  
			                    case HSSFCell.CELL_TYPE_FORMULA:  
			                        map.put(HeaderCode[cell.getColumnIndex()], cell.getCellFormula());
			                        break;  
			                    default:  
			                        System.out.print("unsuported sell type");  
			                        break;  
		                    }  
		                }
		                if(map != null && !map.isEmpty()){
		                	datalist.add(map);
		                }
	                }
	            }  
	        } catch (IOException ex) {  
	            ex.printStackTrace();  
	        }  
	        return datalist;
	    }  

}



