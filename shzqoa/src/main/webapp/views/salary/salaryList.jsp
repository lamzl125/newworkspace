<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>计算工资</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
  <script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
 </head>
 <style>
 .zyh_rated_box{ width:960px; overflow:hidden; margin-left:20px; background-color:#E0EFF5; height:auto;}
  .zyh_rated_box span{ display:block; float:left; margin-left:20px; margin-bottom:10px;}
 .zyh_rated_btn{ width:120px; height:36px; background-color:#FF7D01; border:none; color:#fff; border-radius:3px; display: inline-block; line-height:36px; margin-top:20px; margin-bottom:20px;}
 .zyh_rated_btn:hover{ background-color:#FFA501;}
 .zyh_rated_shao{ width:960px; overflow:hidden; margin-top:10px;}
 .whh_wraper.width{ width:1200px;}
 .zyh_tab_size th{ font-size:12px;}
 .whh_tab1{margin-top: 20px;}
 </style>
 <script type="text/javascript">
function togetListBypage(page){
	var url = "/salary/salaryList.do?page="+page;
	window.location.href=url;
}
function tonextpageInfo(page){
	var url = "/salary/salaryList.do?page="+(page+1);
	window.location.href=url;
}
function toprevpageInfo(page){
	var url = "/salary/salaryList.do?page="+(page-1);
	window.location.href=url;
}
function topageInfo(){
	var topage = $("#topage").val();
	var url = "/salary/salaryList.do?page="+topage;
	window.location.href=url;
}
function searchsalaryByCon(){
	 var searchcustomercode = $("#searchcustomercode").val().trim();
	 var month = $("#month").val().trim();
	 var url = "/salary/salaryList.do?searchcustomercode="+searchcustomercode+"&month="+month;
	 window.location.href=url;
}
function downsalaryByCon(){
	var searchcustomercode = $("#searchcustomercode").val().trim();
	 var month = $("#month").val().trim();
	 var url = "/salary/downSalaryList.do?searchcustomercode="+searchcustomercode+"&month="+month;
	 window.location.href=url;
}
 </script>
 <body>
   <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper width">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>计算工资</span></h2>
          <div class="whh_tab_bor">
       		<div class="zyh_sos">
            	<span class="zyh_k_heigth">人员姓名：</span>
                <select class="whh_sel" id="searchcustomercode" >
                     <option value="">请选择</option>
                     <c:forEach items="${custList}" var="item">
                      		<option <c:if test="${searchcustomercode==item.customercode}">selected</c:if> value='${item.customercode}'>${item.customername}</option>
                     </c:forEach>
                </select>
                <span class="zyh_k_heigth">状态：</span>
                <input type="text" class="whh_input" id="month" onclick="WdatePicker({skin:'whyGreen',dateFmt:'yyyy/MM',maxDate:new Date()})" onblur="$(this).trigger('change')" value=${month}>
				<input type="button" class="zyh_btn" value="查询" onclick="searchsalaryByCon();">
				<input type="button" class="zyh_btn" value="导出" onclick="downsalaryByCon();" >
            </div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1 zyh_tab_size">
                <thead>
                  <tr>
<!--                      <th>序号</th> -->
                     <th>姓名</th>
                     <th>是否转正</th>
                     <th>实际出勤</th>
<!--                      <th>法定出勤</th> -->
                     <th>工资</th>
                     <th>加班小时</th>
                     <th>请假天数</th>
                     <th>迟到早退</th>
                     <th>扣工资</th>
                     <th>实际工资</th>
                     <th>实际出勤</th>
<!--                      <th>法定出勤</th> -->
                     <th>入项实际工资</th>
                     <th>工资合计</th>
                     <th>税金</th>
                     <th>扣借款</th>
                     <th>扣住宿</th>
                     <th>报销</th>
                     <th>保险</th>
                     <th>补助</th>
                     <th>实发工资</th>
                 </tr>
                </thead>
                <tbody>
                	<c:forEach items="${list}" var="item" varStatus="status">
		                  <tr>
<%-- 		                   <td>${status.index+1}</td> --%>
		                   <td><a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${item.CustomerCode}">${item.CustomerName}</a></td>
		                   <td>是
		                   		<c:if test="${item.ifZZ==1}">
		                   		已经转正
		                   		</c:if>
		                   		<c:if test="${item.ifZZ==2}">
		                   		未转正
		                   		</c:if>
		                   		<c:if test="${item.ifZZ==3}">
		                   		月内转正
		                   		</c:if>
		                   </td>
		                   <td>${item.XzTime}</td>
<%-- 		                   <td>${item.XzFdTime}</td> --%>
		                   <td><fmt:formatNumber pattern="0.00" value='${item.IdleSalary/item.XzFdTime*item.XzTime}' /></td>
		                   <td>${item.JbHover}</td>
		                   <td>${item.QjTime}</td>
		                   <td>${item.CdTime}</td>
		                   <td>${item.CdTime*10}</td>
		                   <td><fmt:formatNumber pattern="0.00" value='${item.IdleSalary/item.XzFdTime*item.XzTime-item.CdTime*10}' /></td>
		                   <td>${item.SjTime}</td>
<%-- 		                   <td>${item.FdTime}</td> --%>
		                   <td><fmt:formatNumber pattern="0.00" value='${item.ProbationarySalary/item.SyqFdTime*item.SyqTime+item.RegularSalary/item.FdTime*item.SjTime}' /></td>
		                   <td><fmt:formatNumber pattern="0.00" value='${item.IdleSalary/item.XzFdTime*item.XzTime-item.CdTime*10+item.ProbationarySalary/item.SyqFdTime*item.SyqTime+item.RegularSalary/item.FdTime*item.SjTime}' /></td>
		                   <td>${item.Sj}</td>
		                   <td>${item.Kjk}</td>
		                   <td>${item.Kzs}</td>
		                   <td>${item.Bxiao}</td>
		                   <td>${item.Bxian}</td>
		                   <td>${item.Bz}</td>
		                   <td><fmt:formatNumber pattern="0.00" value='${item.IdleSalary/item.XzFdTime*item.XzTime-item.CdTime*10+item.ProbationarySalary/item.SyqFdTime*item.SyqTime+item.RegularSalary/item.FdTime*item.SjTime-item.Sj-item.Kjk-item.Kzs+item.Bxiao+item.Bxian+item.Bz}' /></td>
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