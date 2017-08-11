<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求简历列表</title>
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
<script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script> 
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
 </head>
  <style>
 .zyh_sosu{ margin-bottom:10px;}
 </style>
 <script type="text/javascript">
 $(document).ready(function(){
	  initMemu(1,6);
 })
 function search(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/demanresume/demandResumeList1.do?customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
 }
 function topageInfo(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/demanresume/demandResumeList1.do?customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/demanresume/demandResumeList1.do?page="+(pag-1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/demanresume/demandResumeList1.do?page="+page+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/demanresume/demandResumeList1.do?page="+(page+1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
	}
 
 
 </script>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="需求简历列表" class="current">需求简历列表</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求简历列表</h5>
          </div>
          <div class="widget-content clearfix">
          		<div class="zyh_sosu">
					<span> 客户： </span>
					<c:if test="${managerflag==1}">
						<select id="cusname" class="whh_sel" style="width:150px;">
                          <option value="">请选择</option>
                         <c:forEach items="${corporList }" var="info">
							<option value="${info.corpCode }" <c:if test="${info.corpCode eq  customername}">  selected="selected" </c:if>>${info.corpName }</option>
						 </c:forEach>
                       </select>
					</c:if>
					<c:if test="${managerflag!=1}">
						<select id="cusname" class="whh_sel" style="width:150px;">
                          <option value="">请选择</option>
                         <c:forEach items="${corporList }" var="info">
							<option value="${info.corpCode }" <c:if test="${info.corpCode eq  customername}">  selected="selected" </c:if>>${info.corpCode }</option>
						 </c:forEach>
                       </select>
					</c:if>
					<span> 技术方向： </span>
                       <select id="technologydirection" class="whh_sel" style="width:120px;">
                          <option value="">请选择</option>
                         <c:forEach items="${profession }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  technologydirection}">  selected="selected" </c:if>>${info.name }</option>
						 </c:forEach>
                       </select>
                    <span>项目地点： </span> 
					<select class="zyh_sel zyh_k_heigth whh_sel" id="projectlocation" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${arealist }" var="info">
							<option value="${info.areaid }" <c:if test="${info.areaid eq  projectlocation}">  selected="selected" </c:if>>${info.areaname }</option>
						 </c:forEach>
					</select>
					<span> 技术级别： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="demandyears" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${grade }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  demandyears}">  selected="selected" </c:if>>${info.gradename }</option>
						 </c:forEach>
					</select>
					<span>录入人员： </span>
					<select class="zyh_sel" id="ocode"
						name="ocode">
						<option value="">请选择人员</option>
						<c:forEach items="${userlist}" var="info">
							<c:choose>
							<c:when test="${info.usercode eq  ocode}">
								<option value="${info.usercode}" selected="selected">${info.realname}</option>								
							</c:when>
							<c:otherwise>
								<option value="${info.usercode}">${info.realname}</option>								
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<!-- <input type="button" id="realname" /> -->
					<%-- <select class="zyh_sel zyh_k_heigth whh_sel" id="operuser" style="width:65px;">
						 <option value="">请选择</option>
                          <c:forEach items="${grade }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  demandyears}">  selected="selected" </c:if>>${info.gradename }</option>
						 </c:forEach> 
					</select> --%>
					<input type="button" class="zyh_btn" value="查询" onclick="search()">
				</div>  
            <table class="table table-bordered table-striped with-check">
            <colgroup>
            		<col width="10%" /><col width="10%" /><col width="10%" /><col width="10%" /><col width="40%" /><col width="10%" /><col width="10%" />
            	</colgroup>
              <thead>
                <tr><th>姓名</th><th>性别</th><th>出生日期</th><th>电话</th><th>技术特长</th><th>录入人</th><th>操作</th></tr>
              </thead>
              <tbody>
	              	<c:if test="${fn:length(list2) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有需求简历信息</td>
					    </tr>
					</c:if>
	                <c:forEach items="${list2 }" var="demand" varStatus="status">
		                  <tr>
			                   <td>${demand.customername }</td>
			                   <td><c:if test="${demand.customersex==0 }">男</c:if>
			                   <c:if test="${demand.customersex==1 }">女</c:if></td>
			                   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${demand.customerbirth }" /></td>
			                   <td>${demand.customertel }</td>
			                   <td width="260">${demand.technicalexpertise }</td>
			                   <td width="80">${demand.opertname }</td>
			                    <td>
				                   <a class="editButClass" href="/demanresume/demandDetail.do?customercode=${demand.customercode}">详情</a>&nbsp;&nbsp;
		                   </tr>
                   	</c:forEach>    
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
                <c:if test="${tatalpage>=currpage}">
                	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                </c:if>
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