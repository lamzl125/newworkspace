<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>服务费用统计页面</title>
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
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/dateinit.js" type="text/javascript"></script>
<script type="text/javascript">
	function toprevpageInfo(page){
	  	var url = "/serviceSettlement/selectCost.do?page="+(page-1);
	  	window.location.href=url;
	}
	function togetListBypage(page){
	  	var url = "/serviceSettlement/selectCost.do?page="+page;
	  	window.location.href=url;
	}
	function tonextpageInfo(page){
	  	var url = "/serviceSettlement/selectCost.do?page="+(page+1);
	  	window.location.href=url;
	}
	function topageInfo(){
		var topage = $("#topage").val();
	  	var url = "/serviceSettlement/selectCost.do?page="+topage;
	  	window.location.href=url;
	} 
	$(document).ready(function(){
		  initMemu(3,1);
	})
</script>
</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	     	<a href="" title="服务费结算表" class="current">服务费结算表</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>服务费结算表</h5>
          </div>
          <div class="widget-content clearfix">
            <div class="zyh_sos search">
	            	<span>姓名：</span>
	                <input name="customername" value="${customername }"  class="zyh_txt" /> 
					<span>性别：</span> 
					<select name="customersex" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:choose>
							<c:when test="${customersex ne '' && customersex eq 0}">
								<option value="0" selected="selected">男</option>
							</c:when>
							<c:otherwise>
								<option value="0">男</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${customersex ne '' && customersex eq 1}">
								<option value="1" selected="selected">女</option>
							</c:when>
							<c:otherwise>
								<option value="1">女</option>
							</c:otherwise>
						</c:choose>
					</select>
					 <a class="btn searchBth zyh_btn_n" href="javascript:void(0)">搜索</a>
	            </div>
	            
	            
	            
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="10%"><col width="10%"><col width="10%">
	            	<col width="10%"><col width="10%"><col width="15%"><col width="25%">
	            </colgroup>
              <thead>
                <tr>
                	<th>应结算公司名称</th>
                     <th>合同签订总月份</th>
                     <th>签订时间</th>
                     <th>结束时间</th>
                     <th>结算月份</th>
                     <th>费用</th>
                     <th>操作</th>
                </tr>
              </thead>
              <tbody>
           			<c:if test="${fn:length(list) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有服务费用统计信息</td>
					    </tr>
					</c:if>
                  	<c:forEach items="${list }" var="lists">
                  		<tr>
                  			<td>${lists.settlementName }</td>
                  			<td>${lists.contractCount }</td>
                  			<td><fmt:formatDate value="${lists.contracBeginTime }"
											pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${lists.contractEndTime }"
											pattern="yyyy-MM-dd" /></td>
                  			<td>${lists.settlementMonth }</td>
                  			<td>${lists.settlementCost }</td>
                  			<td><a class="zyh_yes" href="/expenseVoucher.do?corpName=${lists.settlementName}&servicePayCount=${lists.settlementCost}&settlementMonth=${lists.settlementMonth}">结算</a></td>
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