<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>测试</title>
  </head>

  <body>
	 <form method="post" action="../test/addUser.do">  
    <h3>添加</h3>  
    <label>用户名:</label><input type="text" name="userName" >  
    <br> <br>   
    <label>密码:</label><input type="password" name="password" >  
    <br> <br> 
    <div style="text-align: center">  
        <button type="submit">注册</button>    
        <button type="reset">重置</button>  
        <br>  
    </div>  
    </form>  
  </body>
</html>
