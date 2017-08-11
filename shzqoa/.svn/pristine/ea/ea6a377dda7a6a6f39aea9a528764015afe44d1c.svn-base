<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>修改联系人信息</title>
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
  
  function modifyCorpcontent(){
	  	  var id=$("#id").val();
	   	  var corpCode = $("#corpCode").val();
		  var ContanName = $("#ContanName").val();
		  var ContTel = $("#ContTel").val();
		  var ConPhone = $("#ConPhone").val();
		  var ContOfficeTel = $("#ContOfficeTel").val();
		  var QQ = $("#QQ").val();
		  var WeiXin = $("#WeiXin").val();
		  var Remark = $("#Remark").val();
		  
	  var data = {
			  	"id": id,
			  	"corpCode": corpCode,
				 "ContanName":ContanName,
				 "ContTel": ContTel,
				 "ConPhone": ConPhone,
				 "ContOfficeTel": ContOfficeTel,
				 "QQ": QQ,
				 "WeiXin": WeiXin,
				 "Remark": Remark,
			/*  "corpCode": corpCode,
			 "corpProjectName":corpProjectName,
			 "starttime": starttime,
			 "endtime": endtime, */
	  }
	  $.ajax({
          type: "post",
          url: "/corpProject/modifyCorpcontent.do",
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
  </script>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          <input type="hidden" value="${map.Id}" id="id"/>
            <div class="control-group">
              <label class="control-label">联系人姓名：</label>
              <div class="controls">
                <input type="text" class="" placeholder="联系人姓名" id="ContanName" value="${map.ContanName}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">固定电话 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="固定电话" id="ContTel" value="${map.ContTel}"/>
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label">手机 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="手机" value="${map.ConPhone}" id="ConPhone"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">办公电话 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="办公电话" value="${map.ContOfficeTel}" id="ContOfficeTel"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">QQ :</label>
              <div class="controls">
                <input type="text" class="" placeholder="QQ" value="${map.QQ}" id="QQ"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">微信 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="微信" value="${map.WeiXin}" id="WeiXin"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">备注 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="备注" value="${map.Remark}" id="Remark"/>
              </div>
            </div>
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="modifyCorpcontent()">提交</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 </body>
</html>