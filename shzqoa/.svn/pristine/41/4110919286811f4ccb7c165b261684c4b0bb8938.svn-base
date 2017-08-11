package com.shzqoa.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shzqoa.dao.AccountsMapper;
import com.shzqoa.model.AccountArea;
import com.shzqoa.model.Accounts;
@Service
public class AccountsService {
	@Resource
	private AccountsMapper accountsMapper;
	public List<AccountArea> selaccount(Map<String,Object> map){
		return  accountsMapper.selaccount(map);
	}
	public List<AccountArea> selectaccount(){
		return  accountsMapper.selectaccount();
	}
	public Integer getAllAreasCount(Map<String,Object> map){
		return accountsMapper.getAllAccountCount(map);
	}
	@Transactional
	public int save(Accounts accounts){
		if(accounts != null){
			return this.accountsMapper.save(accounts);
		}
		return 0;
	}
	@Transactional
	public int delete(String aid){
		if(StringUtils.isNotBlank(aid)){
			return this.accountsMapper.deleteById(aid);
		}
		return 0;
	}
	@Transactional
	public int update(Accounts accounts){
		if(accounts != null){
			return this.accountsMapper.update(accounts);
		}
		return 0;
	}
	public List<Accounts> selectUsableAccount(){
		return  accountsMapper.selectUsableAccount();
	}
}
