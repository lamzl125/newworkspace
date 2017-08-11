<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>新增信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/common/css/zyh_style.css" />
  <style>
    .whh_position{position:relative;width:200px;}
    #customersex-error,#relationshipbyzq-error{position:absolute;right:0;top:0;}
  </style>
  <script src="/views/common/js/jquery.min.js" ></script>
  <script type="text/javascript">
  function save(){
	 var contactId = $("#contactId").val().trim(); 	 
	 var memo = $("#memo").val().trim(); 
	 
	 if(memo==null || memo==""){
		 alert("跟踪内容不能为空");
	 }else{
		 var data = {
				 "contactId":contactId,"memo":memo,
		 }
		 $.ajax({
	         type: "post",
	         url: "/follow/saveFollowInfo.do",
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
  }
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
   <input type="hidden" class="whh_input" id="contactId" value="${contactId}"/>
    <div style="margin-top:20px;">
		<div class="container-fluid">
	        <div>
	          <div class="clearfix">
	            <table class="table table-bordered table-striped with-check whh_table">
	              <tbody>
                   <tr>
	                   <td class="whh_right"><span class="xing">*</span>跟踪内容：</td>
	                   <td><input type="text" class="whh_input input_800" placeholder="输入跟踪内容" id="memo" />  </td>
	                 </tr>
	                  <tr>
	                   <td width="40%" class="whh_right"><span class="xing">*</span>跟踪人：</td>
	                   <td><input type="text" class="whh_input input_800" value="${user.realname}" readonly="readonly"/></td>
	                 </tr>
	               </tbody>
	            </table>
	            <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" onclick="save()" value="保存"></p>
	          </div>
	        </div>
	  </div>
	</div>
 </body>
</html>