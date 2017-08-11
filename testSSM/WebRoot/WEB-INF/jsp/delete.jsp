<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script> 
	<title>删除</title>
	<script type="text/javascript">
	function del(){
		var userID= document.getElementById('userID').value;
		$.get("<%=basePath%>test/delete.do?id=" + userID,function(data){
			if("success" == data.result){
				alert("删除成功");
				window.location.reload();
			}else{
				alert("删除失败");
			}
		});
	}
	</script>
  </head>

  <body>
  
    <h3>删除</h3>  
    <label>用户ID:</label><input id="userID" type="text" name="id" >  
    <br> <br>   
    <div style="text-align: center">  
        <a href="javascript:del()">删除</a>   
        <button type="reset">重置</button>  
        <br>  
    </div>  
     
  </body>
</html>
