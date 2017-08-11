<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>跟踪问题</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
<style>
.widget-box{ margin-top:10px; margin-bottom:0;}
.form-actions{ text-align:center;}
.form-horizontal .control-label{width: 320px;}
.form-horizontal .controls{margin-left: 339px;}
.span11.zyh_cursor{ cursor:pointer;}
</style>
<script src="/views/common/js/jquery.min.js" ></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script> 
<script src="/views/common/js/matrix.js"></script> 
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<script type="text/javascript">
function checkEndTime(startTime,endTime){  
    var start=new Date(startTime.replace("-", "/").replace("-", "/"));  
    var end=new Date(endTime.replace("-", "/").replace("-", "/"));  
    if(end<start){  
        return false;  
    }  
    return true;  
} 
function followquestion(){	
	var questionId = $("#questionId").val();	
	var questionFollowContent = $("#questionFollowContent").val();
	if(questionFollowContent==null||questionFollowContent==""){
		alert("跟踪情况不能为空");
		return false;
	}
	var questionStatus = $("#questionStatus").val();
	if(questionStatus==null||questionStatus==""){
		alert("问题解决情况必须选择一个");
		return false;
	}
	
	var data = {
			"questionFollowContent":questionFollowContent,"questionStatus":questionStatus,"questionId":questionId,
			}
	$.ajax({
        type: "post",
        url: "/question/followQuestion.do",
        data: data,
        dataType: "json",
        success: function(result){
        	alert(result.msg);
	       	 if(result.status == 0){
	       		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
	       	 }
        }
    });
	
}
</script> 
</head>
<body style="background-color:#fff;">
<input type="hidden"  id="questionId" value="${info.questionId}"/>
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">问题反馈人 :</label>
              <div class="controls">
                ${info.problemMaker}
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">反映时间 :</label>
              <div class="controls">
           		<fmt:formatDate pattern="yyyy-MM-dd" value="${info.reflectProblemTime}" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">问题描述:</label>
              <div class="controls">
                ${info.questionContent}
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">跟踪情况:</label>
              <div class="controls">
              	<textarea class="span12" id="questionFollowContent"></textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">问题解决情况:</label>
              <div class="controls">
                    <select id="questionStatus">
                      <option value="">--请选择--</option>
                      <option value="1">未处理</option>
                      <option value="2">处理中</option>
                      <option value="3">已解决</option>
                    </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">跟踪人:</label>
              <div class="controls">
              	${curuser.realname}
              </div>
            </div>
             
            
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="followquestion()">跟踪</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 

</body>
</html>
