<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>新增日简历统计</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script type="text/javascript">
  function saveInfo(){
	  var id = $("#id").val();
	  var recodeday = $("#recodeday").val();
	  if(recodeday==null||recodeday==""){
		  alert("记录日期不能为空");
		  return false;
	  }
	  var resource = $("#resource").val();
	  if(resource==null||resource==""){
		  alert("简历来源不能为空");
		  return false;
	  }
	  var count = $("#count").val();
	  if(count == null || count == ''){
		  alert("数量不能为空");
		  return false;
	  }
	  var data = {
			  "id":id,
			  "recodeday": recodeday,
			 "resource": resource,
			 "count":count,
	  }
	  $.ajax({
          type: "post",
          url: "/dayrescount/savedayrescount.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.window.location.href="/dayrescount/dayrescountlist.do";//刷新列表页面
                 var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
                 parent.layer.close(index);//关闭当前弹出框
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
	  
  }
  </script>
 </head>
 <body>
 <input type="hidden"  id="id" value="${info.id}">
  <div class="whh_wraper">
   <form name="signupForm" method="post">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>新增日简历统计</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>日期：</td>
                   <td><input type="text" class="whh_input" id="recodeday" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${info.recorddate}" />" onclick="WdatePicker()" onfocus="WdatePicker({startDate:'%y',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})" ></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>简历来源：</td>
                   <td><select class="whh_sel" id="resource">
                      <option value="">请选择</option>
                   	  <c:forEach var="item"  items="${resumeSourceList}" >
                       		<option <c:if test="${info.resumesource==item.resumesourceid}">selected='selected'</c:if>  value='${item.resumesourceid}' >${item.resumesourcename}</option>
                       </c:forEach>
                   </select></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>份数：</td>
                   <td><label class="whh_label"><input type="text" class="whh_input" id="count" value="${info.count}"></label></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" onclick="saveInfo()"></p>
          </div>

       </div>
   </form>
   </div>
 </body>
</html>