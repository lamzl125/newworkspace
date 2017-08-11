package com.shzqoa.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.util.Word2PdfUtil;




@Controller
@RequestMapping(value = "/readDocOnline")
public class ReadWordDocumentController {
	private final Logger log = Logger.getLogger(ReadWordDocumentController.class);
	
	@RequestMapping("/download")  
	public ModelAndView doc2html(@RequestParam(value = "fileName", defaultValue = "") String fileName,
			HttpServletRequest request){
		String contextPath = request.getSession().getServletContext().getRealPath("/");
		String path = contextPath.substring(0, contextPath.lastIndexOf("\\"))+fileName;
		String realPath = path.replaceAll("\\\\", "/");
		String pdfpath = contextPath.substring(0, contextPath.lastIndexOf("\\"))+"/shzqoa/fileUpload"+fileName.substring(fileName.lastIndexOf("/"),fileName.lastIndexOf("."))+".pdf";
		
		ModelAndView modelAndView = new ModelAndView("views/readdoc");
		/**
		 * 判断转换的文件是否存在
		 */
		File pdffile = new File(pdfpath);
		if(pdffile.exists()){//文件存在
			modelAndView.addObject("errormsg", "");
			modelAndView.addObject("filename", pdfpath);
		}else{
			log.info("开始进行转换");
			boolean flag = Word2PdfUtil.word2pdf(realPath, pdfpath.replaceAll("\\\\", "/"));
			if(!flag){
				modelAndView.addObject("errormsg", "查看文档出错");
			}else{
				modelAndView.addObject("errormsg", "");
				modelAndView.addObject("filename", pdfpath);
			}
		}
		return modelAndView;
	}
	
	
}
