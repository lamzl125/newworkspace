package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shzqoa.dao.QuestionMapper;
import com.shzqoa.model.Question;

@Service
public class QuestionService {
	@Resource
	private QuestionMapper questionMapper;
	
	
	public List<Map<String,Object>> getQuestionsByMap(Map<String,Object> map){
		return questionMapper.getQuestionsByMap(map);
	}
	public Integer getQuestionsCountByMap(Map<String,Object> map){
		return questionMapper.getQuestionsCountByMap(map);
	}
	public int addQuestions(Question  info){
		return questionMapper.addQuestions(info);
	}
	public int updateQuestions(Question  info){
		return questionMapper.updateQuestions(info);
	}
	public int delQuestionById(String  questionId){
		return questionMapper.delQuestionById(questionId);
	}
	public Question getQuestionById(String  questionId){
		return questionMapper.getQuestionById(questionId);
	}
	
}
