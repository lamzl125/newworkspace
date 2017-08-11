<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>参数种类编辑</title>
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
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0);
  })
  function saveInfo(){
	  var parakindid = $("#parakindid").val();
	  if(parakindid==null||parakindid==""){
		  parakindid = 0;
	  }
	  var parakindname = $("#parakindname").val();
	  var orderindex = $("#orderindex").val();
	  if(parakindname == null || parakindname == ''){
		  alert("参数种类名称不能为空");
		  return false;
	  }
	  if(orderindex == null || orderindex == ''){
		  alert("顺序不能为空");
		  return false;
	  }
	  var data = {
			 "parakindid": parakindid,
			 "parakindname":parakindname.trim(),
			 "orderindex": orderindex,
	  }
	  $.ajax({
          type: "post",
          url: "/basepara/saveParaKind.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         		 window.location.href="/basepara/paraKindList.do";
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
	  
  }
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
            <div class="control-group" style='display:none;'>
              <label class="control-label">参数种类ID：</label>
              <div class="controls">
                <input type="text" class="whh_input"  id="parakindid" disabled="disabled" value=${info.parakindid}>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">参数种类名称 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="参数种类名称" id="parakindname" value=${info.parakindname}>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">顺序 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="顺序" value="${info.orderindex}" id="orderindex">
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