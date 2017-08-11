<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>普工跟踪列表</title>
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
	.container-fluid {padding-right: 0px; padding-left: 0px;}
	.widget-box { margin-top: 0; margin-bottom: 0;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,3);
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '普工项目信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '650px'],
				content:'/workdemand/toWorkDemandAdd.do'
		    })
		})
  })
  function editInfo(demandId){
	  layer.open({
	        type: 2,
	        title: '普工项目信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '650px'],
	        content: '/workdemand/toEditWorkDemand.do?demandId='+demandId
	    })
  }
  function searchByCon(){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
	  var url = "/workdemand/toWorkDemandList.do?page=1";
	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+page;
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+(page+1);
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+(page-1);
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var topage = $("#topage").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+topage;
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  

  
  function delInfo(demandId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/workdemand/delWorkDemandById.do",
		          data: {"demandId":demandId},
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
  function workerlist(demandId){
	  layer.open({
	        type: 2,
	        title: '普工人员列表信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['946px' , '650px'],
			content:'/workdemand/demandWorkerList.do?demandId='+demandId
	    })
  }
  
  </script>
  
 </head>
 <body style="background-color:#fff;">
<div>
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>跟踪人</th><th>跟踪时间</th><th>普工</th><th>普工状态</th><th>跟踪情况</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(workerfollowlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有普工跟踪信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${workerfollowlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>
	                  	   		<c:forEach var="useritem" items="${userlist}">
	                  	   			<c:if test="${useritem.usercode eq item.addPeople}">${useritem.realname}</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td><fmt:formatDate value="${item.followTime}" pattern="yyyy-MM-dd"/></td>
	                  	   
	                  	   <td>${worker.workerName}</td>
	                  	   <td>${item.objectStatus == 1 ?'登记':item.objectStatus == 2 ?'面试不通过':item.objectStatus == 3 ?'面试通过':item.objectStatus == 4 ?'体检通过':item.objectStatus == 5 ?'体检不通过':item.objectStatus == 6 ?'入职':item.objectStatus == 7 ?'反费':''}</td>
	                  	   <td>${item.content}</td>
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