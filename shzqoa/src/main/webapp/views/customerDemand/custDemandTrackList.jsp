<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求跟踪列表</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
<link rel="stylesheet" href="/views/resource/css/style.css">
<script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/customerDemand/js/custDemandTrackList.js"></script>
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
 </head>
 <style>
.zyh_wii{ width:100px;} 
.zyh_btn {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
} 
.zyh_sosu{ margin-bottom:10px;}

.zyh_caozuo{
	display: inline-block;
    width: 40px;
    background-color: #E14C4D;
    color: #fff;
    cursor: pointer;}
 </style>
 <script type="text/javascript">
 function topageInfo(){
	 var topage = $("#topage").val();
	 var url = "/customerDemand/toCustDemandTrackList.do?page="+topage;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var url = "/customerDemand/toCustDemandTrackList.do?page="+(page-1);
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var url = "/customerDemand/toCustDemandTrackList.do?page="+page;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var url = "/customerDemand/toCustDemandTrackList.do?page="+(page+1);
	 window.location.href=url;
	}
 $(function(){
	  $('.whh_tab1 tbody tr').each(function(col) {
		  if(col<3){
			  $('.whh_tab1').rowspan(col); 
		  }
		 });
 })
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
 
 </script>
 <body>
 <input type="hidden" id="initflag" value=${trackFlag}>
  <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求跟踪列表</span></h2>
          <div class="custDemandTrack">
          	 <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                  	<c:forEach items="${custList}" var="mapItem" begin="0" end="0">
						<c:forEach items="${mapItem}" var="entry">
						  <c:if test='${entry.key == "Id"}'><th style="display:none;">Id</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "OpertName"}'><th>提交人</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "CustomerName"}'><th>姓名</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "CorpName"}'><th>客户</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "name"}'><th>技术方向</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "EntryTime"}'><th>工作年限</th></c:if>
			            </c:forEach>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "ExpectationSalary"}'><th>希望薪资</th></c:if>
			            </c:forEach>
			            <th>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key != "ExpectationSalary" &&
					       entry.key != "OpertName" &&        entry.key != "CorpName"&& 
					        entry.key != "name"&&         entry.key != "EntryTime"&& 
					        entry.key != "CustomerName"&& entry.key != "Id" && 
					        entry.key != "Specificrequirement"}'>
					      		${entry.key}
					      </c:if>
			            </c:forEach>
			            </th>
			            <th style='<c:if test="${operflag==0}">display:none;</c:if>'>操作</th>
					</c:forEach>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(custList) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td>
					    </tr>
					</c:if>
					<c:forEach items="${custList}" var="mapItem">
					<tr>
						<td name="Id" style="display:none;">
						<c:forEach items="${mapItem}" var="entry">
						  <c:if test='${entry.key == "Id"}'>${entry.value}</c:if>
			            </c:forEach>
			            </td>
			            <td>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "OpertName"}'>${entry.value}</c:if>
			            </c:forEach>
			            </td>
			            <td>
				            <c:forEach items="${mapItem}" var="entry">
						      <c:if test='${entry.key == "CustomerName"}'>
						      	${entry.value}
						      </c:if>
				            </c:forEach>
			            </td>
			            <td name="corpname">
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "CorpName"}'>
					      	<a class="getSpecificrequirement" href="javascript:void(0);">${entry.value}</a>
					      </c:if>
			            </c:forEach>
			            </td>
			            <td>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "name"}'>${entry.value}</c:if>
			            </c:forEach>
			            </td>
			            <td>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "EntryTime"}'>
				      		<fmt:formatNumber type="number" maxFractionDigits="0" value="${entry.value}" />年
					      </c:if>
			            </c:forEach>
			            </td>
			            <td>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key == "ExpectationSalary"}'>${entry.value}</c:if>
			            </c:forEach>
			            </td>
			            <td>
			            <c:forEach items="${mapItem}" var="entry">
					      <c:if test='${entry.key != "ExpectationSalary" && entry.key != "OpertName" && 
					      entry.key != "CorpName"&& entry.key != "name"&& 
					      entry.key != "EntryTime"&& entry.key != "CustomerName"&& 
					      entry.key != "Id" && entry.key != "Specificrequirement"}'>
					      		${entry.value}
					      </c:if>
			            </c:forEach>
			            </td>
			            <td style='<c:if test="${operflag==0}">display:none;</c:if>'>
						      <a class="editButClass" href="javascript:void(0);">跟踪</a>
			            </td>
			            <td style="display:none;" name="itemspereq">
			      			<c:forEach items="${mapItem}" var="entry">
						      <c:if test='${entry.key == "Specificrequirement"}'>${entry.value}</c:if>
				            </c:forEach>
			            </td>
			           </tr>
					</c:forEach>
                </tbody>
              </table>
          	 <!-- 页码开始 -->
             <div class="od_pages clearfix">
					<div class="travels_diary_page">
						<c:if test="${tatalpage>1 && currpage != 1}">
							<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
						</c:if>
						<c:if test="${tatalpage<=3}">
							<c:forEach var="item" begin="1" end="${tatalpage}"
								varStatus="status">
								<a href="javascript:void(0);"
									class="<c:if test='${currpage==item}'>curr</c:if>"
									onclick="togetListBypage(${item})">${item}</a>
							</c:forEach>
						</c:if>
						<c:if test="${tatalpage>3}">
							<c:if test="${currpage>=3}">
								<c:if test="${currpage==tatalpage}">
									<c:forEach var="item" begin="${currpage-2}" end="${currpage}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>
								<c:if test="${currpage!=tatalpage}">
									<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>

							</c:if>
							<c:if test="${currpage<3}">
								<c:forEach var="item" begin="1" end="3" varStatus="status">
									<a href="javascript:void(0);"
										class="<c:if test='${currpage==item}'>curr</c:if>"
										onclick="togetListBypage(${item})">${item}</a>
								</c:forEach>
							</c:if>
							<c:if test="${currpage != tatalpage}">
								<span class="ellipsis">...</span>
							</c:if>

						</c:if>
						<c:if test="${tatalpage>1}">
							<c:if test="${currpage < tatalpage}">
								<span class="next_page" onclick="tonextpageInfo(${currpage})">下一页</span>
							</c:if>
							<span class="reach_desc">到</span>
							<input type="text" id="topage">
							<span class="confirm_btn" onclick="topageInfo()">确定</span>
						</c:if>

					</div>
				</div>
              <!-- 页码结束 -->
          </div>
       </div>
   </div>
 </body>
</html>