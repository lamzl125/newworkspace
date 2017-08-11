<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>问题</title>
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
function savequestion(){
	var problemMaker = $("#problemMaker").val();
	if(problemMaker==null||problemMaker==""){
		alert("问题反馈人不能为空");
		return false;
	}
	var reflectProblemTime = $("#reflectProblemTime").val();
	if(reflectProblemTime==null||reflectProblemTime==""){
		alert("问题反馈时间不能为空");
		return false;
	}
	var nowtime = new Date().toLocaleString();
	if(!checkEndTime(reflectProblemTime,nowtime)){
		alert("问题反馈时间不能大于当前时间");
		return false;
	}
	var questionContent = $("#questionContent").val();
	if(questionContent==null||questionContent==""){
		alert("问题描述不能为空");
		return false;
	}
	var personLiable = $("#personLiable").val();
	if(personLiable==null||personLiable==""){
		alert("责任人不能为空");
		return false;
	}
	var urgencyLevel = $("#urgencyLevel").val();
	if(urgencyLevel==null||urgencyLevel==""){
		alert("紧急程度不能为空");
		return false;
	}
	var estimatedSettlingTime = $("#estimatedSettlingTime").val();
	if(estimatedSettlingTime==null||estimatedSettlingTime==""){
		alert("预计完成时间不能为空");
		return false;
	}
	if(!checkEndTime(nowtime,estimatedSettlingTime)){
		alert("预计完成时间必须大于当前时间");
		return false;
	}
	
	var data = {
			"problemMaker":problemMaker,"reflectProblemTime":reflectProblemTime,
			"questionContent":questionContent,"personLiable":personLiable,
			"urgencyLevel":urgencyLevel,"estimatedSettlingTime":estimatedSettlingTime,
			}
	$.ajax({
        type: "post",
        url: "/question/addQuestion.do",
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
  <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">问题反馈人 :</label>
              <div class="controls">
                <input type="text" class="span12" placeholder="问题反馈人" id="problemMaker"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">反映时间 :</label>
              <div class="controls">
                <input type="text" class="span12 zyh_cursor" placeholder="反映时间" onclick="WdatePicker()" id="reflectProblemTime" onfocus="WdatePicker({skin:'whyGreen',maxDate:'%y-%M-%d'})" readonly/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">问题描述:</label>
              <div class="controls">
                <input type="text" class="span12" placeholder="问题描述" id="questionContent"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">责任人:</label>
              <div class="controls">
                    <select id="personLiable">
                      <option value="">--请选择--</option>
                      <c:forEach items="${list}" var="personli">
                      		<option value="${personli.usercode}">${personli.realname}-${personli.fullName}</option>
                      </c:forEach>
                    </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">紧急程度:</label>
              <div class="controls">
                <input type="text" class="span12" placeholder="紧急程度" id="urgencyLevel"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">预计解决时间 :</label>
              <div class="controls">
                <input type="text" class="span12 zyh_cursor" placeholder="预计解决时间" onclick="WdatePicker()" id="estimatedSettlingTime" onfocus="WdatePicker({skin:'whyGreen',minDate:'%y-%M-%d'})" readonly/>
              </div>
            </div>
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="savequestion()">确定</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 

</body>
</html>
