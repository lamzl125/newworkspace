package com.ying.app.req;

import java.io.Serializable;

/**
 * 请求包
 *
 */
public class Req implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cmd;//请求 指令
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
}
