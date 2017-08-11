<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>添加合作公司</title>
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
 <script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script>
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
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
	  var Num="hzgs-"; 
	  for(var i=0;i<6;i++){
		  Num += Math.floor(Math.random()*10); 
	  }
	  
	  $("#corpCode").val(Num);
	  if($('#currpage').val()==1 && $('#cp').val()>=1){
		  layer.open({
			  type: 2,
			  title: '提示信息',
			  area: ['600px', '600px'],
			  skin: 'layui-layer-rim',
			  content: '/corp/overdueCue.do' 
			}); 
	  }
	  
  })
  function addCorp(){
	  var corpCode = $("#corpCode").val();
	  var corpName = $("#corpName").val();
	  var starttime = $("#starttime").val();
	  var endtime = $("#endtime").val();
	  if(corpCode == null || corpCode == ''){
		  alert("公司编号不能为空");
		  return false;
	  }
	  if(corpName == null || corpName == ''){
		  alert("公司名称不能为空");
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
	  var start=$("#starttime").val();                                              //用JQuery从页面去的时间值
	   var end=$("#endtime").val();
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
	     alert("开始日期不能在结束日期之后！");
	     return false;
	    }
	   }
	  var data = {
			 "corpCode": corpCode,
			 "corpName":corpName,
			 "starttime": starttime,
			 "endtime": endtime,
	  }
	  $.ajax({
          type: "post",
          url: "/corp/saveCorp.do",
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
  function getCorpProject(corpcode){
	  var url = "/corpProject/toCorpProjectList.do?corpCode="+encodeURI(encodeURI($.trim(corpcode)));
	  window.location.href=url;
  }
  function getcorpcontant(corpcode){
	  var url = "/corpProject/togetcorpcontantList.do?corpCode="+corpcode;
	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var seaCorpName = $("#seaCorpName").val();
	  var seaCorpStatus = $("#seaCorpStatus").val();
  	var url = "/corp/toAddCorp.do?page="+page;
  	 if(seaCorpName!=null && seaCorpName!=""){
		  url += "&seaCorpName="+seaCorpName;
	  }
	  if(seaCorpStatus!=null && seaCorpStatus!=""){
		  url += "&seaCorpStatus="+seaCorpStatus;
	  }
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var seaCorpName = $("#seaCorpName").val();
	  var seaCorpStatus = $("#seaCorpStatus").val();
  	var url = "/corp/toAddCorp.do?page="+(page+1);
  	 if(seaCorpName!=null && seaCorpName!=""){
		  url += "&seaCorpName="+seaCorpName;
	  }
	  if(seaCorpStatus!=null && seaCorpStatus!=""){
		  url += "&seaCorpStatus="+seaCorpStatus;
	  }
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var seaCorpName = $("#seaCorpName").val();
	  var seaCorpStatus = $("#seaCorpStatus").val();
  	var url = "/corp/toAddCorp.do?page="+(page-1);
  	 if(seaCorpName!=null && seaCorpName!=""){
		  url += "&seaCorpName="+seaCorpName;
	  }
	  if(seaCorpStatus!=null && seaCorpStatus!=""){
		  url += "&seaCorpStatus="+seaCorpStatus;
	  }
  	window.location.href=url;
  }
  function topageInfo(){
	  var seaCorpName = $("#seaCorpName").val();
	  var seaCorpStatus = $("#seaCorpStatus").val();
  	var topage = $("#topage").val();
  	var url = "/corp/toAddCorp.do?page="+topage;
  	 if(seaCorpName!=null && seaCorpName!=""){
		  url += "&seaCorpName="+seaCorpName;
	  }
	  if(seaCorpStatus!=null && seaCorpStatus!=""){
		  url += "&seaCorpStatus="+seaCorpStatus;
	  }
  	window.location.href=url;
  }
  function searchByCon(){
	  var seaCorpName = $("#seaCorpName").val();
	  var seaCorpStatus = $("#seaCorpStatus").val();
	  var url = "/corp/toAddCorp.do?page=1";
	  if(seaCorpName!=null && seaCorpName!=""){
		  url += "&seaCorpName="+seaCorpName;
	  }
	  if(seaCorpStatus!=null && seaCorpStatus!=""){
		  url += "&seaCorpStatus="+seaCorpStatus;
	  }
	  window.location.href=url;
  }
  function getCloseCorp(corpcode){
	  layer.open({
		  type: 2,
		  title: '关闭原因',
		  area: ['800px', '350px'],
		  skin: 'layui-layer-rim',
		  content: '/corp/toCloseCorp.do?corpcode='+corpcode 
		}); 
  }
  
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <input type="hidden" value="${currpage }" id="currpage" />
  <input type="hidden" value="${fn:length(cp) }" id="cp" />
  
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
     	<a href="" title="合作公司管理" class="current">合作公司管理</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>合作公司管理</h5>
          </div>
          <div class="widget-content clearfix">
          <!--查询条件-begin-->
            <div class="widget-search">
                <span>公司名称：<input type="text" class="zyh_txt whh_input"  id="seaCorpName"  value="${seaCorpName}"></span>
                <span>状态：
                	<select id="seaCorpStatus" class="whh_input">
                		<option value="" <c:if test="${seaCorpStatus==null}">selected</c:if>>请选择</option>
                		<option value="1" <c:if test="${seaCorpStatus==1}">selected</c:if>>正常</option>
                		<option value="2" <c:if test="${seaCorpStatus==2}">selected</c:if>>关闭</option>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
          
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>公司名称</th><th>合作开始时间</th>
                  <th>合作结束时间</th><th>状态</th><th>关闭原因</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有合作公司信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
		                   <td width="25%"><a href="javascript:void(0);" onclick="getCorpProject('${item.corpcode}')" class="font_orange">${item.corpname}</a></td>
		                   <td width="10%"><fmt:formatDate pattern="yyyy/MM/dd" value="${item.starttime}" /></td>
		                   <td width="10%"><fmt:formatDate pattern="yyyy/MM/dd" value="${item.endtime}"/></td>
		                   <td>${item.corpStatus==null?'正常':item.corpStatus==1?'正常':item.corpStatus==2?'关闭':''}</td>
		                   <td  width="30%">${item.closeReason}</td>
		                   <td>
			                   	<input type="button" value="项目管理" onclick="getCorpProject('${item.corpcode}')"/>&nbsp;
			                   	<input type="button" onclick="getcorpcontant('${item.corpcode}')" value="联系人管理"/>&nbsp;
			                   	<c:if test="${item.corpStatus ne 2}">
			                   		<input type="button" value="关闭" onclick="getCloseCorp('${item.corpcode}')"/>
			                   	</c:if>
		                   </td>
		                   
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
                <c:if test="${tatalpage>=currpage}">
                	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                </c:if>
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
            	<span>公司编码：</span>
                <input type="text" class="whh_input" id="corpCode" disabled="true">
            	<span>公司名称：</span>
                <input type="text" class="whh_input" id="corpName" placeholder="输入公司名称"> <br/>	<br/>
        		<span> 开始时间： </span>
                <input type="text" class="whh_input" placeholder="请输入开始时间" id="starttime" onclick="WdatePicker()" readonly/>
                <span>结束时间：</span>
               <input type="text" class="whh_input" placeholder="请输入结束时间" id="endtime" onclick="WdatePicker()" readonly/>	
                
                <input type="button" class="zyh_btn" onclick="addCorp()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>
</body>
</html>