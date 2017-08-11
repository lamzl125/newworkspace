<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务分配</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
<script type="text/javascript" src="/views/resource/my97/WdatePicker.js"></script>
<style type="text/css">
	.contains {
		width: 100%;
		height: 444px;
	}
	.layui-layer-tips {
		margin-top: -50px;
	}
	.layui-layer-tips .layui-layer-content {
		padding: 0px 10px;
	}
	.selUser {
		margin-top: 25px;
		margin-left: 20px;
		height: 25px;
	}
	.selUser label {
		padding-left: 20px;
	}
	.selUser select {
	    width: 80px;
	}
	.selUser input {
		width: 100px;
	}
	#allotnum {
		width: 60px;
		height: 18px;
	}
	.addTask {
		width: 60px;
	    background: #01d24a;
	    border: 0px;
	    height: 24px;
	    margin-left: 36px;
	    color: #fff;
	    cursor: pointer;
	}
	.addTask:hover {
	    background: #00c144;
	}
	
	.addTask:active {
	    background: #00e650;
	}
	a.removeTask {
	    display: inline-block;
	    background: #ff4646;
	    width: 50px;
	    color: #fff;
	}
	
	a.removeTask:hover,
	a.removeTask:active,
	a.removeTask:focus {
	    color: #fff;
	    background: #ff4646;
	}
	.btndiv {

		width: 100%;
		margin-bottom: 30px;
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
	.allotTask:hover,
	.allotTask:active,
	.allotTask:focus {
	    color: #fff;
	}
	.allotTask:hover {
		background: #3656f9;
	}
	.allotTask:active {
		background: #607bff;
	}
</style>
</head>
<body>
	<div class="contains">
		<input type="text" hidden id="taskData" value='${taskData }'/>
		<div class="selUser">
			<label>执行人：</label>
			<select id="user">
				<option value="">--请选择--</option>
				<c:forEach items="${users }" var="u">
					<option value="${u.usercode }">${u.realname }</option>
				</c:forEach>
			</select>
			<label>开始时间：</label>
			<input id="starttime" type="text" class="Wdate" readOnly onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endtime\')}'});"/> 
			<label>结束时间：</label>
			<input id="endtime" type="text" class="Wdate" readOnly onFocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\')}'});"/>
			<label>任务量：</label><input id="allotnum"/>
			<button class="addTask">添加</button>
			
		</div>
		<div class="whh_tab_bor">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"
				class="whh_tab1">
				<thead>
					<tr>
						<th>执行人</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>任务量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="allotdetails">
					<!-- <tr>
						<td>李四</td>
						<td>2015-09-09</td>
						<td>2015-10-00</td>
						<td>22</td>
						<td><a href="javascript:void(0);" class="removeTask">移除</a></td>
					</tr> -->
				</tbody>
			</table>
		</div>
<!-- 		<div class="btndiv"><a href="javascript:void(0);" class="allotTask">分配</a></div> -->
	<div class="btndiv"><a class="allotTask layui-layer-btn0">分配</a></div>
	</div>

</body>
<script type="text/javascript" src="/views/taskallot/js/allotdetails.js"></script>
</html>