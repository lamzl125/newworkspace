<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>学校列表</title>
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

<script type="text/javascript">
   $(document).ready(function(){
 	  initMemu(6,0);
   })
    function togetListBypage(page){
   		var url = "/school/toSchoolList.do?page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
   		var url = "/school/toSchoolList.do?page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
   		var url = "/school/toSchoolList.do?page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
   		var topage = $("#topage").val();
   		var url = "/school/toSchoolList.do?page="+topage;
    	window.location.href=url;
    }
    function toAdd(schoolType){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '学校信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '500px'],
            content: '/school/toSchoolAdd.do?schoolType='+schoolType
		});
    }
    function delSchool(schoolId){
    	$.ajax({
	         type: "post",
	         url: "/school/deleteSchool.do",
	         data: {"schoolId":schoolId,},
	         dataType: "json",
	         success: function(result){
	        	 if(result.success == true){
	        		 alert(result.resultMessage);
	         		 window.location.reload();
	        	 }else{
	        		 alert(result.resultMessage);
	        	 }
	         }
	     });
    }
    function toEditSchool(schoolId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '学校信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '500px'],
            content: '/school/toEditSchool.do?schoolId='+schoolId
		});
    }
    function trainInfoList(schoolId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '培训内容',
            maxmin: true, //开启最大化最小化按钮
            area: ['1000px', '650px'],
            content: '/contact/toTrainInfoList.do?schoolId='+schoolId
		});
    }
    function departments(schoolId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '院系列表',
            maxmin: true, //开启最大化最小化按钮
            area: ['1000px', '650px'],
            content: '/contact/toDepartmentsList.do?schoolId='+schoolId
		});
    }
    function searchByCon(){
    	var searchschoolname = $("#searchschoolname").val();
    	var searchschooladdr = $("#searchschooladdr").val();
    	var searchschoolurl = $("#searchschoolurl").val();
    	var searchSchollType = $("select[name='searchSchollType']").val();
    	var url = "/school/toSchoolList.do?searchschoolname="+searchschoolname+"&searchschooladdr="+searchschooladdr+"&searchschoolurl="+searchschoolurl+"&searchSchollType="+searchSchollType;
    	window.location.href=url;
    }
  </script>
</head>
<body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="培训" class="tip-bottom"><i
					class="icon-home"></i>培训</a> <a href="" title="学校管理" class="current">学校管理</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>学校管理</h5>
					<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onclick="toAdd(1);">新增培训学校</button>
					<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onclick="toAdd(2);">新增大学</button>
				</div>
				<div class="widget-content clearfix">
					<div class="zyh_sos">
						<span>学校： </span> <input type="text"
							class="zyh_txt whh_input input_100" id="searchschoolname"
							value="${searchschoolname}"> <span>地址： </span> <input
							type="text" class="zyh_txt whh_input input_100"
							id="searchschooladdr" value="${searchschooladdr}"> <span>网址：
						</span> <input type="text" class="zyh_txt whh_input input_100"
							id="searchschoolurl" value="${searchschoolurl}"> <span>学校类型：
						</span> <select class="whh_sel input_100" name="searchSchollType">
							<option value="0"
								<c:if test="${searchSchollType==null}">selected</c:if>>请选择</option>
							<option value="1"
								<c:if test="${searchSchollType==1}">selected</c:if>>培训学校</option>
							<option value="2"
								<c:if test="${searchSchollType==2}">selected</c:if>>大学</option>
						</select> <input type="button" class="searchButClass" value="搜索"
							onclick="searchByCon()">
					</div>

					<table class="table table-bordered table-striped with-check">
						<colgroup>
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
							<col width="20%">
						</colgroup>
						<thead>
							<tr>
								<th>学校名称</th>
								<th>学校地址</th>
								<th>学校网址</th>
								<th>学校类型</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${fn:length(schoollist) == 0}">
								<tr>
									<td colspan="12" style="text-align: center">未查询到学校信息</td>
								</tr>
							</c:if>
							<c:forEach items="${schoollist}" var="schoolInfo">
								<tr data-schoolid="${schoolInfo.schoolId}">
									<td><a href="#" style="color: red;">${schoolInfo.schoolName}</a>
									</td>
									<td>${schoolInfo.schoolAddr }</td>
									<td>${schoolInfo.schoolURL }</td>
									<td><c:choose>
											<c:when test="${schoolInfo.schoolType==1}">培训学校</c:when>
											<c:when test="${schoolInfo.schoolType==2}">大学</c:when>
										</c:choose></td>
									<td><a class="edit"
										onclick="toEditSchool(${schoolInfo.schoolId})"
										href="javascript:void(0);" class="zyh_tan_btn">修改</a>&nbsp;&nbsp;
										<%--                    		<a class="edit" onclick="delSchool(${schoolInfo.schoolId})" href="javascript:void(0);" class="zyh_tan_btn">删除</a>&nbsp;&nbsp; --%>
										<c:if test="${schoolInfo.schoolType==1}">
											<a class="edit"
												onclick="trainInfoList(${schoolInfo.schoolId})"
												href="javascript:void(0);" class="zyh_tan_btn">培训内容</a>
										</c:if> <c:if test="${schoolInfo.schoolType==2}">
											<a class="edit" onclick="departments(${schoolInfo.schoolId})"
												href="javascript:void(0);" class="zyh_tan_btn">院系</a>
										</c:if></td>
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