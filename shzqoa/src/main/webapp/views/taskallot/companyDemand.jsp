<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>公司需求详情</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="/views/resource/js/jquery.nicescroll.js"></script>
<style type="text/css">
	body {
	    margin: 0px;
	}
	.contains {
		width: 100%;
	    height: 307px;
	    overflow: hidden;
	}
	.companyContentTitle tr th,
	.companyContentBody tr td {
		width: 50%;
	}
	.companyContentBody {
		height: 263px;
		overflow: auto;
	}
</style>
</head>
<body>
	<div class="contains">
		<div class="companyContentTitle">
			<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
				<thead>
					<tr>
						<th>公司名称</th>
						<th>需求详情</th>
					</tr>
				</thead>
			</table>
		</div>
		<div class="companyContentBody">
			<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
				<tbody id="test">
					<c:forEach items="${list }" var="c">
						<tr>
							<td>${c.corpName }</td>
							<td>${c.specificrequirement }</td>
<%-- 							<td>${(c.demandnumber eq null || c.demandnumber eq '') ? '不限':c.demandnumber}</td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('.companyContentBody').niceScroll({ 
	    cursorcolor: "#ccc",//#CC0071 光标颜色 
	    cursoropacitymax: 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0 
	    touchbehavior: false, //使光标拖动滚动像在台式电脑触摸设备 
	    cursorwidth: "5px", //像素光标的宽度 
	    cursorborder: "0", //     游标边框css定义 
	    cursorborderradius: "5px",//以像素为光标边界半径 
	    autohidemode: false //是否隐藏滚动条 
	});
</script>
</html>