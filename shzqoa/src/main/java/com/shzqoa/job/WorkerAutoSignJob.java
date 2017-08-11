package com.shzqoa.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.shzqoa.model.User;
import com.shzqoa.model.WorkerSign;
import com.shzqoa.service.UserService;
import com.shzqoa.service.WorkerSignService;
import com.shzqoa.util.AllotUtil;
import com.shzqoa.util.RandomUtil;
import com.shzqoa.util.ResourceUtil;
import com.shzqoa.util.SerialNumber;

@Component
public class WorkerAutoSignJob {
	Logger log = Logger.getLogger("CommJob");
	@Resource
	private WorkerSignService workerSignService;
	@Resource
	private UserService userService;
	
	
    public void commtask(){  
    	log.info("普工自动分配任务开始");
    	Map<String,Object> acMap= new HashMap<String,Object>();
    	//1、分配超过3天就无效
    	log.info("普工分配超过3天失效");
    	workerSignService.updateOverdue(acMap);	
    	
    	//2、查询在职普工
    	log.info("查询在职普工");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("groupname", "工厂招聘组");
		map.put("userStatus", 1);
		List<User> userlist = userService.getGroupInUsers(map);
		List<User> alluser = userService.getAllUsers();
		
		
		int totalcount = 0;//总普工数量
		Map<String,List<Map<String,Object>>> resultmap = new HashMap<String,List<Map<String,Object>>>();//分配结果		
		log.info("查询昨日放弃的普工");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		Date yesterday = cal.getTime();
		acMap.put("yesterday", yesterday);
		List<Map<String,Object>> giveuplist = workerSignService.giveupworkerlist(acMap);
		totalcount += giveuplist.size();
		log.info("开始分配昨日放弃的普工");
		for(int m=0;m<giveuplist.size();m++){
			Map<String,Object> giveupinfo = giveuplist.get(m);
			//判断是否有分配指定人员
			if(giveupinfo.get("IntentionUserCode")!=null&& !"".equals(giveupinfo.get("IntentionUserCode"))){
				String[] srarr = giveupinfo.get("IntentionUserCode").toString().split(",");
				if(srarr!=null && srarr.length>0){
					String urcode = srarr[0];
					List<Map<String,Object>> ilists = resultmap.get(urcode);
					if(ilists==null || ilists.size()<=0){
						ilists = new ArrayList<Map<String,Object>>();
					}
					ilists.add(giveupinfo);
					resultmap.put(urcode, ilists);
				}
			}else{
				List<Map<String,Object>> ulist = new ArrayList<Map<String,Object>>();
				ulist.add(giveupinfo);
				totalcount++;
				List<User> otherusers = userlist;
				otherusers.remove((String)giveupinfo.get("AddPeople"));
				resultmap = AllotUtil.allotOfRandom(otherusers,ulist,resultmap);
			}
		}
		
		
		
		
    	
    	
		log.info("查询n天未跟踪的普工");		
		for(User userinfo:alluser){
			acMap.put("usercode", userinfo.getUsercode());
			//2、查询满足未关闭需求的技术方向且n天未跟踪的简历
			acMap.put("minday", ResourceUtil.DISMINDAY);
			acMap.put("maxday", ResourceUtil.DISMAXDAY);
			List<Map<String,Object>> demteresmelist = workerSignService.demteworkerlist(acMap);
			totalcount += demteresmelist.size();
			List<User> otherusers = userlist;
			otherusers.remove(userinfo.getUsercode());
			resultmap = AllotUtil.allotOfRandom(otherusers,demteresmelist,resultmap);
		}
		
		//计算平均数量
		int avgcount = 0;
		if((totalcount % userlist.size()) > 0){
			avgcount = totalcount/userlist.size()+1;
		}else{
			avgcount = totalcount/userlist.size();
		}
		log.info("未跟踪普工平均分配的数量为："+avgcount);
		//缺少的数量
		int lackcount = 0;
		
		
		
		log.info("开始获取多余的普工和需要分配的人员及数量");
		//获取多余的简历和需要分配的人员及数量
		if(resultmap!=null && resultmap.size()>0){
			//需再次给人员分配数量
			Map<String,Integer> useraddcount = new HashMap<String,Integer>();
			//分配多的需求
			List<Map<String,Object>> signlist = new ArrayList<Map<String,Object>>();		
			 for (Map.Entry<String, List<Map<String,Object>>> entry : resultmap.entrySet()) {
				 String usercode = entry.getKey();
				 List<Map<String,Object>> indexrsultmap = entry.getValue();
				 if(indexrsultmap.size()<avgcount){
					 //分配数量少
					 useraddcount.put(usercode, avgcount-indexrsultmap.size());
					 log.info("用户："+usercode+"需再次分配"+(avgcount-indexrsultmap.size())+"个普工");
					 lackcount+=avgcount-indexrsultmap.size();
				 }else if(indexrsultmap.size()>avgcount){
					//分配数量多
					 while(indexrsultmap.size()>avgcount){
						 Map<String,Object> info = RandomUtil.getRandomElement(indexrsultmap);
						 signlist.add(info);
						 indexrsultmap.remove(info);
					 }
				 }
			  }
			 log.info("分配后缺少的数量为："+lackcount+"个普工");
			 for (Map.Entry<String,Integer> entry : useraddcount.entrySet()) {
				 String userc = entry.getKey();
				 while(entry.getValue()>1){
					 Map<String,Object> info = RandomUtil.getRandomElement(signlist);
					 resultmap.get(userc).add(info);
					 signlist.remove(info);
					 useraddcount.put(userc, entry.getValue()-1);					 
				 }
			 }
			 Iterator<String> it = useraddcount.keySet().iterator();
			 while (it.hasNext()) {
				 String userc = it.next();
				 while(signlist.size()>0){
					 Map<String,Object> sinfo = signlist.get(0);
					 resultmap.get(userc).add(sinfo);
					 signlist.remove(sinfo);
					 useraddcount.put(userc, 0);	
				 }
			 }
		}
		
		
		//不够时需要选以上的
		log.info("不够时需要选n天以上未联系的的");
		if(ResourceUtil.RGDISTAUTO>=avgcount){
			acMap.put("minday", ResourceUtil.DISMAXDAY);
			acMap.put("maxday", 9999999);
			acMap.put("start", 0);			
			acMap.remove("usercode");			
			if(resultmap!=null && resultmap.size()>0){
				if(lackcount>0){
					acMap.put("pageSize", lackcount);
				}else{
					acMap.put("pageSize", ResourceUtil.RGDISTAUTO);
				}
				List<Map<String,Object>> demteresmelist = workerSignService.demteworkerlist(acMap);
				if(demteresmelist!=null && demteresmelist.size()>0){
					for (Map.Entry<String, List<Map<String,Object>>> entry : resultmap.entrySet()) {
						String usercode = entry.getKey();
						 List<Map<String,Object>> rsultlist = entry.getValue();
						 while(rsultlist.size()<ResourceUtil.RGDISTAUTO){
							 while(demteresmelist==null || demteresmelist.size()<=0){
								 demteresmelist = workerSignService.demteworkerlist(acMap);
							 }
							 Map<String,Object> info = RandomUtil.getRandomElement(demteresmelist);
							 resultmap.get(usercode).add(info);
							 demteresmelist.remove(info);
						 }
					}
				}
			}else{
				for(int y =0;y<userlist.size();y++){
					acMap.put("pageSize", ResourceUtil.RGDISTAUTO);
					List<Map<String,Object>> demteresmelist = workerSignService.demteworkerlist(acMap);
					User user = userlist.get(y);
					List<Map<String,Object>> ustask = resultmap.get(user.getUsercode());
					while(ustask == null || ustask.size()<ResourceUtil.RGDISTAUTO && demteresmelist.size()>0){
						Map<String,Object> info = RandomUtil.getRandomElement(demteresmelist);
						if(ustask==null){
							ustask = new ArrayList<Map<String,Object>>();
						}
						ustask.add(info);
						demteresmelist.remove(info);
					}
					resultmap.put(user.getUsercode(), ustask);
				}
			}
		}
		
		log.info("普工分配列表");
		List<WorkerSign> signslist = new ArrayList<WorkerSign>();
    	for (Map.Entry<String, List<Map<String,Object>>> entry : resultmap.entrySet()){
    		String keystr = entry.getKey();
    		List<Map<String,Object>> list = entry.getValue();
    		for(Map<String,Object> info :list){
    			WorkerSign sign = new WorkerSign();
    			sign.setWorkerId(info.get("WorkerId").toString());
    			sign.setSignedTime(new Date());
    			sign.setSignId(SerialNumber.createSerial("cs", 10));
    			sign.setSignStatus(1);
    			sign.setUserCode(keystr);
    			signslist.add(sign);
    		}
		}
    	if(signslist!=null && signslist.size()>0){
    		workerSignService.addList(signslist);
    	}
    	log.info("普工自动分配任务结束");
    }  
    
    
    
    
   
}
