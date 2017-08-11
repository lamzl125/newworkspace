<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>月服务费查询</title>
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
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>

<style type="text/css">
.zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
.search label {margin-left: 20px;}
.btn {display: inline-block;height: 24px;line-height: 21px;text-align: center;margin-left: 20px;}
.searchBth {color: #FFFFFF;background: #0F486E;}
.searchBth:hover {color: #F6F6F6;background: #125582;}
.searchBth:active {color: #F6F6F6;background: #206A9C;}
.zyh_txt {border-radius: 3px;padding-left: 5px;border: #F1F1F1 1px solid;width: 90px;height: 30px;font-size: 13px;color: #666;}
.zyh_btn_n {width: 50px;line-height: 30px;color: #fff;background-color: #0aa7e6;border: none;border-radius: 5px;margin-left: 8px;cursor: pointer;}
</style>
<script>
//-----------上下单元格合并--------------------
jQuery.fn.rowspan = function(colIdx) {
	 return this.each(function(){
	  var that;
	  $('tr', this).each(function(row) {
	  $('td:eq('+colIdx+')', this).each(function(col) {
	      if ($(this).html() == $(that).html()) {
	        rowspan = $(that).attr("rowSpan");
	        if (rowspan == undefined) {
	          $(that).attr("rowSpan",1);
	          rowspan = $(that).attr("rowSpan");
	        }
	        rowspan = Number(rowspan)+1;
	        $(that).attr("rowSpan",rowspan); // do your action for the colspan cell here
	        $(this).hide(); // .remove(); // do your action for the old cell here
	      } else {
	        that = this;
	      }
	      that = (that == null) ? this : that; // set the that if not already set
	  });
	 });
	 });
}

//-----------左右单元格合并--------------------
jQuery.fn.colspan = function(rowIdx) {
 return this.each(function(){
  var that;
  $('tr', this).filter(":eq("+rowIdx+")").each(function(row) {
  $(this).find('td').each(function(col) {
      if ($(this).html() == $(that).html()) {
        colspan = $(that).attr("colSpan");
        if (colspan == undefined) {
          $(that).attr("colSpan",1);
          colspan = $(that).attr("colSpan");
        }
        colspan = Number(colspan)+1;
        $(that).attr("colSpan",colspan);
        $(this).hide(); // .remove();
      } else {
        that = this;
      }
      that = (that == null) ? this : that; // set the that if not already set
  });
 });
 });
 }
	 
	 $(document).ready(function(){
// 		 $('.whh_tab1 tbody tr').each(function(col) {
// 			   $('.whh_tab1').rowspan(col);
// 		 });
  })
</script>
<script type="text/javascript">
 	function togetListBypage(page){
		var customercode = $('.search').find('select[name="customercode"]').val();
	 	var url = "/servicepaysummary/queryServicePayList.do?page="+page+"&customercode="+encodeURI(encodeURI($.trim(customercode)));
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
		var customercode = $('.search').find('select[name="customercode"]').val();
	 	var url = "/servicepaysummary/queryServicePayList.do?page="+(page+1)+"&customercode="+encodeURI(encodeURI($.trim(customercode)));
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
		var customercode = $('.search').find('select[name="customercode"]').val();
	 	var url = "/servicepaysummary/queryServicePayList.do?page="+(page-1)+"&customercode="+encodeURI(encodeURI($.trim(customercode)));
	 	window.location.href=url;
	}
	function topageInfo(){
		var customercode = $('.search').find('select[name="customercode"]').val();
	 	var topage = $("#topage").val();
	 	var url = "/servicepaysummary/queryServicePayList.do?page="+topage+"&customercode="+encodeURI(encodeURI($.trim(customercode)));
		window.location.href=url;
	}
	$(function(){
		$('.searchBth').off('click').on('click',function(){
			var customercode = $('.search').find('select[name="customercode"]').val();
			var corpcode = $('.search').find('select[name="corpcode"]').val();
			var yearstr = $('.search').find('input[name="yearstr"]').val();
			var monthstr = $('.search').find('select[name="monthstr"]').val();
			window.location.href="/servicepaysummary/queryServicePayList.do?customercode="+encodeURI(encodeURI($.trim(customercode)))
					+"&corpcode="+encodeURI(encodeURI($.trim(corpcode)))
					+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
					+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
		});
		$('.summaryBth').off('click').on('click',function(){
			var corpcode = $('.search').find('select[name="corpcode"]').val();
			var yearstr = $('.search').find('input[name="yearstr"]').val();
			var monthstr = $('.search').find('select[name="monthstr"]').val();
			window.location.href="/servicepaysummary/queryServicePaySumList.do?corpcode="+encodeURI(encodeURI($.trim(corpcode)))
					+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
					+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
		});
		$('.plansummaryBtn').off('click').on('click',function(){
			window.location.href="/servicepaysummary/expectedreturn.do";
		});
		$('.actualPayBtn').off('click').on('click',function(){
			window.location.href="/servicepaysummary/actualpayment.do";
		});
		
	});
	$(document).ready(function(){
		  initMemu(3,3);
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
	     	<a href="" title="月服务费查询" class="current">月服务费查询</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>月服务费查询</h5>
          </div>
          <div class="widget-content clearfix">
            	<div class="zyh_sos search">
	            	<span>姓名：</span>
	                <select name="customercode" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:forEach items="${cuslist}" var="cusinfo">
							<option value="${cusinfo.customercode}" <c:if test="${customerCode==cusinfo.customercode}">selected="selected"</c:if>>${cusinfo.customername}</option>
						</c:forEach>
					</select> 
					<span>公司：</span>
	                <select name="corpcode" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:forEach items="${corplist}" var="corp">
							<option value="${corp.corpcode}" <c:if test="${corpCode==corp.corpcode}">selected="selected"</c:if>>${corp.corpname}</option>
						</c:forEach>
					</select> 
					<span>年：</span>
	                <input name="yearstr" value="${yearstr}"  class="zyh_txt" /> 
	                <span>月：</span>
	                <select name="monthstr" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:forEach begin="1" end="12" var="m">
							<option value="${m}" <c:if test="${m==monthstr}">selected="selected"</c:if>>${m}月</option>
						</c:forEach>
					</select> 
					 <a class="btn searchBth zyh_btn_n" href="javascript:void(0)">搜索</a>
					 <a class="btn btn-default btn-sm actualPayBtn" href="javascript:void(0)" style="float:right;">实际回款</a>
					 <a class="btn btn-default btn-sm plansummaryBtn" href="javascript:void(0)" style="float:right;">预计回款</a>
					 <a class="btn btn-default btn-sm summaryBth" href="javascript:void(0)" style="float:right;">汇总</a>
	            </div>
	            
	            
	            
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="10%"><col width="25%"><col width="10%">
	            	<col width="10%"><col width="10%"><col width="15%"><col width="10%">
	            </colgroup>
              <thead>
                <tr>
                	<th>姓名</th><th>服务月份</th><th>客户公司</th><th>服务开始时间</th>
					<th>服务结束时间</th><th>服务费</th><th>付款周期</th><th>付款时间</th>
                </tr>
              </thead>
              <tbody>
           			<c:forEach items="${list}" var="info">
	    				<tr>
							<td>${info.CustomerName}</td>
							<td>${info.YearIndex}-${info.MonthIndex}</td>
							<td>${info.CorpName}</td>
							<td><fmt:formatDate value="${info.StartTime}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${info.EndTime}" pattern="yyyy-MM-dd" /></td>
							<td>${info.ServicePay}</td>
							<td>${info.SettledCycle eq 1?'月付':info.SettledCycle eq 2?'隔月付':info.SettledCycle eq 3?'季付':'' }</td>
							<td>
								<c:choose>
									<c:when test="${info.SettledCycle eq 1}">
										<c:if test="${info.MonthIndex==12}">
											<fmt:parseDate value="${info.YearIndex+1}-1-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
										<c:if test="${info.MonthIndex!=12}">
											<fmt:parseDate value="${info.YearIndex}-${info.MonthIndex+1}-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
									</c:when>
									<c:when test="${info.SettledCycle eq 2}">
										<c:if test="${info.MonthIndex>=11}">
											<fmt:parseDate value="${info.YearIndex+1}-${info.MonthIndex-10}-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
										<c:if test="${info.MonthIndex<11}">
											<fmt:parseDate value="${info.YearIndex}-${info.MonthIndex+2}-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
									</c:when>
									<c:when test="${info.SettledCycle eq 3}">
										<c:if test="${info.MonthIndex>=10}">
											<fmt:parseDate value="${info.YearIndex+1}-${info.MonthIndex-9}-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
										<c:if test="${info.MonthIndex<10}">
											<fmt:parseDate value="${info.YearIndex}-${info.MonthIndex+3}-1" var="yearMonth" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM" />
										</c:if>
									</c:when>
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