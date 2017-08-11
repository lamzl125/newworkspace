<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>学校管理</title>
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
	  initMemu(8,0);
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '学校信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '430px'],
		        content: '/trainschool/toTrainSchoolAdd.do'
		    })
		})
  })
  
  function togetListBypage(page){
	  var trainSchoolLevel = $("#trainSchoolLevel").val();
	  var trainSchoolZone = $("#trainSchoolZone").val();	  
	  var trainSchoolName = $("#trainSchoolName").val();
	  var trainSchoolAddr = $("#trainSchoolAddr").val();
	  var trainSchoolURL = $("#trainSchoolURL").val();
	  var trainSchoolStatus = $("#trainSchoolStatus").val();	
  	var url = "/trainschool/toTrainSchoolList.do?page="+page;
  	if(trainSchoolLevel!=null && trainSchoolLevel!=""){
		  url += "&trainSchoolLevel="+encodeURI(encodeURI($.trim(trainSchoolLevel)));
	  }
	  if(trainSchoolZone!=null && trainSchoolZone!=""){
		  url += "&trainSchoolZone="+encodeURI(encodeURI($.trim(trainSchoolZone)));
	  }
	  if(trainSchoolName!=null && trainSchoolName!=""){
		  url += "&trainSchoolName="+encodeURI(encodeURI($.trim(trainSchoolName)));
	  }
	  if(trainSchoolAddr!=null && trainSchoolAddr!=""){
		  url += "&trainSchoolAddr="+encodeURI(encodeURI($.trim(trainSchoolAddr)));
	  }
	  if(trainSchoolURL!=null && trainSchoolURL!=""){
		  url += "&trainSchoolURL="+encodeURI(encodeURI($.trim(trainSchoolURL)));
	  }
	  if(trainSchoolStatus!=null && trainSchoolStatus!=""){
		  url += "&trainSchoolStatus="+encodeURI(encodeURI($.trim(trainSchoolStatus)));
	  }
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var trainSchoolLevel = $("#trainSchoolLevel").val();
	  var trainSchoolZone = $("#trainSchoolZone").val();	  
	  var trainSchoolName = $("#trainSchoolName").val();
	  var trainSchoolAddr = $("#trainSchoolAddr").val();
	  var trainSchoolURL = $("#trainSchoolURL").val();
	  var trainSchoolStatus = $("#trainSchoolStatus").val();	
  	var url = "/trainschool/toTrainSchoolList.do?page="+(page+1);
  	if(trainSchoolLevel!=null && trainSchoolLevel!=""){
		  url += "&trainSchoolLevel="+encodeURI(encodeURI($.trim(trainSchoolLevel)));
	  }
	  if(trainSchoolZone!=null && trainSchoolZone!=""){
		  url += "&trainSchoolZone="+encodeURI(encodeURI($.trim(trainSchoolZone)));
	  }
	  if(trainSchoolName!=null && trainSchoolName!=""){
		  url += "&trainSchoolName="+encodeURI(encodeURI($.trim(trainSchoolName)));
	  }
	  if(trainSchoolAddr!=null && trainSchoolAddr!=""){
		  url += "&trainSchoolAddr="+encodeURI(encodeURI($.trim(trainSchoolAddr)));
	  }
	  if(trainSchoolURL!=null && trainSchoolURL!=""){
		  url += "&trainSchoolURL="+encodeURI(encodeURI($.trim(trainSchoolURL)));
	  }
	  if(trainSchoolStatus!=null && trainSchoolStatus!=""){
		  url += "&trainSchoolStatus="+encodeURI(encodeURI($.trim(trainSchoolStatus)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var trainSchoolLevel = $("#trainSchoolLevel").val();
	  var trainSchoolZone = $("#trainSchoolZone").val();	  
	  var trainSchoolName = $("#trainSchoolName").val();
	  var trainSchoolAddr = $("#trainSchoolAddr").val();
	  var trainSchoolURL = $("#trainSchoolURL").val();
	  var trainSchoolStatus = $("#trainSchoolStatus").val();	
  	var url = "/trainschool/toTrainSchoolList.do?page="+(page-1);
  	if(trainSchoolLevel!=null && trainSchoolLevel!=""){
		  url += "&trainSchoolLevel="+encodeURI(encodeURI($.trim(trainSchoolLevel)));
	  }
	  if(trainSchoolZone!=null && trainSchoolZone!=""){
		  url += "&trainSchoolZone="+encodeURI(encodeURI($.trim(trainSchoolZone)));
	  }
	  if(trainSchoolName!=null && trainSchoolName!=""){
		  url += "&trainSchoolName="+encodeURI(encodeURI($.trim(trainSchoolName)));
	  }
	  if(trainSchoolAddr!=null && trainSchoolAddr!=""){
		  url += "&trainSchoolAddr="+encodeURI(encodeURI($.trim(trainSchoolAddr)));
	  }
	  if(trainSchoolURL!=null && trainSchoolURL!=""){
		  url += "&trainSchoolURL="+encodeURI(encodeURI($.trim(trainSchoolURL)));
	  }
	  if(trainSchoolStatus!=null && trainSchoolStatus!=""){
		  url += "&trainSchoolStatus="+encodeURI(encodeURI($.trim(trainSchoolStatus)));
	  }
  	window.location.href=url;
  }
  function topageInfo(){
	  var trainSchoolLevel = $("#trainSchoolLevel").val();
	  var trainSchoolZone = $("#trainSchoolZone").val();	  
	  var trainSchoolName = $("#trainSchoolName").val();
	  var trainSchoolAddr = $("#trainSchoolAddr").val();
	  var trainSchoolURL = $("#trainSchoolURL").val();
	  var trainSchoolStatus = $("#trainSchoolStatus").val();	
  	var topage = $("#topage").val();
  	var url = "/trainschool/toTrainSchoolList.do?page="+topage;
  	if(trainSchoolLevel!=null && trainSchoolLevel!=""){
		  url += "&trainSchoolLevel="+encodeURI(encodeURI($.trim(trainSchoolLevel)));
	  }
	  if(trainSchoolZone!=null && trainSchoolZone!=""){
		  url += "&trainSchoolZone="+encodeURI(encodeURI($.trim(trainSchoolZone)));
	  }
	  if(trainSchoolName!=null && trainSchoolName!=""){
		  url += "&trainSchoolName="+encodeURI(encodeURI($.trim(trainSchoolName)));
	  }
	  if(trainSchoolAddr!=null && trainSchoolAddr!=""){
		  url += "&trainSchoolAddr="+encodeURI(encodeURI($.trim(trainSchoolAddr)));
	  }
	  if(trainSchoolURL!=null && trainSchoolURL!=""){
		  url += "&trainSchoolURL="+encodeURI(encodeURI($.trim(trainSchoolURL)));
	  }
	  if(trainSchoolStatus!=null && trainSchoolStatus!=""){
		  url += "&trainSchoolStatus="+encodeURI(encodeURI($.trim(trainSchoolStatus)));
	  }
  	window.location.href=url;
  }
  

  function searchByCon(){
	  var trainSchoolLevel = $("#trainSchoolLevel").val();
	  var trainSchoolZone = $("#trainSchoolZone").val();	  
	  var trainSchoolName = $("#trainSchoolName").val();
	  var trainSchoolAddr = $("#trainSchoolAddr").val();
	  var trainSchoolURL = $("#trainSchoolURL").val();
	  var trainSchoolStatus = $("#trainSchoolStatus").val();	  
	  var url = "/trainschool/toTrainSchoolList.do?page=1";
	  if(trainSchoolLevel!=null && trainSchoolLevel!=""){
		  url += "&trainSchoolLevel="+encodeURI(encodeURI($.trim(trainSchoolLevel)));
	  }
	  if(trainSchoolZone!=null && trainSchoolZone!=""){
		  url += "&trainSchoolZone="+encodeURI(encodeURI($.trim(trainSchoolZone)));
	  }
	  if(trainSchoolName!=null && trainSchoolName!=""){
		  url += "&trainSchoolName="+encodeURI(encodeURI($.trim(trainSchoolName)));
	  }
	  if(trainSchoolAddr!=null && trainSchoolAddr!=""){
		  url += "&trainSchoolAddr="+encodeURI(encodeURI($.trim(trainSchoolAddr)));
	  }
	  if(trainSchoolURL!=null && trainSchoolURL!=""){
		  url += "&trainSchoolURL="+encodeURI(encodeURI($.trim(trainSchoolURL)));
	  }
	  if(trainSchoolStatus!=null && trainSchoolStatus!=""){
		  url += "&trainSchoolStatus="+encodeURI(encodeURI($.trim(trainSchoolStatus)));
	  }
  	  window.location.href=url;
  }
  function delInfo(trainSchoolId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/trainschool/delTrainSchoolById.do",
		          data: {"trainSchoolId":trainSchoolId},
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
  function editInfo(trainSchoolId){
	  layer.open({
	        type: 2,
	        title: '学校信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '430px'],
	        content: '/trainschool/toEditTrainSchool.do?trainSchoolId='+trainSchoolId
	    })
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
	     	<a href="" title="招聘学校管理" class="current">招聘学校管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>招聘学校管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>级别：
                	<select id="trainSchoolLevel" class="whh_input">
                		<option value="" <c:if test="${trainSchoolLevel==null}">selected</c:if>>请选择</option>
                         <c:forEach var="item" items="${levellist}" varStatus="status">
		                     <option value=${item.id} <c:if test="${trainSchoolLevel==item.id}">selected</c:if>>${item.name}</option>
		                  </c:forEach>
                	</select>
                </span>
                <span>区域：
                	<select id="trainSchoolZone" class="whh_input">
                		<option value="" <c:if test="${trainSchoolZone==null}">selected</c:if>>请选择</option>
                         <c:forEach var="item" items="${zonelist}" varStatus="status">
		                     <option value=${item.id} <c:if test="${trainSchoolZone==item.id}">selected</c:if>>${item.name}</option>
		                  </c:forEach>
                	</select>
                </span>
                <span>名称：<input type="text" class="zyh_txt whh_input"  id="trainSchoolName"  value=${trainSchoolName}></span>
                <span>地址：<input type="text" class="zyh_txt whh_input"  id="trainSchoolAddr"  value=${trainSchoolAddr}></span>
                <span>网址：<input type="text" class="zyh_txt whh_input"  id="trainSchoolURL"  value=${trainSchoolURL}></span>
                <span>状态：
                	<select id="trainSchoolStatus" class="whh_input">
                		<option value="" <c:if test="${trainSchoolStatus==null}">selected</c:if>>请选择</option>
                		<option value="0" <c:if test="${trainSchoolStatus==0}">selected</c:if>>正常</option>
                		<option value="1" <c:if test="${trainSchoolStatus==1}">selected</c:if>>废弃</option>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>层次</th><th>区域</th><th>名称</th><th>地址</th><th>网址</th><th>学校状态</th><th>操作</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(trainschoollist) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有招聘学校信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" items="${trainschoollist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>
	                  	   		<c:forEach var="paritem" items="${levellist}" varStatus="status">
	                  	   			<c:if test="${paritem.id == item.trainSchoolLevel}">${paritem.name}</c:if>
				                </c:forEach>
	                  	   </td>
		                   <td>
		                   		<c:forEach var="paritem" items="${zonelist}" varStatus="status">
	                  	   			<c:if test="${paritem.id == item.trainSchoolZone}">${paritem.name}</c:if>
				                </c:forEach>
		                   </td>
		                   <td><a class="zyh_xuexiao zyh_font_color" href="/trainschool/toTripRecordList.do?trainSchoolId=${item.trainSchoolId}">${item.trainSchoolName}</a></td>
		                   <td>${item.trainSchoolAddr}</td><td>${item.trainSchoolURL}</td>
		                   <td>${item.trainSchoolStatus == 0 ?'正常':item.trainSchoolStatus == 1 ?'废弃':''}</td>
		                   <td>
								<button type="button" class="btn btn-warning btn-mini" onclick="editInfo('${item.trainSchoolId}')">修改</button>
								<button type="button" class="btn btn-mini btn-danger zyh_delete" onclick="delInfo('${item.trainSchoolId}')">删除</button>
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