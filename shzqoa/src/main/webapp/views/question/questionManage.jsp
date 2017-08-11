<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>问题管理</title>
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
<style type="text/css">
	.zyh_btn{wdth:30px;height:30px;font-size:16px;background-color:#009FE8;border:none;color:#fff;}
	.zyh_sos{margin: 0 auto;width: 700px;}
</style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(4,2);
	  $('.layer_tj').on('click', function(){
		    layer.open({
		        type: 2,
		        title: '添加问题',
		        maxmin: true,
				scrollbar: false,
		        shadeClose: true, //点击遮罩关闭层
		        area : ['800px' , '427px'],
		        content: '/question/toAddQuestion.do'
		    })
		})
  })
  function togetListBypage(page){
  	var url = "/question/toQuestionList.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/question/toQuestionList.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/question/toQuestionList.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/question/toQuestionList.do?page="+topage;
  	window.location.href=url;
  }
  function delInfoById(questionId){
		if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/question/delQuestionById.do",
		          data: {"questionId":questionId},
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
  }
  function editInfo(questionId){
	  layer.open({
	        type: 2,
	        title: '编辑问题',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '427px'],
	        content: '/question/toEditQuestion.do?questionId='+questionId
	    })
  }
  function followInfoById(questionId){
	  layer.open({
	        type: 2,
	        title: '跟踪问题',
	        maxmin: true,
			scrollbar: false,
	        shadeClose: true, //点击遮罩关闭层
	        area : ['800px' , '408px'],
	        content: '/question/toFollowQuestion.do?questionId='+questionId
	    })
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
     	<a href="" title="问题管理" class="current">问题管理</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>问题管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj">添加</button>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>问题提出人</th><th>提出时间</th><th>问题描述</th>
                  <th>责任人</th><th>紧急程度</th><th>预计解决时间</th><th>实际解决时间</th>
                  <th>跟踪情况</th><th>跟踪时间</th><th>是否解决</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr><td colspan="12" style="text-align: center">没有问题信息</td></tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td><td>${item.ProblemMaker}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.ReflectProblemTime }" /></td>
	                  	   <td>${item.QuestionContent}</td>
	                  	   <td>
	                  	   		<c:forEach items="${userlist}" var="userinfo">
	                  	   			<c:if test="${userinfo.usercode==item.PersonLiable}">${userinfo.realname}</c:if>
	                  	   		</c:forEach>
	                  	   </td>
	                  	   <td>${item.UrgencyLevel}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.EstimatedSettlingTime }" /></td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.ActualSettlementTime }" /></td>
	                  	   <td>${item.QuestionFollowContent}</td>
	                  	   <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.FollowTime }" /></td>
	                  	   <td>
	                  	   		<c:if test="${item.QuestionStatus==3}">已解决</c:if>
	                  	   		<c:if test="${item.QuestionStatus!=3}">未解决</c:if>
	                  	   </td>
		                   <td>
		                   		<a class="delButClass" href="javascript:void(0);" onclick="delInfoById('${item.QuestionId}')">删除</a>&nbsp;&nbsp;
		                   		<a class="delButClass" href="javascript:void(0);" onclick="editInfo('${item.QuestionId}')">编辑</a>&nbsp;&nbsp;
		                   		<a class="delButClass" href="javascript:void(0);" onclick="followInfoById('${item.QuestionId}')">跟踪</a>&nbsp;&nbsp;
		                   </td>
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
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