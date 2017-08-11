<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>待面试人员列表</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<style type="text/css">
.btndiv {
    position: absolute;
    width: 100%;
    bottom: 40px;
}
.allotTask {
    display: block;
    width: 70px;
    height: 35px;
    line-height: 35px;
    background: #4764f5;
    color: #fff;
    margin: 0 auto;
    text-align: center;
}
.contains {
    height: 469px;
}
.whh_coustomercode{overflow:hidden;margin-left:50px;}
.whh_coustomercode label{
 margin:0 7px 8px 0;
 width:90px;
 display:block;
 white-space:nowrap; 
 overflow:hidden; 
 text-overflow:ellipsis;
 float:left;
}
</style>
</head>
<body>
	<div class="contains">   
		<div class="whh_tab_bor whh_coustomercode" id="alltaskJoin">
 
			<c:forEach items="${custList }" var="t">
				 <label><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${t.customercode }" target="_blank">${t.customername }</a></label> 
			</c:forEach>
 
		</div>
	</div>
</body>
</html>