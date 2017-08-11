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
    $(function(){
      $("#btn_add").click(function(){
        $(".whh_tab_add").show();
      })
    })
    function togetListBypage(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var customercode = $("#customercode").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
    	var customercode = $("#customercode").val();
    	var topage = $("#topage").val();
    	var url = "/customerDatailInfo/toCustomerDatailInfo.do?customercode="+customercode+"&page="+topage;
    	window.location.href=url;
    }
    function addContInf(){
    	var customercode = $("#customercode").val();
    	var currusercode = $("#curruserid").val();
    	var newcontmemo = $("#newcontmemo").val();
    	var newentprobability = $("#newentprobability").val();
    	if(newentprobability==null || newentprobability == ""){
    		alert("请填写入职概率");
    		return false;
    	}else{
    		if(isNaN(newentprobability)){
    			alert("入职概率只能为数字");
    			return false;
    		}else{
    			if(newentprobability<0||newentprobability>100){
    				alert("入职概率只能为0-100之间的数字");
        			return false;
    			}
    		}
    	}
    	var newrelationshipbyzh = $("#newrelationshipbyzh").val();
    	var newrelationshipbyzq = $("#newrelationshipbyzq").val();
    	var updateStatus = $("#updateStatus").val();
    	var data = {
    			"customercode":customercode,"newcontmemo":newcontmemo,"newentprobability":newentprobability,
    			"newrelationshipbyzh":newrelationshipbyzh,"newrelationshipbyzq":newrelationshipbyzq,
    			"currusercode":currusercode,"updateStatus":updateStatus,
    			}
    	$.ajax({
			data : data,
			url : "/contactDate/addContactDate.do",
			type : "post",
			dataType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.rightmsg);
					parent.location.reload();
				} else if (result.status != 0) {
					alert(result.errormsg);
				}
			}
		});
    }
    function downloadfile(filename){
    	var url = "/readDocOnline/download.do?fileName="+filename;
    	window.open(url,'_blank');
    }
    $(document).ready(function(){
  	  initMemu(1);
    })
  </script>
 </head>
 <body>
 <input type="hidden" id="curruserid" value=${user.usercode}>
 <input type="hidden" id="customercode" value=${customerInfo.customercode}>
  <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>需求详情信息</span>
          	<input type="button" value="上一步" class="zyh_syb" onClick="javascript:window.history.go(-1)">
          </h2>
          <div class="whh_tab_bor">
              <ul class="whh_ul">
                <li>客户编号: <label>${demandDetail.CorpName }</label></li>
                <li>技术方向: <label>${demandDetail.name }</label></li>
                <li>项目地点:  <label>${demandDetail.AreaName }</label></li>
                <li>级别:  <label>${demandDetail.gradename }</label></li>
                <li>学历要求: <label>${demandDetail.Education }</label></li>
                <li>需求人数:  <label>${demandDetail.Demandnumber }</label></li>
                <li>需求名称:<label>${demandDetail.Projecttype }</label></li>
              	<li>重要级别:  <label>${demandDetail.Importantlevel }</label></li>
                <li style="width:100%;">技术要求: <label>${demandDetail.Specificrequirement }</label></li>
                <li style="width:100%;">详细地址: <label>${demandDetail.Projectlocation }</label></li>
                <li style="width:100%;">备注其他:  <label>${demandDetail.Remarks }</label></li>
              </ul>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <th>抢取人</th>
                     <th>抢取/分配时间</th>
                     <th>抢取顺序</th>
                     <th>比例</th>
                 </tr>
                </thead>
                <tbody>
                    <c:forEach items="${demandresumeList }" var="demandresume" >
                    <tr>
                		<td>${demandresume.realName }</td>
                		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${demandresume.SignedTime }" /></td>
                		<td>${demandresume.SingnedIndex }</td>
                		<td>${demandresume.Proportion }%</td>
                	</tr>
                    </c:forEach>
                	
                </tbody>
              </table>  
          </div>

       </div>
   </div>
 </body>
</html>