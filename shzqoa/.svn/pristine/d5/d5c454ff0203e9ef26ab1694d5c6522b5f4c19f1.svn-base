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
.intention0{padding-left:2%;padding-right:2%;}
.intention0 label{width:15%;float:left;}
.intention0 div{width:30%;float:left;}
#intention0{display:none;} 
</style>
  <script type="text/javascript">  
  function saveInfo(){
	  	  var followType=$("#followType").val();
	  	  var objectId = $("#objectId").val();	  	
	  	  var followTime = $("#followTime").val();	  	  
	  	  var objectStatus = $("#objectStatus").val();	 
	  	  var content = $("textarea[name='content']").val();
	  	  var factoryId = $("#factoryId").val();
	  	  var giveUpFlag = $("#giveUpFlag").val();
	  	  
	  	
	  	  if(factoryId == null || factoryId==""){
	  		  alert("跟踪厂区不能为空");
	  		  return false;
	  	  }
	  	  if(giveUpFlag == null || giveUpFlag==""){
	  		  alert("是否放弃必须选择一个");
	  		  return false;
	  	  }
	  	  var intentionFactory = "";
	  	  var intentionUserCode = "";
	  	  var error = "";
	  	  $(".intention0:gt(0)").find("select[name='intentionFactory']").each(function(){
	  		  var intfac = $(this).val();
	  		  if(intfac==null){
	  			intfac = "";
	  		  }
	  		  if(intfac==null || intfac==""){
	  			error = "意向厂区不能为空";
	  			return ;
	  		  }
	  		  intentionFactory+=intfac;
	  		  intentionFactory+=",";
	  	  });
	  	  $(".intention0:gt(0)").find("select[name='intentionUserCode']").each(function(){
	  		  var intuser = $(this).val();
	  		  if(intuser==null){
	  			intuser = "";
	  		  }
	  		  intentionUserCode+=intuser;
	  		  intentionUserCode+=",";
	  	  });
	  	  if(error != ""){
	  		alert(error);
	  		return false;
	  	  }
	  var data = {
			  	"followType": followType,"objectId": objectId,"followTime":followTime,
			  	"objectStatus": objectStatus,"content": content,"factoryId":factoryId,
			  	"intentionFactory":intentionFactory,"intentionUserCode":intentionUserCode,
			  	"giveUpFlag":giveUpFlag,
	  }
 	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF"); 
	  $.ajax({
          type: "post",
          url: "/workerfollow/saveWorkerFollow.do",
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
  function changefac(){
	  var factoryId = $("#factoryId").val();
	  var facname = $("#factoryId").find("option:selected").text();
	  $("textarea[name='content']").val("以"+facname+"厂区联系，目前情况为：");  
  }
  function addintention(){
	  var ele = $("#intention0").clone().css("display","block").removeAttr('id'); 
	  $("#intentions").append(ele);
  }
  function changeintfac(obj){
	  var factid = $(obj).val();
	  $.ajax({
          type: "post",
          url: "/plantheader/stlHeaderByPlant.do",
          data: {"plantId":factid},
          dataType: "json",
          success: function(result){
         	 if(result.success == true){
         		var plantheaders = result.resultData;
        		var optionString = "";
        		var selele = $(obj).parents(".intention0").find("select[name='intentionUserCode']");
        		selele.empty();  
        		for(var i in  plantheaders){
        			var plantheaderinfo = plantheaders[i];
        			optionString +="<option value='" + plantheaderinfo.UserCode + "' >" + plantheaderinfo.realName + "</option>";
        		}
        		selele.html("<option value=''>请选择...</option> "+optionString);  
         	 }else{
         		alert(result.resultMessage);
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
          <div style="float:right;">
              	<input type="button" class="zyh_btn" onclick="addintention()" value="+意向">
          </div>
          <input type="hidden" value="${followType}" id="followType"/>
          <input type="hidden" value="${objectId}" id="objectId"/>
            <div class="control-group">
              <label class="control-label">跟踪时间：</label>
              <div class="controls">
                <input type="text" id="followTime" class="zyh_cursor" onclick="WdatePicker()" readonly />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">普工状态:</label>
              <div class="controls">
                <select id="objectStatus" class="whh_input">
               		<option value="" >请选择</option>
               		<option value="1" >登记</option>
               		<option value="2" >面试不通过</option>
               		<option value="3" >面试通过</option>
               		<option value="4" >体检通过</option>
               		<option value="5" >体检不通过</option>
               		<option value="6" >入职</option>
               		<option value="7" >反费</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">跟踪厂区:</label>
              <div class="controls">
                <select id="factoryId" class="whh_input" onchange="changefac()">
               		<option value="" >请选择</option>
               		<c:forEach var="item" begin="0" items="${factorylist}" varStatus="status">
	                     <option value="${item.id}" >${item.name}</option>
	                </c:forEach>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">跟踪情况 :</label>
              <div class="controls">
              	<textarea rows="6" name="content"></textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">是否放弃:</label>
              <div class="controls">
                <select id="giveUpFlag" class="whh_input">
               		<option value="" >请选择</option>
               		<option value="1" >是</option>
               		<option value="2" >否</option>
               	</select>
              </div>
            </div>
            <div id="intentions" class="control-group">
           		<div id="intention0" class="intention0">
	              <label>意向厂区:</label>
	              <div>
	              	<select name="intentionFactory" class="whh_input" onchange="changeintfac(this)">
	               		<option value="" >请选择</option>
	               		<c:forEach var="item" begin="0" items="${factorylist}" varStatus="status">
		                     <option value="${item.id}" >${item.name}</option>
		                </c:forEach>
	               	</select>
	              </div>
	              <label>意向人:</label>
	              <div>
	              	<select name="intentionUserCode" class="whh_input">
	               		<option value="" >请选择</option>
	               	</select>
	              </div>
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