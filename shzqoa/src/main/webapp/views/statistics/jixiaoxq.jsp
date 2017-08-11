<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>绩效信息详情</title>
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
  <script type="text/javascript">
    function togetListBypage(page){
    	var opertCode=$("#opertCode").val().trim();
    	var url = "/PerfomanceDetail.do?"+"&opertCode="+opertCode+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var opertCode=$("#opertCode").val().trim();
    	var url = "/PerfomanceDetail.do?"+"&opertCode="+opertCode+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var opertCode=$("#opertCode").val().trim();
   		var url = "/PerfomanceDetail.do?"+"&opertCode="+opertCode+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
    	var opertCode=$("#opertCode").val().trim();
   		var topage = $("#topage").val();
   		var url = "/PerfomanceDetail.do?"+"&opertCode="+opertCode+"&page="+topage;
    	window.location.href=url;
    }
    $(document).ready(function(){
  	  initMemu(2,1);
    })
  </script>
 </head>
 <body>
 <jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="信息绩效统计" class="tip-bottom"><i class="icon-home"></i>信息绩效统计</a>
	     	<a href="" title="绩效信息详情" class="current">绩效信息详情</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>绩效信息详情</h5>
          </div>
          <div class="widget-content clearfix">
            <input type="hidden" id="opertCode" value="${opertcode}"/>
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="10%"><col width="10%"><col width="10%"><col width="50%"><col width="10%">
	            </colgroup>
              <thead>
                <tr><th>客户姓名</th><th>出生日期</th><th>参加工作时间</th><th>入职概率</th><th>技术特长</th><th>录入时间</th></tr>
              </thead>
              <tbody>
           			<c:if test="${fn:length(customerInfoList) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有客户信息</td>
					    </tr>
					</c:if>
					<c:forEach items="${customerInfoList}"  var="custInfo">
					<tr>
	                   <td><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${custInfo.customercode}">${custInfo.customername}</a></td>
	                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.customerbirth}"/></td>
	                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.entrytime}"/></td>
	                   <td>${custInfo.entryprobability }</td>
	                   <td>${custInfo.technicalexpertise}</td>
	                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.addtime}"/></td>
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