<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>外派公司详情</title>
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
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(3,0);
})
</script>
</head>
<style>
.zyh_rated_btn {
	width: 100px;
	height: 36px;
	background-color: #007ADF;
	border: none;
	color: #fff;
	border-radius: 3px;
	display: inline-block;
	line-height: 36px;
	margin-top: 20px;
	margin-bottom: 20px;
	font-size: 16px;
}

.add_btn {
	display: block;
	width: 60px;
	height: 30px;
	line-height: 30px;
	background: #51c51e;
	color: #F6F6F6;
	text-align: center;
	position: absolute;
	top: 0px;
	right: 0px;
	margin-top: 11px;
	margin-right: 31px;
	border-radius: 3px;
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
	-khtml-user-select: none;
	user-select: none;
	cursor: pointer;
}

.add_btn:hover {
	background: #81DC57;
}

.add_btn:active {
	background: #6BB14B;
}
.btn {
	display: block;
    width: 46px;
    height: 24px;
    line-height: 24px;
    text-align: center;
    border-radius: 3px;
    position: absolute;
    cursor: pointer;
}
.save_btn {
	background: #FD5252;
	color: #F6F6F6;
    margin-left: 40px;
    margin-top: -11px;
}
.repeal_btn {
	background: #51C51E;
	color: #F6F6F6;
    margin-left: 98px;
    margin-top: -11px;
}
.save_btn:active {
    background: #F53636;
}
</style>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<input id="cid" hidden value="${cid }">
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	    	<a href="index.html" title="服务费核算设置" class="tip-bottom"><i class="icon-home"></i>服务费核算设置</a>
	     	<a href="" title="外派公司详情" class="current">外派公司详情</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>外派公司详情</h5>
            <span class="add_btn">新增</span>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
	            </colgroup>
              <thead>
                <tr><th>外派公司名称</th><th>开始时间</th><th>结束时间</th><th>项目详情</th></tr>
              </thead>
              <tbody  id="wpDetails">
           			<c:forEach items="${list }" var="c">
						<tr id="${c.id }">
							<td>${c.corpName }</td>
							<td>${c.startTime }</td>
							<td>${c.endTime }</td>
							<td><a href="javascript:void(0);" corpCode="${c.corpCode }" class="viewBtn">查看</a></td>
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
<script type="text/javascript"
	src="/views/customerCompany/js/serverMoneyEdit.js"></script>
<script type="text/javascript">
	var cid = $('#cid').val();
	function togetListBypage(page){
		var url = "/paydetail/queryOutCompany.do?page="+page+"&cid="+cid;
		window.location.href=url;
	}
	function tonextpageInfo(page){
		var url = "/paydetail/queryOutCompany.do?page="+(page+1)+"&cid="+cid;
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
	 	var url = "/paydetail/queryOutCompany.do?page="+(page-1)+"&cid="+cid;
	 	window.location.href=url;
	}
	function topageInfo(){
	 	var topage = $("#topage").val();
	 	var url = "/paydetail/queryOutCompany.do?page="+topage+"&cid="+cid;
	 	window.location.href=url;
	}
</script>
</html>