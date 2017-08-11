<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>注册</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  <script type="text/javascript">
   $(function(){
     $("#signupForm").validate({
      rules: {
        userId: {
          required: true,
        },
        password: {
          required: true,
        },
        confirm_password: {
          required: true,
          equalTo: "#password"
        },
        userName: {
          required: true
        },
      },
      messages: {
        userId: {
          required: "请输入用户名",
        },
        password: {
          required: "请输入密码",
        },
        confirm_password: {
          required: "请再输一遍密码",
          equalTo: "与输入密码不一样，请重新输入"
        },
         userName: {
          required: "请输入您的真实姓名"
        },
      }
    });
   });
  </script>
  <script type="text/javascript">
  	function enroll(){
  		var userId = $("#userId").val().trim();
  		if(userId == ""){
  			alert("请输入用户名!");
  			return;
  		}
  		 if(userId.length > 10 || userId.length < 6){
  			alert("用户名请输入6—10位英文数字组合!");
  			return;
  		} 
  		var userName = $("#userName").val().trim();
  		if(userName == ""){
  			alert("请输入别称即英文名称!");
  			return;
  		}
  		var password = $("#password").val().trim();
  		if(password == ""){
  			alert("请输入密码!");
  			return;
  		}
  	/* 	if(password.length < 8 || password.length > 15){
  			alert("输入8-15位密码!");
  			return;
  		} */
  		var confirm_password = $("#confirm_password").val().trim();
  		if(!(password === confirm_password)){
  			alert("与输入密码不一样，请重新输入");
  			return;
  		}
  		var fullName = $("#fullName").val().trim();
  		if(fullName == ""){
  			alert("请输入姓名!");
  			return;
  		}
  		$.ajax({
            type: "post",
            url: "/login/enrollajax.do",
            data: {"userId":userId,"userName":userName,"password":password,"fullName":fullName},
            dataType: "json",
            success: function(result){
           	 if(result.status == 0){
           		 alert(result.msg);
           		 window.location.replace("/login/entry.do");
           	 }else{
           		 alert(result.msg);
           	 }
            }
        });
  	}
  </script>
 </head>
 <body>
   <div class="whh_head">
     <div class="whh_wraper">
        <a href="javascript:void(0)" class="whh_logo"><img src="/views/images/logo2.jpg"></a>
        <!-- <ul class="whh_nav">
          <li><a href="">录入信息</a></li>
          <li><a href="">查询信息</a></li>
          <li><a href="">员工详情</a></li>
          <li><a href="">我的账户</a></li>
        </ul> -->
     </div>
   </div>
   <div class="whh_wraper">
    <!-- <form name="signupForm" method="post" action="" id="signupForm"> -->
       <div class="whh_content">
          <h2 class="whh_h2"><i class="whh_line fl"></i>注册帐号</h2>
          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
             <tr>
                <td width="40%" class="whh_right"><span class="xing">*</span>用户名：</td>
                <td><input type="text" class="whh_input" placeholder="请输入用户名"  name="userId" id="userId"/></td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>密　码：</td>
                <td><input type="password" class="whh_input" placeholder="请输入密码"  name="password" id="password"/></td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>确认密码：</td>
                <td><input type="password" class="whh_input" placeholder="请再输一遍密码" name="confirm_password" id="confirm_password"/></td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>别称：</td>
                <td><input type="text" class="whh_input" placeholder="请输入别称" name="userName" id="userName"/></td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>姓名：</td>
                <td><input type="text" class="whh_input" placeholder="请输入姓名" name="fullName" id="fullName"/></td>
             </tr>
             <tr>
                <td class="whh_right"></td>
                <td>
                  <input type="button" class="whh_btn whh_btn_big mt20" value="立即注册" onclick="enroll();">
                </td>
             </tr>
          </table>
       </div>
    <!-- </form> -->
   </div>
 </body>
</html>