<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>普工信息</title>
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
	  initMemu(8,5);
  })
  var startdate = parent.$("#startdate").val();
  var enddate = parent.$("#enddate").val();	  
  var usercode  = $("#usercode").val();
  var optype = $("#optype").val();
  function togetListBypage(page){
  	  var url = "/workdemand/showworkerlist.do?page="+page;
  	  if(usercode!=null && usercode!=''){
  		  url += "&usercode="+usercode;
  	  }
  	  if(optype!=null && optype!=''){
		  url += "&optype="+optype;
	  }
  	  if(startdate!=null && startdate!=''){
		  url += '&startdate='+startdate;
	  }
  	  if(enddate!=null && enddate!=''){
		  url += '&enddate='+enddate;
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
  	  var url = "/workdemand/showworkerlist.do?page="+(page+1);
  	  if(usercode!=null && usercode!=''){
		  url += "&usercode="+usercode;
	  }
	  if(optype!=null && optype!=''){
		  url += "&optype="+optype;
	  }
	  if(startdate!=null && startdate!=''){
		  url += '&startdate='+startdate;
	  }
	  if(enddate!=null && enddate!=''){
		  url += '&enddate='+enddate;
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
  	  var url = "/workdemand/showworkerlist.do?page="+(page-1);
  	  if(usercode!=null && usercode!=''){
		  url += "&usercode="+usercode;
	  }
	  if(optype!=null && optype!=''){
		  url += "&optype="+optype;
	  }
	  if(startdate!=null && startdate!=''){
		  url += '&startdate='+startdate;
	  }
	  if(enddate!=null && enddate!=''){
		  url += '&enddate='+enddate;
	  }
  	  window.location.href=url;
  }
  function topageInfo(){        
  	  var topage = $("#topage").val();
  	  var url = "/workdemand/showworkerlist.do?page="+topage;
  	  if(usercode!=null && usercode!=''){
		  url += "&usercode="+usercode;
	  }
	  if(optype!=null && optype!=''){
		  url += "&optype="+optype;
	  }
	  if(startdate!=null && startdate!=''){
		  url += '&startdate='+startdate;
	  }
	  if(enddate!=null && enddate!=''){
		  url += '&enddate='+enddate;
	  }
  	  window.location.href=url;
  }
  </script>
  
 </head>
 <body style="background:#fff;">
 <input type="hidden" id="usercode" value="${usercode}" />
 <input type="hidden" id="optype" value="${optype}" />
<div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                	<tr><th>#</th><th>录入人</th><th>普工</th></tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">未查询到普工信息</td></tr>
				</c:if>
                <c:forEach  items="${list}"  var="worker" varStatus="status">
               		<tr>
	                   <td>${status.index+1}</td>
	                   <td>
	                   		<c:forEach items="${userlist}" var="userinfo">
	                   			<c:if test="${userinfo.usercode eq worker.addPeople}">${userinfo.realname}</c:if>
	                   		</c:forEach>
	                   </td>
	                   <td>${worker.workerName}</td>
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