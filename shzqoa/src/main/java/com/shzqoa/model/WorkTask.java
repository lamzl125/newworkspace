package com.shzqoa.model;

import java.util.Date;

/**
 * 工作任务表
 * @author Auser
 *
 */
public class WorkTask {
	private Integer taskid;           //工作任务id
	
	private String publishid;        //工作发布者id
	
	private String publishcontent;   //工作内容
	
	private String appointuserid;   //工作任务指定人员id
	
	private String realname;      // 指定人员名称
	
	private String appointgroupid;  //工作任务指定部门
	
	private Integer status;        //完成状态0-未完成 1-已完成  2-处理中 3-已处理
	
	private Date publishtime;     // 工作任务发布时间
	
	private Date confirm;          // 确认完成时间
	
	

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getPublishid() {
		return publishid;
	}

	public void setPublishid(String publishid) {
		this.publishid = publishid;
	}

	public String getPublishcontent() {
		return publishcontent;
	}

	public void setPublishcontent(String publishcontent) {
		this.publishcontent = publishcontent;
	}

	public String getAppointuserid() {
		return appointuserid;
	}

	public void setAppointuserid(String appointuserid) {
		this.appointuserid = appointuserid;
	}

	public String getAppointgroupid() {
		return appointgroupid;
	}

	public void setAppointgroupid(String appointgroupid) {
		this.appointgroupid = appointgroupid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getConfirm() {
		return confirm;
	}

	public void setConfirm(Date confirm) {
		this.confirm = confirm;
	}
	
	

}





