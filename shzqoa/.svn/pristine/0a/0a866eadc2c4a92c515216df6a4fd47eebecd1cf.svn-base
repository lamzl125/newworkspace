<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>参数种类管理</title>
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
  
  

  <style type="text/css" rel="stylesheet">
	.zyh_btn{width: 30px;height: 30px;font-size: 16px;background-color: #009FE8; border: none;color: #fff;}
	.zyh_sos{margin: 0 auto;width: 1000px;}
	.whh_input{width:170px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,9);
  })
  function togetListBypage(page){
  	var url = "/basepara/paraKindList.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/basepara/paraKindList.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/basepara/paraKindList.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/basepara/paraKindList.do?page="+topage;
  	window.location.href=url;
  }
  
  function searchByCon(){
// 	  var searchid = $("#searchid").val().trim();
	  var searchname = $("#searchname").val().trim();
	  var url = "/basepara/paraKindList.do?searchid=0&searchname="+searchname;
  		window.location.href=url;
  }
  function delInfoById(id){
	  $.ajax({
          type: "post",
          url: "/basepara/delparaKindById.do",
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
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
	     	<a href="" title="参数管理" class="current">参数管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>参数管理</h5>
            <button type="button" class="btn btn-mini btn-success btn_fr layer_tj" id="toadd">添加</button>
          </div>
          <div class="widget-content clearfix">
            <!--查询条件-begin-->
            <div class="widget-search">
            	<span> 参数种类名称： </span> 
				<input type="text" class="zyh_txt whh_input"  id="searchname"  value=${searchname}> 
				<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th style="display:none;">参数种类ID</th><th>参数种类名称</th><th>顺序</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有参数种类信息</td>
				    </tr>
				</c:if>
                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
		                   <td style="display:none;"><a class="getparas" href="javascript:void(0);">${item.parakindid}</a></td>
		                   <td><a class="getparas" href="javascript:void(0);">${item.parakindname}</a></td>
		                   <td>${item.orderindex}</td>
		                   <td>
		                   		<a class="delButClass" href="javascript:void(0);" onclick="delInfoById(${item.parakindid})">删除</a>
		                   		<a class="editButClass editparakind" href="javascript:void(0);">修改</a>
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
  <script type="text/javascript" src="/views/baseParameter/js/parakind.js"></script>
 </body>
</html>