<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>用户绑定用户组</title>
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
  <script src="/views/common/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
 </head>
 <style>
.whh_content{background: #fff;}
.whh_content_border{ border:none;}
.whh_tab_bor{ overflow:hidden;}
.zyh_table{ border:#CCC 1px dashed; float:left; margin-right:20px;}
.zyh_table th,td{ border:none;}
.zyh_tab_box{ margin-left: 150px;; overflow:hidden;}
.zyh_btt1{width:100px; height:35px; border-radius:3px;text-align: center;background-color: #009fe8;border: none; color:#fff; cursor:pointer;margin: 30px 0 30px 420px;}
.zyh_th{background-color:#009fe8;color: #fff;line-height: 35px;font-size: 14px;}
.zyh_wid{width:120px;}
.zyh_wid1{width:19px;}
.zyh_wid2{width:231px;}
 </style>
<script type="text/javascript">
$(document).ready(function(){
	  initMemu(0,5);
})
$(document).ready(function(){
	$(':checkbox[name=list1Check]').each(function(){
		$(this).click(function(){ 
			var checkflag = $(this).attr('checked');
			if(checkflag == 'checked'){
				$(this).removeAttr('checked');
				$(':checkbox[name=list2Check]').removeAttr('checked');
			}else{
				$(this).attr('checked',"checked");  
				$(this).parents("tr").siblings().find(":checkbox[name='list1Check']").removeAttr('checked');
				
				$.ajax({
			        type: "post",
			        url: "/usergroup/getCheckList2ByCheck1.do",
			        data: {"list1Check":$(this).val()},
			        dataType: "json",
			        success: function(result){
			       	 if(result.status == 0){
			       		$(':checkbox[name=list2Check]').removeAttr('checked');
			       		var checkList2 = result.getList2;
			       		$(':checkbox[name=list2Check]').each(function(k, checke2obj){
			       			for(var i in  checkList2){
			       				var check2Info = checkList2[i];
			       				if(check2Info.groupid==checke2obj.value){
			       					checke2obj.checked=true;
			       				}
			       			}
			       		});
			       	 }else{
			       		 alert(result.msg);
			       	 }
			        }
			    });
			}
		}); 
	}); 
}); 
function setUserGroup(){
	var list1Check = $("input[name='list1Check']:checked").val();
	var list2Check = "";
	$("input:checked[name='list2Check']").each(function() {
		list2Check += this.value + ",";
    });
	$.ajax({
        type: "post",
        url: "/usergroup/setUserGroup.do",
        data: {"list1Check":list1Check,"list2Check":list2Check,},
        dataType: "json",
        success: function(result){
       	 if(result.status == 0){
       		 alert(result.msg);
       		 parent.location.reload();
       	 }else{
       		 alert(result.msg);
       	 }
        }
    });
}
function searchuser(){
	var seauser = $("#seauser").val().toUpperCase();
	if(seauser==null || seauser==""){
		$("#table1 tr").each(function(){
			var elf = $(this).find(".zyh_th").size();
			if(elf==0){
				$(this).css("display","block");
			}
		});
	}else{
		$("#table1 tr").each(function(){
			var elf = $(this).find(".zyh_th").size();
			var uname = $(this).find(".zyh_wid2").text().toUpperCase();
			if(seauser != uname && elf ==0){
				$(this).css("display","none");
			}
		});
	}
	
}
</script>
 <body>
 <jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
	     	<a href="" title="合作公司--联系人管理" class="current">合作公司--联系人管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>合作公司--联系人管理</h5>
          </div>
          <div class="widget-content clearfix">
          	<div class="zyh_tab_box">
          	<div><input type="text" id="seauser" name="seauser" onblur="searchuser()" /></div>
			<table width="30%" border="1" class="zyh_table" style="margin-right: 170px;" id="table1">
				<th colspan="3" class="zyh_th">用户</th>
				<c:forEach var="item" begin="0" items="${list1}" varStatus="status">
					  <tr>
					  	<td class="zyh_wid">&nbsp;</td>
					    <td class="zyh_wid1" scope="row"><input type="checkbox" name="list1Check" <c:if test="${status.index==0}">checked</c:if> value="${item.usercode}"></td>
					    <td class="zyh_wid2"><label  for="checkboxOneInput">${item.realname}</label></td>
					  </tr>
				</c:forEach>
			</table>
			<table width="30%" border="1" class="zyh_table" id="list2">
				<th colspan="3" class="zyh_th">用户组</th>
				<c:forEach var="item" begin="0" items="${list2}" varStatus="status">
				   <tr>
				  	<td class="zyh_wid">&nbsp;</td>
				    <td class="zyh_wid1" scope="row"><input type="checkbox" name="list2Check" <c:forEach var='item2' begin='0' items='${list3}' varStatus='status2'><c:if test='${item2.groupid==item.groupid}'>checked</c:if></c:forEach> value=${item.groupid}></td>
				    <td class="zyh_wid2">${item.groupname}</td>
				  </tr>
				</c:forEach>
			</table>
          </div>
          <input class="zyh_btt1" type="button" value="确 认" onclick="setUserGroup()" />
          </div>
        </div>
  </div>
</div>
 </body>
</html>