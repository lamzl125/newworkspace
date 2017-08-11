<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>任务进度</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/viewsresource/js/jquery.validate.js"></script>
  <script src="/viewsresource/my97/WdatePicker.js" type="text/javascript"></script>
  <script type="text/javascript">
   
  </script>
 </head>
 <style>
 /*弹框  新增*/
.zyh_riz_tan{ width:100%;border-radius: 5px;}
.zyh_tan_kun{margin:10px;}
.zyh_tan_kun h1{text-align:center; font-size:16px; line-height:40px;}
.zyh_tan_kun span{text-align:center; display:block; width:100%; font-size:14px; margin-bottom:5px;}
.zyh_tan_kun p{text-indent:2em;}
 </style>
<body>
<div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>任务进度列表</span></h2>          
          <div class="whh_tab_bor">
              <table style="word-break:break-all;"  cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                   	<th width="50%">任务</th><th width="50%">进度</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(workTasks) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">未查询到任务信息</td>
				    </tr>
				</c:if>
                <c:forEach items="${workTasks}" var="info" varStatus="infostatus">
					<tr>
					    <td>${info.publishContent}</td>
					    <td>${info.logContent}</td>
				  	</tr>
				</c:forEach>
                </tbody>
              </table>
          </div>
       </div>
   </div>
</body>
</html>