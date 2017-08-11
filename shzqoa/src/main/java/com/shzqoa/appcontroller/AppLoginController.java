package com.shzqoa.appcontroller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.interfaces.RSAKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.standard.Copies;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.shzqoa.controller.CustomerDetailController;
import com.shzqoa.model.AccountArea;
import com.shzqoa.model.Accounts;
import com.shzqoa.model.Areas;
import com.shzqoa.model.Corp;
import com.shzqoa.model.CorpContant;
import com.shzqoa.model.CorpProject;
import com.shzqoa.model.CustDemand;
import com.shzqoa.model.CustInfoAdd;
import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.CustomerProject;
import com.shzqoa.model.Customerprojectpay;
import com.shzqoa.model.DemandResume;
import com.shzqoa.model.DemandResumeFollow;
import com.shzqoa.model.DemandSign;
import com.shzqoa.model.Grade;
import com.shzqoa.model.Group;
import com.shzqoa.model.GroupRight;
import com.shzqoa.model.Parameter;
import com.shzqoa.model.ParameterKind;
import com.shzqoa.model.Profession;
import com.shzqoa.model.ResumeSource;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.Rights;
import com.shzqoa.model.ServicerOnLine;
import com.shzqoa.model.User;
import com.shzqoa.model.UserGroup;
import com.shzqoa.model.UserWeiXin;
import com.shzqoa.service.AccountsService;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CorpProjectService;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CorporatepartnersService;
import com.shzqoa.service.CustomerContlService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerDetailService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.CustomerProjectService;
import com.shzqoa.service.CustomerSignService;
import com.shzqoa.service.CustomerprojectpayService;
import com.shzqoa.service.DemandResumeFollowService;
import com.shzqoa.service.DemandResumeService;
import com.shzqoa.service.DemandSignService;
import com.shzqoa.service.GradeService;
import com.shzqoa.service.GroupRightService;
import com.shzqoa.service.GroupService;
import com.shzqoa.service.ItemsService;
import com.shzqoa.service.LoginUserService;
import com.shzqoa.service.MonthServicePayService;
import com.shzqoa.service.ParameterKindService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.ResumeSourceService;
import com.shzqoa.service.RightsService;
import com.shzqoa.service.SalarySetService;
import com.shzqoa.service.ServicerOnLineService;
import com.shzqoa.service.TaskService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.service.UserWeiXinService;
import com.shzqoa.util.DESUtil;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;
import com.shzqoa.util.Word2PdfUtil;

@Controller
@RequestMapping(value = "/app")
public class AppLoginController {
	private final Logger log = Logger.getLogger(CustomerDetailController.class);
	
	@Resource
	private LoginUserService loginUserService;
	@Resource
	private RightsService rightsService;
	@Resource
	private ServicerOnLineService servicerOnLineService;
	@Resource
	private AreasService areasService;
	@Resource
	private CorpService corpService;
	@Resource
	private CorpProjectService corpProjectService;
	@Resource
	private GroupService groupService;
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private GroupRightService groupRightService;
	@Resource
	private UserService userService;
	@Resource
	private AccountsService accountsService;
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private ResumeSourceService resumeSourceService;
	@Resource
	private CustomerDetailService customerDetailService;
	@Resource
	private ParameterKindService parameterKindService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private GradeService gradeService;
	@Resource
	private ProfessionService  professiService;
	@Resource
	private ItemsService itemsService;
	@Resource 
	private CustomerInfoService customerinfoService;
	@Resource
	private TaskService taskService;
	@Resource
	private ProfessionService professionService;
	@Resource
	private CustomerDemandService customerDemandService;
	@Resource
	private CustomerProjectService customerProjectService;
	@Resource
	private CustomerContlService customerContlService;
	@Resource  
	CorporatepartnersService corporateService;
	@Resource
	private DemandSignService demandSignService;
	@Resource
	private DemandResumeService demandResumeService;
	@Resource
	private DemandResumeFollowService demandResumeFollowService;
	@Resource
	private CustomerprojectpayService customerprojectpayService;
	@Resource
	private SalarySetService salarySetService;
	@Resource
	private MonthServicePayService  monthServicePayService;
	@Resource
	private CustomerSignService customerSignService;
	@Resource
	private UserWeiXinService userWeiXinService;
	
	
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
				
				rd.setUsercode(user.getUsercode());
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
	
	
	/**
	 * 获取地区信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toAddAreas")  
	@ResponseBody
    public Map<String,Object> toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		List<Areas> lsit = areasService.getAllAreas(conMap);
		int total = areasService.getAllAreasCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取地区信息成功!");
		resultMap.put("lsitAreas", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 获取合作公司列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toAddCorp") 
	@ResponseBody
    public Map<String,Object> toAddAreas(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "seaCorpName", defaultValue = "") String seaCorpName,
    		@RequestParam(value = "seaCorpStatus", defaultValue = "") Integer seaCorpStatus
    		){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		if(seaCorpName!=null && !"".equals(seaCorpName)){
			conMap.put("corpname", seaCorpName);
		}
		if(seaCorpStatus!=null && seaCorpStatus>0){
			conMap.put("corpStatus", seaCorpStatus);
		}
		
		List<Corp> lsit = corpService.getAllCorp(conMap);
		int total = corpService.getAllCoropsCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		for (int i = 0; i < lsit.size(); i++) {
			if (lsit.get(i).getClosePeople()==null) {
				lsit.get(i).setClosePeople("");
			}
			if (lsit.get(i).getCloseReason()==null) {
				lsit.get(i).setCloseReason("");
			}
			if (lsit.get(i).getCorpStatus()==null) {
				lsit.get(i).setCorpStatus(1);
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取合作公司成功!");
		resultMap.put("lsitCorps", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 关闭合作公司列表
	 * @param page
	 * @param pageSize
	 * @param usercode
	 * @return
	 */
	@RequestMapping("/closeCorp")  
	@ResponseBody
	public Map<String,Object> closeCorp(
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "closeReason", defaultValue = "") String closeReason,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//User user = (User)request.getSession().getAttribute("user");
		//查询地区编号是否存在
		Corp isEx = corpService.getCorpById(corpcode);
		isEx.setCorpStatus(2);
		isEx.setClosePeople(usercode);
		isEx.setCloseReason(closeReason);
		isEx.setCloseTime(new Date());
		
		
		if(corpService.closeCorp(isEx)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "关闭公司信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "关闭公司信息失败");
		}
		return resultMap;
	}
	
	
	/**
	 * 获取合作公司项目
	 * @param page
	 * @param pageSize
	 * @param corpCode
	 * @return
	 */
	@RequestMapping("/toCorpProjectList")  
	@ResponseBody
    public Map<String,Object> toCorpProjectList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "corpCode", defaultValue = "") String corpCode
    		) throws UnsupportedEncodingException{
		corpCode = URLDecoder.decode(corpCode,"UTF-8");
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("corpcode", corpCode);
		List<CorpProject> lsit = corpProjectService.getAllCorpProjectByCropCode(conMap);
		
		int total = corpProjectService.getCorpContantCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取合作公司项目成功!");
		resultMap.put("projectlist", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 获取合作公司联系人
	 * @param page
	 * @param pageSize
	 * @param corpCode
	 * @return
	 */
	@RequestMapping("/togetcorpcontantList")  
	@ResponseBody
    public Map<String,Object> togetcorpcontantList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "corpCode", defaultValue = "") String corpCode
    		){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("corpcode", corpCode);
		List<CorpContant> lsit = corpProjectService.getAllCorpContantByCropCode(conMap);
		
		int total = corpProjectService.getCorpProjectCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取合作公司联系人成功");
		resultMap.put("contantlist", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 新增合作公司项目
	 * @param corpCode
	 * @param corpProjectName
	 * @param starttime
	 * @param endtime
	 * @param usercode
	 * @return
	 */
	@RequestMapping("/saveCorpProject")  
	@ResponseBody
	public Map<String,Object> saveCorpProject(
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "corpProjectName", defaultValue = "") String corpProjectName,
			@RequestParam(value = "starttime", defaultValue = "") String starttime,
			@RequestParam(value = "endtime", defaultValue = "") String endtime,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		CorpProject info = new CorpProject();
		info.setCorpprojectcode(SerialNumber.createSerial("cstm", 6));
		info.setCorpcode(corpCode);
		info.setCorpprojectname(corpProjectName);
		info.setProjectstartdate(sdf.parse(starttime));
		info.setProjectenddate(sdf.parse(endtime));
		//User user = (User) request.getSession().getAttribute("user");
		//info.setOpercode(user.getUsercode());
		info.setOpercode(usercode);
		info.setOpertime(new Date());
		if(corpProjectService.insertCorpProject(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加公司项目信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加公司项目信息失败");
		}
		return resultMap;
	}
	
	
	/**
	 * 新增合作公司联系人
	 * @param corpCode
	 * @param ContanName
	 * @param ContTel
	 * @param ConPhone
	 * @param ContOfficeTel
	 * @param QQ
	 * @param WeiXin
	 * @param Remark
	 * @return
	 */
	@RequestMapping("/savecorpcontant")  
	@ResponseBody
	public Map<String,Object> savecorpcontant(
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "ContanName", defaultValue = "") String ContanName,
			@RequestParam(value = "ContTel", defaultValue = "") String ContTel,
			@RequestParam(value = "ConPhone", defaultValue = "") String ConPhone,
			@RequestParam(value = "ContOfficeTel", defaultValue = "") String ContOfficeTel,
			@RequestParam(value = "QQ", defaultValue = "") String QQ,
			@RequestParam(value = "WeiXin", defaultValue = "") String WeiXin,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CorpContant con= new CorpContant();
		con.setId(SerialNumber.createSerial("cstm", 6));
		con.setCorpcode(corpCode);
		con.setContanname(ContanName);
		con.setConttel(ContTel);
		con.setConphone(ConPhone);
		con.setContofficetel(ContOfficeTel);
		con.setQq(QQ);
		con.setWeixin(WeiXin);
		con.setRemark(Remark);
//		User user = (User) request.getSession().getAttribute("user");
//		con.setOpercode(user.getUsercode());
		con.setOpercode(usercode);
		con.setOpertime(new Date());
		
		if(corpProjectService.insertCorpContant(con)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加公司项目联系人成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加公司项目联系人失败");
		}
		return resultMap;
	}
	
	
	/**
	 * 修改合作公司联系人
	 * @param corpCode
	 * @param ContanName
	 * @param ContTel
	 * @param ConPhone
	 * @param ContOfficeTel
	 * @param QQ
	 * @param WeiXin
	 * @param Remark
	 * @return
	 */
	@RequestMapping("modifyCorpcontent")
	@ResponseBody
	public Map<String,Object> modifyCorpcontent(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "corpCode", defaultValue = "") String corpCode,
			@RequestParam(value = "ContanName", defaultValue = "") String ContanName,
			@RequestParam(value = "ContTel", defaultValue = "") String ContTel,
			@RequestParam(value = "ConPhone", defaultValue = "") String ConPhone,
			@RequestParam(value = "ContOfficeTel", defaultValue = "") String ContOfficeTel,
			@RequestParam(value = "QQ", defaultValue = "") String QQ,
			@RequestParam(value = "WeiXin", defaultValue = "") String WeiXin,
			@RequestParam(value = "Remark", defaultValue = "") String Remark,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			HttpServletRequest request,HttpServletResponse response
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		CorpContant con= corpProjectService.getcorpcontantById(id);
		con.setCorpcode(corpCode);
		con.setContanname(ContanName);
		con.setConttel(ContTel);
		con.setConphone(ConPhone);
		con.setContofficetel(ContOfficeTel);
		con.setQq(QQ);
		con.setWeixin(WeiXin);
		con.setRemark(Remark);
//		User user = (User) request.getSession().getAttribute("user");
//		con.setOpercode(user.getUsercode());
		con.setOpercode(usercode);
		con.setOpertime(new Date());
		
		int c=corpProjectService.updatecorpcontant(con);
		if(c>=0){
			resultMap.put("status", 0);
			resultMap.put("msg", "修改成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "修改失败");
		}
			return resultMap;
	}
	
	
	/**
	 * 删除合作公司项目联系人
	 * @param page
	 * @param pageSize
	 * @param usercode
	 * @return
	 */
	@RequestMapping("/deletecontent")  
	@ResponseBody
	public Map<String,Object> deletecontent(
			@RequestParam(value = "Id", defaultValue = "") String Id
			) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int c=corpProjectService.deletecontent(Id);
		if(c>=0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "删除失败");
		}
			return resultMap;
	}
	
	
	/**
	 * 获取权限列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/rightsList")  
	@ResponseBody
    public Map<String,Object> rightsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "searchrightid", defaultValue = "") String searchrightid,
    		@RequestParam(value = "searchrightname", defaultValue = "") String searchrightname,
    		@RequestParam(value = "searchParentRightId", defaultValue = "") String searchParentRightId
    		) throws UnsupportedEncodingException{
		searchrightname = URLDecoder.decode(searchrightname,"UTF-8");
		Map<String,Object> conMap= new HashMap<String,Object>();
		List<Rights> allrightList = rightsService.getAllRights(conMap);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		if(searchrightid!=null && !"".equals(searchrightid)){
			conMap.put("rightid", searchrightid);
		}
		if(searchrightname!=null && !"".equals(searchrightname)){
			conMap.put("rightname", searchrightname);
		}
		if(searchParentRightId!=null && !"".equals(searchParentRightId)){
			conMap.put("parentRightid", searchParentRightId);
		}
		
		List<Rights> lsit = rightsService.getAllRights(conMap);
		int total = rightsService.getAllRightsCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		for (int i = 0; i < allrightList.size(); i++) {
			if (allrightList.get(i).getParentid()==null) {
				allrightList.get(i).setParentid("");
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取权限列表成功");
		resultMap.put("allrightList", allrightList);
		resultMap.put("rightlist", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 获取用户组信息
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/groupList")  
	@ResponseBody
    public Map<String,Object> rightsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Group> lsit = groupService.getAllGroup(conMap);
		int total = groupService.getAllGroupCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取用户组信息成功");
		resultMap.put("grouplist", lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 获取用户绑定的用户组
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/userGroupList")  
	@ResponseBody
    public Map<String,Object> userGroupList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("userstatus", 2);
		List<User> userList = userService.queryCurList(conMap);
		
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Group> groupList = groupService.getGroupList();
		List<UserGroup> userGroupList = new ArrayList<UserGroup>();
		if(userList!=null && userList.size()>0){
			User user = userList.get(0);
			userGroupList = userGroupService.getUserGroupListByUserCode(user.getUsercode());
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		resultMap.put("status", 0);
		resultMap.put("msg", "获取用户绑定的用户组成功");
		resultMap.put("list1", userList);
		resultMap.put("list2", groupList);
		resultMap.put("list3", userGroupList);
		return resultMap;
	}
	
	
	/**
	 * 获取账号
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toAccount")  
	@ResponseBody
    public Map<String, Object> toAccount(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		List<AccountArea> list = accountsService.selaccount(acMap);
		List<Areas> areasList = areasService.getAreaList();
		List<ResumeSource>  resumeList= resumeSourceService.getResumeSourseList();
		int total = accountsService.getAllAreasCount(acMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取账号数量成功");
		resultMap.put("areasList",areasList);
		resultMap.put("resumeList", resumeList);
		resultMap.put("accountList", list);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 添加或修改账号
	 * @param page
	 * @param aid
	 * @param account
	 * @param strarttime
	 * @param endtime
	 * @param quantity
	 * @param accountCity
	 * @param resumesourceid
	 * @return
	 */
	@RequestMapping("/saveAccount")  
	@ResponseBody
    public Map<String, Object> saveAccount(
    		@RequestParam(value = "aid", defaultValue = "") int aid,
    		@RequestParam(value = "account", defaultValue = "") String account,
    		@RequestParam(value = "strarttime", defaultValue = "") String strarttime,
    		@RequestParam(value = "endtime", defaultValue = "") String endtime,
    		@RequestParam(value = "quantity", defaultValue = "") int quantity,
    		@RequestParam(value = "accountCity", defaultValue = "") String accountCity,
    		@RequestParam(value = "resumesourceid", defaultValue = "") int resumesourceid
    		) throws UnsupportedEncodingException{
		ResultObject result = ResultObject.getResultObject();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Accounts accounts = new Accounts();
			accounts.setAid(aid);
			accounts.setAccount(account);
			accounts.setStrarttime(sdf.parse(strarttime));
			accounts.setEndtime(sdf.parse(endtime));
			accounts.setQuantity(quantity);
			accounts.setAccountCity(accountCity);
			accounts.setResumesourceid(resumesourceid);
			if(accounts != null){
				int i = 0;
				if(accounts.getAid() != null && accounts.getAid()!=0){
					//update
					i = accountsService.update(accounts);
				}else{
					//insert
					i = accountsService.save(accounts);
				}
				result.setResultData(i);
				if(i>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "保存成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "保存失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", 1);
			resultMap.put("msg", "保存失败");
			resultMap.put("resultMessage", e.getMessage());
		}
		return resultMap;
	}
	
	
	/**
	 * 获取简历来源
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/resumeSourceList")  
	@ResponseBody
    public Map<String,Object> resumeSourceList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<ResumeSource> lsit = resumeSourceService.getAllResumeSource(conMap);
		int total = resumeSourceService.getAllResumeSourceCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取简历来源成功");
		resultMap.put("sourceList",lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 参数种类
	 * @param page
	 * @param pageSize
	 * @param searchname
	 * @return
	 */
	@RequestMapping("/paraKindList")  
	@ResponseBody
    public Map<String, Object> paraKindList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "searchid", defaultValue = "0") Long searchid,
    		@RequestParam(value = "searchname", defaultValue = "") String searchname
    		){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		if(searchid!=null && searchid!=0){
			conMap.put("parakindid", searchid);
		}
		if(searchname!=null && !"".equals(searchname)){
			conMap.put("parakindname", searchname);
		}
		List<ParameterKind> lsit = parameterKindService.getAllParameterKind(conMap);
		int total = parameterKindService.getAllParameterKindCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取参数种类成功");
		resultMap.put("paraKindList",lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	

	/**
	 * 获取基本参数二级分类
	 * @param page
	 * @param pageSize
	 * @param searchname
	 * @return
	 */
	@RequestMapping("/parasList")  
	@ResponseBody
    public Map<String, Object> parasList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "parakindid", defaultValue = "0") Long parakindid,
    		@RequestParam(value = "searchid", defaultValue = "0") Long searchid,
    		@RequestParam(value = "searchname", defaultValue = "") String searchname
    		){
		Map<String,Object> conMap= new HashMap<String,Object>();
		List<ParameterKind> paraKindlsit = parameterKindService.getAllParameterKind(conMap);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("parakindid", parakindid);
		
		if(searchid!=null && searchid!=0){
			conMap.put("id", searchid);
		}
		if(searchname!=null && !"".equals(searchname)){
			conMap.put("name", searchname);
		}
		
		List<Parameter> lsit = parameterService.getAllParameter(conMap);
		int total = parameterService.getAllParameterCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取基本参数二级分类成功");
		resultMap.put("parasList",lsit);
		resultMap.put("paraKindlsit",paraKindlsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 级别管理列表
	 * @return
	 */
	@RequestMapping("/gradeManage")
	@ResponseBody
	public Map<String,Object> gradeManage(
			@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> rmap = gradeService.getGradeByPage((page-1)*pageSize,page, pageSize);
		rmap.put("status", 0);
		rmap.put("msg", "获取级别管理列表成功");
		return rmap;
	}
	
	
	/**
	 * 技术方向维护
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/toProfession")  
	@ResponseBody
    public Map<String, Object> toProfession(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Profession> lsit = professiService.getAllProfess(conMap);
		
		int total = professiService.getAllProfessCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取技术方向列表成功");
		resultMap.put("professionList",lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 离职人员管理
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/demisssionList")  
	@ResponseBody
    public Map<String, Object> demisssionList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		conMap.put("userstatus", 2);
		List<User> lsit = userService.queryDessionList(conMap);
		int total = userService.queryDessionListCount(conMap);
		
		
		//在职人员列表
		List<User> curuser = userService.queryCurList(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取离职人员列表成功");
		resultMap.put("list",lsit);
		resultMap.put("curList", curuser);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 物品管理
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/itemsList")  
	@ResponseBody
    public Map<String, Object> itemsList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Map<String,Object>> lsit = itemsService.getAllItems(conMap);
		int total = itemsService.getAllItemsCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取物品列表成功");
		resultMap.put("itemsList",lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 在线客服管理
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/servicerOnLineList") 
	@ResponseBody
    public Map<String, Object> servicerOnLineList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "serviceName", defaultValue = "") String serviceName,
			@RequestParam(value = "qQ", defaultValue = "") String qQ,
			@RequestParam(value = "weiXin", defaultValue = "") String weiXin) throws UnsupportedEncodingException{
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		serviceName = URLDecoder.decode(serviceName, "UTF-8");
		qQ = URLDecoder.decode(qQ, "UTF-8");
		weiXin = URLDecoder.decode(weiXin, "UTF-8");
		
		if(serviceName!=null && !"".equals(serviceName)){
			conMap.put("serviceName", serviceName);
		}
		if(qQ!=null && !"".equals(qQ)){
			conMap.put("qQ", qQ);
		}
		if(weiXin!=null && !"".equals(weiXin)){
			conMap.put("weiXin", weiXin);
		}
		
		List<ServicerOnLine> lsit = servicerOnLineService.getAllServicerOnLine(conMap);		
		int total = servicerOnLineService.getAllServicerOnLineCount(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		for (int i = 0; i < lsit.size(); i++) {
			lsit.get(i).setQq(lsit.get(i).getqQ());
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "获取在线客服列表成功");
		resultMap.put("onlineList",lsit);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("total", total);
		return resultMap;
	}
	
	
	/**
	 * 修改和添加在线客服
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/saveServicerOnLine")  
	@ResponseBody
	public Map<String,Object> saveServicerOnLine(
			@RequestParam(value = "id", defaultValue = "") String id,
			@RequestParam(value = "serviceName", defaultValue = "") String serviceName,
			@RequestParam(value = "qQ", defaultValue = "") String qQ,
			@RequestParam(value = "weiXin", defaultValue = "") String weiXin,
			HttpServletRequest request,HttpServletResponse response
			) throws UnsupportedEncodingException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//查询服务名称、qq是否存在
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("serviceName", serviceName);	
		int count = 0;
		if(id!=null && !"".equals(id) && !"0".equals(id)){
			conMap.put("id", id);	
			count = servicerOnLineService.getAllServicerOnLineCount(conMap);
		}
		if(count>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "该在线客服名称已存在");
		}else{
			conMap.remove("serviceName");
			conMap.put("qQ", qQ);
			if(id!=null && !"".equals(id) && !"0".equals(id)){
				conMap.put("id", id);	
				count = servicerOnLineService.getAllServicerOnLineCount(conMap);
			}
			if(count>0){
				resultMap.put("status", 1);
				resultMap.put("msg", "该QQ已存在");
			}else{
				ServicerOnLine info = new ServicerOnLine();
				if(id!=null && !"".equals(id) && !"0".equals(id)){
					info = servicerOnLineService.getServicerOnLineById(id);
				}else{
					info.setId(SerialNumber.createSerial("sol",4));
				}				
				info.setqQ(qQ);
				info.setReMark("");
				info.setServiceName(serviceName);
				info.setServicerStatus(1);
				info.setWeiXin(weiXin);
				int resultcount = 0;
				if(id!=null && !"".equals(id) && !"0".equals(id)){
					resultcount = servicerOnLineService.updateServicerOnLine(info);
				}else{
					resultcount = servicerOnLineService.insertServicerOnLine(info);
				}
				if(resultcount>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "添加/更新在线客服信息成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "添加/更新在线客服信息失败");
				}
			}
		}
		return resultMap;
	}
	
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/effectiveServicerOnLine")
	@ResponseBody
	public Map<String, Object> effectiveServicerOnLine(String id){
		ResultObject result = ResultObject.getResultObject();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(id!=null && !"".equals(id)){
				ServicerOnLine info = servicerOnLineService.getServicerOnLineById(id);
				info.setServicerStatus(1);
				int i = servicerOnLineService.updateServicerOnLine(info);
				result.setResultData(i);
				if(i>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "启用成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "启用失败");
				}
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "启用失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", 1);
			resultMap.put("msg", "启用失败");
			result.setResultMessage(e.getMessage());
		}
		return resultMap;
	}
	
	/**
	 * 不启用
	 * @param id
	 * @return
	 */
	@RequestMapping("/invalidServicerOnLine")
	@ResponseBody
	public Map<String, Object> invalidServicerOnLine(String id){
		ResultObject result = ResultObject.getResultObject();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(id!=null && !"".equals(id)){
				ServicerOnLine info = servicerOnLineService.getServicerOnLineById(id);
				info.setServicerStatus(2);
				int i = servicerOnLineService.updateServicerOnLine(info);
				result.setResultData(i);
				if(i>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "禁用成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "禁用失败");
				}
			}else{
				resultMap.put("status", 1);
				resultMap.put("msg", "禁用失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", 1);
			resultMap.put("msg", "禁用失败");
			result.setResultMessage(e.getMessage());
		}
		return resultMap;
	}
	
	
	/**
	 * 获取录入信息需要的参数
	 * @return
	 */
	@RequestMapping("/addCustomerInfo")  
	@ResponseBody
    public Map<String, Object> addCustomerInfo(
    		@RequestParam(value = "usercode", defaultValue = "") String usercode,
    		HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("taskList", taskService.queryTaskAllotByUser(usercode));
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		resultMap.put("accountList", accountsService.selectUsableAccount());		
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		resultMap.put("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		resultMap.put("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		resultMap.put("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		resultMap.put("status", 0);
		resultMap.put("msg", "查詢成功");
		return resultMap;
		
	}

	
	/**
	 * 录入信息
	 * @return
	 */
	@RequestMapping("/saveCustomerInfo")  
	@ResponseBody
	synchronized public ReturnDate saveCustomerInfo(
			/*@RequestParam(value = "taskid", defaultValue = "") String taskallotid,*/
			@RequestParam(value = "customername", defaultValue = "") String customername,
			@RequestParam(value = "customersex", defaultValue = "0") Integer customersex,
			@RequestParam(value = "areaid", defaultValue = "0") String areaid,
			@RequestParam(value = "customertel", defaultValue = "") String customertel,
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,
			@RequestParam(value = "resumeupdatedate", defaultValue = "") String resumeupdatedate,
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,
			@RequestParam(value = "relationshipbyzq", defaultValue = "0") Integer relationshipbyzq,
			@RequestParam(value = "memo", defaultValue = "") String memo,
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,
			@RequestParam(value = "entryprobability", defaultValue = "0") Integer entryprobability,
			@RequestParam(value = "resumepath", defaultValue = "") String resumepath,
			@RequestParam(value = "zqentrytime", defaultValue = "") String zqentrytime,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "expectationSalary", defaultValue = "0") Integer expectationSalary,
			@RequestParam(value = "professionId", defaultValue = "") String professionId,
			
			@RequestParam(value = "education", defaultValue = "") Long education,
			@RequestParam(value = "englishLevel", defaultValue = "") Long englishLevel,
			@RequestParam(value = "japaneseLevel", defaultValue = "") Long japaneseLevel,
			@RequestParam(value = "directWorkLife", defaultValue = "") Double directWorkLife,
			@RequestParam(value = "prolist", defaultValue = "") String prolist,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			HttpServletRequest request,HttpServletResponse response
			) throws Exception{
		ReturnDate data =  new ReturnDate();
		List<CustomerProject> proListArr = new ArrayList<CustomerProject>();
		if(!"[]".equals(prolist)){
			Map<String,String> postData = new HashMap<String,String>();
			proListArr = JSON.parseArray(prolist, CustomerProject.class);
		}
		
		
		//int telcount = customerInfoService.queryDetailsCountByTel(customertel);
		HashMap<String, Object> paras = new HashMap<String, Object>();
		paras.put("resumeid", resumeid);			
		paras.put("customertel", customertel);
		//paras.put("customername", customername);
		//paras.put("lastprojectname", lastprojectname);
		int count = customerInfoService.getSameCustomerCount(paras);
		if(count>0){
			data.setStatus(1);
			data.setMsg("客户信息已存在！");
			return data;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			java.util.Date addtime = new Date();
			CustomerInfo customerinfo = new CustomerInfo();
			customerinfo.setCustomercode(SerialNumber.createSerial("cstm", 5));
			customerinfo.setCustomername(customername.replaceAll(" +",""));
			customerinfo.setCustomersex(customersex);
			customerinfo.setAreaid(areaid);
			customerinfo.setCustomertel(customertel.replaceAll(" +",""));
			customerinfo.setAccount(account);
			customerinfo.setCustomerbirth(sdf.parse(customerbirth.replaceAll(" +","")));
			customerinfo.setCustomeruniversity(customeruniversity.replaceAll(" +",""));
			customerinfo.setCustomerspecialities(customerspecialities.replaceAll(" +",""));
			if(!entrytime.equals("")){//如果入职时间为空
				customerinfo.setEntrytime(sdf.parse(entrytime.replaceAll(" +","")));
			}
			customerinfo.setResumesource(resumesource);
			customerinfo.setResumeid(resumeid.replaceAll(" +",""));
			customerinfo.setResumeupdatedate(sdf.parse(resumeupdatedate.replaceAll(" +","")));
			if(!lastvcompanyname.equals("")){//如果最近公司名称为空
				customerinfo.setLastvcompanyname(lastvcompanyname.replaceAll(" +",""));
			}
			customerinfo.setTechnicalexpertise(technicalexpertise);
			if(!lastprojectname.equals("")){//如果最近项目名称为空
				customerinfo.setLastprojectname(lastprojectname.replaceAll(" +",""));
			}	
			customerinfo.setRelationshipbyzq(relationshipbyzq);
			customerinfo.setMemo(memo.replaceAll(" +",""));
			customerinfo.setRelationshipbyzh(relationshipbyzh);
			customerinfo.setEntryprobability(entryprobability);
			customerinfo.setResumepath(resumepath);
			if(!zqentrytime.equals("")){
				customerinfo.setZqentrytime(sdf.parse(zqentrytime));
			}
			customerinfo.setAddtime(addtime);
//			User user = (User) request.getSession().getAttribute("user");
			User user = loginUserService.sltUser(usercode);
			customerinfo.setOpertcode(user.getUsercode());
			customerinfo.setOpertname(user.getRealname());
			customerinfo.setLastconttime(addtime);
			customerinfo.setLastupdatestatic(5);
			customerinfo.setExpectationSalary(expectationSalary);
			customerinfo.setProfessionId(professionId);
			customerinfo.setEducation(education);
			customerinfo.setEnglishLevel(englishLevel);
			customerinfo.setJapaneseLevel(japaneseLevel);
			customerinfo.setDirectWorkLife(directWorkLife);
			
			if(/*taskService.saveInter(taskallotid,customerinfo.getCustomercode()) && */customerInfoService.saveNewCustomerInfo(customerinfo, proListArr)>0){
				data.setStatus(0);
				data.setMsg("添加成功！");
				return data;
			}else{
				data.setStatus(1);
				data.setMsg("添加客户信息失败！");
				return data;
			}
		}
	}
	
	
	/**
	 * 兼职人员打开录入界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/partaddCustomerInfo")  
	@ResponseBody
    public Map<String, Object> partaddCustomerInfo(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		resultMap.put("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		resultMap.put("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		resultMap.put("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		return resultMap;
	}
	/**
	 * 兼职人员录入信息
	 * 
	 */
	@RequestMapping("/partsaveCustomerInfo")  
	@ResponseBody
	synchronized public ReturnDate partsaveCustomerInfo(
			/*@RequestParam(value = "taskid", defaultValue = "") String taskallotid,*/
			@RequestParam(value = "customername", defaultValue = "") String customername,
			@RequestParam(value = "customersex", defaultValue = "0") Integer customersex,
			@RequestParam(value = "areaid", defaultValue = "0") String areaid,
			@RequestParam(value = "customertel", defaultValue = "") String customertel,
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,
			@RequestParam(value = "resumeupdatedate", defaultValue = "") String resumeupdatedate,
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,
			@RequestParam(value = "relationshipbyzq", defaultValue = "0") Integer relationshipbyzq,
			@RequestParam(value = "memo", defaultValue = "") String memo,
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,
			@RequestParam(value = "entryprobability", defaultValue = "0") Integer entryprobability,
			@RequestParam(value = "resumepath", defaultValue = "") String resumepath,
			@RequestParam(value = "zqentrytime", defaultValue = "") String zqentrytime,
			@RequestParam(value = "account", defaultValue = "") String account,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			@RequestParam(value = "expectationSalary", defaultValue = "0") Integer expectationSalary,
			HttpServletRequest request,HttpServletResponse response
			) throws ParseException{
		ReturnDate data =  new ReturnDate();
		HashMap<String, Object> paras = new HashMap<String, Object>();
		paras.put("resumeid", customertel);			
		paras.put("customertel", customertel);
		int count = customerInfoService.getSameCustomerCount(paras);
		if(count>0){
			data.setStatus(1);
			data.setMsg("客户信息已存在！");
			return data;
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
			java.util.Date addtime = new Date();
			CustomerInfo customerinfo = new CustomerInfo();
			customerinfo.setCustomercode(SerialNumber.createSerial("cstm", 5));
			customerinfo.setCustomername(customername.replaceAll(" +",""));
			customerinfo.setCustomersex(customersex);
			customerinfo.setAreaid(areaid);
			customerinfo.setAccount(account);
			customerinfo.setCustomertel(customertel.replaceAll(" +",""));
			customerinfo.setCustomerbirth(sdf.parse(customerbirth.replaceAll(" +","")));
			customerinfo.setCustomeruniversity(customeruniversity.replaceAll(" +",""));
			customerinfo.setCustomerspecialities(customerspecialities.replaceAll(" +",""));
			if(!entrytime.equals("")){//如果入职时间为空
				customerinfo.setEntrytime(sdf.parse(entrytime.replaceAll(" +","")));
			}
			customerinfo.setResumesource(resumesource);
			customerinfo.setResumeid(customertel.replaceAll(" +",""));
			customerinfo.setResumeupdatedate(sdf.parse(resumeupdatedate.replaceAll(" +","")));
			if(!lastvcompanyname.equals("")){//如果最近公司名称为空
				customerinfo.setLastvcompanyname(lastvcompanyname.replaceAll(" +",""));
			}
			customerinfo.setTechnicalexpertise(technicalexpertise);
			if(!lastprojectname.equals("")){//如果最近项目名称为空
				customerinfo.setLastprojectname(lastprojectname.replaceAll(" +",""));
			}	
			customerinfo.setRelationshipbyzq(relationshipbyzq);
			customerinfo.setMemo(memo.replaceAll(" +",""));
			customerinfo.setRelationshipbyzh(relationshipbyzh);
			customerinfo.setEntryprobability(entryprobability);
			customerinfo.setResumepath(resumepath);
			if(!zqentrytime.equals("")){
				customerinfo.setZqentrytime(sdf.parse(zqentrytime));
			}
			customerinfo.setAddtime(addtime);
			//User user = (User) request.getSession().getAttribute("user");
			User user = loginUserService.sltUser(usercode);
			customerinfo.setOpertcode(user.getUsercode());
			customerinfo.setOpertname(user.getRealname());
			customerinfo.setLastconttime(addtime);
			customerinfo.setLastupdatestatic(5);
			customerinfo.setExpectationSalary(expectationSalary);
			
			if(/*taskService.saveInter(taskallotid,customerinfo.getCustomercode()) && */customerInfoService.saveCustomerInfo(customerinfo)>0){
				data.setStatus(0);
				data.setMsg("添加成功！");
				return data;
			}else{
				data.setStatus(1);
				data.setMsg("添加客户信息失败！");
				return data;
			}
		}
	}
	
	
	/**
	 * 根据code查询用户
	 * @return
	 */
	@RequestMapping("/UserList")  
	@ResponseBody
    public Map<String, Object> UserList(
    		@RequestParam(value = "usercode", defaultValue = "") String usercode
    		){
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("usercode", usercode);
		List<User> lsit = loginUserService.gettUser(conMap);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "查询成功");
		resultMap.put("list",lsit);
		return resultMap;
	}
	
	
	/**
	 * 跳转查询页面时需要的参数(简历出处)
	 * @return
	 */
	@RequestMapping("/inquiry")
	@ResponseBody
	public Map<String, Object> inquiry(HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "查询成功");
		resultMap.put("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		return resultMap;
	}
	
	
	/**
	 * 查询页面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/DocustomerInfo")
	@ResponseBody
	public Map<String, Object> DocustomerInfo(
			@RequestParam(value = "page", defaultValue = "1") int page, 
			@RequestParam(value = "pageSize", defaultValue = "10") int pageSize, 
			@RequestParam(value = "customername", defaultValue = "") String customername,  //'客户姓名',
			@RequestParam(value = "customersex", defaultValue = "-1") Integer customersex,  //'客户性别（0-男，1-女）',
			@RequestParam(value = "customertel", defaultValue = "") String customertel,  //'联系电话',
			@RequestParam(value = "customerbirth", defaultValue = "") String customerbirth,  //'出生日期',
			@RequestParam(value = "customeruniversity", defaultValue = "") String customeruniversity,  //'毕业院校',
			@RequestParam(value = "customerspecialities", defaultValue = "") String customerspecialities,  //'所学专业',
			@RequestParam(value = "entrytime", defaultValue = "") String entrytime,  //'入职时间',
			@RequestParam(value = "resumesource", defaultValue = "0") Integer resumesource,  //  '简历来源（1-51JOb，2-智联,3-其他）',
			@RequestParam(value = "resumeid", defaultValue = "") String resumeid,  //'简历ID',
			@RequestParam(value = "lastvcompanyname", defaultValue = "") String lastvcompanyname,   //'最近公司名称',
			@RequestParam(value = "lastprojectname", defaultValue = "") String lastprojectname,    //'最近项目名称',
			@RequestParam(value = "technicalexpertise", defaultValue = "") String technicalexpertise,   // '技术特长',
			@RequestParam(value = "relationshipbyzq", defaultValue = "") Integer relationshipbyzq,  //'与梓钦关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系）',
			@RequestParam(value = "relationshipbyzh", defaultValue = "0") Integer relationshipbyzh,  //'与郑州公司关系（1-已离职、2-在职、3-提交简历未通过、4-待入职、5-无关系）',
			@RequestParam(value = "entryprobability", defaultValue = "") Integer entryprobability,    //'入职概率',
			@RequestParam(value = "lastupdatestatic", defaultValue = "") Integer lastupdatestatic,    //'入职概率',
			HttpServletRequest request) throws UnsupportedEncodingException{
		customername = URLDecoder.decode(customername, "UTF-8");
		customertel = URLDecoder.decode(customertel, "UTF-8");
		customeruniversity = URLDecoder.decode(customeruniversity, "UTF-8");
		customerspecialities = URLDecoder.decode(customerspecialities, "UTF-8");
		lastprojectname = URLDecoder.decode(lastprojectname, "UTF-8");
		resumeid = URLDecoder.decode(resumeid, "UTF-8");
		technicalexpertise = URLDecoder.decode(technicalexpertise, "UTF-8");
		if(customersex==-1){
			customersex=null;
		}
		Map<String, Object> map=customerinfoService.CustomerInfoList(page, pageSize, customername.replaceAll(" +",""), customersex, 
				customertel.replaceAll(" +",""), customerbirth.replaceAll(" +",""), customeruniversity.replaceAll(" +",""), customerspecialities.replaceAll(" +",""), entrytime.replaceAll(" +",""), resumesource, 
				resumeid.replaceAll(" +",""), lastvcompanyname.replaceAll(" +",""), lastprojectname.replaceAll(" +",""), technicalexpertise.replaceAll(" +",""), relationshipbyzq, relationshipbyzh, entryprobability,lastupdatestatic);
		if (request.getQueryString() != null)  // 查询参数
			map.put("dataQuery", "?" + request.getQueryString());
		//request.getSession().getAttribute("user");
		//map.addAllObjects(map);
		return map;
	}
	
	
	/**
	 * 客户详细信息
	 * @param customercode
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("/toCustomerDatailInfo")  
	@ResponseBody
    public Map<String, Object>  toCustomerDatailInfo(
    		@RequestParam(value = "customercode", defaultValue = "") String customercode,
    		@RequestParam(value = "usercode", defaultValue = "") String usercode,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) {  
		Map<String, Object> resultMap = new HashMap<String, Object>();
//		User user = (User) request.getAttribute("user");
		User user = loginUserService.sltUser(usercode);
		if(user != null){
			resultMap.put("user", user);
		}
		log.info("开始查询客户详细信息");
		CustomerInfo info = customerDetailService.getCustomerinfoByCode(customercode);
		log.info("开始查询客户更新列表信息");
		Map<String,Object> map = customerContlService.getContactDateByCustomerCode(customercode,page,pageSize);
		//resultMap.put("map",map);
		resultMap.put("currpage", map.get("currpage"));
		resultMap.put("customercode", map.get("customercode"));
		resultMap.put("list", map.get("list"));
		resultMap.put("page", map.get("page"));
		resultMap.put("pageSize", map.get("pageSize"));
		resultMap.put("tatalpage", map.get("tatalpage"));
		resultMap.put("total", map.get("total"));
		
		resultMap.put("customerInfo", info);
		resultMap.put("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
		resultMap.put("arealist", areasService.getAreaList());
		
		
		log.info("开始查询客户项目经验信息");
		Map<String,Object> promap = customerProjectService.getCustProByCustomerCode(customercode);
		resultMap.put("prolist", promap.get("list"));
		
		
		
		String contextPath = request.getSession().getServletContext().getRealPath("/");
		String path = contextPath.substring(0, contextPath.lastIndexOf("\\"))+info.getResumepath();
		String realPath = path.replaceAll("\\\\", "/");
		String pdfpath = "";
		if(info.getResumepath()!=null && !"".equals(info.getResumepath())){
			pdfpath = contextPath.substring(0, contextPath.lastIndexOf("\\"))+"/shzqoa/fileUpload"+info.getResumepath().substring(info.getResumepath().lastIndexOf("/"),info.getResumepath().lastIndexOf("."))+".pdf";
		}
		
		/**
		 * 判断转换的文件是否存在
		 */
		if(pdfpath!=null && !"".equals(pdfpath)){
			File pdffile = new File(pdfpath);
			if(pdffile.exists()){//文件存在
				resultMap.put("pdffilename", pdfpath.substring(pdfpath.indexOf("/shzqoa")));
			}else{
				log.info("开始进行转换");
				boolean flag = Word2PdfUtil.word2pdf(realPath, pdfpath.replaceAll("\\\\", "/"));
				if(!flag){
					map.put("status", 1);
					map.put("filename", "查看文档出错");
				}else{
					resultMap.put("pdffilename", pdfpath.substring(pdfpath.indexOf("/shzqoa")));
				}
			}
		}
		resultMap.put("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
		resultMap.put("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
		resultMap.put("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));		
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("prorolelist", parameterService.selectByName(ResourceUtil.PROROLE));
		resultMap.put("softenvlist", parameterService.selectByName(ResourceUtil.SOFTENVIRONMENT));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		
		resultMap.put("professionlist", professionService.queryAll());
		resultMap.put("accountlist", accountsService.selectaccount());
		
		//查询抢取的需求且绑定该简历的需求
		Map<String,Object> umap = new HashMap<String,Object>();
		umap.put("customercode", customercode);
		List<Map<String,Object>> delist = customerDemandService.stlDemandByBindUser(umap);
		resultMap.put("delist", delist);
		
        return resultMap;  
    }  
	
	
	/**
	 * 进入添加评价的页面
	 * @param customercode
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> eidt(String customercode,
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		CustomerInfo customerInfo=customerInfoService.selectByCustomercode(customercode);
		resultMap.put("customerInfo", customerInfo);
		resultMap.put("status", 0);
		resultMap.put("msg", "成功");
		return resultMap;
	}
	
	
	/**
	 * 执行添加评价的操作
	 * @param customercode
	 * @param comEvaluate
	 * @param proEvaluate
	 * @param synEvaluate
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("update")
	@ResponseBody
	public Map<String, Object> update(
			@RequestParam(value = "customercode", defaultValue = "") String customercode, 
			@RequestParam(value = "comEvaluate", defaultValue = "") int comEvaluate, 
			@RequestParam(value = "proEvaluate", defaultValue = "") int proEvaluate, 
			@RequestParam(value = "synEvaluate", defaultValue = "") int synEvaluate, 
			HttpServletRequest request,HttpServletResponse response) throws IOException{
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomercode(customercode);
		customerInfo.setComEvaluate(comEvaluate);
		customerInfo.setProEvaluate(proEvaluate);
		customerInfo.setSynEvaluate(synEvaluate);
		customerInfoService.updateEvaluate(customerInfo);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", 0);
		resultMap.put("msg", "修改成功");
		return resultMap;
	}
	
	
	/**
	 * 录入需求   需要的参数
	 * @return
	 */
	@RequestMapping("/addCustomerDemand")
	@ResponseBody
	public Map<String, Object> addCustomerDemand(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("corpList", corpService.getCorpList());
		resultMap.put("gradList",gradeService.queryAll());
		resultMap.put("imporList", parameterService.selectByName("重要程度"));
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("status", 0);
		resultMap.put("msg", "成功");
		return resultMap;			
	}
	
	
	/**
	 * 录入需求
	 * @param corpcode
	 * @param technologydirection
	 * @param demandyears
	 * @param education
	 * @param demandnumber
	 * @param specificrequirement
	 * @param projecttype
	 * @param projectlocation
	 * @param remarks
	 * @param state
	 * @param address
	 * @param importantlevel
	 * @param industry
	 * @param technicalRequirement
	 * @param directWorkLife
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/saveCustomerDemand") 
	@ResponseBody
	public Map<String, Object> saveCustomerDemand(
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
			@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
			@RequestParam(value = "education", defaultValue = "") String education,
			@RequestParam(value = "demandnumber", defaultValue = "") String demandnumber,
			@RequestParam(value = "specificrequirement", defaultValue = "") String specificrequirement,
			@RequestParam(value = "projecttype", defaultValue = "") String projecttype,
			@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
			//@RequestParam(value = "operationuser", defaultValue = "") String operationuser,
			@RequestParam(value = "remarks", defaultValue = "") String remarks,
			@RequestParam(value = "state", defaultValue = "0") Integer state,
			@RequestParam(value = "address", defaultValue = "0") String address,
			@RequestParam(value = "importantlevel", defaultValue = "0") Integer importantlevel,
			@RequestParam(value = "usercode", defaultValue = "") String usercode,
			@RequestParam(value = "industry", defaultValue = "") Long industry,
			@RequestParam(value = "technicalRequirement", defaultValue = "") String technicalRequirement,
			@RequestParam(value = "directWorkLife", defaultValue = "0") Double directWorkLife,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("corpcode", corpcode);
		map.put("technologydirection", technologydirection);
		map.put("demandyears", demandyears);
		map.put("projectlocation", projectlocation);
		map.put("projecttype", projecttype);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(customerDemandService.selectCount(map)!=0){
			resultMap.put("status", 0);
			resultMap.put("msg", "成功");
			return resultMap;
		}else{
		CustomerDemand cd = new CustomerDemand();
		cd.setId(SerialNumber.createSerial("demand", 5));
		cd.setCorpcode(corpcode);
		cd.setTechnologydirection(technologydirection);
		cd.setDemandyears(demandyears);
		cd.setEducation(education.replaceAll(" +",""));
		cd.setDemandnumber(demandnumber.replaceAll(" +",""));
		cd.setSpecificrequirement(specificrequirement.replace("\r\n", "<br/>"));
		cd.setProjecttype(projecttype);
		cd.setProjectlocation(projectlocation);
		//cd.setOperationuser(operationuser);
		cd.setRemarks(remarks.replace("\r\n", "<br/>"));
		cd.setState(state);
		cd.setAddress(address.replace("\r\n", "<br/>"));
		cd.setImportantlevel(importantlevel);
		//User user = (User) request.getSession().getAttribute("user");
		//cd.setOperationuser(user.getUsercode());
		cd.setOperationuser(usercode);
		cd.setAddtime(new Date());
		cd.setIndustry(industry);
		cd.setTechnicalRequirement(technicalRequirement);
		cd.setDirectWorkLife(directWorkLife);
		
		if(customerDemandService.insertCustomerDemand(cd)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "失败");
		}
		
		return resultMap;
		}
		
	}
	
	
	/**
	 * 修改需求时需要的参数
	 * @param custDemandId
	 * @param coper
	 * @return
	 */
	@RequestMapping("/editCustomerDemand")
	@ResponseBody
	public Map<String, Object> editCustomerDemand(
			@RequestParam(value = "custDemandId", defaultValue = "") String custDemandId,
			int coper
			){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("customerDemand",customerDemandService.selectById(custDemandId));
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("corpList", corpService.getCorpList());
		resultMap.put("gradList",gradeService.queryAll());
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("imporList", parameterService.selectByName("重要程度"));
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		resultMap.put("coper",coper);
		resultMap.put("status", 0);
		resultMap.put("msg", "成功");
		return resultMap;			
	}
	
	
	/**
	 * 修改需求
	 * @param custDemandId
	 * @param corpcode
	 * @param technologydirection
	 * @param demandyears
	 * @param education
	 * @param demandnumber
	 * @param specificrequirement
	 * @param projecttype
	 * @param projectlocation
	 * @param remarks
	 * @param state
	 * @param address
	 * @param importantlevel
	 * @param industry
	 * @param technicalRequirement
	 * @param directWorkLife
	 * @return
	 */
	@RequestMapping("/updateCustomerDemand") 
	@ResponseBody
	public Map<String, Object> updateCustomerDemand(
			@RequestParam(value = "custDemandId", defaultValue = "") String custDemandId,
			@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
			@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
			@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
			@RequestParam(value = "education", defaultValue = "") String education,
			@RequestParam(value = "demandnumber", defaultValue = "") String demandnumber,
			@RequestParam(value = "specificrequirement", defaultValue = "") String specificrequirement,
			@RequestParam(value = "projecttype", defaultValue = "") String projecttype,
			@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
			//@RequestParam(value = "operationuser", defaultValue = "") String operationuser,
			@RequestParam(value = "remarks", defaultValue = "") String remarks,
			@RequestParam(value = "state", defaultValue = "0") Integer state,
			@RequestParam(value = "address", defaultValue = "0") String address,
			@RequestParam(value = "importantlevel", defaultValue = "0") Integer importantlevel,
			@RequestParam(value = "industry", defaultValue = "") Long industry,
			@RequestParam(value = "technicalRequirement", defaultValue = "") String technicalRequirement,
			@RequestParam(value = "directWorkLife", defaultValue = "0") Double directWorkLife
			){
		CustomerDemand cd = customerDemandService.selectById(custDemandId);
		cd.setCorpcode(corpcode);
		cd.setTechnologydirection(technologydirection);
		cd.setDemandyears(demandyears);
		cd.setEducation(education.replaceAll(" +",""));
		cd.setDemandnumber(demandnumber.replaceAll(" +",""));
		cd.setSpecificrequirement(specificrequirement);
		cd.setProjecttype(projecttype);
		cd.setProjectlocation(projectlocation);
		//cd.setOperationuser(operationuser);
		cd.setRemarks(remarks);
		cd.setState(state);
		cd.setAddress(address);
		cd.setImportantlevel(importantlevel);
		cd.setIndustry(industry);
		cd.setDirectWorkLife(directWorkLife);
		cd.setTechnicalRequirement(technicalRequirement);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if(customerDemandService.updateCustomerDemand(cd)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "修改客户需求成功！");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "修改客户需求失败！");
		}
		
		return resultMap;
	}
	
	
	/**
	 * 需求列表页面
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @return
	 */
	@RequestMapping("/toCustDemandList")  
	@ResponseBody
    public Map<String, Object> toCustDemandList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears){
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		map.put("customername", customername);
		map.put("technologydirection", technologydirection);
		map.put("projectlocation", projectlocation);
		map.put("demandyears", demandyears);
		map.put("ocode", ocode);
		List<Profession> profession=professionService.queryAll();
		List<Areas> arealist=areasService.getAreaList();
		List<Grade> grade=gradeService.queryAll();
		List<CustDemand> custList=customerDemandService.selectDemand(map);
		/*List<CustomerInfo> userlist=customerinfoService.selectCuName();;*/
		int total=customerDemandService.selectDemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("corporList",corporateService.queryAll());
		resultMap.put("grade",grade);
		resultMap.put("profession",profession);
		resultMap.put("arealist", arealist);
		resultMap.put("customername",customername);
		resultMap.put("technologydirection",technologydirection);
		resultMap.put("projectlocation",projectlocation);
		resultMap.put("demandyears",demandyears);
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("custList", custList);
		/*mv.addObject("userlist", userlist);*/
		resultMap.put("userlist", userService.getAllUsers());
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		resultMap.put("status", 0);
		resultMap.put("msg", "获取需求列表成功！");
		return resultMap;
	}
	
	
	/**
	 * 绑定简历列表
	 * @param demandId
	 * @param customername
	 * @param customerphone
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/demandBindResumeList")
	@ResponseBody
    public Map<String, Object> demandBindResumeList(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customerphone", defaultValue = "") String customerphone,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		customername = URLDecoder.decode(customername, "UTF-8");
		demandId = URLDecoder.decode(demandId, "UTF-8");
		customerphone = URLDecoder.decode(customerphone, "UTF-8");
		resultMap.put("customername", customername);
		resultMap.put("demandId", demandId);
		resultMap.put("currpage", page);
		User user = (User) request.getSession().getAttribute("user");
		//根据需求查询当前用户已绑定简历信息		  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userCode", user.getUsercode());
		map.put("demandId", demandId);
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);		
		if(customername!=null && !"".equals(customername)){
			map.put("customername", customername);
		}
		if(customerphone!=null && !"".equals(customerphone)){
			map.put("customerphone", customerphone);
		}
		List<Map<String,Object>> list = customerInfoService.selectbindresumebydemand(map);
		int total = customerInfoService.selectbindresumebydemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("list", list);
		resultMap.put("status", 0);
		resultMap.put("msg", "获取绑定简历列表成功！");
		return resultMap;
	}
	
	
	/**
	 * 未绑定简历列表
	 * @param demandId
	 * @param customername
	 * @param customerphone
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/demandNoBindResumeList") 
	@ResponseBody
    public Map<String, Object> demandNoBindResumeList(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customerphone", defaultValue = "") String customerphone,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		customername = URLDecoder.decode(customername, "UTF-8");
		demandId = URLDecoder.decode(demandId, "UTF-8");
		customerphone = URLDecoder.decode(customerphone, "UTF-8");
		resultMap.put("customername", customername);
		resultMap.put("demandId", demandId);
		User user = (User) request.getSession().getAttribute("user");
		
		//查询未绑定
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userCode", user.getUsercode());
		map.put("demandId", demandId);
		if(customername!=null && !"".equals(customername)){
			map.put("customername", customername);
		}
		if(customerphone!=null && !"".equals(customerphone)){
			map.put("customerphone", customerphone);
		}
		
		
		List<Map<String,Object>> list = customerInfoService.selectnobindresumebydemand(map);
		int total = customerInfoService.selectnobindresumebydemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("list", list);
		resultMap.put("status", 0);
		resultMap.put("msg", "获取未绑定简历列表成功！");
		return resultMap;
	}
	
	
	/**
	 * 需求详细信息，及抢取/分配信息列表
	 * @param demandid
	 * @param managerflag
	 * @return
	 */
	@RequestMapping("/showdemanddetail")
	@ResponseBody
	public Map<String,Object> showdemanddetail(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			@RequestParam(value = "managerflag", defaultValue = "") Integer managerflag
			){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("customerDemand",customerDemandService.selectById(demandid));
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("corpList", corpService.getCorpList());
		resultMap.put("gradList",gradeService.queryAll());
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("imporList", parameterService.selectByName("重要程度"));
		resultMap.put("managerflag",managerflag);
		List<User> userlist = userService.getAllUsers();
		resultMap.put("userlist",userlist);
		
		//获取抢取信息
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		List<DemandSign> demandsignlist = demandSignService.selectDemandSignByMap(map);
		resultMap.put("demandsignlist",demandsignlist);
		resultMap.put("status", 0);
		resultMap.put("msg", "获取详细信息成功！");
		return resultMap;			
	}
	
	
	/**
	 * 需求列表页面
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @return
	 */
	@RequestMapping("/toDemandList") 
	@ResponseBody
    public Map<String, Object> toDemandList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		HttpServletRequest request
    		){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<Profession> profession=professionService.queryAll();
		List<Areas> arealist=areasService.getAreaList();
		List<Grade> grade=gradeService.queryAll();
		
		List<User> userlist = userService.getAllUsers();
		//查询未关闭的需求列表
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandstatus", 0);
		
		//查询当前登录用户所属组
		User user = (User) request.getSession().getAttribute("user");
		map.put("usercode", user.getUsercode());
		map.put("groupname", "人事管理员组");
		
		//查询当前用户已经抢取的需求列表
		List<CustDemand> binddemandlist = customerDemandService.selectSignDemandByUser(map);
		resultMap.put("binddemandlist",binddemandlist);
		
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(map);
		if(groups!=null && groups.size()>0){
			resultMap.put("managerflag", 1);
		}
		
		//查询人事组成员列表
		List<User> rsuserlist = userService.queryUsersByGroupName("人事");
		resultMap.put("rsuserlist",rsuserlist);
		
		map.remove("usercode");
		map.remove("groupname");
		
		if(corpcode!=null && !"".equals(corpcode)){
			map.put("corpcode", corpcode);
		}
		if(technologydirection!=null && !"".equals(technologydirection)){
			map.put("technologydirection", technologydirection);
		}
		if(projectlocation!=null && !"".equals(projectlocation)){
			map.put("areaid", projectlocation);
		}
		if(demandyears!=null && !"".equals(demandyears)){
			map.put("demandyears", demandyears);
		}
		if(ocode!=null && !"".equals(ocode)){
			map.put("ocode", ocode);
		}
		List<CustDemand> custList=customerDemandService.selectOpenDemand(map);
		int total=customerDemandService.selectOpenDemandCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("corporList",corporateService.queryAll());
		resultMap.put("grade",grade);
		resultMap.put("profession",profession);
		resultMap.put("arealist", arealist);
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("custList", custList);
		resultMap.put("userlist",userlist);
		resultMap.put("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		resultMap.put("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		resultMap.put("status", 0);
		resultMap.put("msg", "获取详细信息成功！");
		return resultMap;
	}
	
	
	/**
	 * 显示需求分配列表信息表
	 * @param demandid
	 */
	@RequestMapping("/showdemandsignlist")
	@ResponseBody
	public Map<String,Object> showdemandsignlist(
			@RequestParam(value = "demandid", defaultValue = "") String demandid){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<User> userlist = userService.getAllUsers();
		resultMap.put("userlist",userlist);
		
		//获取抢取信息
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		List<DemandSign> demandsignlist = demandSignService.selectDemandSignByMap(map);
		resultMap.put("demandsignlist",demandsignlist);
		resultMap.put("status", 0);
		resultMap.put("msg", "获取分配列表成功！");
		return resultMap;			
	}
	
	
	/**
	 * 分配需求
	 */
	@RequestMapping("/bindDemand")
	@ResponseBody
	public Map<String,Object> bindDemand(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			@RequestParam(value = "checkuser", defaultValue = "") String checkuser,
			HttpServletRequest request
			){
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		ResultObject result = ResultObject.getResultObject();		
		//User user = (User) request.getSession().getAttribute("user");
		User user = loginUserService.sltUser(checkuser);
		
		//确定需求是否已抢过，不能重复抢需求
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		map.put("usercode", checkuser);
		List<DemandSign> signlist = demandSignService.selectDemandSignByMap(map);
		if(signlist!=null && signlist.size()>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "抱歉！该需求您已经抢取/分配，无需再次分配！");
		}else{
			try {
				DemandSign info = new DemandSign();
				info.setId(SerialNumber.createSerial("desig", 5));
				info.setDemandId(demandid);
				info.setUserCode(checkuser);
				info.setSignedTime(new Date());
				
				//查询当前需求的最大顺序	
				Integer max = demandSignService.selectMaxIndexByDemand(demandid);
				if(max<=1){
					info.setSingnedIndex(max+1);
					info.setProportion(100);
				}else{
					info.setSingnedIndex(max+1);
					info.setProportion(100-(max-1)*5);
				}
				info.setSsigner(user.getUsercode());
				int res = demandSignService.insertDemandSign(info);
				result.setResultData(res);
				if(res>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "恭喜你，分配成功！");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "很遗憾！分配失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("status", 1);
				resultMap.put("msg", e.getMessage());
			}
		}
		return resultMap;
	}
	
	
	/**
	 * 抢取需求
	 */
	@RequestMapping("/grabDemand")
	@ResponseBody
	public Map<String, Object> grabDemand(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();		
		User user = (User) request.getSession().getAttribute("user");
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		
		//确定需求是否已抢过，不能重复抢需求
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		map.put("usercode", user.getUsercode());
		List<DemandSign> signlist = demandSignService.selectDemandSignByMap(map);
		if(signlist!=null && signlist.size()>0){
			resultMap.put("status", 1);
			resultMap.put("msg", "抱歉！该需求您已经抢取，无需再次抢取！");
		}else{
			try {
				DemandSign info = new DemandSign();
				info.setId(SerialNumber.createSerial("desig", 5));
				info.setDemandId(demandid);
				info.setUserCode(user.getUsercode());
				info.setSignedTime(new Date());
				
				//查询当前需求的最大顺序	
				Integer max = demandSignService.selectMaxIndexByDemand(demandid);
				if(max<=1){
					info.setSingnedIndex(max+1);
					info.setProportion(100);
				}else{
					info.setSingnedIndex(max+1);
					info.setProportion(100-(max-1)*5);
				}
				int res = demandSignService.insertDemandSign(info);
				result.setResultData(res);
				if(res>0){
					resultMap.put("status", 0);
					resultMap.put("msg", "恭喜你，抢取成功！你第"+(max+1)+"个抢取成功");
				}else{
					resultMap.put("status", 1);
					resultMap.put("msg", "很遗憾！抢取失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("status", 1);
				resultMap.put("msg", e.getMessage());
			}
		}
		return resultMap;
	}
	
	
	/**
	 * 简历需求查询
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param ocode
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @param request
	 * @return
	 */
	@RequestMapping("/demandResumeList1")  
    public Map<String,Object> demandResumeList1(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
    		@RequestParam(value = "usercode", defaultValue = "") String usercode,
    		HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		//User user = (User) request.getSession().getAttribute("user");
		User user = loginUserService.sltUser(usercode);
		
		Map<String,Object> conMap= new HashMap<String,Object>();
		conMap.put("usercode", user.getUsercode());
		conMap.put("demanstatus", 0);
		
		//当前用户分配到的需求列表
		List<Map<String,Object>> list = demandSignService.selectDemandSignByUserMap(conMap);
		
		//当前用户上传的简历列表
		Map<String, Object> map = new HashMap<String,Object>();
				
		
		List<DemandResume> demandResumelist = new ArrayList<DemandResume>();
		if(list!=null && list.size()>0){
			Map<String,Object> mapinfo = list.get(0);
			String signid = mapinfo.get("signid").toString();
			demandResumelist = demandResumeService.selectDemandResumeBySignId(signid);
		}
//		int total = 0;
//		total=customerInfoService.notClosedDemandsCount(user.getUsercode());
//		int tatalpage = 0;
//		if(total != 0){
//			if(total%pageSize!=0){
//				tatalpage = total/pageSize+1;
//			}else{
//				tatalpage = total/pageSize;
//			}
//		}
		//判断用户是人事管理员
		Map<String,Object> usermap = new HashMap<String,Object>();
		usermap.put("usercode", user.getUsercode());
		usermap.put("groupname", "人事管理员组");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			resultMap.put("managerflag", 1);
			map = customerInfoService.selectCustInfoByOpertCode(page, 10, null,customername,technologydirection,projectlocation,demandyears,ocode);
		}else{
			resultMap.put("managerflag", 0);
			map = customerInfoService.selectCustInfoByOpertCode(page, 10, user.getUsercode(),customername,technologydirection,projectlocation,demandyears,ocode);
		}
		resultMap.put("currpage", page);
		resultMap.put("total", map.get("total"));
		resultMap.put("tatalpage", map.get("tatalpage"));
		resultMap.put("areaList", areasService.getAreaList());
		resultMap.put("corpList", corpService.getCorpList());
		resultMap.put("gradList",gradeService.queryAll());
		resultMap.put("professList",professionService.queryAll());
		resultMap.put("list1", list);
		resultMap.put("list2", map.get("customerInfoList"));
		resultMap.put("list3", demandResumelist);
		resultMap.put("realname", user.getRealname());
		resultMap.put("corporList",corporateService.queryAll());
		resultMap.put("profession",professionService.queryAll());
		resultMap.put("grade",gradeService.queryAll());
		resultMap.put("userlist", userService.getAllUsers());
		resultMap.put("arealist", areasService.getAreaList());
		resultMap.put("customername",customername);
		resultMap.put("technologydirection",technologydirection);
		resultMap.put("projectlocation",projectlocation);
		resultMap.put("demandyears",demandyears);
		resultMap.put("ocode",ocode);
		resultMap.put("status", 0);
		resultMap.put("msg", "简历需求查询成功");
		return resultMap;
	}
	
	
	/**
	 * 简历需求详细信息
	 * @param customercode
	 * @param request
	 * @return
	 */
//	@RequestMapping("/demandDetail")
//	@ResponseBody
//	public Map<String,Object> demandDetail(
//			@RequestParam(value = "customercode", defaultValue = "") String customercode,
//			HttpServletRequest request){
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		CustomerInfo customerDetail = customerDetailService.getCustomerinfoByCode(customercode);
//		List<Map<String,Object>> demandcustomer = new ArrayList<Map<String,Object>>();
//		demandcustomer = customerInfoService.demandResumeOfDemand(customercode);
//		resultMap.put("customerDetail", customerDetail);
//		resultMap.put("demandcustomer", demandcustomer);
//		resultMap.put("professList",professionService.queryAll());
//		resultMap.put("areaList", areasService.getAreaList());
//		resultMap.put("corpList", corpService.getCorpList());
//		resultMap.put("gradList",gradeService.queryAll());
//		
//		//查询当前登录用户所属组
//		User user = (User) request.getSession().getAttribute("user");
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("usercode", user.getUsercode());
//		map.put("groupname", "人事管理员组");
//		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(map);
//		if(groups!=null && groups.size()>0){
//			resultMap.put("managerflag", 1);
//		}
//		
//		resultMap.put("accountlist", accountsService.selectaccount());
//		resultMap.put("resumeSourceList", resumeSourceService.getAllResumeSource(new HashMap<String,Object>()));
//		resultMap.put("enlevellist", parameterService.selectByName(ResourceUtil.ENGLISHLEVEL));
//		resultMap.put("japlevellist", parameterService.selectByName(ResourceUtil.JAPANESELEVEL));
//		resultMap.put("educationlist", parameterService.selectByName(ResourceUtil.EDUCATION));	
//		resultMap.put("status", 0);
//		resultMap.put("msg", "简历需求查询成功");
//		return resultMap;
//	}
	
	
	/**
	 * 简历需求详细信息下的跟踪信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/followOfResume")
	@ResponseBody
	public Map<String,Object> followOfResume(@RequestParam(value = "Id", defaultValue = "") String id){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<Map<String,Object>> resusmeFollowList = new ArrayList<Map<String,Object>>();
		resusmeFollowList = demandResumeFollowService.secondfollowOfResume(id);
		resultMap.put("resusmeFollowList", resusmeFollowList);
		resultMap.put("demandresumeId",id);
		resultMap.put("status", 0);
		resultMap.put("msg", "简历需求查询成功");
		return resultMap;
	}
	
	
	/**
	 * 简历需求跟踪模块
	 * @param page
	 * @param pageSize
	 * @param customername
	 * @param ocode
	 * @param technologydirection
	 * @param projectlocation
	 * @param demandyears
	 * @param request
	 * @return
	 */
	@RequestMapping("/demandFollowList")
	@ResponseBody
	public Map<String,Object> demandFollowList(@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
    		HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> map= new HashMap<String,Object>();
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);	
		map.put("customername", customername);
		map.put("technologydirection", technologydirection);
		map.put("projectlocation", projectlocation);
		map.put("demandyears", demandyears);
		map.put("ocode", ocode);
		List<Map<String,Object>> demandList= new ArrayList<Map<String,Object>>();
		int total = 0;
		demandList = customerDemandService.notClosedDemands(map);
		total=customerDemandService.notClosedDemandsCount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("corporList",corporateService.queryAll());
		resultMap.put("grade",gradeService.queryAll());
		resultMap.put("profession",professionService.queryAll());
		resultMap.put("arealist", areasService.getAreaList());
		resultMap.put("customername",customername);
		resultMap.put("technologydirection",technologydirection);
		resultMap.put("projectlocation",projectlocation);
		resultMap.put("demandyears",demandyears);
		resultMap.put("ocode",ocode);
		List<CustDemand> custList=customerDemandService.selectDemand(map);
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("demandList", demandList);
		resultMap.put("userlist", userService.getAllUsers());
		//判断用户是人事管理员
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> usermap = new HashMap<String,Object>();
		usermap.put("usercode", user.getUsercode());
		usermap.put("groupname", "人事管理员组");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			resultMap.put("managerflag", 1);
		}else{
			resultMap.put("managerflag", 0);
		}
		resultMap.put("status", 0);
		resultMap.put("msg", "获取简历需求跟踪模块成功");
		return resultMap;
	}
	
	
	/**
	 * 获取简历需求跟踪详情
	 * @param demandId
	 * @param customername
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("/demandDetail")
	@ResponseBody
	public Map<String,Object> demandDetail(@RequestParam(value = "demandId", defaultValue = "") String demandId,
			@RequestParam(value = "customername", defaultValue = "") String customername,
			@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
			HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> demandDetail= new HashMap<String,Object>();
		demandDetail = customerDemandService.getDemandDetail(demandId);
		List<Map<String,Object>> demandresumeList = new ArrayList<Map<String,Object>>();
		Map<String,Object> conmap = new HashMap<String,Object>();
		if(customername!=null && !"".equals(customername)){
			conmap.put("customername", customername);
			resultMap.put("customername", customername);
		}
		conmap.put("start", (page-1)*pageSize);
		conmap.put("pageSize", pageSize);	
		conmap.put("demandId", demandId);		
		demandresumeList = demandResumeService.demandResumeOfDemandMap(conmap);
		int total = 0;
		total=demandResumeService.demandResumeOfDemandCount(conmap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("demandDetail", demandDetail);
		resultMap.put("demandresumeList", demandresumeList);
		resultMap.put("imporList", parameterService.selectByName("重要程度"));
		//判断用户是人事管理员
		User user = (User) request.getSession().getAttribute("user");
		Map<String,Object> usermap = new HashMap<String,Object>();
		usermap.put("usercode", user.getUsercode());
		usermap.put("groupname", "人事管理员组");
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(usermap);
		if(groups!=null && groups.size()>0){
			resultMap.put("managerflag", 1);
		}else{
			resultMap.put("managerflag", 0);
		}
		//查询需求简历最后更更新时间及状态
		List<Map<String,Object>> lasfollowList = new ArrayList<Map<String,Object>>();
		lasfollowList = demandResumeService.laststatusdemandResume(demandId);
		resultMap.put("lasfollowList", lasfollowList);		
		resultMap.put("status", 0);
		resultMap.put("msg", "获取简历需求跟踪详情成功");
		return resultMap;
	}
	
	
	/**
	 * 在项人员详细信息
	 * @param customername
	 * @param customersex
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryCustomerDetails")
	@ResponseBody
	public Map<String, Object> queryCustomerDetails(
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customersex", defaultValue = "") String customersex,
    		@RequestParam(value = "page", defaultValue = "1") int page,//第几页
    		@RequestParam(value = "pageSize", defaultValue = "1") int pageSize,//每页条数
    		HttpServletRequest request){
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			customername = URLDecoder.decode(customername, "UTF-8");
			if(StringUtils.isNotBlank(customername)){
				params.put("customername", customername.replaceAll(" +", ""));
			}
			if(StringUtils.isNotBlank(customersex)){
				params.put("customersex", customersex);
			}
			params.put("offset", (page-1)*pageSize);
			params.put("pageSize", pageSize);
			List<CustomerInfo> list = customerInfoService.selectCuName();
			
			
			//查询签约信息
			List<Customerprojectpay> cplist = customerprojectpayService.queryAllPay(params);
			int total = customerprojectpayService.queryAllPayCount(params);
			int tatalpage = 0;
			if(total != 0){
				if(total%pageSize!=0){
					tatalpage = total/pageSize+1;
				}else{
					tatalpage = total/pageSize;
				}
			}
			
			
			//查询月份
			Map<String,List<Date>> monthpay = new HashMap<String,List<Date>>();//查询月份列表
			List<Map<String,Object>> allsalarylist = new ArrayList<Map<String,Object>>();//查询工资信息
			List<Map<String,Object>> allpaylist = new ArrayList<Map<String,Object>>();//查询付款信息
			if(cplist!=null && cplist.size()>0){
				for(int i=0;i<cplist.size();i++ ){
					Customerprojectpay info = cplist.get(i);
					//查询所有月份
					List<Date> monthlist = customerprojectpayService.queryAllMonth(info.getStartTime(), info.getEndTime());
					monthpay.put(info.getId(), monthlist);
					
					//查询考勤信息
					if(monthlist!=null && monthlist.size()>0){
						for(int j=0;j<monthlist.size();j++){
							Date date = monthlist.get(j);
							Calendar cal = Calendar.getInstance();
							cal.set(date.getYear(),date.getMonth(), date.getDay(),date.getHours(), date.getMinutes(), date.getSeconds());
							cal.add(Calendar.MONTH, 1);
							
							Map<String,Object> map = new HashMap<String,Object>();
							map.put("month", cal.getTime());//下个月
							map.put("searchcustomercode", info.getCustomerCode());
							map.put("start",0);
							map.put("pageSize", 1);
							List<Map<String,Object>> salarylist = salarySetService.getSalaryList(map);
							allsalarylist.addAll(salarylist);
						}
					}
					
					//查询付款信息
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("corpCode", info.getCorpCode());
					map.put("customerProjectPayId", info.getId());
					map.put("customerCode", info.getCustomerCode());
					List<Map<String,Object>> paylist = monthServicePayService.queryMapMonthServicePay(map);
					allpaylist.addAll(paylist);
				}
			}
			model.put("customername", customername);
			model.put("customersex", customersex);
			model.put("total", total);
			model.put("tatalpage", tatalpage);//总页数
			model.put("currpage", page);//当前页
			model.put("list", list);
			model.put("cplist", cplist);
			model.put("monthpay", monthpay);
			model.put("allsalarylist", allsalarylist);
			model.put("allpaylist", allpaylist);
			
			//查询客户公司信息
			List<Corp> corplist = corpService.getCorpList();
			model.put("corplist", corplist);
			
			//查询人事列表
			List<User> userlist = userService.getAllUsers();
			model.put("userlist", userlist);
			
			//查询未归还物品列表
			List<Map<String,Object>> noreturnlist = itemsService.getNotReturnList();
			model.put("noreturnlist", noreturnlist);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return new ModelAndView("views/customerallinfodetail/customerallinfolist",model);
		return model;
	}
	
	
	/**
	 * 跟踪简历列表
	 * @param page
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFollowResumeList")  
	@ResponseBody
    public Map<String,Object> toFollowResumeList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		@RequestParam(value = "usercode", defaultValue = "") String usercode,
    		HttpServletRequest request){
		Map<String,Object> resultMap = new HashMap<String,Object>();
//		tripRecordId = URLDecoder.decode(tripRecordId,"UTF-8");		
//		User user = (User)request.getSession().getAttribute("user");
		Map<String,Object> acMap= new HashMap<String,Object>();
		acMap.put("start", (page-1)*pageSize);
		acMap.put("pageSize", pageSize);
		//acMap.put("userCode", user.getUsercode());
		acMap.put("userCode", usercode);
		acMap.put("signStatus", 1);
		List<CustInfoAdd> followlist = customerSignService.followresmelist(acMap);
		int total = customerSignService.followresmelistcount(acMap);
		
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		resultMap.put("followlist",followlist);
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		return resultMap;
	}
	
	
	/**
	 * 
	 * @param userWeiXinId
	 * @param req
	 * @param res
	 * @return
	 */
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
	
	
	/**
	 * 添加用户微信
	 * @param addUserCode
	 * @param addweixin
	 * @param req
	 * @param res
	 * @return
	 */
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
	
	
	/**
	 * 用户微信列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/userweixinlist")  
	@ResponseBody
    public Map<String,Object> userweixinlist(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> acMap= new HashMap<String,Object>();
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
		resultMap.put("total", total);
		resultMap.put("tatalpage", tatalpage);
		resultMap.put("list", list);
		
		List<User> userlist = userService.getAllUsers();
		resultMap.put("userlist", userlist);
		return resultMap;
	}
	
	
	
	
	
	
	
	
	
	
	
}







