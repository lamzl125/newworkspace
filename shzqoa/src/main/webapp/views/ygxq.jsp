<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>员工详情信息</title>
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
	<link rel="stylesheet" href="/views/common/css/uploadify.css">
	<link rel="stylesheet" href="/views/common/css/combo.select.css">
	<link rel="stylesheet" href="/views/common/css/otherstyle.css">
 <script src="/views/common/js/jquery.min.js" ></script>
<!--   <script src="/views/common/js/media/jquery-1.7.2.min.js" type="text/javascript"></script> -->
<script src="/views/common/js/jquery.validate.js"></script>
		<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
		
		<script src="/views/common/js/bootstrap.min.js"></script> 
		<script src="/views/common/js/matrix.js"></script> 
		<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
		<script src="/views/common/js/jquery.uploadify.min.js"></script>
		<script src="/views/common/js/jquery.combo.select.js"></script>
		<script type="text/javascript" src="/views/common/js/media/jquery.media.js"></script>
  <style type="text/css">
  .rxclass{display:none;}
  .titleclass{
	color: #EE9A49;
	font-size:26px;
	padding-left:80px;
	text-decoration:underline;
}
  </style>
  <script type="text/javascript">
    $(function(){
    	 $('a.media').media({width:800, height:600});
      $("#btn_add").click(function(){
        $(".whh_tab_add").show();
      })
      initMemu(1,1);
    })
    function togetListBypage(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
    	var customercode = $("#customercode").val();
    	var topage = $("#topage").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+topage;
    	window.location.href=url;
    }
    function addContInf(){
    	var customercode = $("#customercode").val();
    	var currusercode = $("#curruserid").val();
    	var newcontmemo = $("#newcontmemo").val();
    	var newentprobability = $("#newentprobability").val();
    	var considerChangeJob = $("#considerChangeJob").val();    	
    	var intentionArea = $("#intentionArea").val();
    	
    	if(newentprobability==null || newentprobability == ""){
    		alert("请填写入职概率");
    		return false;
    	}else{
    		if(isNaN(newentprobability)){
    			alert("入职概率只能为数字");
    			return false;
    		}else{
    			if(newentprobability<0||newentprobability>100){
    				alert("入职概率只能为0-100之间的数字");
        			return false;
    			}
    		}
    	}
    	/* var newrelationshipbyzh = $("#newrelationshipbyzh").val(); */
    	var newrelationshipbyzq = $("#newrelationshipbyzq").val();
    	var updateStatus = $("#updateStatus").val();
    	
    	
    	var newjoinprojecttime = $("#newjoinprojecttime").val();
    	if(newrelationshipbyzq==6){
    		if(newjoinprojecttime==null || newjoinprojecttime==""){
    			alert("入职状态时入项时间不能为空");
    			return false;
    		}
    	}  
    	var newjoindemand = $("#newjoindemand").val();
    	var data = {
    			"customercode":customercode,"newcontmemo":newcontmemo,"newentprobability":newentprobability,
    			/* "newrelationshipbyzh":newrelationshipbyzh, */
    			"newrelationshipbyzq":newrelationshipbyzq,
    			"currusercode":currusercode,"updateStatus":updateStatus,
    			"joinprojecttime":newjoinprojecttime,"considerChangeJob":considerChangeJob,
    			"intentionArea":intentionArea,"joindemand":newjoindemand,
    			}
    	$.ajax({
			data : data,
			url : "/contactDate/addContactDate.do",
			type : "post",
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.rightmsg);
					parent.location.reload();
				} else if (result.status != 0) {
					alert(result.errormsg);
				}
			}
		});
    }
    function downloadfile(filename){
    	/* var url = "/readDocOnline/download.do?fileName="+filename;
    	window.open(url,'_blank'); */
    	/* $.ajax({
			data : {"fileName":filename},
			url : "/readDocOnline/showpdffilename.do",
			type : "post",
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.filename);
					$('.pdf1').media({
						  width: 450,
						  height: 350,
						  autoplay: true,
						  src: filename,
						});
				} else if (result.status != 0) {
					alert(result.errormsg);
				}
			}
		}); */
    	
    }
    $('a.media').media({width:1200,height:800});
    function addjoinproject(){
    	var newrelationshipbyzq = $("#newrelationshipbyzq").val();	
    	if(newrelationshipbyzq==6){
    		$(".whh_tab_show thead .rxclass").show();
    		$(".whh_tab_show tbody .rxclass").show();
    	}else{
    		$(".whh_tab_show thead .rxclass").hide();
    		$(".whh_tab_show tbody .rxclass").hide();
    	}
    }
  </script>
 </head>
 <body>
 <jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
 <input type="hidden" id="curruserid" value="${user.usercode}">
 <input type="hidden" id="customercode" value="${customerInfo.customercode}">
 <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="查询信息" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="员工详情信息" class="current">员工详情信息</a>
    </div>
  </div>

  <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>员工详情信息</h5>
            <button type="button" class="btn btn-mini btn-success btn_fr layer_tj" onClick="javascript:window.history.go(-1)">上一步</button>
          </div>
          <div class="widget-content clearfix">
          		 <form name="signupForm" method="post" id="signupForm" class="form-inline">
			       <div class="whh_content whh_content_border">
			          <div class="whh_tab_bor">
			          <ul class="whh_ul">
		                <li>姓名: <label>${customerInfo.customername}</label></li>
		                <li>性别:  
		                    	<label>
		                    		<c:choose>
								       <c:when test="${customerInfo.customersex == 0}">男</c:when>
								       <c:otherwise>女 </c:otherwise>
									</c:choose>
		                    	</label></li>
		                <li>区域:  
			                <label>
			                	<c:forEach items="${arealist}" var="info">
	                    			<c:if test="${info.areaid==customerInfo.areaid}">${info.areaname}</c:if>
	                            </c:forEach>
			                </label>
		                </li>
		                <li>技术方向:  
		                	<label>
		                		<c:forEach items="${professionlist}" var="info">
	                    			<c:if test="${info.id==customerInfo.professionId}">${info.name}</c:if>
	                            </c:forEach>
	                            <c:if test="${customerInfo.professionId==null || customerInfo.professionId eq ''}">无</c:if>
		                	</label>
		                </li>
		                <li>录入账号:  
		                	<label>
		                		<c:forEach items="${accountlist}" var="info">
	                    			<c:if test="${info.aid==customerInfo.account}">${info.account}</c:if>
	                            </c:forEach>
		                		
		                	</label>
		                </li>
		                <li>电话:  <label>${customerInfo.customertel}</label></li>
		                <li>出生日期:  <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerInfo.customerbirth}" /></label></li>
		                <li>毕业院校: <label>${customerInfo.customeruniversity}</label></li>
		                    <li>所学专业:  <label>${customerInfo.customerspecialities}</label></li>
		                    <%-- <li>入职时间:   <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerInfo.entrytime}" /></label></li> --%>
		                    <li>简历出处:  
		                    	<label>
		                    		<c:forEach items="${resumeSourceList}" var="info">
		                    			<c:if test="${info.resumesourceid==customerInfo.resumesource}">
		                    				${info.resumesourcename}
		                    			</c:if>
		                            </c:forEach>
		                    	</label>
		                    </li>
		                 	<li>简历ID:  <label style="font-size: 12px;">${customerInfo.resumeid}</label></li>
		                   <%--  <li>最近公司名称:  <label>${customerInfo.lastvcompanyname}</label></li>
		                    <li>最近项目名称:   <label>${customerInfo.lastprojectname}</label></li> 
		                    <li>技术特长: <label>${customerInfo.technicalexpertise}</label></li>--%>
		                 	<%-- <li>与郑州关系: 
		                 		<label>
		                 			<c:choose>
								       <c:when test="${customerInfo.relationshipbyzh == 1}">已离职</c:when>
								       <c:when test="${customerInfo.relationshipbyzh == 2}">在职</c:when>
								       <c:when test="${customerInfo.relationshipbyzh == 3}">提交简历未通过</c:when>
								       <c:when test="${customerInfo.relationshipbyzh == 4}">待入职</c:when>
								       <c:when test="${customerInfo.relationshipbyzh == 5}">无关系</c:when>
									</c:choose>
		                 		</label>
		                 	</li> 
		                    <li>与梓钦关系: 
		                    	<label>
		                    		<c:choose>
								       <c:when test="${customerInfo.relationshipbyzq == 1}">已离职</c:when>
								       <c:when test="${customerInfo.relationshipbyzq == 2}">在职</c:when>
								       <c:when test="${customerInfo.relationshipbyzq == 3}">提交简历未通过</c:when>
								       <c:when test="${customerInfo.relationshipbyzq == 4}">待入职</c:when>
								       <c:when test="${customerInfo.relationshipbyzq == 5}">无关系</c:when>
									</c:choose>
		                    	</label>
		                    </li>--%>
		                    <li>入职概率:  <label>${customerInfo.entryprobability}%</label></li>
		                    <%-- <li>本公司入职时间: <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerInfo.zqentrytime}" /></label></li> --%>
		                 	<li>学历: 
		                    	<label>
		                    		<c:forEach items="${educationlist}" var="info">
		                    			<c:if test="${info.id==customerInfo.education}">${info.name}</c:if>
		                            </c:forEach>
		                            
		                    	</label>
		                    </li>
		                    <li>英语水平: 
		                    	<label>
		                    		<c:forEach items="${enlevellist}" var="info">
		                    			<c:if test="${info.id==customerInfo.englishLevel}">${info.name}</c:if>
		                            </c:forEach>
		                   		</label>
		                    </li>
		                    <li>日语水平: 
		                    	<label>
		                    		<c:forEach items="${japlevellist}" var="info">
		                    			<c:if test="${info.id==customerInfo.japaneseLevel}">${info.name}</c:if>
		                            </c:forEach>
		                    	</label>
		                    </li>
		                    <li>技术方向工作年限: <label>${customerInfo.directWorkLife}</label></li>
		                 	<li>添加时间: <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerInfo.addtime}" /></label></li>
		                    <li>添加人员ID:  <label>${customerInfo.opertcode}</label></td>
		                    <li>添加人员姓名: <label>${customerInfo.opertname}</label></td>
		                    <li>简历更新时间: <label><fmt:formatDate pattern="yyyy/MM/dd" value="${customerInfo.resumeupdatedate}" /></label></li>
		                    
		                    
		               		<%-- <li>最近项目: <label>${customerInfo.lastprojectname}</label></td> --%>
		                 	<%-- <li style="width:100%;">
		                 		<a class="media" href="${pdffilename}" >简历路径:  <label>${customerInfo.resumepath}</label></a>
		                 		<input type="hidden" id="resumepath" value="${customerInfo.resumepath}">
		                 	</li> --%>
		              </ul>
		              
		              <c:if test="${fn:length(prolist) > 0}">
					  
		              <div class="titleclass">项目经验</div>
		              <div id="projy">
			              	<c:forEach items="${prolist}" var="proinfo">
			              		<div class="templatepro0" id="templatepro0">
				                 	<div class="temre">
				                 		<label>项目行业：</label>
				                 		<c:forEach items="${proindlist}" var="info">
				                 			<c:if test="${info.id==proinfo.industry}">${info.name}</c:if>
				                        </c:forEach>
					                 </div>
				                   	
					                 <div class="temre">
					                    <label>项目名称：</label>${proinfo.projectName}
				                 	</div>
				                 	<div class="temre">
				                 		<label class="lableclass">角色：</label>
				                          <c:forEach items="${prorolelist}" var="info">
				                           		<c:if test="${info.id==proinfo.role}">${info.name}</c:if>
				                          </c:forEach>
				                     </div>
				                     <div class="temre">
				                 		<label>项目开始日期：</label><fmt:formatDate pattern="yyyy/MM/dd" value="${proinfo.joinProjectTime}" />
				                 	</div>
				                 	<div class="temre">	
				                 		<label>项目结束日期：</label><fmt:formatDate pattern="yyyy/MM/dd" value="${proinfo.quitProjectTime}" />
				                 	</div>
				                 	<div class="alltemre">
				                 		<label>软件环境：</label>
				                 		<c:set value="${fn:split(proinfo.softwareEnvironment, ',') }" var="softenvarr" />
				                 		<c:forEach items="${softenvlist}" var="info">
			                   				<input type="checkbox" name="softwareEnvironment" <c:forEach items="${softenvarr}" var="s"><c:if test="${s==info.id}">checked</c:if></c:forEach> value="${info.id}" />${info.name}
				                   		</c:forEach>
				                   	</div>
				                   	
				                   	<div class="alltemre">
				                   		<label>项目介绍：</label>${proinfo.projectIntroduction}
				                 	</div>
				                 	<div class="alltemre">	
				                 		<label>技术类型：</label>
				                 		<c:set value="${fn:split(proinfo.technologyType, ',') }" var="tectypearr" />
				                 		<c:forEach items="${tectypelist}" var="info">
			                   				<input type="checkbox" name="technologyType" <c:forEach items="${tectypearr}" var="s"><c:if test="${s==info.id}">checked</c:if></c:forEach> value="${info.id}" />${info.name}
				                   		</c:forEach>
				                   	</div>	
				                   	<div class="alltemre">	
				                   		<label>职责：</label>${proinfo.duty}
				                 	</div>
				                 </div>
			              	</c:forEach>
			                 </div>
		              	</c:if>
			              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="table table-bordered table-striped with-check">
			              		<colgroup>
					                  <col style="width:7%;"><col style="width:5%;"><col style="width:15%;">
					                  <col style="width:4%;"><col style="width:5%;"><col style="width:5%;">
					                  <col style="width:6%;"><col style="width:5%;"><col style="width:5%;">
					              </colgroup>
			              		<thead>
				                  <tr>
				                     <th>时间</th><th>跟踪人姓名</th><th>最新跟踪情况</th><th>入职概率</th>
				                    <!--  <th>郑州的关系</th> -->
				                     <th>梓钦的关系</th><th>是否考虑换工作</th><th>意向地址</th><th>更新状态</th>
				                 </tr>
				                </thead>
			                <tbody>
				                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
				                	<tr>
					                   <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${item.contacttime}" /></td>
					                   <td>${item.contactusercode}</td>
					                   <td width="30%">${item.memo}</td>
					                   <td>${item.entryprobability}%</td>
					                   <%-- <td>
					                   		<c:choose>
										       <c:when test="${customerInfo.relationshipbyzh == 1}">已离职</c:when>
										       <c:when test="${customerInfo.relationshipbyzh == 2}">在职</c:when>
										       <c:when test="${customerInfo.relationshipbyzh == 3}">提交简历未通过</c:when>
										       <c:when test="${customerInfo.relationshipbyzh == 4}">待入职</c:when>
										       <c:when test="${customerInfo.relationshipbyzh == 5}">无关系</c:when>
										       <c:when test="${customerInfo.relationshipbyzh == 6}">入职</c:when>
											</c:choose>
					                   		
					                   </td> --%>
					                   <td>
					                   		<c:choose>
										       <c:when test="${customerInfo.relationshipbyzq == 1}">已离职</c:when>
										       <c:when test="${customerInfo.relationshipbyzq == 2}">在职</c:when>
										       <c:when test="${customerInfo.relationshipbyzq == 3}">提交简历未通过</c:when>
										       <c:when test="${customerInfo.relationshipbyzq == 4}">待入职</c:when>
										       <c:when test="${customerInfo.relationshipbyzq == 5}">无关系</c:when>
										       <c:when test="${customerInfo.relationshipbyzq == 6}">入职</c:when>
											</c:choose>
					                   </td>
					                   <td>
					                   		<c:choose>
										       <c:when test="${item.considerChangeJob == 1}">考虑</c:when>
										       <c:when test="${item.considerChangeJob == 2}">不考虑</c:when>
											</c:choose>
					                   
					                   </td>
					                   <td><c:if test="${item.intentionArea == null || item.intentionArea eq ''}">无</c:if>
					                   		<c:forEach items="${arealist }" var="areainfo">
					                   			<c:if test="${item.intentionArea eq  areainfo.areaid}">${areainfo.areaname}</c:if>
											</c:forEach>	                   
					                   </td>
					                   <td class="zyh_icon">
					                   		<c:choose>
										       <c:when test="${item.updatestatic == 1}"><img  src="/views/resource/css/img/icon_1.png"></c:when>
										       <c:when test="${item.updatestatic == 2}"><img  src="/views/resource/css/img/icon_2.png"></c:when>
										       <c:when test="${item.updatestatic == 3}"><img  src="/views/resource/css/img/icon_3.png"></c:when>
										       <c:when test="${item.updatestatic == 4}"><img  src="/views/resource/css/img/icon_4.png"></c:when>
										       <c:when test="${item.updatestatic == 5}"><img  src="/views/resource/css/img/icon_5.png"></c:when>
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
				            <p style="text-align: center;margin-top:50px;">
			               	<a href="javascript:void(0)" class="btn btn-mini btn-info" id="btn_add">更新</a></p>
			               	
			               	
			               	<div class="whh_tab_add">
				              <table cellpadding="0" cellspacing="0" border="0"  width="100%" class="table table-bordered table-striped with-check whh_tab_show">
				                  <colgroup>
					                  <col style="width:30%;"><col style="width:8%;"><col style="width:5%;">
					                  <col style="width:5%;"><col style="width:5%;"><col style="width:5%;">
					                  <col style="width:5%;"><col style="width:5%;">
					              </colgroup>
				                  <thead>
					                  	<tr>
					                      	<!-- <th>时间</th>
					  						<th>跟踪人</th> -->
					  						<th>最新跟踪情况</th>
					  						<th>入职概率</th>
					  						<!-- <th>郑州的关系</th> -->
					  						<th>梓钦的关系</th>
					  						<th>更新状态</th>
					  						<th>是否考虑换工作</th>
					  						<th>意向地址</th>
					  						<th class="rxclass">入项时间</th>
					  						<th class="rxclass">需求</th>
					  					</tr>
				                  </thead>
				                  <tbody>
				                    <tr>
				                     <%-- <td><fmt:formatDate value="<%=new Date() %>" pattern="yyyy/MM/dd HH:mm:ss" /></td>
				                     <td>${user.realname}</td> --%>
				                     <td><input type="text" id="newcontmemo" class="whh_input3" /></td>
				                     <td><input type="text" id="newentprobability" class="whh_input2" />%</td>
				                    <!--  <td>
				                     	<select id="newrelationshipbyzh">
					                          <option value=5>无关系</option>
					                          <option value=1>已离职</option>
					                          <option value=2>在职</option>
					                          <option value=3>提交简历未通过</option>
					                          <option value=4>待入职</option>
					                          <option value=6>入职</option>
					                    </select>
					                    
				                     </td> -->
				                     <td>
				                    	<select id="newrelationshipbyzq" onchange="addjoinproject()">
					                          <option value=5>无关系</option>
					                          <option value=1>已离职</option>
					                          <option value=2>在职</option>
					                          <option value=3>提交简历未通过</option>
					                          <option value=4>待入职</option>
					                          <option value=6>入职</option>
					                    </select>
				                     </td>
				                     
				                     <td>
				                    	<select id="updateStatus">
					                          <option value="1">电话错误</option>
					                          <option value="2">不接电话</option>
					                          <option value="3">挂断电话</option>
					                          <option value="4">不接受外包</option>
					                          <option value="5">其他</option>
					                    </select>
				                     </td>
				                     <td>
				                    	<select id="considerChangeJob">
					                          <option value="1">考虑</option>
					                          <option value="2">不考虑</option>
					                    </select>
				                     </td>
				                     <td>
				                     	<select id="intentionArea">
					                          <option value="">无</option>
					                          <c:forEach items="${arealist }" var="areainfo">
					                          		<option value="${areainfo.areaid}">${areainfo.areaname}</option>
											  </c:forEach>
					                    </select>
				                     </td>
				                     <td  class="rxclass"><input type="text" id="newjoinprojecttime" class="rxclass" onclick="WdatePicker()" readonly /></td>
				                     <td  class="rxclass">
				                     	<select id="newjoindemand">
					                          <option value="">无</option>
					                          <c:forEach items="${delist}" var="info">
					                          		<option value="${info.Id}">${info.Projecttype}</option>
											  </c:forEach>
					                    </select>
				                     </td>
				                   </tr>
				                  </tbody>
				                </table>
				                <p style="text-align: center;"><a href="javascript:void(0)" class="btn btn-mini btn-info" onclick="addContInf()">保存</a></p>
			              </div>
			              
			              
			               
			              <div class="zyh_zhushi">
			              <h5>注释：</h5>
			              <p>
				              1.电话错误<img src="/views/resource/css/img/icon_1.png">
				              2.不接电话<img src="/views/resource/css/img/icon_2.png">
				              3.挂断电话<img src="/views/resource/css/img/icon_3.png">
				              4.不接受外包<img src="/views/resource/css/img/icon_4.png">
				              5.其他<img src="/views/resource/css/img/icon_5.png">
			              </p>
			              </div>
			          </div>
			       </div>
			   </form>
          </div>
        </div>
  </div>
</div>
 
 </body>
</html>