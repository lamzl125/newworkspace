<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>权限编辑</title>
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
  function saveRight(){
	  var rightid = $("#rightid").val().trim();
	  var rightname = $("#rightname").val().trim();
	  var parentid = $("#parentid").val().trim();
	  var url = $("#url").val().trim();
	  var rightlevel = $("#rightlevel").val().trim();
	  if(rightname == null || rightname == ''){
		  alert("权限名称不能为空");
		  return false;
	  }
	  if(parentid == null || parentid == ''){
		  alert("父级菜单不能为空");
		  return false;
	  }
	  if(parentid!='-1'){
		  if(url == null || url == ''){
			  alert("URL地址不能为空");
			  return false;
		  }
	  }
	  var data = {
			 "rightid": rightid,
			 "rightname":rightname,
			 "parentid": parentid,
			 "url": url,
	  }
	  $.ajax({
          type: "post",
          url: "/rights/updateRightById.do",
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
  function updateParentRight(){
	  var parentid = $("#parentid").val().trim();
	  if(parentid==""){
		  alert("必须选择一个菜单");
		  return false;
	  }else if(parentid=="-1"){
		  $("#rightlevel").val("1");
	  }else{
		  $.ajax({
	          type: "post",
	          url: "/rights/updateParentId.do",
	          data: {"parentid":parentid,},
	          dataType: "json",
	          success: function(result){
	         	 if(result.status == 0){
	         		$("#rightlevel").val(parseInt(result.parentRight.rightlevel)+1);
	         	 }else{
	         		 alert(result.msg);
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
   <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
   <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>权限编辑</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>权限ID：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入权限ID" id="rightid" disabled="disabled" value=${info.rightid}></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>权限名称：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入权限名称" id="rightname"  value=${info.rightname}></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>上级权限：</td>
                   <td>
                       <select class="whh_sel" id="parentid" onchange="updateParentRight()">
                          <option selected value="">请选择上级权限</option>
                          <option selected value="-1">无</option>
                          <c:forEach items="${rightList}" var="item">
                           		<option value='${item.rightid}' <c:if test="${item.rightid==info.parentid}">selected='selected'</c:if>>${item.rightlevel}-${item.rightname}</option>
                          </c:forEach>
                       </select>
                   </td>
                 </tr>
                 <tr>
                   <td class="whh_right">URL地址：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入URL地址" id="url"  value=${info.url}></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>权限级别：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" id="rightlevel"  disabled="disabled" value=${info.rightlevel} ></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" onclick="saveRight()"></p>
          </div>

       </div>
   </form>
   </div>
 </body>
</html>