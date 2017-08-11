package com.ying.service;

import com.ying.entity.Member;

public interface IMemberService {
	/**
	 * 根据mobile或者user_num  或者uid 查询 
	 * @param str
	 * @return
	 */
	public Member queryByMobielOrEmail(String str);
	public Member queryByUid(String str);
	/**
	 * 保存member
	 * @param m
	 * @return
	 */
	public Member saveMem(Member m);
	/**
	 * 修改密码
	 * @param m
	 * @param newPwd
	 * @return
	 */
	public boolean upPwd(Member m,String newPwd);
	/**
	 * 修改会员头像
	 * @param memberId
	 * @param url
	 * @return
	 */
	public boolean uploadMemberIcon(int memberId,String url);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Member queryMemberById(int id);
	/**
	 * 修改会员状态
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean updateMmeberState(int id,int state);
	
	/**
	 * 修改状态 t_friends
	 * @param id
	 * @param state
	 * @return
	 */
	public boolean upstate(int id,int state);
	/**
	 * 查询我的好友state=0 查询所有 state=1 查询未通过的 state=2 查询已通过 
	 * @param memberId
	 * @param state
	 * @return
	 */
	
	/**
	 * 删除好友
	 * @param memberId
	 * @param friendId
	 * @return
	 */
	public boolean deleteFriend(int memberId, int friendId);
	/**
	 * @param intValue
	 * @param photoUrl
	 * @param imageInfo
	 * @return
	 */
	public boolean upPhotos(int memberId, String photoUrl, String imageInfo);
	/**
	 * @param string
	 * @param shopNum
	 */
	public boolean saveUserFav(String uid, String shopNum);
	/**
	 * @param string
	 * @param shopNum
	 * @return
	 */
	public boolean cancleUserFav(String uid, String shopNum);
}
