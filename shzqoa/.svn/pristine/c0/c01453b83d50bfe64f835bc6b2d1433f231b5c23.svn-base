<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>查询结果</title>
  <link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />

<script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
<script src="/views/resource/js/jquery.validate.js"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script> 
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 


   
   <script type="text/javascript">
   $(document).ready(function(){
 	  initMemu(1,1);
   })
    function togetListBypage(page){
    	var cusname=$("#customername").val().trim();
   		var sex=$("#customersex").val().trim();
   		var cusphone=$("#customertel").val().trim();
   		var cusbirth=encodeURI(encodeURI($("#customerbirth").val().trim()));
   		var cusuniversity =$("#customeruniversity").val();      
   		var cusspecialities=$("#customerspecialities").val();
   		var entrytime=encodeURI(encodeURI($("#entrytime").val().trim()));
   		var resumesource=$("#resumesource").val().trim();
   		var resumeid=$("#resumeid").val().trim();
   		var lastvcompanyname=$("#lastvcompanyname").val();
   		var lastprojectname=$("#lastprojectname").val();
   		var technicalexpertise=$("#technicalexpertise").val();
   		var relationshipbyzq=$("#relationshipbyzq").val().trim();
   		var relationshipbyzh=$("#relationshipbyzh").val().trim();
   		var entryprobability=$("#entryprobability").val().trim();
   		var lastupdatestatic=$("#lastupdatestatic").val().trim();
   		var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customerbirth="+cusbirth+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&entrytime="+entrytime+"&resumesource="+resumesource+"&resumeid="+resumeid+"&lastvcompanyname="+lastvcompanyname+"&lastprojectname="+lastprojectname+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&relationshipbyzh="+relationshipbyzh+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic+"&page="+page;
    	window.location.href=url;
    }
    function tonextpageInfo(page){
    	var cusname=$("#customername").val().trim();
   		var sex=$("#customersex").val().trim();
   		if(sex==''){
   			sex==-1;
   		}
   		var cusphone=$("#customertel").val().trim();
   		var cusbirth=encodeURI(encodeURI($("#customerbirth").val().trim()));
   		var cusuniversity =$("#customeruniversity").val();      
   		var cusspecialities=$("#customerspecialities").val();
   		var entrytime=encodeURI(encodeURI($("#entrytime").val().trim()));
   		var resumesource=$("#resumesource").val().trim();
   		var resumeid=$("#resumeid").val().trim();
   		var lastvcompanyname=$("#lastvcompanyname").val();
   		var lastprojectname=$("#lastprojectname").val();
   		var technicalexpertise=$("#technicalexpertise").val();
   		var relationshipbyzq=$("#relationshipbyzq").val().trim();
   		var relationshipbyzh=$("#relationshipbyzh").val().trim();
   		var entryprobability=$("#entryprobability").val().trim();
   		var lastupdatestatic=$("#lastupdatestatic").val().trim();
   		var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customerbirth="+cusbirth+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&entrytime="+entrytime+"&resumesource="+resumesource+"&resumeid="+resumeid+"&lastvcompanyname="+lastvcompanyname+"&lastprojectname="+lastprojectname+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&relationshipbyzh="+relationshipbyzh+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic+"&page="+(page+1);
    	window.location.href=url;
    }
    function toprevpageInfo(page){
    	var cusname=$("#customername").val().trim();
   		var sex=$("#customersex").val().trim();
   		if(sex==''){
   			sex==-1;
   		}
   		var cusphone=$("#customertel").val().trim();
   		var cusbirth=encodeURI(encodeURI($("#customerbirth").val().trim()));
   		var cusuniversity =$("#customeruniversity").val();      
   		var cusspecialities=$("#customerspecialities").val();
   		var entrytime=encodeURI(encodeURI($("#entrytime").val().trim()));
   		var resumesource=$("#resumesource").val().trim();
   		var resumeid=$("#resumeid").val().trim();
   		var lastvcompanyname=$("#lastvcompanyname").val();
   		var lastprojectname=$("#lastprojectname").val();
   		var technicalexpertise=$("#technicalexpertise").val();
   		var relationshipbyzq=$("#relationshipbyzq").val().trim();
   		var relationshipbyzh=$("#relationshipbyzh").val().trim();
   		var entryprobability=$("#entryprobability").val().trim();
   		var lastupdatestatic=$("#lastupdatestatic").val().trim();
   		var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customerbirth="+cusbirth+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&entrytime="+entrytime+"&resumesource="+resumesource+"&resumeid="+resumeid+"&lastvcompanyname="+lastvcompanyname+"&lastprojectname="+lastprojectname+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&relationshipbyzh="+relationshipbyzh+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic+"&page="+(page-1);
    	window.location.href=url;
    }
    function topageInfo(){
    	var cusname=$("#customername").val().trim();
   		var sex=$("#customersex").val().trim();
   		if(sex==''){
   			sex==-1;
   		}
   		var cusphone=$("#customertel").val().trim();
   		var cusbirth=encodeURI(encodeURI($("#customerbirth").val().trim()));
   		var cusuniversity =$("#customeruniversity").val();      
   		var cusspecialities=$("#customerspecialities").val();
   		var entrytime=encodeURI(encodeURI($("#entrytime").val().trim()));
   		var resumesource=$("#resumesource").val().trim();
   		var resumeid=$("#resumeid").val().trim();
   		var lastvcompanyname=$("#lastvcompanyname").val();
   		var lastprojectname=$("#lastprojectname").val();
   		var technicalexpertise=$("#technicalexpertise").val();
   		var relationshipbyzq=$("#relationshipbyzq").val().trim();
   		var relationshipbyzh=$("#relationshipbyzh").val().trim();
   		var entryprobability=$("#entryprobability").val().trim();
   		var lastupdatestatic=$("#lastupdatestatic").val().trim();
   		var topage = $("#topage").val();
   		var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customerbirth="+cusbirth+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&entrytime="+entrytime+"&resumesource="+resumesource+"&resumeid="+resumeid+"&lastvcompanyname="+lastvcompanyname+"&lastprojectname="+lastprojectname+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&relationshipbyzh="+relationshipbyzh+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic+"&page="+topage;
    	window.location.href=url;
    }
  </script>
 </head>
 <body>
  <input type="hidden" id="customername" value="${customername}"/>
  <input type="hidden" id="customersex" value="${customersex}"/>
  <input type="hidden" id="customertel" value="${customertel}"/>
  <input type="hidden" id="customerbirth" value="${customerbirth}"/>
  <input type="hidden" id="customeruniversity" value="${customeruniversity}"/>
  <input type="hidden" id="customerspecialities" value="${customerspecialities}"/>
  <input type="hidden" id="entrytime" value="${entrytime}"/>
  <input type="hidden" id="resumesource" value="${resumesource}"/>
  <input type="hidden" id="resumeid" value="${resumeid}"/>
  <input type="hidden" id="lastvcompanyname" value="${lastvcompanyname}"/>
  <input type="hidden" id="lastprojectname" value="${lastprojectname}"/>
  <input type="hidden" id="technicalexpertise" value="${technicalexpertise}"/>
  <input type="hidden" id="relationshipbyzq" value="${relationshipbyzq}"/>
  <input type="hidden" id="relationshipbyzh" value="${relationshipbyzh}"/>
  <input type="hidden" id="entryprobability" value="${entryprobability}"/>
  <input type="hidden" id="lastupdatestatic" value="${lastupdatestatic }"/>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
    	<a href="index.html" title="查询员工信息" class="tip-bottom"><i class="icon-home"></i>查询员工信息</a>
     	<a href="" title="查询结果" class="current">查询结果</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>查询结果</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
            	<colgroup>
            		<col width="10%" /><col width="10%" /><col width="10%" /><col width="10%" /><col width="40%" /><col width="10%" /><col width="10%" />
            	</colgroup>
              <thead>
                <tr><th>姓名</th><th>时间</th><th>出生日期</th><th>入职概率</th><th>技术特长<br/></th><th>综合评价</th><!-- <th>备注</th> --><th>操作</th></tr>
              </thead>
              <tbody>
	              	<c:if test="${fn:length(customerInfoList) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">未查询到人员信息</td>
					    </tr>
					</c:if>
	                <c:forEach  items="${customerInfoList}"  var="custInfo">
		                <c:if test="${custInfo.lastCont != 0 }">
		                	<tr>
		                	<td>
		                	<input type="hidden"  value="${custInfo.customercode }" />
		                	<a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${custInfo.customercode }"  style="color: red;">${custInfo.customername }</a></td>
		                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.resumeupdatedate }" /></td>
		                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.customerbirth }" /></td>
		                   <td>${custInfo.entryprobability }</td>
		                   <td>${custInfo.technicalexpertise }</td>
		                   <td>	<c:choose>
		                   		<c:when test="${custInfo.synEvaluate>=1 && custInfo.synEvaluate<60 }">一般</c:when>
		                   		<c:when test="${custInfo.synEvaluate>=60 && custInfo.synEvaluate<80 }">良好</c:when>
		                   		<c:when test="${custInfo.synEvaluate>=80 && custInfo.synEvaluate<=100 }">优秀</c:when>
		                   	</c:choose></td>
		                   <%-- <td>${custInfo.memo }</td> --%>
		                   <td ><a class="appraiseButClass" href="/PingJia/edit.do?customercode=${custInfo.customercode }" class="zyh_tan_btn">添加评价</a></td>
		                 </tr>
		                </c:if>
		                 <c:if test="${custInfo.lastCont == 0 }">
		                	<tr>
		                	<td>
		                	<input type="hidden"  value="${custInfo.customercode }" />
		                	<a href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${custInfo.customercode }">${custInfo.customername }</a></td>
		                    <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.resumeupdatedate }" /></td>
		                   <td><fmt:formatDate pattern="yyyy/MM/dd" value="${custInfo.customerbirth }" /></td>
		                   <td>${custInfo.entryprobability }</td>
		                   <td>${custInfo.technicalexpertise }</td>
		                   <td>
		                   	<c:choose>
		                   		<c:when test="${custInfo.synEvaluate>=1 && custInfo.synEvaluate<60 }">一般</c:when>
		                   		<c:when test="${custInfo.synEvaluate>=60 && custInfo.synEvaluate<80 }">良好</c:when>
		                   		<c:when test="${custInfo.synEvaluate>=80 && custInfo.synEvaluate<=100 }">优秀</c:when>
		                   	</c:choose>
		                   </td>
		                   <%-- <td>${custInfo.memo }</td> --%>
		                   <td ><a class="appraiseButClass" href="/PingJia/edit.do?customercode=${custInfo.customercode }" class="zyh_tan_btn">添加评价</a></td><%-- href="/PingJia/edit.do?customercode=${custInfo.customercode }" --%>
		                 </tr>
		                 </c:if>
	                </c:forEach>
              </tbody>
            </table>
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
            <p style="text-align: center;"><a href="/inquiry.do" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" >继续查询</a></p>
          </div>
        </div>
  </div>
</div>


 <!-- <div class="zyh_tan_box" style="display: none;">
	<div class="zyh_tan">
    	<a href="#" class="zyh_x">Ｘ</a>
       	<h3 style="text-align:center;">评价</h3>
    	<div class="zyh_tan_k">
        	<div class="zyh_bx">
        	<span>沟 通 评 价</span>
                            <select class='sect'>
                            	<option value="60">1-60分</option>
                            	<option value="80">60-80分</option>                        
                            	<option value="100">80-100分</option>
                            </select>
              <input type="button" value="一般" class="zyh_tan_btn input_id">
            </div>
        	<div class="zyh_tan_t zyh_bx">
        	<span>项 目 描 述</span>
                            <select class='sect'>
                            	<option value="一般">1-60分</option>
                            	<option value="良好">60-80分</option>                        
                            	<option value="优秀">80-100分</option>
                            </select>
              <input type="button" value="一般" class="zyh_tan_btn input_id">
            </div>
        	<div class="zyh_tan_t zyh_bx">
        	<span>综 合 评 价</span>
                            <select class='sect'>
                            	<option value="一般">1-60分</option>
                            	<option value="良好">60-80分</option>                        
                            	<option value="优秀">80-100分</option>
                            </select>
              <input type="button" value="一般" class="zyh_tan_btn input_id">
            </div>
            <button class="zyh_btt">确认</button>
        </div>
    </div>   	
</div> -->
<!--  <script type="text/javascript">
$(function(){
	$(".zyh_x").click(function(){
	  $(".zyh_tan_box").hide();	
	})
	  

$(".sect").change(function(){
	 var s=$(this).val();//拿到select选中的val值
	 $(this).next(".input_id").val(s);
     
})	
$(".zyh_tan_btn").click(function(){
	$(".zyh_tan_box").show();
	
})

})
</script> -->
 </body>
</html>