<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.shzqoa.model.Rights"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>用户组绑定权限</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/ztreedemo.css" type="text/css">
  <link rel="stylesheet" href="/views/resource/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="/views/resource/js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="/views/resource/js/jquery.ztree.excheck.js"></script>
    
 </head>
 <style> 
 .whh_h2_bg span{font-family: "Microsoft YaHei",Arial,Helvetica;font-size: 21px;color: #666;}
 .whh_tab_bor{ overflow:hidden;}
 .zyh_table{ border:#CCC 1px dashed; float:left; margin-right:20px;}
 .zyh_table th,td{ border:none;}
 .zyh_tab_box{ margin-left: 150px;; overflow:hidden;}
 .zyh_btt1{width:100px; height:35px; border-radius:3px;text-align: center;background-color: #009fe8;border: none; color:#fff; cursor:pointer;margin: 30px 0 30px 420px;}
 
 .zyh_th{background-color:#009fe8;
    color: #fff;
    line-height: 35px;
    font-size: 14px;}
   .zyh_wid{width:120px;}
  .zyh_wid1{width:19px;}
  .zyh_wid2{width:231px;}
  div.zTreeDemoBackground{
  	width:231px;
  	margin:0 auto;
  	text-align:center;
  }
  .groupdiv{
  	width:50%;
  	float:left;
  	padding:0 0 50px;
  }
 </style>
<script type="text/javascript">
/*
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
			        url: "/groupright/getCheckList2ByCheck1.do",
			        data: {"list1Check":$(this).val()},
			        dataType: "json",
			        success: function(result){
			       	 if(result.status == 0){
			       		$(':checkbox[name=list2Check]').removeAttr('checked');
			       		var checkList2 = result.getList2;
			       		$(':checkbox[name=list2Check]').each(function(k, checke2obj){
			       			for(var i in  checkList2){
			       				var check2Info = checkList2[i];
			       				if(check2Info.rightid==checke2obj.value){
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
}); */
function setGroupRight(){
	var list1Check = checkgroupDemo();
	var list2Check = checktreeDemo();
	$.ajax({
        type: "post",
        url: "/groupright/setUserGroup.do",
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
function checkgroupDemo() {
	var treeObj = $.fn.zTree.getZTreeObj("groupDemo");
	var nodes = treeObj.getCheckedNodes();

    var classpurview = "";
    for(var i=0;i<nodes.length;i++) {
         classpurview += nodes[i].id;
    }
    return classpurview;
}
function checktreeDemo() {
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes();

    var classpurview = "";
    for(var i=0;i<nodes.length;i++) {
         classpurview += nodes[i].id+",";
    }
    return classpurview;
}

var setting = {  
		async: {
			enable : true,
			url : "",
			autoParam : [],
			contentType : "application/x-www-form-urlencoded"
		},
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
		
	}; 
var setting2 = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "level"
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onCheck: beforeClick
		}
	};

var zTree;  
var treeNodes;  
$(function(){
	$.ajax({
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: "/groupright/doGetGroupTree.do",//请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。    
            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
        }  
    });  
    $.fn.zTree.init($("#groupDemo"), setting2, treeNodes);
    
    
    var checknod = getFirst();
    $.ajax({  
    	data:{"groupid":checknod,},
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: "/groupright/doGetPrivilegeTree.do",//请求的action路径 
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。    
            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
        }  
    });  
    $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
    
});
function getFirst(e,treeId,treeNode){
    var treeObj=$.fn.zTree.getZTreeObj("groupDemo"),
    nodes=treeObj.getCheckedNodes(true),
    v="";
   	v=nodes[0].id;
    return v;
}
function beforeClick(e, treeId, treeNode){
	 $.ajax({  
	    	data:{"groupid":treeNode.id,},
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: "/groupright/doGetPrivilegeTree.do",//请求的action路径 
	        error: function () {//请求失败处理函数  
	            alert('请求失败');  
	        },  
	        success:function(data){ //请求成功后处理函数。    
	            treeNodes = data;   //把后台封装好的简单Json格式赋给treeNodes  
	        }  
	    });  
	    $.fn.zTree.init($("#treeDemo"), setting, treeNodes);
}


</script>
 <body>
   <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>用户组绑定权限</span></h2>
         <div class="whh_tab_bor">
       		<div class="groupdiv">
				<div class="zTreeDemoBackground left">
					<ul class="zyh_th">用户组</ul>
					<ul id="groupDemo" class="ztree"></ul>
				</div>
			</div>
			<div class="groupdiv">
				<div class="zTreeDemoBackground right">
					<ul class="zyh_th">权限</ul>
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
       		<!-- 
			<table width="30%" border="1" class="zyh_table" style="margin-right: 170px;" >
				<c:forEach var="item" begin="0" items="${list1}" varStatus="status">
					  <tr>
					  	<td class="zyh_wid">&nbsp;</td>
					    <td class="zyh_wid1" scope="row"><input type="checkbox" name="list1Check" <c:if test="${status.index==0}">checked</c:if> value=${item.groupid}></td>
					    <td class="zyh_wid2"><label  for="checkboxOneInput">${item.groupname}</label></td>
					  </tr>
				</c:forEach>
			</table> -->
			<!-- 
			<table width="30%" border="1" class="zyh_table" id="list2">
				<th colspan="3" class="zyh_th">权限</th>
				<div class="zTreeDemoBackground right">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
				
				<c:forEach var="item" begin="0" items="${list2}" varStatus="status">
				   <tr>
				  	<td class="zyh_wid">&nbsp;</td>
				    <td class="zyh_wid1" scope="row"><input type="checkbox" name="list2Check" <c:forEach var='item2' begin='0' items='${list3}' varStatus='status2'><c:if test='${item2.rightid==item.rightid}'>checked</c:if></c:forEach> value=${item.rightid}></td>
				    <td class="zyh_wid2">${item.rightname}</td>
				  </tr>
				</c:forEach>
			</table>-->
          
          

		</div>
		<input class="zyh_btt1" type="button" value="确 认" onclick="setGroupRight()" />
       </div>
   </div>
 </body>
</html>