package com.ying.app.res;

import java.io.Serializable;

public class Res implements Serializable {
	private static final long serialVersionUID = 1L;
	private String result="1";////0 成功 1 失败
	private String resultNote="系统繁忙";//响应结果描述	失败时填写失败原因
	private String uid;

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResultNote() {
		return resultNote;
	}
	public void setResultNote(String resultNote) {
		this.resultNote = resultNote;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}

