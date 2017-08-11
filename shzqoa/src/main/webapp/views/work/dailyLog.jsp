<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>工作日志</title>
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
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
  	<script src="/views/resource/js/jquery.uploadify.min.js"></script>
  <script type="text/javascript">
  $(function(){
	  $("input[type=radio][name=lrjl]").click(function(){
         var $thisval=$(this).val();
         if($thisval=="1"){
            $(this).parents(".zyh_rizhi").find(".tab_jianli").show();
         }else{
            $(this).parents(".zyh_rizhi").find(".tab_jianli").hide();
         }
       });
	  $("#log_b").hide();
	  $(".zyh_bd_rw").click(function (){
		  $("#log_a").hide();
		  $("#log_b").show();
	  });
	  $(".zyh_sz_fx").click(function (){
		  $("#log_a").show();
		  $("#log_b").hide();
	  });
	  var url = window.location.search;
	  if(url.indexOf("?") > -1){
			$(".zyh_bd_rw").click();
		}
	  
	  
  });
  $(document).ready(function(){
	  initMemu(4,1);
	  $(".tab_jianli").hide();
  });
   function table(){
	  $("#tab_jianli_id tr").each(function(i,value){
		  var rid = $(this).find("input[name='IsAddFlag']").val();
		  var data = {	"resumesourceid":rid}
		  $.ajax({
//	 		   type: "post",
	 		   url: "/log/getAllResumeSourceByresumesourceid.do",
	 		   data: data,
	 		   dataType: "json",
	 		   success: function(result){
	 			   $(value).find("input[name='soucecount']").val(result.data);
	 		   }
		  }); 
		  
	  });
	  
   }
   function toprevpageInfo(page){
	   	var logdate = $("#logdate").val();
	    var url = "/log/enter.do?page="+(page-1)+"&logdate="+logdate;
		window.location.href=url;
   }
   
   function togetListBypage(page){
	   var logdate = $("#logdate").val();
	   var url = "/log/enter.do?page="+page+"&logdate="+logdate;
	   window.location.href=url;
   }
   
   function tonextpageInfo(page){
	   var logdate = $("#logdate").val();
	   var url = "/log/enter.do?page="+(page+1)+"&logdate="+logdate;
	   window.location.href=url;
   }
   
   function topageInfo(){
	   var logdate = $("#logdate").val();
	   var topage = $("#topage").val();
	   var url = "/log/enter.do?page="+topage+"&logdate="+logdate;
	   window.location.href=url;
   }
   // 提交工作日志
   function submitWork(){
	   var errrormsg = "";
	   var taskid = $("#task option:selected").val().trim();
	   var publishcontent = $("#task option:selected").text();
	   var userid = $("#usercode").val();
	   var realname = $("#realname").html();
	   var logcontent = $("#logcontent").val().trim();
	   var isAddJ = $("input[type=radio][name=lrjl]:checked").val();
	   
	   var addresumecount = "";
	   if(isAddJ == "1"){
		   $("input[name='IsAddFlag']:checked").each(function (i, n) {
			   if(this.checked){
				   var ele = $(this).parents(".trclass").find(".whh_input");
				   if(ele==null || ele.val() == ""){
					   errrormsg = "请确定选中的简历来源必须输入数量"; 
					   return;
				   }
				   addresumecount+=$(this).val();
				   addresumecount+=";";
				   addresumecount+=ele.val()+"-";
			    }
		   	});
	   }
	   if(errrormsg != ""){
		   alert(errrormsg);
		   return false;
	   }
	   if(logcontent == ""){
		   alert("工作日志内容不能为空!");
		   return;
	   }
	   var weixin = "";
	   var lastCount = "";
	   var addCount = "";
	   var addDynamic = "";
	   var logcon_arr = logcontent.split("\n");
	   var errormsg = "";
	   var  z = /^[0-9]*$/;
	   for(var i=0;i<logcon_arr.length;i++){
           var indexlogcon = logcon_arr[i];
           if(indexlogcon.indexOf("微信号") > 0 ){
        	   if(weixin!=null && weixin != ""){
        		   weixin += "-";
        		   lastCount += "-";
        		   addCount += "-";
        		   addDynamic += "-";
        	   }
        	   var weixininfo = (indexlogcon.substring(indexlogcon.indexOf("微信号：")+4, indexlogcon.indexOf(";原来有微信好友人数："))).trim();
        	   var lastCountinfo = (indexlogcon.substring(indexlogcon.indexOf("原来有微信好友人数：")+10, indexlogcon.indexOf(";今日增加好友数"))).trim();
        	   var addCountinfo = (indexlogcon.substring(indexlogcon.indexOf("今日增加好友数：")+8, indexlogcon.indexOf(";今日朋友圈动态数："))).trim();
        	   var addDynamicinfo = (indexlogcon.substring(indexlogcon.indexOf("今日朋友圈动态数：")+9, indexlogcon.indexOf("。"))).trim();
        	   if(weixininfo==null || weixininfo==""){
    			   errormsg = "微信不能为空";
    			   break;
    		   }
        	   if(lastCountinfo==null || lastCountinfo==""){
    			   errormsg = "原来有微信好友人数不能为空";
    			   break;
    		   }
    		   if(addCountinfo==null || addCountinfo==""){
    			   errormsg = "今日增加好友数不能为空";
    			   break;
    		   }
    		   if(addDynamicinfo==null || addDynamicinfo==""){
    			   errormsg = "今日朋友圈动态数不能为空";
    			   break ;
    		   }
    		   
    		   if(isNaN(lastCountinfo)/* z.test(lastCountinfo) */){
    			   errormsg = "原来有微信好友人数不是数字";
    			   break ;
   			   }
    		   if(isNaN(addCountinfo)/* z.test(addCountinfo) */){
    			   errormsg = "今日增加好友数不是数字";
    			   break ;
   			   }
    		   if(isNaN(addDynamicinfo)/* z.test(addDynamicinfo) */){
    			   errormsg = "今日朋友圈动态数不是数字";
    			   break ;
   			   }
    		   weixin += weixininfo;
    		   lastCount += lastCountinfo;
    		   addCount += addCountinfo;
    		   addDynamic += addDynamicinfo;
           }
       }
	   if(errormsg!=""){
		   alert(errormsg);
		   return false;
	   }
	   
	   
	   if(isAddJ == "1" && (addresumecount==null || addresumecount=="") ){
		   alert("选择录入简历后，简历信息必须至少选择一个");
		   return false;
	   }
	   
	   var propose = $("#propose").val().trim();
	   var taskstatus = $("#taskstatus").val().trim();
	   if(taskid!=null && taskid!="" && (taskstatus==null||taskstatus=="")){
		   alert("选择任务时必须选择任务进度");
		   return false;
	   }
	   if(taskid==null || taskid==""){
		   taskid = 0;
		   taskstatus = 0;
	   }
	   
	   
	   var data = {
		   "taskid":taskid,"publishcontent":publishcontent,"userid":userid,"realname":realname,
	   		"logcontent":logcontent,"propose":propose,"isaddj":isAddJ,
	   		"addresumecount":addresumecount,"taskstatus":taskstatus,"weixin":weixin.trim(),
	   		"lastCount":lastCount,"addCount":addCount,"addDynamic":addDynamic,
	   }
	   $("p input[type='button']").attr("disabled",true);
	   $("p input[type='button']").css("background","#CCCCFF"); 
	   $.ajax({
		   type: "post",
		   url: "/log/addLog.do",
		   data: data,
		   dataType: "json",
		   success: function(result){
			   if(result.status == 1){
				   alert("工作日志提交成功!");
				   window.location.reload();
			   } else {
				   alert("工作日志提交失败!");
			   }
		   }
	   });
   }
   // 搜索
   function search(){
	   var logdate = $("#logdate").val();
	   var url = "/log/enter.do?logdate="+logdate;
	   window.location.href=url;
   }
   function toreplylog(obj){
	   var dailylogid = $(obj).attr("logid");
	   var url = "/log/toreplylog.do?dailylogid="+dailylogid;
	   window.location.href=url;
   }
   function seltask(){
	   var taskid = $("#task").val();
	   if(taskid!=null && taskid!=""){
		   $("#taskstadiv").css("display","block");
	   }else{
		   $("#taskstadiv").css("display","none");
	   }
   }
  </script>
 </head>
<style>
 .whh_tab_bor{padding:20px 0;}
	.whh_sel{ margin-left:360px;}
	.whh_h2 a{ cursor:pointer;}
	.zyh_fangxiang{margin:20px auto;}
	.zyh_boss h1{text-align:center; font-size:16px; color:#333333; display:block; background-color:#59afe4;; line-height:30px; color:#fff;}
	.zyh_boss h1.cor{background-color: #FF7D01;}
	.zyh_name{ width:100%; overflow:hidden;    margin-top: 20px; margin-left: 29px;}
	.zyh_name li{ float:left; margin-right:20px; margin-bottom:20px;width: 55px;}
	.zyh_boss_ren{background-color: #fff; border: #ccc 1px solid; margin-top: 20px; color: #333333;}
	.zyh_caozuo_n{display: inline-block; width: 40px; background-color: #009fe8; color: #fff; cursor: pointer;}
	.zyh_rizhi{ margin-top:20px;}
	.zyh_tarea{width: 99%; min-height:100px; padding:5px;margin-top: -10px;}
	.zyh_select{ width:100%;white-space:nowrap; height:35px;margin-top: -10px;}
	.zyh_p_text{white-space:nowrap; text-overflow:ellipsis; -o-text-overflow:ellipsis; overflow: hidden; }
	
	/*弹框  新增*/
	.zyh_rizhi_tan{position:fixed; left:0; top:0; width:100%; height:100%; background-color:rgba(0,0,0,0.5); z-index:9999; display:none;}
	.zyh_riz_tan{position:absolute; left:50%; top:50%; width:700px; background-color:#fff; margin-left:-350px; height:500px; margin-top:-250px;border-radius: 5px;}
	.zyh_tan_kun{margin:10px; height:430px;}
	.zyh_tan_kun h1{text-align:center; font-size:16px; line-height:40px;}
	.zyh_tan_kun span{text-align:center; display:block; width:100%; font-size:16px; margin-bottom:5px;background-color: #e5e5e5;
    line-height: 30px;border-radius: 3px;}
	.zyh_tan_kun p{text-indent:2em;}
	.zyh_rizhi_btt{width:200px; height:40px; border-radius:3px; margin:0 auto; background-color:#06C; color:#fff; text-align:center; line-height:40px; cursor:pointer;}
    .zyh_rzne{ text-align:center;}
    .zyh_btn_n {width: 50px;line-height: 30px;color: #fff;background-color: #0aa7e6;border: none;border-radius: 5px;margin-left: 8px;cursor: pointer;}
    .zyh_txt {border-radius: 3px;padding-left: 5px;border: #F1F1F1 1px solid;width: 150px;height: 30px;}
    .replylog{display: inline-block; width: 40px;background-color: #FF7E00;color: #fff;}
</style>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="工作信息" class="tip-bottom"><i class="icon-home"></i>工作信息</a>
	     	<a href="" title="工作日志" class="current">工作日志</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5 class="whh_h2"><i class="whh_line fl"></i><a  class="zyh_sz_fx cur">　发表工作日志　</a>|<a class="zyh_bd_rw">　查看工作日志　</a></h5>
          </div>
          <div class="widget-content clearfix">
          		<form name="signupForm" method="post" action="#" id="signupForm" class="form-inline">
            	<div class="zyh_fangxiang" id="log_a" >
		          	<div class="zyh_boss">
		            <div>
		              <h1 class="cor">工作任务内容</h1>
		              	<select class="zyh_select" id="task" onchange="seltask()">
		                	<option value="">无</option>
		                	<c:forEach items="${workTasks }" var="task">
		                		<option value="${task.taskid }">${task.publishcontent }</option>
		                	</c:forEach>
		                </select>
		            </div>
		            <div  class="zyh_rizhi" style="display:none;" id="taskstadiv">
		              <h1>任务进度</h1>
		              	<select class="zyh_select" id="taskstatus">
		                	<option value="0">未完成</option>
		                	<option value="2">处理中</option>
		                	<option value="3">已处理</option>
		                </select>
		            </div>
		            <div class="zyh_rizhi">
		              <h1>工 作 日 志</h1>
		              <c:set var="indeval">0</c:set>
		              <textarea class="zyh_tarea" style="min-height:300px;" id="logcontent"><c:forEach items="${uwxlist}" var="uwx" varStatus="weist"><c:set var="indeval">${indeval+1}</c:set>${fn:trim(indeval)}、微信号：${uwx.weiXin};原来有微信好友人数：      ;今日增加好友数：   ;今日朋友圈动态数：        。&#13;&#10;</c:forEach><c:forEach items="${contlist}" var="condateinfo" varStatus="status"><c:if test="${condateinfo.Memo eq '录入人员信息'}"><c:set var="indeval">${indeval+1}</c:set><c:set var="datestr"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${condateinfo.ContactTime}" /></c:set>${fn:trim(indeval)}、${datestr}--录入人员：${condateinfo.CustomerName}--技术：${fn:trim(condateinfo.TechnicalExpertise)}--毕业院校：${fn:trim(condateinfo.CustomerUniversity)}--入职日期：${fn:trim(condateinfo.EntryTime)}--最近公司：${fn:trim(condateinfo.LastCompanyName)}&#13;&#10;</c:if></c:forEach><c:forEach items="${contlist}" var="condateinfo"><c:if test="${condateinfo.Memo ne '录入人员信息'}"><c:set var="indeval">${indeval+1}</c:set><c:set var="datestr"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${condateinfo.ContactTime}" /></c:set>${fn:trim(indeval)}、${datestr}--跟踪人员：${condateinfo.CustomerName}--技术：${fn:trim(condateinfo.TechnicalExpertise)}--毕业院校：${fn:trim(condateinfo.CustomerUniversity)}--入职日期：${fn:trim(condateinfo.EntryTime)}--最近公司：${fn:trim(condateinfo.LastCompanyName)}--跟踪情况：${fn:trim(condateinfo.Memo)}&#13;&#10;</c:if></c:forEach><c:forEach items="${worklist}" var="workerinfo" varStatus="status"><c:set var="indeval">${indeval+1}</c:set><c:set var="datestr"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${workerinfo.addTime}" /></c:set>${fn:trim(indeval)}、${datestr}--录入人员：${workerinfo.workerName}--电话：${fn:trim(workerinfo.workerPhone)}--年龄：${fn:trim(workerinfo.age)}--籍贯：${fn:trim(workerinfo.origin)}--身份证号：${fn:trim(workerinfo.idCard)}&#13;&#10;</c:forEach><c:forEach items="${adddemandlist}" var="itemt"><c:set var="indeval">${indeval+1}</c:set><c:set var="datestr"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${itemt.Addtime}" /></c:set>${fn:trim(indeval)}、${datestr}--录入需求：${itemt.Projecttype}--客户：${fn:trim(itemt.CorpName)}--地区：${fn:trim(itemt.AreaName)}--技术：${fn:trim(itemt.name)}--级别：${fn:trim(itemt.gradename)}&#13;&#10;</c:forEach><c:forEach items="${follist}" var="itemt"><c:set var="indeval">${indeval+1}</c:set><c:set var="datestr"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${itemt.TrackingTime}" /></c:set><c:set var="folstatus"><c:if test="${itemt.ArrangeEntryStatus==1}">已入项</c:if><c:if test="${itemt.RetestResultStatus==1 || (itemt.InterviewResultStatus==1 && itemt.RetestStatus==0)}">面试通过</c:if>              				<c:if test="${itemt.RetestResultStatus==2 || itemt.InterviewResultStatus==2}">面试未通过</c:if><c:if test="${itemt.NoticeInterviewStatus==1}">已通知面试</c:if><c:if test="${itemt.ScreeningResumesStatus==1}">简历筛选已通过</c:if></c:set>${fn:trim(indeval)}、${datestr}--跟踪需求：${itemt.Projecttype}--简历：${fn:trim(itemt.CustomerName)}--跟踪情况：${fn:trim(itemt.Remark)}--状态：${folstatus}&#13;&#10;
		              		</c:forEach>
		              </textarea>
		            </div>
		            <span style="color:red">注：多个微信请用-分割，例如：weixin1-weixin2</span>
		            <div class="zyh_rizhi">
		              <h1>问 题 建 议</h1>
		              <textarea class="zyh_tarea" id="propose"></textarea>
		            </div>
		            <div class="zyh_rizhi">
		            	<span>是否录入简历：</span>
		               <label class="whh_label"><input type="radio" name="lrjl" value="1" />是</label>
		               <label class="whh_label"><input type="radio" name="lrjl" value="0" checked/>否</label>
		               
		               <table cellspacing="0" cellpadding="0" border="0" class="tab_jianli" id="tab_jianli_id">
		               		<c:forEach items="${resumeSourceList}" var="info" varStatus="status">
		               			<tr class="trclass">
		               				<td><input type="checkbox" name="IsAddFlag" value="${info.resumesourceid}" <c:forEach items="${resumelist}" var="res">
		             						<c:if test="${res.ResumeSourceId==info.resumesourceid && res.coun>0}">checked disabled</c:if></c:forEach>/></td>
				                    <td>${info.resumesourcename}</td>
				                    <td><!-- <input type="text" name="soucecount" class="whh_input input_100" value="0"/> -->
		             						<input type="text" readonly class="whh_input input_100" placeholder="0" <c:forEach items="${resumelist}" var="res">
		             						<c:if test="${res.ResumeSourceId==info.resumesourceid}">value="${res.coun}"</c:if>0
		             						<%-- <c:if test="${res.ResumeSourceId!=info.resumesourceid}">value="0"</c:if> --%></c:forEach> />
				                    </td>
		               			</tr>
			               	</c:forEach>
		               </table>
		            </div>
		            <%-- <div class="whh_tab_bor">
		            	<span>联系信息：</span>
		               <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
			               <thead>
			                  <tr><th>简历名称</th><th>联系内容</th><th>联系时间</th></tr>
			                </thead>
		               		<c:forEach items="${contlist}" var="condateinfo">
		               			<tr class="trclass">
				                    <td>${condateinfo.CustomerName}</td>
				                    <td>${condateinfo.Memo}</td>
				                    <td>
				                    	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${condateinfo.ContactTime}" />
				                    </td>
		               			</tr>
			               	</c:forEach>
		               </table>
		            </div> --%>
		              
		            </div>         
		              <p style="text-align: center;">
		               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="提交" onclick="submitWork();" />
		              </p>
		          </div>
		          
		          
		          
	            <div class="zyh_fangxiang" id="log_b">
		          	<div>
		            	<%-- <span>提交者：</span>
		                <select id="userlist">
		                     <option value="">请选择</option>
		                     <c:forEach items="${users }" var="user">
		                      		<option value="${user.usercode }">${user.realname }</option>
		                     </c:forEach>
		                </select>
		                <span>工作任务</span>
		                	<select>
		                		<option value="">请选择</option>
		                		<option value="">1</option>
		                		<option value="">2</option>
		                	</select> --%>
		                <span>日志时间：</span>
		                <input type="text" class="zyh_txt" name=logdate value="${logdate }"
								id="logdate" readonly="readonly" placeholder="输入时间"
								onclick="WdatePicker()" onblur="$(this).trigger('change')" />
						<input type="button" value="搜索" onclick="search();" class="zyh_btn_n" />
		            </div>
					<div class="whh_tab_bor">
		              <table  class="table table-bordered table-striped with-check">
		              	<colgroup>
			            	<col width="10%"><col width="15%"><col width="34%"><col width="15%">
			            	<col width="6%"><col width="10%"><col width="10%"><col width="10%">
			            </colgroup>
		                <thead>
		                  <tr>
		                     <th>提交者</th><th>工作任务</th><th>日志内容</th><th>问题建议</th>
		                     <th>日期</th><th>简历份数</th><th>回复内容</th><th>操作</th>
		                 </tr>
		                </thead>
		                <tbody>
		                <c:forEach items="${dailyLogs }" var="log">
		                  <tr>
		                   <c:set var="daystr"><fmt:formatDate pattern="yyyy-MM-dd " value="${log.logdate}" /></c:set>
		                   <td><a href="javascript:void(0);" onclick="showuserdaiylog('${log.userid}','${daystr}')">${log.realname }</a></td>
		                   <td><p class="zyh_p_text" style="width: 180px;">${log.publishcontent }</p></td>
		                   <td><p class="zyh_p_text" style="width: 180px;">${log.logcontent }</p></td>
		                   <td><p class="zyh_p_text" style="width: 110px;">${log.propose }</p></td>
		                   <td><fmt:formatDate value="${log.logdate }" type="date" dateStyle="medium" /></td>
		                   <td>
		                   		<c:forEach items="${resc}" var="item">
		                   			<c:if test="${item.dailylogid==log.dailylogid}">
		                   				<c:forEach items="${resumeSourceList}" var="resitem">
		                   					<c:if test="${resitem.resumesourceid==item.resumesourceid}">
		                   						<p class="zyh_p_text">${resitem.resumesourcename}:${item.count}份</p>
		                   					</c:if>
		                   				</c:forEach>
		                   			</c:if>
		                   		</c:forEach>
		                   </td>
		                   <td><p class="zyh_p_text" style="width: 110px;">${log.replycontent}</p></td>
		                   <td>
		                   		<span class="zyh_caozuo_n" logcontent="${log.logcontent }" propose="${log.propose }" value="${log.dailylogid }">查看</span>
		                   		<a href="javascript:void(0);" class="replylog" logid="${log.dailylogid}" onclick="toreplylog(this)">回复</a>
		                   		<c:if test="${log.taskstatus!=4}">
		                   			<a href="javascript:void(0);" class="replylog" logid="${log.dailylogid}" onclick="checkdailylog('${log.dailylogid}')">已检查</a>
		                   		</c:if>
		                   		
		                   </td>
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
	            </form>
            
          </div>
        </div>
  </div>
</div>
   <script>
	$(".zyh_caozuo_n").click(function(){
		var logcontent = $(this).attr("logcontent").trim();
		var propose = $(this).attr("propose").trim();
		$("#rznr").text(logcontent);
		$("#wtjy").text(propose);
		$(".zyh_rizhi_tan").show();
	});
	//弹出一个页面层
	$('.zyh_caozuo_n').on('click', function(){
		var dailylogid = $(this).attr("value");
	    layer.open({
			title:'工作日志',
	        type: 2,
	        area: ['1000px', '650px'],
	        shadeClose: true, //点击遮罩关闭
	        content: "/log/dailyid.do?dailylogid="+dailylogid
	    });
	});
	function showuserdaiylog(userid,logdate){
		layer.open({
			title:'任务进度',
	        type: 2,
	        area: ['1000px', '500px'],
	        shadeClose: true, //点击遮罩关闭
	        content: "/log/showUserDaiyLog.do?userid="+userid+"&logdate="+logdate
	    });
	}
	function checkdailylog(dailylogid){
		var data = {"dailylogid":dailylogid,};
		$.ajax({
			   type: "post",
			   url: "/log/checkdailylog.do",
			   data: data,
			   dataType: "json",
			   success: function(result){
				   alert(result.msg);
			   }
		   });
	}
</script>
 </body>
</html>



