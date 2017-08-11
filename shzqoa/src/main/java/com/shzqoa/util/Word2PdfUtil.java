package com.shzqoa.util;

import java.io.IOException;
import java.io.File;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jacob.activeX.ActiveXComponent;  
import com.jacob.com.Dispatch; 


public class Word2PdfUtil {
	private static Logger logger = LoggerFactory.getLogger(Word2PdfUtil.class);  
	  
    private static final int xlTypePDF = 0;  
    private static final int ppSaveAsPDF = 32;  
	static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。  
    static final int wdFormatPDF = 17;// word转PDF 格式  
  
    public static void main(String[] args) throws IOException {  
        String source1 = "e:\\test.doc";  
        String target1 = "e:\\test1.pdf";  
        Word2PdfUtil pdf = new Word2PdfUtil();  
        pdf.word2pdf(source1, target1);  
    }  
  
    public static boolean word2pdf(String source, String target) {  
        System.out.println("Word转PDF开始启动...");  
        long start = System.currentTimeMillis();  
        ActiveXComponent app = null;  
        try {  
            app = new ActiveXComponent("Word.Application");  
            app.setProperty("Visible", false);  
            Dispatch docs = app.getProperty("Documents").toDispatch();  
            System.out.println("打开文档：" + source);  
            Dispatch doc = Dispatch.call(docs, "Open", source, false, true).toDispatch();  
            System.out.println("转换文档到PDF：" + target);  
            File tofile = new File(target);  
            if (tofile.exists()) {  
                tofile.delete();  
            }  
            Dispatch.call(doc, "SaveAs", target, wdFormatPDF);  
            Dispatch.call(doc, "Close", false);  
            long end = System.currentTimeMillis();  
            System.out.println("转换完成，用时：" + (end - start) + "ms");  
            return true;  
        } catch (Exception e) {  
            System.out.println("Word转PDF出错：" + e.getMessage());  
            return false;  
        } finally {  
            if (app != null) {  
                app.invoke("Quit", wdDoNotSaveChanges);  
            }  
        }  
    }  
    
    
    
    

	
  
    /** 
     * 转换为pdf 
     *  
     * @param inputFile 
     *            输入文件 
     * @param pdfFile 
     *            输出pdf文件 
     * @return 
     */  
    public static boolean convert2PDF(String inputFile, String pdfFile) {  
//        String suffix = FileUtils.getExt(inputFile); 
    	String suffix = inputFile.substring(inputFile.lastIndexOf(".")+1);
        File file = new File(inputFile);  
        if (!file.exists()) {  
  
            logger.debug("{}文件不存", file.getName());  
            return false;  
        }  
        if (suffix.equals("pdf")) {  
  
            logger.debug("PDF not need to convert!");  
            return false;  
        }  
        if (suffix.equals("doc") || suffix.equals("docx")  
                || suffix.equals("txt")) {  
            return word2PDF(inputFile, pdfFile);  
        } else if (suffix.equals("ppt") || suffix.equals("pptx")) {  
            return ppt2PDF(inputFile, pdfFile);  
        } else if (suffix.equals("xls") || suffix.equals("xlsx")) {  
            return excel2PDF(inputFile, pdfFile);  
        } else {  
  
            logger.debug("文件格式不支持转换!");  
            return false;  
        }  
    }  
  
    /** 
     * 文档和txt转换为pdf 
     *  
     * @param inputFile 
     * @param pdfFile 
     * @return 
     */  
    private static boolean word2PDF(String inputFile, String pdfFile) {  
        try {  
            // 打开word应用程序  
            ActiveXComponent app = new ActiveXComponent("Word.Application");  
            // 设置word不可见  
            app.setProperty("Visible", false);  
            // 获得word中所有打开的文档,返回Documents对象  
            Dispatch docs = app.getProperty("Documents").toDispatch();  
            // 调用Documents对象中Open方法打开文档，并返回打开的文档对象Document  
            Dispatch doc = Dispatch.call(docs, "Open", inputFile, false, true)  
                    .toDispatch();  
            // 调用Document对象的SaveAs方法，将文档保存为pdf格式  
            /* 
             * Dispatch.call(doc, "SaveAs", pdfFile, wdFormatPDF 
             * //word保存为pdf格式宏，值为17 ); 
             */  
            Dispatch.call(doc, "ExportAsFixedFormat", pdfFile, wdFormatPDF // word保存为pdf格式宏，值为17  
            );  
            // 关闭文档  
            Dispatch.call(doc, "Close", false);  
            // 关闭word应用程序  
            app.invoke("Quit", 0);  
            return true;  
        } catch (Exception e) {  
  
            logger.warn("word to PDF 出错", e);  
            return false;  
        }  
    }  
  
    /** 
     * excel转换为pdf 
     *  
     * @param inputFile 
     * @param pdfFile 
     * @return 
     */  
    private static boolean excel2PDF(String inputFile, String pdfFile) {  
        try {  
            ActiveXComponent app = new ActiveXComponent("Excel.Application");  
            app.setProperty("Visible", false);  
            Dispatch excels = app.getProperty("Workbooks").toDispatch();  
            Dispatch excel = Dispatch.call(excels, "Open", inputFile, false,  
                    true).toDispatch();  
            Dispatch.call(excel, "ExportAsFixedFormat", xlTypePDF, pdfFile);  
            Dispatch.call(excel, "Close", false);  
            app.invoke("Quit");  
            return true;  
        } catch (Exception e) {  
  
            logger.warn("excel to PDF 出错", e);  
            return false;  
        }  
  
    }  
  
    /** 
     * ppt转换为pdf 
     *  
     * @param inputFile 
     * @param pdfFile 
     * @return 
     */  
    private static boolean ppt2PDF(String inputFile, String pdfFile) {  
        try {  
            ActiveXComponent app = new ActiveXComponent(  
                    "PowerPoint.Application");  
            // app.setProperty("Visible", msofalse);  
            Dispatch ppts = app.getProperty("Presentations").toDispatch();  
  
            Dispatch ppt = Dispatch.call(ppts, "Open", inputFile, true,// ReadOnly  
                    true,// Untitled指定文件是否有标题  
                    false// WithWindow指定文件是否可见  
                    ).toDispatch();  
            Dispatch.call(ppt, "SaveAs", pdfFile, ppSaveAsPDF);  
            Dispatch.call(ppt, "Close");  
            app.invoke("Quit");  
            return true;  
        } catch (Exception e) {  
  
            logger.warn("ppt to PDF 出错", e);  
            return false;  
        }  
    }  



}
