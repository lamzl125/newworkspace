<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
 <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
 
</head>
<body>
	<div class="contains">
				     <input type="hidden" value="${interView.id }" id="id"/>
				 	 <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
		                <tbody>
		                  <tr>
		                   <td width="40%" class="whh_right">姓名：</td>
		                   <td><label>${interView.customername}</label></td>
		                   
		                 </tr>
		                 <tr>
		                   <td class="whh_right">安排面试时间：</td>
		                   <td><label class="whh_label"><input type="text" class="whh_input" value="<fmt:formatDate value="${interView.plantime }" pattern="yyyy-MM-dd"/>" name="plantime" id="plantime" onclick="WdatePicker()" readonly="readonly"/></label></td>
		                 </tr>
		                 <tr>
		                   <td class="whh_right">实际面试时间：</td>
		                   <td><label class="whh_label"><input type="text" class="whh_input" value="<fmt:formatDate value="${interView.realitytime }" pattern="yyyy-MM-dd"/>" name="realitytime" id="realitytime" onclick="WdatePicker()" readonly="readonly"/></label></td>
		                 </tr>
		                 <tr>
		                   <td class="whh_right">面试情况：</td>
		                   <td>
		                       <select class="whh_sel" id="issuccess">
		                       	  <option value="">请选择</option>
                        		  <option value="0" <c:if test="${interView.issuccess eq '0' }">  selected="selected" </c:if>>待面试</option>
                          		  <option value="1" <c:if test="${interView.issuccess eq '1' }">selected="selected" </c:if>>失败</option>
                         		  <option value="2" <c:if test="${interView.issuccess eq '2' }"> selected="selected"</c:if>>成功</option>
		                       </select>
		                   </td>
		                 </tr>
		                 <tr>
		                   <td class="whh_right">是否入职：</td>
		                   <td>
		                       <select class="whh_sel" id="isentry">
		                       	  <option value="">请选择</option>
                          		  <option value="0" <c:if test="${interView.isentry eq '0' }">selected="selected" </c:if>>否</option>
                        		  <option value="1" <c:if test="${interView.isentry eq '1' }">  selected="selected" </c:if>>是</option>
		                       </select>
		                   </td>
		                 </tr>
		                </tbody>
		              </table>
		             <p style="text-align: center;">
		             	<a class="whh_btn whh_btn_big mt20 whh_btn_big_blue" href="javaScript:void(0);" onclick="doupdate()">保存</a>
    				</p>
			</div>
</body>
<script type="text/javascript">
 function doupdate(){
	 	var id2=$("#id").val();
	 	var plantime=$("#plantime").val();
	 	var realitytime=$("#realitytime").val();
	 	var issuccess=$("#issuccess").find("option:selected").val();
	 	var isentry=$("#isentry").find("option:selected").val();
		var data = {
				"id":id2,
				"realitytime":realitytime,
				"plantime":plantime,
				"issuccess":issuccess,
				"isentry":isentry
			}
			 $.ajax({
				data : data,
				url : "/InterView/updateInterView.do",
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