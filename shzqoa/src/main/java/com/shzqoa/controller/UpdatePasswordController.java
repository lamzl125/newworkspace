package com.shzqoa.controller;

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
import com.shzqoa.service.LoginUserService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.DESUtil;
import com.shzqoa.util.ResourceUtil;
@Controller
@RequestMapping(value = "/update")
public class UpdatePasswordController{

	@Resource
	private LoginUserService loginUserService;
	@Resource 
	private UserGroupService userGroupService;
	@Resource 
	private UserService userService;
	
	/**
	 * 修改密码页面
	 * @return
	 */
	@RequestMapping("/password")  
    public ModelAndView  updatePassword() { 
		ModelAndView mv = new ModelAndView("views/xiugai");
		Map<String,Object> usermap = new HashMap<String,Object>();
		usermap.put("groupname", "管理员");
		List<Map<String,Object>>  groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			mv.addObject("gmflag", 1);
		}else{
			mv.addObject("gmflag", 0);
		}
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist", userlist);
        return mv;  
    }
	@RequestMapping("/checkPassword")
	@ResponseBody
	public ReturnDate checkPassword(String usercode,String userpassword){
		userpassword = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(userpassword,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		return loginUserService.ispass(usercode, userpassword);
	}
	@RequestMapping("/updatepass")
	@ResponseBody
	public ReturnDate updatePass(
			@RequestParam(value = "usercode", defaultValue = "") String usercode ,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "oldPassword", defaultValue = "")String oldPassword,
			HttpServletRequest req,HttpServletResponse res){
		ReturnDate rd=new ReturnDate();
		password = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(password,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		oldPassword = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(oldPassword,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		if(loginUserService.ispas(usercode, oldPassword)>0){
			return loginUserService.updatePass(password, usercode);
			
		}else{
			rd.setStatus(1);
			rd.setMsg("请输入正确密码!");
			return rd;
		}
	}
	
	@RequestMapping("/setPassword")
	@ResponseBody
	public ReturnDate setPassword(
			@RequestParam(value = "usercode", defaultValue = "") String usercode ,
			HttpServletRequest req,HttpServletResponse res){
		String userpassword="shzqoa8888";
		userpassword = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(userpassword,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		return loginUserService.setPassword(userpassword, usercode);
	}
}
