<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.shzqoa.model.User" %>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>查询员工信息</title>
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
    <script>
    $(document).ready(function(){
  	  initMemu(1,1);
    })
    </script>
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="查询员工信息" class="current">查询员工信息</a>
    </div>
  </div>

  <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>查询员工信息</h5>
          </div>
          <div class="widget-content clearfix">
          		 <form name="signupForm" method="post" id="signupForm" class="form-inline">
			       <div class="whh_content whh_content_border">
			          <div class="whh_tab_bor">
			              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
			                <tbody>
			                  	<tr>
				                   <td width="40%" class="whh_right">姓名：</td>
				                   <td><input type="text" class="whh_input" id="cusname" placeholder="请输入姓名" /></td>
			               		</tr>
				                <tr>   
				                   <td class="whh_right">性别：</td>
				                   <td>
					                   <div>
						                   <label class="whh_label"><input type="radio" name="sex" value="0"/>男</label>
						                   <label class="whh_label"><input type="radio" name="sex" value="1" />女</label>
						                   <label class="whh_label"><input type="radio" name="sex" value="-1" checked/>不限</label>
					                   </div>
				                   </td>
				                 </tr>
			                 	<tr>
				                   <td class="whh_right">电话：</td>
				                   <td><input type="text" class="whh_input" id="cusphone" placeholder="请输入电话" /></td>
			               		</tr>
			               		<!-- 
			               		<tr>
				                   <td class="whh_right">电话：</td>
				                   <td><input type="text" class="whh_input" id="cusbirth" placeholder="请输入出生日期" onclick="WdatePicker()" readonly/></td>
			               		</tr>
			               		<tr>
				                   <td class="whh_right">入职日期：</td>
				                   <td><input type="text" class="whh_input" id="entrytime" placeholder="请输入入职日期" onclick="WdatePicker()" readonly/></td>
			               		</tr>
			               		<tr>
				                   <td class="whh_right">最近公司名称：</td>
				                   <td><input type="text" class="whh_input" id="lastvcompanyname" placeholder="请输入最近公司名称" /></td>
			               		</tr>
			               		 -->
			               		<tr>
				                   <td class="whh_right">毕业院校：</td>
				                   <td><input type="text" class="whh_input" id="cusuniversity" placeholder="请输入毕业院校" /></td>
			               		</tr>
			                 	<tr>
				                   <td class="whh_right">所学专业：</td>
				                   <td><input type="text" class="whh_input" id="cusspecialities" placeholder="请输入所学专业" /></td>
			               		</tr>
				                 <tr>
				                   <td class="whh_right">简历出处：</td>
				                   <td>
				                       <select class="whh_sel"  id="resumesource">
				                       	  <option value="">请选择出处</option>
				                       	   <c:forEach items="${resumeSourceList}" var="info">
				                          		<option value=${info.resumesourceid}>${info.resumesourcename}</option>
				                          </c:forEach>
				                       </select>
				                   	</td>
				                  </tr>
				                 	<tr>
					                   <td class="whh_right">简历ID：</td>
					                   <td><input type="text" class="whh_input" id="resumeid" placeholder="请输入简历ID" /></td>
				               		</tr>
				               		
				               		<tr>
					                   <td class="whh_right">最近项目名称：</td>
					                   <td><input type="text" class="whh_input" id="lastprojectname" placeholder="请输入最近项目名称" /></td>
				               		</tr>
				               		<tr>
					                   <td class="whh_right">技术特长：</td>
					                   <td><input type="text" class="whh_input" id="technicalexpertise" placeholder="请输入技术特长" /></td>
				               		</tr>
				               		<tr>
					                   <td class="whh_right">与梓钦关系：</td>
					                   <td>
					                   		<label class="whh_label"><input type="radio" name="ziqin"  value="1" />已离职</label>
					                   		<label class="whh_label"><input type="radio" name="ziqin" value="2"/>在职</label>
					                   		<label class="whh_label"><input type="radio" name="ziqin" value="3"/>提交简历未通过</label>
					                   		<label class="whh_label"><input type="radio" name="ziqin" value="4" />待入职</label>
					                   		<label class="whh_label"><input type="radio" name="ziqin" value="5" />无关系</label>
					                   </td>
				               		</tr>
				               		<!-- 
				               		<tr>
					                   <td class="whh_right">与郑州公司关系：</td>
					                   <td>
					                   		<label class="whh_label"><input type="radio" name="zhengzhou" value="1"/>已离职</label>
					                   		<label class="whh_label"><input type="radio" name="zhengzhou"  value="2"/>在职</label>
					                   		<label class="whh_label"><input type="radio" name="zhengzhou"  value="3"/>提交简历未通过</label>
					                   		<label class="whh_label"><input type="radio" name="zhengzhou" value="4"/>待入职</label>
					                   		<label class="whh_label"><input type="radio" name="zhengzhou" value="5" />无关系</label>
					                   </td>
				               		</tr>
				                  	-->
				                  	<tr>
					                   <td class="whh_right">入职概率：</td>
					                   <td><input type="text" class="whh_input" placeholder="请输入入职概率" id="entryprobability"/></td>
				               		</tr>
				               		<tr>
					                   <td class="whh_right">联系状态：</td>
					                   <td>
					                   		<label class="whh_label"><input type="radio" name="lastupdatestatic" value="1"/>电话错误</label>
					                   		<label class="whh_label"><input type="radio" name="lastupdatestatic"  value="2"/>不接电话</label>
					                   		<label class="whh_label"><input type="radio" name="lastupdatestatic"  value="3"/>挂断电话</label>
					                   		<label class="whh_label"><input type="radio" name="lastupdatestatic" value="4"/>不接受外包</label>
					                   		<label class="whh_label"><input type="radio" name="lastupdatestatic" value="5" />其他</label>
										</td>
				               		</tr>
			                </tbody>
			              </table>
			              
			              <p style="text-align:center;">
			               <input id="submitform" type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="查询" onclick="searchCusInfo()" /></p>
			          </div>
			       </div>
			   </form>
          </div>
        </div>
  </div>
</div>

   <script type="text/javascript">
   	function searchCusInfo(){
   		var cusname=encodeURI(encodeURI($("#cusname").val().trim()));
   		var sex=$("input[name='sex']:checked").val();
   		var cusphone=encodeURI(encodeURI($("#cusphone").val().trim()));
        /*var cusbirth=encodeURI(encodeURI($("#cusbirth").val().trim())); */
   		var cusuniversity =encodeURI(encodeURI($("#cusuniversity").val().trim()));      
   		var cusspecialities=encodeURI(encodeURI($("#cusspecialities").val().trim()));
   		/* var entrytime=encodeURI(encodeURI($("#entrytime").val().trim())); */
   		var resumesource=$("#resumesource").find("option:selected").val();
   		var resumeid=encodeURI(encodeURI($("#resumeid").val().trim())); 
   		/* var lastvcompanyname=$("#lastvcompanyname").val(); */
   	    var lastprojectname=encodeURI(encodeURI($("#lastprojectname").val())); 
   		var technicalexpertise=encodeURI(encodeURI($("#technicalexpertise").val().trim()));
   		var relationshipbyzq=$("input[name='ziqin']:checked").val();
   		var lastupdatestatic=$("input[name='lastupdatestatic']:checked").val();
   		if(relationshipbyzq==undefined){
   			relationshipbyzq="";
   		}
   		if(lastupdatestatic==undefined){
   			lastupdatestatic="";
   		}
   		/* var relationshipbyzh=$("input[name='zhengzhou']:checked").val(); 
   		if(relationshipbyzh==undefined){
   			relationshipbyzh="";
   		} */
   		var entryprobability=$("#entryprobability").val().trim();
   		
    		if(isNaN(entryprobability)){
    			alert("入职概率只能为数字");
    			return false;
    		}
    		if(entryprobability<0||entryprobability>100){
    			alert("入职概率只能为0-100之间的数字");
        		return false;
    		}
    	var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&resumesource="+resumesource+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic+"&resumeid="+resumeid+"&lastprojectname="+lastprojectname;
   		/* var url = "/DocustomerInfo.do?customername="+cusname+"&customersex="+sex+"&customertel="+cusphone+"&customerbirth="+cusbirth+"&customeruniversity="+cusuniversity+"&customerspecialities="+cusspecialities+"&entrytime="+entrytime+"&resumesource="+resumesource+"&resumeid="+resumeid+"&lastvcompanyname="+lastvcompanyname+"&lastprojectname="+lastprojectname+"&technicalexpertise="+technicalexpertise+"&relationshipbyzq="+relationshipbyzq+"&relationshipbyzh="+relationshipbyzh+"&entryprobability="+entryprobability+"&lastupdatestatic="+lastupdatestatic; */
    	window.location.href=url;
   	}
   </script>
 </body>
</html>