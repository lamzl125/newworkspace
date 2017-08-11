package com.shzqoa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.shzqoa.dao.DailyLogMapper;
import com.shzqoa.dao.DailyLogResumeCountMapper;
import com.shzqoa.dao.ReplyUserMapper;
import com.shzqoa.dao.WorkTaskMapper;
import com.shzqoa.model.DailyLog;
import com.shzqoa.model.DailyLogResumeCount;
import com.shzqoa.model.ReplyUser;
import com.shzqoa.model.User;
import com.shzqoa.model.WorkTask;
import com.shzqoa.util.SerialNumber;

@Service
public class DailyLogService {
	
	@Resource
	private DailyLogMapper dailyLogMapper;
	@Resource
	private WorkTaskMapper workTaskMapper;
	@Resource
	private DailyLogResumeCountMapper dailyLogResumeCountMapper;
	@Resource
	private ReplyUserMapper replyUserMapper;
	
	
	
	/**
	 * 添加工作日志
	 * @param taskid
	 * @param userid
	 * @param realname
	 * @param logcontent
	 * @param propose
	 * @return
	 */
	public int addWorkLog(
			Integer taskid,String publishcontent,String userid,String realname,String logcontent,String propose,
			int isaddj,String addresumecount,Integer taskstatus,String weixin,String lastCount,String addCount,String addDynamic){
		DailyLog log = new DailyLog();
		int result = 0;
		log.setTaskid(taskid);
		log.setPublishcontent(publishcontent);
		log.setUserid(userid);
		log.setRealname(realname);
		log.setLogcontent(logcontent);
		log.setPropose(propose);
		log.setLogdate(new Date());
		log.setTaskstatus(taskstatus);
		log.setWeixin(weixin);
		log.setLastCount(lastCount);
		log.setAddCount(addCount);
		log.setAddDynamic(addDynamic);
		result = dailyLogMapper.addWorkLog(log);
		if(isaddj==1){//有录入简历
			List<DailyLogResumeCount> infolist = new ArrayList<DailyLogResumeCount>();
			String[] list = addresumecount.split("-");
			for(String info : list){
				DailyLogResumeCount iteminfo = new DailyLogResumeCount();
				String[] itemarr = info.split(";");
				if(itemarr!=null && itemarr.length>1){
					iteminfo.setId(SerialNumber.createSerial("dlrc", 4));
					iteminfo.setDailylogid(log.getDailylogid());
					iteminfo.setResumesourceid(Integer.parseInt(itemarr[0]));
					iteminfo.setCount(Integer.parseInt(itemarr[1]));
					infolist.add(iteminfo);
				}
			}
			result = dailyLogResumeCountMapper.addInfoList(infolist);
		}
		
		if(taskid!=null && taskid>0){//有任务时更新任务状态
			WorkTask worktask = workTaskMapper.stlWorkTaskById(taskid);
			worktask.setStatus(taskstatus);//0-未完成 1-已完成  2-处理中 3-已处理
			result = workTaskMapper.updateWorkTaskById(worktask);
		}
		return result;
		
	}
	
	/**
	 * 工作日志列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> dailyLogList(int page,int pageSize,String userid,Date time){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("userid", userid);
		map.put("logdate", time);
		List<DailyLog> dailyLogs = dailyLogMapper.sltDailyLogs(map);
		int total = dailyLogMapper.sltDailyLogNum(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("dailyLogs", dailyLogs);
		map.put("tatalpage", tatalpage);
		List<DailyLogResumeCount> resc = dailyLogResumeCountMapper.getAllList(map);
		map.put("resc", resc);
		return map;
	}
	
	/**
	 * 单条日志详情
	 * @param dailylogid
	 * @return
	 */
	public DailyLog sltdailylogbyid(Integer dailylogid){
		return dailyLogMapper.sltdailylogbyid(dailylogid);
	}
	
	
	public int updatedailylogbyid(Map<String,Object> map){
		return dailyLogMapper.updateWorkLog(map);
	}
	
	public List<DailyLogResumeCount> getResumeCount(Integer dailylogid){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("dailylogid", dailylogid);
		return dailyLogResumeCountMapper.getAllList(map);
	}
	/**
	 * 回复日志
	 */
	@Transactional(propagation= Propagation.REQUIRED, rollbackFor = RuntimeException.class)
	public int replyWorkLog(
			Integer dailylogid,String replyinfo,String repalyuser,User user){
		Map<String,Object> infopara= new HashMap<String,Object>();
		infopara.put("dailylogid", dailylogid);
		infopara.put("replycontent", replyinfo);
		//1、更新回复信息
		int result = dailyLogMapper.updateWorkLog(infopara);
		if (result == 0) {
            throw new RuntimeException("更新0条记录;");
        }
		//2、添加回复人员信息
		List<ReplyUser> replyUserList = new ArrayList<ReplyUser>();
		List<String> reps = Arrays.asList(repalyuser.split("-"));
		for(String info : reps){
			ReplyUser replyUser = new ReplyUser();
			replyUser.setDailylogid(dailylogid);
			replyUser.setId(SerialNumber.createSerial("rpuc", 4));
			replyUser.setOpercode(user.getUsercode());
			replyUser.setOpertime(new Date());
			replyUser.setReplyto(info);
			replyUserList.add(replyUser);
		}
		result = replyUserMapper.addInfoList(replyUserList);
		if (result == 0) {
            throw new RuntimeException("添加0条记录;");
        }
		return result;
		
	}
	
	/**
	 * 问题建议列表
	 */
	public Map<String,Object> ProblemList(
			int page,int pageSize,Date starttime,
			Date endtime,String keywords,String usercode){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currpage", page); 
		page = (page-1)*pageSize;
		map.put("page", page);
		map.put("pageSize", pageSize);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("keywords", keywords);
		map.put("usercode", usercode);
		List<Map<String,Object>>  dailyLogs = dailyLogMapper.sltProblems(map);
		int total = dailyLogMapper.sltProblemscount(map);
		int tatalpage = 0;
		if(total != 0){
			if(total%pageSize!=0){
				tatalpage = total/pageSize+1;
			}else{
				tatalpage = total/pageSize;
			}
		}
		map.put("total", total);
		map.put("dailyLogs", dailyLogs);
		map.put("tatalpage", tatalpage);
		List<DailyLogResumeCount> resc = dailyLogResumeCountMapper.getAllList(map);
		map.put("resc", resc);
		return map;
	}
	
	public List<Map<String,Object>> getWeiXinListByMap(Map<String,Object> map){
		return dailyLogMapper.getWeiXinListByMap(map);
	}
	public int getWeiXinListCountByMap(Map<String,Object> map){
		return dailyLogMapper.getWeiXinListCountByMap(map);
	}
}



