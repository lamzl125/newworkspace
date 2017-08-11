<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>企业列表</title>
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
 	  initMemu(6,1);
   })
    function togetListBypage(page){
	   var searchschoolname = encodeURI(encodeURI($("#searchschoolname").val().trim()));
	   	var searchschooladdr = encodeURI(encodeURI($("#searchschooladdr").val().trim()));
	   	var searchschoolurl = encodeURI(encodeURI($("#searchschoolurl").val().trim()));
   		var url = "/enterprise/allEnterpriseList.do?page="+page;
   		url += "&enterpriseName="+searchschoolname+"&enterpriseAddr="+searchschooladdr+"&enterpriseURL="+searchschoolurl;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var searchschoolname = encodeURI(encodeURI($("#searchschoolname").val().trim()));
    	var searchschooladdr = encodeURI(encodeURI($("#searchschooladdr").val().trim()));
    	var searchschoolurl = encodeURI(encodeURI($("#searchschoolurl").val().trim()));
   		var url = "/enterprise/allEnterpriseList.do?page="+(page+1);
   		url += "&enterpriseName="+searchschoolname+"&enterpriseAddr="+searchschooladdr+"&enterpriseURL="+searchschoolurl;
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var searchschoolname = encodeURI(encodeURI($("#searchschoolname").val().trim()));
    	var searchschooladdr = encodeURI(encodeURI($("#searchschooladdr").val().trim()));
    	var searchschoolurl = encodeURI(encodeURI($("#searchschoolurl").val().trim()));
   		var url = "/enterprise/allEnterpriseList.do?page="+(page-1);
   		url += "&enterpriseName="+searchschoolname+"&enterpriseAddr="+searchschooladdr+"&enterpriseURL="+searchschoolurl;
    	window.location.href=url;
    }
    function topageInfo(){
    	var searchschoolname = encodeURI(encodeURI($("#searchschoolname").val().trim()));
    	var searchschooladdr = encodeURI(encodeURI($("#searchschooladdr").val().trim()));
    	var searchschoolurl = encodeURI(encodeURI($("#searchschoolurl").val().trim()));
   		var topage = $("#topage").val();
   		var url = "/enterprise/allEnterpriseList.do?page="+topage;
   		url += "&enterpriseName="+searchschoolname+"&enterpriseAddr="+searchschooladdr+"&enterpriseURL="+searchschoolurl;
    	window.location.href=url;
    }
    function toAdd(){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '企业信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '520px'],
            content: '/enterprise/toAddEnterprise.do'
		});
    }
    function del(enterpriseId){
    	$.ajax({
	         type: "post",
	         url: "/enterprise/delEnterprise.do",
	         data: {"enterpriseId":enterpriseId,},
	         dataType: "json",
	         success: function(result){
	        	 if(result.status == 0){
	        		 alert(result.msg);
	         		 window.location.reload();
	        	 }else{
	        		 alert(result.msg);
	        	 }
	         }
	     });
    }
    function toEdit(enterpriseId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '企业信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '630px'],
            content: '/enterprise/toEditEnterprise.do?enterpriseId='+enterpriseId
		});
    }
  
    function searchByCon(){
    	var searchschoolname = encodeURI(encodeURI($("#searchschoolname").val().trim()));
    	var searchschooladdr = encodeURI(encodeURI($("#searchschooladdr").val().trim()));
    	var searchschoolurl = encodeURI(encodeURI($("#searchschoolurl").val().trim()));
    	var url = "/enterprise/allEnterpriseList.do?enterpriseName="+searchschoolname+"&enterpriseAddr="+searchschooladdr+"&enterpriseURL="+searchschoolurl;
    	window.location.href=url;
    }
    function modifystatus(enterpriseId,status){
    	$.ajax({
	         type: "post",
	         url: "/enterprise/modifystatus.do",
	         data: {"enterpriseId":enterpriseId,"enterpriseStatus":status},
	         dataType: "json",
	         success: function(result){
	        	 if(result.status == 0){
	        		 alert(result.msg);
	         		 window.location.reload();
	        	 }else{
	        		 alert(result.msg);
	        	 }
	         }
	     });
    }
    function contact(enterpriseId){
		layer.open({
	        id:'iframetest',
	        type: 2,
	        title: '联系人信息',
	        maxmin: true, //开启最大化最小化按钮
	        area: ['1000px', '600px'],
	        content: '/enterprise/toContactsInfoList.do?enterpriseId='+enterpriseId
		});
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
					class="icon-home"></i>培训</a> <a href="" title="企业列表" class="current">企业列表</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>企业列表</h5>
					<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onclick="toAdd();">新增</button>
				</div>
				<div class="widget-content clearfix">
					<div class="zyh_sos">
						<span>企业名称： </span> 
						<input type="text" class="zyh_txt whh_input input_100"  id="searchschoolname"  value="${enterpriseName}"> 
						<span>地址： </span> 
						<input type="text" class="zyh_txt whh_input input_100"  id="searchschooladdr"  value="${enterpriseAddr}"> 
						<span>网址： </span> 
						<input type="text" class="zyh_txt whh_input input_100"  id="searchschoolurl"  value="${enterpriseURL}"> 	
						<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
					</div>

					<table class="table table-bordered table-striped with-check">
						<colgroup>
							<col width="10%"><col width="10%"><col width="25%"><col width="10%">
							<col width="10%"><col width="10%"><col width="25%">
						</colgroup>
						<thead>
							<tr>
								<th>企业名称</th><th>企业规模</th><th>企业简介</th><th>企业网址</th>                     
                     			<th>企业地址</th><th>企业状态</th><th>操作</th>                   
                     
							</tr>
						</thead>
						<tbody>
							<c:if test="${fn:length(list) == 0}">
								<tr>
									<td colspan="12" style="text-align: center">未查询到企业信息</td>
							    </tr>
							</c:if>
			                <c:forEach  items="${list}"  var="enterpriseInfo">
			                	<tr data-schoolid= "${enterpriseInfo.enterpriseId}">
			                	<td>
			                		<a href="#"  style="color: red;">${enterpriseInfo.enterpriseName}</a>
			                	</td>
			                   <td>${enterpriseInfo.enterpriseScale }</td>
			                   <td>${enterpriseInfo.enterpriseProfile }</td>
			                   <td>${enterpriseInfo.enterpriseURL }</td>
			                   <td>${enterpriseInfo.enterpriseAddr }</td>
			                   <td>	
				                   <c:choose>
				                   		<c:when test="${enterpriseInfo.enterpriseStatus==1}">启用</c:when>
				                   		<c:when test="${enterpriseInfo.enterpriseStatus==2}">不启用</c:when>
				                   	</c:choose>
			                   	</td>
			                   <td >
			                   		<a class="edit" onclick="toEdit('${enterpriseInfo.enterpriseId}')" href="javascript:void(0);" class="zyh_tan_btn">修改</a>&nbsp;&nbsp;
			                   		<a class="edit" onclick="del('${enterpriseInfo.enterpriseId}')" href="javascript:void(0);" class="zyh_tan_btn">删除</a>&nbsp;&nbsp;
			               			<c:if test="${enterpriseInfo.enterpriseStatus==1}">
			               				<a class="edit" onclick="modifystatus('${enterpriseInfo.enterpriseId}',2)" href="javascript:void(0);" class="zyh_tan_btn">失效</a>&nbsp;&nbsp;
			               			</c:if>
			               			<c:if test="${enterpriseInfo.enterpriseStatus==2}">
			               				<a class="edit" onclick="modifystatus('${enterpriseInfo.enterpriseId}',1)" href="javascript:void(0);" class="zyh_tan_btn">启用</a>&nbsp;&nbsp;
			               			</c:if>
			               			<a class="edit" onclick="contact('${enterpriseInfo.enterpriseId}')" href="javascript:void(0);" class="zyh_tan_btn">联系人</a>
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