package com.shzqoa.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.QuestionFollowMapper;
import com.shzqoa.dao.QuestionMapper;
import com.shzqoa.model.Question;
import com.shzqoa.model.QuestionFollow;
import com.shzqoa.model.User;
import com.shzqoa.util.SerialNumber;

@Service
public class QuestionFollowService {
	@Resource
	private QuestionFollowMapper questionFollowMapper;
	@Resource
	private QuestionMapper questionMapper;
	
	public int addQuestionFollow(QuestionFollow  info){
		return questionFollowMapper.addQuestionFollow(info);
	}
	@Transactional
	public int followQuestions(Question  info,User user ,String questionFollowContent,Integer questionStatus) throws Exception{
		QuestionFollow questionfollow = new QuestionFollow();
		questionfollow.setQuestionFollowId(SerialNumber.createSerial("qefo", 4));
		questionfollow.setQuestionId(info.getQuestionId());
		questionfollow.setQuestionStatus(questionStatus);
		questionfollow.setQuestionFollowContent(questionFollowContent);
		questionfollow.setFollowPeople(user.getUsercode());
		questionfollow.setFollowTime(new Date());
		int result = addQuestionFollow(questionfollow);
		if(questionStatus==3){//问题状态（1-未处理  2-处理中  3-已解决）
			int reuslt1 = 0;
			info.setQuestionStatus(questionStatus);
			info.setActualSettlementTime(new Date());
			reuslt1 = questionMapper.updateQuestions(info);
			if(result>0 && reuslt1>0){
				return result;
			}else{
				throw new Exception ("跟踪失败");
			}
		}else{
			return result;
		}
	}
	
	
}
