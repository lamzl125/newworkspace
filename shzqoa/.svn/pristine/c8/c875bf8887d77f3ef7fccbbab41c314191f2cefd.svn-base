<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求普工信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
  <link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
  <link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
  <link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="/views/common/css/zyh_style.css" />
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <style>
.formdiv{margin:10px;width:98%;padding:10px;height:500px;overflow-y:scroll;}
.workerdiv{float:left;width:150px;height:35px;padding:0px;}
.btndiv{width:100%;align:center;text-align:center;}
</style>
  <script type="text/javascript">  
  function saveInfo(){
	  var demandId=$("#demandId").val();
	  var workerids = "";
	  $("input[name='checkworker']:checked").each(function(){
			if(workerids!=""){
				workerids += ",";
			}
			workerids += $(this).val();
	  });
	  var data = {"demandId": demandId,"workerids": workerids,}
	  $.ajax({
          type: "post",
          url: "/workdemand/saveDemandWorker.do",
          data: data,
          dataType: "json",
          success: function(result){
        	  alert(result.resultMessage);
         	 if(result.success == true){
         		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
         	 }
          }
      });
	  
	  
	  /* $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	   */
  }
  </script>
 </head>
<body  style="background-color:#F9F9F9;">
	<div class="formdiv">
		<input type="hidden" value="${demand.demandId}" id="demandId"/>
		<c:forEach items="${allworkers}" var="worker">
			<div class="workerdiv">
				<input type="checkbox" name="checkworker" 
					<c:forEach items="${workers}" var="bindworker">
						<c:if test="${bindworker.WorkerId eq worker.workerId}">checked</c:if>
					</c:forEach> 
				value="${worker.workerId}" >${worker.workerName}
			</div>
		</c:forEach>
	</div>
	<div class="btndiv">
		<button type="button" class="btn btn-success" onclick="saveInfo()">提交</button>
	</div>
</body>
</html>