<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>添加简历</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
 </head>
 <style>
 
 
 
 .whh_content{background: #fff;}
 .whh_content_border{ border:none;}
 .whh_tab_bor{ overflow:hidden;}
 .zyh_table{ border:#CCC 1px dashed; float:left; margin-right:20px;}
 .zyh_table th,td{ border:none;}
 .zyh_tab_box{ margin-left: 150px;; overflow:hidden;}
.zyh_btt1{width:100px; height:35px; border-radius:3px;text-align: center;background-color: #009fe8;border: none; color:#fff; cursor:pointer;margin: 30px 0 30px 420px;}
 
 .zyh_th{background-color:#009fe8;
    color: #fff;
    line-height: 35px;
    font-size: 14px;}
   .zyh_wid{width:120px;}
  .zyh_wid1{width:19px;}
  .zyh_wid2{width:660px;}
 </style>
<script type="text/javascript">
function togetListBypage(page){
	var customername = $("#searchname").val();
	var demandId = $("#demandId").val();
	var url = "/demandsigned/demandBindResumeList.do?page="+page+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&demandId="+encodeURI(encodeURI($.trim(demandId)));
	window.location.href=url;
}
function tonextpageInfo(page){
	var customername = $("#searchname").val();
	var demandId = $("#demandId").val();
	var url = "/demandsigned/demandBindResumeList.do?page="+(page+1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&demandId="+encodeURI(encodeURI($.trim(demandId)));
	window.location.href=url;
}
function toprevpageInfo(page){
	var customername = $("#searchname").val();
	var demandId = $("#demandId").val();
	var url = "/demandsigned/demandBindResumeList.do?page="+(page-1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&demandId="+encodeURI(encodeURI($.trim(demandId)));
	window.location.href=url;
}
function topageInfo(){
	var topage = $("#topage").val();
	var customername = $("#searchname").val();
	var demandId = $("#demandId").val();
	var url = "/demandsigned/demandBindResumeList.do?page="+topage+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&demandId="+encodeURI(encodeURI($.trim(demandId)));
	window.location.href=url;
}
function search(){
	var customername = $("#searchname").val();
	var demandId = $("#demandId").val();
	var url = "/demandsigned/demandBindResumeList.do?customername="+encodeURI(encodeURI($.trim(customername)))+"&demandId="+encodeURI(encodeURI($.trim(demandId)));
	window.location.href=url;
}
</script>
 <body>
 <input type="hidden" id="demandId" value="${demandId}" /> 
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>提交简历列表</span></h2>
          <div class="whh_tab_bor">
				<div class="zyh_sosu">
                    <span>人员名称： </span> 
					<input type="text" id="searchname" value="${customername}"  class="zyh_txt" /> 
					<input type="button" class="zyh_btn" value="查询" onclick="search()">
				</div>
                <table cellpadding="0" cellspacing="0" border="0" class="whh_tab1" style="width:100%;">
                <thead>
                  <tr>
                     <th>姓名</th>
                     <th>电话</th>
                 </tr>
                </thead>
                <tbody>
                	<c:if test="${fn:length(list) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td>
					    </tr>
					</c:if>
                	<c:forEach items="${list }" var="cc">
	                  <tr>
	                   <td>${cc.CustomerName }</td>
	                   <td>${cc.CustomerTel}</td>
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