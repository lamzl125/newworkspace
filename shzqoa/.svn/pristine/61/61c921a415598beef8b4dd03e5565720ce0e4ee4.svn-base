<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>代理人管理</title>
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
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  
  <script src="/views/common/js/jquery.validate.js"></script>
  <style type="text/css" rel="stylesheet">
	.whh_input{width:100px;}
	.fixedtable{
		TABLE-LAYOUT:fixed;
	}
	.fixedtable th{
		word-break:break-all; word-wrap:break-word;
	}
	.fixedtable td{
		word-break:break-all; word-wrap:break-word;
	}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,2);
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '代理人信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '650px'],
		        content: '/agent/toAgentAdd.do'
		    })
		})
  })
  
  function togetListBypage(page){
	  var agentName = $("#agentName").val();
	  var contype = $("#contype").val();
	  var idCard = $("#idCard").val();	
	  var contractCode = $("#contractCode").val();	
  	  var url = "/agent/toAgentList.do?page="+page;
  	  if(agentName!=null && agentName!=""){
		  url += "&agentName="+encodeURI(encodeURI($.trim(agentName)));
	  }
	  if(contype!=null && contype!=""){
		  url += "&mobile="+encodeURI(encodeURI($.trim(contype)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(contractCode!=null && contractCode!=""){
		  url += "&contractCode="+encodeURI(encodeURI($.trim(contractCode)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var agentName = $("#agentName").val();
	  var contype = $("#contype").val();
	  var idCard = $("#idCard").val();	
	  var contractCode = $("#contractCode").val();
  	  var url = "/agent/toAgentList.do?page="+(page+1);
  	  if(agentName!=null && agentName!=""){
		  url += "&agentName="+encodeURI(encodeURI($.trim(agentName)));
	  }
	  if(contype!=null && contype!=""){
		  url += "&mobile="+encodeURI(encodeURI($.trim(contype)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(contractCode!=null && contractCode!=""){
		  url += "&contractCode="+encodeURI(encodeURI($.trim(contractCode)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var agentName = $("#agentName").val();
	  var contype = $("#contype").val();
	  var idCard = $("#idCard").val();	
	  var contractCode = $("#contractCode").val();
  	  var url = "/agent/toAgentList.do?page="+(page-1);
  	  if(agentName!=null && agentName!=""){
		  url += "&agentName="+encodeURI(encodeURI($.trim(agentName)));
	  }
	  if(contype!=null && contype!=""){
		  url += "&mobile="+encodeURI(encodeURI($.trim(contype)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(contractCode!=null && contractCode!=""){
		  url += "&contractCode="+encodeURI(encodeURI($.trim(contractCode)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){
	  var agentName = $("#agentName").val();
	  var contype = $("#contype").val();
	  var idCard = $("#idCard").val();	
	  var contractCode = $("#contractCode").val();
  	  var topage = $("#topage").val();
  	  var url = "/agent/toAgentList.do?page="+topage;
  	  if(agentName!=null && agentName!=""){
		  url += "&agentName="+encodeURI(encodeURI($.trim(agentName)));
	  }
	  if(contype!=null && contype!=""){
		  url += "&mobile="+encodeURI(encodeURI($.trim(contype)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(contractCode!=null && contractCode!=""){
		  url += "&contractCode="+encodeURI(encodeURI($.trim(contractCode)));
	  }
  	  window.location.href=url;
  }
  

  function searchByCon(){
	  var agentName = $("#agentName").val();
	  var contype = $("#contype").val();
	  var idCard = $("#idCard").val();	
	  var contractCode = $("#contractCode").val();
	  var url = "/agent/toAgentList.do?page=1";	  
	  if(agentName!=null && agentName!=""){
		  url += "&agentName="+encodeURI(encodeURI($.trim(agentName)));
	  }
	  if(contype!=null && contype!=""){
		  url += "&mobile="+encodeURI(encodeURI($.trim(contype)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(contractCode!=null && contractCode!=""){
		  url += "&contractCode="+encodeURI(encodeURI($.trim(contractCode)));
	  }
  	  window.location.href=url;
  }
  function delInfo(agentId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/agent/delAgentById.do",
		          data: {"agentId":agentId},
		          dataType: "json",
		          success: function(result){
		         	 if(result.success == true){
		         		 alert(result.resultMessage);
		         		 parent.location.reload();
		         	 }else{
		         		 alert(result.resultMessage);
		         	 }
		          }
		      });
		}
  }
  function editInfo(agentId){
	  var url = "/agent/toEditAgent.do?agentId="+agentId;
	  layer.open({
	        type: 2,
	        title: '代理人信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '650px'],
	        content: url
	    })
  }
  </script>
  
 </head>
 <body>
 <input type="hidden" id="trainSchoolId"  value="${map.trainSchoolId}">
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="招聘管理" class="tip-bottom"><i class="icon-home"></i>招聘管理</a>
	     	<a href="" title="代理人管理" class="current">代理人管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>代理人管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
            	<span>姓名：<input type="text" class="zyh_txt whh_input"  id="agentName"  value="${agentName}"></span>
                <span>联系方式：<input type="text" class="zyh_txt whh_input"  id="contype"  value="${mobile}"></span>
                <span>身份证：<input type="text" class="zyh_txt whh_input"  id="idCard"  value="${idCard}"></span>
                <span>合同：<input type="text" class="zyh_txt whh_input"  id="contractCode"  value="${contractCode}"></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check fixedtable">
              <thead>
                <tr>
                  <th style="width:30px;">姓名</th>
                  <th style="width:24px;">性别</th>
                  <th>地址</th>
                  <th>联系方式</th>
                  <th style="width:60px;">身份证</th>
                  <th style="width:64px;">合同编号</th>
                  <th style="width:64px;">开始时间</th>
                  <th style="width:64px;">结束时间</th>
                  <th style="width:40px;">招聘人</th>
                  <th style="width:64px;">招聘时间</th>
                  <th style="width:50px;">招聘学校</th>
                  <th style="width:70px;">操作</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(agentlist) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有代理人信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" items="${agentlist}" varStatus="status">
	                  <tr>
	                  	   <td>${item.AgentName}</td><td>${item.AgentSex==1?'男':item.AgentSex==2?'女':''}</td>
	                  	   <td>${item.AgentAddr}</td>
	                  	   <td style="width:120px;">手机：${item.Mobile}&nbsp;&nbsp;Tel:${item.OfficeTel}&nbsp;&nbsp;QQ:${item.QQ}&nbsp;&nbsp;微信:${item.WeiXin}</td>
	                  	   <td>${item.IdCard}</td><td>${item.ContractCode}</td>	                  	   
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.StartTime}"/></td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.EndTime}"/></td>
		                   <td>
		                   		<c:forEach var="record" items="${recordlist}">
		                   			<c:if test="${record.TripRecordId eq item.TripRecordId}">${record.TripWhoName}</c:if>
		                   		</c:forEach>
		                   </td>
		                   <td>
		                   		<c:forEach var="record" items="${recordlist}">
		                   			<c:if test="${record.TripRecordId eq item.TripRecordId}">
		                   				<fmt:formatDate pattern="yyyy-MM-dd" value="${record.TripTime}"/>
		                   			</c:if>
		                   		</c:forEach>
		                   </td>
		                   <td>
		                   		<c:forEach var="record" items="${recordlist}">
		                   			<c:if test="${record.TripRecordId eq item.TripRecordId}">
		                   				<c:forEach var="school" items="${schoollist}">
		                   					<c:if test="${record.TrainSchoolId eq school.trainSchoolId}">
		                   						${school.trainSchoolName}
		                   					</c:if>
		                   				</c:forEach>
		                   			</c:if>
		                   		</c:forEach>
		                   </td>
		                   
		                   <td>
								<button type="button" class="btn btn-warning btn-mini" onclick="editInfo('${item.AgentId}')">修改</button>
								<button type="button" class="btn btn-mini btn-danger zyh_delete" onclick="delInfo('${item.AgentId}')">删除</button>
		                   </td>
		                   
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
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