<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>权限管理</title>
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
  .zyh_btn{
	    width: 30px;
	    height: 30px;
	    font-size: 16px;
	    background-color: #009FE8;
	    border: none;
	    color: #fff;
	}
	.zyh_sos{
	   margin: 0 auto;
	    width: 1000px;
	}
	.whh_input{width:170px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,3);
  })
  function addRight(){
	  var addParentId = $("#addParentId").val().trim();
	  var addRightId = $("#addRightId").val().trim();
	  var addRightname = $("#addRightname").val().trim();
	  var addRightURL = $("#addRightURL").val().trim();
	  if(addParentId == null || addParentId == ''){
		  alert("父级菜单不能为空");
		  return false;
	  }
	  if(addRightId == null || addRightId == ''){
		  alert("权限ID不能为空");
		  return false;
	  }
	  if(addRightname == null || addRightname == ''){
		  alert("权限名称不能为空");
		  return false;
	  }
	  if(addParentId!='-1'){
		  if(addRightURL == null || addRightURL == ''){
			  alert("URL地址不能为空");
			  return false;
		  }
	  }
	  
	  var data = {
			 "addParentId": addParentId,
			 "addRightId":addRightId,
			 "addRightname": addRightname,
			 "addRightURL": addRightURL,
	  }
	  $.ajax({
          type: "post",
          url: "/rights/saveRight.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
  }
 function toEditRight(rightid){
	var url = "/rights/toEditRight.do?rightid="+rightid;
  	window.location.href=url;
 }
  function togetListBypage(page){
  	var url = "/rights/rightsList.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/rights/rightsList.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/rights/rightsList.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/rights/rightsList.do?page="+topage;
  	window.location.href=url;
  }
  
  function pad2(num, n) {   
	  if ((num + "").length >= n) return num;   
	  return pad2(num + "0", n);   
  } 
  function showChildRightTop(){
	  var addParentId = $("#addParentId").val();
	  $("#addRightId").val("");
	  if(addParentId=="-1"){
		  $.ajax({
	          type: "post",
	          url: "/rights/getMaxRightId.do",
	          data: {"addParentId":addParentId,},
	          dataType: "json",
	          success: function(result){
	         	 if(result.status == 0){
	         		var cc = (parseInt(result.maxChildRight.rightid.substring(0,7))+1);
	         		$("#addRightId").val(pad2(cc,12));
	         	 }else{
	         		$("#addRightId").val("100000100000");
	         	 }
	          }
	      });
	  }else{
		  if(addParentId!=""){
			  $.ajax({
		          type: "post",
		          url: "/rights/getMaxRightId.do",
		          data: {"addParentId":addParentId,},
		          dataType: "json",
		          success: function(result){
		         	 if(result.status == 0){
		         		$("#addRightId").val(parseInt(result.maxChildRight.rightid)+1);
		         	 }else{
		         		$("#addRightId").val(parseInt(result.addParentId)+1);
		         	 }
		          }
		      });
		  } 
	  }
  }
  function searchByCon(){
	  var searchrightid = $("#searchrightid").val().trim();
	  var searchrightname = $("#searchrightname").val().trim();
	  var searchParentRightId = $("#searchParentRightId").val().trim();
	  var url = "/rights/rightsList.do?searchrightid="+searchrightid+"&searchrightname="+encodeURI(encodeURI($.trim(searchrightname)))+"&searchParentRightId="+searchParentRightId;
  		window.location.href=url;
  }
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
	     	<a href="" title="权限管理" class="current">权限管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>权限管理</h5>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
            	<span style="display: none;"> 权限ID： </span> 
				<input style="display: none;" type="text" class="zyh_txt whh_input"   id="searchrightid" value=${searchrightid}>
				
                <span>权限名称：<input type="text" class="zyh_txt whh_input"  id="searchrightname"  value=${searchrightname}></span>
                <span>父权限：
                	<select style="width: 120px;" id="searchParentRightId">
                		<option value="" <c:if test="${searchParentRightId==null}">selected</c:if>>请选择父级菜单</option>
                         <option value="-1" <c:if test="${searchParentRightId==-1}">selected</c:if>>无</option>
                         <c:forEach var="item" begin="0" items="${allrightList}" varStatus="status">
		                     <option value=${item.rightid} <c:if test="${searchParentRightId==item.rightid}">selected</c:if>>${item.rightlevel}-${item.rightname}</option>
		                  </c:forEach>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th style="display: none;">权限ID</th><th>权限名称</th>
                  <th>父权限</th><th>url地址</th><th>权限级别</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有合作公司信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
		                   <td style="display: none;"><a href="javascript:void(0);" onclick="toEditRight('${item.rightid}')">${item.rightid}</a></td>
		                   <td>${item.rightname}</td>
		                   <td>${item.parentid}</td>
		                   <td>${item.url}</td>
		                   <td>${item.rightlevel}</td>
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
          <div class="whh_tab_bor">
            <div class="zyh_sos">
            	<span>父级菜单：</span>
            	<select class="whh_sel" id="addParentId" onchange="showChildRightTop()">
            		<option value="">请选择父级菜单</option>
	            	<option value="-1">无</option>
	           		<c:forEach var="item" begin="0" items="${allrightList}" varStatus="status">
	                     <option value=${item.rightid}>${item.rightlevel}-${item.rightname}</option>
	                 </c:forEach>
                 </select>
            	<span style="display: none;">权限ID：</span>
                <input style="display: none;" type="text" class="whh_input" id="addRightId" placeholder="输入权限ID">
        		<span>权限名称： </span>
                <input type="text" class="whh_input" placeholder="请输入权限名称" id="addRightname" ><br/><br/>
                <span>URL地址：</span>
                <input type="text" class="whh_input2" placeholder="eg:/rights/rightsList.do" id="addRightURL" >	
                <input type="button" class="zyh_btn" onclick="addRight()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>
</body>
</html>