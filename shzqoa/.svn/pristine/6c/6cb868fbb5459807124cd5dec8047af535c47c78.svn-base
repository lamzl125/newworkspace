<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务分配详情</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
 <script type="text/javascript">
    function togetListBypage(page){
	  	var id = $("#taskallotid").val();
   		var url = "/InterView/ViewList.do?taskallotid="+id+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var id = $("#taskallotid").val();
   		var url ="/InterView/ViewList.do?taskallotid="+id+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var id = $("#taskallotid").val();
   		var url ="/InterView/ViewList.do?taskallotid="+id+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
   		var topage = $("#topage").val();
   		var id = $("#taskallotid").val();
   		var url = "/InterView/ViewList.do?taskallotid="+id+"&page="+topage;
    	window.location.href=url;
    }
  </script>
</head>
<body>
	<input type="hidden" value="${taskallotid }" id="taskallotid"/>
	<div class="contains">
		<div class="whh_tab_bor">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"
				class="whh_tab1">
				<thead>
					<tr>
						<th>客户</th>
						<th>安排面试时间</th>
						<th>实际面试时间</th>
						<th>面试情况</th>
						<th>是否入职</th>
						<th>更新</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="t">
						<tr  item="${t.id }">
							<td><a href="javascript:void(0);" class="redirectPage" item="${t.customercode}">${t.customername }</a></td>
							<td><fmt:formatDate value="${t.plantime }" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${t.realitytime }" pattern="yyyy-MM-dd"/></td>
							<td><c:if test="${t.issuccess==0 }">待面试</c:if>
							<c:if test="${t.issuccess==1 }">失败</c:if>
							<c:if test="${t.issuccess==2 }">成功</c:if></td>
							<td><c:if test="${t.isentry==0 }">否</c:if>
							<c:if test="${t.isentry==1 }">是</c:if>
							<c:if test="${t.isentry=='' }">否</c:if></td>
							<td><a href="javascript:void(0);"  class="payEdit">更新</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
		   <!-- 页码开始 -->
              <div class="od_pages clearfix">
                <div class="travels_diary_page">
                	<c:if test="${tatalpage>1 && currpage != 1}">
                		<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
                	</c:if>
                  <c:if  test="${tatalpage<=3}">
	                  <c:forEach var="item" begin="1" end="${tatalpage}" varStatus="status">
	                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
	                  </c:forEach>
                  </c:if>
                  <c:if  test="${tatalpage>3}">
                  		<c:if test="${currpage>=3}">
                  			<c:if test="${currpage==tatalpage}">
                  				<c:forEach var="item" begin="${currpage-2}" end="${currpage}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			<c:if test="${currpage!=tatalpage}">
                  				<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			
                  		</c:if>
                  		<c:if test="${currpage<3}">
	                  		<c:forEach var="item" begin="1" end="3" varStatus="status">
		                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
		                    </c:forEach>
	                    </c:if>
	                    <c:if test="${currpage != tatalpage}">
	                    	<span class="ellipsis">...</span>
	                    </c:if>
                  		
                  </c:if>
				  <c:if test="${tatalpage>1}">
				  		<c:if test="${currpage < tatalpage}">
				  			<span class="next_page" onclick="tonextpageInfo(${currpage})">下一页</span>
				  		</c:if>
	                  <span class="reach_desc">到</span>
	                  <input type="text" id="topage">
	                  <span class="confirm_btn" onclick="topageInfo()">确定</span>
				  </c:if>
                  
                </div>
              </div>
	
</body>
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/views/taskallot/HR_taskdetails/js/hr_taskdetails.js"></script>
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
</html>