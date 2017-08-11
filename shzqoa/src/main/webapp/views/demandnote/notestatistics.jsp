<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>帖子统计信息</title>
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
.widget-box{ margin-top:10px; margin-bottom:0;}
.form-actions{ text-align:center;}
.form-horizontal .control-label{width: 320px;}
.form-horizontal .controls{margin-left: 339px;}
.span11.zyh_cursor{ cursor:pointer;}
</style>
  <script type="text/javascript">  
  function saveInfo(){
	  	var demandnoteid = $("#demandnoteid").val();	  	  
	  	  var daypageview=$("#daypageview").val();
	  	  var allpageview = $("#allpageview").val();	  	
	  var data = {
			  	"demandnoteid": demandnoteid,"daypageview": daypageview,"allpageview":allpageview,
	  }
	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	  $.ajax({
          type: "post",
          url: "/demandnotestatistics/saveNoteStatistics.do",
          data: data,
          dataType: "json",
          success: function(result){
        	  alert(result.resultMessage);
         	 if(result.success == true){
         		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
         	 }else{
         		$(".btn-success").attr("disabled", false); 
       		    $(".btn-success").css("background","#5bb75b");
         	 }
          }
      });
  }
  </script>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          	<input type="hidden" id="demandnoteid" value="${demandnoteid}"/>
            <div class="control-group">
              <label class="control-label">今日浏览量：</label>
              <div class="controls">
                <input type="text" placeholder="今日浏览量" id="daypageview" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">总计浏览量：</label>
              <div class="controls">
                <input type="text" placeholder="总计浏览量" id="allpageview" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            
      
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="saveInfo()">提交</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 </body>
</html>