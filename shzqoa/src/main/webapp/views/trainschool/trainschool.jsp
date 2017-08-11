<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>招聘学校信息</title>
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
	  	  var trainSchoolId=$("#trainSchoolId").val();
	  	  var trainSchoolLevel = $("#trainSchoolLevel").val();	   	  
		  var trainSchoolZone = $("#trainSchoolZone").val();		  
		  var trainSchoolName = $("#trainSchoolName").val();		  
		  var trainSchoolAddr = $("#trainSchoolAddr").val();		  
		  var trainSchoolURL = $("#trainSchoolURL").val();		  
		  var trainSchoolStatus = $("#trainSchoolStatus").val();		  
	  var data = {
			  	"trainSchoolId": trainSchoolId,"trainSchoolLevel": trainSchoolLevel,
			  	"trainSchoolZone":trainSchoolZone,"trainSchoolName": trainSchoolName,
			  	"trainSchoolAddr": trainSchoolAddr,"trainSchoolURL": trainSchoolURL,
				 "trainSchoolStatus": trainSchoolStatus,
	  }
	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	  $.ajax({
          type: "post",
          url: "/trainschool/saveTrainSchool.do",
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
          <input type="hidden" value="${map.trainSchoolId}" id="trainSchoolId"/>
            <div class="control-group">
              <label class="control-label">层次：</label>
              <div class="controls">
                <select id="trainSchoolLevel" class="whh_input">
               		<option value="" <c:if test="${map.trainSchoolLevel==null}">selected</c:if>>请选择</option>
                    <c:forEach var="item" items="${levellist}" varStatus="status">
	                     <option value=${item.id} <c:if test="${map.trainSchoolLevel==item.id}">selected</c:if>>${item.name}</option>
                  	</c:forEach>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">区域：</label>
              <div class="controls">
                <select id="trainSchoolZone" class="whh_input">
               		<option value="" <c:if test="${map.trainSchoolZone==null}">selected</c:if>>请选择</option>
                    <c:forEach var="item" items="${zonelist}" varStatus="status">
	                     <option value=${item.id} <c:if test="${map.trainSchoolZone==item.id}">selected</c:if>>${item.name}</option>
                  	</c:forEach>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">名称 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="名称" id="trainSchoolName" value="${map.trainSchoolName}"/>
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label">地址 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="地址" value="${map.trainSchoolAddr}" id="trainSchoolAddr"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">网址 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="网址" value="${map.trainSchoolURL}" id="trainSchoolURL"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">状态 :</label>
              <div class="controls">
                <select id="trainSchoolStatus" class="whh_input">
               		<option value="" <c:if test="${map.trainSchoolStatus==null}">selected</c:if>>请选择</option>
               		<option value="0" <c:if test="${map.trainSchoolStatus==0}">selected</c:if>>正常</option>
               		<option value="1" <c:if test="${map.trainSchoolStatus==1}">selected</c:if>>废弃</option>
               	</select>
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