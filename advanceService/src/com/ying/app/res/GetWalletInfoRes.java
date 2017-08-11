package com.ying.app.res;

import java.util.ArrayList;
import java.util.List;

import com.ying.app.bean.MessageBean;
import com.ying.app.bean.MoneyListBean;
import com.ying.app.bean.UserInfo;


public class GetWalletInfoRes extends Res{
	private Long totalPage;			//总页数
	private List<MoneyListBean> moneyList = new ArrayList<MoneyListBean>();
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public List<MoneyListBean> getMoneyList() {
		return moneyList;
	}
	public void setMoneyList(List<MoneyListBean> moneyList) {
		this.moneyList = moneyList;
	}
	
	
}
