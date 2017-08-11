<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>设置人员基数</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link href="/views/common/css/lanren.css" type="text/css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/views/common/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/views/common/css/matrix-style.css" />
<!-- 主体样式 -->
<link rel="stylesheet" href="/views/common/css/matrix-media.css" />
<!-- 侧边栏的补充样式 -->
<link href="/views/common/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
<link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
<link href="/views/common/css/bootstrap-table-fixed-columns.css"
	rel="stylesheet" />
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js"></script>
<script src="/views/common/js/bootstrap-table.js"></script>
<script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/my97/WdatePicker.js"
	type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script>
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/layer-v2.3/layer/layer.js"></script>
<script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script type="text/javascript">
   $(function(){
	   initMemu(5,3);
/*	   $(".zyh_cz_box").hide()
	   $(".zyh_cz_wrod").click(function(){
		$(".whh_table").hide();
		$(".zyh_cz_box").show();  
		})
		$(".zyh_xg_wrod").click(function(){
			$(".whh_table").show();
			$(".zyh_cz_box").hide();	
		})
		
*/
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
	    var listflag = $("#listflag").val();
	    if(listflag=='list'){
	    	$(".zyh_bd_rw").click();
	    }
   })
 
  </script>
</head>
<style>
.uploadify-button {
	border: none !important;
}

.whh_texts {
	position: absolute;
	left: 105px;
	top: 0;
	z-index: 1;
	height: 28px;
}

.whh_h2 a {
	cursor: pointer;
}

.zyh_fangxiang {
	margin: -5px auto;
}

.zyh_boss h1 {
	text-align: center;
	font-size: 16px;
	color: #333333;
	display: block;
	background-color: #59afe4;;
	line-height: 30px;
	color: #fff;
}

.zyh_name {
	width: 100%;
	overflow: hidden;
	margin-top: 20px;
	margin-left: 29px;
}

.zyh_name li {
	float: left;
	margin-right: 20px;
	margin-bottom: 20px;
	width: 55px;
}

.zyh_boss_ren {
	background-color: #fff;
	border: #ccc 1px solid;
	margin-top: 20px;
	color: #333333;
}

.zyh_caozuo_n {
	display: inline-block;
	width: 40px;
	background-color: #009fe8;
	color: #fff;
	cursor: pointer;
}

.zh_edit {
	display: inline-block;
	width: 40px;
	background-color: #0aa7e6;
	color: #fff;
}

.zh_delete:hover {
	color: #fff;
	background: #AB0000;
}

.zh_edit:hover {
	color: #fff;
	background: #0278A7;
}

.zh_delete {
	display: inline-block;
	width: 40px;
	background-color: #f53636;
	color: #fff;
}

.save_btn:active {
	background: #F53636;
}

.zyh_btn_jx {
	width: 80px;
	height: 30px;
	color: #fff;
	background-color: #0aa7e6;
	border: none;
	border-radius: 5px;
	margin-left: 5px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	 $('#uploadFile').uploadify({
		 	'queueID'  : 'some_file_queue',
			'swf' : '/views/resource/js/uploadify.swf',
			'uploader' : '/uploadResume.do;jsessionid=<%=session.getId()%>',
			'fileObjName' : 'resume',
			'fileSizeLimit' : '3MB',//限制文件大小
           'auto':true,//选择文件后自动上传
           'fileTypeDesc' : 'Image Files',
           'fileTypeExts' : '*.doc;*.docx;*.txt;*.pdf',//限制文件格式
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
           		$("#resumepath").val(data.replace(reg,"/"));  
           		$("#resumepath").show();
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
function addInf(){
	debugger; 
	  var id = $("#id").val().trim();
	  var addCustomerCode = $("#addCustomerCode").val().trim();//选择人员
	  var addIdleSalary = $("#addIdleSalary").val().trim();//闲置薪资
	  var addRegularSalary = $("#addRegularSalary").val().trim();//转正后工资
	  var addProbationarySalary = $("#addProbationarySalary").val().trim();//试用工资
	  var addInsuranceCost = $("#addInsuranceCost").val().trim();//保险
	  var idleSocialSecurity=$("#idleSocialSecurity").val().trim();//闲置社保
	  var idleSubsidy=$("#idleSubsidy").val().trim(); //闲置补助
	  var probationaryStartDate=$("#ProbationaryStartDate").val().trim();//试用期开始时间
	  var probationaryEndDate=$("#ProbationaryEndDate").val().trim();//试用期结束时间
	  var regularSocialSecurity=$("#RegularSocialSecurity").val().trim();//转正后社保
	  var regularSubsidy=$("#RegularSubsidy").val().trim();//转正后补助
	  var contractStartDate=$("#ContractStartDate").val().trim();//签订合同开始时间
	  var contractEndDate=$("#ContractEndDate").val().trim();//签订合同结束时间
	  var fileAddr=$("#resumepath").val().trim();//合同
	  var probationarySubsidy=$("#probationarySubsidy").val().trim();
	  if(addCustomerCode == null || addCustomerCode == ''){
		  alert("必须选择一个人员");
		  return false;
	  }
	  if(addIdleSalary == null || addIdleSalary == ''){
		  alert("闲置工资不能为空");
		  return false;
	  }else{
		  if(isNaN(addIdleSalary)){
			  alert("闲置工资必须为数字");
			  return false;
		  }else{
			  if(addIdleSalary<=0){
				  alert("闲置工资必须大于零");
				  return false;
			  }
		  }
	  }
	  if(probationarySubsidy == null || probationarySubsidy == ''){
		  alert("试用期补助不能为空");
		  return false;
	  }else{
		  if(isNaN(probationarySubsidy)){
			  alert("试用期补助必须为数字");
			  return false;
		  }else{
			  if(probationarySubsidy<0){
				  alert("试用期补助不能小于零");
				  return false;
			  }
		  }
	  }
	  
	  
	  
	  
	  if(addProbationarySalary == null || addProbationarySalary == ''){
		  alert("试用期工资不能为空");
		  return false;
	  }else{
		  if(isNaN(addProbationarySalary)){
			  alert("试用期工资必须为数字");
			  return false;
		  }else{
			  if(addProbationarySalary<=0){
				  alert("试用期工资必须大于零");
				  return false;
			  }
		  }
	  }
	  if(addRegularSalary == null || addRegularSalary == ''){
		  alert("项目工资不能为空");
		  return false;
	  }else{
		  if(isNaN(addRegularSalary)){
			  alert("项目工资必须为数字");
			  return false;
		  }else{
			  if(addRegularSalary<=0){
				  alert("项目工资必须大于零");
				  return false;
			  }
		  }
	  }
	  if(addInsuranceCost == null || addInsuranceCost == ''){
		  alert("保险费用不能为空");
		  return false;
	  }else{
		  if(isNaN(addInsuranceCost)){
			  alert("保险费用必须为数字");
			  return false;
		  }else{
			  if(addInsuranceCost<0){
				  alert("保险费用必须大于零");
				  return false;
			  }
		  }
	  }
	  var data = {
			 "id": id,
			 "addCustomerCode": addCustomerCode,
			 "addIdleSalary": addIdleSalary,
			 "addRegularSalary": addRegularSalary,
			 "addProbationarySalary": addProbationarySalary,
			 "addInsuranceCost": addInsuranceCost,
			 "idleSocialSecurity": idleSocialSecurity,
			 "idleSubsidy": idleSubsidy,
			 "probationaryStartDate": probationaryStartDate,
			 "probationaryEndDate": probationaryEndDate,
			 "regularSocialSecurity": regularSocialSecurity,
			 "regularSubsidy": regularSubsidy,
			 "contractStartDate": contractStartDate,
			 "contractEndDate": contractEndDate,
			 "fileAddr": fileAddr,
			 "probationarySubsidy":probationarySubsidy
	  }
	  $.ajax({
        type: "post",
        url: "/salary/saveSalarySet.do",
        data: data,
        dataType: "json",
        success: function(result){
       	 if(/* result.status == 0 */1==1){
       		 alert(result.msg);
       		 parent.location.reload();
       	 }else{
       		 alert(result.msg);
       	 }
        }
    });
}
function toEditRight(id){
	var url = "/salary/salaryListSet.do?id="+id;
  	window.location.href=url;
 }
function delInfoById(id){
	  $.ajax({
        type: "post",
        url: "/salary/delSalarySetById.do?listflag=list",
        data: {"id":id,},
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
function searchByCon(){
	  var searchcustomercode = $("#searchcustomercode").val().trim();
	  var searchstatus = $("#searchstatus").val().trim();
	  var url = "/salary/salaryListSet.do?searchcustomercode="+searchcustomercode+"&searchstatus="+searchstatus+"&listflag=list";
	  window.location.href=url;
}
function togetListBypage(page){
  	var url = "/salary/salaryListSet.do?page="+page+"&listflag=list";
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/salary/salaryListSet.do?page="+(page+1)+"&listflag=list";
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/salary/salaryListSet.do?page="+(page-1)+"&listflag=list";
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/salary/salaryListSet.do?page="+topage+"&listflag=list";
  	window.location.href=url;
  }
  function getSalary(){
	  var url = "/salary/salaryList.do";
	  	window.location.href=url;
  }
  function hideselect(){
		$("#addCustomerCode").css("display","none"); 
		$("#customerName").css("display","block"); 
	}
  function showselect(obj){
		var textval = $(obj).val();
		$("#addCustomerCode option").each(function(){
			var optext = $(this).text();
			if(optext.indexOf(textval)==-1){
				$(this).css("display","none");
			}else{
				$(this).css("display","block");
			}
		});
		$("#addCustomerCode").css("display","block"); 
		$("#customerName").css("display","none"); 
	}
</script>
<body>

	<input type="hidden" id="listflag" value=${listflag}>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="" title="考勤管理" class="tip-bottom"><i class="icon-home"></i>考勤管理</a>
				<a href="" title="人员工资信息" class="current">人员工资信息</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i>
					</span>
					<h5>
						<i class="whh_line fl"></i><a class="zyh_sz_fx cur"> 设置人员基数 </a>|<a
							class="zyh_bd_rw"> 修改人员基数 </a>
					</h5>
				</div>
				<div class="widget-content clearfix">
					<input type="hidden" class="whh_input" id="id"
						<c:if test="${info!=null}">value=${info.id}</c:if>>

					<form name="signupForm" method="post" action="#" id="signupForm">
						<div class="zyh_fangxiang">
							<div class="whh_tab_bor" style="padding: 20px 0;">
								<input type="hidden" class="whh_input" id="id"
									<c:if test="${info!=null}">value=${info.id}</c:if>>
								<table cellpadding="0" cellspacing="0" border="0" width="100%"
									class="whh_table">
									<tbody>
										<tr>
											<td class="whh_right"><span class="xing">*</span>选择人员：</td>
											<td><input type="text" class="whh_input"
												id="customerName" name="customerName" onfocus="hideselect()"
												onblur="showselect(this)"
												<c:forEach var="item" items="${custList}"><c:if test="${item.customercode eq info.customercode}">value="${item.customername}"</c:if></c:forEach> />
												<select class="whh_sel" name="jlcc" id="addCustomerCode"
												style="display: none;" ondblclick="hideselect()"
												<c:if test="${info!=null}">disabled</c:if>>
													<option value="">请选择</option>
													<c:forEach var="item" begin="0" items="${custList}"
														varStatus="status">
														<option value="${item.customercode}"
															<c:if test="${item.customercode eq info.customercode}">selected</c:if>>${item.customername}</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>闲置工资：</td>
											<td><label class="whh_label"><input type="text"
													id="addIdleSalary" class="whh_input" placeholder="请输入闲置工资"
													<c:if test="${info!=null}">value=${info.idlesalary}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>闲置社保：</td>
											<td><label class="whh_label"><input type="text"
													id="idleSocialSecurity" class="whh_input"
													placeholder="请输入闲置社保"
													<c:if test="${info!=null}">value=${info.idlesocialsecurity}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>闲置补助：</td>
											<td><label class="whh_label"><input type="text"
													id="idleSubsidy" class="whh_input" placeholder="请输入闲置补助"
													<c:if test="${info!=null}">value=${info.idlesubsidy}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>试用期开始时间：</td>
											<td><label class="whh_label"><input type="text"
													class="whh_input" placeholder="请输入开始时间"
													name="ProbationaryStartDate" id="ProbationaryStartDate"
													onclick="WdatePicker()" onblur="$(this).trigger('change')"
													value="<fmt:formatDate pattern='yyyy-MM-dd' value='${info.probationarystartdate}' />" /></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>试用期结束时间：</td>
											<td><label class="whh_label"><input type="text"
													class="whh_input" placeholder="请输入结束时间"
													name="ProbationaryEndDate" id="ProbationaryEndDate"
													onclick="WdatePicker()" onblur="$(this).trigger('change')"
													value="<fmt:formatDate pattern='yyyy-MM-dd' value='${info.probationaryenddate}' />" /></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>试用期补助：</td>
											<td><label class="whh_label"><input type="text"
													id="probationarySubsidy" class="whh_input"
													placeholder="请输入试用期补助"
													<c:if test="${info!=null}">value=${info.probationarySubsidy}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>试用工资：</td>
											<td><label class="whh_label"><input type="text"
													id="addProbationarySalary" class="whh_input"
													placeholder="请输入试用工资"
													<c:if test="${info!=null}">value=${info.probationarysalary}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>转正后工资：</td>
											<td><label class="whh_label"><input type="text"
													id="addRegularSalary" class="whh_input"
													placeholder="请输入转正后工资"
													<c:if test="${info!=null}">value=${info.regularsalary}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>转正后社保：</td>
											<td><label class="whh_label"><input type="text"
													id="RegularSocialSecurity" class="whh_input"
													placeholder="请输入转正社保"
													<c:if test="${info!=null}">value=${info.regularsocialsecurity}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>转正后补助：</td>
											<td><label class="whh_label"><input type="text"
													id="RegularSubsidy" class="whh_input" placeholder="转正后补助"
													<c:if test="${info!=null}">value=${info.regularsubsidy}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>保险：</td>
											<td><label class="whh_label"><input type="text"
													id="addInsuranceCost" class="whh_input" placeholder="请输入保险"
													<c:if test="${info!=null}">value=${info.insurancecost}</c:if>></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>签订合同开始时间：</td>
											<td><label class="whh_label"><input type="text"
													class="whh_input" placeholder="请输入开始时间"
													name="ContractStartDate" id="ContractStartDate"
													onclick="WdatePicker()" onblur="$(this).trigger('change')"
													value="<fmt:formatDate pattern='yyyy-MM-dd' value='${info.contractstartdate}' />" /></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>签订合同结束时间：</td>
											<td><label class="whh_label"><input type="text"
													class="whh_input" placeholder="请输入结束时间"
													name="ContractEndDate" id="ContractEndDate"
													onclick="WdatePicker()" onblur="$(this).trigger('change')"
													value="<fmt:formatDate pattern='yyyy-MM-dd' value='${info.contractenddate}' />" /></td>
										</tr>
										<!-- <tr>
		                   <td class="whh_right"><span class="xing">*</span>简历路径：</td>
		                   <td>
		                      <div class="whh_flie_div">
		                        <input type="file" class="whh_file" name="resumeupload" id="uploadFile" value=""/>
		                        <input id="resumepath" name="resumepath"  style="display:none;width:400px" value="" readonly class="whh_input whh_texts"/>
		                        <span>上传文件</span>
		                      </div>
		                   </td>  </tr> -->
										<tr>
											<td class="whh_right"><span class="xing">*</span>合同：</td>
											<td>
												<div class="whh_flie_div">
													<input type="file" class="whh_file" name="resumeupload"
														id="uploadFile" value="" /> <input id="resumepath"
														name="resumepath" style="display: none; width: 400px"
														value="" readonly class="whh_input whh_texts" /> <span>上传文件</span>
												</div>
											</td>
										</tr>
										<!-- *</span>合同：</td>
		                   <td>
		                      <div class="whh_flie_div">
		                        <input type="file" class="whh_file" name="resumeupload" id="uploadFile" value=""/>
		                        <input id="resumepath" name="resumepath"  style="display:none;width:400px" value="" readonly class="whh_input whh_texts"/>
		                        <span>上传文件</span>
		                      </div>
		                   </td> -->
									</tbody>
								</table>
								<p style="text-align: center;">
									<input type="button"
										class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存"
										onclick="addInf()">
								</p>
							</div>
						</div>

						<div class="zyh_fangxiang">
							<div class="whh_tab_bor" style="padding: 20px 0;">
								<div class="zyh_sos">
									<span class="zyh_k_heigth">人员姓名：</span> <select class="whh_sel"
										id="searchcustomercode">
										<option value="">请选择</option>
										<c:forEach items="${custList}" var="item">
											<option
												<c:if test="${searchcustomercode==item.customercode}">selected</c:if>
												value='${item.customercode}'>${item.customername}</option>
										</c:forEach>
									</select> <span class="zyh_k_heigth">状态：</span> <select class="whh_sel"
										id="searchstatus">
										<option value=-1>请选择</option>
										<option <c:if test="${searchstatus==0}">selected</c:if>
											value=0>未使用</option>
										<option <c:if test="${searchstatus==1}">selected</c:if>
											value=1>使用中</option>
									</select> <input type="button" class="zyh_btn_jx" value="查询"
										onclick="searchByCon()"> <input type="button"
										class="zyh_btn_jx" value="计算工资" onclick="getSalary()"
										style="float: right">
								</div>
								<table class="table table-bordered table-striped with-check">
									<colgroup>
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
										<col width="10%" />
									</colgroup>
									<thead>
										<tr>
											<th>人员</th>
											<th>闲置工资</th>
											<th>试用工资</th>
											<th>项目工资</th>
											<th>转正后社保</th>
											<th>转正后补助</th>
											<th>保险</th>
											<th>状态</th>
											<th>操作人</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="zh_body">
										<c:forEach var="item" begin="0" items="${list}"
											varStatus="status">
											<tr>
												<td><c:forEach var="cusitem" begin="0"
														items="${custList}" varStatus="status">
														<c:if test="${item.customercode eq cusitem.customercode}">
															<a
																href="/customerDatailInfo/toCustomerDatailInfo.do?customercode=${cusitem.customercode}">${cusitem.customername}</a>
														</c:if>
													</c:forEach></td>
												<td>${item.idlesalary}</td>
												<td>${item.probationarysalary}</td>
												<td>${item.regularsalary}</td>

												<td>${item.regularsocialsecurity}</td>
												<td>${item.regularsubsidy}</td>

												<td>${item.insurancecost}</td>
												<td><c:choose>
														<c:when test="${item.status==1}">
			                   				使用中
			                   			</c:when>
														<c:when test="${item.status==0}">
			                   				未使用
			                   			</c:when>
													</c:choose></td>
												<td><c:forEach items="${userlist}" var="user">
														<c:if test="${cc.addpeople==user.usercode}">${user.realname} </c:if>
													</c:forEach></td>
												<td><a href="javascript:void(0)" class="zh_edit"
													onclick="toEditRight('${item.id}')">修改</a> <a
													href="javascript:void(0)" class="zh_delete"
													onclick="delInfoById('${item.id}')">删除</a></td>
											</tr>
										</c:forEach>

									</tbody>
								</table>
								<!--分页-->
								<div class="pagination alternate page_fr">
									<ul>
										<li
											<c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a
											href="javascript:void(0)"
											onclick="toprevpageInfo(${currpage})">Prev</a></li>
										<li class="active"><a href="javascript:void(0);"
											onclick="togetListBypage(${currpage})">${currpage}</a></li>
										<c:if test="${tatalpage>=(currpage+1)}">
											<li><a href="javascript:void(0)"
												onclick="togetListBypage(${currpage+1})">${currpage+1}</a></li>
										</c:if>
										<c:if test="${tatalpage>=(currpage+2)}">
											<li><a href="javascript:void(0)"
												onclick="togetListBypage(${currpage+2})">${currpage+2}</a></li>
										</c:if>
										<c:if test="${tatalpage>=(currpage+3)}">
											<li><a href="javascript:void(0)"
												onclick="togetListBypage(${currpage+3})">${currpage+3}</a></li>
										</c:if>
										<li><a href="javascript:void(0)"
											onclick="tonextpageInfo(${currpage})">Next</a></li>
									</ul>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>