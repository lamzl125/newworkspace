<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>合作公司--项目管理</title>
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
	  initMemu(0,2);
  })
  function addCorpProject(){
	  var corpCode = $("#corpCode").val().trim();
	  var corpProjectName = $("#addCorpProjectName").val().trim();
	  var starttime = $("#addStarttime").val();
	  var endtime = $("#addEndtime").val();
	  if(corpProjectName == null || corpProjectName == ''){
		  alert("项目名称不能为空");
		  return false;
	  }
	  if(starttime == null || starttime == ''){
		  alert("开始时间不能为空");
		  return false;
	  }
	  if(endtime == null || endtime == ''){
		  alert("结束时间不能为空");
		  return false;
	  }
	  var start=$("#addStarttime").val();                                              //用JQuery从页面去的时间值
	   var end=$("#addEndtime").val();
	   if(start!=''&&end!=''){
	    start=start.split('-');                                                     //用的是时间控件格式是yyyy-MM-dd
	    end=end.split('-');
	    var start1=new Date(start[0],start[1]-1,start[2]);    //因为当前时间的月份需要+1，故在此-1，不然和当前时间做比较会判断错误
	    var end1=new Date(end[0],end[1]-1,end[2]);
	    var td=new Date();
	   <%--  if(td>start1){开始时间必须大于当前时间
	     alert("开始时间要从明天开始");
	     return false;
	    } --%>
	    if(start1>end1){
	     alert("结束日期不能在开始日期之后！");
	     return false;
	    }
	   }
	  var data = {
			 "corpCode": corpCode,
			 "corpProjectName":corpProjectName,
			 "starttime": starttime,
			 "endtime": endtime,
	  }
	  $.ajax({
          type: "post",
          url: "/corpProject/saveCorpProject.do",
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
	  var corpCode = $("#corpCode").val();
  	var url = "/corpProject/toCorpProjectList.do?corpCode="+corpCode+"&page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var corpCode = $("#corpCode").val();  
  	var url = "/corpProject/toCorpProjectList.do?corpCode="+corpCode+"&page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var corpCode = $("#corpCode").val();  
  	var url = "/corpProject/toCorpProjectList.do?corpCode="+corpCode+"&page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
	  var corpCode = $("#corpCode").val();  
  	var topage = $("#topage").val();
  	var url = "/corpProject/toCorpProjectList.do?corpCode="+corpCode+"&page="+topage;
  	window.location.href=url;
  }
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<input type="hidden" id="corpCode" value=${corpcode}>
<div id="content">
<div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
     	<a href="" title="合作公司--项目管理" class="current">合作公司--项目管理</a>
    </div>
</div>
<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>合作公司--项目管理</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>项目编号</th><th>项目名称</th><th>项目开始时间</th><th>项目结束时间</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有合作公司信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                	<a href="javascript:void(0);" onclick="getCorpProject('${item.corpcode}')">
		                  <tr>
		                  	   <td>${status.index+1}</td>
		                  	   <td width="30%">${item.corpprojectcode}</td>
			                   <td>${item.corpprojectname}</td>
			                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${item.projectstartdate}" /></td>
			                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${item.projectenddate}" /></td>
		                 </tr>
		                </a>
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
            	<span>项目名称：</span>
                <input type="text" class="whh_input" id="addCorpProjectName" placeholder="输入项目名称">
        		<span>开始时间： </span>
                <input type="text" class="whh_input" placeholder="请输入开始时间" id="addStarttime" onclick="WdatePicker()" readonly/>
                <span>结束时间：</span>
               <input type="text" class="whh_input" placeholder="请输入结束时间" id="addEndtime" onclick="WdatePicker()" readonly/>	
                
                <input type="button" class="zyh_btn" onclick="addCorpProject()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>
</body>
</html>