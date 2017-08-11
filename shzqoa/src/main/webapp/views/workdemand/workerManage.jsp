<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>普工管理</title>
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
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,4);
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '普工信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '650px'],
				content:'/worker/toWorkerAdd.do'
		    })
		})
  })
  function editInfo(workerId){
	  layer.open({
	        type: 2,
	        title: '普工信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '650px'],
	        content: '/worker/toEditWorker.do?workerId='+workerId
	    })
  }
  function tofollowAdd(workerId){
	  layer.open({
	        type: 2,
	        title: '普工信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '478px'],
	        content: '/workerfollow/tofollowAdd.do?followType=1&objectId='+workerId
	    })
	  
  }
  
  function followInfo(workerId){
	  layer.open({
	        type: 2,
	        title: '普工跟踪信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '510px'],
	        content: '/workerfollow/toWorkerFollowList.do?followType=1&objectId='+workerId
	    })
  }
  function searchByCon(){
	  var workerName = $("#workerName").val();
	  var workerPhone = $("#workerPhone").val();	  
	  var origin = $("#origin").val();
	  var idCard = $("#idCard").val();
	  var workerStatus = $("#workerStatus").val();
	  var url = "/worker/toWorkerList.do?page=1";
	  if(workerName!=null && workerName!=""){
		  url += "&workerName="+encodeURI(encodeURI($.trim(workerName)));
	  }
	  if(workerPhone!=null && workerPhone!=""){
		  url += "&workerPhone="+encodeURI(encodeURI($.trim(workerPhone)));
	  }
	  if(origin!=null && origin!=""){
		  url += "&origin="+encodeURI(encodeURI($.trim(origin)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(workerStatus!=null && workerStatus!=""){
		  url += "&workerStatus="+encodeURI(encodeURI($.trim(workerStatus)));
	  }
  	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var workerName = $("#workerName").val();
	  var workerPhone = $("#workerPhone").val();	  
	  var origin = $("#origin").val();
	  var idCard = $("#idCard").val();
	  var workerStatus = $("#workerStatus").val();
  	  var url = "/worker/toWorkerList.do?page="+page;
  	  if(workerName!=null && workerName!=""){
		  url += "&workerName="+encodeURI(encodeURI($.trim(workerName)));
	  }
	  if(workerPhone!=null && workerPhone!=""){
		  url += "&workerPhone="+encodeURI(encodeURI($.trim(workerPhone)));
	  }
	  if(origin!=null && origin!=""){
		  url += "&origin="+encodeURI(encodeURI($.trim(origin)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(workerStatus!=null && workerStatus!=""){
		  url += "&workerStatus="+encodeURI(encodeURI($.trim(workerStatus)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var workerName = $("#workerName").val();
	  var workerPhone = $("#workerPhone").val();	  
	  var origin = $("#origin").val();
	  var idCard = $("#idCard").val();
	  var workerStatus = $("#workerStatus").val();
  	  var url = "/worker/toWorkerList.do?page="+(page+1);
  	  if(workerName!=null && workerName!=""){
		  url += "&workerName="+encodeURI(encodeURI($.trim(workerName)));
	  }
	  if(workerPhone!=null && workerPhone!=""){
		  url += "&workerPhone="+encodeURI(encodeURI($.trim(workerPhone)));
	  }
	  if(origin!=null && origin!=""){
		  url += "&origin="+encodeURI(encodeURI($.trim(origin)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(workerStatus!=null && workerStatus!=""){
		  url += "&workerStatus="+encodeURI(encodeURI($.trim(workerStatus)));
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
	  var workerName = $("#workerName").val();
	  var workerPhone = $("#workerPhone").val();	  
	  var origin = $("#origin").val();
	  var idCard = $("#idCard").val();
	  var workerStatus = $("#workerStatus").val();
  	  var url = "/worker/toWorkerList.do?page="+(page-1);
  	  if(workerName!=null && workerName!=""){
		  url += "&workerName="+encodeURI(encodeURI($.trim(workerName)));
	  }
	  if(workerPhone!=null && workerPhone!=""){
		  url += "&workerPhone="+encodeURI(encodeURI($.trim(workerPhone)));
	  }
	  if(origin!=null && origin!=""){
		  url += "&origin="+encodeURI(encodeURI($.trim(origin)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(workerStatus!=null && workerStatus!=""){
		  url += "&workerStatus="+encodeURI(encodeURI($.trim(workerStatus)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){        
	  var workerName = $("#workerName").val();
	  var workerPhone = $("#workerPhone").val();	  
	  var origin = $("#origin").val();
	  var idCard = $("#idCard").val();
	  var workerStatus = $("#workerStatus").val();
  	  var topage = $("#topage").val();
  	  var url = "/worker/toWorkerList.do?page="+topage;
  	  if(workerName!=null && workerName!=""){
		  url += "&workerName="+encodeURI(encodeURI($.trim(workerName)));
	  }
	  if(workerPhone!=null && workerPhone!=""){
		  url += "&workerPhone="+encodeURI(encodeURI($.trim(workerPhone)));
	  }
	  if(origin!=null && origin!=""){
		  url += "&origin="+encodeURI(encodeURI($.trim(origin)));
	  }
	  if(idCard!=null && idCard!=""){
		  url += "&idCard="+encodeURI(encodeURI($.trim(idCard)));
	  }
	  if(workerStatus!=null && workerStatus!=""){
		  url += "&workerStatus="+encodeURI(encodeURI($.trim(workerStatus)));
	  }
  	  window.location.href=url;
  }
  

  
  function delInfo(workerId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/worker/delWorkerById.do",
		          data: {"workerId":workerId},
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
  
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="招聘管理" class="tip-bottom"><i class="icon-home"></i>招聘管理</a>
	     	<a href="" title="普工管理" class="current">普工管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>普工管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>姓名：<input type="text" class="zyh_txt whh_input"  id="workerName"  value="${workerName}"></span>
                <span>电话：<input type="text" class="zyh_txt whh_input"  id="workerPhone"  value="${workerPhone}"></span>
                <span>籍贯：<input type="text" class="zyh_txt whh_input"  id="origin"  value="${origin}"></span>
                <span>身份证：<input type="text" class="zyh_txt whh_input"  id="idCard"  value="${idCard}"></span>
                <span>状态：
                	<select id="workerStatus" class="whh_input">
                		<option value="" <c:if test="${workerStatus==null}">selected</c:if>>请选择</option>
                		<option value="1" <c:if test="${workerStatus==1}">selected</c:if>>登记</option>
                		<option value="2" <c:if test="${workerStatus==2}">selected</c:if>>面试不通过</option>
                		<option value="3" <c:if test="${workerStatus==3}">selected</c:if>>面试通过</option>
                		<option value="4" <c:if test="${workerStatus==4}">selected</c:if>>体检通过</option>
                		<option value="5" <c:if test="${workerStatus==5}">selected</c:if>>体检不通过</option>
                		<option value="6" <c:if test="${workerStatus==6}">selected</c:if>>入职</option>
                		<option value="7" <c:if test="${workerStatus==7}">selected</c:if>>反费</option>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <div style="width:100%;overflow:auto;">
            <table class="table table-bordered table-striped with-check" style="width:2000px;">
            	<colgroup>
                  <col style="width:1%;"><col style="width:5%;"><col style="width:3%;">
                  <col style="width:3%;"><col style="width:4%;"><col style="width:3%;">
                  <col style="width:3%;"><col style="width:5%;"><col style="width:3%;">
                  <col style="width:5%;"><col style="width:3%;"><col style="width:7%;">
                  <col style="width:5%;"><col style="width:3%;"><col style="width:3%;">
                  <col style="width:3%;"> <col style="width:6%;"><col style="width:5%;">
              </colgroup>
              <thead>
                <tr>
                  <th>#</th><th>时间</th><th>姓名</th>
                  <th>性别</th><th>电话</th><th>年龄</th>
                  <th>籍贯</th><th>身份证号</th><th>是否体检</th>
                  <th>预计反费时间</th><th>状态</th><th>反费金额</th>
                  <th>反费时间</th><th>是否结清</th><th>添加人</th>
                  <th>加入工厂</th><th>夜班要求</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(workerlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有普工需求信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${workerlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.registerTime}"/></td>
	                  	   <td>${item.workerName}</td>
	                  	   <td>${item.workerSex==1?'男':item.workerSex==2?'女':item.workerSex==3?'保密':''}</td>
	                  	   <td>${item.workerPhone}</td>
	                  	   <td>${item.age}</td><td>${item.origin}</td><td>${item.idCard}</td>
	                  	   <td>${item.physicalExamination==1?'是':item.workerSex==2?'否':''}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.estimateAntiFeeTime}"/></td>
		                   <td>${item.workerStatus == 1 ?'登记':item.workerStatus == 2 ?'面试不通过': item.workerStatus == 3?'面试通过':item.workerStatus == 4?'体检通过':item.workerStatus == 5?'体检不通过':item.workerStatus == 6?'入职':item.workerStatus == 7?'反费':''}</td>
		                   <td>${item.antiFeePay}</td>
		                   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.antiFeeTime}"/></td>
		                   <td>${item.isSettlement==1?'是':item.workerSex==2?'否':''}</td>
		                   <td>
	                  	   		<c:forEach var="useritem" items="${userlist}">
	                  	   			<c:if test="${useritem.usercode eq item.addPeople}">${useritem.realname}</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td>
	                  	   		<c:forEach var="workerdemand" items="${workerdemandlist}">
	                  	   			<c:if test="${workerdemand.WorkerId eq item.workerId}">${workerdemand.Name}</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td>${item.reMark1}</td>
		                   <td>
								<button type="button" class="btn btn-warning btn-mini" onclick="editInfo('${item.workerId}')">修改</button>
								<button type="button" class="btn btn-warning btn-mini" onclick="followInfo('${item.workerId}')">记录</button>
								<button type="button" class="btn btn-warning btn-mini" onclick="tofollowAdd('${item.workerId}')">跟踪</button>
								<%-- <button type="button" class="btn btn-mini btn-danger zyh_delete" onclick="delInfo('${item.workerId}')">删除</button> --%>
		                   </td>
		                   
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
            </div>
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