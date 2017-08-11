<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>公司月服务费查询</title>
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

<style type="text/css">
.zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
.search label {margin-left: 20px;}
.btn {display: inline-block;width: 50px;height: 30px;line-height: 21px;text-align: center;margin-left: 20px;}
.searchBth {color: #FFFFFF;background: #0F486E;}
.searchBth:hover {color: #F6F6F6;background: #125582;}
.searchBth:active {color: #F6F6F6;background: #206A9C;}
.zyh_txt {border-radius: 3px;padding-left: 5px;border: #F1F1F1 1px solid;width: 90px;height: 30px;font-size: 13px;color: #666;}
.zyh_btn_n {width: 50px;line-height: 30px;color: #fff;background-color: #0aa7e6;border: none;border-radius: 5px;margin-left: 8px;cursor: pointer;}
</style>
<script type="text/javascript">
 	function togetListBypage(page){
 		var corpcode = $('.search').find('select[name="corpcode"]').val();
		var yearstr = $('.search').find('input[name="yearstr"]').val();
		var monthstr = $('.search').find('select[name="monthstr"]').val();
	 	var url = "/servicepaysummary/actualpayment.do?page="+page+"&corpcode="+encodeURI(encodeURI($.trim(corpcode)))
		+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
		+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
		var corpcode = $('.search').find('select[name="corpcode"]').val();
		var yearstr = $('.search').find('input[name="yearstr"]').val();
		var monthstr = $('.search').find('select[name="monthstr"]').val();
	 	var url = "/servicepaysummary/actualpayment.do?page="+(page+1)+"&corpcode="+encodeURI(encodeURI($.trim(corpcode)))
		+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
		+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
		var corpcode = $('.search').find('select[name="corpcode"]').val();
		var yearstr = $('.search').find('input[name="yearstr"]').val();
		var monthstr = $('.search').find('select[name="monthstr"]').val();
	 	var url = "/servicepaysummary/actualpayment.do?page="+(page-1)+"&corpcode="+encodeURI(encodeURI($.trim(corpcode)))
		+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
		+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
	 	window.location.href=url;
	}
	function topageInfo(){
		var corpcode = $('.search').find('select[name="corpcode"]').val();
		var yearstr = $('.search').find('input[name="yearstr"]').val();
		var monthstr = $('.search').find('select[name="monthstr"]').val();
	 	var topage = $("#topage").val();
	 	var url = "/servicepaysummary/actualpayment.do?page="+topage+"&corpcode="+encodeURI(encodeURI($.trim(corpcode)))
			+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
			+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
		window.location.href=url;
	}
	$(function(){
		$('.searchBth').off('click').on('click',function(){
			var corpcode = $('.search').find('select[name="corpcode"]').val();
			var yearstr = $('.search').find('input[name="yearstr"]').val();
			var monthstr = $('.search').find('select[name="monthstr"]').val();
			if(yearstr!=null && yearstr>0){
				if(monthstr==null || monthstr==''){
					alert("请选择月份");
					return false;
				}
			}else{
				if(monthstr!=null && monthstr>0){
					alert("请输入年份");
					return false;
				}
			}
			var url = "/servicepaysummary/actualpayment.do?corpcode="+encodeURI(encodeURI($.trim(corpcode)))
			+"&yearstr="+encodeURI(encodeURI($.trim(yearstr)))
			+"&monthstr="+encodeURI(encodeURI($.trim(monthstr)));
			window.location.href=url;
		});
	});
	$(document).ready(function(){
		  initMemu(3,3);
	})
  </script>
</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	     	<a href="" title="月服务费查询" class="current">月服务费查询</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>月服务费查询</h5>
          </div>
          <div class="widget-content clearfix">
            	<div class="zyh_sos search">
					<span>公司：</span>
	                <select name="corpcode" style="text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:forEach items="${corplist}" var="corp">
							<option value="${corp.corpcode}" <c:if test="${corpCode==corp.corpcode}">selected="selected"</c:if>>${corp.corpname}</option>
						</c:forEach>
					</select> 
					<span>年：</span>
	                <input name="yearstr" value="${yearIndex==null||yearIndex==0?'':yearIndex}"  class="zyh_txt" /> 
	                <span>月：</span>
	                <select name="monthstr" style="width: 90px; text-align: center;border:1px solid #F1F1F1;height: 30px;">
						<option value="">--请选择--</option>
						<c:forEach begin="1" end="12" var="m">
							<option value="${m}" <c:if test="${m==monthIndex}">selected="selected"</c:if>>${m}月</option>
						</c:forEach>
					</select> 
					 <a class="btn searchBth zyh_btn_n" href="javascript:void(0)">搜索</a>
	            </div>
	            
	            
	            
            <table class="table table-bordered table-striped with-check">
	            <colgroup>
	            	<col width="10%"><col width="15%"><col width="15%"><col width="10%">
	            	<col width="10%"><col width="15%"><col width="10%"><col width="15%">
	            </colgroup>
              <thead>
                <tr>
                	<th>月份</th><th>客户名称</th><th>负责人</th>	<th>回款金额</th>
					<th>回款月份</th><th>收款帐号</th><th>回款时间</th><th>备注</th>
                </tr>
              </thead>
              <tbody>
           			<c:forEach items="${list}" var="info">
	    				<tr>
							<td><fmt:formatDate value="${info.PaymentDate}" pattern="yyyy-MM" /></td>
							<td>${info.CorpName}</td>
							<td>
									<c:forEach items="${payoperlist}" var="payoper">
										<c:if test="${payoper.CorpCode eq  info.CorpCode && info.ServicePayYearr eq  payoper.YearIndex && info.ServicePayMonth eq payoper.MonthIndex}">
												${payoper.realName}
										</c:if>
									</c:forEach>
							</td>
							<td>${info.Amount}</td>
							<td>${info.ServiceTitle }</td>
							<td>${info.AccountReceivable eq 1?'总公司': info.AccountReceivable eq  2?'分公司':info.AccountReceivable eq 3?'个人卡':''}</td>
							<td><fmt:formatDate value="${info.PaymentDate}" pattern="yyyy-MM-dd" /></td>
							<td>${info.FollowContent}</td>
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