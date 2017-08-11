<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>新增企业联系人信息</title>
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
	 var enterpriseId = $("#enterpriseId").val();	       
	 var contactsName = $("#contactsName").val(); 
	 var contactsPhone = $("#contactsPhone").val(); 
	 var contactsTel = $("#contactsTel").val(); 
	 var contactsQQ = $("#contactsQQ").val(); 
	 var contactsWeiXin = $("#contactsWeiXin").val(); 
	 var job = $("#job").val();
	 var contactsStatus = $("input[name=contactsStatus]:checked").val(); 
	 if(enterpriseId==null || enterpriseId==""){
		 alert("必须选择一个企业");
		 return false;
	 }
	 if(contactsName==null || contactsName==""){
		 alert("联系人名称不能为空");
		 return false;
	 }
	 if(contactsPhone==null){
		 contactsPhone = "";
	 }
	 if(contactsTel==null){
		 contactsTel = "";
	 }
	 if(contactsQQ==null){
		 contactsQQ = "";
	 }
	 if(contactsWeiXin==null){
		 contactsWeiXin = "";
	 }
	 if(job==null){
		 job = "";
	 }
	 if(contactsStatus==null || contactsStatus==""){
		 alert("联系人状态不能为空");
		 return false;
	 }
	 
	 var data = {
			 "enterpriseId":enterpriseId.trim(),"contactsName":contactsName.trim(),"contactsPhone":contactsPhone.trim(),
			 "contactsTel":contactsTel.trim(),"contactsQQ":contactsQQ.trim(),"contactsWeiXin":contactsWeiXin.trim(),
			 "job":job.trim(),"contactsStatus":contactsStatus.trim(),
	 }
	 $.ajax({
         type: "post",
         url: "/enterprise/saveContactsInfo.do",
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
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
   <input type="hidden" class="whh_input" id="enterpriseId" value="${enterpriseId}"/>
   <div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
            <table class="table table-bordered table-striped with-check whh_table">
              <tbody>
                  <tr>
                   <td width="50%"class="whh_right"><span class="xing">*</span>姓名：</td>
                   <td><input type="text" class="whh_input" placeholder="输入姓名" id="contactsName" />  </td>
                 </tr>
                  <tr>
                   <td  class="whh_right">联系电话：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入联系电话" id="contactsPhone" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">办公电话：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入办公电话" id="contactsTel" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">QQ：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入QQ" id="contactsQQ" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">微信号：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入微信号" id="contactsWeiXin" />
                   </td>
                 </tr>
                 <tr>
                   <td class="whh_right">职位：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入职位" id="job" />
                   </td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>是否启用：</td>
                   <td>
                   		<div class="whh_position" style="float:left;">
		                   <label class="whh_label"><input type="radio" name="contactsStatus"  value="2"/>否</label>
		                   <label class="whh_label"><input type="radio" name="contactsStatus" checked value="1"/>是</label>
	                   </div>
	                   <div style="float:left;width:220px;">
	                   		<span class="xing">启用后该企业其他联系人为不启用</span>
	                   </div>
                   </td>
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