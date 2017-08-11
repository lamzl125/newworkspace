<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>学校行程记录管理</title>
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
	  initMemu(8,1);
	  $('.layer_tj').on('click', function(){
		  var trainSchoolId = $("#trainSchoolId").val();
		    layer.open({
		        type: 2,
		        title: '学校行程信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '326px'],
		        content: '/trainschool/toTripRecordAdd.do?trainSchoolId='+trainSchoolId
		    })
		})
  })
  
  function togetListBypage(page){
	  var tripWho = $("#tripWho").val();
	  var tripTime = $("#tripTime").val();
	  var tripAddr = $("#tripAddr").val();	
	  var trainSchoolId = $("#trainSchoolId").val();		
  	  var url = "/trainschool/toTrainSchoolList.do?page="+page;
  	if(tripWho!=null && tripWho!=""){
		  url += "&tripWho="+encodeURI(encodeURI($.trim(tripWho)));
	  }
	  if(tripTime!=null && tripTime!=""){
		  url += "&tripTime="+encodeURI(encodeURI($.trim(tripTime)));
	  }
	  if(tripAddr!=null && tripAddr!=""){
		  url += "&tripAddr="+encodeURI(encodeURI($.trim(tripAddr)));
	  }
	  if(trainSchoolId!=null && trainSchoolId!=""){
		  url += "&trainSchoolId="+encodeURI(encodeURI($.trim(trainSchoolId)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var tripWho = $("#tripWho").val();
	  var tripTime = $("#tripTime").val();
	  var tripAddr = $("#tripAddr").val();	
	  var trainSchoolId = $("#trainSchoolId").val();	
  	  var url = "/trainschool/toTripRecordList.do?page="+(page+1);
  	  if(tripWho!=null && tripWho!=""){
		  url += "&tripWho="+encodeURI(encodeURI($.trim(tripWho)));
	  }
	  if(tripTime!=null && tripTime!=""){
		  url += "&tripTime="+encodeURI(encodeURI($.trim(tripTime)));
	  }
	  if(tripAddr!=null && tripAddr!=""){
		  url += "&tripAddr="+encodeURI(encodeURI($.trim(tripAddr)));
	  }
	  if(trainSchoolId!=null && trainSchoolId!=""){
		  url += "&trainSchoolId="+encodeURI(encodeURI($.trim(trainSchoolId)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var tripWho = $("#tripWho").val();
	  var tripTime = $("#tripTime").val();
	  var tripAddr = $("#tripAddr").val();	
	  var trainSchoolId = $("#trainSchoolId").val();	
  	  var url = "/trainschool/toTripRecordList.do?page="+(page-1);
  	  if(tripWho!=null && tripWho!=""){
		  url += "&tripWho="+encodeURI(encodeURI($.trim(tripWho)));
	  }
	  if(tripTime!=null && tripTime!=""){
		  url += "&tripTime="+encodeURI(encodeURI($.trim(tripTime)));
	  }
	  if(tripAddr!=null && tripAddr!=""){
		  url += "&tripAddr="+encodeURI(encodeURI($.trim(tripAddr)));
	  }
	  if(trainSchoolId!=null && trainSchoolId!=""){
		  url += "&trainSchoolId="+encodeURI(encodeURI($.trim(trainSchoolId)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){
	  var tripWho = $("#tripWho").val();
	  var tripTime = $("#tripTime").val();
	  var tripAddr = $("#tripAddr").val();	
	  var trainSchoolId = $("#trainSchoolId").val();	
  	  var topage = $("#topage").val();
  	  var url = "/trainschool/toTripRecordList.do?page="+topage;
  	  if(tripWho!=null && tripWho!=""){
		  url += "&tripWho="+encodeURI(encodeURI($.trim(tripWho)));
	  }
	  if(tripTime!=null && tripTime!=""){
		  url += "&tripTime="+encodeURI(encodeURI($.trim(tripTime)));
	  }
	  if(tripAddr!=null && tripAddr!=""){
		  url += "&tripAddr="+encodeURI(encodeURI($.trim(tripAddr)));
	  }
	  if(trainSchoolId!=null && trainSchoolId!=""){
		  url += "&trainSchoolId="+encodeURI(encodeURI($.trim(trainSchoolId)));
	  }
  	  window.location.href=url;
  }
  

  function searchByCon(){
	  var tripWho = $("#tripWho").val();
	  var tripTime = $("#tripTime").val();
	  var tripAddr = $("#tripAddr").val();	
	  var trainSchoolId = $("#trainSchoolId").val();
	  var url = "/trainschool/toTripRecordList.do?trainSchoolId="+trainSchoolId;	  
	  if(tripWho!=null && tripWho!=""){
		  url += "&tripWho="+encodeURI(encodeURI($.trim(tripWho)));
	  }
	  if(tripTime!=null && tripTime!=""){
		  url += "&tripTime="+encodeURI(encodeURI($.trim(tripTime)));
	  }
	  if(tripAddr!=null && tripAddr!=""){
		  url += "&tripAddr="+encodeURI(encodeURI($.trim(tripAddr)));
	  }
  	  window.location.href=url;
  }
  function delInfo(tripRecordId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/trainschool/delTripRecordById.do",
		          data: {"tripRecordId":tripRecordId},
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
  function editInfo(tripRecordId){
	  var url = "/trainschool/toEditTripRecord.do?tripRecordId="+tripRecordId;
	  layer.open({
	        type: 2,
	        title: '学校行程信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '326px'],
	        content: url
	    })
  }
  function agentList(tripRecordId){
	  var url = "/agent/toAgentList.do?tripRecordId="+tripRecordId;	  
  	  window.location.href=url;
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
	     	<a href="" title="学校行程记录管理" class="current">学校行程记录管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>学校行程记录管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
            	<span>人员：<input type="text" class="zyh_txt whh_input"  id="tripWho"  value="${tripWhoName}"></span>
                <span>区域：<input type="text" class="zyh_cursor" id="tripTime" value="${tripTime}" placeholder="输入时间" onclick="WdatePicker()" readonly /></span>
                <span>地址：<input type="text" class="zyh_txt whh_input"  id="tripAddr"  value="${tripAddr}"></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>人员</th><th>时间</th><th>学校</th><th>地址</th><th>操作</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(recordlist) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有学校行程信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" items="${recordlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>${item.TripWhoName}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.TripTime}"/></td>
	                  	   <td>
	                  	   		<c:forEach items="${schoollist}" var="school">
	                  	   			<c:if test="${school.trainSchoolId eq item.TrainSchoolId}">${school.trainSchoolName}</c:if>
	                  	   		</c:forEach>
	                  	   </td>
	                  	   <td>${item.TripAddr}</td>
		                   <td style="width:160px;">
								<button type="button" class="btn btn-warning btn-mini" onclick="editInfo('${item.TripRecordId}')">修改</button>
								<button type="button" class="btn btn-mini btn-danger zyh_delete" onclick="delInfo('${item.TripRecordId}')">删除</button>
								<button type="button" onclick="agentList('${item.TripRecordId}')" class="btn btn-warning btn-mini" >代理人列表</button>
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