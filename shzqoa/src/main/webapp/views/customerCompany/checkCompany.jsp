<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>审核</title>
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
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
 </head>
 <style>
  .zyh_rated_btn{ width:100px; height:36px; background-color:#007ADF; border:none; color:#fff; border-radius:3px; display: inline-block; line-height:36px; margin-top:20px; margin-bottom:20px; font-size:16px;}

 </style>
 <script type="text/javascript">
	 function togetListBypage(page){
	 	var url = "/company/initPage.do?page="+page;
	 	window.location.href=url;
	 }
	 function tonextpageInfo(page){
	 	var url = "/company/initPage.do?page="+(page+1);
	 	window.location.href=url;
	 }
	 function toprevpageInfo(page){
	 	var url = "/company/initPage.do?page="+(page-1);
	 	window.location.href=url;
	 }
	 function topageInfo(){
	 	var topage = $("#topage").val();
	 	var url = "/company/initPage.do?page="+topage;
	 	window.location.href=url;
	 }
	 function operCheck(status,id){
		 $.ajax({
				url:'/company/operCheck.do',
				data:{
					status:status,
					id:id
				},
				type:'POST',
				dataType:'json',
				cache:false,
				success:function(res){
					if(res && res>0){
						var page = $('a.curr').text();
						var url = "/company/initPage.do?page="+page;
					 	window.location.href=url;
					}else{
						alert("操作失败");
					}
				}
		 });
	 }
	 $(document).ready(function(){
		  initMemu(3,2);
	})
 </script>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	     	<a href="" title="审核" class="current">审核</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>审核</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="5%"><col width="10%"><col width="10%">
	            	<col width="10%"><col width="10%"><col width="10%"><col width="10%">
	            	<col width="20%">
	            </colgroup>
              <thead>
                <tr>
                	<th>公司名称</th><th>结算月份</th><th>所需支付费用</th><th>实际支付费用</th>
                     <th>备注说明</th><th>支付凭证</th><th>操作人</th><th>日期</th>
                     <th>审核</th>
                </tr>
              </thead>
              <tbody>
           			<c:forEach items="${list }" var="c">
	                	<tr>
		                	<td><a href="" class="font_orange">${c.companyName}</a></td>
		                	<td>${c.balancemonth }</td>
		                   	<td>${c.predictCost }</td>
		                   	<td>${c.realityCost }</td>
		                   	<td>${c.explain }</td>
		                   	<td><img src="${c.certificate }"  width="150"></td>
		                   	<td>${c.operator }</td>
		                   	<td><fmt:formatDate pattern="yyyy-MM-dd" value="${c.creatime }" /></td>
		                   	<c:if test="${c.status eq 0 }">
			                   	<td><a class="zyh_yes" href="javascript:void(0);" item="${c.id }" onclick="operCheck(1,'${c.id }');">通过</a>
			                   	 <a class="zyh_no" href="javascript:void(0);" onclick="operCheck(2,'${c.id }');">不通过</a></td>
		                   	</c:if>
		                   	<c:if test="${c.status eq 1 }">
			                   	<td>审核通过</td>
		                   	</c:if>
		                   	<c:if test="${c.status eq 2 }">
			                   	<td>审核不通过</td>
		                   	</c:if>
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