<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>普工项目管理</title>
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
 
  <style type="text/css" rel="stylesheet">
	.whh_input{width:100px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(8,3);
	  $(".table").bootstrapTable({
		  fixedColumns:true,
		  fixedNumber:2
	  });
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '普工项目信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '650px'],
				content:'/workdemand/toWorkDemandAdd.do'
		    })
		})
  })
  function editInfo(demandId){
	  layer.open({
	        type: 2,
	        title: '普工项目信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '650px'],
	        content: '/workdemand/toEditWorkDemand.do?demandId='+demandId
	    })
  }
  function searchByCon(){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
	  var url = "/workdemand/toWorkDemandList.do?page=1";
	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+page;
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+(page+1);
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+(page-1);
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  function topageInfo(){
	  var workArea = $("#workArea").val();
	  var workPost = $("#workPost").val();	  
	  var demandStatus = $("#demandStatus").val();
  	  var topage = $("#topage").val();
  	  var url = "/workdemand/toWorkDemandList.do?page="+topage;
  	  if(workArea!=null && workArea!=""){
		  url += "&workArea="+encodeURI(encodeURI($.trim(workArea)));
	  }
	  if(workPost!=null && workPost!=""){
		  url += "&workPost="+encodeURI(encodeURI($.trim(workPost)));
	  }
	  if(demandStatus!=null && demandStatus!=""){
		  url += "&demandStatus="+encodeURI(encodeURI($.trim(demandStatus)));
	  }
  	  window.location.href=url;
  }
  

  
  function delInfo(demandId){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/workdemand/delWorkDemandById.do",
		          data: {"demandId":demandId},
		          dataType: "json",
		          success: function(result){
		         	 if(result.success == true){
		         		 alert(result.resultMessage);
		         		 parent.location.reload();
		         	 }else{
		         		 alert(result.resultMessage);
		         	 }
		          }
		      });
		}
  }
  function workerlist(demandId){
	  layer.open({
	        type: 2,
	        title: '普工人员列表信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['946px' , '650px'],
			content:'/workdemand/demandWorkerList.do?demandId='+demandId
	    })
  }
  function showrecruitment(obj){
	  var recruitment = $(obj).parent().find("textarea[name='recruitment']").text();
	  $("#selrecruitment").text(recruitment)
	  layer.open({
		  type: 1,
		  title: false,
		  closeBtn: 0,
		  shadeClose: true,
// 		  skin: 'yourclass',
		  area: ['1000px', '650px'],
		  content: $('#selrecruitment')
		});
  }
  function demandnotelsit(id){
		 var url =  "/demandnote/toDemanNoteList.do?workdemandid="+encodeURI(encodeURI(id.trim()));
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
	    	<a href="index.html" title="招聘管理" class="tip-bottom"><i class="icon-home"></i>招聘管理</a>
	     	<a href="" title="普工项目管理" class="current">普工项目管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>普工项目管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>工作地点：
                	<select id="workArea" class="whh_input">
                		<option value="" <c:if test="${workArea==null}">selected</c:if>>请选择</option>
                         <c:forEach var="item" items="${zonelist}" varStatus="status">
		                     <option value="${item.areaid}" <c:if test="${workArea==item.areaid}">selected</c:if>>${item.areaname}</option>
		                  </c:forEach>
                	</select>
                </span>
                <span>工作岗位：<input type="text" class="zyh_txt whh_input"  id="workPost"  value="${workPost}"></span>
                <span>状态：
                	<select id="demandStatus" class="whh_input">
                		<option value="" <c:if test="${demandStatus==null}">selected</c:if>>请选择</option>
                		<option value="1" <c:if test="${demandStatus==1}">selected</c:if>>正常</option>
                		<option value="2" <c:if test="${demandStatus==2}">selected</c:if>>关闭</option>
                	</select>
                </span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <div style="width:100%;overflow:auto;">
            <table class="table table-bordered table-striped with-check" style="width:2300px;">
              <colgroup>
                  <col style="width:1%;"><col style="width:3%;"><col style="width:3%;">
                  <col style="width:3%;"><col style="width:4%;"><col style="width:2%;">
                  <col style="width:2%;"><col style="width:2%;"><col style="width:2%;">
                  <col style="width:2%;"><col style="width:3%;"><col style="width:7%;">
                  <col style="width:24%;"><col style="width:20%;"><col style="width:8%;">
                  <col style="width:2%;"> <col style="width:1%;"><col style="width:7%;">
              </colgroup>
              <thead>
                <tr>
                  <th>#</th><th>工厂</th><th>对接公司</th>
                  <th>工作岗位</th><th>工作内容</th><th>工作地点</th>
                  <th>返费</th><th>月薪</th><th>加班费</th>
                  <th>餐补</th><th>住宿</th><th>交通补助</th>
                  <th>福利待遇</th><th>录取短信</th><th>夜班情况</th>
                  <th>驻厂老师</th><th>状态</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(demandllist) == 0}">
					<tr><td colspan="12" style="text-align: center">没有普工项目信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${demandllist}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>
	                  	   		<c:forEach var="paritem" items="${factorylist}">
	                  	   			<c:if test="${paritem.id eq item.factoryId}">
	                  	   				<a href="javascript:void(0);" onclick="showrecruitment(this)">${paritem.name}</a>
	                  	   				<textarea name="recruitment" style="display:none;">
	                  	   					${item.recruitment}
	                  	   				</textarea>
	                  	   			</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td>
	                  	   		<c:forEach var="paritem" items="${dockcompanylist}">
	                  	   			<c:if test="${paritem.id eq item.dockCompany}">${paritem.name}</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td>${item.workPost}</td><td>${item.workContent}</td>
	                  	   <td>
	                  	   		<c:forEach var="paritem" items="${zonelist}">
	                  	   			<c:if test="${paritem.areaid eq item.workArea}">${paritem.areaname}</c:if>
				                </c:forEach>
	                  	   </td>
	                  	   <td><fmt:formatNumber type="number" pattern="0.00" value="${item.hourlyWage}" maxFractionDigits="2" /></td>
						   <td><fmt:formatNumber type="number" pattern="0.00" value="${item.monthWage}" maxFractionDigits="2"/></td>
	                  	   <td><fmt:formatNumber type="number" value="${item.overtimePay}" pattern="0.00" maxFractionDigits="2"/></td> 
						   <td><fmt:formatNumber type="number" pattern="0.00" value="${item.mealSupplement}" maxFractionDigits="2"/></td>
	                  	   <td>${item.accommodation}</td><td>${item.transportationAllowance}</td>
	                  	   <td>${item.fringeBenefit}</td><td>${item.otherSubsidies}</td>
	                  	   <td>${item.reMark}</td><td>${item.residentTeacher}</td>
		                   <td>${item.demandStatus == 1 ?'正常':item.demandStatus == 2 ?'关闭':''}</td>
		                   <td>
								<div class="dropdown">
		                   			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										更多
										<b class="caret"></b>
									</a>
									<ul class="dropdown-menu">
											<li><a href="javascript:void(0);" onclick="editInfo('${item.demandId}')" >修改</a></li>
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="delInfo('${item.demandId}')">删除</a></li>
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="workerlist('${item.demandId}')">普工</a></li>
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="demandnotelsit('${item.demandId}')">帖子</a></li>
										
									</ul>
								</div>
		                   </td>
	                  </tr>
                 </c:forEach>
              </tbody>
            </table>
            </div>
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

<textarea id="selrecruitment" style="width:1000px;height:650px;display:none;">
</textarea>
</body>
</html>