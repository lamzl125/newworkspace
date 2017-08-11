<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>普工信息</title>
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
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <style>
.widget-box{ margin-top:10px; margin-bottom:0;}
.form-actions{ text-align:center;}
.form-horizontal .control-label{width: 320px;}
.form-horizontal .controls{margin-left: 339px;}
.span11.zyh_cursor{ cursor:pointer;}
</style>
  <script type="text/javascript">  
  function saveInfo(){
	  	  var antiFeePay=$("#antiFeePay").val();
	  	  var workerId = $("#workerId").val();	  	
	  	  var antiFeeTime = $("#antiFeeTime").val();	  	  
	  	  var workerStatus = $("#workerStatus").val();	  	  
		  var idCard = $("#idCard").val();		  
		  var origin = $("#origin").val();
		  var age = $("#age").val();		  
		  var workerPhone = $("#workerPhone").val();			  
		  var workerName = $("#workerName").val();
		  var registerTime = $("#registerTime").val();
		  var workerSex = $("#workerSex").val();
		  var physicalExamination = $("#physicalExamination").val();
		  var estimateAntiFeeTime = $("#estimateAntiFeeTime").val();
		  var isSettlement = $("#isSettlement").val();
		  var reMark = $("#reMark").val();
		  var reMark1 = $("#reMark1").val();
	  var data = {
			  	"workerId": workerId,"antiFeePay": antiFeePay,"reMark":reMark,
			  	"antiFeeTime": antiFeeTime,"workerStatus": workerStatus,"idCard": idCard,
				"origin": origin,"age": age,"workerPhone": workerPhone,"workerName": workerName,
				"registerTime": registerTime,"workerSex": workerSex,"physicalExamination": physicalExamination,
				"estimateAntiFeeTime": estimateAntiFeeTime,"isSettlement": isSettlement,
				"reMark1":reMark1,
	  }
	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	  $.ajax({
          type: "post",
          url: "/worker/saveWorker.do",
          data: data,
          dataType: "json",
          success: function(result){
        	  alert(result.resultMessage);
         	 if(result.success == true){
         		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
         	 }else{
         		$(".btn-success").attr("disabled", false); 
       		    $(".btn-success").css("background","#5bb75b");
         	 }
          }
      });
  }
  </script>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          <input type="hidden" value="${map.workerId}" id="workerId"/>
            <div class="control-group">
              <label class="control-label">时间：</label>
              <div class="controls">
                <input type="text" id="registerTime" class="zyh_cursor" placeholder="时间" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${map.registerTime}' />"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">姓名：</label>
              <div class="controls">
                <input type="text" placeholder="姓名" id="workerName" value="${map.workerName}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">性别 :</label>
              <div class="controls">
                <select id="workerSex" class="whh_input">
               		<option value="" <c:if test="${map.workerSex==null}">selected</c:if>>请选择</option>
               		<option value="1" <c:if test="${map.workerSex==1}">selected</c:if>>男</option>
               		<option value="2" <c:if test="${map.workerSex==2}">selected</c:if>>女</option>
               		<option value="3" <c:if test="${map.workerSex==3}">selected</c:if>>保密</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">电话：</label>
              <div class="controls">
                <input type="text" placeholder="电话" id="workerPhone" value="${map.workerPhone}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">年龄 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="年龄" id="age" value="${map.age}" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">籍贯 :</label>
              <div class="controls">
                <input type="text" placeholder="籍贯" value="${map.origin}" id="origin"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">身份证号 :</label>
              <div class="controls">
                <input type="text" placeholder="身份证号" value="${map.idCard}" id="idCard"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">是否体检 :</label>
              <div class="controls">
                <select id="physicalExamination" class="whh_input">
               		<option value="" <c:if test="${map.physicalExamination==null}">selected</c:if>>请选择</option>
               		<option value="1" <c:if test="${map.physicalExamination==1}">selected</c:if>>是</option>
               		<option value="2" <c:if test="${map.physicalExamination==2}">selected</c:if>>否</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">状态 :</label>
              <div class="controls">
                <select id="workerStatus" class="whh_input">
               		<option value="" <c:if test="${map.workerStatus==null}">selected</c:if>>请选择</option>
               		<option value="1" <c:if test="${map.workerStatus==1}">selected</c:if>>登记</option>
               		<option value="2" <c:if test="${map.workerStatus==2}">selected</c:if>>面试不通过</option>
               		<option value="3" <c:if test="${map.workerStatus==3}">selected</c:if>>面试通过</option>
               		<option value="4" <c:if test="${map.workerStatus==4}">selected</c:if>>体检通过</option>
               		<option value="5" <c:if test="${map.workerStatus==5}">selected</c:if>>体检不通过</option>
               		<option value="6" <c:if test="${map.workerStatus==6}">selected</c:if>>入职</option>
               		<option value="7" <c:if test="${map.workerStatus==7}">selected</c:if>>反费</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">预计反费时间：</label>
              <div class="controls">
                <input type="text" id="estimateAntiFeeTime" class="zyh_cursor" placeholder="反费时间" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${map.estimateAntiFeeTime}' />"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">反费时间：</label>
              <div class="controls">
                <input type="text" id="antiFeeTime" class="zyh_cursor" placeholder="反费时间" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${map.antiFeeTime}' />"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">反费金额 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="反费金额" id="antiFeePay" value="${map.antiFeePay}" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            
            
            <div class="control-group">
              <label class="control-label">是否结清 :</label>
              <div class="controls">
                <select id="isSettlement" class="whh_input">
               		<option value="" <c:if test="${map.isSettlement==null}">selected</c:if>>请选择</option>
               		<option value="1" <c:if test="${map.isSettlement==1}">selected</c:if>>是</option>
               		<option value="2" <c:if test="${map.isSettlement==2}">selected</c:if>>否</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">备注 :</label>
              <div class="controls">
                <input type="text" placeholder="备注" value="${map.reMark}" id="reMark"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">夜班要求 :</label>
              <div class="controls">
                <textarea rows="6" id="reMark1">${map.reMark1}</textarea>
              </div>
            </div>
            
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="saveInfo()">提交</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 </body>
</html>