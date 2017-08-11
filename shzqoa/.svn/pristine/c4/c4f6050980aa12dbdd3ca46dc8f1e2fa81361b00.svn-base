<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>服务费核算</title>
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
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
<script type="text/javascript">
 	function togetListBypage(page){
		var customername = $('.search').find('input[name="customername"]').val();
		var customersex = $('.search').find('select[name="customersex"]').val();
	 	var url = "/customerDatailInfo/queryCustomerDetails.do?page="+page+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
		var customername = $('.search').find('input[name="customername"]').val();
		var customersex = $('.search').find('select[name="customersex"]').val();
	 	var url = "/customerDatailInfo/queryCustomerDetails.do?page="+(page+1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
		var customername = $('.search').find('input[name="customername"]').val();
		var customersex = $('.search').find('select[name="customersex"]').val();
	 	var url = "/customerDatailInfo/queryCustomerDetails.do?page="+(page-1)+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
	 	window.location.href=url;
	}
	function topageInfo(){
		var customername = $('.search').find('input[name="customername"]').val();
		var customersex = $('.search').find('select[name="customersex"]').val();
	 	var topage = $("#topage").val();
	 	var url = "/customerDatailInfo/queryCustomerDetails.do?page="+topage+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
		window.location.href=url;
	}
	function customerEdit(cid){
		var customername = $('.search').find('input[name="customername"]').val();
		var customersex = $('.search').find('select[name="customersex"]').val();
		window.location.href="/paydetail/queryOutCompany.do?cid="+cid+"&customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
	}
	$(function(){
		$('.searchBth').off('click').on('click',function(){
			var customername = $('.search').find('input[name="customername"]').val();
			var customersex = $('.search').find('select[name="customersex"]').val();
			window.location.href="/customerDatailInfo/queryCustomerDetails.do?customername="+encodeURI(encodeURI($.trim(customername)))+"&customersex="+$.trim(customersex);
		});
	});
	$(document).ready(function(){
	  	  initMemu(3,0);
    })
  </script>
<style type="text/css">
.zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
.search {
	/*position: absolute;
	right: 80px;
	top: 15px;*/
}

.search label {
	margin-left: 20px;
}

.btn {
	display: inline-block;
	width: 50px;
	height: 30px;
	line-height: 21px;
	text-align: center;
	margin-left: 20px;
}

.searchBth {
	color: #FFFFFF;
	background: #0F486E;
}

.searchBth:hover {
	color: #F6F6F6;
	background: #125582;
}

.searchBth:active {
	color: #F6F6F6;
	background: #206A9C;
}
.zyh_txt {
	border-radius: 3px;
	padding-left: 5px;
	border: #F1F1F1 1px solid;
	width: 90px;
	height: 30px;
	font-size: 13px;
	color: #666;
}
.zyh_btn_n {
    width: 50px;
    line-height: 30px;
    color: #fff;
    background-color: #0aa7e6;
    border: none;
    border-radius: 5px;
    margin-left: 8px;
    cursor: pointer;
}
</style>
</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	     	<a href="" title="服务费核算设置" class="current">服务费核算设置</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>服务费核算设置</h5>
          </div>
          <div class="widget-content clearfix">
            <div class="zyh_sos search">
	            	<span>姓名：</span>
	                <input name="customername" value="${customername }"  class="zyh_txt" /> 
					<span>性别：</span> 
					<select name="customersex" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:choose>
							<c:when test="${customersex ne '' && customersex eq 0}">
								<option value="0" selected="selected">男</option>
							</c:when>
							<c:otherwise>
								<option value="0">男</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${customersex ne '' && customersex eq 1}">
								<option value="1" selected="selected">女</option>
							</c:when>
							<c:otherwise>
								<option value="1">女</option>
							</c:otherwise>
						</c:choose>
					</select>
					 <a class="btn searchBth zyh_btn_n" href="javascript:void(0)">搜索</a>
	            </div>
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
	            </colgroup>
              <thead>
                <tr><!-- <th>客户编号</th> --><th>姓名</th><th>性别</th><th>出生日期</th><th>外派情况</th></tr>
              </thead>
              <tbody>
           			<c:forEach items="${list }" var="c">
							<tr>
								<!-- <td>${c.customercode }</td> -->
								<td width="25%"><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${c.customercode }">${c.customername }</a></td>
								<td width="25%">${c.customersex eq 0?"男":"女" }</td>
								<td width="25%"><fmt:formatDate pattern="yyyy-MM-dd"
										value="${c.customerbirth }" /></td>
								<td><a href="javascript:void(0)"
									onclick="customerEdit('${c.customercode }')">查看</a></td>
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