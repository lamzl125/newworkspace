<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>物资管理</title>
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
  <style type="text/css">
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
	    width: 900px;
	}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,13);
  })
  function addInfo(){
	  var name = $("#infoname").val().trim();
	  if(infoname == null || infoname == ''){
		  alert("物资名称不能为空");
		  return false;
	  }
	  
	  var data = {
			 "name": name,
	  }
	  $.ajax({
          type: "post",
          url: "/items/saveItem.do",
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
  function delById(id){
	  $.ajax({
          type: "post",
          url: "/items/delById.do",
          data: {"id":id,},
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
  function editById(Id) {
	  var url = '/items/openedit.do?Id='+Id;
		layer.open({
			type : 2,
			title : '修改物资信息',
			area : [ '280px', '200px' ],
			move : false, 	
			content:url
// 			content : ['/items/openedit.do?Id='+Id, 'yes']
		});
	}
  function togetListBypage(page){
  	var url = "/items/itemsList.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/items/itemsList.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/items/itemsList.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/items/itemsList.do?page="+topage;
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
     	<a href="" title="物资管理" class="current">物资管理</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>物资管理</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr><th style="display: none;">物资ID</th><th width="50%">物资名称</th><th>操作</th></tr>
              </thead>
              <tbody>
	              	<c:if test="${fn:length(list) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有物资信息</td>
					    </tr>
					</c:if>
	                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
		                  <tr>
				                  <%--  <td style="display: none;"><a href="/resumeSource/toEditResumeSourceById.do?id=${item.resumesourceid}" >${item.resumesourceid}</a></td> --%>
				                   <td>${item.name}</td>
			                   <td>
			                   <a href="javascript:void(0);" class="delButClass" onclick="delById('${item.id}')">删除</a>&nbsp;&nbsp;
			                   <a href="javascript:void(0);" class="editButClass" onclick="editById('${item.id}')">编辑</a>
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
          <div class="whh_tab_bor">
	           <div class="zyh_sos">
	        		<span>物资名称： </span>
	                <input type="text" class="whh_input" placeholder="请输入物资名称" id="infoname" >
	                <input type="button" class="zyh_btn" onclick="addInfo()" value="+">
	            </div>
          </div>
        </div>
  </div>
</div>



 </body>
</html>