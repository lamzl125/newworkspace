<%@ page language="java" import="java.util.*,com.testSSM.test.model.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>查询结果</title>
  </head>
<%
	User user = new User();
	if(request.getAttribute("user") !=null)
		user =(User)request.getAttribute("user");
	else
		user =null;
%>
  <body>
    <table>
   	<%if(user !=null) {%>
   		<tr><td>${user.id}</td><td>${user.userName}</td><td>${user.password}</td></tr>
   	<%} else{%>
   		<tr><td>没有查询到相关用户信息！</td></tr>
   	<%} %>
    </table>
  </body>
</html>
