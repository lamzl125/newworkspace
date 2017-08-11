<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求简历列表</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
<link rel="stylesheet" href="/views/resource/css/style.css">
<script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<script src="/views/resource/layer/layer.js"></script>
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
 function search(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url =  "/customerDemand/toCustDemandList.do?customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
 }
 function topageInfo(){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var topage = $("#topage").val();
	 var url = "/customerDemand/toCustDemandList.do?page="+topage+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function toprevpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+(page-1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function togetListBypage(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+page+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function tonextpageInfo(page){
	 var customername=$("#cusname").val().trim();
	 var technologydirection=$("#technologydirection").find("option:selected").val();;
	 var projectlocation=$("#projectlocation").val().trim();
	 var demandyears=$("#demandyears").val().trim();
	 var url = "/customerDemand/toCustDemandList.do?page="+(page+1)+"&customername="+customername+"&technologydirection="+technologydirection+"&projectlocation="+projectlocation+"&demandyears="+demandyears;
	 window.location.href=url;
	}
 function deletedemand(did){
	 if(confirm("确定要删除么?")){
		 $.ajax({
			 data: {"Id":did,},
	         type: "post",
	         url: "/customerDemand/deleteCusdemand.do",
	         dataType: "json",
	         success: function(result){
	        	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	         }
	     });
	 }
 }
 function editdemand(did){
	 window.location="/customerDemand/editCustomerDemand.do?custDemandId="+did+"&coper=1";
 }
 function closedemand(did){
	 if(confirm("确定要关闭需求吗?")){
		 $.ajax({
			 data: {"demandid":did,},
	        type: "post",
	        url: "/customerDemand/closeDemand.do",
	        dataType: "json",
	        success: function(result){
	       	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	        }
	    }); 
	 }
}
 function opendemand(did){
	 if(confirm("确定要恢复需求吗?")){
		 $.ajax({
			 data: {"demandid":did,},
	        type: "post",
	        url: "/customerDemand/openDemand.do",
	        dataType: "json",
	        success: function(result){
	       	 if (result.status == 0) {
						alert(result.msg);
						parent.location.reload();
					} else if (result.status != 0) {
						alert(result.msg);
					}
	        }
	    }); 
	 }
}
 function grab(id){
	 alert("恭喜你，抢取成功");
 }
 function allot(id){
	 $(".zyh_b_box").show();
 }
 $(".zyh_click_btn").click(function(){
		$(".zyh_b_box").show();
	})
	$(".zyh_pos_x,.zyh_xuqiu_btt").click(function(){
		$(".zyh_b_box").hide();
	})
function binding(){
	 alert("分配成功");
 }
 </script>
 <body>
  <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求简历列表</span></h2>
          <div class="whh_tab_bor">
                <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                  	 <th>姓名</th>
                     <th>性别</th>
                     <th>出生日期</th>
                     <th>电话</th>
                     <th>技术特长</th>
                     <th>录入人</th>
                     <th>操作</th>
                 </tr>
                </thead>
                <!-- <tbody>
                	<tr>
                	   <td>张涛</td>
	                   <td>男</td>
	                   <td>1991/2/1</td>
	                   <td>13727711121</td>
	                   <td>JAVA</td>
	                   <td>张三</td>
	                   <td>
		                   <a class="editButClass" href="/views/demandresume/resumedemandfollowdetail.jsp" onclick="detail(1)">详情</a>
	                 </tr>
	                 <tr>
                	   <td>张涛</td>
	                   <td>男</td>
	                   <td>1991/2/1</td>
	                   <td>13727711121</td>
	                   <td>JAVA</td>
	                   <td>张三</td>
	                   <td>
		                   <a class="editButClass" href="/views/demandresume/resumedemandfollowdetail.jsp" onclick="detail(1)">详情</a>
	                 </tr>
	                 <tr>
                	   <td>张涛</td>
	                   <td>男</td>
	                   <td>1991/2/1</td>
	                   <td>13727711121</td>
	                   <td>JAVA</td>
	                   <td>张三</td>
	                   <td>
		                   <a class="editButClass" href="/views/demandresume/resumedemandfollowdetail.jsp" onclick="detail(1)">详情</a>
	                 </tr>
	                 <tr>
                	   <td>张涛</td>
	                   <td>男</td>
	                   <td>1991/2/1</td>
	                   <td>13727711121</td>
	                   <td>JAVA</td>
	                   <td>张三</td>
	                   <td>
		                   <a class="editButClass" href="/views/demandresume/resumedemandfollowdetail.jsp" onclick="detail(1)">详情</a>
	                 </tr>
	                 <tr>
                	   <td>张涛</td>
	                   <td>男</td>
	                   <td>1991/2/1</td>
	                   <td>13727711121</td>
	                   <td>JAVA</td>
	                   <td>张三</td>
	                   <td>
		                   <a class="editButClass" href="/views/demandresume/resumedemandfollowdetail.jsp" onclick="detail(1)">详情</a>
	                 </tr>
                </tbody> -->
                <tbody>
                <c:forEach items="${list2 }" var="demand" varStatus="status">
	                  <tr>
	                   <!--td style="word-wrap:break-word;">${demand.Id}</td-->
	                   <%-- <td style="word-wrap:break-word;">${status.index+1 }</td> --%>
	                   <td>${demand.CustomerName }</td>
	                   <td>${demand.CustomerSex }</td>
	                   <td>${demand.CustomerBirth }</td>
	                   <td>${demand.CustomerTel }</td>
	                   <td width="260">${demand.TechnicalExpertise }</td>
	                   <td width="80">${demand.OpertName }</td>
	                   <td>
		                   <a class="editButClass" href="/demanresume/demanresumeDetail.do?demandId=${demand.Id}">详情</a>&nbsp;&nbsp;
		                   </td>
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
              <div class="zyh_b_box">
			 	<div class="zyh_bb_box">
			    	<a class="zyh_pos_x"></a>
			    	<h1>指定人员</h1>
			    	<div class="zyh_sor_r">
			        <ul>
		        		<li><label><input type="checkbox" value="1" name="custlist">张三</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">李四</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">王武</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">赵六</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">钱琦</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">李思沄</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">宋量</label></li>
		        		<li><label><input type="checkbox" value="1" name="custlist">魏武雅</label></li>
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
 </body>
</html>