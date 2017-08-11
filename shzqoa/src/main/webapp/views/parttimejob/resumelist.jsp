<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>简历信息</title>
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
   
   <script type="text/javascript">
   $(document).ready(function(){
 	  initMemu(1);
 	 table();
   })
   function table(){
	  $("#tab_1 tr").each(function(i,value){
		  
		  var mobile= $(this).find("td:eq(1)").text();
		  var mm= mobile.replace(/(\d{3})(\d{4})(\d{4})/,"$1****$3");
		  $(value).find("td:eq(1)").html(mm); 
		  
	  });
 }
    function togetListBypage(page){
    	var customertel=$("#customerTel").val();
    	var projecttype=$("#projecttype").val();
   		var url = "/partDocustomerInfo.do?customertel="+customertel+"&projecttype="+projecttype+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var customertel=$("#customerTel").val();
    	var projecttype=$("#projecttype").val();
   		var url = "/partDocustomerInfo.do?customertel="+customertel+"&projecttype="+projecttype+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var customertel=$("#customerTel").val();
    	var projecttype=$("#projecttype").val();
   		var url = "/partDocustomerInfo.do?customertel="+customertel+"&projecttype="+projecttype+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
    	var customertel=$("#customerTel").val();
    	var projecttype=$("#projecttype").val();
   		var topage = $("#topage").val();
   		var url = "/partDocustomerInfo.do?customertel="+customertel+"&projecttype="+projecttype+"&page="+topage;
    	window.location.href=url;
    }
    function search(){
    	var customertel=$("#customerTel").val();
    	var projecttype=$("#projecttype").val();
    	var url = "/partDocustomerInfo.do?customertel="+customertel+"&projecttype="+projecttype;
    	window.location.href=url;
    }
  </script>
 </head>
 <body>
  <input type="hidden" id="customername" value="${customername}"/>
  <input type="hidden" id="currentpage" value="${page }"/>
  <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>查询结果</span></h2>
          <div class="whh_tab_bor">
       			<div class="zyh_sosu">
					<span> 电话： </span>
					<input type="text" class="zyh_txt whh_input"  id="customerTel"  value="${customertel}"> 
					<span>需求名称： </span>
					<input type="text" class="zyh_txt whh_input"  id="projecttype"  value="${projecttype}"> 
					<input type="button" class="zyh_btn" value="查询" onclick="search()">
				</div>
              <table id="tab_1" style="word-break:break-all;"  cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                   	<th width="10%">姓名</th>
                     <th width="10%">电话</th>
                     <th width="10%">需求名称</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(customerInfoList) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">未查询到人员信息</td>
				    </tr>
				</c:if>
                <c:forEach  items="${customerInfoList}"  var="custInfo">
                	<tr>
                	<td>
                	<input type="hidden"  value="${custInfo.customercode }" />${custInfo.CustomerName }</td>
                   <%--  <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.resumeupdatedate }" /></td>
                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custnfo.customerbirth }" /></td>
                   <td>${custInfo.entryprobability }</td> --%>
                   <td>${custInfo.CustomerTel}</td>
                  <%--  <td>	<c:choose>
                   		<c:when test="${custInfo.synEvaluate>=1 && custInfo.synEvaluate<60 }">一般</c:when>
                   		<c:when test="${custInfo.synEvaluate>=60 && custInfo.synEvaluate<80 }">良好</c:when>
                   		<c:when test="${custInfo.synEvaluate>=80 && custInfo.synEvaluate<=100 }">优秀</c:when>
                   	</c:choose></td> --%>
                   <td>${custInfo.Projecttype }</td>
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
          </div>

       </div>
   </div>
 </body>
</html>