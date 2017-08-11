package org.utils;


public class PageContainer {

	private static final int containerSize = 10;// 容器容量(包含的页数)
	
	private long currIndex = 1;// 当前页索引
	private long currPageNo = 1;// 当前页索引对应的页号
	private long totalPages = 0;// 总页数
	private long currSize = 0;// 当前包含页数

	
	public long getCurrIndex() {
		return currIndex;
	}


	public long getCurrSize() {
		return currSize;
	}
	
	
	public boolean getHasPre(){
//		if(currPageNo<=containerSize){
//			return false;
//		}
		if(currPageNo<=1)
			return false;
		return true;
	}	
	

	public boolean getHasNext(){
//		if(currSize<containerSize){
//			return false;
//		}else if(currPageNo -currIndex + containerSize>=totalPages){
//			return false;
//		}
		if(currPageNo>=totalPages)
			return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PageContainer pc = new PageContainer(10,17);
		System.out.print((pc.getHasPre() ? "上一页" : ""));
		for(int i=1;i<=pc.getCurrSize();i++){
			if(i==pc.getCurrIndex()){
				System.out.print(i + "c ");
			}else{
				System.out.print(i + " ");
			}
		}
		System.out.print((pc.getHasNext() ? "下一页" : ""));
	}
	
	public PageContainer(long currPpageNo,long totalPages){
		this.currPageNo = currPpageNo;
		this.totalPages = totalPages;
		currIndex = currPageNo % containerSize;
		if(currIndex==0){
			currIndex=10;
		}
		if(currPpageNo + (containerSize-currIndex) <= totalPages){
			currSize = containerSize;
		}else{
			currSize = totalPages % containerSize;
		}
	}

}
