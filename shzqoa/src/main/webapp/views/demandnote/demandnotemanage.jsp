<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>帖子管理</title>
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
  
  <script src="/views/common/js/jquery.validate.js"></script>
  <style type="text/css" rel="stylesheet">
	.whh_input{width:100px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  var customerdemandid = $("#customerdemandid").val();
	  var workdemandid = $("#workdemandid").val();	
	  var url = "/demandnote/toDemandNoteAdd.do?";
	  if(customerdemandid!=null && customerdemandid!=""){
		  url += "&customerdemandid="+encodeURI(encodeURI($.trim(customerdemandid)));
		  initMemu(1,4);  
	  }
	  if(workdemandid!=null && workdemandid!=""){
		  url += "&workdemandid="+encodeURI(encodeURI($.trim(workdemandid)));
		  initMemu(8,3);  
	  }
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '需求帖子信息',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['900px' , '324px'],
				content:url
		    })
		})
  })
  function editInfo(demandnoteid){
	  layer.open({
	        type: 2,
	        title: '需求帖子信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '324px'],
	        content: '/demandnote/toEditInfo.do?demandnoteid='+demandnoteid
	    })
  }
  function daystaAdd(demandnoteid){
	  layer.open({
	        type: 2,
	        title: '帖子统计信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '220px'],
	        content: '/demandnotestatistics/toNoteStatisticsAdd.do?demandnoteid='+demandnoteid
	    })
	  
  }
  
  function daystalist(demandnoteid){
	  layer.open({
	        type: 2,
	        title: '帖子统计列表信息',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['900px' , '510px'],
	        content: '/demandnotestatistics/toNoteStatisticsList.do?demandnoteid='+demandnoteid
	    })
  }
  function searchByCon(){
	  var customerdemandid = $("#customerdemandid").val();
	  var workdemandid = $("#workdemandid").val();	  
	  var noteaddpeople = $("#addpeople").val();
	  var notename = $("#notename").val();
	  var url = "/demandnote/toDemanNoteList.do?page=1";
	  if(customerdemandid!=null && customerdemandid!=""){
		  url += "&customerdemandid="+encodeURI(encodeURI($.trim(customerdemandid)));
	  }
	  if(workdemandid!=null && workdemandid!=""){
		  url += "&workdemandid="+encodeURI(encodeURI($.trim(workdemandid)));
	  }
	  if(noteaddpeople!=null && noteaddpeople!=""){
		  url += "&noteaddpeople="+encodeURI(encodeURI($.trim(noteaddpeople)));
	  }
	  if(notename!=null && notename!=""){
		  url += "&notename="+encodeURI(encodeURI($.trim(notename)));
	  }
	  window.location.href=url;
  }
  
  function togetListBypage(page){
	  var customerdemandid = $("#customerdemandid").val();
	  var workdemandid = $("#workdemandid").val();	  
	  var noteaddpeople = $("#addpeople").val();
	  var notename = $("#notename").val();
  	  var url = "/demandnote/toDemanNoteList.do?page="+page;
  	  if(customerdemandid!=null && customerdemandid!=""){
		  url += "&customerdemandid="+encodeURI(encodeURI($.trim(customerdemandid)));
	  }
	  if(workdemandid!=null && workdemandid!=""){
		  url += "&workdemandid="+encodeURI(encodeURI($.trim(workdemandid)));
	  }
	  if(noteaddpeople!=null && noteaddpeople!=""){
		  url += "&noteaddpeople="+encodeURI(encodeURI($.trim(noteaddpeople)));
	  }
	  if(notename!=null && notename!=""){
		  url += "&notename="+encodeURI(encodeURI($.trim(notename)));
	  }
  	  window.location.href=url;
  }
  function tonextpageInfo(page){
	  var customerdemandid = $("#customerdemandid").val();
	  var workdemandid = $("#workdemandid").val();	  
	  var noteaddpeople = $("#addpeople").val();
	  var notename = $("#notename").val();
  	  var url = "/demandnote/toDemanNoteList.do?page="+(page+1);
  	if(customerdemandid!=null && customerdemandid!=""){
		  url += "&customerdemandid="+encodeURI(encodeURI($.trim(customerdemandid)));
	  }
	  if(workdemandid!=null && workdemandid!=""){
		  url += "&workdemandid="+encodeURI(encodeURI($.trim(workdemandid)));
	  }
	  if(noteaddpeople!=null && noteaddpeople!=""){
		  url += "&noteaddpeople="+encodeURI(encodeURI($.trim(noteaddpeople)));
	  }
	  if(notename!=null && notename!=""){
		  url += "&notename="+encodeURI(encodeURI($.trim(notename)));
	  }
  	  window.location.href=url;
  }
  function toprevpageInfo(page){
	  var customerdemandid = $("#customerdemandid").val();
	  var workdemandid = $("#workdemandid").val();	  
	  var noteaddpeople = $("#addpeople").val();
	  var notename = $("#notename").val();
  	  var url = "/demandnote/toDemanNoteList.do?page="+(page-1);
  	  if(customerdemandid!=null && customerdemandid!=""){
		  url += "&customerdemandid="+encodeURI(encodeURI($.trim(customerdemandid)));
	  }
	  if(workdemandid!=null && workdemandid!=""){
		  url += "&workdemandid="+encodeURI(encodeURI($.trim(workdemandid)));
	  }
	  if(noteaddpeople!=null && noteaddpeople!=""){
		  url += "&noteaddpeople="+encodeURI(encodeURI($.trim(noteaddpeople)));
	  }
	  if(notename!=null && notename!=""){
		  url += "&notename="+encodeURI(encodeURI($.trim(notename)));
	  }
  	  window.location.href=url;
  }
  
  

  
  function delInfo(demandnoteid){
	  if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/demandnote/delInfoById.do",
		          data: {"demandnoteid":demandnoteid},
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
  function closeInfo(demandnoteid){
	  if (confirm("确定要关闭么?"))  {
			$.ajax({
		          type: "post",
		          url: "/demandnote/closeInfoById.do",
		          data: {"demandnoteid":demandnoteid},
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
  function checkdaynst(demandnoteid){
	  if (confirm("该申请信息确定要通过?"))  {
			$.ajax({
		          type: "post",
		          url: "/demandnote/checkInfoById.do",
		          data: {"demandnoteid":demandnoteid},
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
  </script>
  
 </head>
 <body>
 <if test="${customerdemandid!=null && customerdemandid!=''}">
 	<input type="hidden" id="customerdemandid" value="${customerdemandid}">
 </if>
  <if test="${workdemandid!=null && workdemandid!=''}">
 	<input type="hidden" id="workdemandid" value="${workdemandid}">
 </if>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<c:if test="${workdemandid!=null && workdemandid!=''}">
	    		<a href="" title="招聘管理" class="tip-bottom"><i class="icon-home"></i>招聘管理</a>
	     		<a href="" title="普工项目管理" class="tip-bottom"><i class="icon-tags"></i>普工项目管理</a>
	    	</c:if>
	    	<c:if test="${customerdemandid!=null && customerdemandid!=''}">
	    		<a href="" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
	     		<a href="" title="需求分配" class="tip-bottom"><i class="icon-tags"></i>需求分配</a>
	    	</c:if>
	     	<a href="" title="需求帖子" class="current">需求帖子</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求帖子</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
          	<!--查询条件-begin-->
            <div class="widget-search">
                <span>姓名：
                	<select id="addpeople" class="whh_input">
                		<option value="">请选择</option>
                		<c:forEach items="${userlist}" var="useritem">
                			<option value="${useritem.usercode}" <c:if test="${noteaddpeople eq useritem.usercode}">selected</c:if>>${useritem.realname}</option>
                		</c:forEach>
                	</select>
                </span>
                <span>名称：<input type="text" class="zyh_txt whh_input"  id="notename"  value="${notename}"></span>
                <button class="btn btn-info" onclick="searchByCon()">查询</button>
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>简历需求</th><th>客户公司</th>
                  <th>普工需求</th><th>厂区</th><th>帖子来源</th>
                  <th>帖子名称</th><th>发贴时间</th><th>发帖人</th>
                  <th>日浏览量</th><th>总浏览量</th><th>状态</th><th>操作</th>             
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">没有需求帖子信息</td></tr>
				</c:if>
				<c:forEach var="item" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td>${item.Projecttype}</td><td>${item.CorpName}</td>
	                  	   <td>${item.Name}-${item.WorkPost}</td><td>${item.Name}</td>
	                  	   <td>
		                  	   	<c:forEach items="${notesourcelist}" var="paritem">
		                  	   		<c:if test="${paritem.id eq item.NoteSourceId}">${paritem.name }</c:if>
		                		</c:forEach>	
	                  	   </td>
	                  	   <td>${item.NoteName}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.NoteAddTime}"/></td>
	                  	   <td>
	                  	   		<c:forEach items="${userlist}" var="paritem">
		                  	   		<c:if test="${paritem.usercode eq item.NoteAddPeople}">${paritem.realname }</c:if>
		                		</c:forEach>
	                  	   	
	                  	   </td>
	                  	   <td>${item.DayPageView}</td>
	                  	   <td>${item.AllPageView}</td>
	                  	   
	                  	   <td>${item.NoteStatus==1?'正常':item.NoteStatus==2?'待关闭':item.NoteStatus==3?'关闭':''}</td>
		                   <td>
		                   		
		                   		<div class="dropdown">
		                   			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										更多
										<b class="caret"></b>
									</a>
									<ul class="dropdown-menu">
										<li><a href="javascript:void(0);" onclick="daystalist('${item.DemandNoteId}')">日统计</a></li>
										<c:if test="${sessionScope.user.usercode eq item.NoteAddPeople}">
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="editInfo('${item.DemandNoteId}')" >修改</a></li>
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="delInfo('${item.DemandNoteId}')">删除</a></li>
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="closeInfo('${item.DemandNoteId}')">关闭</a></li>
										</c:if>
										<c:if test="${xzflag==1}">
											<li class="divider"></li>
											<li><a href="javascript:void(0);" onclick="daystaAdd('${item.DemandNoteId}')">统计</a></li>
											<c:if test="${item.NoteStatus == 2}">
												<li class="divider"></li>
												<li><a href="javascript:void(0);" onclick="checkdaynst('${item.DemandNoteId}')">审核通过</a></li>
											</c:if>
										</c:if>
										
									</ul>
								</div>
								
								
								
		                   </td>
		                   
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
</body>
</html>