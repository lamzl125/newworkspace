<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>需求模版</title>
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
<link rel="stylesheet" href="/views/common/css/uploadify.css">
		
  <script src="/views/common/js/jquery.min.js"	type="text/javascript"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script>
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.uploadify.min.js"></script>
  <style type="text/css">
	.whh_tab_bor{padding-top:20px;}
	.whh_position{position:relative;width:600px;}
    #customersex-error,#relationshipbyzq-error{position:absolute;right:0;top:0;}
    .uploadify-button{border:none !important;}
    .newUploadbutton{display: block;float: left;position: relative;height: 25px;width: 80px;margin: -10px 10px 18px 0;text-decoration: none;font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;font-weight: bold;line-height: 25px;text-align: center;}
	.whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
	span.xing{color: #e14c4d;display: inline-block;margin-right: 3px;}
	.whh_table tbody tr{height:56px;}
	.whh_right{text-align: right;padding-right: 15px;}
	.blspan{height:40px;margin-top:24px;}
	#SWFUpload_0{margin-top:-10px;height: 26px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(1,3);
	  $('#uploadFile').uploadify({
		 	'queueID'  : 'some_file_queue',
			'swf' : '/views/resource/js/uploadify.swf',
			'uploader' : "/uploadfilebypathtype.do?pathname=detl&filetype=detl&jsessionid=<%=session.getId()%>",
			'fileObjName' : 'resume',
			'fileSizeLimit' : '3MB',//限制文件大小
          'auto':true,//选择文件后自动上传
          'fileTypeDesc' : 'Image Files',
          'fileTypeExts' : '*.doc;*.docx;*.txt;*.pdf',//限制文件格式
           'buttonClass':"newUploadbutton",
          'uploadLimit' : 999,//限制上传文件数量
          'buttonText':'选择文件',
          'height':'40px',
          'onInit': function () {                        //载入时触发，将flash设置到最小
              $("#some_file_queue").hide();
          },
          'onUploadSuccess' : function(file, data, response) {
          	if(data!=""){
          		var reg=/\\|\//g;
          		$("#templatepath").val(data.replace(reg,"/"));  
          		$("#templatepath").show();
          	}else{
          		alert("上传失败");
          	}
          	
          },
          'onSelectError' : function(file,errorCode,errorMsg){
          	    var msgText = "上传失败\n";
	     	        switch (errorCode) {
	     	            case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:  msgText += "每次最多上传 " + this.settings.queueSizeLimit + "个文件"; break;
	     	            case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT: msgText += "文件大小超过限制( " + this.settings.fileSizeLimit + " )"; break;
	     	            case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE: msgText += "文件大小为0";	 break;
	     	            case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE: msgText += "文件格式不正确，仅限 " + this.settings.fileTypeExts; break;
	     	            default:  msgText += "错误代码：" + errorCode + "\n" + errorMsg;
	     	        }
	     	        alert(msgText);
          },
          'onUploadError' : function(file, errorCode, errorMsg, errorString){
          	 // 手工取消不弹出提示
  	        if (errorCode == SWFUpload.UPLOAD_ERROR.FILE_CANCELLED  || errorCode == SWFUpload.UPLOAD_ERROR.UPLOAD_STOPPED) {
  	            return;
  	        }
  	        var msgText = "上传失败\n";
  	        switch (errorCode) {
  	            case SWFUpload.UPLOAD_ERROR.HTTP_ERROR: msgText += "HTTP 错误\n" + errorMsg; break;
  	            case SWFUpload.UPLOAD_ERROR.MISSING_UPLOAD_URL:  msgText += "上传文件丢失，请重新上传"; break;
  	            case SWFUpload.UPLOAD_ERROR.IO_ERROR: msgText += "IO错误"; break;
  	            case SWFUpload.UPLOAD_ERROR.SECURITY_ERROR:  msgText += "安全性错误\n" + errorMsg; break;
  	            case SWFUpload.UPLOAD_ERROR.UPLOAD_LIMIT_EXCEEDED:  msgText += "每次最多上传 " + this.settings.uploadLimit + "个";   break;
  	            case SWFUpload.UPLOAD_ERROR.UPLOAD_FAILED:msgText += errorMsg;  break;
  	            case SWFUpload.UPLOAD_ERROR.SPECIFIED_FILE_ID_NOT_FOUND:  msgText += "找不到指定文件，请重新操作"; break;
  	            case SWFUpload.UPLOAD_ERROR.FILE_VALIDATION_FAILED:msgText += "参数错误";  break;
  	            default:  msgText += "文件:" + file.name + "\n错误码:" + errorCode + "\n"   + errorMsg + "\n" + errorString;
  	        }
  	        alert(msgText);
          },
		});
  })
  function adddemandtel(){
	  var addtepname = $("#addtepname").val().trim();
	  var templatepath = $("#templatepath").val().trim();
	  if(addtepname == null || addtepname == ''){
		  alert("模版名称不能为空");
		  return false;
	  }
	  if(templatepath == null || templatepath == ''){
		  alert("模版文件不能为空");
		  return false;
	  }
	  var data = { "templateName": addtepname, "templateFile":templatepath, }
	  $.ajax({
          type: "post",
          url: "/template/saveDemandTemplate.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
  }
  function togetListBypage(page){
  	var url = "/areas/toAddAreas.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/areas/toAddAreas.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/areas/toAddAreas.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/areas/toAddAreas.do?page="+topage;
  	window.location.href=url;
  }
  function delAreaById(areaId){
		if (confirm("确定要删除么?"))  {
			$.ajax({
		          type: "post",
		          url: "/areas/delAreasById.do",
		          data: {"areaid":areaId},
		          dataType: "json",
		          success: function(result){
		         	 if(result.status == 0){
		         		 alert(result.msg);
		         		 parent.location.reload();
		         	 }else{
		         		 alert(result.msg);
		         	 }
		          }
		      });
		}
  }
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>

<div id="content">
<input type="hidden" class="zyh_txt whh_input" id="demandId" value="${demandId}">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="需求分配" class="current">需求分配</a>
    </div>
  </div>
    <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>需求分配</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th>
                  <th>模版名称</th>
                  <th>模版顺序</th>
                  <th>模版状态</th>
                  <th width="13%">操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有模版信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
		                   <td>${item.TemplateName}</td>
		                   <td>${item.TemplateOrder}</td>
		                   <td>${item.TemplateStatus}</td>
		                   <td><a class="delButClass" href="javascript:void(0);" onclick="delAreaById('${item.TemplateId}')">删除</a></td>
	                 </tr>
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
          </div>
          <div class="whh_tab_bor">
          		<div class="span11">
          			 <div class="span1 blspan">
			          	<span>模版名称:</span>
			          </div>
			          <div class="span9 blspan">
				            <input type='text' class='span4 mab0 thisinput' value='' id="addtepname"/>
		                </div>
			          <div class="span1 blspan">
			          	<span>模    版:</span>
			          </div>
			          	<div class="span8 blspan">
				            <div class="whh_flie_div">
				                 <input type="file" class="whh_file" name="temload" id="uploadFile" value=""/>
				                 <input id="templatepath" name="templatepath"  style="display:None;position: relative;width:500px;left:0;" value="" readonly class="whh_input whh_texts"/>
			                </div>
		                </div>
		                
				</div>
				<p style="text-align: center;">
               		<input id="submitform" type="button" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" onclick="adddemandtel()" value="保存">
               </p>
          </div>
        </div>
  </div>
</div>

 </body>
</html>