package com.shzqoa.util;
/*
 * 分页的封装类
 */
import java.util.List;

public class Pager<T> {
	private List<T> records;
	private Integer counts;
	private Integer pageNo=1;
	private Integer pageSize=2;
	private Integer maxPageNo;
	
	public Integer getMaxPageNo() {
		if (counts>0) {
			if (counts%pageSize>0) {
				return counts/pageSize+1;
			}else {
				return counts/pageSize;
			}
			
		}
		return 1;
	}
	public void setMaxPageNo(Integer maxPageNo) {
		this.maxPageNo = maxPageNo;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public Integer getCounts() {
		return counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getOffSet(){
		return (pageNo-1)*pageSize;
	}
	
	public Integer getLimit(){
		return pageSize;
	}
	
}
