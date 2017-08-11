package com.shzqoa.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.CustomerDemandMapper;
import com.shzqoa.dao.CustomerInfoMapper;
import com.shzqoa.dao.DemandResumeFollowMapper;
import com.shzqoa.dao.DemandResumeMapper;
import com.shzqoa.dao.DemandSignMapper;
import com.shzqoa.dao.NoticeMapper;
import com.shzqoa.model.CustomerDemand;
import com.shzqoa.model.CustomerInfo;
import com.shzqoa.model.DemandResume;
import com.shzqoa.model.DemandResumeFollow;
import com.shzqoa.model.DemandSign;
import com.shzqoa.model.Notice;
import com.shzqoa.util.SerialNumber;

@Service
public class DemandResumeFollowService {
	@Resource
	private DemandResumeFollowMapper demandResumeFollowMapper;
	@Resource
	private NoticeMapper noticeMapper;
	@Resource
	private DemandResumeMapper demandResumeMapper;
	@Resource
	private DemandSignMapper demandSignMapper;
	@Resource
	private CustomerDemandMapper customerDemandMapper;
	@Resource
	private CustomerInfoMapper customerInfoMapper;
	
	
	
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer insertDemandResumeFollow(DemandResumeFollow follow,HttpServletRequest request) throws Exception{
		int rcount = demandResumeFollowMapper.insertDemandResumeFollow(follow);
		if(rcount>0 && follow.getNoticeInterviewStatus()!=null && follow.getNoticeInterviewStatus()==1 && follow.getInterviewResultStatus()==null){			
			DemandResume dr = demandResumeMapper.stlObjectById(follow.getDemandResumeId());
			DemandSign ds = demandSignMapper.selectObjectById(dr.getDemandSignId());
			CustomerDemand cd = customerDemandMapper.selectById(ds.getDemandId());
			CustomerInfo customer = customerInfoMapper.selectByCustomercode(dr.getCustomerCode());
			
			Notice notice = new Notice();
			notice.setNoticeId(SerialNumber.createSerial("noti", 4));
			notice.setNoticeTime(new Date());
			notice.setNoticeType(1);//通知类型（1-面试通知  2-入项通知）
			notice.setNoticeContent(customer.getCustomername()+"简历在需求："+cd.getProjecttype()+"筛选通过");
			notice.setNoticeTo(customer.getOpertcode());
			notice.setNoticeStatus(0);
			int rslt = noticeMapper.save(notice);
			if(rslt>0){
				List<Map<String,Object>> noticelist = noticeMapper.getAllUnSeenNotice(new HashMap<String,Object>());
				request.getSession().setAttribute("noticelist", noticelist);
				return rcount;
			}else{
				throw new Exception();
			}
			
		}else if(rcount>0 && follow.getArrangeEntryStatus()!=null && follow.getArrangeEntryStatus()==1){
			DemandResume dr = demandResumeMapper.stlObjectById(follow.getDemandResumeId());
			DemandSign ds = demandSignMapper.selectObjectById(dr.getDemandSignId());
			CustomerDemand cd = customerDemandMapper.selectById(ds.getDemandId());
			CustomerInfo customer = customerInfoMapper.selectByCustomercode(dr.getCustomerCode());
			
			Notice notice = new Notice();
			notice.setNoticeId(SerialNumber.createSerial("noti", 4));
			notice.setNoticeTime(new Date());
			notice.setNoticeType(2);//通知类型（1-面试通知  2-入项通知）
			notice.setNoticeContent(customer.getCustomername()+"加入项目："+cd.getProjecttype());
			notice.setNoticeTo(customer.getOpertcode());
			notice.setNoticeStatus(0);
			int rslt = noticeMapper.save(notice);
			if(rslt>0){
				List<Map<String,Object>> noticelist = noticeMapper.getAllUnSeenNotice(new HashMap<String,Object>());
				request.getSession().setAttribute("noticelist", noticelist);
				return rcount;
			}else{
				throw new Exception();
			}
			
			
		}else{
			return rcount;
		}
	};
	
	public List<Map<String,Object>> followOfResume(String demandResumeId){
		return demandResumeFollowMapper.followOfResume(demandResumeId);
	}
	public  List<Map<String,Object>> secondfollowOfResume(String id){
		return demandResumeFollowMapper.secondfollowOfResume(id);
	};
	 public List<DemandResumeFollow> getdemandresumefollowByid(String id){
			return demandResumeFollowMapper.getdemandresumefollowByid(id);
	    }
	 
	 public List<DemandResumeFollow> getdemandresumefollowBydemandresumeid(String demandresumeid){
			return demandResumeFollowMapper.getdemandresumefollowBydemandresumeid(demandresumeid);
	    }
	 
	 public  List<Map<String,Object>> getDurationByCorp(Map<String,Object> map){
			return demandResumeFollowMapper.getDurationByCorp(map);
	}
	 
	 
	 
	 public List<Map<String,Object>> followlistOfDemandResume(Map<String,Object> map){
			return demandResumeFollowMapper.followlistOfDemandResume(map);
	 }
	 
	 
	 public DemandResumeFollow stllastestfollowBydrid(String demandResumeId){
		 return demandResumeFollowMapper.stllastestfollowBydrid(demandResumeId);
	 }
}
