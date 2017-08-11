package com.shzqoa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shzqoa.model.Areas;
import com.shzqoa.model.CustDemand;
import com.shzqoa.model.DemandResumeFollow;
import com.shzqoa.model.DemandSign;
import com.shzqoa.model.Grade;
import com.shzqoa.model.Profession;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.model.User;
import com.shzqoa.service.AreasService;
import com.shzqoa.service.CorpService;
import com.shzqoa.service.CorporatepartnersService;
import com.shzqoa.service.CustomerDemandService;
import com.shzqoa.service.CustomerInfoService;
import com.shzqoa.service.DemandResumeFollowService;
import com.shzqoa.service.DemandResumeService;
import com.shzqoa.service.DemandSignService;
import com.shzqoa.service.GradeService;
import com.shzqoa.service.ParameterService;
import com.shzqoa.service.ProfessionService;
import com.shzqoa.service.UserGroupService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.ResultObject;
import com.shzqoa.util.SerialNumber;

@Controller
@RequestMapping(value="/demandsigned")
public class DemandSignedController {
	@Resource
	CustomerDemandService customerDemandService;
	@Resource
	GradeService gradeService;
	@Resource
	AreasService areasService;
	@Resource  
	ProfessionService professionService;
	@Resource  
	CorporatepartnersService corporateService;
	@Resource
	private UserGroupService userGroupService;
	@Resource
	private UserService userService;
	@Resource
	private CorpService corpService;
	@Resource
	private ParameterService parameterService;
	@Resource
	private DemandSignService demandSignService;
	@Resource
	private DemandResumeFollowService demandResumeFollowService;
	@Resource
	private CustomerInfoService customerInfoService;
	@Resource
	private DemandResumeService demandResumeService;
	
	/**
	 * 需求添加简历
	 */
	@RequestMapping(value="/demandaddresume", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject demandaddresume(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			@RequestParam(value = "customercodes", defaultValue = "") String customercodes,
			HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();		
		User user = (User) request.getSession().getAttribute("user");
		
		//确定需求是否已抢过
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		map.put("usercode", user.getUsercode());
		List<DemandSign> signlist = demandSignService.selectDemandSignByMap(map);
		String singId = "";
		if(signlist==null || signlist.size()<=0){
			//1、新增需求分配
			singId =  SerialNumber.createSerial("desig", 5);
			DemandSign sign = new DemandSign();
			sign.setId(singId);
			sign.setDemandId(demandid);
			sign.setUserCode(user.getUsercode());
			sign.setSignedTime(new Date());
			sign.setSingnedIndex(0);
			sign.setProportion(0);			
			int res = demandSignService.insertDemandSign(sign);
			if(res<=0){
				result.setSuccess(false);
				result.setResultMessage("添加简历失败");
			}
		}else{
			singId = signlist.get(0).getId();
		}
		//2、分配需求
		try{
			int resultc = demandResumeService.setDemandResume(singId, customercodes.split(","), user.getUsercode());
			if(resultc>0){
				result.setSuccess(true);
				result.setResultMessage("添加简历成功");
			}else{
				result.setSuccess(false);
				result.setResultMessage("添加简历失败");
			}
		}catch(Exception e){
			result.setSuccess(false);
			result.setResultMessage("添加简历失败");
		}
		return result;
	}
	
	//绑定简历列表
	@RequestMapping("/demandBindResumeList")  
    public ModelAndView demandBindResumeList(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customerphone", defaultValue = "") String customerphone,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/unassigneddemand/demandbindresumelist");	
		customername = URLDecoder.decode(customername, "UTF-8");
		demandId = URLDecoder.decode(demandId, "UTF-8");
		customerphone = URLDecoder.decode(customerphone, "UTF-8");
		mv.addObject("customername", customername);
		mv.addObject("demandId", demandId);
		mv.addObject("currpage", page);
		User user = (User) request.getSession().getAttribute("user");
		//根据需求查询当前用户已绑定简历信息		  
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userCode", user.getUsercode());
		map.put("demandId", demandId);
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);		
		if(customername!=null && !"".equals(customername)){
			map.put("customername", customername);
			mv.addObject("customername",customername);
		}
		if(customerphone!=null && !"".equals(customerphone)){
			map.put("customerphone", customerphone);
			mv.addObject("customerphone",customerphone);
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
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", list);
		return mv;
	}
	
	//未绑定简历列表
	@RequestMapping("/demandNoBindResumeList")  
    public ModelAndView demandNoBindResumeList(
    		@RequestParam(value = "demandId", defaultValue = "") String demandId,
    		@RequestParam(value = "customername", defaultValue = "") String customername,
    		@RequestParam(value = "customerphone", defaultValue = "") String customerphone,
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
    		HttpServletRequest request) throws UnsupportedEncodingException{
		ModelAndView mv = new ModelAndView("views/unassigneddemand/addResume");	
		customername = URLDecoder.decode(customername, "UTF-8");
		demandId = URLDecoder.decode(demandId, "UTF-8");
		customerphone = URLDecoder.decode(customerphone, "UTF-8");
		mv.addObject("customername", customername);
		mv.addObject("demandId", demandId);
		User user = (User) request.getSession().getAttribute("user");
		
		//查询未绑定
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userCode", user.getUsercode());
		map.put("demandId", demandId);
		if(customername!=null && !"".equals(customername)){
			map.put("customername", customername);
			mv.addObject("customername",customername);
		}
		if(customerphone!=null && !"".equals(customerphone)){
			map.put("customerphone", customerphone);
			mv.addObject("customerphone",customerphone);
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
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", list);
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/getdemandresumefollowByid")
	@ResponseBody
	public ReturnDate getdemandresumefollowByid(
			@RequestParam(value = "id", defaultValue = "0") String id){
		ReturnDate rd = new ReturnDate();
		
		List<DemandResumeFollow> list=demandResumeFollowService.getdemandresumefollowByid(id);
		double time1=0;
		double time2=0;
		double time3=0;
		int count=0;
		for(DemandResumeFollow follow:list){
			//通过筛选的简历的记录
			if(follow.getSendResumeStatus()==2 & follow.getScreeningResumesStatus()==1 & follow.getNoticeInterviewStatus()==0){
				//记录通过筛选的时间
				Calendar calendar = Calendar.getInstance();
				Calendar calendar1 = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				Calendar calendar3 = Calendar.getInstance();
				Calendar calendar4 = Calendar.getInstance();
				Calendar calendar5 = Calendar.getInstance();
				calendar.setTime(follow.getTrackingTime());
				//循环通过筛选的简历
				List<DemandResumeFollow> list1=demandResumeFollowService.getdemandresumefollowBydemandresumeid(follow.getDemandResumeId());
				for(DemandResumeFollow follow1:list1){
					//未筛选的简历
					if(follow1.getSendResumeStatus()==2 & follow1.getScreeningResumesStatus()==0){
						calendar1.setTime(follow1.getTrackingTime());
					}
					//通知面试结果的简历
					if(follow1.getSendResumeStatus()==2 & follow1.getScreeningResumesStatus()==1 & follow1.getNoticeInterviewStatus()==1 & (follow1.getInterviewResultStatus()==1 || follow1.getInterviewResultStatus()==2)){
						calendar2.setTime(follow1.getTrackingTime());
					}
					//通知面试但结果没下来对应的时间
					if(follow1.getSendResumeStatus()==2 & follow1.getScreeningResumesStatus()==1 & follow1.getNoticeInterviewStatus()==1 & follow1.getInterviewResultStatus()==0){
						calendar3.setTime(follow1.getTrackingTime());
					}
					//安排入项
					if(follow1.getSendResumeStatus()==2 & follow1.getScreeningResumesStatus()==1 & follow1.getNoticeInterviewStatus()==1 & follow1.getInterviewResultStatus()==1 & follow1.getArrangeEntryStatus()==1){
						calendar4.setTime(follow1.getTrackingTime());
					}
					//未安排入项
					if(follow1.getSendResumeStatus()==2 & follow1.getScreeningResumesStatus()==1 & follow1.getNoticeInterviewStatus()==1 & follow1.getInterviewResultStatus()==0 & follow1.getArrangeEntryStatus()==0){
						calendar5.setTime(follow1.getTrackingTime());
					}
				}
				long l1=calendar.getTimeInMillis()-calendar1.getTimeInMillis();
				double  days1=l1/(1000*60*60*24);
				long l2=calendar2.getTimeInMillis()-calendar.getTimeInMillis();
				double days2=l2/(1000*60*60*24);
				long l3=calendar4.getTimeInMillis()-calendar2.getTimeInMillis();
				double days3=l3/(1000*60*60*24);
				time1+=days1;
				time2+=days2;
				time3+=days3;
				count++;
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if(count!=0){
		double c1=(double)(Math.round(time1/count)/100.0);//这样为保持2位 
		double c2=(double)(Math.round(time2/count)/100.0);//这样为保持2位 
		double c3=(double)(Math.round(time3/count)/100.0);//这样为保持2位 
		map.put("c1", c1);
		map.put("c2", c2);
		map.put("c3", c3);
		}else{
		map.put("c1", "暂无跟踪");
		map.put("c2", "暂无跟踪");
		map.put("c3", "暂无跟踪");
		}
		rd.setData(map);
		
		return rd;
	}
	
	/**
	 * 分配需求
	 */
	@RequestMapping(value="/bindDemand", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject bindDemand(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			@RequestParam(value = "checkuser", defaultValue = "") String checkuser,
			HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();		
		User user = (User) request.getSession().getAttribute("user");
		
		//确定需求是否已抢过，不能重复抢需求
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		map.put("usercode", checkuser);
		List<DemandSign> signlist = demandSignService.selectDemandSignByMap(map);
		if(signlist!=null && signlist.size()>0){
			result.setSuccess(false);
			result.setResultMessage("抱歉！该需求您已经抢取/分配，无需再次分配！");
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
					result.setSuccess(true);
					result.setResultMessage("恭喜你，分配成功！");
				}else{
					result.setSuccess(false);
					result.setResultMessage("很遗憾！分配失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setResultMessage(e.getMessage());
			}
		}
		return result;
	}
	
	
	/**
	 * 抢取需求
	 */
	@RequestMapping(value="/grabDemand", method=RequestMethod.POST)
	@ResponseBody
	public ResultObject grabDemand(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			HttpServletRequest request
			){
		ResultObject result = ResultObject.getResultObject();		
		User user = (User) request.getSession().getAttribute("user");
		
		//确定需求是否已抢过，不能重复抢需求
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		map.put("usercode", user.getUsercode());
		List<DemandSign> signlist = demandSignService.selectDemandSignByMap(map);
		if(signlist!=null && signlist.size()>0){
			result.setSuccess(false);
			result.setResultMessage("抱歉！该需求您已经抢取，无需再次抢取！");
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
					result.setSuccess(true);
					result.setResultMessage("恭喜你，抢取成功！你第"+(max+1)+"个抢取成功");
				}else{
					result.setSuccess(false);
					result.setResultMessage("很遗憾！抢取失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.setResultMessage(e.getMessage());
			}
		}
		return result;
	}
	
	
	/**
	 * 需求详细信息，及抢取/分配信息列表
	 * @param demandid
	 * @param managerflag
	 * @return
	 */
	@RequestMapping("/showdemanddetail")
	public ModelAndView showdemanddetail(
			@RequestParam(value = "demandid", defaultValue = "") String demandid,
			@RequestParam(value = "managerflag", defaultValue = "") Integer managerflag
			){
		ModelAndView mv = new ModelAndView("/views/unassigneddemand/demanddetail");
		mv.addObject("customerDemand",customerDemandService.selectById(demandid));
		mv.addObject("areaList", areasService.getAreaList());
		mv.addObject("corpList", corpService.getCorpList());
		mv.addObject("gradList",gradeService.queryAll());
		mv.addObject("professList",professionService.queryAll());
		mv.addObject("imporList", parameterService.selectByName("重要程度"));
		mv.addObject("managerflag",managerflag);
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist",userlist);
		
		
		//获取抢取信息
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		List<DemandSign> demandsignlist = demandSignService.selectDemandSignByMap(map);
		mv.addObject("demandsignlist",demandsignlist);
		return mv;			
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
    public ModelAndView toDemandList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
    		@RequestParam(value = "corpcode", defaultValue = "") String corpcode,
    		@RequestParam(value = "technologydirection", defaultValue = "") String technologydirection,
    		@RequestParam(value = "projectlocation", defaultValue = "") String projectlocation,
    		@RequestParam(value = "demandyears", defaultValue = "") String demandyears,
    		@RequestParam(value = "ocode", defaultValue = "") String ocode,
    		HttpServletRequest request
    		){
		ModelAndView mv = new ModelAndView("views/unassigneddemand/unassignedDemandList");
		mv.addObject("currpage", page);
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
		mv.addObject("binddemandlist",binddemandlist);
				
		
		
		map.put("start", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		List<Map<String,Object>> groups = userGroupService.getUserGroupMapByUsercode(map);
		if(groups!=null && groups.size()>0){
			mv.addObject("managerflag", 1);
		}
		
		
		
		
		//查询人事组成员列表
		List<User> rsuserlist = userService.queryUsersByGroupName("人事");
		mv.addObject("rsuserlist",rsuserlist);
		
		map.remove("usercode");
		map.remove("groupname");
		
		if(corpcode!=null && !"".equals(corpcode)){
			map.put("corpcode", corpcode);
			mv.addObject("corpcode", corpcode);
		}
		if(technologydirection!=null && !"".equals(technologydirection)){
			map.put("technologydirection", technologydirection);
			mv.addObject("technologydirection", technologydirection);
		}
		if(projectlocation!=null && !"".equals(projectlocation)){
			map.put("areaid", projectlocation);
			mv.addObject("projectlocation", projectlocation);
		}
		if(demandyears!=null && !"".equals(demandyears)){
			map.put("demandyears", demandyears);
			mv.addObject("demandyears", demandyears);
		}
		if(ocode!=null && !"".equals(ocode)){
			map.put("ocode", ocode);
			mv.addObject("ocode", ocode);
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
		mv.addObject("corporList",corporateService.queryAll());
		mv.addObject("grade",grade);
		mv.addObject("profession",profession);
		mv.addObject("arealist", arealist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("custList", custList);
		mv.addObject("userlist",userlist);
		mv.addObject("proindlist", parameterService.selectByName(ResourceUtil.PROINDUSTRY));
		mv.addObject("tectypelist", parameterService.selectByName(ResourceUtil.TECHNOLOGYTYPE));
		return mv;
	}
	
	
	/**
	 * 显示需求分配列表信息表
	 * @param demandid
	 */
	@RequestMapping("/showdemandsignlist")
	public ModelAndView showdemandsignlist(
			@RequestParam(value = "demandid", defaultValue = "") String demandid){
		ModelAndView mv = new ModelAndView("/views/unassigneddemand/demandsignlist");
		
		List<User> userlist = userService.getAllUsers();
		mv.addObject("userlist",userlist);
		
		//获取抢取信息
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("demandId", demandid);
		List<DemandSign> demandsignlist = demandSignService.selectDemandSignByMap(map);
		mv.addObject("demandsignlist",demandsignlist);
		return mv;			
	}
	
}
