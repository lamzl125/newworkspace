<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务分配</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
<style type="text/css">
	.whh_tab1{margin-top: 20px;}
</style>
</head>
<body>
	<jsp:include page="/views/Top.jsp"></jsp:include>
	<div class="whh_wraper">
		<div class="whh_content whh_content_border">
			<h2 class="whh_h2_bg">
				<span>任务统计</span>
			</h2>
			<div class="whh_tab_bor">
				<div class="zyh_sos">
                <span class="zyh_k_heigth">任务人：</span>
                <select class="whh_sel" id="opername" >
                     <option value="">请选择</option>
                     <c:forEach items="${userlist}" var="item">
                     		<option <c:if test="${opername==item.usercode}">selected</c:if> value="${item.usercode}">${item.realname}</option>
                     </c:forEach>
                </select>
				<input type="button" class="zyh_btn" value="查询" onclick="searchInfoByCon();">
            </div>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="whh_tab1">
					<thead>
						<tr>
							<th>任务人</th>
							<th>任务名称</th>
							<th>任务周期</th>
							<th>任务量</th>
							<th>实际提交简历份数</th>
							<th>实际面试人员数</th>
							<th>入职人数</th>
						</tr>
					</thead>
					<tbody id="dfp">
						<c:forEach items="${TaskList }" var="o">
							<tr item="${o.usercode}" taskid="${o.taskid }">
								<td>${o.realname }</td>
								<td>${o.name } ,${o.gradename },${o.areaName }</td>
								<td><fmt:formatDate  pattern="yyyy/MM/dd" value="${o.starttime }"/>--<fmt:formatDate  pattern="yyyy/MM/dd" value="${o.endtime }"/></td>
								<td>${o.allotnum }</td>
								<td><a href="javaScript:void:(0);" class="showuser">${o.acount }</a></td>
								<td><a href="javaScript:void:(0);" class="showinter">${o.bcount }</a></td>
								<td><a href="javaScript:void:(0);" class="showsenter">${o.ccount }</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- 页码开始 -->
				<div class="od_pages clearfix">
					<div class="travels_diary_page">
						<c:if test="${tatalpage>1 && currpage != 1}">
							<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
						</c:if>
						<c:if test="${tatalpage<=3}">
							<c:forEach var="item" begin="1" end="${tatalpage}"
								varStatus="status">
								<a href="javascript:void(0);"
									class="<c:if test='${currpage==item}'>curr</c:if>"
									onclick="togetListBypage(${item})">${item}</a>
							</c:forEach>
						</c:if>
						<c:if test="${tatalpage>3}">
							<c:if test="${currpage>=3}">
								<c:if test="${currpage==tatalpage}">
									<c:forEach var="item" begin="${currpage-2}" end="${currpage}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>
								<c:if test="${currpage!=tatalpage}">
									<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>

							</c:if>
							<c:if test="${currpage<3}">
								<c:forEach var="item" begin="1" end="3" varStatus="status">
									<a href="javascript:void(0);"
										class="<c:if test='${currpage==item}'>curr</c:if>"
										onclick="togetListBypage(${item})">${item}</a>
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
				<!-- 页码结束 -->
			</div>

		</div>
	</div>
</body>
<script type="text/javascript" src="/views/taskallot/js/taskinter.js"></script>
<script type="text/javascript">
	function togetListBypage(page){
	 	var url = "/taskallot/TaskList.do?page="+page;
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
	 	var url = "/taskallot/TaskList.do?page="+(page+1);
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
	 	var url = "/taskallot/TaskList.do?page="+(page-1);
	 	window.location.href=url;
	}
	function topageInfo(){
	 	var topage = $("#topage").val();
	 	var url = "/taskallot/TaskList.do?page="+topage;
		window.location.href=url;
	}
	function showResume(usercode){
		
	}
	function searchInfoByCon(){
		var opername = $("#opername").val();
		var url = "/taskallot/TaskList.do?opername="+opername;
		window.location.href=url;
	}
</script>
</html>