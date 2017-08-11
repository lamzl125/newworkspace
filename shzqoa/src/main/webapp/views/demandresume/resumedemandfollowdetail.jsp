<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>简历详情信息</title>
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
  function whowfollow(Id,thistr){
  	$(".whh_tab1 tr").removeClass("onSelect");	
  	$(thistr).addClass("onSelect");
  	$("#followPart").load("/demanresume/followOfResume.do?Id="+Id);
  }
  $(document).ready(function(){
	  initMemu(1,6);
  })
  </script>
</head>
<body>
	<input type="hidden" id="curruserid" value="${user.usercode}">
	<input type="hidden" id="customercode" value="${customerInfo.customercode}">
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="基本信息" class="tip-bottom"><i
					class="icon-home"></i>基本信息</a> <a href="" title="需求简历列表"
					class="current">需求简历列表</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>需求简历列表</h5>
				</div>
				<div class="widget-content clearfix">
					<form name="signupForm" method="post" id="signupForm"
						class="form-inline">
						<ul class="whh_ul">
							<li>姓名: <label>${customerDetail.customername}</label></li>
			                <li>性别:  
			                    	<label>
			                    		<c:choose>
									       <c:when test="${customerDetail.customersex == 0}">男</c:when>
									       <c:when test="${customerDetail.customersex == 1}">女</c:when>
									       <c:otherwise>保密 </c:otherwise>
										</c:choose>
			                    	</label></li>
			                <li>区域:  
				                <label>
				                	<c:forEach items="${areaList}" var="info">
		                    			<c:if test="${info.areaid==customerDetail.areaid}">${info.areaname}</c:if>
		                            </c:forEach>
				                </label>
			                </li>
			                <li>技术方向:  
			                	<label>
			                		<c:forEach items="${professList}" var="info">
		                    			<c:if test="${info.id==customerDetail.professionId}">${info.name}</c:if>
		                            </c:forEach>
		                            <c:if test="${customerDetail.professionId==null || customerDetail.professionId eq ''}">无</c:if>
			                	</label>
			                </li>
			                <li>录入账号:  
			                	<label>
			                		<c:forEach items="${accountlist}" var="info">
		                    			<c:if test="${info.aid==customerDetail.account}">${info.account}</c:if>
		                            </c:forEach>
			                		
			                	</label>
			                </li>
			                <li>电话:  <label>${customerDetail.customertel}</label></li>
			                <li>出生日期:  <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerDetail.customerbirth}" /></label></li>
			                <li>毕业院校: <label>${customerDetail.customeruniversity}</label></li>
		                    <li>所学专业:  <label>${customerDetail.customerspecialities}</label></li>
		                    <li>简历出处:  
		                    	<label>
		                    		<c:forEach items="${resumeSourceList}" var="info">
		                    			<c:if test="${info.resumesourceid==customerDetail.resumesource}">
		                    				${info.resumesourcename}
		                    			</c:if>
		                            </c:forEach>
		                    	</label>
		                    </li>
		                 	<li>简历ID:  <label style="font-size: 12px;">${customerDetail.resumeid}</label></li>
		                    <li>入职概率:  <label>${customerDetail.entryprobability}%</label></li>
		                 	<li>学历: 
		                    	<label>
		                    		<c:forEach items="${educationlist}" var="info">
		                    			<c:if test="${info.id==customerDetail.education}">${info.name}</c:if>
		                            </c:forEach>
		                            
		                    	</label>
		                    </li>
		                    <li>英语水平: 
		                    	<label>
		                    		<c:forEach items="${enlevellist}" var="info">
		                    			<c:if test="${info.id==customerDetail.englishLevel}">${info.name}</c:if>
		                            </c:forEach>
		                   		</label>
		                    </li>
		                    <li>日语水平: 
		                    	<label>
		                    		<c:forEach items="${japlevellist}" var="info">
		                    			<c:if test="${info.id==customerDetail.japaneseLevel}">${info.name}</c:if>
		                            </c:forEach>
		                    	</label>
		                    </li>
		                    <li>技术方向工作年限: <label>${customerDetail.directWorkLife}</label></li>
		                 	<li>添加时间: <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerDetail.addtime}" /></label></li>
		                    <li>添加人员ID:  <label>${customerDetail.opertcode}</label></td>
		                    <li>添加人员姓名: <label>${customerDetail.opertname}</label></td>
		                    <li>简历更新时间: <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerDetail.resumeupdatedate}" /></label></li>
						</ul>
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
									<th>公司名称</th>
									<th>技术方向</th>
									<th>项目地点</th>
									<th>级别</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${demandcustomer}" var="demandresume">
									<tr onclick="whowfollow('${demandresume.Id}',this)">
										<td><c:if test="${managerflag==1}">
												<c:forEach items="${corpList }" var="info">
													<c:if test="${info.corpcode==demandresume.CorpCode }">${info.corpname} </c:if>
												</c:forEach>
											</c:if> <c:if test="${managerflag!=1}">${demandresume.CorpCode}</c:if></td>
										<%-- <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${demandresume.SignedTime }" /></td> --%>
										<td><c:forEach items="${professList }" var="info">
												<c:if test="${info.id==demandresume.Technologydirection }">${info.name} </c:if>
											</c:forEach></td>
										<td><c:forEach items="${areaList}" var="info">
												<c:if test="${info.areaid==demandresume.Projectlocation}">  ${info.areaname}</c:if>
											</c:forEach></td>
										<td><c:forEach items="${gradList}" var="gradinfo">
												<c:if test="${gradinfo.id==demandresume.Demandyears}">
					                   			${gradinfo.gradename }
					                   		</c:if>
											</c:forEach></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div id="followPart"></div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>