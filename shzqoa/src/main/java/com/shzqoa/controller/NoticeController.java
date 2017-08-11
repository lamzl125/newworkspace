package com.shzqoa.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shzqoa.model.Notice;
import com.shzqoa.service.NoticeService;
import com.shzqoa.util.ResultObject;


@Controller
@RequestMapping(value = "/notice")
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	
	
	@RequestMapping(value="/seeNoticeInfo")
	@ResponseBody
	public ResultObject seeNoticeInfo(
			@RequestParam(value = "noticeid", defaultValue = "") String noticeid,
    		@RequestParam(value = "noticeStatus", defaultValue = "") Integer noticeStatus,
    		HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();
		try {
			Notice info = noticeService.getNoticeById(noticeid);
			info.setNoticeStatus(noticeStatus);
			info.setSureTime(new Date());
			int resultcount = noticeService.updateNotice(info);
			if(resultcount>0){
				List<Map<String,Object>> noticelist = noticeService.getAllUnSeenNotice(null,null);
				request.getSession().setAttribute("noticelist", noticelist);
				result.setSuccess(true);
				result.setResultMessage("读取成功");
			}else{
				result.setSuccess(false);
				result.setResultMessage("读取失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setResultMessage(e.getMessage());
		}
		return result;
	}
	
	
}
