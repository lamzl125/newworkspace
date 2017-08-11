<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>厂区负责人信息</title>
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
  </script>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          <input type="hidden" value="${map.plantHeaderId}" id="plantHeaderId"/>
            <div class="control-group">
              <label class="control-label">厂区Id：</label>
              <div class="controls">
              		<c:forEach var="item" begin="0" items="${factorylist}" varStatus="status">
              			<c:if test="${map.plantId==item.id}">
              				${item.name}
              			</c:if>
                    </c:forEach>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">负责人Id：</label>
              <div class="controls">
              		<c:forEach var="item" begin="0" items="${userlist}" varStatus="status">
              			<c:if test="${map.userCode==item.usercode}">
              				${item.realname}
              			</c:if>
	                 </c:forEach>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">添加人：</label>
              <div class="controls">
              		<c:forEach var="item" begin="0" items="${userlist}" varStatus="status">
              			<c:if test="${map.addPeople==item.usercode}">
              				${item.realname}
              			</c:if>
	                 </c:forEach>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">添加时间：</label>
              <div class="controls"><fmt:formatDate pattern='yyyy-MM-dd' value='${map.addTime}' /></div>
            </div>
            <div class="control-group">
              <label class="control-label">状态：</label>
              <div class="controls">${map.statusFlag==1?'正常':map.statusFlag==2?'作废':''}</div>
            </div>
            <div class="control-group">
              <label class="control-label">作废时间：</label>
              <div class="controls"><fmt:formatDate pattern='yyyy-MM-dd' value='${map.cancellationTime}' /></div>
            </div>
            <div class="control-group">
              <label class="control-label">作废人 :</label>
              <div class="controls">
              		<c:forEach var="item" begin="0" items="${userlist}" varStatus="status">
              			<c:if test="${map.invalid==item.usercode}">
              				${item.realname}
              			</c:if>
	                 </c:forEach>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 </body>
</html>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title></title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <link rel="stylesheet" href="/views/resource/css/uploadify.css">
  <script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
   <div class="whh_wraper">
   <form name="signupForm" method="post" id="signupForm">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>厂区负责人信息</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>厂区负责人Id：</td>
                   <td>${map.plantHeaderId}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>厂区Id：</td>
                   <td>${map.plantId}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>负责人Id：</td>
                   <td>${map.userCode}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>添加人：</td>
                   <td>${map.addPeople}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>添加时间：</td>
                   <td>${map.addTime}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>状态：</td>
                   <td>${map.statusFlag==1?'正常':map.statusFlag==2?'作废':''}</td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>作废时间	：</td>
                   <td>${map.cancellationTime}</td>
                 </tr>
                 <tr>
                   <td class="whh_right">作废人：</td>
                   <td>${map.invalid}</td>
                 </tr>
                </tbody>
              </table>
          </div>

       </div>
   </form>
   </div>
 </body>
</html> --%>