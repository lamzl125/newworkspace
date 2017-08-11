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
	<input type="hidden" value="${taskallotid }" id="taskallotid"/>
		<div class="whh_tab_bor whh_coustomercode" id="alltaskJoin">
 
			<c:forEach items="${list }" var="t">
				 <label><input type="checkbox" value="${t.customercode }" name="customercode">${t.customername }</label> 
			</c:forEach>
 
		</div>
	</div>
	<div class="btndiv"><a href="javascript:void(0);" onclick="bantan()" class="allotTask">绑定</a></div>
</body>
<script type="text/javascript">
function getCustomercodes(){
	var ids = "";
	$("input[name='customercode']").each(function(){
		if($(this).is(':checked')){
			ids += $(this).val()+",";
		}
	})
	ids = ids.substring(0, ids.length-1);
	return ids;
} 
function bantan(){
	var customercode=getCustomercodes();
	var taskallotid=$("#taskallotid").val().trim();
	if(customercode==""){
		alert("请选择数据");
		return
	}
	var data = {
			"customercode":customercode,
			"taskallotid":taskallotid
		}

		 $.ajax({
			data : data,
			url : "/taskallotdetails/saveJoinCustomer.do",
			success : function(result) {
				if (result.status == 0) {
					alert("操作成功！");
					parent.location.reload();
				} else if (result.status != 0) {
					alert(result.msg);// 操作失败
				}
			},
			error : function() {
				alert("系统错误,操作失败");
			}
		});
}

</script>
</html>