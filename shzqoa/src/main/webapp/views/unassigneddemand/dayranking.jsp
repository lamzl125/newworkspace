<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>录入简历排行</title>
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
<script type="text/javascript"></script>
 <body>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>排行榜</span></h2>
         <div class="whh_tab_bor">
       		<div class="zyh_tab_box">
			<table width="45%" border="1" class="zyh_table" style="margin-left:0;margin-right:0px;" >
			<th colspan="3" class="zyh_th">日排行榜</th>
			<tr>
				<td>排名</td>
				<td>姓名</td>
				<td>数量</td>
			</tr>
				   <c:forEach items="${dayrankinglist}" var="dayranking" varStatus="status">
				   		<tr>
				   			<td>${status.count}</td>
						  	<td class="zyh_wid">${dayranking.name}</td>
						    <td class="zyh_wid1" scope="row">${dayranking.amount}</td>
						  </tr>
				   </c:forEach>
			</table>
			<table width="30%" border="1" class="zyh_table" id="list2" style="float:right;">
			<th colspan="3" class="zyh_th">周排行榜</th>
				<tr>
					<td>排名</td>
					<td>姓名</td>
					<td>数量</td>
				</tr>
					<c:forEach items="${weekrankinglist}" var="weekranking" varStatus="status1">
				   		<tr>
				   			<td>${status1.count}</td>
						  	<td class="zyh_wid">${weekranking.name}</td>
						    <td class="zyh_wid1" scope="row">${weekranking.amount}</td>
						 </tr>
				   </c:forEach>
			</table>
          </div>
		</div>
       </div>
   </div>
 </body>
</html>