package com.ying.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ying.dao.IMemberDao;

import com.ying.entity.Member;
@Service("memberService")
@Transactional
public class MemberService implements IMemberService{
	@Autowired
	@Qualifier("memberDao")
	private IMemberDao dao;
	
	@Override
	public Member queryByMobielOrEmail(String str) {
		return dao.queryByMobielOrEmail(str);
	}
	@Override
	public Member queryByUid(String str) {
		return dao.queryByUid(str);
	}
	
	@Override
	public Member saveMem(Member m) {
		return dao.saveMem(m);
	}

	@Override
	public boolean upPwd(Member m, String newPwd) {
		return dao.upPwd(m, newPwd);
	}

	@Override
	public boolean uploadMemberIcon(int memberId, String url) {
		return dao.uploadMemberIcon(memberId, url);
	}

	@Override
	public Member queryMemberById(int id) {
		return dao.queryMemberById(id);
	}

	@Override
	public boolean updateMmeberState(int id, int state) {
		return dao.updateMmeberState(id, state);
	}

	@Override
	public boolean upstate(int id, int state) {
		return dao.upstate(id, state);
	}

	@Override
	public boolean deleteFriend(int memberId, int friendId) {
		return dao.deleteFriend(memberId, friendId);
	}
	
	//10.1上传图片
	@Override
	public boolean upPhotos(int memberId, String photoUrl, String imageInfo) {
		
		return dao.upPhotos(memberId,photoUrl,imageInfo);
	}
	//收藏店铺
	@Override
	public boolean saveUserFav(String uid, String shopNum) {
	
		return 	dao.saveUserFav(uid,shopNum);
		
	}
	//取消收藏店铺
	@Override
	public boolean cancleUserFav(String uid, String shopNum) {
		
		return dao.cancleUserFav(uid,shopNum);
	}
	
}
