package com.shzqoa.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shzqoa.model.User;

@Controller
public class UploadUtrilController {
	/**
	 * 处理上传文件
	 */
	@RequestMapping(value = "/uploadUtril")
	@ResponseBody
	public String uploadResume(@RequestParam(value = "resume") MultipartFile resume,
			@RequestParam(value = "pathname") String pathname,
			HttpServletRequest request,HttpServletResponse response){
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String contextPath = request.getSession().getServletContext().getRealPath("/");  //项目路径
		String tempPath = File.separator+"fileUpload"+File.separator+sdf.format(today)+"temp"; //临时路径
        String fileName = new Date().getTime()+resume.getOriginalFilename();  //保存文件的名称
        File tempFile = new File(contextPath+tempPath, fileName); 
        //临时目录是否存在，如果不存在则重新创建
        if(!tempFile.exists()){  
        	tempFile.mkdirs();  
        }  
        //保存  
        String savePath = File.separator+pathname+File.separator+sdf.format(today)+"temp"; //保存路径
        File saveFile = new File(contextPath+savePath, fileName); 
        if(!saveFile.exists()){  
        	saveFile.mkdirs();  
        } 
        try {  
        	resume.transferTo(saveFile); 
        } catch (Exception e) {  
            return "";
        }
        return savePath+File.separator+ fileName;
	}
	
	
	
	@RequestMapping(value = "/uploadfilebypathtype")
	@ResponseBody
	public String uploadResume(@RequestParam(value = "resume") MultipartFile resume,
			@RequestParam(value = "pathname") String pathname,
			@RequestParam(value = "filetype") String filetype,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(filetype==null || "".equals(filetype)){
			filetype = "resume";
		}
		User user = (User)request.getSession().getAttribute("user");
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String contextPath = request.getSession().getServletContext().getRealPath("/");  //项目路径
		String tempPath = File.separator+"fileUpload"+File.separator+sdf.format(today)+"temp"; //临时路径
		String sufprex = resume.getOriginalFilename().substring(resume.getOriginalFilename().lastIndexOf("."));
        
        String fileName = new Date().getTime()+user.getUsercode()+resume.getSize()+filetype+sufprex;  //保存文件的名称
        File tempFile = new File(contextPath +tempPath, fileName); 
        //临时目录是否存在，如果不存在则重新创建
        if(!tempFile.exists()){  
        	tempFile.mkdirs();  
        }  
      //保存  
        try {  
        	resume.transferTo(tempFile); 
        } catch (Exception e) {  
            return "";
        }
        
        String savePath = File.separator+pathname+File.separator+sdf.format(today)+"temp"; //保存路径
        File saveFile = new File(contextPath+savePath, fileName); 
        FileUtils.copyFile(tempFile, saveFile);
        return savePath+File.separator+ fileName;
	}
}
