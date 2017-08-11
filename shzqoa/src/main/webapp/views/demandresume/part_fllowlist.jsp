<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
.onSelect{
background-color:#EEEEEE;
}


 
</style>
<script type="text/javascript">

</script> 
        <%--  <input type="hidden" id="demandresumeId" value="${demandresumeId}"> --%>
         <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1 whh_tab_show">
                  <thead>
	                  	<tr>
	                      	<th>跟踪时间</th>
	  						<th>跟踪人</th>
	  						<th>状态</th>
	  						<th>截图</th>
	  						<th>备注</th>
	  					</tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${resusmeFollowList}" var="follow">
                    <tr>
                     <td><fmt:formatDate value="${follow.TrackingTime}" pattern="yyyy-MM-dd " /></td>
                     <td>${follow.realName}</td>
                     <td><c:if test="${follow.ArrangeEntryStatus==1}">已入项</c:if>
                     <c:if test="${follow.RetestResultStatus==1&&follow.ArrangeEntryStatus==null}">复试通过</c:if>
                     <c:if test="${follow.RetestResultStatus==2&&follow.ArrangeEntryStatus==null}">复试未通过</c:if>
                     <c:if test="${follow.RetestStatus==1&&follow.RetestResultStatus==null}">需要复试</c:if>
                     <c:if test="${follow.InterviewResultStatus==1&&follow.RetestStatus==null}">面试通过</c:if>
                     <c:if test="${follow.InterviewResultStatus==2&&follow.RetestStatus==null}">面试未通过</c:if>
                     
                     <c:if test="${follow.NoticeInterviewStatus==1&&follow.InterviewResultStatus==null}">通知面试</c:if>
                     <c:if test="${follow.ScreeningResumesStatus==1&&follow.NoticeInterviewStatus==null}">简历帅选通过</c:if>
                     <c:if test="${follow.SendResumeStatus==1&&follow.ScreeningResumesStatus==null}">简历未发客户</c:if>
                     <c:if test="${follow.SendResumeStatus==2&&follow.ScreeningResumesStatus==null}">简历已发客户</c:if>
                     </td>
                     <td>  <img src="${follow.PicUrl }" id="picshow" height="100" width="100" align="middle"></img></td>
                     <td>${follow.Remark }</td>
                   </tr>
                   </c:forEach>
                  </tbody>
                </table> 
                <!-- <p style="text-align: center;"><a href="javascript:void(0)" class="whh_btn whh_btn_big mt20 whh_btn_big_or" onclick="toflow()">跟踪</a></p> -->