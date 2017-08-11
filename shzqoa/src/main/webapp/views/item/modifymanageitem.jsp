<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>修改物资管理</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <link rel="stylesheet" href="/views/resource/css/zyh_style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/layer/layer.js"></script>
  <script type="text/javascript"></script>
  <script type="text/javascript">
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
  function modifyitem(){
	  	  var id=$("#id").val();
	   	  var name = $("#name").val();
	   	  var renttime = $("#renttime").val();
	   	  var returntime = $("#returntime").val();
	   	   var rentitem=$("#rentitem option:selected").val();
	   	 var type=$("#type").val();
		  
		  
	  var data = {
			  	"id": id,
			  	"name": name,
			  	"renttime": renttime,
			  	"returntime": returntime,
			  	"rentitem": rentitem,
			  	"type": type,
	  }
	  $.ajax({
          type: "post",
          url: "/items/updatemanageitem.do",
          data: data,
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
 </head>
 <body>
  <div class="whh_tab_bor">
  <input type="hidden" value="${list.id}" id="id"/>
  <input type="hidden" value="${list.status}" id="status"/>
  <input type="hidden" value="${list.name}" id="name"/>
   <input type="hidden" value="${list.type}" id="type"/>
            <div class="whh_tab_bor">
            <div class="zyh_sos"><!-- whh_input -->
                <div style="float:left;"><span>请选择人员：</span></div>
                <div style="float:left;" id="userdiv">
				<select class="zyh_sel zyh_k_heigth whh_sel" id="userlist" onclick="userlist()" style="width:65px;" name="name">
						<option value="">选用户</option>
                          <c:forEach items="${userlist}" var="info">
                          <option value="${info.usercode }" <c:if test="${list.name==info.usercode}">  selected="selected" </c:if>>${info.realname }</option>
						 </c:forEach>
				</select>
				</div>
				<div style="float:left;" id="cusdiv">
			<select class="zyh_sel zyh_k_heigth whh_sel" id="cuslist" onclick="cuslist()" style="width:65px;" name="name">
					<option value="">选客户</option>
                  <c:forEach items="${cuslist}" var="info">
                  <option value="${info.CustomerCode }" <c:if test="${list.name==info.CustomerCode}">  selected="selected" </c:if>>${info.CustomerName }</option>
				</c:forEach>
			</select>
			</div>
        		<span>借出时间：</span>
               <input id="renttime" type="text"  value="${list.renttime}" placeholder="请输入日期" name="gzsj" onclick="WdatePicker()" readonly/>
               <span> 借用物品： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="rentitem" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${itemlist }" var="info">
                          <option value="${info.id }" <c:if test="${list.rentitem==info.id}">  selected="selected" </c:if>>${info.name }</option>
						 </c:forEach>
					</select>
					<span>归还时间：</span>
               <input id="returntime" type="text"  value="${list.returntime}" placeholder="请输入日期" name="gzsj" onclick="WdatePicker()" readonly/>
                <input type="button" class="zyh_btn" onclick="modifyitem()" value="修改">
               </div>
         </div>
         </div>

 </body>
</html>