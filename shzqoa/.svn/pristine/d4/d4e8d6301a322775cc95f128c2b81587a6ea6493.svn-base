<%@ page language="java" import="java.util.*,java.io.*"  
pageEncoding="utf-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme() + "://"  
    + request.getServerName() + ":" + request.getServerPort()  
    + path + "/"; 
String filename = (String)request.getAttribute("filename");
String errormsg = (String)request.getAttribute("errormsg");
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
<head>  
   <base href="<%=basePath%>">  
</head>  
 <%  
 	out.clear();  
  	out = pageContext.pushBody();  
 	if(errormsg ==null || errormsg == ""){
 	   response.setContentType("application/pdf");  
 	  
 	   try {  
 	    String strPdfPath = new String(filename);  
 	    //判断该路径下的文件是否存在  
 	    File file = new File(strPdfPath);  
 	    if (file.exists()) {  
 	     DataOutputStream temps = new DataOutputStream(response.getOutputStream());  
 	     DataInputStream in = new DataInputStream(new FileInputStream(strPdfPath));  
 	  
 	     byte[] b = new byte[2048];  
 	     while ((in.read(b)) != -1) {  
	 	      temps.write(b);  
	 	      temps.flush();  
 	     }  
 	  
	 	     in.close();  
	 	     temps.close();  
 	    } else {  
 	     	out.print(strPdfPath + " 文件不存在!");  
 	    }  
 	   } catch (Exception e) {  
 	    	out.println(e.getMessage());  
 	   }  
 	}else{
 		out.println("查看文档出错");  
 	} 
   
%> 
<body>  
   <br>  
</body>  
</html>  