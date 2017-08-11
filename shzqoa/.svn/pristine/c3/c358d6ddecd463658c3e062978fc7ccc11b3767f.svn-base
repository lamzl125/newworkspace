package com.shzqoa.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.model.WorkTask;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkTaskService;
import com.shzqoa.util.DateUtils;
import com.shzqoa.util.WorkTaskReadPOIUtil;


/**
 * 工作任务 
 * @author Auser
 *
 */
@Controller
@RequestMapping(value = "/work")
public class WorkTaskController {
	
	@Resource
	private WorkTaskService workTaskService;
	
	@Resource
	private UserService userService;
	
	/**
	 * 上传工作任务文件并解析
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
	 */
	@RequestMapping(value = "/uploadWorkTask")
	@ResponseBody
	public ReturnDate uploadWorkTask(
			@RequestParam(value = "file") MultipartFile file,
			HttpServletRequest request,HttpServletResponse response) throws EncryptedDocumentException, InvalidFormatException{
		ReturnDate rd = new ReturnDate();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String contextPath = request.getSession().getServletContext().getRealPath("/");  //项目路径
		String tempPath = File.separator+"fileUpload"+File.separator+sdf.format(today)+"worktasktemp"; //临时路径
        String fileName = new Date().getTime()+file.getOriginalFilename();  //保存文件的名称
        File tempFile = new File(contextPath +tempPath, fileName); 
        //临时目录是否存在，如果不存在则重新创建
        if(!tempFile.exists()){  
        	tempFile.mkdirs();  
        }  
        //保存  
        try {  
        	file.transferTo(tempFile); 
        } catch (Exception e) {  
            rd.setStatus(1);
			rd.setMsg("工作任务上传失败!");
			return rd;
        }
        User user = (User) request.getSession().getAttribute("user");
        List<Map<String,Object>> datalist = WorkTaskReadPOIUtil.readXml(tempFile.getAbsolutePath());
        List<WorkTask> workTasklist = new ArrayList<WorkTask>();
        if(datalist!=null && datalist.size()>0){
        	for(int i=0;i<datalist.size();i++){
        		Map<String,Object> datamap = datalist.get(i);
        		WorkTask workTask = new WorkTask();
        		workTask.setPublishid(user.getUsercode());
        		workTask.setPublishcontent(datamap.get("publishContent").toString());
        		String[] appuserstr = datamap.get("appointUser").toString().split("-");        		
        		workTask.setAppointuserid(appuserstr[0]); //工作任务指定人员id
        		workTask.setRealname(appuserstr[1]);// 指定人员名称       		
        		workTask.setStatus(0);//0-未完成  1-已完成
        		workTask.setPublishtime(today);//工作任务发布时间
        		workTask.setConfirm((Date)datamap.get("confirm"));// 预计确认完成时间
        		workTasklist.add(workTask);
            }
        }
        if(workTaskService.batchaddWorkTask(workTasklist)>0){
        	rd.setStatus(0);
			rd.setMsg("工作任务上传成功!");
		}else{
			rd.setStatus(1);
			 rd.setMsg("工作任务上传失败!");
			
		}
        return rd;
	}
	
	/**
	 * 添加工作任务
	 * @param publishid
	 * @param publishcontent
	 * @param appointuserid
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public ReturnDate insertWorkTask(
			@RequestParam(value = "publishid", defaultValue = "1") String publishid,
			@RequestParam(value = "publishcontent", defaultValue = "1") String publishcontent,
			@RequestParam(value = "appointuserid", defaultValue = "1") String appointuserid,
			@RequestParam(value = "realname", defaultValue = "1") String realname){
		ReturnDate rd = new ReturnDate();
		if(workTaskService.insertWorkTask(publishid, publishcontent.replace("\n", "<br/>"), appointuserid,realname) > 0){
			rd.setStatus(1);
		}
			return rd;
	}
	
	/**
	 * 确认工作任务
	 * @param taskid
	 * @return
	 */
	@RequestMapping(value = "/confirm")
	@ResponseBody
	public ReturnDate confirmWork(
			@RequestParam(value = "taskid", defaultValue = "1") Integer taskid){
		ReturnDate rd = new ReturnDate();
		if(workTaskService.confirmWork(taskid) > 0){
			rd.setStatus(1);
			rd.setMsg("工作任务确认完成!");
		}
		return rd;
	}
	
	/**
	 * 进入工作任务页面
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/issue")
	public ModelAndView workTaskadd(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
			@RequestParam(value = "appointuserid", defaultValue = "") String appointuserid,
			@RequestParam(value = "realname", defaultValue = "请选择") String realname,
			@RequestParam(value = "publishtime", defaultValue = "") String publishtime,
			HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/work/WorkTask");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date time = null;
		if(publishtime.length() > 0){
			try {
				time = sf.parse(publishtime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<User> users = userService.getAllUsers();
		mv.addObject("users", users);
		Map<String,Object> map = workTaskService.intoWorkTask(page, pageSize,appointuserid,time);
		int total=(Integer) map.get("total");
		
		if (request.getQueryString() != null)  // 查询参数
			mv.addObject("dataQuery", "?" + request.getQueryString());
		request.getSession().getAttribute("user");
		mv.addAllObjects(map);
		mv.addObject("total",total);
		mv.addObject("publishtime", publishtime);
		mv.addObject("appointuserid", appointuserid);
		mv.addObject("realname", realname);
		return mv;
	}
	
} 	



