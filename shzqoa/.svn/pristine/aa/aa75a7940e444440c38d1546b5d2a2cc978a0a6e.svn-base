<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>任务分配</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/views/resource/layer/layer.js"></script>
</head>
<body>
	<jsp:include page="/views/Top.jsp"></jsp:include>
	<div class="whh_wraper">
		<div class="whh_content whh_content_border">
			<h2 class="whh_h2_bg">
				<span>任务分配</span>
			</h2>
			<div class="whh_tab_bor">
				<div class="zyh_sos">
					<span> 技术方向： </span> 
					<select class="zyh_sel" id="professionid">
						<option value="">--请选择--</option>
						<c:forEach items="${professionList }" var="p">
							<c:choose>
								<c:when test="${p.id eq professionid }">
									<option value="${p.id }" selected="selected">${p.name }</option>
								</c:when>
								<c:otherwise>
									<option value="${p.id }">${p.name }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					<span>地区： </span> 
					<select class="zyh_sel" id="areaid">
						<option value="">--请选择--</option>
						<c:forEach items="${areasList }" var="a">
							<c:choose>
								<c:when test="${a.areaid eq areaid }">
									<option value="${a.areaid }" selected="selected">${a.areaname }</option>
								</c:when>
								<c:otherwise>
									<option value="${a.areaid }">${a.areaname }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					<span> 级别： </span> 
					<select class="zyh_sel" id="gradeid">
						<option value="">--请选择--</option>
						<c:forEach items="${gradeList }" var="g">
							<c:choose>
								<c:when test="${g.id eq gradeid }">
									<option value="${g.id }" selected="selected">${g.gradename }</option>
								</c:when>
								<c:otherwise>
									<option value="${g.id }">${g.gradename }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
					<input type="button" class="zyh_btn" value="查询"
						onclick="searchXQ()"> 
					<input type="button"
						class="zyh_btn" value="分配任务" id="allotTask" 
						style="background-color: #FF7E00;">
				</div>
				<table cellpadding="0" cellspacing="0" border="0" width="100%"
					class="whh_tab1">
					<thead>
						<tr>
							<th>选择</th>
							<th>方向</th>
							<th>地区</th>
							<th>级别</th>
							<th>人数</th>
							<th>任务详情</th>
							<th>公司需求详情</th>
						</tr>
					</thead>
					<tbody id="dfp">
						<c:forEach items="${list }" var="o">
							<tr>
								<td><input type="checkbox"></td>
								<td item="${o.Technologydirection }">${o.name }</td>
								<td item="${o.Projectlocation }">${o.AreaName }</td>
								<td item="${o.Demandyears }">${o.gradename }</td>
								<fmt:parseNumber var="sum" integerOnly="true" type="number" value="${o.peoplesum }" />
								<td item="${sum }">
									<c:if test="${sum==0}">
										不限
									</c:if>
									<c:if test="${sum!=0}">
										${sum }
									</c:if>
								</td>
								<td><a href="javascript:void(0);" class="allotView">查看</a></td> 
								<td><a href="javascript:void(0);" class="companyView">查看</a></td>
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
						<c:if test="${tatalpage<=3}">
							<c:forEach var="item" begin="1" end="${tatalpage}"
								varStatus="status">
								<a href="javascript:void(0);"
									class="<c:if test='${currpage==item}'>curr</c:if>"
									onclick="togetListBypage(${item})">${item}</a>
							</c:forEach>
						</c:if>
						<c:if test="${tatalpage>3}">
							<c:if test="${currpage>=3}">
								<c:if test="${currpage==tatalpage}">
									<c:forEach var="item" begin="${currpage-2}" end="${currpage}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>
								<c:if test="${currpage!=tatalpage}">
									<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}"
										varStatus="status">
										<a href="javascript:void(0);"
											class="<c:if test='${currpage==item}'>curr</c:if>"
											onclick="togetListBypage(${item})">${item}</a>
									</c:forEach>
								</c:if>

							</c:if>
							<c:if test="${currpage<3}">
								<c:forEach var="item" begin="1" end="3" varStatus="status">
									<a href="javascript:void(0);"
										class="<c:if test='${currpage==item}'>curr</c:if>"
										onclick="togetListBypage(${item})">${item}</a>
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
<link rel="stylesheet" href="/views/taskallot/js/css/taskallot.css">
<script type="text/javascript" src="/views/taskallot/js/taskallot.js"></script>
<script type="text/javascript">
	function togetListBypage(page){
		var professionid = $('#professionid').val();
		var areaid = $('#areaid').val();
		var gradeid = $('#gradeid').val();
	 	var url = "/taskallot/main.do?page="+page+"&professionid="+$.trim(professionid)+"&areaid="+$.trim(areaid)+"&gradeid="+$.trim(gradeid);
	 	window.location.href=url;
	}
	function tonextpageInfo(page){
		var professionid = $('#professionid').val();
		var areaid = $('#areaid').val();
		var gradeid = $('#gradeid').val();
	 	var url = "/taskallot/main.do?page="+(page+1)+"&professionid="+$.trim(professionid)+"&areaid="+$.trim(areaid)+"&gradeid="+$.trim(gradeid);
	 	window.location.href=url;
	}
	function toprevpageInfo(page){
		var professionid = $('#professionid').val();
		var areaid = $('#areaid').val();
		var gradeid = $('#gradeid').val();
	 	var url = "/taskallot/main.do?page="+(page-1)+"&professionid="+$.trim(professionid)+"&areaid="+$.trim(areaid)+"&gradeid="+$.trim(gradeid);
	 	window.location.href=url;
	}
	function topageInfo(){
		var professionid = $('#professionid').val();
		var areaid = $('#areaid').val();
		var gradeid = $('#gradeid').val();
	 	var topage = $("#topage").val();
	 	var url = "/taskallot/main.do?page="+topage+"&professionid="+$.trim(professionid)+"&areaid="+$.trim(areaid)+"&gradeid="+$.trim(gradeid);
		window.location.href=url;
	}
	function searchXQ(){
		var professionid = $('#professionid').val();
		var areaid = $('#areaid').val();
		var gradeid = $('#gradeid').val();
		var url = "/taskallot/main.do?professionid="+$.trim(professionid)+"&areaid="+$.trim(areaid)+"&gradeid="+$.trim(gradeid);
		window.location.href=url;
	}
</script>
</html>