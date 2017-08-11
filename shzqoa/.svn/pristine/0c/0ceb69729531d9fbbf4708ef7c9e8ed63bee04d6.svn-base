<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>利润查询</title>
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
.btn {display: inline-block;width: 50px;height: 30px;line-height: 21px;text-align: center;margin-left: 20px;}
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
	var customername = $('.search').find('input[name="customername"]').val();
	var corpname = $('.search').find('input[name="corpname"]').val();
	var opertname = $('.search').find('input[name="opertname"]').val();
 	var url = "/servicepaysummary/queryServiceProfitsList.do?page="+page+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&corpname="+encodeURI(encodeURI($.trim(corpname)))+"&opertname="+encodeURI(encodeURI($.trim(opertname)));
 	window.location.href=url;
}
function tonextpageInfo(page){
	var customername = $('.search').find('input[name="customername"]').val();
	var corpname = $('.search').find('input[name="corpname"]').val();
	var opertname = $('.search').find('input[name="opertname"]').val();
 	var url = "/servicepaysummary/queryServiceProfitsList.do?page="+(page+1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&corpname="+encodeURI(encodeURI($.trim(corpname)))+"&opertname="+encodeURI(encodeURI($.trim(opertname)));
 	window.location.href=url;
}
function toprevpageInfo(page){
	var customername = $('.search').find('input[name="customername"]').val();
	var corpname = $('.search').find('input[name="corpname"]').val();
	var opertname = $('.search').find('input[name="opertname"]').val();
 	var url = "/servicepaysummary/queryServiceProfitsList.do?page="+(page-1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&corpname="+encodeURI(encodeURI($.trim(corpname)))+"&opertname="+encodeURI(encodeURI($.trim(opertname)));
 	window.location.href=url;
}
function topageInfo(){
	var customername = $('.search').find('input[name="customername"]').val();
	var corpname = $('.search').find('input[name="corpname"]').val();
	var opertname = $('.search').find('input[name="opertname"]').val();
 	var topage = $("#topage").val();
 	var url = "/servicepaysummary/queryServiceProfitsList.do?page="+topage+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&corpname="+encodeURI(encodeURI($.trim(corpname)))+"&opertname="+encodeURI(encodeURI($.trim(opertname)));
	window.location.href=url;
}
$(function(){
	$('.searchBth').off('click').on('click',function(){
		var customername = $('.search').find('input[name="customername"]').val();
		var corpname = $('.search').find('input[name="corpname"]').val();
		var opertname = $('.search').find('input[name="opertname"]').val();
		window.location.href="/servicepaysummary/queryServiceProfitsList.do?customername="+encodeURI(encodeURI($.trim(customername)))+"&corpname="+encodeURI(encodeURI($.trim(corpname)))+"&opertname="+encodeURI(encodeURI($.trim(opertname)));
	});
});
$(document).ready(function(){
	  initMemu(3,4);
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
	     	<a href="" title="利润查询" class="current">利润查询</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>利润查询</h5>
          </div>
          <div class="widget-content clearfix">
            	<div class="zyh_sos search">
	            	<span>姓名：</span>
	                <input name="customername" value="${customername }"  class="zyh_txt" /> 
	                <%-- <span>客户：</span>
	                <input name="corpname" value="${corpname }"  class="zyh_txt" />
	                <span>招聘人事：</span>
	                <input name="opertname" value="${opertname }"  class="zyh_txt" /> --%>
					 <a class="btn searchBth zyh_btn_n" href="javascript:void(0);">搜索</a>
	            </div>
	            <%-- <div class="zyh_sos search">
			    <span>姓名：</span>
	                <input name="customername" value="${customername }"  class="zyh_txt" /> 
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
	            </div> --%>
	            
	            
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="15%"><col width="15%"><col width="15%"><col width="15%">
	            	<col width="20%"><col width="20%">
	            </colgroup>
              <thead>
                <tr>
                	<th>姓名</th><th>月份</th><th>下月利润</th><th>下月预计服务费</th>
					<th>截止当前利润</th><th>截至当前利润/投资总额</th>
                </tr>
              </thead>
              <tbody>
           			<c:forEach items="${cplist}" var="c">
								<c:forEach items="${monthpay}" var="monthinfo">
									<c:if test="${c.id==monthinfo.key}">
										<c:set var="allpay" value="0"></c:set>
										<c:set var="lirun" value="0"></c:set>
										<c:set var="zonglirun" value="0"></c:set>
										<c:set var="compare1" value="0"></c:set>
										<c:forEach items="${monthinfo.value}" var="monthstr" varStatus="montstatus">
											<c:set var="allmonthstr">
									    		<fmt:formatDate pattern="yyyy-MM" value="${monthstr}" />
									    	</c:set>
									    	<c:set var="nowmonthstr">
									    		<fmt:formatDate pattern="yyyy-MM" value="<%=new Date() %>" />
									    	</c:set>
							    			<c:if test="${allmonthstr<=nowmonthstr }">
							    				<c:set var="expiremonthstr">
										    		<fmt:formatDate pattern="MM" value="${c.startTime}" />
										    	</c:set>
										    	<c:set var="expiremonthstr" value="${expiremonthstr+10}"></c:set>
										    	<c:set var="expireyearstr">
										    		<fmt:formatDate pattern="yyyy" value="${c.startTime}" />
										    	</c:set>
										    	<c:if test="${expiremonthstr>12}">
										    		<c:set var="expiremonthstr" value="${expiremonthstr-12}"></c:set>
									    			<c:set var="expireyearstr" value="${expireyearstr+1}"></c:set>
										    	</c:if>
										    	
										    	<c:set var="payyearstr">
										    		<fmt:formatDate pattern="yyyy" value="${monthstr}" />
										    	</c:set>
										    	<c:set var="paymonthstr">
										    		<fmt:formatDate pattern="MM" value="${monthstr}" />
										    	</c:set>
							    				<tr class="<c:if test='${payyearstr>expireyearstr||(payyearstr eq expireyearstr && paymonthstr>expireyearstr)}'>redclass</c:if>">
													<td>
														<c:forEach items="${list1}" var="resume">
															<c:if test="${resume.customercode==c.customerCode}">${resume.customername}</c:if>
														</c:forEach>
													</td>
													<td>
												    	<fmt:formatDate pattern="yyyy-MM" value="${monthstr}" />
												    </td>
													
													<td>
														<c:forEach items="${allsalarylist}" var="salary" varStatus="salarystatus">
															<c:set var="salarymonthstr">
													    		<fmt:formatDate pattern="yyyy-MM" value="${salary.KqTime}" />
													    	</c:set>
															<c:if test="${salary.CustomerCode eq c.customerCode && allmonthstr eq salarymonthstr}">
																<c:set var="lirun">
																	<fmt:formatNumber pattern='0.00' value='${salary.IdleSalary/salary.XzFdTime*salary.XzTime-salary.CdTime*10+salary.ProbationarySalary/salary.SyqFdTime*salary.SyqTime+salary.RegularSalary/salary.FdTime*salary.SjTime-salary.Sj-salary.Kjk-salary.Kzs+salary.Bxiao+salary.Bxian+salary.Bz}' />
																</c:set>	
														<c:forEach items="${allpaylist}" var="payinfo" varStatus="paystatus">
															<c:if test="${payinfo.YearIndex eq payyearstr && payinfo.MonthIndex eq paymonthstr&& payinfo.CorpCode eq c.corpCode && payinfo.CustomerCode eq c.customerCode}">
														    	<c:set var="allpay" value="${payinfo.RealPay}"></c:set>	
															</c:if>
														</c:forEach>
																<c:set var="lirun" value="${allpay-lirun }"></c:set>
															</c:if>
														</c:forEach>
														${lirun}
													</td>
													<td>${c.servicePay} </td>
													
													<td>
														<c:forEach items="${profitList}" var="profit" varStatus="prostatus">
															<c:forEach items="${profit}" var="map">
 															<c:if test="${c.id==map.key}"> 
 																<c:set var="zonglirun" value="${map.value}"></c:set>  
															</c:if> 
														      </c:forEach>
														</c:forEach>
														${zonglirun} 
													</td>
													<td>
														<c:forEach items="${compareList}" var="compare" varStatus="salarystatus">
														<c:forEach items="${compare}" var="map">
															<c:if test="${map.key==c.id}">
																<c:set var="compare1" value="${map.value}"></c:set>
															</c:if>
															 </c:forEach>
														</c:forEach>
														${compare1}
													</td>
											   </tr>
							    			</c:if>
									    </c:forEach>
									</c:if>
								</c:forEach>
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