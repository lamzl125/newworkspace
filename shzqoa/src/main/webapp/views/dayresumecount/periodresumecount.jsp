<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>简历份数统计</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script type="text/javascript">
    function jianli(a,b,c) {
       var lis = document.getElementById(a).getElementsByTagName('input');
       for (var i=0;i<lis.length;i++){
        lis[i].className="zyh_btn";
        document.getElementById(c+i).style.display="none";
        lis[b].className="zyh_btn cur";
        document.getElementById(c+b).style.display='inline-table';
       }
       var groupparam;
       if(b==0){
       	groupparam = "resumeSource";
       }else{
       	groupparam = "opert";
       }
       var starttime =$("#searchstarttime").val();
       var endtime =$("#searchendtime").val();
       var data = {	
    		 "starttime":starttime,
    		 "endtime":endtime,
  			 "groupparam": groupparam
  	  }
       $.ajax({
           type: "post",
           url: "/dayrescount/selectCountByGroup.do",
           data: data,
           dataType: "json",
           success: function(result){
          	 if(result.success && result.message=="resumeSource"){
          		 var domstr = "";
          		 for(var resume in result.resultData){
          			domstr+="<tr><td>"+resume.resName+"</td>";
          			domstr+="<td>"+resume.counts+"</td></tr>";
          		 }
          		$("#sourceCounts").innerHTML=domstr;
          	 }else if(result.success && result.message=="opert"){
          		 var domstr = "";
          		 for(var resume in result.resultData){
          			domstr+="<tr><td>"+resume.optname+"</td>";
          			domstr+="<td>"+resume.counts+"</td></tr>";
          		 }
          		$("#opertCounts").innerHTML=domstr;
          	 }
           }
       });
       
    }
    function selectstarttime(){
    	var searchstarttime = $("#searchstarttime").val();
    	$("#searchendtime").append($("#alldate").html());
    	$("#searchendtime option").each(function(i,val){
    		if($(this).val()<= searchstarttime){
    			$(this).remove();
    		}
    	});
    }
  </script>
 </head>
 <body>
 <jsp:include page="/views/Top.jsp"></jsp:include>
 <div style="display:none;">
 	 <select id="alldate" class="whh_sel" style="width: 120px;">
	   <c:forEach var="dateitem"  items="${datelist}" >
	   		<option value="<fmt:formatDate pattern='yyyy-MM-dd' value='${dateitem}' />" ><fmt:formatDate pattern='yyyy-MM-dd' value='${dateitem}' /></option>
	    </c:forEach>
	</select>	
 </div>

   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>简历份数统计</span></h2>
          <div class="whh_tab_bor">
              <div class="zyh_sos mb10" id="JianLi">
                   <span>开始时间：</span>
                   <select id="searchstarttime" class="whh_sel" style="width: 120px;" onchange="selectstarttime()">
                   		<c:forEach var="dateitem"  items="${datelist}" >
                       		<option value="<fmt:formatDate pattern='yyyy-MM-dd' value='${dateitem}' />" ><fmt:formatDate pattern='yyyy-MM-dd' value='${dateitem}' /></option>
                       </c:forEach>
                   </select>
                   <span>结束时间：</span>
                   <select id="searchendtime" class="whh_sel" style="width: 120px;">
                   </select>
                   <span>简历来源：</span>
                   <select class="whh_sel" style="width: 120px;">
                      <option value="">--请选择--</option>
                   	  <c:forEach var="item"  items="${resumeSourceList}" >
                       		<option <c:if test="${info.resumesource==item.resumesourceid}">selected='selected'</c:if>  value='${item.resumesourceid}' >${item.resumesourcename}</option>
                       </c:forEach>
                   </select>
                  <input type="button" class="zyh_btn cur" value="按录入人员统计" onclick="jianli('JianLi',0,'jianli_')" style="width: 120px;">
                  <input type="button" class="zyh_btn" value="按简历来源统计" onclick="jianli('JianLi',1,'jianli_')" style="width: 120px;">
              </div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1" id="jianli_0">
                <thead>
                  <tr>
                     <th>录入人员</th>
                     <th>份数</th>
                 </tr>
                </thead>
                <tbody id="opertCounts">
             
                </tbody>
              </table>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1" id="jianli_1" style="display: none;">
                <thead>
                  <tr>
                     <th>简历来源</th>
                     <th>份数</th>
                 </tr>
                </thead>
                <tbody id="sourceCounts">
             
                </tbody>
              </table>
              <!-- 页码开始 -->
              <div class="od_pages clearfix">
                <div class="travels_diary_page">
                  <span class="prev_page"><em></em></span>
                  <a href="javascript:void(0);" class="curr" onclick="">1</a>
                  <a href="javascript:void(0);">2</a>
                  <a href="javascript:void(0);">3</a>
                  <span class="ellipsis">...</span>
                  <span class="next_page">下一页</span>
                  <span class="reach_desc">到</span>
                  <input type="text">
                  <span class="confirm_btn">确定</span>
                </div>
              </div>
              <!-- 页码结束 -->
          </div>

       </div>
   </div>
 </body>
</html>