package com.ying.app.req;

public class PsrecordListReq extends Req{
    private String uid;
    private String type;  //1.揽件记录 2.派件记录 3.完成记录 4.退件记录
    private String nowPage; //(当前页数，每页10条)
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNowPage() {
		return nowPage;
	}
	public void setNowPage(String nowPage) {
		this.nowPage = nowPage;
	}
    
}
