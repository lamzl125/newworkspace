<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>待跟踪列表</title>
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
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
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
	  initMemu(1,9);
  })
  
  function togetListBypage(page){
  	  var url = "/customersign/toFollowResumeList.do?page="+page;
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
  	  var url = "/customersign/toFollowResumeList.do?page="+(page+1);
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
  	  var url = "/customersign/toFollowResumeList.do?page="+(page-1);
  	  window.location.href=url;
  }
  function topageInfo(){
  	  var topage = $("#topage").val();
  	  var url = "/customersign/toFollowResumeList.do?page="+topage;
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
	    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
	     	<a href="" title="跟踪简历列表" class="current">跟踪简历列表</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>跟踪简历列表</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>姓名</th><th>时间</th><th>出生日期</th><th>入职概率</th>
                  <th style="width:300px;">技术特长</th><th>综合评价</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(followlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有需要跟踪的简历信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${followlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>
	                  	   		<a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${item.CustomerCode }">${item.CustomerName}</a>
	                  	   </td>
	                  	   <td>
	                  	   		<fmt:formatDate value="${item.ResumeUpdateDate}" pattern="yyyy-MM-dd"/>
	                  	   </td>
	                  	   <td>${item.CustomerBirth}</td>
	                  	   <td>${item.EntryProbability}</td><td>${item.TechnicalExpertise}</td>
	                  	   <td>
		                  	   <c:choose>
			                   		<c:when test="${item.SynEvaluate>=1 && item.SynEvaluate<60 }">一般</c:when>
			                   		<c:when test="${item.SynEvaluate>=60 && item.SynEvaluate<80 }">良好</c:when>
			                   		<c:when test="${item.SynEvaluate>=80 && item.SynEvaluate<=100 }">优秀</c:when>
			                   	</c:choose>
                   			</td>
		                   <td>
		                   		<a class="appraiseButClass" href="/PingJia/edit.do?customercode=${item.CustomerCode }" class="zyh_tan_btn">添加评价</a>
		                   </td>
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