<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>账号数量详情</title>
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
<link rel="stylesheet" href="/views/account/js/css/accounts.css">
<script src="/views/common/js/jquery.min.js" ></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>  
<script src="/views/common/js/bootstrap.min.js"></script> 
<script src="/views/common/js/matrix.js"></script> 
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<script type="text/javascript" src="/views/account/js/accounts.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(0,7);
})
function togetListBypage(page){
	var url = "/account/toAccount.do?page="+page;
	window.location.href=url;
}
function tonextpageInfo(page){
	var url = "/account/toAccount.do?page="+(page+1);
	window.location.href=url;
}
function toprevpageInfo(page){
	var url = "/account/toAccount.do?page="+(page-1);
	window.location.href=url;
}
function topageInfo(){
	var topage = $("#topage").val();
	var url = "/account/toAccount.do?page="+topage;
	window.location.href=url;
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
	     	<a href="" title="账号数量详情" class="current">账号数量详情</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>账号数量详情</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<select class="whh_sel allArea" style="display:none" >
                <c:forEach var="item"  items="${areasList}" >
               		<option value='${item.areaid}' >${item.areaname}</option>
                </c:forEach>
            </select>
		    <select class="whh_sel allResume" style="display:none">
	          <c:forEach var="item"  items="${resumeList}" >
           			<option value='${item.resumesourceid}' >${item.resumesourcename}</option>
              </c:forEach>
		    </select>
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>帐号</th><th>帐号地址</th><th>简历来源</th><th>开始时间</th>
				  <th>结束时间</th><th>简历份数</th><th style="width:110px;">操作</th>
                </tr>
              </thead>
              <tbody id="zh_body">
              	<c:if test="${fn:length(accountList) == 0}">
					<tr>
						<td colspan="12" style="text-align: center"></td>
					</tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${accountList}" varStatus="status">
					<tr aid="${item.aid }">
						<td>${item.account}</td>
						<td>${item.areaName}</td>
						<td>${item.resumesource}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.strarttime }" /></td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.endtime }" /></td>
						<td>${item.quantity}</td>
						<td><a href="javascript:void(0)" class="zh_edit">修改</a> <a
							href="javascript:void(0)" class="zh_delete">删除</a></td>
						<td style="display:none;">${item.accountCity}</td>	
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

	<%-- <div class="whh_wraper">
		<div class="whh_content whh_content_border">
			<h2 class="whh_h2_bg">
				<span>账号数量详情</span>
			</h2>
			<span class="add_btn">新增</span>
			<div class="whh_tab_bor">
				
					<select class="whh_sel allArea" style="display:none" >
                          <c:forEach var="item"  items="${areasList}" >
                           		<option value='${item.areaid}' >${item.areaname}</option>
                          </c:forEach>
                    </select>
				    <select class="whh_sel allResume" style="display:none">
				          <c:forEach var="item"  items="${resumeList}" >
                           		<option value='${item.resumesourceid}' >${item.resumesourcename}</option>
                          </c:forEach>
				    </select>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="whh_tab1">
					<colgroup>
						<col width="231px;" />
						<col width="119px;" />
						<col width="138px;" />
						<col width="219px;" />
						<col width="220px;" />
						<col width="100px;" />
						<col width="152px;" />
					</colgroup>
					<thead>
						<tr>
							<th>帐号</th>
							<th>帐号地址</th>
							<th>简历来源</th>
							<th>开始时间</th>
							<th>结束时间</th>
							<th>简历份数</th>
							<th style="width:110px;">操作</th>
							
						</tr>
					</thead>
					<tbody id="zh_body">
						<c:if test="${fn:length(accountList) == 0}">
							<tr>
								<td colspan="12" style="text-align: center"></td>
							</tr>
						</c:if>
						<c:forEach var="item" begin="0" items="${accountList}"
							varStatus="status">
							<tr aid="${item.aid }">
								<td>${item.account}</td>
								<td>${item.areaName}</td>
								<td>${item.resumesource}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${item.strarttime }" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${item.endtime }" /></td>
								<td>${item.quantity}</td>
								<td><a href="javascript:void(0)" class="zh_edit">修改</a> <a
									href="javascript:void(0)" class="zh_delete">删除</a></td>
								<td style="display:none;">${item.accountCity}</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
				 <!-- 页码部分-->
                <div class="od_pages clearfix">
                <div class="travels_diary_page">
                	<c:if test="${tatalpage>1 && currpage != 1}">
                		<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
                	</c:if>
                  <c:if  test="${tatalpage<=3}">
	                  <c:forEach var="item" begin="1" end="${tatalpage}" varStatus="status">
	                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
	                  </c:forEach>
                  </c:if>
                  <c:if  test="${tatalpage>3}">
                  		<c:if test="${currpage>=3}">
                  			<c:if test="${currpage==tatalpage}">
                  				<c:forEach var="item" begin="${currpage-2}" end="${currpage}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			<c:if test="${currpage!=tatalpage}">
                  				<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			
                  		</c:if>
                  		<c:if test="${currpage<3}">
	                  		<c:forEach var="item" begin="1" end="3" varStatus="status">
		                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
		                    </c:forEach>
	                    </c:if>
	                    <c:if test="${currpage != tatalpage}">
	                    	<span class="ellipsis">...</span>
	                    </c:if>
                  		
                  </c:if>
				  <c:if test="${tatalpage>1}">
				  		<c:if test="${currpage < tatalpage}">
				  			<span class="next_page" onclick="tonextpageInfo(${currpage})">下一页</span>
				  		</c:if>
	                  <span class="reach_desc">到</span>
	                  <input type="text" id="topage">
	                  <span class="confirm_btn" onclick="topageInfo()">确定</span>
				  </c:if>
                  
                </div>
              </div> 
			</div>
		</div>
	</div> --%>
</body>


</html>