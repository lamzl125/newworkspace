<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>考勤统计</title>
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
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>

<script type="text/javascript">
function toprevpageInfo(page){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
	var url="/CustomerInfoKq/selectCustomerInfoKq.do?page="+(page-1)+"&beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
	window.location.href=url;
}
function togetListBypage(page){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
  	var url = "/CustomerInfoKq/selectCustomerInfoKq.do?page="+page+"&beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
  	window.location.href=url;
  }
function tonextpageInfo(page){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
  	var url = "/CustomerInfoKq/selectCustomerInfoKq.do?page="+(page+1)+"&beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
  	window.location.href=url;
  }
function toprevpageInfo(page){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
  	var url = "/CustomerInfoKq/selectCustomerInfoKq.do?page="+(page-1)+"&beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
  	window.location.href=url;
  }
function topageInfo(){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
  	var topage = $("#topage").val();
  	var url = "/CustomerInfoKq/selectCustomerInfoKq.do?page="+topage+"&beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
  	window.location.href=url;
  } 

function searchByParam(){
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var customerCode=$("#customerCode").find("option:selected").val();
	var ifZZ=$("#ifZZ").find("option:selected").val();
	var usercode=$("#userid").find("option:selected").val();
	var url="/CustomerInfoKq/selectCustomerInfoKq.do?beginTime="+beginTime+"&endTime="+endTime+"&customerCode="+customerCode+"&ifZZ="+ifZZ+"&usercode="+usercode;
	window.location.href=url;
}
$(document).ready(function(){
	initMemu(5,1);
})
</script>
<style>
.zyh_rated_box {
	width: 960px;
	overflow: hidden;
	margin-left: 20px;
	background-color: #E0EFF5;
	height: auto;
}

.zyh_rated_box span {
	display: block;
	float: left;
	margin-left: 20px;
	margin-bottom: 10px;
}

.zyh_rated_btn {
	width: 120px;
	height: 36px;
	background-color: #FF7D01;
	border: none;
	color: #fff;
	border-radius: 3px;
	display: inline-block;
	line-height: 36px;
	margin-top: 20px;
	margin-bottom: 20px;
}

.zyh_rated_btn:hover {
	background-color: #FFA501;
}

.zyh_rated_shao {
	width: 960px;
	overflow: hidden;
	margin-top: 10px;
}

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

.zyh_txt, .zyh_sel {
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

select {
	border: 0px;
}

.zyh_sel {
	border: #e5e5e5 1px solid;
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
</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="" title="考勤管理" class="tip-bottom"><i class="icon-home"></i>考勤管理</a>
	     	<a href="" title="考勤统计" class="current">考勤统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>考勤统计</h5>
          </div>
          <div class="widget-content clearfix">
            	<div class="zyh_sos">
					<span style="margin-left: 0px;"> 开始时间：</span> <input type="text"
						class="zyh_txt" name="beginTime" value="${beginTime }"
						id="beginTime" readonly="readonly" placeholder="输入时间"
						onclick="WdatePicker()" onblur="$(this).trigger('change')" /> <span>结束时间：
					</span> <input type="text" class="zyh_txt" name="endTime"
						value="${endTime }" id="endTime" readonly="readonly"
						placeholder="输入时间" onclick="WdatePicker()"
						onblur="$(this).trigger('change')" /> <span> 姓名： </span> <select
						class="zyh_sel" style="width: 120px;" name="customerCode"
						id="customerCode">
						<option value="">请选择人员姓名</option>
						<c:forEach items="${customerinfos}" var="info">
							<c:choose>
								<c:when test="${info.customercode eq customerCode}">
									<option value="${info.customercode}" selected="selected">${info.customername}</option>
								</c:when>
								<c:otherwise>
									<option value="${info.customercode}">${info.customername}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <span>是否转正：</span> <select class="zyh_sel" id="ifZZ" name="ifZZ">
						<option value="">请选择出处</option>
						<c:choose>
							<c:when test="${ifZZ eq 1 }">
								<option value="1" selected="selected">已转正</option>
							</c:when>
							<c:otherwise>
								<option value="1">已转正</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ifZZ eq 2 }">
								<option value="2" selected="selected">未转正</option>
							</c:when>
							<c:otherwise>
								<option value="2">未转正</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ifZZ eq 3 }">
								<option value="3" selected="selected">月内转正</option>
							</c:when>
							<c:otherwise>
								<option value="3">月内转正</option>
							</c:otherwise>
						</c:choose>
					</select> <span>录入人员：</span> <select class="zyh_sel" id="userid"
						style="width: 120px;" name="usercode">
						<option value="">请选择人员姓名</option>
						<c:forEach items="${users}" var="info">
							<c:choose>
								<c:when test="${info.usercode eq usercode }">
									<option value="${info.usercode}" selected="selected">${info.realname}</option>
								</c:when>
								<c:otherwise>
									<option value="${info.usercode}">${info.realname}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <input type="button" class="zyh_btn_n" value="搜索"
						onclick="searchByParam()">
				</div>
	            
	            
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="5%"><col width="5%"><col width="5%"><col width="5%">
	            	<col width="5%"><col width="5%"><col width="5%"><col width="5%">
	            	<col width="5%">
	            </colgroup>
              <thead>
                <tr>
                	<th>人员</th><th>是否转正</th><th>加班小时</th><th>请假天数</th>
					<th>实际出勤</th><th>法定出勤</th><th>税金</th><th>状态</th>
					<th>录入人员</th>
                </tr>
              </thead>
              <tbody>
           			<c:if test="${fn:length(customerInfoKqs) == 0}">
							<tr>
								<td colspan="12" style="text-align: center">没有考勤信息</td>
							</tr>
						</c:if>
						<c:forEach items="${customerInfoKqs }" var="info">
							<tr item="${info.id }">
								<td item="${info.customerCode }"><c:forEach
										items="${customerinfos }" var="cs">
										<c:if test="${cs.customercode==info.customerCode }">
                   		${cs.customername }
                   		</c:if>
									</c:forEach></td>
								<td item="${info.ifZZ }">${info.ifZZ eq 1?'已转正':info.ifZZ eq 2?'未转正':info.ifZZ eq 3?'月内转正':'' }</td>
								<td item="${info.jbHover }">${info.jbHover }</td>
								<td item="${info.qjTime }">${info.qjTime }</td>
								<td item="${info.sjTime }">${info.sjTime }</td>
								<td item="${info.fdTime }">${info.fdTime }</td>
								<td item="${info.sj }">${info.sj }</td>
								<td item="${info.status }"><c:if test="${info.status==0 }">错误</c:if>
									<c:if test="${info.status==1 }">正确</c:if></td>
								<td>
									<c:forEach items="${users }" var="us">
										<c:if test="${us.usercode == info.usercode }">${us.realname }</c:if>
									</c:forEach>
								</td>
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