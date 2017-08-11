<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>物资管理</title>
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


  <script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script>
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
 </head>
 <!-- <style> -->
 <style type="text/css">
  .zyh_btn{
	    width: 30px;
	    height: 30px;
	    font-size: 16px;
	    background-color: #009FE8;
	    border: none;
	    color: #fff;
	}
	.zyh_sos{
	   margin: 0 auto;
	    width: 900px;
	}
	.zyh_txt{ border-radius:3px; padding-left:5px; border:#F1F1F1 1px solid; width:90px; height:30px;}
 .zyh_btn_n{ width:80px; height:30px; color:#fff; background-color:#0aa7e6; border:none; border-radius:5px; margin-left:5px;cursor: pointer;}
  </style>
 <!-- .zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
 .zyh_sos span,.zyh_txt,.zyh_btn_n{ float:left; line-height:30px;}
 .zyh_txt{ border-radius:3px; padding-left:5px; border:#F1F1F1 1px solid; width:90px; height:30px;}
 .zyh_btn_n{ width:80px; height:30px; color:#fff; background-color:#0aa7e6; border:none; border-radius:5px; margin-left:5px;cursor: pointer;}
 </style> -->
 <script type="text/javascript">
 $(document).ready(function(){
 	  initMemu(5,4);
   })
   
   function search(){
	  var name = encodeURI(encodeURI($("#userName").val())); 
	/*  var name=$("#userName").val(); */
	 var url = "/item/itemmanagement.do?name="+name;
 	 window.location.href=url;
 }
 
 function togetListBypage(page){
	 var name = encodeURI(encodeURI($("#userName").val()));
 	var url = "/item/itemmanagement.do?name="+name+"&page="+page;
 	window.location.href=url;
 }
 function tonextpageInfo(page){
	 var name = encodeURI(encodeURI($("#userName").val()));
 	var url = "/item/itemmanagement.do?name="+name+"&page="+(page+1);
 	window.location.href=url;
 }
 function toprevpageInfo(page){
	 var name = encodeURI(encodeURI($("#userName").val()));
		var url = "/item/itemmanagement.do?name="+name+"&page="+(page-1);
 	window.location.href=url;
 }
 function topageInfo(){
	 var name = encodeURI(encodeURI($("#userName").val()));
	 var topage = $("#topage").val();
  	var url = "/item/itemmanagement.do?name="+name+"&page="+topage;
  	window.location.href=url;
  }
 function del(id){
	 if (confirm("确定要删除吗 ?") == false) {
         return;
     }
	  $.ajax({
         type: "post",
         url: "/items/delmanagerById.do",
         data: {"id":id,},
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
 function xiugai(id){
	 layer.open({
			type : 2,
			title : '修改物资管理',
			area : [ '1000px', '150px' ],
			move : false, 	
			content : [ '/items/openmanageredit.do?Id='+id, 'yes' ]
		});
  }
 function userlist(){
	 var userCode=$("#userlist option:selected").val(); 
	 if(userCode!=null && userCode!=''){
		 document.getElementById("cuslist").style.display= "none"
			 $("#name").val(userCode);
		 	$("#type").val(1);
	 }else{
		 document.getElementById('cuslist').style.display='block';
	 }
 }
 function addretttu(){
	 var id=$("#iid").val();
	 var returntime=$("#returntime").val();
	 $.ajax({
         type: "post",
         url: "/items/retttuitem.do",
         data: {"id":id,"returntime":returntime},
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
 function cuslist(){
	 var CustomerCode=$("#cuslist option:selected").val();  
	 if(CustomerCode!=null && CustomerCode!=''){
		 document.getElementById("userlist").style.display= "none"
		 $("#name").val(CustomerCode);
		 $("#type").val(2);
	 }else{
		 document.getElementById('userlist').style.display='block';
	 }
 }
 function retur(id){
	 document.getElementById('retttu').style.display='block';
	 $("#iid").val(id);
 }
 function addmanager(){
	 var name=$("#name").val();
	 var renttime=$("#renttime").val();
	 var rentitem=$("#rentitem option:selected").val();
	 var type1=$("#type").val();
	 var data= {
			 "name":name,
			 "renttime":renttime,
			 "rentitem":rentitem,
			 "type1":type1
	  }
	 $.ajax({
		 type:"post",
         url:"/items/saveitemmanagement.do",
         data:data,
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
 </script>
 <body>
 <jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
   <input type="hidden" value="" id="name"/>
   <input type="hidden" value="" id="type"/>
   <input type="hidden" value="" id="iid"/>
  <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
     	<a href="" title="物资管理" class="current">物资管理</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>物资管理</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
	            	<col width="15%"><col width="15%"><col width="10%"><col width="10%">
	            	<col width="15%"><col width="10%"><col width="10%"><col width="15%">
	            </colgroup>
              <thead>
                <tr>
                	<th>姓名</th><th>借出日期</th><th>借用物品</th><th>借用经办人</th>
                	<th>归还日期</th><th>归还经办人</th><th>借用人类型</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
	              	<c:if test="${fn:length(userCount) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有物资信息</td>
					    </tr>
					</c:if>
	                <c:forEach var="count" items="${userCount}">
	                  <tr>
	                   <td>
	                   <c:if test="${count.type==1}">
	                   		<c:forEach items="${userlist}" var="info">
								<c:if test="${info.usercode==count.name}">${info.realname} </c:if>
							 </c:forEach>
	                   </c:if>
	                   <c:if test="${count.type==2}">
	                   		<c:forEach items="${cuslist}" var="info">
								<c:if test="${info.CustomerCode==count.name}">${info.CustomerName} </c:if>
							 </c:forEach>
	                   </c:if>
	                   </td>
	                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${count.renttime}"/></td>
	                   <td>
	                   		<c:forEach items="${itemlist }" var="info">
								<c:if test="${info.id==count.rentitem}">${info.name} </c:if>
							 </c:forEach>
						</td>
	                   <td>
	                   		<c:forEach items="${userlist }" var="info">
								<c:if test="${info.usercode==count.handler}">${info.realname} </c:if>
							 </c:forEach></td>
	                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${count.returntime}"/></td>
	                    <td>
	                    	<c:forEach items="${userlist }" var="info">
								<c:if test="${info.usercode==count.returnhandler}">${info.realname} </c:if>
							 </c:forEach></td>
						<td>
							<c:if test="${count.type==1}">用户</c:if>
							<c:if test="${count.type==2}">客户</c:if>
						</td>
						<td>
							<input type="button" class="delButClass" value="删除" onclick="del('${count.id}')"/>
							<input type="button" class="editButClass" value="修改" onclick="xiugai('${count.id}')"/>
							<input type="button" class="editButClass" value="还" onclick="retur('${count.id}')"/>
						</td>
	                  
	                 </tr>
	                </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
                <c:if test="${tatalpage>=currpage}">
                	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+1)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+1})">${currpage+1}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+2)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+2})">${currpage+2}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+3)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+3})">${currpage+3}</a> </li>
                </c:if>
                <li><a href="javascript:void(0)" onclick="tonextpageInfo(${currpage})">Next</a></li>
              </ul>
            </div>
          </div>
          <div class="whh_tab_bor">
           <div class="zyh_sos"><!-- whh_input -->
                <span style="float:left;">请选择人员：</span>
				<select class="zyh_sel zyh_k_heigth whh_sel" id="userlist" onclick="userlist()"name="name" style="width:20%; float:left;">
						<option value="">选用户</option>
                          <c:forEach items="${userlist}" var="info">
							<option value="${info.usercode }">${info.realname }</option>
						 </c:forEach>
				</select>
			<select class="zyh_sel zyh_k_heigth whh_sel" id="cuslist" onclick="cuslist()" name="name" style="width:20%; float:left;">
					<option value="">选客户</option>
                  <c:forEach items="${cuslist}" var="info">
					<option value="${info.CustomerCode}">${info.CustomerName }</option>
				</c:forEach>
			</select>
        		<span>时间：</span>
               <input id="renttime" type="text"  class="whh_input" placeholder="请输入日期" name="gzsj" onclick="WdatePicker()" readonly/>
               <span> 借用物品： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="rentitem" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${itemlist }" var="info">
							<option value="${info.id }">${info.name }</option>
						 </c:forEach>
					</select>
                <input type="button" class="zyh_btn" onclick="addmanager()" value="借">
               </div>
          </div>
          <div class="whh_tab_bor" style="display:none;" id="retttu">
            <div class="zyh_sos"><!-- whh_input -->
        		<span>归还时间：</span>
               <input id="returntime" class="whh_input" type="text"  placeholder="请输入日期" name="gzsj" onclick="WdatePicker()" readonly/>
                <input type="button" class="zyh_btn" onclick="addretttu()" value="还">
               </div>
         </div>
        </div>
  </div>
</div>
</body>
</html>