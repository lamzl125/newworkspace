<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	<a href="<%=basePath %>test/addPage.do">添加新用户</a> <br>
  	<a href="<%=basePath %>test/queryPage.do">查询用户信息</a> <br>
    <a href="<%=basePath %>test/userlistPage.do">用户信息列表</a> <br>
    <a href="<%=basePath %>test/deletePage.do">删除用户信息</a> <br>
  </body>
</html>
