<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>参数编辑</title>
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
  <script type="text/javascript">
  function saveInfo(){
	  var id = $("#id").val();
	  if(id==null||id==""){
		  id = 0;
	  }
	  var parakindid = $("#parakindid").val();
	  if(parakindid==null||parakindid==""){
		  alert("参数种类不能为空");
		  return false;
	  }
	  var name = $("#name").val();
	  var orderindex = $("#orderindex").val();
	  if(name == null || name == ''){
		  alert("参数名称不能为空");
		  return false;
	  }
	  if(orderindex == null || orderindex == ''){
		  alert("顺序不能为空");
		  return false;
	  }
	  var data = {
			  "id": id,
			 "parakindid": parakindid,
			 "name":name.trim(),
			 "orderindex": orderindex,
	  }
	  $.ajax({
          type: "post",
          url: "/basepara/savePara.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         		 window.location.href="/basepara/paraList.do";
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
              <label class="control-label">参数ID：</label>
              <div class="controls">
                <input type="text" class="whh_input"  id="id" disabled="disabled" value=${info.id}>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">参数种类:</label>
              <div class="controls">
           		<select id="parakindid">
                    <option selected value="">请选择参数种类</option>
                    <c:forEach items="${paraKindlsit}" var="parakinditem">
                   		<option value='${parakinditem.parakindid}' <c:if test="${parakinditem.parakindid==info.parakindid}">selected='selected'</c:if>>${parakinditem.parakindname}</option>
                    </c:forEach>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">参数名称 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="参数名称" id="name" value=${info.name}>
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