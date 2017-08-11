package com.ying.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.utils.DateTimeUtil;
import org.utils.Logs;
import org.utils.StringUtils;
import org.utils.Tool;

import com.ying.dao.EntityDao;
import com.ying.dao.IMemberDao;

import com.ying.entity.Member;
import com.ying.entity.MemberQuota;

@Repository("memberDao")
public class MemberDao extends EntityDao implements IMemberDao {

	@Override
	public Member queryByMobielOrEmail(String str) {
		Member m=new Member();
		try {
			String sql="";
			if(Tool.isMobile(str)){
				sql="select m.* from t_member m where m.phone_num=?";
			}else{
				sql="select m.* from t_member m  where m.third_uid=?";
			}
			m=getEntity(Member.class,sql,new Object[]{str});
		} catch (Exception e) {
			Logs.error(e);
		}
		return m;
	}
	//根据传入的uid获取用户
	@Override
	public Member queryByUid(String str) {
		Member m=new Member();
		MemberQuota mq = new MemberQuota();
		try {
			String sql="";
			if(str != null){
				sql="select m.* from t_member m  where m.id=?";
			}
			m=getEntity(Member.class,sql,new Object[]{str});
			if (m!=null) {
				String sql2="select m.* from t_member_quota m  where m.uid=?";
				mq=getEntity(MemberQuota.class,sql2,new Object[]{str});
				m.setStatus(mq.getStatus());
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return m;
	}
	@Override
	public Member saveMem(Member m) {
		try {
			if(m.getId()==null){
				Map<String, Object> pa=new HashMap<String, Object>();
				pa.put("phone_num", m.getPhoneNum());
				pa.put("password", m.getPassword());
				pa.put("user_icon", m.getUserIcon());
				pa.put("third_uid", m.getThirdUid());
				pa.put("recommended_code", m.getRecommendedCode());
				pa.put("service_code", m.getServiceCode());
				if (m.getUserName()!=null) {
					pa.put("user_name", m.getUserName());
				}else {
					pa.put("user_name", "用户"+String.valueOf(Math.random()).substring(3,8));
				}
				pa.put("statue", 1);
				pa.put("adtime", new Date());
				pa.put("servictime", new Date());
				Long id=insert(pa, "t_member");
				if(id!=null && id!=-1){
					String sql="select m.* from t_member m where id ="+id;
					m=getEntity(Member.class,sql,new Object[]{});
					//存储服务码下次可修改时间
					try {
						if (!"".equals(m.getServiceCode()) && m.getServiceCode()!=null) {
							String sql2="update t_member set servictime=DATE_ADD(servictime,INTERVAL 3 month) where id="+id;
							getJt().update(sql2,new Object[]{});
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					return m;
				}
			}else{
				String s="update t_member set phone_num=?,recommended_code=?,service_code=?,user_name=?,token=? where id=?";
				getJt().update(s,new Object[]{m.getPhoneNum(),m.getRecommendedCode(),m.getServiceCode(),m.getUserName(),m.getToken(),m.getId()});
				String sql="select m.* from t_member m where id ="+m.getId();
				m=getEntity(Member.class,sql,new Object[]{});
				return m;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	@Override
	public boolean upPwd(Member m, String newPwd) {
		try {
			String sql="update t_member set password=? where id=?";
			getJt().update(sql,new Object[]{newPwd,m.getId()});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean uploadMemberIcon(int memberId, String url) {
		try {
			String sql="update t_member set usericon=? where id=?";
			getJt().update(sql,new Object[]{url,memberId});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public Member queryMemberById(int id) {
		Member m=null;
		try {
			String sql="select t.*,s.score from t_member t left join t_member_score s on t.id=s.member_id where t.id=?";
			m=getEntity(Member.class,sql,new Object[]{});
		} catch (Exception e) {
		}
		return m;
	}

	@Override
	public boolean updateMmeberState(int id, int state) {
		try {
			String sql="update t_member set state=? where id=?";
			getJt().update(sql,new Object[]{state,id});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean upstate(int id, int state) {
		try {
			String sql="update t_friends set state=? where id=?";
			getJt().update(sql,new Object[]{state,id});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean deleteFriend(int memberId, int friendId) {
		try {
			String sql="update t_friends set state=9 where member_id=? and friend_id=?";
			getJt().update(sql,new Object[]{memberId,friendId});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}
	
	@Override
	public boolean upPhotos(int memberId, String photoUrl, String imageInfo) {
		try {
			Map<String, Object> ap = new HashMap<String, Object>();
			ap.put("photo_info",imageInfo);
			ap.put("photo_url",photoUrl);				
			ap.put("uid", memberId);
			Long id=insert(ap,"t_member_photos");
			if(id != null && id != -1){
				return true;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}
	//收藏店铺
	@Override
	public boolean saveUserFav(String uid, String shopNum) {

		try{	
			String sql="delete from t_member_collect where collect_id = " + shopNum + " and user_id = " + uid;
			getJt().update(sql,new Object[]{});
			Map<String, Object> ap = new HashMap<String, Object>();
			ap.put("user_id", uid);
			ap.put("collect_id",shopNum);			
			ap.put("adtime", new Date());
			Long id = insert(ap,"t_member_collect");
			if(id != null && id != -1){
				return true;
			}			
		}catch(Exception e){
			Logs.error(e);
		}
		return false;
	
		
	}
	//取消收藏
	@Override
	public boolean cancleUserFav(String uid, String shopNum) {
		try {
			String sql="delete from t_member_collect where collect_id = " + shopNum + " and user_id = " + uid;
			getJt().update(sql,new Object[]{});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

}
