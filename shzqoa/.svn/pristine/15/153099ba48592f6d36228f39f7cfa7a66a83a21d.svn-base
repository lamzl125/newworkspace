<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>学校院系列表</title>
<link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
  <link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
  <link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
  <link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="/views/common/css/zyh_style.css" />
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  
  <script src="/views/common/js/jquery.validate.js"></script>
     
   <script type="text/javascript">
   $(document).ready(function(){
	   initMemu(6,0);
   })
    function togetListBypage(page){
	   var schoolId = $("#schoolId").val();
   		var url = "/contact/toDepartmentsList.do?page="+page+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	 var schoolId = $("#schoolId").val();
   		var url = "/contact/toDepartmentsList.do?page="+(page+1)+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	 var schoolId = $("#schoolId").val();
   		var url = "/contact/toDepartmentsList.do?page="+(page-1)+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function topageInfo(){
    	 var schoolId = $("#schoolId").val();
   		var topage = $("#topage").val();
   		var url = "/contact/toDepartmentsList.do?page="+topage+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function toAdd(){
    	 var schoolId = $("#schoolId").val();
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '新增院系信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content: '/contact/toDepartInfoAdd.do?schoolId='+schoolId
		});
    }
    function toEdit(contactId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '院系信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content: '/contact/toEditContact.do?contactId='+contactId
		});
    }
    function todel(contactId){
    	$.ajax({
	         type: "post",
	         url: "/contact/deleteContact.do",
	         data: {"contactId":contactId,},
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
    function follow(contactId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '跟踪列表',
            maxmin: true, //开启最大化最小化按钮
            area: ['970px', '600px'],
            content: '/follow/toFollowList.do?contactId='+contactId
		});
    } 
    function tofollowAdd(contactId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '跟踪记录',
            maxmin: true, //开启最大化最小化按钮
            area: ['950px', '550px'],
            content: '/follow/toFollowInfoAdd.do?contactId='+contactId
		});
    }
    function searchByCon(){
    	var schoolId = $("#schoolId").val();
    	var searchdirection = $("#searchdirection").val();
    	var searchcontactTel = $("#searchcontactTel").val();
    	var searchcontactName = $("#searchcontactName").val();
    	var url = "/contact/toDepartmentsList.do?searchdirection="+searchdirection+"&searchcontactTel="+searchcontactTel+"&searchcontactName="+searchcontactName+"&schoolId="+schoolId;
    	window.location.href=url;
    }
  </script>
 </head>
 <body style="background:#fff;">
 <input type="hidden" id="schoolId" value="${schoolId}">
<div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
          	<div>
       	  		<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onclick="toAdd();">新增</button>
       	  	</div>
       	  	<div class="zyh_sos">
				<span>院系名称： </span> 
				<input type="text" class="zyh_txt whh_input input_100"  id="searchdirection"  value="${searchdirection}"> 
				<span>电话： </span> 
				<input type="text" class="zyh_txt whh_input input_100"  id="searchcontactTel"  value="${searchcontactTel}"> 
				<span>联系人： </span> 
				<input type="text" class="zyh_txt whh_input input_100"  id="searchcontactName"  value="${searchcontactName}"> 	
				<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
			</div>
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
					<col width="10%"><col width="10%"><col width="10%"><col width="10%">
					<col width="10%"><col width="10%"><col width="20%"><col width="20%">
				</colgroup>
              <thead>
                	 <tr>
                		<th>是否独占</th><th>院系名称</th><th>联系电话</th><th>联系人</th>
                     	<th>学校</th><th>性别</th><th>职位</th><th>操作</th>
                     </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(contactlist) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">未查询到培训内容信息</td>
				    </tr>
				</c:if>
                <c:forEach  items="${contactlist}"  var="info">
                	<tr data-schoolid= "${info.contactId}">
                	<td><input type="checkbox" <c:if test="${info.isEngross==1}">checked</c:if> >独占</td>
                	<td>${info.direction}</td>
                   <td>${info.contactTel}<c:if test="${info.officeTel!=null && info.officeTel!=''}">,${info.officeTel}</c:if><c:if test="${info.qq!=null && info.qq!=''}">,${info.qq}</c:if></td>
                   <td>${info.contactName }</td>
                   <td>
                   		<c:forEach items="${allSchoolList}" var="schoolInfo">
                   			<c:if test="${schoolInfo.schoolId==info.schoolId}">${schoolInfo.schoolName}</c:if>
                   		</c:forEach>
                   </td>                   
                   <td>	
	                   <c:choose>
	                   		<c:when test="${info.contactSex==1}">男</c:when>
	                   		<c:when test="${info.contactSex==2}">女</c:when>
	                   	</c:choose>
                   	</td>
                   <td>${info.jobName }</td>
                   
                   <td >
                   		<a class="edit" onclick="toEdit(${info.contactId})" href="javascript:void(0);" class="zyh_tan_btn">修改</a>&nbsp;&nbsp;
<%--                    		<a class="edit" onclick="todel(${info.contactId})" href="javascript:void(0);" class="zyh_tan_btn">删除</a>&nbsp;&nbsp; --%>
               			<a class="edit" onclick="follow(${info.contactId})" href="javascript:void(0);" class="zyh_tan_btn">跟踪列表</a>&nbsp;&nbsp;
               			<a class="edit" onclick="tofollowAdd(${info.contactId})" href="javascript:void(0);" class="zyh_tan_btn">跟踪</a>
                   </td>
                 </tr>
                </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
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