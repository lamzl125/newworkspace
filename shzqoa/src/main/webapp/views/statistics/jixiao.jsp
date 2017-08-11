<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>绩效统计</title>
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
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
 </head>
 <style>
 .zyh_sos{ width:100%; overflow:hidden; margin-bottom:10px;}
 .zyh_sos span,.zyh_txt,.zyh_btn_n{ float:left; line-height:30px;}
 .zyh_txt{ border-radius:3px; padding-left:5px; border:#F1F1F1 1px solid; width:90px; height:30px;}
 .zyh_btn_n{ width:80px; height:30px; color:#fff; background-color:#0aa7e6; border:none; border-radius:5px; margin-left:5px;cursor: pointer;}
 </style>
 <script type="text/javascript">
 $(document).ready(function(){
 	  initMemu(2,1);
   })
   
   function search(){
	 var opertname = encodeURI(encodeURI($("#userName").val()));
	 var url = "/user/search.do?opertname="+opertname;
 	 window.location.href=url;
 }
 
 function togetListBypage(page){
	 var opertname = encodeURI(encodeURI($("#userName").val()));
 	var url = "/user/search.do?opertname="+opertname+"&page="+page;
 	window.location.href=url;
 }
 function tonextpageInfo(page){
	 var opertname = encodeURI(encodeURI($("#userName").val()));
 	var url = "/user/search.do?opertname="+opertname+"&page="+(page+1);
 	window.location.href=url;
 }
 function toprevpageInfo(page){
	 var opertname = encodeURI(encodeURI($("#userName").val()));
		var url = "/user/search.do?opertname="+opertname+"&page="+(page-1);
 	window.location.href=url;
 }
 function topageInfo(){
	 var opertname = encodeURI(encodeURI($("#userName").val()));
	 var topage = $("#topage").val();
  	var url = "/user/search.do?opertname="+opertname+"&page="+topage;
  	window.location.href=url;
  }
	  
 </script>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="信息绩效统计" class="tip-bottom"><i class="icon-home"></i>信息绩效统计</a>
	     	<a href="" title="绩效统计" class="current">绩效统计</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>绩效统计</h5>
          </div>
          <div class="widget-content clearfix">
            <div class="zyh_sos">
            	<span>
               	 姓名：
                </span>
                <input type="text" class="zyh_txt" placeholder="输入姓名" id="userName" value="${opertname }">
                
                <input type="button" class="zyh_btn_n" value="搜索" onclick="search();">
            </div>
            
            <table class="table table-bordered table-striped with-check">
            <colgroup>
            	<col width="20%"><col width="20%"><col width="15%"><col width="15%"><col width="15%"><col width="15%">
            </colgroup>
              <thead>
                <tr><th>姓名</th><th>统计</th><th>成功人数</th><th>未成功</th><th>待入职</th><th>成功率</th></tr>
              </thead>
              <tbody>
           			<c:if test="${fn:length(userCount) == 0}">
						<tr>
							<td colspan="12" style="text-align: center">没有简历信息</td>
					    </tr>
					</c:if>
	                <c:forEach var="count" items="${userCount }">
	                  <tr>
	                   <td><a href="/PerfomanceDetail.do?&opertCode=${count.userCode }">${count.realName }</a></td>
	                   <td><a href="/jianLiDetails/selectJianLiDetails.do?opertCode=${count.userCode }">${count.tongji }份</a></td>
	                   <td>${count.zhruzhiCount + count.zqruzhiCount }人</td>
	                   <td>${count.zhwuguanxiCount + count.zqwuguanxiCount }人</td>
	                   <td>${count.zhdairuzhiCount + count.zqdairuzhiCount }人</td>
	                   <c:if test="${count.tongji==0}">
	                   	<td>0%</td>
	                   </c:if>
	                   <c:if test="${count.tongji!=0}">
	                   	<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${count.succes} "/></td>
	                   </c:if>
	                 </tr>
	                </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0);" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
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
          </div>
        </div>
  </div>
</div>

















   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>绩效统计</span></h2>
          <div class="whh_tab_bor">
            <div class="zyh_sos">
            	<span>
               	 姓名：
                </span>
                <input type="text" class="zyh_txt" placeholder="输入姓名" id="userName" value="${opertname }">
                
                <input type="button" class="zyh_btn_n" value="搜索" onclick="search();">
            </div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <th>姓名</th>
	                 <th>统计</th>
                     <th>成功人数</th>
                     <th>未成功</th>
                     <th>待入职</th>
                     <th>成功率</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(userCount) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有简历信息</td>
				    </tr>
				</c:if>
                <c:forEach var="count" items="${userCount }">
                  <tr>
                   <td><a href="/PerfomanceDetail.do?&opertCode=${count.userCode }">${count.realName }</a></td>
                   <td><a href="/jianLiDetails/selectJianLiDetails.do?opertCode=${count.userCode }">${count.tongji }份</a></td>
                   <td>${count.zhruzhiCount + count.zqruzhiCount }人</td>
                   <td>${count.zhwuguanxiCount + count.zqwuguanxiCount }人</td>
                   <td>${count.zhdairuzhiCount + count.zqdairuzhiCount }人</td>
                   <c:if test="${count.tongji==0}">
                   	<td>0%</td>
                   </c:if>
                   <c:if test="${count.tongji!=0}">
                   	<td><fmt:formatNumber type="percent" maxIntegerDigits="3" value="${count.succes} "/></td>
                   </c:if>
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
		</div>
       </div>
   </div>
 </body>
</html>