<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>修改地区</title>
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
	    width: 700px;
	}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,0);
  })
  function addAread(){
	  var areaid = $("#areaid").val().trim();
	  var areaname = $("#areaname").val().trim();
	  if(areaid == null || areaid == ''){
		  alert("地区编号不能为空");
		  return false;
	  }
	  if(areaname == null || areaname == ''){
		  alert("地区名称不能为空");
		  return false;
	  }
	  var data = {
			 "areaid": areaid,
			 "areaname":areaname,
	  }
	  $.ajax({
          type: "post",
          url: "/areas/saveAreas.do",
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
  function togetListBypage(page){
  	var url = "/areas/toAddAreas.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/areas/toAddAreas.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/areas/toAddAreas.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/areas/toAddAreas.do?page="+topage;
  	window.location.href=url;
  }
  function delAreaById(areaId){
		if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/areas/delAreasById.do",
		          data: {"areaid":areaId},
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
     	<a href="" title="管理地区" class="current">管理地区</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>管理地区</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th>
                  <th style="display:none;">地区编号</th>
                  <th>地区名称</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有地区信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
		                   <td  style="display:none;">${item.areaid}</td>
		                   <td>${item.areaname}</td>
		                   <td><a class="delButClass" href="javascript:void(0);" onclick="delAreaById('${item.areaid}')">删除</a></td>
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
            	<span>地区编码：</span>
                <input type="text" class="zyh_txt whh_input" id="areaid" placeholder="输入地区开头字母">
            	<span>地区名称：</span>
                <input type="text" class="zyh_txt whh_input" id="areaname" placeholder="输入所在地区">
                
                <input type="button" class="zyh_btn" onclick="addAread()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>

 </body>
</html>