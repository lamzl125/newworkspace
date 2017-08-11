<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务分配详情</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
</head>
<body>
	<div class="contains">
		<div class="whh_tab_bor">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"
				class="whh_tab1">
				<thead>
					<tr>
						<th>执行人</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>任务量</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="t">
						<tr>
							<td>${t.realName }</td>
							<td><fmt:formatDate value="${t.starttime }" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${t.endtime }" pattern="yyyy-MM-dd"/></td>
							<td>${t.allotnum }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>