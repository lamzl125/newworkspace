<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head>
 	<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
 	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  	<title>工作任务</title>
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
  	<style>
		.whh_tab_bor{padding: 20px 0;}
		.whh_h2 a{ cursor:pointer;}
		.zyh_fangxiang{margin:20px auto;}
		.zyh_boss{ }
		.zyh_boss h1{text-align:center; font-size:16px; color:#333333; display:block; background-color:#59afe4;; line-height:30px; color:#fff;margin:0;}
		.zyh_name{ width:auto; overflow:hidden; margin-top: 20px; margin-left: 29px;}
		.zyh_name input{vertical-align:middle;margin-right:2px;}
		.zyh_name li{ float:left; margin-right:20px; margin-bottom:20px;width: auto;}
		.zyh_boss_ren{background-color: #fff; border: #ccc 1px solid; margin-top: 20px; color: #333333;}
		.zyh_caozuo_n{display: inline-block; width: 40px; background-color: #009fe8; color: #fff; cursor: pointer;}
    .zyh_txt{border-radius: 3px;padding-left: 5px;border: #F1F1F1 1px solid;width: 90px;height: 30px;font-size: 13px;color: #666;}
 .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
	</style>
 	<script type="text/javascript">
 	$(function(){
 		$(".zyh_fangxiang").eq(1).hide();
		$(".zyh_fangxiang").eq(2).hide();
		
		$(".zyh_sz_fx").click(function(){
			$(".zyh_fangxiang").eq(0).show().siblings(".zyh_fangxiang").hide()
			
		})
		$(".zyh_bd_rw").click(function(){
			$(".zyh_fangxiang").eq(1).show().siblings(".zyh_fangxiang").hide()
			
		})
		
		$(".whh_h2 a").click(function(){
			$(this).addClass("cur").siblings().removeClass("cur");
		})
		var url = window.location.search;
		if(url.indexOf("&") > -1){
			$(".zyh_bd_rw").click();
		}
 	  });
 	
 	function toprevpageInfo(page){
	    var url = "/work/issue.do?page="+(page-1)+"&listflag=list";
		window.location.href=url;
   }
   
   function togetListBypage(page){
	    var url = "/work/issue.do?page="+page+"&listflag=list";
		window.location.href=url;
   }
   
   function tonextpageInfo(page){
	    var url = "/work/issue.do?page="+(page+1)+"&listflag=list";
		window.location.href=url;
   }
   
   function topageInfo(){
	   var topage = $("#topage").val();
	   var url = "/work/issue.do?page="+topage+"&listflag=list";
	   window.location.href=url;
   }
   
   function search(){
	   var appointuserid = $("#userlist option:selected").val();
	   var realname = $("#userlist option:selected").text();
	   var publishtime = $("#publishtime").val();
	   
	   var url = "/work/issue.do?appointuserid="+appointuserid+"&realname="+realname+"&publishtime="+publishtime;
	   window.location.href=url;
   }
   
   // 发布工作任务
   function publish(){
   			var publishid = $("#usercode").val().trim();  // 发布者
   			var publishcontent = $("#workTask").val().trim(); //工作任务内容
   			if(publishcontent == ""){
   				alert("工作任务不能为空!");
   				return;
   			}
   			var userString = $('#users input[name="username"]:checked').val();
   			if(userString == null){
   				alert("请选择指定人员!");
   				return;
   			}
   			var result = userString.split(",");
   			var appointuserid = result[0];  // 指定人员编号
   			var realname = result[1];  //  指定人员名称
   			$.ajax({
   				type: "post",
   				url: "/work/add.do",
   				data: {"publishid":publishid,"publishcontent":publishcontent,"appointuserid":appointuserid,"realname":realname},
   				dataType: "json",
   				success: function(result){
   					if(result.status == 1){
   						alert("添加工作任务成功!");
   						window.location.reload();
   					} else {
   						alert("工作任务发布失败!");	
   					}
   				}
   			});
   		}
   	//  确认完成工作任务
   	function finish(taskid){
   		$.ajax({
				type: "post",
				url: "/work/confirm.do",
				data: {"taskid":taskid},
				dataType: "json",
				success: function(result){
					if(result.status == 1){
						alert("工作任务确认完成!");
						window.location.reload();
					} else {
						alert("工作任务确认失败!");	
					}
				}
			});
   	}
   	
    $(document).ready(function(){
    	initMemu(4,0);
		 $('#uploadFile').uploadify({
			 	'queueID'  : 'some_file_queue',
				'swf' : '/views/resource/js/uploadify.swf',
				'uploader' : '/work/uploadWorkTask.do;jsessionid=<%=session.getId()%>',
				'fileObjName' : 'file',
				'fileSizeLimit' : '3MB',//限制文件大小
	            'auto':true,//选择文件后自动上传
	            'fileTypeDesc' : 'Files',
	            'fileTypeExts' : '*.xls;*.xlsx;',//限制文件格式
//	            'buttonClass':"newUploadbutton",
	            'uploadLimit' : 999,//限制上传文件数量
	            'buttonText':'选择文件',
	            'height':'40px',
	            'onInit': function () {$("#some_file_queue").hide();},//载入时触发，将flash设置到最小
	            'onUploadSuccess' : function(file, data, response) {
	            	var retulst = eval("(" + data + ")");
					alert(retulst.msg);
	            },
	            'onSelectError' : function(file,errorCode,errorMsg){
	            	    var msgText = "上传失败\n";
		     	        switch (errorCode) {
		     	            case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED: msgText += "每次最多上传 " + this.settings.queueSizeLimit + "个文件";break;
		     	            case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT: msgText += "文件大小超过限制( " + this.settings.fileSizeLimit + " )";break;
		     	            case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE: msgText += "文件大小为0";break;
		     	            case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE: msgText += "文件格式不正确，仅限 " + this.settings.fileTypeExts;break;
		     	            default: msgText += "错误代码：" + errorCode + "\n" + errorMsg;
		     	        }
		     	        alert(msgText);
	            },
	            'onUploadError' : function(file, errorCode, errorMsg, errorString){
	            	 // 手工取消不弹出提示
	    	        if (errorCode == SWFUpload.UPLOAD_ERROR.FILE_CANCELLED || errorCode == SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED) {return;}
	    	        var msgText = "上传失败\n";
	    	        switch (errorCode) {
	    	            case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:	 msgText += "HTTP 错误\n" + errorMsg;break;
	    	            case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:   msgText += "上传文件丢失，请重新上传";break;
	    	            case SWFUpload.UPLOAD_ERROR.IO_ERROR:  msgText += "IO错误";break;
	    	            case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:  msgText += "安全性错误\n" + errorMsg;break;
	    	            case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED: msgText += "每次最多上传 " + this.settings.uploadLimit + "个";break;
	    	            case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:msgText += errorMsg;break;
	    	            case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND:   msgText += "找不到指定文件，请重新操作";break;
	    	            case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED: msgText += "参数错误";break;
	    	            default:  msgText += "文件:" + file.name + "\n错误码:" + errorCode + "\n" + errorMsg + "\n" + errorString;
	    	        }
	    	        alert(msgText);
	            },
			});
}) 
  </script>
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="工作信息" class="tip-bottom"><i class="icon-home"></i>工作信息</a>
	     	<a href="" title="工作任务" class="current">工作任务</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5 class="whh_h2"><i class="whh_line fl"></i> <a class="zyh_sz_fx cur" href="javascript:;" onclick="window.open('/views/Moban/20170411workday.xls')">  下载任务模板   </a>|<a  class="zyh_sz_fx cur">　发布工作任务　</a>|<a class="zyh_bd_rw">　任务列表　</a></h5>
          </div>
          <div class="widget-content clearfix">
            	<div class="zyh_fangxiang" id="work_a">
		          	<div class="whh_flie_div">
		                 <input type="file" class="whh_file" name="fileupload" id="uploadFile" value=""/>
		                 <!-- <input id="filepath" name="filepath"  style="display:none;width:400px" value="" readonly class="whh_input whh_texts"/> -->
		                 <span>上传文件</span>
		            </div>
		          	<div class="zyh_boss">
		            <div>
		              <h1>工作任务内容</h1>
		              <textarea style=" width: 99%;  min-height:100px;margin-top:-10px;" id="workTask"></textarea>
		               </div>
		              <div class="zyh_boss_ren">
		              <h1>指定人员</h1>
		              <ul class="zyh_name" id="users">
		              	<c:forEach items="${users }" var="user">
		              		<li><label><input name="username" type="radio" value="${user.usercode },${user.realname }" />${user.realname } </label></li>
		              	</c:forEach>
		              </ul>
		              </div>
		            </div>         
		              <p style="text-align: center;margin-top:20px;">
			               <input type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="发布" onclick="publish();">
		              </p>
		          </div>
	            <div class="zyh_fangxiang" id="work_b">
		          <!-- 搜索start -->
		          	<div>
		            	<span>指定人员：</span>
		                <select id="userlist" class="whh_sel">
		                     <option value="${appointuserid }">${realname }</option>
		                     <c:forEach items="${users }" var="user">
		                      		<option value="${user.usercode }">${user.realname }</option>
		                     </c:forEach>
		                </select>
		                <span>发布时间：</span>
		                <input type="text" class="zyh_txt" name="publishtime" value="${publishtime }"
								id="publishtime" readonly="readonly" placeholder="输入时间"
								onclick="WdatePicker()" onblur="$(this).trigger('change')" />
						<input type="button" value="搜索" onclick="search();" class="zyh_btn" />
		            </div>
		            <!-- 搜索 end -->
					<div class="whh_tab_bor">
		              <table  class="table table-bordered table-striped with-check">
		              	<colgroup>
			            	<col width="25%"><col width="15%"><col width="15%"><col width="15%">
			            	<col width="30%">
			            </colgroup>
		                <thead>
		                  <tr>
		                     <th>工作任务内容</th>
		                     <th>指定完成人员</th>
		                     <th>任务发布时间</th>
		                     <th>完成状态</th>
		                     <th>操作</th>
		                 </tr>
		                </thead>
		                <tbody>
		                <c:forEach items="${workTasks }" var="work">
		                <c:if test="${work.status != 1 }">
		                  <tr>
		                   <td width="200">${work.publishcontent }</td>
		                   <td width="200">${work.realname }</td>
		                   <td><fmt:formatDate value="${work.publishtime }" type="date" dateStyle="medium"/></td>
		                   <td width="100">
		                   		<c:if test="${work.status==0}">未完成</c:if>
		                   		<c:if test="${work.status==2}">处理中 </c:if>
		                   		<c:if test="${work.status==3}">已处理</c:if>
		                   </td>
		                   <td width="100"><span class="zyh_caozuo_n" onclick="finish(${work.taskid});">完成</span></td>
		                  </tr>
		                </c:if>
		                <c:if test="${work.status == 1 }">
		                  <tr>
		                   <td width="200">${work.publishcontent }</td>
		                   <td width="200">${work.realname }</td>
		                   <td><fmt:formatDate value="${work.publishtime }" type="date" dateStyle="medium"/></td>
		                   <td width="100">已完成</td>
		                   <td width="100"><span class="zyh_caozuo_n"></span></td>
		                  </tr>
		                </c:if>
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
  </div>
</div>
</body>
</html> 





