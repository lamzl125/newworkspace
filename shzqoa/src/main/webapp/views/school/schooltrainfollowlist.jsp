<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>跟踪列表</title>
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
    function togetListBypage(page){
	   var schoolId = $("#schoolId").val();
   		var url = "/contact/toTrainInfoList.do?page="+page+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	 var schoolId = $("#schoolId").val();
   		var url = "/contact/toTrainInfoList.do?page="+(page+1)+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	 var schoolId = $("#schoolId").val();
   		var url = "/contact/toTrainInfoList.do?page="+(page-1)+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function topageInfo(){
    	 var schoolId = $("#schoolId").val();
   		var topage = $("#topage").val();
   		var url = "/contact/toTrainInfoList.do?page="+topage+"&schoolId="+schoolId;
    	window.location.href=url;
    }
    function toAdd(){
    	 var schoolId = $("#schoolId").val();
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '新增培训内容信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content: '/contact/toTrainInfoAdd.do?schoolId='+schoolId
		});
    }
    function toEdit(contactId){
    	layer.open({
            id:'iframetest',
            type: 2,
            title: '培训内容信息',
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
  </script>
 </head>
 <body style="background:#fff;">
 <input type="hidden" id="schoolId" value="${schoolINfo.schoolId}">
 <div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
					<col width="10%"><col width="10%"><col width="10%"><col width="10%">
					<col width="10%"><col width="10%"><col width="20%"><col width="20%">
				</colgroup>
              <thead>
                	 <tr>
                		<th>跟踪人</th><th>跟踪时间</th><th>跟踪情况</th><th><c:if test="${schoolINfo.schoolType==1}">培训内容</c:if><c:if test="${schoolINfo.schoolType==2}">院系</c:if></th>
                     	<th>联系电话</th><th>联系人</th><th>学校</th><th>性别</th>
                     </tr>
              </thead>
              <tbody>
	              	<c:if test="${fn:length(followlist) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到跟踪信息</td>
					    </tr>
					</c:if>
	                <c:forEach  items="${followlist}"  var="info">
	                	<tr data-schoolid= "${info.followId}">
	                	<td>
	                		<c:forEach items="${userlist}" var="userInfo">
	                			<c:if test="${userInfo.usercode==info.operCode }">${userInfo.realname}</c:if>
	                		</c:forEach>
	                	</td>
	                   <td><fmt:formatDate pattern="yyyy-MM-dd " value="${info.operTime}" /></td>
	                   <td>${info.memo}</td>
	                   <td>${contactInfo.direction }</td>
	                   <td>${contactInfo.contactTel}</td> 
	                   <td>${contactInfo.contactName}</td>   
	                   <td>${schoolINfo.schoolName}</td>   
	                   <td>	
		                   <c:choose>
		                   		<c:when test="${contactInfo.contactSex==1}">男</c:when>
		                   		<c:when test="${contactInfo.contactSex==2}">女</c:when>
		                   	</c:choose>
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