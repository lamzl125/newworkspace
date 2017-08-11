<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>问题建议列表</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="/views/resource/my97/WdatePicker.js"></script>
  <script type="text/javascript">
  function toprevpageInfo(page){
	  	var opercode = $("#opercode").val();
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var keywords = $("#keywords").val();
	  	var url = "/log/problems.do?page="+(page-1);
	  	if(opercode!=null && opercode!=""){
	  		url += "&usercode="+opercode.trim();
	  	}
	  	if(starttime!=null && starttime!=""){
	  		url += "&starttime="+starttime.trim();
	  	}
	  	if(endtime!=null && endtime!=""){
	  		url += "&endtime="+endtime.trim();
	  	}
	  	if(keywords!=null && keywords!=""){
	  		url += "&keywords="+keywords.trim();
	  	}
		window.location.href=url;
  }
  
  function togetListBypage(page){
	   var url = "/log/problems.do?page="+page;
	   var opercode = $("#opercode").val();
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var keywords = $("#keywords").val();
	  	if(opercode!=null && opercode!=""){
	  		url += "&usercode="+opercode.trim();
	  	}
	  	if(starttime!=null && starttime!=""){
	  		url += "&starttime="+starttime.trim();
	  	}
	  	if(endtime!=null && endtime!=""){
	  		url += "&endtime="+endtime.trim();
	  	}
	  	if(keywords!=null && keywords!=""){
	  		url += "&keywords="+keywords.trim();
	  	}
	   window.location.href=url;
  }
  
  function tonextpageInfo(page){
	   var logdate = $("#logdate").val();
	   var url = "/log/problems.do?page="+(page+1);
	   var opercode = $("#opercode").val();
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var keywords = $("#keywords").val();
	  	if(opercode!=null && opercode!=""){
	  		url += "&usercode="+opercode.trim();
	  	}
	  	if(starttime!=null && starttime!=""){
	  		url += "&starttime="+starttime.trim();
	  	}
	  	if(endtime!=null && endtime!=""){
	  		url += "&endtime="+endtime.trim();
	  	}
	  	if(keywords!=null && keywords!=""){
	  		url += "&keywords="+keywords.trim();
	  	}
	   window.location.href=url;
  }
  
  function topageInfo(){
	   var topage = $("#topage").val();
	   var url = "/log/problems.do?page="+topage;
	   var opercode = $("#opercode").val();
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var keywords = $("#keywords").val();
	  	if(opercode!=null && opercode!=""){
	  		url += "&usercode="+opercode.trim();
	  	}
	  	if(starttime!=null && starttime!=""){
	  		url += "&starttime="+starttime.trim();
	  	}
	  	if(endtime!=null && endtime!=""){
	  		url += "&endtime="+endtime.trim();
	  	}
	  	if(keywords!=null && keywords!=""){
	  		url += "&keywords="+keywords.trim();
	  	}
	   window.location.href=url;
  }
  function search(){
	  var url = "/log/problems.do?page=1";
	  var opercode = $("#opercode").val();
	  	var starttime = $("#starttime").val();
	  	var endtime = $("#endtime").val();
	  	var keywords = $("#keywords").val();
	  	if(opercode!=null && opercode!=""){
	  		url += "&usercode="+opercode.trim();
	  	}
	  	if(starttime!=null && starttime!=""){
	  		url += "&starttime="+starttime.trim();
	  	}
	  	if(endtime!=null && endtime!=""){
	  		url += "&endtime="+endtime.trim();
	  	}
	  	if(keywords!=null && keywords!=""){
	  		url += "&keywords="+keywords.trim();
	  	}
	  window.location.href=url;
  }
  </script>
 </head>
 <body>
 <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>问题建议列表</span></h2>
          <div class="whh_tab_bor">
              <div class="zyh_sos mb10">
                   <span>提交人：</span>
                   <select class="whh_sel" style="width: 120px;" id="opercode">
                      <option value="">请选择</option>
                      <c:forEach items="${userlist}" var="userInfo" varStatus="userstatus">
                      		<option <c:if test="${userInfo.usercode==usercode}">selected</c:if> value="${userInfo.usercode}">${userInfo.realname}</option>
                      </c:forEach>
                   </select>
                   <span>开始时间：</span><input type="text" class="whh_input" style="width: 120px;" id="starttime" onclick="WdatePicker()" onfocus="WdatePicker({startDate:'%y',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endtime\')}'})" value="<fmt:formatDate value='${starttime }' pattern='yyyy-MM-dd'/>"/>
                   <span>结束时间：</span><input type="text" class="whh_input" style="width: 120px;" id="endtime" onclick="WdatePicker()" onfocus="WdatePicker({startDate:'%y',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d',minDate:'#F{$dp.$D(\'starttime\')}'})" value="<fmt:formatDate value='${endtime }' pattern='yyyy-MM-dd'/>"/>
                   <span>关键字：</span><input type="text" class="whh_input"  style="width: 120px;" id="keywords" value="${keywords}"/>
                  <input type="button" class="zyh_btn" value="搜索" onclick="search()">
              </div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <th width="8%">提交人</th>
                     <th width="15%">日志内容</th>
                     <th width="28%">问题建议</th>
                     <th width="10%">日期</th>
                     <th>回复信息</th>
                     <th width="11%">回复到</th>
                 </tr>
                </thead>
                <tbody>
                	<c:forEach items="${dailyLogs}" var="info" varStatus="infostatus">
                		<tr>
		                   <td>${info.realName}</td>
		                   <td>${info.logContent}</td>
		                   <td>${info.propose}</td>
		                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${info.logDate}" /></td>
		                   <td>${info.replycontent}</td>
		                   <td>${info.replyTo}</td>
		                 </tr>
                    </c:forEach>
                </tbody>
              </table>
              <!-- 页码开始 -->
              <div class="od_pages clearfix">
                <div class="travels_diary_page">
                	<c:if test="${tatalpage>1 && currpage != 1}">
                		<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
                	</c:if>
                  <c:if  test="${tatalpage<=3}">
	                  <c:forEach var="item" begin="1" end="${tatalpage}" varStatus="status">
	                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
	                  </c:forEach>
                  </c:if>
                  <c:if  test="${tatalpage>3}">
                  		<c:if test="${currpage>=3}">
                  			<c:if test="${currpage==tatalpage}">
                  				<c:forEach var="item" begin="${currpage-2}" end="${currpage}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			<c:if test="${currpage!=tatalpage}">
                  				<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			
                  		</c:if>
                  		<c:if test="${currpage<3}">
	                  		<c:forEach var="item" begin="1" end="3" varStatus="status">
		                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
		                    </c:forEach>
	                    </c:if>
	                    <c:if test="${currpage != tatalpage}">
	                    	<span class="ellipsis">...</span>
	                    </c:if>
                  		
                  </c:if>
				  <c:if test="${tatalpage>1}">
				  		<c:if test="${currpage < tatalpage}">
				  			<span class="next_page" onclick="tonextpageInfo(${currpage})">下一页</span>
				  		</c:if>
	                  <span class="reach_desc">到</span>
	                  <input type="text" id="topage">
	                  <span class="confirm_btn" onclick="topageInfo()">确定</span>
				  </c:if>
                </div>
              </div>
              <!-- 页码结束 -->
          </div>

       </div>
   </div>
 </body>
</html>