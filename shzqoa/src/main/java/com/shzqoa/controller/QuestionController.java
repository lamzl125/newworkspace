package com.shzqoa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.shzqoa.model.Question;
import com.shzqoa.model.User;
import com.shzqoa.service.QuestionFollowService;
import com.shzqoa.service.QuestionService;
import com.shzqoa.service.UserService;
import com.shzqoa.util.SerialNumber;


@Controller
@RequestMapping(value = "/question")
public class QuestionController {
	@Resource
	private QuestionService questionService;
	@Resource
	private UserService userService;
	@Resource
	private QuestionFollowService questionFollowService;
	
	@RequestMapping("/followQuestion")  
	@ResponseBody
	public Map<String,Object> followQuestion(
			@RequestParam(value = "questionId", defaultValue = "") String questionId,
			@RequestParam(value = "questionFollowContent", defaultValue = "") String questionFollowContent,
			@RequestParam(value = "questionStatus", defaultValue = "") Integer questionStatus,			
			HttpServletRequest request,HttpServletResponse response	) throws Exception{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User)request.getSession().getAttribute("user");
		Question info = questionService.getQuestionById(questionId);
		
		
		if(questionFollowService.followQuestions(info,user,questionFollowContent,questionStatus)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "跟踪问题成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "跟踪问题失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/toFollowQuestion")  
    public ModelAndView toFollowQuestion(
    		@RequestParam(value = "questionId", defaultValue = "") String questionId,
    		HttpServletRequest request){
		ModelAndView mv = new ModelAndView("views/question/followquestion");
		Map<String,Object> map = new HashMap<String,Object>();
		User user = (User)request.getSession().getAttribute("user");
		map.put("userstatus", 2);
		List<User> lsit = userService.queryCurList(map);
		mv.addObject("list", lsit);
		Question question = questionService.getQuestionById(questionId);
		mv.addObject("info", question);
		mv.addObject("curuser", user);
		return mv;
	}
	
	@RequestMapping("/updateQuestion")  
	@ResponseBody
	public Map<String,Object> updateQuestion(
			@RequestParam(value = "questionId", defaultValue = "") String questionId,
			@RequestParam(value = "problemMaker", defaultValue = "") String problemMaker,
			@RequestParam(value = "reflectProblemTime", defaultValue = "") String reflectProblemTime,			
			@RequestParam(value = "questionContent", defaultValue = "") String questionContent,
			@RequestParam(value = "personLiable", defaultValue = "") String personLiable,
			@RequestParam(value = "urgencyLevel", defaultValue = "") String urgencyLevel,
			@RequestParam(value = "estimatedSettlingTime", defaultValue = "") String estimatedSettlingTime,
			HttpServletRequest request,HttpServletResponse response	) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User)request.getSession().getAttribute("user");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Question info = questionService.getQuestionById(questionId);
		info.setQuestionContent(questionContent);
		info.setPersonLiable(personLiable);
		info.setUrgencyLevel(urgencyLevel);
		info.setEstimatedSettlingTime(sdf.parse(estimatedSettlingTime));
		info.setProblemMaker(problemMaker);
		info.setReflectProblemTime(sdf.parse(reflectProblemTime));	
		
		if(questionService.updateQuestions(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "更新问题信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "更新问题信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/toEditQuestion")  
    public ModelAndView toEditQuestion(
    		@RequestParam(value = "questionId", defaultValue = "") String questionId){
		ModelAndView mv = new ModelAndView("views/question/editquestion");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userstatus", 2);
		List<User> lsit = userService.queryCurList(map);
		mv.addObject("list", lsit);
		Question question = questionService.getQuestionById(questionId);
		mv.addObject("info", question);
		return mv;
	}
	
	@RequestMapping("/addQuestion")  
	@ResponseBody
	public Map<String,Object> addQuestion(
			@RequestParam(value = "problemMaker", defaultValue = "") String problemMaker,
			@RequestParam(value = "reflectProblemTime", defaultValue = "") String reflectProblemTime,			
			@RequestParam(value = "questionContent", defaultValue = "") String questionContent,
			@RequestParam(value = "personLiable", defaultValue = "") String personLiable,
			@RequestParam(value = "urgencyLevel", defaultValue = "") String urgencyLevel,
			@RequestParam(value = "estimatedSettlingTime", defaultValue = "") String estimatedSettlingTime,
			HttpServletRequest request,HttpServletResponse response	) throws ParseException{
		Map<String,Object> resultMap = new HashMap<String,Object>();
		User user = (User)request.getSession().getAttribute("user");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Question info = new Question();
		info.setQuestionId(SerialNumber.createSerial("qus", 4));
		info.setQuestionContent(questionContent);
		info.setPersonLiable(personLiable);
		info.setUrgencyLevel(urgencyLevel);
		info.setEstimatedSettlingTime(sdf.parse(estimatedSettlingTime));
		info.setQuestionStatus(1);
		info.setAddPeople(user.getUsercode());
		info.setAddTime(new Date());
		info.setProblemMaker(problemMaker);
		info.setReflectProblemTime(sdf.parse(reflectProblemTime));	
		
		if(questionService.addQuestions(info)>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "添加问题信息成功");
		}else{
			resultMap.put("status", 1);
			resultMap.put("msg", "添加问题信息失败");
		}
		return resultMap;
	}
	
	@RequestMapping("/toAddQuestion")  
    public ModelAndView toAddQuestion(){
		ModelAndView mv = new ModelAndView("views/question/addquestion");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userstatus", 2);
		List<User> lsit = userService.queryCurList(map);
		mv.addObject("list", lsit);
		return mv;
	}
	
	@RequestMapping("/toQuestionList")  
    public ModelAndView toQuestionList(
    		@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/question/questionManage");
		Map<String,Object> conMap= new HashMap<String,Object>();
		mv.addObject("currpage", page);
		conMap.put("start", (page-1)*pageSize);
		conMap.put("pageSize", pageSize);
		
		List<Map<String,Object>> lsit = questionService.getQuestionsByMap(conMap);		
		int total = questionService.getQuestionsCountByMap(conMap);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userstatus", 2);
		List<User> userlist = userService.queryCurList(map);
		mv.addObject("userlist", userlist);
		mv.addObject("total", total);
		mv.addObject("tatalpage", tatalpage);
		mv.addObject("list", lsit);
		return mv;
	}
	@RequestMapping("/delQuestionById")  
	@ResponseBody
	public Map<String,Object> delQuestionById(
			@RequestParam(value = "questionId", defaultValue = "") String questionId){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		int delflag = questionService.delQuestionById(questionId);
		if(delflag>0){
			resultMap.put("status", 0);
			resultMap.put("msg", "删除问题信息成功");
		}else{
			resultMap.put("status",1);
			resultMap.put("msg", "删除问题信息失败");
		}
		return resultMap;
	}
}
