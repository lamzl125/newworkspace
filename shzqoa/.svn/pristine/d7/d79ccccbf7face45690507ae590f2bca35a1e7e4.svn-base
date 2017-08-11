<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>简历来源编辑</title>
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
  $(document).ready(function(){
	  initMemu(0);
  })
  function updateResumeSource(){
	  var resumesourceid = $("#resumesourceid").val().trim();
	  var resumesourcename = $("#resumesourcename").val().trim();
	  if(resumesourcename == null || resumesourcename == ''){
		  alert("简历来源名称不能为空");
		  return false;
	  }
	  var data = {
			 "resumesourceid": resumesourceid,
			 "resumesourcename":resumesourcename,
	  }
	  $.ajax({
          type: "post",
          url: "/resumeSource/updateResumeSourceById.do",
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
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
   <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
   <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>简历来源编辑</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>用户组ID：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入简历来源ID" id="resumesourceid" disabled="disabled" value=${info.resumesourceid}></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>简历来源名称：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入简历来源名称" id="resumesourcename"  value=${info.resumesourcename}></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" onclick="updateResumeSource()"></p>
          </div>

       </div>
   </form>
   </div>
 </body>
</html>