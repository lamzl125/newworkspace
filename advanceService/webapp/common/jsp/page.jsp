<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/taglibs.jsp"%>
<div class="page_r">
	<ul class="oz">
		<li class="pagePrev pageText">
			<a href="javascript:jumpPage(1);" title="首页">首页</a>
			<a href="javascript:jumpPage(${page.prePage});" title="上一页">上一页</a>
		</li>
		<li class="pageNum">
			<c:if test="${PageContainer.currIndex-3>0}">
				<a href="javascript:jumpPage(${PageContainer.currIndex-3});">${PageContainer.currIndex-3}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex-2>0}">
				<a href="javascript:jumpPage(${PageContainer.currIndex-2});">${PageContainer.currIndex-2}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex-1>0}">
				<a href="javascript:jumpPage(${PageContainer.currIndex-1});">${PageContainer.currIndex-1}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex>0}">
				<a class="on"
					href="javascript:jumpPage(${PageContainer.currIndex});">${PageContainer.currIndex}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex+1<=PageContainer.currSize}">
				<a href="javascript:jumpPage(${PageContainer.currIndex+1});">${PageContainer.currIndex+1}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex+2<=PageContainer.currSize}">
				<a href="javascript:jumpPage(${PageContainer.currIndex+2});">${PageContainer.currIndex+2}</a>
			</c:if>
			<c:if test="${PageContainer.currIndex+3<=PageContainer.currSize}">
				<a href="javascript:jumpPage(${PageContainer.currIndex+3});">${PageContainer.currIndex+3}</a>
			</c:if>
		</li>
		<li class="pageNext pageText"><a href="javascript:jumpPage(${page.nextPage});" title="下一页">下一页</a> <a
			href="javascript:jumpPage(${page.totalPages});" title="尾页">尾页</a></li>
	</ul>
</div>