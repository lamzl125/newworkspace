<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>联系人列表</title>
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
 	  initMemu(6,1);
   })
    function togetListBypage(page){
	   var enterpriseId = $("#enterpriseId").val();
   		var searchname = $("#searchname").val();
   		var searchcontactTel = $("#searchcontactTel").val();
   		var url = "/enterprise/toContactsInfoList.do?page="+page+"&enterpriseId="+enterpriseId;
   		url += "&searchname="+searchname+"&searchcontactTel="+searchcontactTel;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var enterpriseId = $("#enterpriseId").val();
   		var searchname = $("#searchname").val();
   		var searchcontactTel = $("#searchcontactTel").val();
   		var url = "/enterprise/toContactsInfoList.do?page="+(page+1)+"&enterpriseId="+enterpriseId;
   		url += "&searchname="+searchname+"&searchcontactTel="+searchcontactTel;
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var enterpriseId = $("#enterpriseId").val();
   		var searchname = $("#searchname").val();
   		var searchcontactTel = $("#searchcontactTel").val();
   		var url = "/enterprise/toContactsInfoList.do?page="+(page-1)+"&enterpriseId="+enterpriseId;
   		url += "&searchname="+searchname+"&searchcontactTel="+searchcontactTel;
    	window.location.href=url;
    }
    function topageInfo(){
    	var enterpriseId = $("#enterpriseId").val();
   		var searchname = $("#searchname").val();
   		var searchcontactTel = $("#searchcontactTel").val();
   		var topage = $("#topage").val();
   		var url = "/enterprise/toContactsInfoList.do?page="+topage+"&enterpriseId="+enterpriseId;
   		url += "&searchname="+searchname+"&searchcontactTel="+searchcontactTel;
    	window.location.href=url;
    }
    
    function toEdit(enterpriseContactsId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '修改联系人信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '570px'],
            content: '/enterprise/toEditEnterpriseContacts.do?enterpriseContactsId='+enterpriseContactsId
		});
    }
    
    function follow(enterpriseContactsId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '跟踪列表',
            maxmin: true, //开启最大化最小化按钮
            area: ['970px', '600px'],
            content: '/enterprise/toContactsFollowList.do?enterpriseContactsId='+enterpriseContactsId
		});
    }
    function tofollowAdd(enterpriseContactsId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '跟踪记录',
            maxmin: true, //开启最大化最小化按钮
            area: ['950px', '550px'],
            content: '/enterprise/toFollowInfoAdd.do?enterpriseContactsId='+enterpriseContactsId
		});
    }
    
    
    function searchByCon(){
    	var enterpriseId = $("#enterpriseId").val();
    	var searchname = $("#searchname").val();
    	var searchcontactTel = $("#searchcontactTel").val();
    	var url = "/enterprise/toContactsInfoList.do?enterpriseId="+enterpriseId+"&searchname="+searchname+"&searchcontactTel="+searchcontactTel;
    	window.location.href=url;
    }
    function todel(enterpriseContactsId){
    	$.ajax({
	         type: "post",
	         url: "/enterprise/delEnterpriseContacts.do",
	         data: {"enterpriseContactsId":enterpriseContactsId,},
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
    function toAdd(){
   	 var enterpriseId = $("#enterpriseId").val();
   	layer.open({
           id:'iframetest',
           type: 2,
           title: '新增联系人信息',
           maxmin: true, //开启最大化最小化按钮
           area: ['900px', '600px'],
           content: '/enterprise/toAddEnterpriseContacts.do?enterpriseId='+enterpriseId
		});
   }
  </script>
 </head>
 <body style="background:#fff;">
 <input type="hidden" id="enterpriseId" value="${enterpriseId}">
 <div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
          	<div>
       	  		<button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onclick="toAdd();">新增</button>
       	  	</div>
          	<div class="zyh_sos">
				<span>姓名： </span> 
				<input type="text" class="zyh_txt whh_input input_100"  id="searchname"  value="${searchname}"> 
				<span>电话： </span> 
				<input type="text" class="zyh_txt whh_input input_100"  id="searchcontactTel"  value="${searchcontactTel}"> 
				<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
			</div>
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
					<col width="15%"><col width="10%"><col width="10%"><col width="10%">
					<col width="10%"><col width="15%"><col width="10%"><col width="20%">
				</colgroup>
              <thead>
                	 <tr>
                		<th>姓名</th><th>手机号</th><th>固定电话</th><th>QQ</th>
                     	<th>微信号</th><th>职位</th><th>状态</th><th>操作</th>
                     </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">未查询到联系人信息</td></tr>
				</c:if>
                <c:forEach  items="${list}"  var="info">
                	<tr data-id= "${info.enterpriseContactsId}">
	                	<td>${info.contactsName}</td>
	                   <td>${info.contactsPhone }</td>
	                   <td>${info.contactsTel }</td>
	                   <td>${info.contactsQQ }</td>   
	                   <td>${info.contactsWeiXin }</td>
	                   <td>${info.job }</td>                  
	                   <td>	
		                   <c:choose>
		                   		<c:when test="${info.contactsStatus==1}">启用</c:when>
		                   		<c:when test="${info.contactsStatus==2}">不启用</c:when>
		                   	</c:choose>
	                   	</td>
	                   <td >
	                   		<a class="edit" onclick="toEdit('${info.enterpriseContactsId}')" href="javascript:void(0);" class="zyh_tan_btn">修改</a>&nbsp;&nbsp;
	                   		<a class="edit" onclick="todel('${info.enterpriseContactsId}')" href="javascript:void(0);" class="zyh_tan_btn">删除</a>&nbsp;&nbsp;
	               			<a class="edit" onclick="follow('${info.enterpriseContactsId}')" href="javascript:void(0);" class="zyh_tan_btn">跟踪列表</a>&nbsp;&nbsp;
	               			<a class="edit" onclick="tofollowAdd('${info.enterpriseContactsId}')" href="javascript:void(0);" class="zyh_tan_btn">跟踪</a>
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