<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>修改技术方向</title>
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
	  initMemu(0,11);
})
  function addProfess(){
	  var id = $("#id").val().trim();
	  var name = $("#name").val().trim();
	  if(id == null || id == ''){
		  alert("技术编号不能为空");
		  return false;
	  }
	  if(name == null || name == ''){
		  alert("技术方向不能为空");
		  return false;
	  }
	  var data = {
			 "id": id,
			 "name":name,
	  }
	  $.ajax({
          type: "post",
          url: "/profession/saveProfess.do",
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
  	var url = "/profession/toProfession.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/profession/toProfession.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/profession/toProfession.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/profession/toProfession.do?page="+topage;
  	window.location.href=url;
  }
  function delPressById(id){
		if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/profession/delProfessById.do",
		          data: {"id":id},
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
     	<a href="" title="管理技术方向" class="current">管理技术方向</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>管理技术方向</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
            		<col width="10%;"><col width="40%;"><col width="25%;"><col width="25%;">
            		
            	</colgroup>
              <thead>
                <tr><th>技术编号</th><th>技术方向</th><th>操作</th></tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有技术方向信息</td>
				    </tr>
				</c:if>
                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
		                   <td>${item.id}</td>
		                   <td>${item.name}</td>
		                   <td><a class="delButClass" href="javascript:void(0);" onclick="delPressById('${item.id}')">删除</a></td>
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
            	<span>技术编码：</span>
                <input type="text" class="zyh_txt whh_input" id="id" placeholder="输入技术方向编码">
            	<span>技术方向： </span>
                <input type="text" class="zyh_txt whh_input" id="name" placeholder="输入技术方向名称">
                
                <input type="button" class="zyh_btn" onclick="addProfess()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>






 </body>
</html>