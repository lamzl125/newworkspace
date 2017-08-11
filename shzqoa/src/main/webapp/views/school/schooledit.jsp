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
  function saveSchool(){
	  var schoolId = $("#schoolId").val().trim(); 
	 var schoolType = $("#schoolType").val().trim(); 
	 var schoolName = $("#schoolName").val().trim(); 
	 var schoolAddr = $("#schoolAddr").val().trim(); 
	 var schoolURL = $("#schoolURL").val().trim(); 
	 if(schoolType==null || schoolType<=0){
		 alert("学校种类不能为空");
	 }else{
		 if(schoolName==null || schoolName==""){
			 alert("学校名称不能为空");
		 }else{
			 if(schoolAddr==null || schoolAddr==""){
				 alert("学校地址不能为空");
			 }else{
				 if(schoolURL==null || schoolURL==""){
					 schoolURL = "";
				 }
					 var data = {
							 "schoolType":schoolType,"schoolName":schoolName,
							 "schoolAddr":schoolAddr,"schoolURL":schoolURL,"schoolId":schoolId,
					 }
					 $.ajax({
				         type: "post",
				         url: "/school/updateSchoolInfo.do",
				         data: data,
				         dataType: "json",
				         success: function(result){
				        	 if(result.success == true){
				        		 alert(result.resultMessage);
				        		 parent.location.reload();
				        		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				        		 parent.layer.close(index);
				        	 }else{
				        		 alert(result.resultMessage);
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
 	<input type="hidden" class="whh_input" id="schoolId" value="${info.schoolId}"/>
   <input type="hidden" class="whh_input" id="schoolType" value="${info.schoolType}"/>
      <div style="margin-top:20px;">
	<div class="container-fluid">
        <div>
          <div class="clearfix">
            <table class="table table-bordered table-striped with-check whh_table">
              <tbody>
                 <tr>
                   <td width="50%" class="whh_right"><span class="xing">*</span><c:if test="${info.schoolType==1}">培训学校名称</c:if><c:if test="${info.schoolType==2}">学校名称</c:if>：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入名称" id="schoolName" value="${info.schoolName}"/>  </td>
                 </tr>
                  <tr>
                   <td class="whh_right"><span class="xing">*</span><c:if test="${info.schoolType==1}">培训学校地址</c:if><c:if test="${info.schoolType==2}">学校地址</c:if>：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入地址" id="schoolAddr" value="${info.schoolAddr}"/></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span><c:if test="${info.schoolType==1}">学校地网址</c:if><c:if test="${info.schoolType==2}">网址</c:if>：</td>
                   <td>
                   		<input type="text" class="whh_input" placeholder="请输入网址" id="schoolURL" value="${info.schoolURL}"/>
                   </td>
                 </tr>
               </tbody>
            </table>
            <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" onclick="saveSchool()" value="保存"></p>
          </div>
        </div>
  </div>
</div>
</body>
</html>