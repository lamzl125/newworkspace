<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>统计简历信息详情</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <script>
  function togetListBypage(page){
  	var starttime = $("#starttime").val();
  	var endtime = $("#endtime").val();
  	var resource = $("#resource").val().trim();
  	var url = "/resume/toResumeByResourceAndTime.do?starttime="+starttime+"&endtime="+endtime+"&resource="+resource+"&page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	var starttime = $("#starttime").val();
  	var endtime = $("#endtime").val();
  	var resource = $("#resource").val().trim();
  	var url = "/resume/toResumeByResourceAndTime.do?starttime="+starttime+"&endtime="+endtime+"&resource="+resource+"&page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	var starttime = $("#starttime").val();
  	var endtime = $("#endtime").val();
  	var resource = $("#resource").val().trim();
  	var url = "/resume/toResumeByResourceAndTime.do?starttime="+starttime+"&endtime="+endtime+"&resource="+resource+"&page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var starttime = $("#starttime").val();
  	var endtime = $("#endtime").val();
  	var resource = $("#resource").val().trim();
  	var topage = $("#topage").val().trim();
  	var url = "/resume/toResumeByResourceAndTime.do?starttime="+starttime+"&endtime="+endtime+"&resource="+resource+"&page="+topage;
  	window.location.href=url;
  }
  $(document).ready(function(){
	  initMemu(2);
  })
  </script>
 </head>
 <body>
 <input type="hidden" id="starttime" value=${starttime}>
 <input type="hidden" id="endtime" value=${endtime}>
  <input type="hidden" id="resource" value=${resource}>
  <jsp:include page="/views/Top.jsp"></jsp:include>
  
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>统计信息详情</span>
          <input type="button" value="上一步" class="zyh_syb" onClick="javascript:window.history.go(-1)">
          </h2>
          <div class="whh_tab_bor">
       
              <table style="word-break:break-all;" cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <th>姓名</th>
                     <th>出生日期</th>
                     <th>参加工作时间</th>
                     <th>入职概率</th>
                     <th width="350">技术特长</th>
                 </tr>
                </thead>
                <tbody>
	                <c:forEach  items="${list}"  var="custInfo">
		                  <tr>
			                   <td><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${custInfo.customercode}">${custInfo.customername}</a></td>
			                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.customerbirth}" /></td>
			                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.entrytime}" /></td>
			                   <td>${custInfo.entryprobability}%</td>
			                   <td>${custInfo.technicalexpertise}</td>
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
<!--               <p style="text-align: center;"><a href="javascript:void(0)" class="whh_btn whh_btn_big mt20 whh_btn_big_blue">继续查询</a></p> -->
          </div>

       </div>
   </div>
 </body>
</html>