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
 <link rel="stylesheet" href="/views/resource/css/uploadify.css">
<script src="/views/resource/js/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<script src="/views/resource/layer/layer.js"></script>
<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
<style type="text/css">
.whh_tab1 td {
	padding: 10px 0;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".zyh_buxian").click(function(){
		  $(".interinput").hide();
	});
	$(".interinput").click(function(){
		  $(".zyh_buxian").attr("checked",false);
		  $(".zyh_xianze").attr("checked",true);
	});
	$(".zyh_xianze").click(function(){
		  $(".zyh_buxian").attr("checked",false);
		  $(".zyh_xianze").attr("checked",true);
		  $(".interinput").show();
	});
	$("input[name='retesttime']").hide();
	$(":radio[name='retestStatus']").click(function(){
		var raval = $(this).val();
		if(raval==0){
			$("input[name='retesttime']").hide();
		}else if(raval==1){
			$("input[name='retesttime']").show();
		}
		
	});
	
	$("input[name='joinprotime']").hide();
	$(":radio[name='arrangeEntryStatus']").click(function(){
		var raval = $(this).val();
		if(raval==0){
			$("input[name='joinprotime']").hide();
		}else if(raval==1){
			$("input[name='joinprotime']").show();
		}
		
	});
	
	
	
	 $('#uploadFile').uploadify({
		 	'queueID'  : 'some_file_queue',
			'swf' : '/views/resource/js/uploadify.swf',
            'uploader' : "/uploadUtril.do?pathname='followPic'&jsessionid=<%=session.getId()%>",
			'fileObjName' : 'resume',
			'fileSizeLimit' : '3MB',//限制文件大小
           'auto':true,//选择文件后自动上传
           'fileTypeDesc' : 'Image Files',
           'fileTypeExts' : '*.jpg;*.jpeg;*.png;*.gif;*.bmp',//限制文件格式
//            'buttonClass':"newUploadbutton",
           'uploadLimit' : 999,//限制上传文件数量
           'buttonText':'选择文件',
           'height':'40px',
           'onInit': function () {                        //载入时触发，将flash设置到最小
               $("#some_file_queue").hide();
           },
           'onUploadSuccess' : function(file, data, response) {
           	if(data!=""){
           		var reg=/\\|\//g;
//            		$("#idCardFrontView").attr("src", "/"+data.msg.replace(reg,"/")) ;
           		$("#picUrl").val(data.replace(reg,"/"));  
           		$("#picshow").attr('src',"../"+data.replace(reg,"/")); 
           	}else{
           		alert("上传失败");
           	}
           	
           },
           'onSelectError' : function(file,errorCode,errorMsg){
           	    var msgText = "上传失败\n";
	     	        switch (errorCode) {
	     	            case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
	     	                //this.queueData.errorMsg = "每次最多上传 " + this.settings.queueSizeLimit + "个文件";
	     	                msgText += "每次最多上传 " + this.settings.queueSizeLimit + "个文件";
	     	                break;
	     	            case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
	     	                msgText += "文件大小超过限制( " + this.settings.fileSizeLimit + " )";
	     	                break;
	     	            case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
	     	                msgText += "文件大小为0";
	     	                break;
	     	            case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
	     	                msgText += "文件格式不正确，仅限 " + this.settings.fileTypeExts;
	     	                break;
	     	            default:
	     	                msgText += "错误代码：" + errorCode + "\n" + errorMsg;
	     	        }
	     	        alert(msgText);
           },
           'onUploadError' : function(file, errorCode, errorMsg, errorString){
           	 // 手工取消不弹出提示
   	        if (errorCode == SWFUpload.UPLOAD_ERROR.FILE_CANCELLED
   	                || errorCode == SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED) {
   	            return;
   	        }
   	        var msgText = "上传失败\n";
   	        switch (errorCode) {
   	            case SWFUpload.UPLOAD_ERROR.HTTP_ERROR:
   	                msgText += "HTTP 错误\n" + errorMsg;
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:
   	                msgText += "上传文件丢失，请重新上传";
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.IO_ERROR:
   	                msgText += "IO错误";
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:
   	                msgText += "安全性错误\n" + errorMsg;
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:
   	                msgText += "每次最多上传 " + this.settings.uploadLimit + "个";
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:
   	                msgText += errorMsg;
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND:
   	                msgText += "找不到指定文件，请重新操作";
   	                break;
   	            case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:
   	                msgText += "参数错误";
   	                break;
   	            default:
   	                msgText += "文件:" + file.name + "\n错误码:" + errorCode + "\n"
   	                        + errorMsg + "\n" + errorString;
   	        }
   	        alert(msgText);
           },
		});
}) 
function addFollow(){
	var demandresumeId = $("#demandResumeId").val();
	$('#submitbtn').removeAttr('href');//去掉a标签中的href属性
	$('#submitbtn').removeAttr('onclick');//去掉a标签中的onclick事件
	$('#submitbtn').css('background',"#CCCCFF");
	
	$.ajax({
		url : '/demandFollow/saveFollow.do',
		dataType : 'json',
		type : 'post',
		data : $('#followForm').serialize(),
		success : function(result, status) {
			if (result.status == 0) {
				alert(result.msg);
				parent.$("#followPart").load("/demandFollow/followOfResume.do?demandResumeId="+demandresumeId);
				var index = parent.layer.getFrameIndex(window.name); //获取当前窗体索引
		    	parent.layer.close(index); 
			} else {
				alert(result.msg);
			}
		},
		error : function() {
			alert("添加失败！");
		}
	}) 
}
  </script>
</head>
<body>
	<div class="">
	<form method="post" id="followForm">
	    <input type="hidden" id="demandResumeId" name="demandResumeId" value="${demandresumeId}">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
			<tbody>
				<c:if test="${follow==null}">
					<tr>
	                   <td class="whh_right">是否发送客户：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="sendResumeStatus" value="1" checked/>未发客户</label>
		                   		<label class="whh_label"><input type="radio" name="sendResumeStatus" value="2"/>已发客户</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				<c:if test="${follow!=null && follow.retestStatus==0 && follow.interviewResultStatus==1 && (follow.arrangeEntryStatus==0||follow.arrangeEntryStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<input type="hidden" name="noticeInterviewStatus" value="1" />
					<input type="hidden" name="interviewResultStatus" value="1" />
					<input type="hidden" name="retestStatus" value="0" />
					<tr>
	                   <td class="whh_right">是否安排入项：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="arrangeEntryStatus" value="0" checked/>否</label>
		                   		<label class="whh_label"><input type="radio" name="arrangeEntryStatus" value="1"/>是</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				<c:if test="${follow!=null && follow.retestResultStatus==1 && (follow.arrangeEntryStatus==0||follow.arrangeEntryStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<input type="hidden" name="noticeInterviewStatus" value="1" />
					<input type="hidden" name="interviewResultStatus" value="1" />
					<input type="hidden" name="retestStatus" value="1" />
					<input type="hidden" name="retestResultStatus" value="1" />
					<tr>
	                   <td class="whh_right">入项时间：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="arrangeEntryStatus" value="0" checked/>否</label>
		                   		<label class="whh_label">
		                   			<input type="radio" name="arrangeEntryStatus" value="1"/>是
		                   			<input type="text" name="joinprotime" onclick="WdatePicker()" onblur="$(this).trigger('change')"  />
		                   		</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				
				
				
				<c:if test="${follow!=null && follow.retestStatus==1 && (follow.retestResultStatus==0||follow.retestResultStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<input type="hidden" name="noticeInterviewStatus" value="1" />
					<input type="hidden" name="interviewResultStatus" value="1" />
					<input type="hidden" name="retestStatus" value="1" />
					<tr>
	                   <td class="whh_right">复试结果：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="retestResultStatus" value="0" checked/>未参加</label>
		                   		<label class="whh_label"><input type="radio" name="retestResultStatus" value="1"/>已通过</label>
		                   		<label class="whh_label"><input type="radio" name="retestResultStatus" value="2"/>未通过</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				
				
				<c:if test="${follow!=null && follow.interviewResultStatus==1 && (follow.arrangeEntryStatus==0||follow.arrangeEntryStatus==null) && follow.retestStatus==null}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<input type="hidden" name="noticeInterviewStatus" value="1" />
					<input type="hidden" name="interviewResultStatus" value="1" />
					<tr>
	                   <td class="whh_right">是否需要复试：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="retestStatus" value="0" checked/>否</label>
		                   		<label class="whh_label">
		                   			<input type="radio" name="retestStatus" value="1" />是
		                   			<input type="text" name="retesttime" onclick="WdatePicker()" onblur="$(this).trigger('change')"  />
		                   		</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				
				<c:if test="${follow!=null && (follow.retestStatus==0||follow.retestStatus==null) && (follow.retestResultStatus==0||follow.retestResultStatus==null) && follow.noticeInterviewStatus==1 && (follow.interviewResultStatus==0 || follow.interviewResultStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<input type="hidden" name="noticeInterviewStatus" value="1" />
					
					<tr>
	                   <td class="whh_right">面试结果：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="interviewResultStatus" value="0" checked/>未参加</label>
		                   		<label class="whh_label"><input type="radio" name="interviewResultStatus" value="1"/>已通过</label>
		                   		<label class="whh_label"><input type="radio" name="interviewResultStatus" value="2"/>未通过</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				<c:if test="${follow!=null && follow.screeningResumesStatus==1 && (follow.noticeInterviewStatus==0||follow.noticeInterviewStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<input type="hidden" name="screeningResumesStatus" value="1" />
					<tr>
                   		<td class="whh_right">面试时间：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" class="zyh_buxian" name="noticeInterviewStatus" value="0" checked />待定</label>
		                   		<label class="whh_label">
		                   			<input type="radio" name="noticeInterviewStatus" value="1" class="zyh_xianze" />确定
		                   			<input type="text" class="interinput" name="interviewtime" onclick="WdatePicker()" onblur="$(this).trigger('change')"  />
		                   		</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				<c:if test="${follow!=null && follow.sendResumeStatus==2 && (follow.screeningResumesStatus==0||follow.screeningResumesStatus==null)}">
					<input type="hidden" name="sendResumeStatus" value="2" />
					<tr>
	                   <td class="whh_right">简历是否通过筛选：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="screeningResumesStatus" value="0" checked/>未通过</label>
		                   		<label class="whh_label"><input type="radio" name="screeningResumesStatus" value="1"/>已通过</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				<c:if test="${follow!=null && follow.sendResumeStatus==1}">
					<tr>
	                   <td class="whh_right">是否发送客户：</td>
	                   <td>
		                   <div class="whh_position">
		                   		<label class="whh_label"><input type="radio" name="sendResumeStatus" value="1" checked/>未发客户</label>
		                   		<label class="whh_label"><input type="radio" name="sendResumeStatus" value="2"/>已发客户</label>
		                   </div>
	                   </td>
	                 </tr>
				</c:if>
				
				<!-- 
                 <tr>
                   <td class="whh_right">截图：</td>
                   <td>
                      <div class="whh_flie_div">
                        <input type="file" class="whh_file" name="resumeupload" id="uploadFile" value=""/>
                        <span>上传图片</span>
                      </div>
                   </td>
                 </tr>  
                  <tr>
                   <td class="whh_right"></td>
                   <td>
                      <div >
                       <input id="picUrl" name="picUrl" type="hidden" style="display:none;width:400px" value="" class="whh_input whh_texts"/>
                        <img src="" id="picshow" height="200" width="200" align="middle"></img>
                      </div>
                   </td>
                 </tr>-->
                 <tr>
                   <td class="whh_right">备注：</td>
                   <td colspan="2" >
                   		<textarea style="width:95%;" rows="3" cols="" name="remark"></textarea>
                   </td>
                 </tr>
			</tbody>
		</table>
		</form>
		<p style="text-align: center;">
			<a href="javascript:void(0)"
				class="whh_btn whh_btn_big mt20 whh_btn_big_or" id="submitbtn" onclick="addFollow()">确定</a>
		</p>
	</div>


</body>
</html>