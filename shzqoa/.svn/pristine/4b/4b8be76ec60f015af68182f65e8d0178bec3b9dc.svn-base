<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- <link rel="stylesheet" href="/views/resource/css/style.css"> -->
<link href="/views/resource/css/nav_style.css" rel="stylesheet">
<link href="/views/resource/css/lanren.css" type="text/css" rel="stylesheet" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.shzqoa.model.Rights"%>


   <div class="zyh_top_box">
 	<div class="zyh_top">
    	<p>欢迎您 , 
        	<span id="realname">${user.realname}</span>
        	<input type="hidden" value="${user.usercode}" id="usercode" />
        </p>
      </div>
    </div>
<div class="htmleaf-container">
	  <nav class="animenu"> 
		  <ul class="animenu__nav">

		    <!-- <li class="zyh_logo_g">
            <img src="/views/images/logo.png">
		    </li> -->
		    
		    <c:forEach var="item" begin="0" items="${userRigtsList}" >
		    	<c:if test="${item.rightlevel==1}">
			    	<li style="height:78px;line-height:78px;">
			    		<input type="hidden" valu=${item.rightid}>
			    		<a href="#">${item.rightname}
			    		<em class="triangle-down"></em>
			    		</a>
			    		<ul class="animenu__nav__child">
			    			<c:forEach var="item2" begin="0" items="${userRigtsList}" >
				    			<c:if test="${item2.rightlevel!=1 && item2.rightid!=item.rightid && item2.parentid==item.rightid}">
				    				<li><a href=${item2.url}>${item2.rightname}</a></li>
				    			</c:if>
				    		</c:forEach>
			    		</ul>
				    </li>
			    </c:if>
		    </c:forEach>
		  </ul>
	  </nav>
</div>

<!-- 代码部分begin -->
<div id="rightArrow"><a href="javascript:;" title="在线客户"></a></div>
<div id="floatDivBoxs">
  <div class="floatDtt">在线客服</div>
  <div class="floatShadow">
    <ul class="floatDqq">
    	<c:forEach var="item2" begin="0" items="${sessionScope.serlist}" >
   			<li><a target="_blank" href="tencent://message/?uin=${item2.qQ}&Site=sc.chinaz.com&Menu=yes"><img src="/views/resource/css/img/qq.png" align="absmiddle">${item2.serviceName}</a></li>
   		</c:forEach>
    </ul>
    <!-- <div class="floatDtxt">热线电话</div>
    <div class="floatDtel"><img src="/views/resource/css/img/online_phone.jpg" width="155" height="45" alt=""></div>
    <div class="floatImg"><img src="/views/resource/css/img/erweima.jpg" width="100%">微信公众账号</div> -->
  </div>
  <div class="floatDbg"></div>
</div>
<script>
$(function(){
	var flag=0;
	$('#rightArrow').on("click",function(){
		if(flag==1){
			$("#floatDivBoxs").animate({right: '-175px'},300);
			$(this).animate({right: '-5px'},300);
			$(this).css('background-position','-50px 0');
			flag=0;
		}else{
			$("#floatDivBoxs").animate({right: '0'},300);
			$(this).animate({right: '170px'},300);
			$(this).css('background-position','0px 0');
			flag=1;
		}
	});
});
</script>
<!-- 代码部分end -->
   