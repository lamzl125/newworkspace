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
  <script src="/views/common/js/jquery.min.js"></script>
  <script type="text/javascript">
  function saveEnterprise(){
	 var enterpriseName = $("#enterpriseName").val(); 
	 var enterpriseScale = $("#enterpriseScale").val(); 
	 var enterpriseProfile = $("#enterpriseProfile").val(); 
	 var enterpriseURL = $("#enterpriseURL").val(); 
	 var enterpriseAddr = $("#enterpriseAddr").val(); 
	 
	 
	 if(enterpriseName==null || enterpriseName==''){
		 alert("名称不能为空");
	 }else{
		 if(enterpriseScale==null || enterpriseScale==""){
			 alert("企业规模不能为空");
		 }else{
			 if(enterpriseAddr==null || enterpriseAddr==""){
				 alert("企业地址不能为空");
			 }else{
				 if(enterpriseProfile==null){
					 enterpriseProfile = "";
				 }
				 if(enterpriseURL==null){
					 enterpriseURL = "";
				 }
				 var data = {
						 "enterpriseName":enterpriseName.trim(),"enterpriseScale":enterpriseScale.trim(),
						 "enterpriseProfile":enterpriseProfile.trim(),"enterpriseURL":enterpriseURL.trim(),
						 "enterpriseAddr":enterpriseAddr.trim()
				 }
				 $("input[type='button']").attr("disabled",true);
				 $("input[type='button']").css("background","#CCCCFF");
				 
				 $.ajax({
			         type: "post",
			         url: "/enterprise/saveEnterprise.do",
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
  }
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body style="background:#fff;">
    <div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
            <table class="table table-bordered table-striped with-check whh_table">
              <tbody>
                 <tr>
                   <td width="50%" class="whh_right"><span class="xing">*</span>企业名称：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入名称" id="enterpriseName" />  </td>
                 </tr>
                  <tr>
                   <td class="whh_right"><span class="xing">*</span>企业规模：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入地址" id="enterpriseScale" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">企业简介：</td>
                   <td>
                   		<textarea style="width:300px; max-width:300px;border:1px solid #a7b6c4;border-radius:3px;" id="enterpriseProfile"></textarea>
                   </td>
                 </tr>
                 <tr>
                   <td class="whh_right">企业网址：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入网址" id="enterpriseURL" />
                   </td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>企业地址：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入地址" id="enterpriseAddr" />
                   </td>
                 </tr>
               </tbody>
            </table>
            <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" onclick="saveEnterprise()" value="保存"></p>
          </div>
        </div>
  </div>
</div>
 </body>
</html>