<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求列表</title>
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
 $(document).ready(function(){
	  initMemu(1,3);
 })
 function search(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var ocode=$("#ocode").find("option:selected").val();
	 var url =  "/customerDemand/toCustDemandList.do?customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
 }
 
 function topageInfo(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var topage = $("#topage").val();
	 var url = "/customerDemand/toCustDemandList.do?page="+topage+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+(page-1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+page+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();;
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+(page+1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function deletedemand(did){
	 if(confirm("确定要删除么?")){
		 $.ajax({
			 data: {"Id":did,},
	         type: "post",
	         url: "/customerDemand/deleteCusdemand.do",
	         dataType: "json",
	         success: function(result){
	        	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	         }
	     });
	 }
 }
 function editdemand(did){
	 window.location="/customerDemand/editCustomerDemand.do?custDemandId="+did+"&coper=1";
 }
 function closedemand(did){
	 if(confirm("确定要关闭需求吗?")){
		 $.ajax({
			 data: {"demandid":did,},
	        type: "post",
	        url: "/customerDemand/closeDemand.do",
	        dataType: "json",
	        success: function(result){
	       	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	        }
	    }); 
	 }
}
 function opendemand(did){
	 if(confirm("确定要恢复需求吗?")){
		 $.ajax({
			 data: {"demandid":did,},
	        type: "post",
	        url: "/customerDemand/openDemand.do",
	        dataType: "json",
	        success: function(result){
	       	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	        }
	    }); 
	 }
}
 </script>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <input type="hidden" value="${currpage }" id="currpage" />
  <input type="hidden" value="${fn:length(cp) }" id="cp" />
  
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="需求列表" class="current">需求列表</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求列表</h5>
          </div>
          <div class="widget-content clearfix">
          <!--查询条件-begin-->
            <div class="zyh_sosu">
					<span> 客户： </span>
					<select id="cusname" class="whh_sel" style="width:150px;">
                          <option value="">请选择</option>
                         <c:forEach items="${corporList }" var="info">
							<option value="${info.corpCode }" <c:if test="${info.corpCode eq  customername}">  selected="selected" </c:if>>${info.corpName }</option>
						 </c:forEach>
                       </select>
					<span> 技术方向： </span>
                       <select id="technologydirection" class="whh_sel" style="width:120px;">
                          <option value="">请选择</option>
                         <c:forEach items="${profession }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  technologydirection}">  selected="selected" </c:if>>${info.name }</option>
						 </c:forEach>
                       </select>
                    <span>项目地点： </span> 
					<select class="zyh_sel zyh_k_heigth whh_sel" id="projectlocation" style="width:120px;">
						<option value="">请选择</option>
                          <c:forEach items="${arealist }" var="info">
							<option value="${info.areaid }" <c:if test="${info.areaid eq  projectlocation}">  selected="selected" </c:if>>${info.areaname }</option>
						 </c:forEach>
					</select>
					<span> 技术级别： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="demandyears" style="width:120px;">
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
            <!--查询条件-end-->
          
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
            		<col width="5%;"><col width="4%;"><col width="4%;">
            		<col width="4%;"><col width="3%;"><col width="5%;">
            		<col width="25%;"><col width="5%;"><col width="5%;">
            		<col width="5%;"><col width="3%;"><col width="3%;">
            		<col width="5%;">
            	</colgroup>
              <thead>
                <tr>
                  	 <!-- <th>需求Id</th> -->
                     <th>客户公司</th><th>方向</th><th>地点</th>
                     <th>级别</th><th>学历</th><th>需求名称</th>
                     <th>具体内容</th><th>备注</th><th>行业</th>
                     <th>技术要求</th><th>年限</th><th>录入人</th>
                     <th>操作</th>
                 </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(custList) == 0}">
						<tr><td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td></tr>
					</c:if>
                <c:forEach items="${custList }" var="cc">
	                  <tr>
	                   <%-- <td style="word-wrap:break-word;">${cc.id }</td> --%>
	                   <td>${cc.corpname }</td>
	                   <td>${cc.name }</td>
	                   <td>${cc.areaname }</td>
	                   <td>${cc.gradename }</td>
	                   <td>${cc.education }</td>
	                   <td>${cc.projecttype }</td>
	                   <td>${cc.specificrequirement }</td>
	                   <td>${cc.remarks }</td>
	                   <td>
	                   		<c:forEach items="${proindlist}" var="info" >
								<c:if test="${cc.industry eq info.id}">${info.name} </c:if>
					    	</c:forEach>
	                   </td>
	                   <td>
	                   		<c:set value="${fn:split(cc.technicalRequirement, ',') }" var="tecreqarr" />
	                 		<c:forEach items="${tecreqarr}" var="s">
	                 			<c:forEach items="${tectypelist}" var="info">
	                 				<c:if test="${s eq info.id}">${info.name}</c:if>
	                 			</c:forEach>
	                   		</c:forEach>
	                   </td>
	                   <td>${cc.directWorkLife }</td>
	                   <td>
	                   		<c:forEach items="${userlist}" var="user" >
								<c:if test="${cc.operationuser==user.usercode}">${user.realname} </c:if>
					    	</c:forEach>
	                   </td>
	                   <td>
	                   		<div class="dropdown">
		                   			<a href="#" class="dropdown-toggle" data-toggle="dropdown">更多<b class="caret"></b></a>
									<ul class="dropdown-menu">
											<li><a class="editButClass" href="javascript:void(0);" onclick="editdemand('${cc.id}')">修改</a></li>
											<li class="divider"></li>
				                   			<li><a class="delButClass" href="javascript:void(0);" onclick="deletedemand('${cc.id}')">删除</a></li>
											<c:if test="${cc.state==0}">
												<li class="divider"></li>
						                   		<li><a class="delButClass" href="javascript:void(0);" onclick="closedemand('${cc.id}')">关闭</a></li>
						                   </c:if>
						                   <c:if test="${cc.state==1}">
						                   		<li class="divider"></li>
						                   		<li><a class="editButClass" href="javascript:void(0);" onclick="opendemand('${cc.id}')">恢复</a></li>
						                   </c:if>
									</ul>
								</div>
	                   </td>
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