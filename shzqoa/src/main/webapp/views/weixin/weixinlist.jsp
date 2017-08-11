<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>微信动态列表</title>
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/jquery.validate.js"></script>
  <script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
    <script type="text/javascript" src="/views/resource/layer/layer.js"></script>
     
   <script type="text/javascript">
    function togetListBypage(page){
   		var url = "/school/toSchoolList.do?page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
   		var url = "/school/toSchoolList.do?page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
   		var url = "/school/toSchoolList.do?page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
   		var topage = $("#topage").val();
   		var url = "/school/toSchoolList.do?page="+topage;
    	window.location.href=url;
    }
  </script>
 </head>
 <body>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>微信动态列表</span></h2>          
          <div class="whh_tab_bor">
              <table style="word-break:break-all;"  cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                   	<th width="10%">微信</th>
                     <th width="10%">原有好友数</th>
                     <th width="10%">增加好友数</th>
                     <th width="10%">增加朋友圈动态数</th>
                     <th width="10%">操作人</th>
                     <th width="10%">操作时间</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(weixinlist) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">未查询到微信信息</td>
				    </tr>
				</c:if>
                <c:forEach  items="${weixinlist}"  var="weixin">
                	<c:set value="${fn:split(weixin.weixin, '-') }" var="weixinstr" />
                	<c:set value="${fn:split(weixin.LastCount, '-') }" var="lastcountstr" />
                	<c:set value="${fn:split(weixin.AddCount, '-') }" var="addcountstr" />
                	<c:set value="${fn:split(weixin.AddDynamic, '-') }" var="adddynamicstr" />
                	<c:forEach items="${weixinstr}" var="s" varStatus="status1">
                		<tr>
		                   <td>${s}</td>
		                   <td>
		                   		<c:forEach items="${lastcountstr}" var="s2" varStatus="status2">
		                   			<c:if test="${status1.index== status2.index}">${s2}</c:if>
		                   		</c:forEach>
		                   </td>
		                   <td>
		                   		<c:forEach items="${addcountstr}" var="s3" varStatus="status3">
		                   			<c:if test="${status1.index== status3.index}">${s3}</c:if>
		                   		</c:forEach>
		                   </td>
		                   <td>
		                   		<c:forEach items="${adddynamicstr}" var="s4" varStatus="status4">
		                   			<c:if test="${status1.index== status4.index}">${s4}</c:if>
		                   		</c:forEach>
		                   </td>
		                   
		                   
		                   
		                   <td>${weixin.realName }</td><td>${weixin.logDate }</td>
	                 	</tr>
                	</c:forEach>
                	
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