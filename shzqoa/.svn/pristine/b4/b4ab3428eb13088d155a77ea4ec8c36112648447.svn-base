package com.shzqoa.dao;

import java.util.List;
import java.util.Map;

import com.shzqoa.model.AccountArea;
import com.shzqoa.model.Accounts;

public interface AccountsMapper {

	List<AccountArea> selaccount(Map<String, Object> map);
	List<AccountArea> selectaccount();
	Integer getAllAccountCount(Map<String,Object> map);  //获取所有的账号信息
	public int save(Accounts accounts);
	public int deleteById(String aid);
	public int update(Accounts accounts);
	List<Accounts> selectUsableAccount();//查询可用的帐号
}
