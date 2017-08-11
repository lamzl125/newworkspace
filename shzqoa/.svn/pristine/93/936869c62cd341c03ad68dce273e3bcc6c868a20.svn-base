<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>未录入简历需求</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
 </head>
 <style>
 
 
 
 .whh_content{background: #fff;}
 .whh_content_border{ border:none;}
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
  .zyh_wid2{width:660px;}
 </style>
<script type="text/javascript">
$(document).ready(function(){
	$("#tab_jianl_id tr").each(function(i,value){
		  var rid = $(this).find("input[name='list1Check']").val();
		  $.ajax({
	 		   type: "post",
	 		   url: "/demanresume/getCheckList2ByCheck1.do",
	 		  data: {"list1Check":rid},
	 		   dataType: "json",
	 		   success: function(result){
	 			   var checkList2 = result.getList2;
	 			   if(checkList2!=null){
	 				  $(value).hide();
	 			   }
	 			  
	 		   }
		  }); 
		  
	  });
	
	}); 
</script>
 <body>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>未录入简历需求</span></h2>
         <div class="whh_tab_bor">
       		<div class="zyh_tab_box">
			<table width="45%" border="1" id="tab_jianl_id" class="zyh_table" style="margin-right: 170px;" >
				<th colspan="3" class="zyh_th">未录入简历需求</th>
				   <c:forEach items="${list1}" var="signdemand" varStatus="status">
				   		<tr>
						  	<td class="zyh_wid">&nbsp;</td>
						    <td class="zyh_wid1" scope="row"><input  type="hidden" name="list1Check" <c:if test="${status.index==0}">checked</c:if> value="${signdemand.signid}"></td>
						    <td class="zyh_wid2">${signdemand.CorpCode}&nbsp;|&nbsp;
						    	<c:forEach items="${professList}" var="proinfo">
	                				<c:if test="${proinfo.id==signdemand.Technologydirection}">
			                   			${proinfo.name }
			                   		</c:if>
		                   		</c:forEach>&nbsp;|&nbsp;
		                   		<c:forEach items="${areaList}" var="areainfo">
	                				<c:if test="${areainfo.areaid==signdemand.Projectlocation}">
			                   			${areainfo.areaname }
			                   		</c:if>
		                   		</c:forEach>&nbsp;|&nbsp;
		                   		<c:forEach items="${gradList}" var="gradinfo">
	                				<c:if test="${gradinfo.id==signdemand.Demandyears}">
			                   			${gradinfo.gradename }
			                   		</c:if>
		                   		</c:forEach>
						    </td>
						  </tr>
				   </c:forEach>
			</table>
          </div>
		</div>
       </div>
   </div>
 </body>
</html>