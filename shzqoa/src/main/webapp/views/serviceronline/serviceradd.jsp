<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>新增客服信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <link rel="stylesheet" href="/views/resource/css/uploadify.css">
  <style>
    .whh_position{position:relative;width:200px;}
    #customersex-error,#relationshipbyzq-error{position:absolute;right:0;top:0;}
  </style>
  <script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script type="text/javascript" src="/views/resource/layer/layer.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0);
  })
  function saveInfo(){
	  var id = $("#sid").val(); 
	 var serviceName = $("#serviceName").val(); 
	 var qQ = $("#qQ").val(); 
	 var weiXin = $("#weiXin").val(); 
	 if(serviceName==null || serviceName==""){
		 alert("客服名称不能为空");
	 }else{
		 if(qQ==null || qQ==""){
			 alert("qQ不能为空");
		 }else{
			 if(weiXin==null){
				 weiXin = "";
			 }
			 var data = {"id":id,"serviceName":serviceName.trim(),"qQ":qQ.trim(), "weiXin":weiXin.trim(),}
			 $.ajax({
		         type: "post",
		         url: "/serviceronline/saveServicerOnLine.do",
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
	 } 
  }
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
 <input type="hidden" class="whh_input" id="sid" value="${info.id }" />
   <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>新增客服信息</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>客服名称：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入名称" id="serviceName" value="${info.serviceName }" />  </td>
                 </tr>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>QQ：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入QQ" id="qQ" value="${info.qQ }" onkeyup="if(!/^\d+$/.test(this.value)) {alert('只能输入数字 !'); this.value=this.value.replace(/[^\d]+/g,'');}"/></td>
                 </tr>
                 <tr>
                   <td class="whh_right">微信号：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入微信号" id="weiXin" value="${info.weiXin }" />
                   </td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" onclick="saveInfo()" value="保存"></p>
          </div>

       </div>
   </form>
 </body>
</html>