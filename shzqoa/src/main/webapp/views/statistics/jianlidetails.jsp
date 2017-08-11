<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	overflow: hidden;
	margin-bottom: 10px;
}

.zyh_sos span, .zyh_txt, .zyh_btn {
	float: left;
	line-height: 30px;
}

.zyh_sos span {
	margin-left: 10px;
}

.zyh_txt {
	border-radius: 3px;
	padding-left: 5px;
	border: #F1F1F1 1px solid;
	width: 90px;
	height: 30px;
}

.zyh_btn {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
}

.zyh_sel {
	float: left;
	margin-top: 2px;
	height: 25px;
}

.a:HOVER {
	color: blue;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(2,1);
})
</script>

</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="信息绩效统计" class="tip-bottom"><i class="icon-home"></i>信息绩效统计</a>
	    	<a href="index.html" title="绩效信息详情" class="tip-bottom"><i class="icon-home"></i>绩效信息详情</a>
	     	<a href="" title="操作员简历详情" class="current">操作员简历详情</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>操作员简历详情</h5>
          </div>
          <div class="widget-content clearfix">
            <input type="hidden" id="opertCode" value="${opertcode}"/>
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="10%"><col width="10%"><col width="10%"><col width="50%"><col width="10%">
	            </colgroup>
              <thead>
                <tr><th>简历来源</th><th>统计</th></tr>
              </thead>
              <tbody>
           			<c:forEach var="count" items="${jianLiDetails }">
						<tr>
							<td>
							<c:choose>
										<c:when test="${count.resumeSource == 0}">未选择简历来源</c:when>
										<c:when test="${count.resumeSource == 1}">51job</c:when>
										<c:when test="${count.resumeSource == 2}">智联招聘</c:when>
										<c:when test="${count.resumeSource == 4}">BOSS直聘</c:when>
										<c:when test="${count.resumeSource == 5}">第三方简历</c:when>
										<c:when test="${count.resumeSource == 3}">其他</c:when>
									</c:choose>
							</td>
							<td>${count.jlCount }</td>
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