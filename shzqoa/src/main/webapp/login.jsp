<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>登录</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  
  <script type="text/javascript">
  // 登录
  	function Login(){
  		var usercode = $.trim($("#user").val());
  		var userpassword = $.trim($("#password").val());
  		 $.ajax({
             type: "post",
             url: "/login/check.do",
             data: {"usercode":usercode,"userpassword":userpassword},
             dataType: "json",
             success: function(result){
            	 if(result.status == 0){
            		 if(result.data==1){
            			 window.location.replace("/customerDatailInfo/queryCustomerDetails.do"); 
            		 }else{
            			 window.location.replace("/update/password.do");
            		 }
            	 }else{
            		 alert(result.msg);
            	 }
             }
         });
  	}
  	$(function(){
  		document.onkeyup = function (event) {
  	        var e = event || window.event;
  	        var keyCode = e.keyCode || e.which;
  	        switch (keyCode) {
  	            case 13:Login();
  	                break;
  	            default:
  	                break;
  	        }
  	    }
  	});
  </script>
 </head>
 <body style="background: url('/views/images/bg.jpg') no-repeat center center;">
 <div class="whh_login">
   <img src="/views/images/bg.jpg">
      <div class="whh_wr">
       <div class="whh_wr_dl">
       <form method="post">
          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
             <tr>
                <td width="40%" class="whh_right">用户名：</td>
                <td><input type="text" class="whh_input" placeholder="请输入用户名" id="user"/></td>
             </tr>
             <tr>
                <td class="whh_right">密　码：</td>
                <td><input type="password" class="whh_input" placeholder="请输入密码" id="password"/></td>
             </tr>
             <tr>
                <td class="whh_right"></td>
                <td>
                    <a href="javascript:void(0)" class="whh_btn whh_btn_big" onclick="Login();">登录</a>
                	<!-- <input type="submit" class="whh_btn whh_btn_big" href="javascript:void(0)"  value="登录" onkeydown="if(event.keyCode==13){Login();return false;}"/> -->
                	<input type="reset" class="zyh_chz" value="重置"/>
                    <!-- <a href="/shzqoa/login/enroll.do" class="whh_btn whh_btn_big whh_color">注册</a> -->
                </td>
             </tr>
          </table>
       </form>
       </div>
   </div>
 </div>
 </body>
</html>