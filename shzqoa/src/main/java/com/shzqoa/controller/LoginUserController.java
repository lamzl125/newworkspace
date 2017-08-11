package com.shzqoa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.Rights;
import com.shzqoa.model.ServicerOnLine;
import com.shzqoa.model.User;
import com.shzqoa.service.LoginUserService;
import com.shzqoa.service.NoticeService;
import com.shzqoa.service.RightsService;
import com.shzqoa.service.ServicerOnLineService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.util.DESUtil;
import com.shzqoa.util.ResourceUtil;

@Controller
@RequestMapping(value = "/login")
public class LoginUserController {
	@Resource
	private LoginUserService loginUserService;
	@Resource
	private RightsService rightsService;
	@Resource
	private ServicerOnLineService servicerOnLineService;
	@Resource
	private NoticeService noticeService;	
	@Resource 
	private UserGroupService userGroupService;
	
	/**
	 * 注册页
	 */
	@RequestMapping("/enroll")  
    public ModelAndView  zhuce() {  
		ModelAndView mv = new ModelAndView("views/zhuce");
        return mv;  
    }
	/**
	 * 提交注册信息
	 * @param userId
	 * @param usercode
	 * @param userPassWord
	 * @return
	 */
	@RequestMapping("/enrollajax")
	@ResponseBody
	public ReturnDate enrollajax(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "userName", defaultValue = "") String userName,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "fullName", defaultValue = "") String fullName,
			HttpServletRequest req,HttpServletResponse res){
		ReturnDate rd = new ReturnDate();
		if(loginUserService.isenroll(userId) > 0){
			rd.setStatus(-1);
			rd.setMsg("该用户名已经被注册!");
			return rd;
		}
		password = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(password,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		if(loginUserService.insertUser(userId, userName, password,fullName) > 0){
			rd.setStatus(0);
			rd.setMsg("注册成功!");
		}else{
			rd.setStatus(1);
			rd.setMsg("注册失败,稍后重试!");
		}
		return rd;
	}
	
	/**
	 * 登录页
	 * @return
	 */
	@RequestMapping("/entry")  
    public ModelAndView  entry() {  
		ModelAndView mv = new ModelAndView("views/login");
        return mv;  
    }
	
	/**
	 * 登录
	 * @param usercode
	 * @param userpassword
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public ReturnDate checkuser(
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			@RequestParam(value = "userpassword", defaultValue = "") String userpassword,
			HttpServletRequest request,HttpServletResponse response){
		ReturnDate rd = new ReturnDate();
		userpassword = DESUtil.encrypt(DESUtil.encrypt(DESUtil.encrypt(userpassword,ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV),ResourceUtil.AUTHKEY,ResourceUtil.AUTHIV);
		if(loginUserService.checkuser(usercode, userpassword) != 0){
			User user = loginUserService.sltUser(usercode);
			if(user.getUserstatus()!=null && user.getUserstatus()==2){
				rd.setStatus(1);
				rd.setMsg("该用户已离职，无法登录！");
			}else{
				//根据登录用户查询所绑定的用户组的权限
				List<Rights> rigtsList = rightsService.getRightsByUserCode(usercode);
				Map<Rights,Object> rootmap = formatRight(rigtsList);
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("userrights", rootmap);
				session.setAttribute("userRigtsList", rigtsList);
				
				//查询在线客服
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("servicerStatus", 1);
				map.put("start", 0);
				map.put("pageSize", 10);
				
				List<ServicerOnLine> serlist = servicerOnLineService.getAllServicerOnLine(map);
				session.setAttribute("serlist", serlist);
				
				//查询通知
				List<Map<String,Object>> noticelist = noticeService.getAllUnSeenNotice(null,null);
				session.setAttribute("noticelist", noticelist);
				
				//判断是否是财务组
				Map<String,Object> usermap = new HashMap<String,Object>();
				usermap.put("usercode",user.getUsercode());
				usermap.put("groupname", "财务组");
				List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
				
				if(groups!=null && groups.size()>0){
					rd.setData(1);
				}
				
				
				rd.setStatus(0);
				rd.setMsg("登录成功!");
			}
		}else{
			rd.setStatus(1);
			rd.setMsg("用户名或密码错误!");
		}
		return rd;
	}
	
	public Map<Rights,Object> formatRight(List<Rights> list){
		return makeMenu("-1", null,list,new HashMap<Rights,Object>());
	}
	
	
	public Map<Rights,Object> makeMenu(String parentId, Rights curMenu,List<Rights> allMenus,Map<Rights,Object> rootmap){
		List<Rights> children = new ArrayList<Rights>();
		for(int j = 0; j < allMenus.size(); j++) {
			Rights right = allMenus.get(j);
			if(parentId.equals(right.getParentid())) {
				makeMenu(right.getRightid(), right, allMenus,rootmap);
				children.add(right);
			}
		}
		rootmap.put(curMenu, children);
		return rootmap;
	}

}







