package com.shzqoa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import com.shzqoa.model.Grade;
import com.shzqoa.model.ReturnDate;
import com.shzqoa.service.GradeService;
import com.shzqoa.util.SerialNumber;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Resource
	private GradeService gradeService;
	/**
	 * 跳转级别管理页码
	 * @return
	 */
	@RequestMapping("/gradeManage")
	public ModelAndView gradeManage(
			@RequestParam(value = "page", defaultValue = "1") int page,
    		@RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
		ModelAndView mv = new ModelAndView("views/grade/grademanage");
		Map<String,Object> rmap = gradeService.getGradeByPage((page-1)*pageSize,page, pageSize);
		mv.addAllObjects(rmap);
		return mv;
	}
    
	@RequestMapping("/addGrade")
	@ResponseBody
	public ReturnDate addGrade(
			@RequestParam(value="gradename",defaultValue="") String gradename,
			@RequestParam(value="years",defaultValue="") String years,
			@RequestParam(value="describes",defaultValue="") String describes
			){
		Grade grade = new Grade();
		grade.setId(SerialNumber.createSerial("grade", 5));
		grade.setGradename(gradename);
		grade.setYears(years);
		grade.setDescribes(describes);
		ReturnDate rd = new ReturnDate();
		if(gradeService.addGrade(grade)>0){
			rd.setStatus(0);
			rd.setMsg("添加成功");
		}else{
			rd.setStatus(1);
			rd.setMsg("添加失败");
		}
		return rd;
	}
	
	@RequestMapping("/deleteGrade")
	@ResponseBody
	public ReturnDate deleteGrade(
			@RequestParam(value="gradeId",defaultValue="") String gradeId){
		
		ReturnDate rd = new ReturnDate();
		if(gradeService.deleteGrade(gradeId)>0){
			rd.setStatus(0);
			rd.setMsg("删除成功！");
		}else{
			rd.setStatus(1);
			rd.setMsg("删除失败！");
		}
		return rd;
	}
}
