<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>帖子管理</title>
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
  <style type="text/css">
	.whh_input{width:100px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(4,3);
  })
  
  function searchByCon(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();
	  var url = "/demandnote/daypageviews.do?page=1";
	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();
  	  var url = "/demandnote/daypageviews.do?page="+page;
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
  	  var url = "/demandnote/daypageviews.do?page="+(page+1);
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
  	  var url = "/demandnote/daypageviews.do?page="+(page-1);
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
	  var url = "/demandnote/daypageviews.do?startdate="+startdate+"&enddate="+enddate;
	  window.location.href=url;
  }
  function userstapv(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();
	  var url = "/demandnote/userstapv.do?startdate="+startdate+"&enddate="+enddate;
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
	    		<a href="" title="工作信息" class="tip-bottom"><i class="icon-home"></i>工作信息</a>
	     		<a href="" title="帖子浏览量统计" class="current">帖子浏览量统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>开始时间：
                	<input type="text" id="startdate" class="span2" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${startdate}'/>"/>
                </span>
                <span>结束时间：<input type="text" id="enddate" class="span2" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${enddate}'/>"/></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
                <button class="btn btn-info" onclick="userstapv()">人员统计</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>日期</th><th>人员</th><th>帖子</th><th>浏览量</th>             
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">没有帖子浏览量统计信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td><td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.AddTime}"/></td>
	                  	   <td>${item.realName}</td><td>${item.NoteName}</td>
	                  	   <td>${item.DayPageView}</td>
		                   
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