<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>修改物资信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <link rel="stylesheet" href="/views/resource/css/zyh_style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/layer/layer.js"></script>
  <script type="text/javascript"></script>
  <script type="text/javascript">
  
  function modifyitem(){
	  	  var id=$("#id").val();
	   	  var name = $("#name").val();
		  
	  var data = {
			  	"id": id,
			  	"name": name,
	  }
	  $.ajax({
          type: "post",
          url: "/items/updateitem.do",
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
  </script>
 </head>
 <body>
  <div class="whh_tab_bor">
  <input type="hidden" value="${list.id}" id="id"/>
            <div class="zyh_sos">
               <span>物资名称：</span>
                <input type="text" class="whh_input" id="name" value="${list.name}">
                <div style="text-align:center; vertical-align:middel;">
		 <input type="button" class="zyh_btn" onclick="modifyitem()" value="修改">
	</div>
            </div>
         </div>

 </body>
</html>