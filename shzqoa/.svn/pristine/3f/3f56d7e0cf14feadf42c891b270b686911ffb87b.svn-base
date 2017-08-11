<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>回复工作日志</title>
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
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
  	<script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script type="text/javascript">
  	function saveInfo(){
  		var dailylogid = $("#dailylogid").val();
  		var replyinfo = $("#replyinfo").val();
  		var repalyuser = "";
  		$("input[name='username']:checked").each(function (i, n) {
			   if(this.checked){
				   repalyuser += $(this).val();
				   repalyuser+="-";
			    }
		});
  		if(replyinfo==null || replyinfo==""){
  			alert("回复内容不能为空");
  			return false;
  		}
  		if(repalyuser==null || repalyuser==""){
  			alert("至少选择一个指定人员");
  			return false;
  		}
  		var data = {
  			   "dailylogid":dailylogid,
  			   "replyinfo":replyinfo,
  			   "repalyuser":repalyuser
  		   }
  		   $.ajax({
  			   type: "post",
  			   url: "/log/replyLog.do",
  			   data: data,
  			   dataType: "json",
  			   success: function(result){
  				   if(result.status == 1){
  					   alert(result.msg);
  					 	var url = "/log/enter.do?page=1";
  						window.location.href=url;
  				   } else {
  					 	alert(result.msg);
  				   }
  			   }
  		   }); 
  		
  	}
  	$(document).ready(function(){
  	  initMemu(4,1);
    });
  </script>
  <style>
 .whh_tab_bor{padding:20px 0;}
	.whh_sel{ margin-left:360px;}
	.whh_h2 a{ cursor:pointer;}
	.zyh_fangxiang{margin:20px auto;}
	.zyh_boss h1{text-align:center; font-size:16px; color:#333333; display:block; background-color:#59afe4;; line-height:30px; color:#fff;}
	.zyh_boss h1.cor{background-color: #FF7D01;}
	.zyh_name{ width:100%; overflow:hidden;    margin-top: 20px; margin-left: 29px;}
	.zyh_name li{ float:left; margin-right:20px; margin-bottom:20px;width: 90px;}
	.zyh_boss_ren{background-color: #fff; border: #ccc 1px solid; margin-top: 20px; color: #333333;}
	.zyh_caozuo_n{display: inline-block; width: 40px; background-color: #009fe8; color: #fff; cursor: pointer;}
	.zyh_rizhi{ margin-top:20px;}
	.zyh_tarea{width: 99%; min-height:100px; padding:5px;margin-top: -10px;}
	.zyh_select{ width:100%;white-space:nowrap; height:35px;margin-top: -10px;}
	.zyh_p_text{white-space:nowrap; text-overflow:ellipsis; -o-text-overflow:ellipsis; overflow: hidden; }
	
	/*弹框  新增*/
	.zyh_rizhi_tan{position:fixed; left:0; top:0; width:100%; height:100%; background-color:rgba(0,0,0,0.5); z-index:9999; display:none;}
	.zyh_riz_tan{position:absolute; left:50%; top:50%; width:700px; background-color:#fff; margin-left:-350px; height:500px; margin-top:-250px;border-radius: 5px;}
	.zyh_tan_kun{margin:10px; height:430px;}
	.zyh_tan_kun h1{text-align:center; font-size:16px; line-height:40px;}
	.zyh_tan_kun span{text-align:center; display:block; width:100%; font-size:16px; margin-bottom:5px;background-color: #e5e5e5;
    line-height: 30px;border-radius: 3px;}
	.zyh_tan_kun p{text-indent:2em;}
	.zyh_rizhi_btt{width:200px; height:40px; border-radius:3px; margin:0 auto; background-color:#06C; color:#fff; text-align:center; line-height:40px; cursor:pointer;}
    .zyh_rzne{ text-align:center;}
    .zyh_btn_n {width: 50px;line-height: 30px;color: #fff;background-color: #0aa7e6;border: none;border-radius: 5px;margin-left: 8px;cursor: pointer;}
    .zyh_txt {border-radius: 3px;padding-left: 5px;border: #F1F1F1 1px solid;width: 150px;height: 30px;}
    .replylog{display: inline-block; width: 40px;background-color: #FF7E00;color: #fff;}
    
</style>
 </head>
 <body>
 <input type="hidden" id="dailylogid" value="${daily.dailylogid }" />
 <jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
 <div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="工作信息" class="tip-bottom"><i class="icon-home"></i>工作信息</a>
	    	<a href="index.html" title="工作日志" class="tip-bottom"><i class="icon-home"></i>工作日志</a>
	     	<a href="" title="回复工作日志" class="current">回复工作日志</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
             <h5>回复工作日志</h5>
          </div>
          <div class="widget-content clearfix">
          		<form name="signupForm" method="post" action="#" id="signupForm" class="form-inline">
	            	<div class="zyh_boss whh_tab_bor">
		              <div>
		                 <h1>工作日志</h1>
		                 <textarea class="zyh_tarea"  style=" width: 99%; min-height:100px;"  disabled="disabled">${daily.logcontent}</textarea>
		              </div>
		              <div class="mt10">
		                 <h1>问题及建议</h1>
		                 <textarea class="zyh_tarea"  style="width:99%; min-height:100px;"  disabled="disabled">${daily.propose}</textarea>
		              </div>
		              <div class="mt10">
		                 <h1>回复</h1>
		                 <textarea class="zyh_tarea" style=" width: 99%; min-height:100px;" id="replyinfo"></textarea>
		              </div>
		              <div class="zyh_boss_ren">
		                <h1>指定人员</h1>
		                <ul class="zyh_name" id="users">
		                	<c:forEach items="${userlist}" var="info" varStatus="status">
		                		<li><label><input name="username" type="checkbox" value="${info.usercode}">${info.realname}</label></li>
		                	</c:forEach>
		                </ul>
		              </div>
		          </div>
		          <p style="text-align: center;">
		               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" onclick="saveInfo()">
		          </p>
	            </form>
            
          </div>
        </div>
  </div>
</div>
 </body>
</html>