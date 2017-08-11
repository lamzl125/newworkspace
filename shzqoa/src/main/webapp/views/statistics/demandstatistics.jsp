<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求统计</title>
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
	  initMemu(2,2);
  })
  
  function togetListBypage(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var url = "/demandstatistics/demandstatisticslist.do?page="+page;
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var url = "/demandstatistics/demandstatisticslist.do?page="+(page+1);
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();		
  	  var url = "/demandstatistics/demandstatisticslist.do?page="+(page-1);
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  function topageInfo(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	
  	  var topage = $("#topage").val();
  	  var url = "/demandstatistics/demandstatisticslist.do?page="+topage;
  	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	window.location.href=url;
  }
  
    
  function searchByCon(){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();	  
	  var url = "/demandstatistics/demandstatisticslist.do?page=1";
	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+encodeURI(encodeURI($.trim(startdate)));
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+encodeURI(encodeURI($.trim(enddate)));
	  }
  	  window.location.href=url;
  }
  function customerstatuslist(demandId,optype){
	  var startdate = $("#startdate").val();
	  var enddate = $("#enddate").val();
	  var url = "/demandstatistics/customerlist.do?demandId="+demandId+"&optype="+optype;
	  if(startdate!=null && startdate!=""){
		  url += "&startdate="+startdate;
	  }
	  if(enddate!=null && enddate!=""){
		  url += "&enddate="+enddate;
	  }
	  layer.open({
	        type: 2,
	        title: '简历信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '546px'],
	        content: url
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
	    	<a href="index.html" title="信息绩效统计" class="tip-bottom"><i class="icon-home"></i>信息绩效统计</a>
	     	<a href="" title="需求统计" class="current">需求统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求统计</h5>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>开始时间：<input type="text" id="startdate" class="span2" onclick="WdatePicker()" readonly value="${startdate}"/></span>
                <span>结束时间：<input type="text" id="enddate" class="span2" onclick="WdatePicker()" readonly value="${enddate}"/></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>客户</th><th>项目</th><th>简历份数</th><th>可面人数</th><th>面试人数</th><th>面试通过人数</th><th>入项人数</th>         
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(stlist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有需求统计信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${stlist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>${item.CorpName}</td>
	                  	   <td>${item.Projecttype}</td>
	                  	   <td><a class="zyh_font_color entrylist" href="javascript:void(0)" onclick="customerstatuslist('${item.demandId}',1)">${item.demandresumecount}</a></td>
	                  	   <td><a class="zyh_font_color entrylist" href="javascript:void(0)" onclick="customerstatuslist('${item.demandId}',2)">${item.yjinterviewcount}</a></td>
	                  	   <td><a class="zyh_font_color entrylist" href="javascript:void(0)" onclick="customerstatuslist('${item.demandId}',3)">${item.interviewcount}</a></td>
	                  	   <td><a class="zyh_font_color entrylist" href="javascript:void(0)" onclick="customerstatuslist('${item.demandId}',4)">${item.successcount}</a></td>
	                  	   <td><a class="zyh_font_color entrylist" href="javascript:void(0)" onclick="customerstatuslist('${item.demandId}',5)">${item.joinprojectcount}</a></td>
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