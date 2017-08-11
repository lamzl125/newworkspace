<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务详情</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
</head>
<style type="text/css">
a.binding {
    display: inline-block;
    width: 70px;
    background: #46b546;
    color: #fff;
    float: left;
}
a.viewKH {
    display: block;
    float: right;
    background: #009fe8;
    color: #fff;
    width: 70px;
}
tr td {
    width: 100px;
}
td a:first-child {
    margin-left: 5px;
}
td a:last-child {
    margin-right: 5px;
}
a.companyView {
    display: inline-block;
    background: #009fe8;
    width: 50px;
    color: #fff;
}
.layui-layer-btn {
	text-align: center;
	background: #f6f6f6;
}
</style>
<body>
	<jsp:include page="/views/Top.jsp"></jsp:include>
	<div class="whh_wraper">
		<div class="whh_content whh_content_border">
			<h2 class="whh_h2_bg">
				<span>任务详情</span>
			</h2>
			<div class="whh_tab_bor"></div>
			<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="whh_tab1">
					<thead>
						<tr>
							<th>方向</th>
							<th>地区</th>
							<th>级别</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>任务量</th>
							<th>公司需求详情</th>
							<th style="width: 140px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="item">
							<tr item="${item.id }">
								<td item="${item.Technologydirection }">${item.name }</td>
								<td item="${item.AreaId }">${item.AreaName }</td>
								<td item="${item.Demandyears }">${item.gradename }</td>
								<td item="${item.Technologydirection }"><fmt:formatDate value="${item.starttime }" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${item.endtime }" pattern="yyyy-MM-dd"/></td>
								<td item="${item.allotnum }">${item.allotnum }</td>
								<td><a href="javascript:void(0);" class="companyView">查看</a></td> 
								<td><a href="javascript:void(0);" class="binding">绑定客户</a>
									<a href="javascript:void(0);" class="viewKH">查看客户</a></td>
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
</body>
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
<script type="text/javascript" src="/views/taskallot/HR_taskdetails/js/hr_taskdetails.js"></script>
<script type="text/javascript">
	function togetListBypage(page){
	 	var url = "/taskallotdetails/queryTaskAllotDetails.do?page="+page;
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
	 	var url = "/taskallotdetails/queryTaskAllotDetails.do?page="+(page+1);
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
	 	var url = "/taskallotdetails/queryTaskAllotDetails.do?page="+(page-1);
	 	window.location.href=url;
	}
	function topageInfo(){
	 	var topage = $("#topage").val();
	 	var url = "/taskallotdetails/queryTaskAllotDetails.do?page="+topage;
		window.location.href=url;
	}
</script>
</html>