<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>绑定需求</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
<link rel="stylesheet" href="/views/resource/css/style.css">
<script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
 </head>
 <style>
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
	var customerdemandid;
	function setBudding(cdId){
		customerdemandid = cdId;
		$(".zyh_b_box").show();
    }
	var customercodes= new Array();
	function binding(){
		$("input[name='custlist']:checked").each(function(){
			customercodes.push($(this).val());
	    }) 
	    if(customercodes.length>0){
	    	$.ajax({
				type: "post",
				url: "/customerDemand/buddingDemand.do",
				data: {"customerdemandid":customerdemandid,"custcodes":customercodes},
				dataType: "json",
				success: function(result){
					if(result.status == 0){
						alert("绑定成功!");
						window.location.reload();
					} else {
						alert(result.msg);	
					}
				}
			});
	    }else{
	    	alert("绑定失败！您没有选择选择绑定人员！");
	    }  
	 }
 function searchByResume(){
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").find("option:selected").val();
	 var demandyears=$("#demandyears").find("option:selected").val();
	 var url =  "/customerDemand/toCustDemand.do?technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
 }
 function topageInfo(){
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").find("option:selected").val();
	 var demandyears=$("#demandyears").find("option:selected").val();
	 var topage = $("#topage").val();
	 var url = "/customerDemand/toCustDemand.do?page="+topage+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").find("option:selected").val();
	 var demandyears=$("#demandyears").find("option:selected").val();
	 var url = "/customerDemand/toCustDemand.do?page="+(page-1)+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").find("option:selected").val();
	 var demandyears=$("#demandyears").find("option:selected").val();
	 var url = "/customerDemand/toCustDemand.do?page="+page+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").find("option:selected").val();
	 var demandyears=$("#demandyears").find("option:selected").val();
	 var url = "/customerDemand/toCustDemand.do?page="+(page+1)+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function toCustDemandTrackList(){
	 var url = "/customerDemand/toCustDemandTrackList.do";
	 window.location.href=url;
 }
 </script>
<body>
    <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求绑定</span></h2>
          <div class="whh_tab_bor">
       		<div class="zyh_sos">
					<span> 技术方向： </span> 
					<select class="zyh_sel zyh_k_heigth " id="technologydirection">
						<option value="">请选择技术</option>
                         <c:forEach items="${profession }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  technologydirection}">  selected="selected" </c:if>>${info.name }</option>
						 </c:forEach>
					</select>
					<span>地区： </span> 
					<select class="zyh_sel zyh_k_heigth" id="projectlocation">
						<option value="">请选择地区</option>
                          <c:forEach items="${arealist }" var="info">
							<option value="${info.areaid }" <c:if test="${info.areaid eq  projectlocation}">  selected="selected" </c:if>>${info.areaname }</option>
						 </c:forEach>
					</select>
                    <span> 级别： </span> 
					<select class="zyh_sel zyh_k_heigth" id="demandyears">
						<option value="">请选择级别</option>
                          <c:forEach items="${grade }" var="info">
							<option value="${info.id }" <c:if test="${info.id eq  demandyears}">  selected="selected" </c:if>>${info.gradename }</option>
						 </c:forEach>
					</select>
					<input type="button" class="zyh_btn" value="查询" onclick="searchByResume()">
					<input style="align:right;float:right;" type="button" class="zyh_btn" value="需求跟踪" onclick="toCustDemandTrackList()">
					<!--  <input type="button" class="zyh_btn zyh_click_btn" value="绑定" onclick="" style="background-color:#FF7E00;">
				     -->
				</div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <!-- <th>选择</th> -->
                     <th style="width:20%">名称</th>
                     <th>绑定人员</th>
                     <th style="width:10%">操作</th>
                     
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(demandList) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到条件信息，请重新查询</td>
					    </tr>
					</c:if>
                 <c:forEach items="${demandList }" var="item">
	                  <tr>
	                   <!-- <td><input type="checkbox" name=""></td> -->
	                   <td><a href="/customerDemand/editCustomerDemand.do?custDemandId=${item.custDemand.id}&coper=0" target="true">${item.custDemand.corpname},${item.custDemand.name },${item.custDemand.areaname },${item.custDemand.gradename }</a></td>
	                   <td>
	                   <c:forEach items="${item.custList }" var="cust">
	                    &nbsp; <a href='/customerDatailInfo/toCustomerDatailInfo.do?customercode=${cust.customercode}' target="true">${cust.customername}</a>&nbsp;
	                   </c:forEach>
	                   </td>
	                   <td>
	                   <input type="button" class="zyh_btn zyh_click_btn" value="绑定" onclick="setBudding('${item.custDemand.id}')" style="background-color:#FF7E00;">
	                   </td>
	                 </tr>
                  </c:forEach>
                  <tr>
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
   
 <div class="zyh_b_box">
 	<div class="zyh_bb_box">
    	<a class="zyh_pos_x">ｘ</a>
    	<h1>指定人员</h1>
    	<div class="zyh_sor_r">
        <ul>
       		 <c:forEach items="${customName }" var="item">
        		<li><label><input type="checkbox" value="${item.customercode }" name="custlist">${item.customername }</label></li>
        	</c:forEach>
        </ul>
        </div>
        
        <div class="zyh_xuqiu_bx" >
        <input class="zyh_xuqiu_btt" type="button"  value="确定" onclick="binding()">
        </div>
    </div>
 </div>
 </body>
 <script>
    $(".zyh_click_btn").click(function(){
		$(".zyh_b_box").show();
	})
	$(".zyh_pos_x,.zyh_xuqiu_btt").click(function(){
		$(".zyh_b_box").hide();
	})</script>
</html>