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
  function save(){
	 var direction = $("#direction").val(); 
	 var contactTel = $("#contactTel").val(); 
	 var contactName = $("#contactName").val(); 
	 var schoolId = $("select[name=school]").val(); 
	 var contactSex = $("input[name=contactSex]:checked").val(); 
	 var isEngross = $("input[name=isEngross]:checked").val(); 
	 var contactName = $("#contactName").val(); 
	 var officeTel = $("#officeTel").val(); 
	 if(officeTel==null){
		 officeTel = "";
	 }
	 var qq = $("#qq").val(); 
	 if(qq==null){
		 qq ="";
	 }
	 var jobName = $("#jobName").val(); 
	 if(jobName==null){
		 jobName = "";
	 }
	 
	 if(direction==null || direction==""){
		 alert("培训内容不能为空");
	 }else{
		 if(contactTel==null || contactTel==""){
			 alert("联系电话不能为空");
		 }else{
			 if(contactName==null || contactName==""){
				 alert("联系人不能为空");
			 }else{
				 if(schoolId==null || schoolId==""){
					 alert("请必须选择一个学校");
				 }else{
					 if(contactSex==null || contactSex==""){
						 alert("性别不能为空");
					 }else{
						 if(isEngross==null || isEngross==""){
							 alert("是否独占必须选择一个");
							 return false;
						 }
						 
						 var data = {
								 "direction":direction.trim(),"contactTel":contactTel.trim(),"isEngross":isEngross.trim(),
								 "contactName":contactName.trim(),"schoolId":schoolId.trim(),"contactSex":contactSex.trim(),
								 "officeTel":officeTel.trim(),"qq":qq.trim(),"jobName":jobName,
						 }
						 $.ajax({
					         type: "post",
					         url: "/contact/saveTrainInfo.do",
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
 <body>
   <input type="hidden" class="whh_input" id="schoolId" value="${schoolId}"/>
     <div style="margin-top:20px;">
		<div class="container-fluid">
	        <div>
	          <div class="clearfix">
	            <table class="table table-bordered table-striped with-check whh_table">
	              <tbody>
                   <tr>
	                   <td width="50%" class="whh_right"><span class="xing">*</span>培训内容：</td>
	                   <td><input type="text" class="whh_input" placeholder="输入培训内容" id="direction" />  </td>
	                 </tr>
	                  <tr>
	                   <td width="40%" class="whh_right"><span class="xing">*</span>联系电话：</td>
	                   <td><input type="text" class="whh_input" placeholder="请输入联系电话" id="contactTel" /></td>
	                 </tr>
	                 <tr>
	                   <td width="40%" class="whh_right"><span class="xing">*</span>办公电话：</td>
	                   <td><input type="text" class="whh_input" placeholder="请输入办公电话" id="officeTel" /></td>
	                 </tr>
	                 <tr>
	                   <td width="40%" class="whh_right"><span class="xing">*</span>QQ：</td>
	                   <td><input type="text" class="whh_input" placeholder="请输入QQ" id="qq" /></td>
	                 </tr>
	                 <tr>
	                   <td class="whh_right"><span class="xing">*</span>联系人：</td>
	                   <td>
	                   		<input type="text" class="whh_input" placeholder="请输入联系人" id="contactName" />
	                   </td>
	                 </tr>
	                 <tr>
	                   <td class="whh_right"><span class="xing">*</span>职位：</td>
	                   <td>
	                   		<input type="text" class="whh_input" placeholder="请输入职位" id="jobName" />
	                   </td>
	                 </tr>
	                  <tr>
	                   <td class="whh_right"><span class="xing">*</span>学校：</td>
	                   <td>
	                   		<select class="whh_sel" name="school">
	                          <option selected value="">请选择学校</option>
	                          <c:forEach items="${allSchoolList}" var="school">
	                          		<option value='${school.schoolId}' <c:if test="${schoolId==school.schoolId}">selected="selected"</c:if>>${school.schoolName}</option>
	                          </c:forEach>
	                       </select>
	                   </td>
	                 </tr>
	                 <tr>
	                   <td class="whh_right"><span class="xing">*</span>性别：</td>
	                   <td>
	                   <div class="whh_position" style="width:510px;">
		                   <label class="whh_label"><input type="radio" name="contactSex" value="1" />男</label>
		                   <label class="whh_label"><input type="radio" name="contactSex" value="2" />女</label>
	                    </div>
	                    </td>
	                 </tr>
	                 <tr>
	                   <td class="whh_right"><span class="xing">*</span>是否独占：</td>
	                   <td>
	                   <div class="whh_position">
	                   <label class="whh_label"><input type="radio" name="isEngross"  value="0"/>否</label>
	                   <label class="whh_label"><input type="radio" name="isEngross" value="1"/>是</label></div>
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