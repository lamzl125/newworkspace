package com.shzqoa.model;

import java.util.Date;

public class DemandNote {
    private String demandnoteid;//需求帖子
    private String customerdemandid;//需求ID
    private String corpcode;//客户公司编号
    private String workdemandid;//普工需求Id
    private Long factoryid;//厂区
    private Long notesourceid;//帖子来源
    private String notename;//帖子名称
    private Date noteaddtime;//发贴时间
    private String noteaddpeople;//发帖人
    private Date addtime;//跟踪添加时间
    private String addpeople;//跟踪人
    private Long daypageview;//最后更新日浏览量
    private Long allpageview;//最后更新总浏览量
    private Integer notestatus;//帖子状态（1-正常  2-待关闭   3-关闭）
    private String remark;//备注

    public String getDemandnoteid() {
        return demandnoteid;
    }

    public void setDemandnoteid(String demandnoteid) {
        this.demandnoteid = demandnoteid == null ? null : demandnoteid.trim();
    }

    public String getCustomerdemandid() {
        return customerdemandid;
    }

    public void setCustomerdemandid(String customerdemandid) {
        this.customerdemandid = customerdemandid == null ? null : customerdemandid.trim();
    }

    public String getCorpcode() {
        return corpcode;
    }

    public void setCorpcode(String corpcode) {
        this.corpcode = corpcode == null ? null : corpcode.trim();
    }

    public String getWorkdemandid() {
        return workdemandid;
    }

    public void setWorkdemandid(String workdemandid) {
        this.workdemandid = workdemandid == null ? null : workdemandid.trim();
    }

    public Long getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(Long factoryid) {
        this.factoryid = factoryid;
    }

    public Long getNotesourceid() {
        return notesourceid;
    }

    public void setNotesourceid(Long notesourceid) {
        this.notesourceid = notesourceid;
    }

    public String getNotename() {
        return notename;
    }

    public void setNotename(String notename) {
        this.notename = notename == null ? null : notename.trim();
    }

    public Date getNoteaddtime() {
        return noteaddtime;
    }

    public void setNoteaddtime(Date noteaddtime) {
        this.noteaddtime = noteaddtime;
    }

    public String getNoteaddpeople() {
        return noteaddpeople;
    }

    public void setNoteaddpeople(String noteaddpeople) {
        this.noteaddpeople = noteaddpeople == null ? null : noteaddpeople.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getAddpeople() {
        return addpeople;
    }

    public void setAddpeople(String addpeople) {
        this.addpeople = addpeople == null ? null : addpeople.trim();
    }

    public Long getDaypageview() {
        return daypageview;
    }

    public void setDaypageview(Long daypageview) {
        this.daypageview = daypageview;
    }

    public Long getAllpageview() {
        return allpageview;
    }

    public void setAllpageview(Long allpageview) {
        this.allpageview = allpageview;
    }

    public Integer getNotestatus() {
        return notestatus;
    }

    public void setNotestatus(Integer notestatus) {
        this.notestatus = notestatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}