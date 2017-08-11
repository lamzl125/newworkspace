<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>代理人信息</title>
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
	  var agentId = $("#agentId").val();
	  var endTime = $("#endTime").val();
	  if(endTime==null){
		  endTime=""
	  }	
	  var startTime=$("#startTime").val();
	  if(startTime==null){
		  startTime=""
	  }	
	  var agentName = $("#agentName").val();
	  if(agentName==null || agentName==""){
		  alert("代理人名称不能为空");
		  return false;
	  }	
	  var agentSex = $("#agentSex").val();
	  if(agentSex==null || agentSex==""){
		  alert("代理人性别必须选择一个");
		  return false;
	  }	
	  var tripRecordId = $("#tripRecordId").val();	
	  if(tripRecordId==null || tripRecordId==""){
		  alert("行程必须选择一个");
		  return false;
	  }	
	  var mobile = $("#mobile").val();	
	  if(mobile==null){
		  mobile=""
	  }
	  var officeTel = $("#officeTel").val();
	  if(officeTel==null){
		  officeTel=""
	  }
	  var qQ = $("#qQ").val();
	  if(qQ==null){
		  qQ=""
	  }
	  var weiXin = $("#weiXin").val();
	  if(weiXin==null){
		  weiXin=""
	  }
	  var idCard = $("#idCard").val();
	  if(idCard==null){
		  idCard=""
	  }
	  var agentAddr = $("#agentAddr").val();
	  if(agentAddr==null){
		  agentAddr=""
	  }
	  var signAgreement = $("#signAgreement").val();
	  if(signAgreement!=null && signAgreement==""){
		  alert("协议签署必须选择一个");
		  return false;
	  }	
	  
	  var contractCode = $("#contractCode").val();
	  if(contractCode==null){
		  contractCode=""
	  }
	  if(signAgreement==1 && contractCode==""){
		  alert("协议已签署时合同编号不能为空");
		  return false;
	  }
	  if(signAgreement==0 && contractCode!=""){
		  alert("协议未签署时合同编号必须为空");
		  return false;
	  }
	  var data = {
			  	"endTime": endTime,"startTime": startTime,"agentName":agentName,			  	
			  	"agentSex": agentSex,"tripRecordId":tripRecordId,"mobile":mobile,
			  	"officeTel": officeTel,"qQ":qQ,"weiXin":weiXin,
			  	"idCard": idCard,"agentAddr":agentAddr,"signAgreement":signAgreement,
			  	"contractCode": contractCode,"agentId":agentId,
	  }
	  
	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	  $.ajax({
          type: "post",
          url: "/agent/saveAgent.do",
          data: data,
          dataType: "json",
          success: function(result){
        	  alert(result.resultMessage);
         	 if(result.success == true){
         		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
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
          <input type="hidden" value="${map.agentId}" id="agentId"/>
            <div class="control-group">
              <label class="control-label">行程 :</label>
              <div class="controls">
              		<select id="tripRecordId" >
	               		<option value="" <c:if test="${map.tripRecordId==null||map.tripRecordId eq ''}">selected</c:if>>请选择</option>
	                    <c:forEach var="item" items="${recordlist}" varStatus="status">
		                     <option value="${item.TripRecordId}" <c:if test="${map.tripRecordId eq item.TripRecordId}">selected</c:if>>
		                     	${item.TripWhoName}<fmt:formatDate pattern='yyyy-MM-dd' value='${item.TripTime}' />
		                     	<c:forEach var="school" items="${schoollist}">
		                     		<c:if test="${school.trainSchoolId eq item.TrainSchoolId}">${school.trainSchoolName}</c:if>
		                     	</c:forEach>
		                     	${item.TripAddr}
		                     </option>
	                  	</c:forEach>
	               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">代理人姓名 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="姓名"  id="agentName" value="${map.agentName}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">性别：</label>
              <div class="controls">
                <select id="agentSex" class="whh_input">
               		 <option value="" <c:if test="${map.agentSex==null||map.agentSex==0}">selected</c:if> >请选择</option>
                     <option value="1" <c:if test="${map.agentSex==1}">selected</c:if> >男</option>
                     <option value="2" <c:if test="${map.agentSex==2}">selected</c:if>>女</option>
               	</select>
              </div>
            </div>
			<div class="control-group">
              <label class="control-label">地址 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="地址"  id="agentAddr" value="${map.agentAddr}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">手机 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="手机"  id="mobile" value="${map.mobile}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">办公电话 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="办公电话"  id="officeTel" value="${map.officeTel}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">QQ :</label>
              <div class="controls">
                <input type="text" class="" placeholder="QQ"  id="qQ" value="${map.qQ}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">微信号 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="微信号"  id="weiXin" value="${map.weiXin}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">身份证号 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="身份证号"  id="idCard" value="${map.idCard}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">协议签署：</label>
              <div class="controls">
                <select id="signAgreement" class="whh_input">
               		 <option value=""  <c:if test="${map.agentName==null}">selected</c:if> >请选择</option>
                     <option value="0" <c:if test="${map.signAgreement==0}">selected</c:if> >未签署</option>
                     <option value="1" <c:if test="${map.signAgreement==1}">selected</c:if> >已签署</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">合同编号 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="合同编号"  id="contractCode" value="${map.contractCode}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">开始时间：</label>
              <div class="controls">
                <input type="text" id="startTime" class="zyh_cursor" placeholder="输入开始时间" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${map.startTime}' />"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">结束时间：</label>
              <div class="controls">
                <input type="text" id="endTime" class="zyh_cursor" placeholder="输入结束时间" onclick="WdatePicker()" readonly value="<fmt:formatDate pattern='yyyy-MM-dd' value='${map.endTime}' />"/>
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