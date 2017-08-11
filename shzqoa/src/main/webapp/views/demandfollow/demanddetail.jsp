<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>需求详情信息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link href="/views/common/css/lanren.css" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" />
<!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" />
<!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
<script src="/views/common/js/jquery.min.js" type="text/javascript"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js"
	type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script>
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<style type="text/css">
.whh_tab1 td {
	padding: 10px 0;
}
</style>
<script type="text/javascript">
    function whowfollow(demandresumeId,thistr){
    	$(".whh_tab1 tr").removeClass("onSelect");	
    	$(thistr).addClass("onSelect");
    	$("#followPart").load("/demandFollow/followOfResume.do?demandResumeId="+demandresumeId);
    }
    $(document).ready(function(){
  	  initMemu(1,7);
    });
    function toflow(demandresumeId){
//     	var demandresumeId = $("#demandresumeId").val();
        	layer.open({
    		  type: 2,
    		  title: '跟踪需求简历',
    		  area: ['900px', '600px'],
    		  skin: 'layui-layer-rim',
    		  content: "/demandFollow/toFollow.do?demandResumeId="+demandresumeId 
    		  //content: '/views/unassigneddemand/followinfo.jsp' 
    		}); 
        }
    function search(){
    	var customername = $("#customername").val();
    	var demandId = $("#demandId").val();    	
    	var url = "/demandFollow/demandDetail.do?demandId="+demandId;
    	if(customername!=null && customername!=''){
    		url += "&customername="+customername;
    	}
    	window.location.href=url;
    }
      function togetListBypage(page){
    	  var customername = $("#customername").val();
      	var demandId = $("#demandId").val();    	
      	var url = "/demandFollow/demandDetail.do?page="+page+"&demandId="+demandId;
      	if(customername!=null && customername!=''){
    		url += "&customername="+customername;
    	}
      	window.location.href=url;
      }
      function tonextpageInfo(page){
    	var customername = $("#customername").val();
       	var demandId = $("#demandId").val();    	
       	var url = "/demandFollow/demandDetail.do?page="+(page+1)+"&demandId="+demandId;
       	if(customername!=null && customername!=''){
     		url += "&customername="+customername;
     	}
      	window.location.href=url;
      }
      function toprevpageInfo(page){
      	var customername = $("#customername").val();
       	var demandId = $("#demandId").val();    	
       	var url = "/demandFollow/demandDetail.do?page="+(page-1)+"&demandId="+demandId;
       	if(customername!=null && customername!=''){
     		url += "&customername="+customername;
     	}
      	window.location.href=url;
      }
      function topageInfo(){
      	var topage = $("#topage").val();
      	var customername = $("#customername").val();
       	var demandId = $("#demandId").val();    	
       	var url = "/demandFollow/demandDetail.do?page="+topage+"&demandId="+demandId;
       	if(customername!=null && customername!=''){
     		url += "&customername="+customername;
     	}
      	window.location.href=url;
      }
  </script>
</head>
<body>
	<input type="hidden" id="curruserid" value="${user.usercode}">
	<input type="hidden" id="customercode"
		value="${customerInfo.customercode}">
	<input type="hidden" id="demandId" value="${demandDetail.Id}">
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="待招人员" class="tip-bottom"><i
					class="icon-home"></i>待招人员</a> <a href="index.html" title="需求跟踪列表"
					class="tip-bottom"><i class="icon-home"></i>需求跟踪列表</a> <a href=""
					title="需求详情信息" class="current">需求详情信息</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>需求详情信息</h5>
					<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onClick="javascript:window.history.go(-1)">上一步</button>
				</div>
				<div class="widget-content clearfix">
					<form name="signupForm" method="post" id="signupForm"
						class="form-inline">
						<ul class="whh_ul">
							<li>客户编号: <label><c:if test="${managerflag==1}">
			                       ${demandDetail.CorpName }
			                   </c:if> <c:if test="${managerflag==0}">
			                       ${demandDetail.CorpCode }
			                   </c:if> </label></li>
							<li>技术方向: <label>${demandDetail.name }</label></li>
							<li>项目地点: <label>${demandDetail.AreaName }</label></li>
							<li>级别: <label>${demandDetail.gradename }</label></li>
							<li>学历要求: <label>${demandDetail.Education }</label></li>
							<li>需求人数: <label><c:choose>
										<c:when test="${demandDetail.Demandnumber>0 }">${demandDetail.Demandnumber }</c:when>
										<c:otherwise>不限</c:otherwise>
									</c:choose> </label></li>
							<li>需求名称:<label>${demandDetail.Projecttype }</label></li>
							<li>重要级别: <label> <c:forEach items="${imporList}"
										var="important">
										<c:if test="${demandDetail.Importantlevel==important.id }">${important.name }</c:if>
									</c:forEach>
							</label></li>
							<li style="width: 100%;">技术要求: <label>${demandDetail.Specificrequirement }</label></li>
							<li style="width: 100%;">详细地址: <label>${demandDetail.Address }</label></li>
							<li style="width: 100%;">备注其他: <label>${demandDetail.Remarks }</label></li>
						</ul>
						<div class="zyh_sosu">
							<span> 客户： </span> <input type="text" class="zyh_txt whh_input"
								id="customername" value=${customername}> <input
								type="button" class="zyh_btn" value="查询" onclick="search()">
						</div>
						<table class="table table-bordered table-striped with-check">
							<colgroup>
								<col width="10%" />
								<col width="10%" />
								<col width="10%" />
								<col width="10%" />
								<col width="40%" />
								<col width="10%" />
								<col width="10%" />
							</colgroup>
							<thead>
								<tr>
									<th>简历名称</th>
									<th>抢取人</th>
									<th>抢取/分配时间</th>
									<th>抢取顺序</th>
									<th>比例</th>
									<th>更新时间</th>
									<th>更新状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${demandresumeList }" var="demandresume">
									<tr onclick="whowfollow('${demandresume.Id}',this)">
										<td>${demandresume.CustomerName }</td>
										<td>${demandresume.realName }</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
												value="${demandresume.SignedTime }" /></td>
										<td>${demandresume.SingnedIndex }</td>
										<td>${demandresume.Proportion }%</td>
										<td><c:forEach items="${lasfollowList }" var="lastfollow">
												<c:if test="${lastfollow.Id==demandresume.Id}">
													<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
														value="${lastfollow.lastfollowtime}" />
												</c:if>
											</c:forEach></td>
										<td><c:forEach items="${lasfollowList}" var="lastfollow">
												<c:if test="${lastfollow.Id==demandresume.Id}">
													<c:choose>
														<c:when test="${lastfollow.ArrangeEntryStatus==1}">安排入项</c:when>
														<c:when test="${lastfollow.ArrangeEntryStatus==0}">未安排入项</c:when>
														<c:when
															test="${lastfollow.RetestStatus==1&&lastfollow.RetestResultStatus==1}">通过复试</c:when>
														<c:when
															test="${lastfollow.RetestStatus==1&&lastfollow.RetestResultStatus==2}">未通过复试</c:when>
														<c:when
															test="${lastfollow.RetestStatus==1&&lastfollow.RetestResultStatus==0}">未参加复试</c:when>

														<c:when
															test="${lastfollow.RetestStatus==1&&lastfollow.RetestResultStatus==null}">通过面试需复试</c:when>
														<c:when test="${lastfollow.RetestStatus==0}">通过面试无需复试</c:when>
														<c:when
															test="${lastfollow.RetestStatus==null&&lastfollow.InterviewResultStatus==1}">通过面试</c:when>
														<c:when
															test="${lastfollow.RetestStatus==null&&lastfollow.InterviewResultStatus==2}">未通过面试</c:when>
														<c:when
															test="${lastfollow.NoticeInterviewStatus==1&&lastfollow.RetestStatus==0&&lastfollow.InterviewResultStatus==0}">未参加面试</c:when>
														<c:when
															test="${lastfollow.NoticeInterviewStatus==1 && lastfollow.InterviewResultStatus == null}">通知面试</c:when>
														<c:when test="${lastfollow.ScreeningResumesStatus==1}">简历筛选通过</c:when>
														<c:when test="${lastfollow.ScreeningResumesStatus==0}">简历筛选未通过</c:when>
														<c:when test="${lastfollow.SendResumeStatus==2}">简历已发客户</c:when>
														<c:when test="${lastfollow.SendResumeStatus==1}">简历未发客户</c:when>
													</c:choose>
												</c:if>
											</c:forEach></td>
										<td><a href="javascript:void(0)"
											class="whh_btn whh_btn_big mt20 whh_btn_big_or"
											onclick="toflow('${demandresume.Id}')">跟踪</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!--分页-->
						<div class="pagination alternate page_fr">
							<ul>
								<li <c:if test="${currpage<=1}">class="disabled"</c:if>><a
									href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
								<c:if test="${tatalpage>=currpage}">
									<li class="active"><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage})">${currpage}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+1)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+1})">${currpage+1}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+2)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+2})">${currpage+2}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+3)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+3})">${currpage+3}</a></li>
								</c:if>
								<li><a href="javascript:void(0)"
									onclick="tonextpageInfo(${currpage})">Next</a></li>
							</ul>
						</div>

						<div id="followPart"></div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>