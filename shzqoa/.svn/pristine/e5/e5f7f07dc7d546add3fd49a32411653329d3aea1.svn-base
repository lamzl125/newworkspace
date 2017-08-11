<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>合格需求列表</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
 <link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
<script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script> 
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
 </head>
 <style>
.zyh_wii{ width:100px;} 
.zyh_btn {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
} 
.zyh_sosu{ margin-bottom:10px;}

.zyh_caozuo{
	display: inline-block;
    width: 40px;
    background-color: #E14C4D;
    color: #fff;
    cursor: pointer;}
    
     .zyh_k_heigth{ height:30px;border-radius: 3px;
    border: 1px solid #a7b6c4;}
 .zyh_sos{ margin-bottom: 10px;}
 zyh_sos .zyh_lefs{ margin-left:20px;}
 .zyh_btn {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
}

.zyh_b_box{ position:fixed; top:0; left:0; background-color:rgba(0,0,0,0.5); z-index:9999; width:100%; height:100%; display:none;}
.zyh_bb_box{ width:800px; position:absolute; left:50%; margin-left:-400px; top:50%; background-color:#fff; border-radius:5px; overflow:hidden; height:500px; margin-top:-250px;}
.zyh_bb_box h1{ text-align:center; display:inline-block;background-color:#F3F3F5; width:100%; font-size:16px; line-height:35px;}
.zyh_bb_box ul{ padding:10px;}
.zyh_bb_box li{ float:left;margin-left: 17px; line-height: 30px;width:78px;}
.zyh_pos_x{ position:absolute; right:3px; top:3px; font-size:18px; cursor:pointer;}
.zyh_sor_r{overflow-y: scroll;height: 415px;}


.zyh_xuqiu_bx{text-align: center;
    width: 100%;}
.zyh_xuqiu_btt{width: 160px;
    background-color: rgb(19, 151, 204);
    height: 40px;
    color: #fff;
    border: none;
    line-height: 40px;
    border-radius: 3px;
        cursor: pointer;}
 </style>
 <script type="text/javascript">
 $(document).ready(function(){
	table();
	initMemu(1,4);
  })
   function table(){
	  $("#tab1 tr").each(function(i,value){
		  var id= $(this).find("input[name='IsAddFlag']").val();
		  var data = {"id":id}
		  $.ajax({
	 		   url: "/demandsigned/getdemandresumefollowByid.do",
	 		   data: data,
	 		   dataType: "json",
	 		   success: function(result){
	 			  $(value).find("td:eq(6)").html(result.data.c1); 
	 			  $(value).find("td:eq(7)").html(result.data.c2); 
	 			  $(value).find("td:eq(8)").html(result.data.c3); 
	 		   }
		  }); 
		  
	  });
 }
 function topageInfo(){
	 var topage = $("#topage").val();
	 var url = "/demandsigned/toDemandList.do?page="+topage;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var url = "/demandsigned/toDemandList.do?page="+(page-1);
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var url = "/demandsigned/toDemandList.do?page="+page;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var url = "/demandsigned/toDemandList.do?page="+(page+1);
	 window.location.href=url;
	}
 function allot(id){
	 $("#signdemanid").val(id);
	 $(".zyh_b_box").show();
 }
 $(".zyh_click_btn").click(function(){
		$(".zyh_b_box").show();
	})
	$(".zyh_pos_x,.zyh_xuqiu_btt").click(function(){
		$(".zyh_b_box").hide();
	})
function binding(){
	 var demandid = $("#signdemanid").val();
	 var checkuser = $("input[name='custlist']:checked").val();
// 	$("input:checked[name='custlist']").each(function() {
// 		if(checkuser!=""){
// 			checkuser +=",";
// 		}
// 		checkuser += this.value ;
//     });
	if(checkuser==null || checkuser==""){
		alert("请选择一个指定人员");
		return false;
	}
	$.ajax({
		data: {"demandid":demandid,"checkuser":checkuser},
		type: "post",
		url: "/demandsigned/bindDemand.do",
		dataType: "json",
		success: function(result){
			alert(result.resultMessage);
			parent.location.reload();
       }
	});
	
 }
 function grab(id){
	 $.ajax({
		 data: {"demandid":id,},
        type: "post",
        url: "/demandsigned/grabDemand.do",
        dataType: "json",
        success: function(result){
        	alert(result.resultMessage);
        	parent.location.reload();
        }
    }); 
 }
 function detail(did){
	 var managerflag = $("#managerflag").val();
	 window.location="/demandsigned/showdemanddetail.do?demandid="+did+"&managerflag="+managerflag;
 }
 function search(){
	 var corpcode = $("#corpcode").val();
	 if(corpcode==null){
		 corpcode = "";
	 }
	 var technologydirection = $("#technologydirection").val();
	 if(technologydirection==null){
		 technologydirection = "";
	 }
	 var projectlocation = $("#projectlocation").val();
	 if(projectlocation==null){
		 projectlocation = "";
	 }
	 var demandyears = $("#demandyears").val();
	 if(demandyears==null){
		 demandyears = "";
	 }
	 var ocode = $("#ocode").val();	 
	 if(ocode==null){
		 ocode = "";
	 }
	 var url =  "/demandsigned/toDemandList.do?corpcode="+corpcode+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears+"&ocode="+ocode;
	 window.location.href=url;
 }
 function addResume(id){
	 layer.open({
         id:'iframetest',
         type: 2,
         title: '添加简历',
         maxmin: true, //开启最大化最小化按钮
         area: ['900px', '600px'],
         content: '/demandsigned/demandNoBindResumeList.do?demandId='+encodeURI(encodeURI(id.trim()))
	});
 }
 function showbindresume(id){
	 layer.open({
         id:'iframetest',
         type: 2,
         title: '该需求提交简历信息',
         maxmin: true, //开启最大化最小化按钮
         area: ['900px', '600px'],
         content: '/demandsigned/demandBindResumeList.do?demandId='+encodeURI(encodeURI(id.trim()))
	});
 }
 function demandnotelsit(id){
	 var url =  "/demandnote/toDemanNoteList.do?customerdemandid="+encodeURI(encodeURI(id.trim()));
	 window.location.href=url;
 }
 </script>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<input type="hidden" id="indexval" value="0">


<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="需求列表" class="current">需求列表</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求列表</h5>
          </div>
          <div class="widget-content clearfix">
         		<div class="zyh_sosu">
					<span> 客户： </span>
					<c:if test="${managerflag eq 1}">
               			<select id="corpcode" class="whh_sel" style="width:150px;">
                          <option value="">请选择</option>
                         <c:forEach items="${corporList }" var="info">
							<option value="${info.corpCode }" <c:if test="${info.corpCode eq  corpcode}">  selected="selected" </c:if>>${info.corpName }</option>
						 </c:forEach>
                       </select>
               		</c:if>
               		<c:if test="${managerflag ne 1}">
               			<select id="corpcode" class="whh_sel" style="width:150px;">
                          <option value="">请选择</option>
                         <c:forEach items="${corporList }" var="info">
							<option value="${info.corpCode }" <c:if test="${info.corpCode eq  corpcode}">  selected="selected" </c:if>>${info.corpCode }</option>
						 </c:forEach>
                       </select>
               		</c:if>
					
					<span> 技术方向： </span>
                       <select id="technologydirection" class="whh_sel" style="width:120px;">
                          <option value="">请选择</option>
                         <c:forEach items="${profession }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  technologydirection}">  selected="selected" </c:if>>${info.name }</option>
						 </c:forEach>
                       </select>
                    <span>项目地点： </span> 
					<select class="zyh_sel zyh_k_heigth whh_sel" id="projectlocation" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${arealist }" var="info">
							<option value="${info.areaid }" <c:if test="${info.areaid eq  projectlocation}">  selected="selected" </c:if>>${info.areaname }</option>
						 </c:forEach>
					</select>
					<span> 技术级别： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="demandyears" style="width:65px;">
						<option value="">请选择</option>
                          <c:forEach items="${grade }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  demandyears}">  selected="selected" </c:if>>${info.gradename }</option>
						 </c:forEach>
					</select>
					<span>录入人员： </span>
					<select class="zyh_sel zyh_k_heigth whh_sel" id="ocode" name="ocode" style="width:65px;">
						<option value="">请选择人员</option>
						<c:forEach items="${userlist}" var="info">
							<c:choose>
							<c:when test="${info.usercode eq  ocode}">
								<option value="${info.usercode}" selected="selected">${info.realname}</option>								
							</c:when>
							<c:otherwise>
								<option value="${info.usercode}">${info.realname}</option>								
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
					<input type="button" class="zyh_btn" value="查询" onclick="search()">
				</div>
          
            <table id="tab1" style="table-layout:fixed" class="table table-bordered table-striped with-check">
            	<colgroup>
            		<col width="5%;"><col width="4%;"><col width="4%;">
            		<col width="4%;"><col width="3%;"><col width="25%;">
            		<col width="5%;"><col width="5%;"><col width="5%;">            		
            		<col width="5%;"><col width="5%;"><col width="5%;">            		
            		<col width="5%;"><col width="5%;">
            	</colgroup>
              <thead>
                <tr>
                     <th>需求名称</th><th>客户公司</th><th>技术方向</th>
                     <th>项目地点</th><th>需求级别</th><th>具体内容</th>
                     <th>客户筛选简历时长</th><th>通知面试结果时长</th><th>安排入项时长</th>                     
                     <th>行业</th><th>技术需求</th><th>工作年限</th>
                     <th>录入人</th><th>操作</th>
                 </tr>
              </thead>
              <tbody>
              		<c:if test="${fn:length(custList) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td>
					    </tr>
					</c:if>
					<c:forEach items="${custList}" var="cc">
                	<tr>
                	   <td style="word-wrap:break-word;" onmouseover="onMouseOver('${cc.id }')"  onmouseout="onMouseOut('${cc.id }')">${cc.projecttype}</td>
	                   <td>
	                   		<input type="hidden" name="IsAddFlag" value="${cc.corpcode }"/>
	                   		<c:if test="${managerflag eq 1}">
	                   			${cc.corpname }
	                   		</c:if>
	                   		<c:if test="${managerflag ne 1}">
	                   			${cc.corpcode }
	                   		</c:if>
	                   </td>
	                   <td>${cc.name }</td>
	                   <td>${cc.areaname }</td>
	                   <td>${cc.gradename }</td>
	                   <td style="text-align:left;">${cc.specificrequirement}</td>
	                   <td></td>
	                   <td></td>
	                   <td></td>
	                   <!-- <td><input style="width:40px;" type="text"  name="soucecount1" vlaue=""></td>
	                   <td><input style="width:40px;"  type="text" name="soucecount2" vlaue=""></td>
	                   <td><input style="width:40px;"  type="text" name="soucecount3" vlaue=""></td> -->
	                   <td>
	                   		<c:forEach items="${proindlist}" var="info" >
								<c:if test="${cc.industry eq info.id}">${info.name} </c:if>
					    	</c:forEach>
	                   </td>
	                   <td>
	                   		<c:set value="${fn:split(cc.technicalRequirement, ',') }" var="tecreqarr" />
	                 		<c:forEach items="${tecreqarr}" var="s">
	                 			<c:forEach items="${tectypelist}" var="info">
	                 				<c:if test="${s eq info.id}">${info.name}</c:if>
	                 			</c:forEach>
	                   		</c:forEach>
	                   </td>
	                   <td>${cc.directWorkLife }</td>
	                   <td>
	                   		<c:forEach items="${userlist}" var="userinfo">
	                   			<c:if test="${userinfo.usercode==cc.operationuser}">${userinfo.realname}</c:if>
	                   		</c:forEach>
	                   </td>
	                   <td>
	                   			<div class="dropdown">
		                   			<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										更多
										<b class="caret"></b>
									</a>
									<ul class="dropdown-menu">
											<li><a href="javascript:void(0);" onclick="detail('${cc.id}')">详情</a></li>
											<c:if test="${managerflag==1}">
												<li class="divider"></li>
						                   		<li><a href="javascript:void(0);" onclick="allot('${cc.id}')">分配</a></li>
						                   </c:if>
										   <c:if test="${managerflag!=1}">
						                   		<c:set var="ccount" value="0"></c:set>
						                   		<c:forEach items="${binddemandlist}" var="binddemand">
						                   			<c:if test="${binddemand.id==cc.id}">
						                   				<c:set var="ccount" value="${ccount+1}"/>
						                   			</c:if>
						                   		</c:forEach>
						                   		<c:if test="${ccount==0}">
						                   			<li class="divider"></li>
						                   			<li><a href="javascript:void(0);" onclick="grab('${cc.id}')">抢取</a></li>
					                   			</c:if>
					                   			<c:if test="${ccount>0}">
					                   				<li class="divider"></li>
						                   			<li><a href="javascript:void(0);" onclick="showbindresume('${cc.id}')">已提交</a></li>
						                   			<li class="divider"></li>
						                   			<li><a href="javascript:void(0);" onclick="addResume('${cc.id}')">添加</a></li>
					                   			</c:if>
					                   			<li class="divider"></li>
					                   			<li><a href="javascript:void(0);" onclick="demandnotelsit('${cc.id}')">帖子</a></li>
						                   </c:if>
										
									</ul>
								</div>
		                   </td>
	                 </tr>
	                 </c:forEach>
              </tbody>
            </table>
            <input type="hidden" id="managerflag" value="${managerflag}">
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
                <c:if test="${tatalpage>=currpage}">
                	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+1)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+1})">${currpage+1}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+2)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+2})">${currpage+2}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+3)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+3})">${currpage+3}</a> </li>
                </c:if>
                <li><a href="javascript:void(0)" onclick="tonextpageInfo(${currpage})">Next</a></li>
              </ul>
            </div>
            
            
            <div class="zyh_b_box">
			 	<div class="zyh_bb_box">
			 		<input type="hidden" id="signdemanid" value="0">
			    	<a class="zyh_pos_x"></a>
			    	<h1>指定人员</h1>
			    	<div class="zyh_sor_r">
				        <ul>
				        	<c:forEach items="${rsuserlist}" var="user">
				        		<li><label><input type="radio" value="${user.usercode}" name="custlist">${user.realname}</label></li>
				        	</c:forEach>
				        </ul>
			        </div>
			        <div class="zyh_xuqiu_bx" >
			        	<input class="zyh_xuqiu_btt" type="button"  value="确定" onclick="binding()">
			        </div>
			    </div>
			 </div>
            
            
          </div>
        </div>
  </div>
</div>
<script>
   var aa;
   function onMouseOver(obj){
// 	   var did = $(this).children(":first").text();
//		var did = $(obj).text();
		var did =obj;
   		var index = layer.open({
           id:'iframetest',
           type: 2,
           title: '查看简历抢取信息',
           maxmin: true, //开启最大化最小化按钮
           area: ['600px', '600px'],
           content: '/demandsigned/showdemandsignlist.do?demandid='+did
		});
   		$("#indexval").val(index);
   		clearTimeout(aa);
   }
   function onMouseOut(obj){
	   setTimeout(function(){
		   var index = $("#indexval").val();
//	 	   alert(index); 
		   parent.layer.close(index);
	   },5000);
   }
</script>
 </body>
</html>