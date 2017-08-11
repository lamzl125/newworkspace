<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head> 
  		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  		<title>提示信息</title>
  		<meta charset="utf-8" />
  		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  		<link rel="stylesheet" href="resource/css/style.css">
  		<script src="resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  		<script src="resource/js/jquery.validate.js"></script>
  		<style type="text/css">
  			.whh_tab1 th{background: #ffe2c7;padding:12px 0;}
			.whh_tab1 td{text-align: center;padding:12px 0;border-bottom: 1px dashed #d9d9d9;}
  		</style>
 	</head>
	<body>	
		<c:if test="${fn:length(list) == 0}">
			<h3>暂时没有提示信息！！</h3>
		</c:if>
		<c:forEach items="${list}" var="item" begin="0" end="0">
			<h3 style="color: red;">以下合作公司即将到期！！！</h3>
			<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
				<thead>
					<tr>
                     	<th>公司名称</th>
                     	<th>合作结束时间</th>
                     	<th>剩余天数</th>
                 	</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.CorpName}</td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${item.EndTime}" /></td>
						<td>${item.cueDay}</td>
					</tr>
					</c:forEach>
				</tbody>
			
			</table>
		</c:forEach>
	</body>
</html>