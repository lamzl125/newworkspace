package com.shzqoa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.model.UserWeiXin;
import com.shzqoa.service.UserService;
import com.shzqoa.service.UserWeiXinService;
import com.shzqoa.util.SerialNumber;



@Controller
@RequestMapping(value = "/userweixin")
public class UserWeiXinController {
	@Resource
	private UserWeiXinService userWeiXinService;
	@Resource
	private UserService userService;
	
	@RequestMapping("/delUserWeiXinById")
	@ResponseBody
	public ReturnDate delUserWeiXinById(
			@RequestParam(value = "userWeiXinId", defaultValue = "") String userWeiXinId ,
			HttpServletRequest req,HttpServletResponse res){
		ReturnDate rd=new ReturnDate();
		UserWeiXin info = userWeiXinService.getUserWeiXinById(userWeiXinId);
		info.setStatusFlag(2);
		info.setNullifyTime(new Date());
		int updatecount = userWeiXinService.update(info);
		if(updatecount>0){
			rd.setStatus(0);
			rd.setMsg("保存成功");
		}else{
			rd.setStatus(1);
			rd.setMsg("保存失败");
		}
		return rd;
	}
	
	
	@RequestMapping("/saveUserWeiXin")
	@ResponseBody
	public ReturnDate saveUserWeiXin(
			@RequestParam(value = "addUserCode", defaultValue = "") String addUserCode ,
			@RequestParam(value = "addweixin", defaultValue = "") String addweixin,
			HttpServletRequest req,HttpServletResponse res){
		ReturnDate rd=new ReturnDate();
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("userCode", addUserCode);
		acMap.put("weiXin", addweixin);
		acMap.put("statusFlag", 1);
		
		int existcount = userWeiXinService.getUserWeiXinCountByMap(acMap);	
		if(existcount>=1){
			rd.setStatus(1);
			rd.setMsg("该信息已存在，无需再次添加");
		}else{
			UserWeiXin info = new UserWeiXin();
			info.setUserWeiXinId(SerialNumber.createSerial("uwx", 4));
			info.setUserCode(addUserCode);
			info.setWeiXin(addweixin);
			info.setStatusFlag(1);
			info.setAddTime(new Date());
			int addcount = userWeiXinService.insertUserWeiXin(info);
			if(addcount>0){
				rd.setStatus(0);
				rd.setMsg("保存成功");
			}else{
				rd.setStatus(1);
				rd.setMsg("保存失败");
			}
		}
		return rd;
	}
	
	
	@RequestMapping("/userweixinlist")  
    public ModelAndView userweixinlist(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/userweixin/userweixinlist");
		Map<String,Object> acMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		
		List<UserWeiXin> list = userWeiXinService.getUserWeiXinListByMap(acMap);		
		int total = userWeiXinService.getUserWeiXinCountByMap(acMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", list);
		
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist", userlist);
		return mv;
	}
}
