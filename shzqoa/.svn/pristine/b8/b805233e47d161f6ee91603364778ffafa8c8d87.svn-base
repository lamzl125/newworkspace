<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.shzqoa.model.Rights"%>
<!DOCTYPE html>
<html>
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>修改/重置密码</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta charset="utf-8" />
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
		<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
		<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
		<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'> -->
		<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
	
		<script src="/views/common/js/jquery.min.js" ></script>
		<script src="/views/common/js/jquery.validate.js"></script>
		<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
		
		<script src="/views/common/js/bootstrap.min.js"></script> 
		<script src="/views/common/js/matrix.js"></script> 
		<script type="text/javascript">
		function checkPassword(){
			var usercode = $("#usercode").val();
			var password=$("#oldPassword").val();
			//校验密码是否正确
			var data = {"usercode":usercode,"userpassword": password,};
			$.ajax({
				data:data,
				url:'/update/checkPassword.do',
				type: 'POST',  
		        dataType: 'json',  
				success:function(result){
					if(result.status == 0){
						return true;
					}else{
						document.getElementById("oldPassword").value="";
						$("#oldPassword-error").show().html(result.msg);
						return false;
					}
				}
			});
		}
	function updatePass(){
		var usercode =  $("#usercode").val();
		var password1=$("#oldPassword").val();
		var password=$("#password").val().trim();
		//校验密码是否正确
		var data = {"oldPassword":password1,"usercode":usercode,"userpassword": password,};
		$.ajax({
			data:data,
			url:'/update/updatepass.do',
			type: 'POST',  
	        dataType: 'json',  
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					window.location="/";
					return true;
				}else{
					$("#oldPassword-error").show().html(result.msg);
					return false;
				}
			}
		});
	}
	function setPassword(){
		var usercode = $("#xguser").val();
		if(usercode==null || usercode==""){
			usercode =  $("#usercode").val();
		}
		
		$.ajax({
			url:'/update/setPassword.do?usercode='+usercode,
			type: 'POST',  
	        dataType: 'json',  
			success:function(result){
				if(result.status == 0){
					alert(result.msg);
					window.location="/";
					return true;
				}else{
					alert(result.msg);
					return false;
				}
			}
		});
	}
		$(function(){
	   		$(".zyh_cz_box").hide();
			$(".zyh_cz_wrod").click(function(){
				$(".whh_table").hide();
				$(".zyh_cz_box").show();  
			})
			$(".zyh_xg_wrod").click(function(){
				$(".whh_table").show();
				$(".zyh_cz_box").hide();	
			})
			$(".whh_h2 a").click(function(){
				$(this).addClass("cur").siblings().removeClass("cur");
			})
			$("#signupForm").validate({
				rules: {
					oldPassword:{
			    		required: true,
					},
				    password: {
						required: true,
				    },
					confirm_password: {
			          required: true,
			          equalTo: "#password"
			        }
	      		},
				messages: {
					oldPassword: {
			        	required: "请输入当前密码",
			        },
			        password: {
			        	required: "请输入新密码",
			        },
			        confirm_password: {
			          	required: "请确认新密码",
			          	equalTo: "与输入密码不一样，请重新输入",
			        }
			    },
			    submitHandler : function(){
					$.ajax({
						url:'/update/updatepass.do',
						dataType:'json',
						type:'post',
						data:$('#signupForm').serialize(),
						success:function(result){
							if(result.status == 0){
								alert(result.msg);
								window.location="/";
								return true;
							}else{
								alert(result.msg);
								return false;
							}
						}
					})
			    }
			})
		})
		$(document).ready(function(){
			initMemu(0,1);
		})
		</script>
	</head>
<body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
     	<a href="" title="密码区域" class="current">密码区域</a>
    </div>
  </div>

  <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>密码区域</h5>
          </div>
          <div class="widget-content clearfix">
          		<form name="signupForm" method="post" id="signupForm">
			       <div class="whh_content">
			          <h2 class="whh_h2"><i class="whh_line fl"></i><a  class="zyh_xg_wrod cur">修改密码 </a>|<a class="zyh_cz_wrod">重置密码</a></h2>
			          <div class="zyh_cz_box">
			               <select id="xguser">
			               		<option value="">请选择</option>
			               		<c:forEach items="${userlist}" var="czuser">
			               			<option value="${czuser.usercode}">${czuser.realname}</option>
			               		</c:forEach>
			               </select>
			                <a href="javascript:void(0);" class="zyh_xbtn" onclick="setPassword()">重置</a>
			
			          </div>
			          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table" id="menu">
			             <tr>
			                <td width="40%" class="whh_right"><span class="xing">*</span>当前密码：</td>
			                <td><input type="password" class="whh_input" placeholder="请输入当前密码"  name="oldPassword" id="oldPassword" onblur="checkPassword()"/>
			                	<input type="hidden" id="usercode" name="usercode" value="${user.usercode }"> 
			                </td>
			             </tr>
			             <tr>
			                <td class="whh_right"><span class="xing">*</span>新 密 码：</td>
			                <td><input type="password" class="whh_input" placeholder="请输入新密码"  name="password" id="password"/></td>
			             </tr>
			             <tr>
			                <td class="whh_right"><span class="xing">*</span>确认新密码：</td>
			                <td><input type="password" class="whh_input" placeholder="请确认新密码" name="confirm_password" id="confirm_password"/></td>
			             </tr>
			             <tr>
			                <td class="whh_right"></td>
			                <td>
			                   <input type="submit"  class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="确定">
			                </td>
			             </tr>
			          </table>
			       </div>
			    </form>
          </div>
        </div>
  </div>
</div>

  <%--  
   <div class="whh_wraper">
    <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content">
          <h2 class="whh_h2"><i class="whh_line fl"></i><a  class="zyh_xg_wrod cur">修改密码 </a>|<a class="zyh_cz_wrod">重置密码</a></h2>
          <div class="zyh_cz_box">
               
                <a href="javascript:void(0);" class="zyh_xbtn" onclick="setPassword()">重置</a>

          </div>
          <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table" id="menu">
             <tr>
                <td width="40%" class="whh_right"><span class="xing">*</span>当前密码：</td>
                <td><input type="password" class="whh_input" placeholder="请输入当前密码"  name="oldPassword" id="oldPassword" onblur="checkPassword()"/>
                	<input type="hidden" id="usercode" name="usercode" value="${user.usercode }"> 
                </td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>新 密 码：</td>
                <td><input type="password" class="whh_input" placeholder="请输入新密码"  name="password" id="password"/></td>
             </tr>
             <tr>
                <td class="whh_right"><span class="xing">*</span>确认新密码：</td>
                <td><input type="password" class="whh_input" placeholder="请确认新密码" name="confirm_password" id="confirm_password"/></td>
             </tr>
             <tr>
                <td class="whh_right"></td>
                <td>
                   <input type="submit"  class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="确定">
                </td>
             </tr>
          </table>
       </div>
    </form>
   </div> --%>
 </body>
</html>