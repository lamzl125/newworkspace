<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%>
<script language="JavaScript">
var v;
<s:if test="hasActionMessages()"> 
<s:iterator value="actionMessages">
    v = "<s:property escape='false'/>";
</s:iterator>   
</s:if>

</script>
权限不足,请<a href="javascript:history.go(-1);">返回</a>.
