<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>客户需求跟踪</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <link rel="stylesheet" href="/views/resource/css/uploadify.css">
  <script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script type="text/javascript">
  function saveInfo(){
	  var demandresumeRelationId = $("#demandresumeRelationId").val().trim();
	  if(demandresumeRelationId==null||demandresumeRelationId==""){
		  alert("未找到制定的客户需求关联ID");
		  return false;
	  }
	  var TrackResult = $("#TrackResult").val().trim();
	  var Remark = $("#Remark").val().trim();
	  if(TrackResult == null || TrackResult == ''){
		  alert("跟踪结果不能为空");
		  return false;
	  }
	  if(Remark == null){
		  Remark = '';  
	  }
	  var data = {
			 "demandresumeRelationId": demandresumeRelationId,
			 "TrackResult":TrackResult,
			 "Remark": Remark,
	  }
	  $.ajax({
          type: "post",
          url: "/customerDemand/saveCustomerDemandTrack.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         		 window.location.href="/customerDemand/toCustDemandTrackList.do";
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
 <body>
   <div class="whh_wraper">
   <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求跟踪</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                  <tr style="display:none;">
                   <td width="40%" class="whh_right"><span class="xing">*</span>客户需求关联ID：</td>
                   <td><input type="text" class="whh_input"  id="demandresumeRelationId" disabled="disabled" value=${DemandresumeRelationId}></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>跟踪结果：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入跟踪结果" id="TrackResult" ></td>
                 </tr>
                 <tr>
                   <td class="whh_right">备注：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入备注" id="Remark" ></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" onclick="saveInfo()"></p>
          </div>

       </div>
   </form>
   </div>
 </body>
</html>