<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求详情信息</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <style type="text/css">
  .whh_tab1 td{padding:10px 0;}
  </style>
  <script type="text/javascript">
    $(document).ready(function(){
  	  	initMemu(1);
    });
  </script>
 </head>
 <body>
 <input type="hidden" id="demandid" value=${customerDemand.id}>
  <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求详情信息</span>
          	<input type="button" value="上一步" class="zyh_syb" onClick="javascript:window.history.go(-1)">
          </h2>
          <div class="whh_tab_bor">
              <ul class="whh_ul">
              	<li style="width:100%;">需求Id: <label>${customerDemand.id }</label></li>
                <li>客户编号: <label>
	                			<c:if test="${managerflag==1}">
		                   			
		                   			<c:forEach items="${corpList}" var="corp">
		                   				<c:if test="${corp.corpcode eq  customerDemand.corpcode}">${corp.corpname }</c:if>
		                   			</c:forEach>
		                   		</c:if>
		                   		<c:if test="${managerflag!=1}">
		                   			${customerDemand.corpcode }
		                   		</c:if>
	                   		</label></li>
                <li>技术方向: <label>
                				<c:forEach items="${professList}" var="proinfo">
	                				<c:if test="${proinfo.id==customerDemand.technologydirection}">
			                   			${proinfo.name }
			                   		</c:if>
		                   		</c:forEach></label></li>
                <li>项目地点:  <label><c:forEach items="${areaList}" var="areainfo">
	                				<c:if test="${areainfo.areaid==customerDemand.projectlocation}">
			                   			${areainfo.areaname }
			                   		</c:if>
		                   		</c:forEach></label></li>
                <li>级别:  <label><c:forEach items="${gradList}" var="gradinfo">
	                				<c:if test="${gradinfo.id==customerDemand.demandyears}">
			                   			${gradinfo.gradename }
			                   		</c:if>
		                   		</c:forEach></label></li>
                <li>学历要求: <label>${customerDemand.education}</label></li>
                <li>需求人数:  <label><c:if test="${customerDemand.demandnumber>0}">
			                   			${customerDemand.demandnumber}
			                   		</c:if>
			                   		<c:if test="${customerDemand.demandnumber==null||customerDemand.demandnumber<=0}">
			                   			不限
			                   		</c:if></label></li>
                <li>需求名称:<label>${customerDemand.projecttype}</label></li>
              	<li>重要级别:  <label><c:forEach items="${imporList}" var="imporinfo">
	                				<c:if test="${imporinfo.id==customerDemand.importantlevel}">
			                   			${imporinfo.name }
			                   		</c:if>
		                   		</c:forEach></label></li>
                <li style="width:100%;">技术要求: <label>${customerDemand.specificrequirement}</label></li>
                <li style="width:100%;">详细地址: <label>${customerDemand.address}</label></li>
                <li style="width:100%;">备注其他:  <label>${customerDemand.remarks}</label></li>
              </ul>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1" id="grablist">
                <thead>
                  <tr>
                     <th>抢取人</th>
                     <th>抢取/分配时间</th>
                     <th>抢取顺序</th>
                     <th>比例</th>
                 </tr>
                </thead>
                <tbody>
                	<c:forEach items="${demandsignlist}" var="demandsign">
                		<tr>
	                		<td>
	                			<c:forEach items="${userlist}" var="user">
									<c:if test="${user.usercode==demandsign.userCode }">${user.realname}</c:if>
								</c:forEach>
	                		</td>
	                		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${demandsign.signedTime}" /></td>
	                		<td>${demandsign.singnedIndex }</td>
	                		<td>${demandsign.proportion }%</td>
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