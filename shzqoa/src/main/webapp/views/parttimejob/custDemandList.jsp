<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求列表</title>
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
<link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
<link href="/views/common/css/bootstrap-table-fixed-columns.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js"></script>
<script src="/views/common/js/bootstrap-table.js"></script>
<script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js"
	type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script>
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
 </head>
 <style>
.zyh_wii{ width:100px;} 
.zyh_btn {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
} 
.zyh_sosu{ margin-bottom:10px;}

.zyh_caozuo{
	display: inline-block;
    width: 40px;
    background-color: #E14C4D;
    color: #fff;
    cursor: pointer;}
 </style>
 <script type="text/javascript">
 function search(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url =  "/partjob/demandList.do?corpcode="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
 }
 
 function topageInfo(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var topage = $("#topage").val();
	 var url = "/partjob/demandList.do?page="+topage+"&corpcode="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/partjob/demandList.do?page="+(page-1)+"&corpcode="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/partjob/demandList.do?page="+page+"&corpcode="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();;
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/partjob/demandList.do?page="+(page+1)+"&corpcode="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function addResume(id){
	 layer.open({
         id:'iframetest',
         type: 2,
         title: '新增简历信息',
         maxmin: true, //开启最大化最小化按钮
         area: ['900px', '600px'],
         content: '/partjob/demandNoBindResumeList.do?demandId='+id
	});
 }
 function showbindresume(id){
	 layer.open({
         id:'iframetest',
         type: 2,
         title: '该需求提交简历信息',
         maxmin: true, //开启最大化最小化按钮
         area: ['900px', '600px'],
         content: '/partjob/demandBindResumeList.do?demandId='+id
	});
 }
 $(document).ready(function(){
	  initMemu(7,0);
  })
 </script>
 <body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="兼职信息" class="tip-bottom"><i
					class="icon-home"></i>兼职信息</a> <a href="" title="需求列表" class="current">需求列表</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>需求列表</h5>
				</div>
				<div class="widget-content clearfix">
					<div class="zyh_sosu">
						<span> 客户： </span>
						<select id="cusname" class="whh_sel" style="width:150px;">
	                          <option value="">请选择</option>
	                         <c:forEach items="${corporList }" var="info">
								<option value="${info.corpCode }" <c:if test="${info.corpCode eq  corpcode}">  selected="selected" </c:if>>${info.corpCode}</option>
							 </c:forEach>
	                       </select>
						<span> 技术方向： </span>
	                       <select id="technologydirection" class="whh_sel" style="width:120px;">
	                          <option value="">请选择</option>
	                         <c:forEach items="${profession }" var="info">
								<option value="${info.id }" <c:if test="${info.id eq  technologydirection}">  selected="selected" </c:if>>${info.name }</option>
							 </c:forEach>
	                       </select>
	                    <span>项目地点： </span> 
						<select class="zyh_sel zyh_k_heigth whh_sel" id="projectlocation" style="width:65px;">
							<option value="">请选择</option>
	                          <c:forEach items="${arealist }" var="info">
								<option value="${info.areaid }" <c:if test="${info.areaid eq  projectlocation}">  selected="selected" </c:if>>${info.areaname }</option>
							 </c:forEach>
						</select>
						<span> 技术级别： </span>
						<select class="zyh_sel zyh_k_heigth whh_sel" id="demandyears" style="width:65px;">
							<option value="">请选择</option>
	                          <c:forEach items="${grade }" var="info">
								<option value="${info.id }" <c:if test="${info.id eq  demandyears}">  selected="selected" </c:if>>${info.gradename }</option>
							 </c:forEach>
						</select>
						<input type="button" class="zyh_btn" value="查询" onclick="search()">
					</div>

					<table class="table table-bordered table-striped with-check">
						<colgroup>
							<col width="4%"><col width="6%"><col width="6%"><col width="6%">
							<col width="4%"><col width="10%"><col width="25%"><col width="10%">
							<col width="6%"><col width="6%"><col width="6%"><col width="6%">
							<col width="6%"><col width="10%">
						</colgroup>
						<thead>
							<tr>
								<th>公司</th><th>技术方向</th><th>项目地点</th><th>需求级别</th>
								<th>学历</th><th>需求名称</th><th>具体内容</th><th>备注</th>
			                     <th>简历数量</th><th>筛选时长</th><th>面试结果时长</th><th>安排入项时长</th>
			                     <th>商务</th><th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${fn:length(custList) == 0}">
								<tr>
									<td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td>
							    </tr>
							</c:if>
		                	<c:forEach items="${custList }" var="cc">
			                  <tr>
			                   <td>
		                   			<c:choose>
		                   				<c:when test="${fn:startsWith(cc.corpcode,'hzgs-')}">${fn:substring(cc.corpcode, 5, -1)}</c:when>
		                   				<c:otherwise>${cc.corpcode}</c:otherwise>
		                   			</c:choose>
			                   </td>
			                   <td>${cc.name }</td>
			                   <td>${cc.areaname }</td>
			                   <td>${cc.gradename }</td>
			                   <td>${cc.education }</td>
			                   <td>${cc.projecttype }</td>
			                   <td width="260">${cc.specificrequirement }</td>
			                   <td  width="80">${cc.remarks }</td>
			                   <td>
			                   		<c:forEach items="${demandrescount}" var="countinfo">
										<c:if test="${countinfo.key eq cc.id}">${countinfo.value}</c:if>
									</c:forEach>
			                   </td>
			                   <td>
			                   		<c:set var="durc">0</c:set>
			                   		<c:forEach items="${durationlist}" var="durationinfo">
										<c:if test="${durationinfo.CorpCode eq cc.corpcode}">
											<c:set var="durc">1</c:set>
											<fmt:formatNumber type="number" value="${durationinfo.sxduration}" maxFractionDigits="0"/>
										</c:if>
									</c:forEach>
									<c:if test="${durc ne 1}">0</c:if>
									天
			                   </td>
			                   <td><c:set var="durc">0</c:set>
			                   		<c:forEach items="${durationlist}" var="durationinfo">
										<c:if test="${durationinfo.CorpCode eq cc.corpcode}"><c:set var="durc">1</c:set><fmt:formatNumber type="number" value="${durationinfo.interviewresultduration}" maxFractionDigits="0"/></c:if>
									</c:forEach><c:if test="${durc ne 1}">0</c:if>天                 
			                   </td>
			                   <td><c:set var="durc">0</c:set>
									<c:forEach items="${durationlist}" var="durationinfo">
										<c:if test="${durationinfo.CorpCode eq cc.corpcode}"><c:set var="durc">1</c:set><fmt:formatNumber type="number" value="${durationinfo.rxduration}" maxFractionDigits="0"/></c:if>
									</c:forEach><c:if test="${durc ne 1}">0</c:if>天
							   </td>
			                   <td>
			                   		<c:forEach items="${userlist}" var="user" >
										<c:if test="${cc.operationuser==user.usercode}">${user.realname} </c:if>
							    	</c:forEach>
			                   </td>
			                   <td>
			                   		<a class="editButClass" href="javascript:void(0);" onclick="addResume('${cc.id}')">添加</a>
			                   		<a class="editButClass" href="javascript:void(0);" onclick="showbindresume('${cc.id}')">已提交</a>
			                   </td>
			                 </tr>
		                 </c:forEach>
						</tbody>
					</table>
					<!--分页-->
					<div class="pagination alternate page_fr">
						<ul>
							<li
								<c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a
								href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
							<li class="active"><a href="javascript:void(0);"
								onclick="togetListBypage(${currpage})">${currpage}</a></li>
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
				</div>
			</div>
		</div>
	</div>
 </body>
</html>