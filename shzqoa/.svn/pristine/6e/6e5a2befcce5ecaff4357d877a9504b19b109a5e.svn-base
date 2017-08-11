<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>帖子统计列表</title>
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
	.container-fluid {padding-right: 0px; padding-left: 0px;}
	.widget-box { margin-top: 0; margin-bottom: 0;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,3);
  })
  
  function togetListBypage(page){
	  var demandnoteid = $("#demandnoteid").val();
  	  var url = "/demandnotestatistics/toNoteStatisticsList.do?page="+page;
  	  if(demandnoteid!=null && demandnoteid!=""){
		  url += "&demandnoteid="+encodeURI(encodeURI($.trim(demandnoteid)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var demandnoteid = $("#demandnoteid").val();
  	  var url = "/demandnotestatistics/toNoteStatisticsList.do?page="+(page+1);
  	  if(demandnoteid!=null && demandnoteid!=""){
		  url += "&demandnoteid="+encodeURI(encodeURI($.trim(demandnoteid)));
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
	  var demandnoteid = $("#demandnoteid").val();
  	  var url = "/demandnotestatistics/toNoteStatisticsList.do?page="+(page-1);
  	  if(demandnoteid!=null && demandnoteid!=""){
		  url += "&demandnoteid="+encodeURI(encodeURI($.trim(demandnoteid)));
	  }
  	  window.location.href=url;
  }
  

  
  </script>
  
 </head>
 <body style="background-color:#fff;">
<div>
<input type="hidden" id="demandnoteid" value="${demandnoteid}">
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>统计时间</th><th>日浏览量</th><th>总浏览量</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">没有帖子统计信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td><fmt:formatDate value="${item.AddTime}" pattern="yyyy-MM-dd"/></td>
	                  	   <td>${item.DayPageView}</td>
	                  	   <td>${item.AllPageView}</td>
	                  	   
	                  </tr>
                 </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0);" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
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