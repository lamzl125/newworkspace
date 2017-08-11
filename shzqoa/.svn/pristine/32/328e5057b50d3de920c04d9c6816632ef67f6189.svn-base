<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求详情信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />

<script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<style type="text/css">
.widget-box{ margin:20px 10px;}
.thisnone,select.thisnone{display: none;width:100px;float:left;}
</style>
</head>
<body style="background:#fff;">
	<div class="span7 clear_float" style="display:block;">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>
            <h5>需求抢取信息</h5> 
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr><th>抢取人</th><th>抢取/分配时间</th><th>抢取顺序</th><th>比例</th></tr>
              </thead>
              <tbody>
                <c:forEach items="${demandsignlist}" var="demandsign">
					<tr>
						<td>
							<c:forEach items="${userlist}" var="user">
								<c:if test="${user.usercode==demandsign.userCode }">${user.realname}</c:if>
							</c:forEach>
						</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								value="${demandsign.signedTime}" /></td>
						<td>${demandsign.singnedIndex }</td>
						<td>${demandsign.proportion }%</td>
					</tr>
				</c:forEach>
              </tbody>
            </table>
            <!--分页
            <div class="pagination alternate page_fr">
              <ul>
                <li class="disabled"><a href="#">Prev</a></li>
                <li class="active"> <a href="#">1</a> </li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">Next</a></li>
              </ul>
            </div>-->
          </div>      
        </div>
	</div> 
</body>
</html>