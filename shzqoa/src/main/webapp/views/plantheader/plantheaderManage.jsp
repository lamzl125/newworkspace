<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>厂区负责人管理</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
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
  <style type="text/css" rel="stylesheet">
	.whh_input{width:100px;}
	.fixedtable{TABLE-LAYOUT:fixed;}
	.fixedtable th{word-break:break-all; word-wrap:break-word;}
	.fixedtable td{word-break:break-all; word-wrap:break-word;}
	.whh_tab_bor{padding-left:20px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,6);
  })
  
  function togetListBypage(page){
	  var plantId = $("#plantId").val();
	  var userCode = $("#userCode").val();
	  var statusFlag = $("#statusFlag").val();	
  	  var url = "/plantheader/toPlantHeaderList.do?page="+page;
  	  if(plantId!=null && plantId!=""){
		  url += "&plantId="+encodeURI(encodeURI($.trim(plantId)));
	  }
	  if(userCode!=null && userCode!=""){
		  url += "&userCode="+encodeURI(encodeURI($.trim(userCode)));
	  }
	  if(statusFlag!=null && statusFlag!=""){
		  url += "&statusFlag="+encodeURI(encodeURI($.trim(statusFlag)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var plantId = $("#plantId").val();
	  var userCode = $("#userCode").val();
	  var statusFlag = $("#statusFlag").val();	
  	  var url = "/plantheader/toPlantHeaderList.do?page="+(page+1);
  	  if(plantId!=null && plantId!=""){
		  url += "&plantId="+encodeURI(encodeURI($.trim(plantId)));
	  }
	  if(userCode!=null && userCode!=""){
		  url += "&userCode="+encodeURI(encodeURI($.trim(userCode)));
	  }
	  if(statusFlag!=null && statusFlag!=""){
		  url += "&statusFlag="+encodeURI(encodeURI($.trim(statusFlag)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var plantId = $("#plantId").val();
	  var userCode = $("#userCode").val();
	  var statusFlag = $("#statusFlag").val();	
  	  var url = "/plantheader/toPlantHeaderList.do?page="+(page-1);
  	  if(plantId!=null && plantId!=""){
		  url += "&plantId="+encodeURI(encodeURI($.trim(plantId)));
	  }
	  if(userCode!=null && userCode!=""){
		  url += "&userCode="+encodeURI(encodeURI($.trim(userCode)));
	  }
	  if(statusFlag!=null && statusFlag!=""){
		  url += "&statusFlag="+encodeURI(encodeURI($.trim(statusFlag)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){
	  var plantId = $("#plantId").val();
	  var userCode = $("#userCode").val();
	  var statusFlag = $("#statusFlag").val();	
  	  var topage = $("#topage").val();
  	  var url = "/plantheader/toPlantHeaderList.do?page="+topage;
  	  if(plantId!=null && plantId!=""){
		  url += "&plantId="+encodeURI(encodeURI($.trim(plantId)));
	  }
	  if(userCode!=null && userCode!=""){
		  url += "&userCode="+encodeURI(encodeURI($.trim(userCode)));
	  }
	  if(statusFlag!=null && statusFlag!=""){
		  url += "&statusFlag="+encodeURI(encodeURI($.trim(statusFlag)));
	  }
  	  window.location.href=url;
  }
  

  function searchByCon(){
	  var plantId = $("#plantId").val();
	  var userCode = $("#userCode").val();
	  var statusFlag = $("#statusFlag").val();	
	  var url = "/plantheader/toPlantHeaderList.do?page=1";	  
	  if(plantId!=null && plantId!=""){
		  url += "&plantId="+encodeURI(encodeURI($.trim(plantId)));
	  }
	  if(userCode!=null && userCode!=""){
		  url += "&userCode="+encodeURI(encodeURI($.trim(userCode)));
	  }
	  if(statusFlag!=null && statusFlag!=""){
		  url += "&statusFlag="+encodeURI(encodeURI($.trim(statusFlag)));
	  }
  	  window.location.href=url;
  }
  function delInfo(plantHeaderId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/plantheader/delPlantHeader.do",
		          data: {"plantHeaderId":plantHeaderId},
		          dataType: "json",
		          success: function(result){
		         	 if(result.success == true){
		         		 alert(result.resultMessage);
		         		 parent.location.reload();
		         	 }else{
		         		 alert(result.resultMessage);
		         	 }
		          }
		      });
		}
  }
  function editInfo(plantHeaderId){
	  var url = "/plantheader/showPlantHeader.do?plantHeaderId="+plantHeaderId;
	  layer.open({
	        type: 2,
	        title: '厂区负责人信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '338px'],
	        content: url
	    })
  }
  function addPlantHeader(){
	  var addPlantId = $("#addPlantId").val();
	  var addUserCode = $("#addUserCode").val();
	  if(addPlantId==null|| addPlantId==""){
		  alert("厂区必须选择一个");
		  return false;
	  }
	  if(addUserCode==null|| addUserCode==""){
		  alert("负责人必须选择一个");
		  return false;
	  }
	  $.ajax({
          type: "post",
          url: "/plantheader/savePlantHeader.do",
          data: {"plantId":addPlantId,"userCode":addUserCode},
          dataType: "json",
          success: function(result){
         	 if(result.success == true){
         		 alert(result.resultMessage);
         		 parent.location.reload();
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
	    	<a href="index.html" title="招聘管理" class="tip-bottom"><i class="icon-home"></i>招聘管理</a>
	     	<a href="" title="厂区负责人管理" class="current">厂区负责人管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>厂区负责人管理</h5>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
            	<span>厂区：
            		<select id="plantId">
                		 <option value="" <c:if test="${plantId==null}">selected</c:if>>请选择</option>
                         <c:forEach var="item" begin="0" items="${factorylist}" varStatus="status">
		                     <option value="${item.id}" <c:if test="${plantId==item.id}">selected</c:if>>${item.name}</option>
		                  </c:forEach>
                	</select>
            	</span>
                <span>负责人：
                	<select id="userCode">
                		 <option value="" <c:if test="${userCode==null}">selected</c:if>>请选择</option>
                         <c:forEach var="item" begin="0" items="${userlist}" varStatus="status">
		                     <option value="${item.usercode}" <c:if test="${userCode==item.usercode}">selected</c:if>>${item.realname}</option>
		                  </c:forEach>
                	</select>
                </span>
                <span>状态：
                	<select id="statusFlag">
                		 <option value="" <c:if test="${statusFlag==null}">selected</c:if>>请选择</option>
	                     <option value="1" <c:if test="${statusFlag==1}">selected</c:if>>正常</option>
	                     <option value="2" <c:if test="${statusFlag==2}">selected</c:if>>作废</option>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check fixedtable">
              <thead>
                <tr>
                	<th>#</th>
                  <th>厂区</th>
                  <th>负责人</th>
                  <th>状态</th>
                  <th>添加人</th>
                  <th>添加时间</th>
                  <th>作废人</th>
                  <th>作废时间</th>
                  <th>操作</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">没有厂区负责人信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${list}" varStatus="status">
	                  <tr>
	                  		<td>${status.index+1}</td>
	                  	   <td>${item.plantName}</td>
	                  	   <td>${item.realName}</td>
	                  	   <td>${item.StatusFlag==1?'正常':item.StatusFlag==2?'作废':''}</td>
	                  	   <td>
	                  	   		<c:forEach var="userinfo" items="${userlist}" >
			              			<c:if test="${item.AddPeople==userinfo.usercode}">
			              				${userinfo.realname}
			              			</c:if>
				                 </c:forEach>
	                  	   </td>
	                  	   <td><fmt:formatDate pattern='yyyy-MM-dd' value='${item.AddTime}' /></td>
	                  	   <td>
	                  	   		<c:forEach var="userinfo" items="${userlist}" >
			              			<c:if test="${item.Invalid==userinfo.usercode}">
			              				${userinfo.realname}
			              			</c:if>
				                 </c:forEach>
	                  	   </td>
		                   <td><fmt:formatDate pattern='yyyy-MM-dd' value='${item.CancellationTime}' /></td>
		                   <td>
								<button type="button" class="btn btn-warning btn-mini" onclick="editInfo('${item.PlantHeaderId}')">详情</button>
								<button type="button" class="btn btn-mini btn-danger zyh_delete" onclick="delInfo('${item.PlantHeaderId}')">作废</button>
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
          <div class="whh_tab_bor">
            <div class="zyh_sos">
            	<span>厂区：</span>
            	<select id="addPlantId">
               		 <option value="">请选择</option>
                        <c:forEach var="item" begin="0" items="${factorylist}" varStatus="status">
	                     	<option value="${item.id}">${item.name}</option>
	                  </c:forEach>
               	</select>
        		<span>负责人： </span>
        		<select id="addUserCode">
               		 <option value="">请选择</option>
                        <c:forEach var="item" items="${userlist}" varStatus="status">
	                     	<option value="${item.usercode}">${item.realname}</option>
	                  </c:forEach>
               	</select>
                <input type="button" class="zyh_btn" onclick="addPlantHeader()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>
</body>
</html>