<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>服务费核算</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link href="/views/common/css/lanren.css" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" />
<!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" />
<!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
<script src="/views/common/js/jquery.min.js" type="text/javascript"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js"
	type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script>
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(1,8);
  });
 	function togetListBypage(page){
		var customername = $('.search').find('input[name="customername"]').val();
	 	var url = "/customerAllInfoDatail/queryCustomerDetails.do?page="+page+"&customername="+encodeURI(encodeURI($.trim(customername)));
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
		var customername = $('.search').find('input[name="customername"]').val();
	 	var url = "/customerAllInfoDatail/queryCustomerDetails.do?page="+(page+1)+"&customername="+encodeURI(encodeURI($.trim(customername)));
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
		var customername = $('.search').find('input[name="customername"]').val();
	 	var url = "/customerAllInfoDatail/queryCustomerDetails.do?page="+(page-1)+"&customername="+encodeURI(encodeURI($.trim(customername)));
	 	window.location.href=url;
	}
	function topageInfo(){
		var customername = $('.search').find('input[name="customername"]').val();
	 	var topage = $("#topage").val();
	 	var url = "/customerAllInfoDatail/queryCustomerDetails.do?page="+topage+"&customername="+encodeURI(encodeURI($.trim(customername)));
		window.location.href=url;
	}
	$(function(){
		$('.searchBth').off('click').on('click',function(){
			var customername = $('.search').find('input[name="customername"]').val();
			window.location.href="/customerAllInfoDatail/queryCustomerDetails.do?customername="+encodeURI(encodeURI($.trim(customername)));
		});
	});
	/* function customerEdit(cid){
		var customername = $('.search').find('input[name="customername"]').val();
		window.location.href="/paydetail/queryOutCompany.do?cid="+cid+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
	}
	 */
  </script>
<style type="text/css">
.zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
.search {
	/*position: absolute;
	right: 80px;
	top: 15px;*/
}

.search label {
	margin-left: 20px;
}
.redclass{color:red;}
.btn {
	display: inline-block;
	width: 50px;
	height: 30px;
	line-height: 21px;
	text-align: center;
	margin-left: 20px;
}

.searchBth {
	color: #FFFFFF;
	background: #0F486E;
}

.searchBth:hover {
	color: #F6F6F6;
	background: #125582;
}

.searchBth:active {
	color: #F6F6F6;
	background: #206A9C;
}
.zyh_txt {
	border-radius: 3px;
	padding-left: 5px;
	border: #F1F1F1 1px solid;
	width: 90px;
	height: 30px;
	font-size: 13px;
	color: #666;
}
.zyh_btn_n {
    width: 50px;
    line-height: 30px;
    color: #fff;
    background-color: #0aa7e6;
    border: none;
    border-radius: 5px;
    margin-left: 8px;
    cursor: pointer;
}
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
</head>
<body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a> 
				<a href="" title="在项人员详情" class="current">在项人员详情</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i></span>
					<h5>在项人员详情</h5>
				</div>
				<div class="widget-content clearfix">
					<form name="signupForm" method="post" id="signupForm" class="form-inline">
						<div class="zyh_sos search">
			            	<span>姓名：</span>
			                <input name="customername" value="${customername }"  class="zyh_txt" /> 
							 <a class="btn searchBth zyh_btn_n" href="javascript:void(0);">搜索</a>
			            </div>
						<table class="table table-bordered table-striped with-check">
							<colgroup>
								<col width="4%" /><!-- 姓名 -->
								<col width="6%" /><!-- 入职时间 -->
								<col width="4%" /><!-- 招聘人事 -->
								<col width="4%" /><!-- 计算机借用情况 -->
								<col width="4%" /><!-- 客户 -->
								<col width="6%" /><!-- 入项时间 -->
								<col width="6%" /><!-- 出项时间 -->
								<col width="4%" /><!-- 单价 -->
								<col width="4%" /><!-- 付款周期 -->
								<col width="5%" /><!-- 月份 -->
								<col width="4%" /><!-- 应结费用 -->
								<col width="4%" /><!-- 实结费用 -->
								<col width="4%" /><!-- 结款日期 -->
								<col width="4%" /><!-- 工资基数-->
								<col width="4%" /><!-- 五险一金 -->
								<col width="4%" /><!-- 补助 -->
								<col width="4%" /><!-- 加班费 -->
								<col width="4%" /><!-- 已出项是否结清 -->
								<col width="4%" /><!-- 费用总计 -->
								<col width="4%" /><!-- 利润 -->
							</colgroup>
							<thead>
								<tr>
									<th>姓名</th>
									<th>入职时间</th>
									<th>人事</th>
									<th>笔记本</th>
									<th>客户</th>
									<th>入项时间</th>
									<th>出项时间</th>
									<th>单价</th>
									<th>付款周期</th>
									<th >月份</th>
									<th>应结费用</th>
									<th>实结费用</th>
									<th>结款日期</th>
									<th>工资基数</th>
									<th>五险一金</th>
									<th>补助</th>
									<th>加班费</th>
									<th>是否结清</th>
									<th>费用总计</th>
									<th>利润</th>			
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cplist}" var="c">
									<c:forEach items="${monthpay}" var="monthinfo">
										<c:if test="${c.id==monthinfo.key }">
											<c:set var="allpay" value="0"></c:set>
											<c:set var="lirun" value="0"></c:set>
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
															<c:forEach items="${list}" var="resume">
																<c:if test="${resume.customercode==c.customerCode}"><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${c.customerCode}">${resume.customername}</a></c:if>
															</c:forEach>
														</td>
														<td >
															<c:forEach items="${list}" var="resume">
																<c:if test="${resume.customercode==c.customerCode}"><fmt:formatDate pattern="yyyy-MM-dd" value="${resume.zqentrytime}" /></c:if>
															</c:forEach>
														</td>
														<td >
															<c:forEach items="${list}" var="resume">
																<c:if test="${resume.customercode==c.customerCode}">${resume.opertname }</c:if>
															</c:forEach>
														</td>
														<td>
																<c:if test="${fn:length(noreturnlist)==0}">未借</c:if>
																<c:if test="${fn:length(noreturnlist)>0}">
																	<c:set var="nocount" value="0"></c:set>
																	<c:forEach items="${noreturnlist}" var="noreturninfo">
																			<c:if test="${noreturninfo.name==c.customerCode}"><c:set var="nocount" value="${nocount+1}"></c:set>${noreturninfo.itemname}</c:if>
																	</c:forEach>
																	<c:if test="${nocount==0}">未借</c:if>
																</c:if>
														</td>
														<td >
															<c:forEach items="${corplist}" var="corp">
																<c:if test="${corp.corpcode==c.corpCode}">${corp.corpname}</c:if>
															</c:forEach>
														</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd" value="${c.startTime}" /></td>
														<td><fmt:formatDate pattern="yyyy-MM-dd" value="${c.endTime}" /></td>
														<td>${c.servicePay}</td>
														<td>${c.settledCycle eq 1?'月付':c.settledCycle eq 2?'隔月付':c.settledCycle eq 3?'季付':'' }</td>
													    <td>
													    	<fmt:formatDate pattern="yyyy-MM" value="${monthstr}" />
													    </td>
														<td>${c.servicePay} </td>
														<td>
																<c:forEach items="${allpaylist}" var="payinfo" varStatus="paystatus">
																	<c:if test="${payinfo.YearIndex eq payyearstr && payinfo.MonthIndex eq paymonthstr&& payinfo.CorpCode eq c.corpCode && payinfo.CustomerCode eq c.customerCode}">
																    	${payinfo.RealPay}
																	</c:if>
																</c:forEach>
																<c:set var="allpay" value="${allpay+0}"></c:set>
														</td>
														<td><c:set var="payyearstr">
														    		<fmt:formatDate pattern="yyyy" value="${monthstr}" />
														    	</c:set>
														    	<c:set var="paymonthstr">
														    		<fmt:formatDate pattern="MM" value="${monthstr}" />
														    	</c:set>
																<c:forEach items="${allpaylist}" var="payinfo" varStatus="paystatus">
																	<c:if test="${payinfo.YearIndex eq payyearstr && payinfo.MonthIndex eq paymonthstr&& payinfo.CorpCode eq c.corpCode && payinfo.CustomerCode eq c.customerCode}">
																    	<fmt:formatDate pattern="yyyy-MM-dd" value="${payinfo.UpdateTime}" />
																	</c:if>
																</c:forEach></td>
														<td>
															<c:forEach items="${allsalarylist}" var="salary" varStatus="salarystatus">
																<c:set var="salarymonthstr">
														    		<fmt:formatDate pattern="yyyy-MM" value="${salary.KqTime}" />
														    	</c:set>
																<c:if test="${salary.CustomerCode eq c.customerCode && allmonthstr eq salarymonthstr}">
															    	<c:choose>
															    		<c:when test="${salary.IfZZ}">
															    			${salary.RegularSalary }
															    		</c:when>
															    		<c:when test="${salary.IfZZ==false}">
															    			${salary.ProbationarySalary }
															    		</c:when>
															    		<c:otherwise>''</c:otherwise>
															    	</c:choose>
																</c:if>
															</c:forEach>
														</td>
														<td>
															<c:forEach items="${allsalarylist}" var="salary" varStatus="salarystatus">
																<c:set var="salarymonthstr">
														    		<fmt:formatDate pattern="yyyy-MM" value="${salary.KqTime}" />
														    	</c:set>
																<c:if test="${salary.CustomerCode eq c.customerCode && allmonthstr eq salarymonthstr}">
																	${salary.Bxian}
																</c:if>
															</c:forEach>
														</td>
														<td>
															<c:forEach items="${allsalarylist}" var="salary" varStatus="salarystatus">
																<c:set var="salarymonthstr">
														    		<fmt:formatDate pattern="yyyy-MM" value="${salary.KqTime}" />
														    	</c:set>
																<c:if test="${salary.CustomerCode eq c.customerCode && allmonthstr eq salarymonthstr}">
																	${salary.Bz}
																</c:if>
															</c:forEach>
														</td>
														<td>0.00</td>
														<td>否</td>
														<td>${allpay }
															<c:set var="allpay" value="${allpay+0}"></c:set>
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
																	<c:set var="lirun" value="${allpay-lirun }"></c:set>
																</c:if>
															</c:forEach>
															${lirun}
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
								<li <c:if test="${currpage<=1}">class="disabled"</c:if>><a
									href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
								<c:if test="${tatalpage>=currpage}">
									<li class="active"><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage})">${currpage}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+1)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+1})">${currpage+1}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+2)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+2})">${currpage+2}</a></li>
								</c:if>
								<c:if test="${tatalpage>=(currpage+3)}">
									<li><a href="javascript:void(0)"
										onclick="togetListBypage(${currpage+3})">${currpage+3}</a></li>
								</c:if>
								<li><a href="javascript:void(0)"
									onclick="tonextpageInfo(${currpage})">Next</a></li>
							</ul>
						</div>


					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>