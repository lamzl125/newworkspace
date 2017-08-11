<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.shzqoa.model.Rights"%>
<div id="sidebar">
	<a href="#" class="visible-phone"><i class="icon icon-home"></i>企业管理</a>
	<c:forEach var="item" begin="0" items="${userrights}" >
		<c:if test="${item.key == null}">
			<ul>
				<c:forEach items="${item.value}" var="firstmap" varStatus="itemstatus">
					<li class="submenu">
						<a href="javascript:void(0)"><i class="icon icon-home"></i><span>${firstmap.rightname}</span></a>
						 <ul>
						 	<c:forEach var="item2" items="${userrights}" varStatus="item2status">
						 		<c:if test="${firstmap == item2.key}">
						 			<c:forEach items="${item2.value}" var="secondmap">
						 				<li><a href="${secondmap.url}">${secondmap.rightname}</a></li>
						 			</c:forEach>
						 		</c:if>
				    		</c:forEach>
						 </ul>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</c:forEach>
</div>

