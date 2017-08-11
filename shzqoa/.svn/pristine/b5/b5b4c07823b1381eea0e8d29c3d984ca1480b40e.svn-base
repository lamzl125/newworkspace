<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求发布统计</title>
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
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(2,4);
  })
  
  function togetListBypage(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var url = "/demandstatistics/demandaddlist.do?page="+page;
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var url = "/demandstatistics/demandaddlist.do?page="+(page+1);
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();		
  	  var url = "/demandstatistics/demandaddlist.do?page="+(page-1);
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function topageInfo(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var topage = $("#topage").val();
  	  var url = "/demandstatistics/demandaddlist.do?page="+topage;
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  
    
  function searchByCon(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	  
	  var url = "/demandstatistics/demandaddlist.do?page=1";
	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
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
	    	<a href="index.html" title="信息绩效统计" class="tip-bottom"><i class="icon-home"></i>信息绩效统计</a>
	     	<a href="" title="需求发布统计" class="current">需求发布统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求发布统计</h5>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>开始时间：<input type="text" id="startdate" class="span2" onclick="WdatePicker()" readonly value="${startdate}"/></span>
                <span>结束时间：<input type="text" id="enddate" class="span2" onclick="WdatePicker()" readonly value="${enddate}"/></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>客户</th><th>需求</th><th>录入人</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(stlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有需求发布统计信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${stlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>${item.corpname}</td>
	                  	   <td>${item.projecttype}</td>
	                  	   <td>
	                  	   		<c:forEach items="${userlist}" var="itemuser">
	                  	   			<c:if test="${itemuser.usercode eq item.operationuser}">${itemuser.realname}</c:if>
	                  	   		</c:forEach>
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
          
          <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>人员</th><th>需求数量</th>        
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(addlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有需求发布统计信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${addlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>${item.realName}</td>
	                  	   <td>${item.adddemcount}</td>
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
          
          
        </div>
  </div>
</div>
</body>
</html>