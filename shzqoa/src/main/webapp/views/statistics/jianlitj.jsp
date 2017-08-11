<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>简历统计页面</title>
  <link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
  <link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
  <link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
  <link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="/views/common/css/zyh_style.css" />
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  
  <script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/dateinit.js" type="text/javascript"></script>
<style type="text/css">
.zyh_sos {
	width: 100%;
	height: 40px;
	overflow: hidden;
	margin-bottom: 10px;
}

.zyh_sos span, .zyh_txt, .zyh_btn_n {
	float: left;
	line-height: 30px;
}

.zyh_sos span {
	margin-left: 8px;
}
.zyh_txt,.zyh_sel{
		font-size: 13px;
	color: #666;
}
.zyh_txt {
	border-radius: 3px;
	padding-left: 5px;
	border: #F1F1F1 1px solid;
	width: 90px;
	height: 30px;
}

.zyh_btn_n {
	width: 50px;
	float: left;
	line-height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 8px;
	cursor: pointer;
}

select{  border:0px;}
.zyh_sel {
  	border:#e5e5e5 1px solid;
	width: 100px;
	float: left;
	margin: 0px;
	height: 30px;
	border-radius: 2px;
}
.a:HOVER {
	color: blue;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(2,0);
	  /* var startdate = showWeekFirstDay();
	  $("#starttime").val(startdate);
	  $("#endtime").val(new Date().format('yyyy-MM-dd')); */
	  //添加缓存
	  /* if(window.sessionStorage){
		  $("select").each(function(){
			  var name = $(this).attr('name');
			  var val = sessionStorage.getItem(name);
			  if(val){
			 	 $(this).val(val);
			  }
	      });
		  $('input').each(function(){
			  var name = $(this).attr('name');
			  var val = sessionStorage.getItem(name);
			  if(val){
				$(this).val(val);
			  }
		  });
	      $("select").change(function(){
	    	  var name =$(this).attr('name');
	    	  var value = $(this).val()
	    	  sessionStorage.setItem(name,value);
	      });
	      $("input").change(function(){
	    	  var name=$(this).attr('name');
	    	  var value=$(this).val();
	    	  sessionStorage.setItem(name, value);
	      });
	  }else{
		  alert('您的浏览器不支持缓存，请升级至最新版。');
	  } */
	  
  });
  function toResumeByResourceAndTime(obj){
		var starttime = $("#starttime").val();
		var endtime = $("#endtime").val();
		var resource = obj;
		var url = "/resume/toResumeByResourceAndTime.do?resource="+resource;
		if(starttime !=null && starttime!=''){
			url += "&starttime="+starttime;
		}
		if(endtime !=null && endtime!=''){
			url += "&endtime="+endtime;
		}
		window.location.href=url;
	}
  function searchByResume(){
	  var resumesource=$("#resumesource").find("option:selected").val().trim();
	  var ocode=$("#ocode").find("option:selected").val().trim();
	  var acount=$("#acount").find("option:selected").val().trim();
	  var starttime=$("#starttime").val().trim();
	  var endtime=$("#endtime").val().trim(); 
	  var url="/jianli/CustomerCount.do?resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
	  window.location.href=url;
  }
 /*  function showWeekFirstDay(){
      var Nowdate=new Date();
      var WeekFirstDay=new Date(Nowdate-(Nowdate.getDay()-1)*86400000);
      return WeekFirstDay.format('yyyy-MM-dd');
  } */
function toprevpageInfo(page){
	  var resumesource=$("#resumesource").find("option:selected").val();
	  var ocode=$("#ocode").find("option:selected").val();
	  var acount=$("#acount").find("option:selected").val();
	  var starttime=$("#starttime").val();
	  var endtime=$("#endtime").val();
	var url="/jianli/CustomerCount.do?page="+(page-1)+"&resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
	window.location.href=url;
}
function togetListBypage(page){
	  var resumesource=$("#resumesource").find("option:selected").val().trim();
	  var ocode=$("#ocode").find("option:selected").val();
	  var acount=$("#acount").find("option:selected").val();
	  var starttime=$("#starttime").val();
	  var endtime=$("#endtime").val();
  	var url = "/jianli/CustomerCount.do?page="+page+"&resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
  	window.location.href=url;
  }
function tonextpageInfo(page){
	  var resumesource=$("#resumesource").find("option:selected").val();
	  var ocode=$("#ocode").find("option:selected").val();
	  var acount=$("#acount").find("option:selected").val();
	  var starttime=$("#starttime").val();
	  var endtime=$("#endtime").val();
  	var url = "/jianli/CustomerCount.do?page="+(page+1)+"&resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
  	window.location.href=url;
  }
function toprevpageInfo(page){
	  var resumesource=$("#resumesource").find("option:selected").val();
	  var ocode=$("#ocode").find("option:selected").val();
	  var acount=$("#acount").find("option:selected").val();
	  var starttime=$("#starttime").val();
	  var endtime=$("#endtime").val();
  	var url = "/jianli/CustomerCount.do?page="+(page-1)+"&resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
  	window.location.href=url;
  }
function topageInfo(){
	  var resumesource=$("#resumesource").find("option:selected").val();
	  var ocode=$("#ocode").find("option:selected").val();
	  var acount=$("#acount").find("option:selected").val();
	  var starttime=$("#starttime").val();
	  var endtime=$("#endtime").val();
  	var topage = $("#topage").val();
  	var url = "/jianli/CustomerCount.do?page="+topage+"&resumesource="+resumesource+"&ocode="+ocode+"&account="+acount+"&starttime="+starttime+"&endtime="+endtime;
  	window.location.href=url;
  }
function ValidateTime(){
	var starttime=$("#starttime").val();
	var endtime=$("#endtime").val();
	if(starttime !='' && endtime !='' && (getDate(starttime)-getDate(endtime)>0)){
		alert("结束时间不能小于开始时间!");
		document.getElementById("endtime").value="";
		return false;
	}
}

//data转换
function getDate(date){
 var dates = date.split("-");
 var dateReturn = '';
 
 for(var i=0; i<dates.length; i++){
  dateReturn+=dates[i];
 }
 return dateReturn;
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
	     	<a href="" title="简历统计" class="current">简历统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>简历统计</h5>
          </div>
          <div class="widget-content clearfix">
            <div class="zyh_sos">
					<span style="margin-left: 0px;"> 开始时间：</span> <input type="text" class="zyh_txt"
						name="starttime"
						value="${starttime }"
						id="starttime" readonly="readonly" placeholder="输入时间"
						onclick="WdatePicker()" onblur="$(this).trigger('change')" />
					<span>结束时间： </span> <input type="text" class="zyh_txt"
						name="endtime"
						value="${endtime }"
						id="endtime" readonly="readonly" placeholder="输入时间"
						onclick="WdatePicker()" onblur="$(this).trigger('change')" onfocus="ValidateTime()" /> <span>
						来源： </span> <select class="zyh_sel" id="resumesource" name="resumesource">
						<option value="">请选择出处</option>
						<c:forEach items="${resumeSourceList}" var="info">
							<c:choose>
								<c:when test="${info.resumesourceid eq resumesource }">	
									<option value="${info.resumesourceid}" selected="selected">${info.resumesourcename}</option>
								</c:when>
								<c:otherwise>
									<option value="${info.resumesourceid}">${info.resumesourcename}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <span>操作人员编号：</span> <select class="zyh_sel" id="ocode"
						name="ocode">
						<option value="">请选择出处</option>
						<c:forEach items="${users}" var="info">
							<c:choose>
							<c:when test="${info.usercode eq  ocode}">
								<option value="${info.usercode}" selected="selected">${info.realname}</option>								
							</c:when>
							<c:otherwise>
								<option value="${info.usercode}">${info.realname}</option>								
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <span>录入账号：</span> <select class="zyh_sel" id="acount" style="width: 120px;" 
						name="acount">
						<option value="">请选择录入账号</option>
						<c:forEach items="${accounts}" var="info">
							<c:choose>
								<c:when test="${info.aid eq account}">
									<option value="${info.aid}" selected="selected">${info.account}</option>									
								</c:when>
								<c:otherwise>
									<option value="${info.aid}">${info.account}</option>								
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <input type="button" class="zyh_btn_n" value="搜索"
						onclick="searchByResume()">
				</div>
            
            <table class="table table-bordered table-striped with-check">
            <colgroup>
            	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
            </colgroup>
              <thead>
                <tr><th>简历来源</th><th>统计人数</th><th>成功人数</th><th>超过50%</th></tr>
              </thead>
              <tbody>
           			<c:if test="${fn:length(customerInfos) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有简历信息</td>
						</tr>
					</c:if>
					<c:forEach items="${customerInfos }" var="CusCount">
						<tr>
							<td><c:forEach items="${resumeSourceList}" var="info">
									<c:if test="${info.resumesourceid==CusCount.resumesource}">${info.resumesourcename}</c:if>
								</c:forEach></td>
							<td><a class="" href="javascript:void(0);"
								onclick="toResumeByResourceAndTime(${CusCount.resumesource})">${CusCount.count }</a></td>
							<td>${CusCount.sum1 }</td>
							<td>${CusCount.sum2 }</td>
						</tr>
					</c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0);" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
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