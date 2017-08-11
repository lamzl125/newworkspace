<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>在线客服列表</title>
  <link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
    
    
    
 	<script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script>
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
     
   <script type="text/javascript">
   $(document).ready(function(){
 	  initMemu(0,14);
   })
    function togetListBypage(page){
	   var serviceName = $("#serviceName").val();
   		var qQ = $("#qQ").val();
   		var url = "/serviceronline/servicerOnLineList.do?page="+page;
   		url += "&serviceName="+encodeURI(encodeURI($.trim(serviceName)))+"&qQ="+encodeURI(encodeURI($.trim(qQ)));
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var serviceName = $("#serviceName").val();
   		var qQ = $("#qQ").val();
   		var url = "/serviceronline/servicerOnLineList.do?page="+(page+1);
   		url += "&serviceName="+encodeURI(encodeURI($.trim(serviceName)))+"&qQ="+encodeURI(encodeURI($.trim(qQ)))
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var serviceName = $("#serviceName").val();
   		var qQ = $("#qQ").val();
   		var url = "/serviceronline/servicerOnLineList.do?page="+(page-1);
   		url += "&serviceName="+encodeURI(encodeURI($.trim(serviceName)))+"&qQ="+encodeURI(encodeURI($.trim(qQ)))
    	window.location.href=url;
    }
    function topageInfo(){
    	var serviceName = $("#serviceName").val();
   		var qQ = $("#qQ").val();
   		var topage = $("#topage").val();   		
   		var url = "/serviceronline/servicerOnLineList.do?page="+topage;
   		url += "&serviceName="+encodeURI(encodeURI($.trim(serviceName)))+"&qQ="+encodeURI(encodeURI($.trim(qQ)))
    	window.location.href=url;
    }
    function toAdd(){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '在线客服信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '500px'],
			content:'/serviceronline/toAddServicerOnLine.do'
		});
    }
    function del(id){
    	$.ajax({
	         type: "post",
	         url: "/serviceronline/deleteServicerOnLine.do",
	         data: {"id":id,},
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
    function toEdit(id){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '学校信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['600px', '500px'],
            content: '/serviceronline/toEditServicerOnLine.do?id='+id
		});
    }
    function searchByCon(){
    	var serviceName = $("#serviceName").val();
    	var qQ = $("#qQ").val();
    	var url = "/serviceronline/servicerOnLineList.do?serviceName="+encodeURI(encodeURI($.trim(serviceName)))+"&qQ="+encodeURI(encodeURI($.trim(qQ)));
    	window.location.href=url;
    }
    function invalid(id){
    	$.ajax({
	         type: "post",
	         url: "/serviceronline/invalidServicerOnLine.do",
	         data: {"id":id,},
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
    function effective(id){
    	$.ajax({
	         type: "post",
	         url: "/serviceronline/effectiveServicerOnLine.do",
	         data: {"id":id,},
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
  </script>
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
     	<a href="" title="在线客服管理" class="current">在线客服管理</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>在线客服列表</h5>
          </div>
          <div class="widget-content clearfix">
         	 <div class="zyh_sos">
					<span>名称： </span> 
					<input type="text" class="zyh_txt whh_input input_100"  id="serviceName"  value="${serviceName}"> 
					<span>QQ： </span> 
					<input type="text" class="zyh_txt whh_input input_100"  id="qQ"  value="${qQ}"> 
					<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
					<div style="float:right;">
		       	  		<input type="button" class="zyh_btn" value="新增" onclick="toAdd();" >
		       	  	</div>
				</div>
          
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
            		<col width="20%"><col width="20%"><col width="20%">
            		<col width="20%"><col width="20%">
            	</colgroup>
              <thead>
                <tr><th>客服名称</th><th width="25%">QQ</th><th>微信</th><th>状态</th><th>操作</th></tr>
              </thead>
              <tbody>
	              <c:if test="${fn:length(list) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到在线客服信息</td>
					    </tr>
					</c:if>
	                <c:forEach  items="${list}"  var="servierInfo">
	                	<tr data-schoolid= "${servierInfo.id}">
	                	<td>
	                		<a href="#"  style="color: red;">${servierInfo.serviceName}</a>
	                	</td>
	                   <td>${servierInfo.qQ }</td>
	                   <td>${servierInfo.weiXin }</td>
	                   <td>
	                   		${servierInfo.servicerStatus eq 1 ? "启用":servierInfo.servicerStatus eq 2 ? "未启用":'未知' }
	                   </td>
	                   <td >
	                   		<a class="edit" onclick="toEdit('${servierInfo.id}')" href="javascript:void(0);" class="zyh_tan_btn">修改</a>&nbsp;&nbsp;
	                   		<a class="edit" onclick="del('${servierInfo.id}')" href="javascript:void(0);" class="zyh_tan_btn">删除</a>&nbsp;&nbsp;
	                   		<c:if test="${servierInfo.servicerStatus eq 1}">
	                   			<a class="edit" onclick="invalid('${servierInfo.id}')" href="javascript:void(0);" class="zyh_tan_btn">不启用</a>&nbsp;&nbsp;
	                   		</c:if>
	                   		<c:if test="${servierInfo.servicerStatus eq 2}">
	                   			<a class="edit" onclick="effective('${servierInfo.id}')" href="javascript:void(0);" class="zyh_tan_btn">启用</a>&nbsp;&nbsp;
	                   		</c:if>
	                   		
	                   </td>
	                 </tr>
	                </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
                <c:if test="${tatalpage>=currpage}">
                	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+1)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+1})">${currpage+1}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+2)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+2})">${currpage+2}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+3)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+3})">${currpage+3}</a> </li>
                </c:if>
                <li><a href="javascript:void(0)" onclick="tonextpageInfo(${currpage})">Next</a></li>
              </ul>
            </div>
          </div>
        </div>
  </div>
</div>

</body>
</html>