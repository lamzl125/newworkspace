<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>费用结算凭证</title>
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
<link rel="stylesheet" href="/views/common/css/uploadify.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
  <script src="/views/common/js/jquery.uploadify.min.js"></script>
  
  
  <script type="text/javascript">
   $(document).ready(function(){
			 $('#voucherupload').uploadify({
				 	'queueID'  : 'some_file_queue',
					'swf' : '/views/resource/js/uploadify.swf',
					'uploader' : '/uploadVoucher.do;jsessionid=<%=session.getId()%>',
					'fileObjName' : 'voucher',
					'fileSizeLimit' : '3MB',//限制文件大小
		            'auto':true,//选择文件后自动上传
		            'fileTypeDesc' : 'Image Files',
		            'fileTypeExts' : '*.bmp;*.jpg;*.tiff;*.gif;*.pcx:*.tga;*.exif;*.fpx;*.svg;*.psd;*.cdr;*.pcd;*.dxf;*.ufo;*.eps;*.ai;*.raw;',//限制文件格式
// 		            'buttonClass':"newUploadbutton",
		            'uploadLimit' : 999,//限制上传文件数量
		            'buttonText':'选择文件',
		            'height':'40px',
		            'onInit': function () {                        //载入时触发，将flash设置到最小
		                $("#some_file_queue").hide();
		            },
		            'onUploadSuccess' : function(file, data, response) {
		            	if(data!=""){
		            		var reg=/\\|\//g;
		            		$("#voucherpic").attr("src", data.replace(reg,"/")) ;
		            		$("#voucherpath").val(data.replace(reg,"/"));  
		            		$("#voucherpath").show();
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
  $(function (){
      jQuery.validator.methods.isTel = function(value, element) { 
    	  var length = value.length; 
    	  var mobile = /^1[3|4|5|7|8]\d{9}$/;
    	  var tel = /^\d{3,4}-\d{7,9}$/; 
    	  return this.optional(element) || (tel.test(value) || mobile.test(value)); 
      }; 
     $("#payForm").validate({
      rules: {
    	  realityCost: {
          required: true
        },
        voucherpath: {
          required: true
        }
      },
      messages: {
    	  realityCost: {
          required: "请输入电话"
        },
        voucherpath: {
          required: "请上传凭证"
        }, 
      },
      submitHandler : function(){
    	  $.ajax({
    		  url:'/addCustomercompany.do',
    		  dataType:'json',
    		  type:'post',
    		  data:$('#payForm').serialize(),
    		  success:function(result,status){
    			  if(result==1){
    					 alert("结算完成！");
    					 window.location="/company/initPage.do"; 
    				 }else{
    					 alert("结算失败！");
    				 }
    		  },
    	     error:function(){
    	    	 alert("添加失败！");
    	     }
    	  })
      }
    })
   });
  $(document).ready(function(){
	  initMemu(3,1);
  })
  </script>
  <style>
  .uploadify-button{border:none !important;}
  .whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  </style>
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<input type="hidden" name="corpName" value="${corpName}">
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="服务费核算" class="tip-bottom"><i class="icon-home"></i>服务费核算</a>
	    	<a href="index.html" title="服务费用结算" class="tip-bottom"><i class="icon-home"></i>服务费用结算</a>
	     	<a href="" title="费用结算凭证" class="current">费用结算凭证</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>费用结算凭证</h5>
          </div>
          <div class="widget-content clearfix">
          	<form name="payForm" method="post" id="payForm">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>结算月份：</td>
                   <td><input type="text" class="whh_input" name="settlementMonth"　readonly value="${settlementMonth}"/></td>
                 </tr>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>所需支付费用：</td>
                   <td><input type="text" class="whh_input" name="predictCost"　readonly value="${servicePayCount}"/></td>
                 </tr>
                 <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>实际支付费用：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入支付费用" name="realityCost" /></td>
                 </tr>
                <tr>
                   <td class="whh_right"><span class="xing">*</span>凭证图片：</td>
                   <td>
                      <div class="whh_flie_div">
                        <input type="file" class="whh_file" name="voucherupload" id="voucherupload" value=""/>
                        <input type="hidden" id="voucherpath" name="voucherpath"  style="display:none;width:400px" value=""/>
                        <span>上传文件</span>
                      </div>
                   </td>
                 </tr>
                 <tr>
                     <td></td>
                     <td><img id="voucherpic" name="voucherpic" alt="" src="">
                     </td>
                 </tr>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>备注说明：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入支付费用" name="explain" /></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="submit" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="提交"></p>
            </form>
          </div>
        </div>
  </div>
</div>














   <div class="whh_wraper">
   <form name="payForm" method="post" id="payForm">
       <input type="hidden" name="corpName" value="${corpName}">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>费用结算凭证</span></h2>
          <div class="whh_tab_bor">
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
                <tbody>
                <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>结算月份：</td>
                   <td><input type="text" class="whh_input" name="settlementMonth"　readonly value="${settlementMonth}"/></td>
                 </tr>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>所需支付费用：</td>
                   <td><input type="text" class="whh_input" name="predictCost"　readonly value="${servicePayCount}"/></td>
                 </tr>
                 <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>实际支付费用：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入支付费用" name="realityCost" /></td>
                 </tr>
                <tr>
                   <td class="whh_right"><span class="xing">*</span>凭证图片：</td>
                   <td>
                      <div class="whh_flie_div">
                        <input type="file" class="whh_file" name="voucherupload" id="voucherupload" value=""/>
                        <input type="hidden" id="voucherpath" name="voucherpath"  style="display:none;width:400px" value=""/>
                        <span>上传文件</span>
                      </div>
                   </td>
                 </tr>
                 <tr>
                     <td></td>
                     <td><img id="voucherpic" name="voucherpic" alt="" src="">
                     </td>
                 </tr>
                  <tr>
                   <td width="40%" class="whh_right"><span class="xing">*</span>备注说明：</td>
                   <td><input type="text" class="whh_input" placeholder="请输入支付费用" name="explain" /></td>
                 </tr>
                </tbody>
              </table>
              <p style="text-align: center;">
               <input type="submit" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="提交"></p>
          </div>

       </div>
   </form>
   </div>
 </body>
</html>