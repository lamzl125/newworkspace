<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>添加简历</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
 </head>
 <style>
 .whh_tab_bor {overflow: hidden;}
 .resdiv {width: 200px;float: left;margin-bottom: 30px;}
 .zyh_btt1 {width: 100px;height: 35px;border-radius: 3px;text-align: center;background-color: #009fe8;border: none;color: #fff;cursor: pointer;margin: 30px 0 30px 420px;}
</style>
<script>
function adddemand(){
	var demandId = $("#demandId").val();
	var customercodes = "";
	$("input[name='customercode']:checked").each(function(){
		if(customercodes!=""){
			customercodes += ",";
		}
		customercodes += $(this).val();
	});
	var data = {"demandid":demandId,"customercodes":customercodes};
	$(".zyh_btt1").attr('disabled',true);
	$(".zyh_btt1").css('background',"#CCCCFF");
	$.ajax({
		url:"/partjob/demandaddresume.do",
		dataType:'json',
		type:'post',
		data:data,
		success:function(result){
			alert(result.resultMessage);
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		 	parent.layer.close(index);
		}
	})
}
</script>
 <body>
 	<input type="hidden" id="demandId" value="${demandId}" /> 
     <h2 class="whh_h2_bg"><span>添加简历列表</span></h2>
     <div class="whh_tab_bor">
     		<c:forEach items="${list}" var="cc">
     			<div class="resdiv">
     				<input type="checkbox" name="customercode" value="${cc.CustomerCode}"/>${cc.CustomerName }&nbsp;&nbsp;|${fn:substring(cc.CustomerTel, 0, 3)}****${fn:substring(cc.CustomerTel, 7, -1)}
     			</div>
          	</c:forEach>
          	<input class="zyh_btt1" type="button" value="确 认" onclick="adddemand()" />
     </div>
 </body>
</html>