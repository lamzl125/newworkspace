<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.util.*"%>
<%@page import="com.shzqoa.model.Rights"%>
<!DOCTYPE html>
<html>
	<head> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>录入员工信息</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta charset="utf-8" />
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
		<link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
		<link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
		<link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link rel="stylesheet" href="/views/common/css/zyh_style.css" />
		<link rel="stylesheet" href="/views/common/css/uploadify.css">
		<link rel="stylesheet" href="/views/common/css/combo.select.css">
		<link rel="stylesheet" href="/views/common/css/otherstyle.css">
		<style>
		    .whh_position{position:relative;width:600px;}
		    #customersex-error,#relationshipbyzq-error{position:absolute;right:0;top:0;}
		    .uploadify-button{border:none !important;}
		    .newUploadbutton{display: block;float: left;position: relative;height: 25px;width: 80px;margin: 0 10px 18px 0;text-decoration: none;font: 12px "Helvetica Neue", Helvetica, Arial, sans-serif;font-weight: bold;line-height: 25px;text-align: center;}
  			.whh_texts{position:absolute;left:105px;top:0;z-index:1;height:28px;}
  			span.xing{color: #e14c4d;display: inline-block;margin-right: 3px;}
  			.whh_table tbody tr{height:56px;}
  			.whh_right{text-align: right;padding-right: 15px;}
  			.jq22 { width: 400px; margin: 100px auto;}
  			.threed{
  				position:relative;
  				top:554px;
				color: #EE9A49;
				letter-spacing: 0;
				text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135 
			}
			.titleclass{
				color: #EE9A49;
				font-size:26px;
				padding-left:80px;
				text-decoration:underline;
			}
			
	    </style>
		<script src="/views/common/js/jquery.min.js" ></script>
		<script src="/views/common/js/jquery.validate.js"></script>
		<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
		
		<script src="/views/common/js/bootstrap.min.js"></script> 
		<script src="/views/common/js/matrix.js"></script> 
		<script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
		<script src="/views/common/js/jquery.uploadify.min.js"></script>
		<script src="/views/common/js/jquery.combo.select.js"></script>
		<script type="text/javascript">
		   $(document).ready(function(){
		   		 changeOption(); 
		   		$('select[name="areaid"]').comboSelect();
		   		$('select[name="professionId"]').comboSelect();
		   		$('select[name="resumesource"]').comboSelect();
		   		$('select[name="account"]').comboSelect();
		   		$('select[name="education"]').comboSelect();
		   		$('select[name="englishLevel"]').comboSelect();
		   		$('select[name="japaneseLevel"]').comboSelect();
// 		   		$('select[name="proindustry"]').comboSelect();
// 		   		$('select[name="prorole"]').comboSelect();
		   		
				<%--  $('#uploadFile').uploadify({
					 	'queueID'  : 'some_file_queue',
						'swf' : '/views/resource/js/uploadify.swf',
						'uploader' : '/uploadResume.do;jsessionid=<%=session.getId()%>',
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
//	 		            		$("#idCardFrontView").attr("src", "/"+data.msg.replace(reg,"/")) ;
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
					}); --%>
	  });
	  $(function (){
		  //存放缓存，提交表单之后并清空
		  if(window.sessionStorage){
			  $('input').each(function(){
				  var name = $(this).attr('name');
				  var val = sessionStorage.getItem(name);
				  if(val){
					  if($(this).attr('type') == 'radio'){
						  $('input[name='+name+'][value='+val+']').trigger('click');
					  }else{
						  $(this).val(val);
					  }
				  }
			  });
			  $("select").each(function(){
				  var name = $(this).attr('name');
				  if(name!=null && name !=''){
					  var val = sessionStorage.getItem(name);
					  if(val){
					 	 $(this).val(val);
					  }
					  var selname = "";
					  $(this).parent().find(".combo-dropdown li").each(function(){
						  var lival = $(this).attr("data-value");
						  if(val == lival){
							  $(this).addClass("option-selected");
							  selname = $(this).html();
						  }
					  });
					  $(this).parent().find("input[class='combo-input text-input']").val(selname);
				  }
				  changeOption();
		      });
			  $("input").change(function(){
		    	  var name =$(this).attr('name');
		    	  var value = $(this).val();
		    	  sessionStorage.setItem(name,value);
		      });
		      $("select").change(function(){
		    	  var name =$(this).attr('name');
		    	  var value = $(this).val();
		    	  sessionStorage.setItem(name,value);
		      });
		  }else{
			  alert('您的浏览器不支持缓存，请升级至最新版。');
		  }
		  $("#submitform").click(function(){
			 $("#submitform").disabled= "disabled";
			  return true;
		  });
		  //
		  jQuery.validator.methods.compareDate = function(value, element) { 
	          var curDate = new Date();
	          var date = new Date(Date.parse(value)); 
	          return value==null || value=='' || date< curDate; 
	      } 
	      jQuery.validator.methods.isTel = function(value, element) { 
	    	  var length = value.length; 
	    	  var mobile = /^1[3|4|5|7|8]\d{9}$/;
	    	  var tel = /^\d{3,4}-\d{7,9}$/; 
	    	  return this.optional(element) || (tel.test(value) || mobile.test(value)); 
	      } 
	     $("#signupForm").validate({
	      rules: {
	    	customername: {
	          required: true
	        },
	        customersex: {
	        	required : true
	        },
	        areaid:{
	        	required : true
	        },
	        customertel: {
	          required: true,
	          isTel:true
	        },
	        customerbirth: {
	          required: true,
	          compareDate:true
	        },
	        resumeupdatedate: {
	          required: true,
	          compareDate:true
	        },
	        customeruniversity: {
	          required: true
	        },
	        customerspecialities: {
	          required: true
	        },
	        entrytime: {
	          compareDate:true
	        },
	        resumesource: {
	          required: true
	        },
	        resumeid: {
	          required: true
	        },
	        account:{
	          required: true
	        }, 
	        account:{
	        	required: true
	        },
	        education: {
	        	required: true
	        },
	        englishLevel: {
	        	required: true
	        },
	        japaneseLevel: {
	        	required: true
	        },
	        directWorkLife: {
	        	required: true
	        }
	        /* 
	        zqentrytime: {
	          compareDate:true
	        },  
	        relationshipbyzq :{
	        	required : true
	        },
	        taskid:{
	    		  required:true
	    	},
	        lastprojectname:{
	        	required: true
	        },
	        lastvcompanyname:{
	        	required: true
	        },
	        resumepath: {
	          required: true
	        }, 
			gzsj: {
	          required: true
	        },
	        technicalexpertise: {
		          required: true
		    },
		    expectationSalary:{
	        	required : true
	        }
		    */
	        
	      },
	      messages: {
	    	customername: {
	          required: "请输入姓名"
	        },
	        customersex: {
	        	required : "请选择人员性别"
	        },
	        areaid:{
	        	required : "请选择区域"
	        },
	        customertel: {
	          required: "请输入电话",
	          isTel:"输入电话格式不正确"
	        },
	        customerbirth: {
	          required: "请输入出生日期",
	          compareDate:"出生日期不能超过当前时间"
	        },
	        resumeupdatedate: {
	          required: "请输入简历更新日期",
	          compareDate:"简历更新日期不能超过当前时间"
	        },
	        customeruniversity: {
	          required: "请输入毕业院校"
	        },
	        customerspecialities: {
	          required: "请输入所学专业"
	        },
	        entrytime: {
	          compareDate:"参加工作日期不能超过当前时间"
	        },
	        resumesource: {
	          required: "请输入简历出处"
	        },
	        resumeid: {
	          required: "请输入简历ID"
	        },
	        account:{
	        	required: "请选择录入账号"
	        }, 
	        account: {
	           required: "请输入录入账户"
	        },
	        education: {
	        	required: "请选择学历"
	        },
	        englishLevel: {
	        	required: "请选择英语水平"
	        },
	        japaneseLevel: {
	        	required: "请选择日语水平"
	        },
	        directWorkLife: {
	        	required: "请输入该技术方向的工作年限"
	        }
	        /* 
	        zqentrytime: {
	          compareDate:"本公司入职时间不能超过当前时间"
	        }, 
	        relationshipbyzq :{
	        	required : "请选择与梓钦的关系"
	        },
	        taskid:{
		  		  required:"请选择任务"
		  	}, 
		  	lastvcompanyname: {
		        required: "请输入最近公司名称"
		      },
		      lastprojectname: {
		        required: "请输入最近项目名称"
		      }, 
		      resumepath: {
		        required: "请输入简历路径"
		      },
				gzsj: {
		        required: "请输入参加工作时间"
		      },
		      technicalexpertise: {
		        required: "请输入技术特长"
		      },
		      expectationSalary :{
		      	required : "请填写期望薪资"
		      }
		  	*/
	      },
	      submitHandler : function(){
	    	  var pros = [];
	    	  $(".templatepro0").each(function(m){
	    		  var proinfo ={};
	    		  var industry = $(this).find("select[name='industry']").val();
	    		  var projectName = $(this).find("input[name='projectName']").val();
	    		  var role = $(this).find("select[name='role']").val();
	    		  var joinProjectTime = $(this).find("input[name='joinProjectTime']").val();	    		  
	    		  var quitProjectTime = $(this).find("input[name='quitProjectTime']").val();
	    		  var softwareEnvironment="";
	    		  $(this).find(":checkbox[name='softwareEnvironment']:checked").each(function(){
						softwareEnvironment += this.value+",";
				  });
	    		  var technologyType="";
	    		  $(this).find(":checkbox[name='technologyType']:checked").each(function(){
	    			  technologyType += this.value+",";
				  });	    		  
	    		  var duty = $(this).find("textarea[name='duty']").val();
	    		  var projectIntroduction = $(this).find("textarea[name='projectIntroduction']").val();
	    		  proinfo.industry = industry;
	    		  proinfo.projectName = projectName;
	    		  proinfo.role = role;
	    		  proinfo.joinProjectTime = joinProjectTime;
	    		  proinfo.quitProjectTime = quitProjectTime;
	    		  proinfo.softwareEnvironment = softwareEnvironment;
	    		  proinfo.technologyType = technologyType;
	    		  proinfo.duty = duty;
	    		  proinfo.projectIntroduction = projectIntroduction;
	    		  pros.push(proinfo);
	    	  });
	    	  var data = $("#signupForm").serialize()+"&prolist="+JSON.stringify(pros);
	    	$.ajax({
	    		  url:'/saveCustomerInfo.do',
	    		  dataType:'json',
	    		  type:'post',
	    		  data:data,
	    		  success:function(result,status){
	    			  if(result.status==0){
	    					 alert(result.msg);
	    					 sessionStorage.clear();//清空缓存
	    					 document.getElementById('signupForm').reset();//清空表单临时数据
	    				 }else{
	    					 alert(result.msg);
	    				 }
	    		  },
	    	     error:function(){
	    	    	 alert("添加失败！");
	    	     }
	    	  });
	      }
	    })
	   });
	  $(document).ready(function(){
		  initMemu(1,0);
	  });
	  function changeOption(){
		 var newarea = $("select[name=areaid]").val().trim(); 
		 var newresume = $("select[name=resumesource]").val().trim();
		 var html = "";
		 var drophtml = "";
		 var text = "";
		 $("#allaccountList option").each(function(){
			 var opval = $(this).val();
			 var earcount = $(this).text().substring(0,$(this).text().indexOf('-'));
			 var leng = $(this).text().length;
			 var resumecount = $(this).text().substring($(this).text().lastIndexOf('-')+1,leng);
			 var count = 1;
			 if((earcount == newarea||earcount=="QGArea")&& resumecount == newresume){
				 html += this.outerHTML;
				 drophtml += "<li class='option-item' data-index='"+count+"' data-value='"+opval+"'>"+$(this).text()+"</li>"
				 count += 1;
			 }
		  });
		 $("select[name=account]").empty().append(html);
		 $("select[name=account]").parent().find(".combo-dropdown").append(drophtml);
		 $('select[name="account"]').comboSelect();
		 
	  }
	  var procount = 0;
	  function addpro(){
		  var ele = $("#templatepro0").clone();
		  ele.removeAttr("id");
		  ele.find(".addpro").css("display","none");  
		  ele.find(".delpro").css("display","block");
		  $("#projy").append(ele);
		  $(".whh_tab_bor p").css("margin-top");
		  procount += 1;
	  }
	  function delpro(obj){
		  $(obj).parents(".templatepro0").remove();
	  }
	</script>
</head>
<body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
<select id="allaccountList" style="display:none;">
	<c:forEach items="${accountList}" var="item">
    		<option value="${item.aid}">${item.accountCity}-${item.account}-${item.resumesourceid}</option>
    </c:forEach>
</select>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> 
    	<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a>
     	<a href="" title="录入员工信息" class="current">录入员工信息</a>
    </div>
  </div>

  <div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>录入员工信息</h5>
          </div>
          <div class="widget-content clearfix">
          		 <form name="signupForm" method="post" id="signupForm" class="form-inline">
			       <div class="whh_content whh_content_border">
			          <div class="whh_tab_bor">
			              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
			                <tbody>
			                  <tr>
			                   <td width="20%" class="whh_right"><span class="xing">*</span>姓名：</td>
			                   <td width="30%"><input type="text" class="whh_input" placeholder="请输入姓名" name="customername" /></td>
			                   <td width="20%" class="whh_right"><span class="xing">*</span>性别：</td>
			                   <td width="30%">
				                   <div>
					                   <label  class="checkbox-inline"><input type="radio" name="customersex" value="0"/>男	</label>
					                   <label  class="checkbox-inline"><input type="radio" name="customersex" value="1"/>女	</label>
				                   </div>
			                   </td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>所在区域：</td>
			                   <td>
			                       <select name="areaid" onchange="changeOption()">
			                          <option value="">请选择区域</option>
			                          <c:forEach items="${areaList}" var="area">
			                           <option value='${area.areaid}'>${area.areaname}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                   <td class="whh_right"><span class="xing">*</span>技术方向：</td>
			                   <td>
			                       <select name="professionId" >
			                          <option value="">请选择技术方向</option>
			                          <c:forEach items="${professList}" var="proinfo">
			                           <option value='${proinfo.id}'>${proinfo.name}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                 </tr>
			                 
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>电话：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入电话" name="customertel"  onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" /></td>
			                   <td class="whh_right"><span class="xing">*</span>出生日期：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入出生日期" name="customerbirth" id="customerbirth" onclick="WdatePicker()" onblur="$(this).trigger('change')"/></td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>简历更新日期：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入简历更新日期" name="resumeupdatedate" onclick="WdatePicker()" onblur="$(this).trigger('change')"/></td>
			                   <td class="whh_right"><span class="xing">*</span>毕业院校：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入毕业院校" name="customeruniversity" /></td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>所学专业：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入所学专业" name="customerspecialities" /></td>
			                   <td class="whh_right">参加工作日期：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入参加工作日期" name="entrytime" onclick="WdatePicker()" readonly/></td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>简历出处：</td>
			                   <td>
			                       <select name="resumesource"  onchange="changeOption()">
			                          <option value="">请选择出处</option>
			                          <c:forEach items="${resumeSourceList}" var="info">
			                          		<option value="${info.resumesourceid}">${info.resumesourcename}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                   <td class="whh_right"><span class="xing">*</span>录入账号：</td>
			                   <td>
			                       <select name="account">
			                          <option value="">请选择录入账号</option>
			                          <c:forEach items="${accountList}" var="item">
			                          		<option value="${item.aid}">${item.account}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>简历ID：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入简历ID" name="resumeid" /></td>
			                   <td class="whh_right">期望薪资：</td>
			                   <td><input type="text" class="whh_input" placeholder="请输入期望薪资" name="expectationSalary" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" /></td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>学历：</td>
			                   <td>
			                       <select name="education">
			                          <option value="0">请选择学历</option>
			                          <c:forEach items="${educationlist}" var="info">
			                           <option value='${info.id}'>${info.name}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                   <td class="whh_right"><span class="xing">*</span>英语水平：</td>
			                   <td>
			                       <select name="englishLevel">
			                          <option value="0">请选择</option>
			                          <c:forEach items="${enlevellist}" var="info">
			                           <option value='${info.id}'>${info.name}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>日语水平：</td>
			                   <td>
			                       <select name="japaneseLevel">
			                          <option value="0">请选择</option>
			                          <c:forEach items="${japlevellist}" var="info">
			                           <option value='${info.id}'>${info.name}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                   <td class="whh_right">技术方向工作年限：</td>
			                   <td><input type="text" class="whh_input" name="directWorkLife" onkeyup="(this.v=function(){this.value=this.value.replace(/[^\d.]/g,'');}).call(this)" onblur="this.v();" /></td>
			                 </tr>
			                 
			                 
			                <!-- 
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>简历路径：</td>
			                   <td>
			                      <div class="whh_flie_div">
			                        <input type="file" class="whh_file" name="resumeupload" id="uploadFile" value=""/>
			                        <input id="resumepath" name="resumepath"  style="display:none;position: relative;width:500px;left:0;" value="" readonly class="whh_input whh_texts"/>
			                        <span>上传文件</span>
			                      </div>
			                   </td>
			                 </tr> 
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>与梓钦关系：</td>
			                   <td>
			                   <div class="whh_position" style="width:510px;"><label class="whh_label"><input type="radio" name="relationshipbyzq" value="1" />已离职</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzq" value="2" />在职</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzq" value="3" />提交简历未通过</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzq" value="4" />待入职</label>
			                    <label class="whh_label"><input type="radio" name="relationshipbyzq" value="5" />无关系</label></div>
			                    </td>
			                 </tr>
			                <tr>
			                   <td class="whh_right"><span class="xing">*</span>技术特长：</td>
			                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入技术特长" name="technicalexpertise" /></td>
			                 </tr>
			                <tr>
			                   <td class="whh_right"><span class="xing">*</span>最近公司名称：</td>
			                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入最近公司名称" name="lastvcompanyname" /></td>
			                 </tr>
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>最近项目名称：</td>
			                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入最近项目名称" name="lastprojectname" /></td>
			                 </tr> 
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>绑定任务：</td>
			                   <td>
			                       <select class="whh_sel" name="taskid">
			                          <option selected value="">请选择任务</option>
			                          <c:forEach items="${taskList}" var="task">
			                           <option value='${task.id}'>${task.name}+${task.AreaName}+${task.gradename}</option>
			                          </c:forEach>
			                       </select>
			                   </td>
			                 </tr>
			                <tr>
			                   <td class="whh_right"><span class="xing">*</span>与郑州公司关系：</td>
			                   <td><label class="whh_label"><input type="radio" name="relationshipbyzh" value="1" checked />已离职</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzh" value="2" />在职</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzh" value="3" />提交简历未通过</label>
			                   <label class="whh_label"><input type="radio" name="relationshipbyzh" value="4" />待入职</label>
			                    <label class="whh_label"><input type="radio" name="relationshipbyzh" value="5" />无关系</label></td>
			                 </tr> 
			                 <tr>
			                   <td class="whh_right"><span class="xing">*</span>参加工作时间：</td>
			                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入参加工作时间" name="gzsj" onclick="WdatePicker()" readonly/></td>
			                 </tr>
		                	<tr>
			                   <td class="whh_right">本公司入职时间：</td>
			                   <td><label class="whh_label"><input type="text" class="whh_input" placeholder="请输入本公司入职时间" name="zqentrytime" onclick="WdatePicker()" readonly/></td>
			                 </tr> -->
			                </tbody>
			              </table>
			              
			              <div class="titleclass">项目经验</div>
			              <div id="projy">
				                 <div class="templatepro0" id="templatepro0">
				                 	<div class="addpro"><a href="javascript:void(0)" onclick="addpro()">+</a></div>
				                 	<div class="delpro"><a href="javascript:void(0)" onclick="delpro(this)">-</a></div>
				                 	<div class="temre">
				                 		<label>项目行业：</label>
				                 		<select name="industry">
					                          <option value="0">请选择</option>
					                          <c:forEach items="${proindlist}" var="info">
					                           <option value='${info.id}'>${info.name}</option>
					                          </c:forEach>
					                    </select>
					                 </div>
				                   	
					                 <div class="temre">
					                    <label>项目名称：</label>
				                 		<input type="text" class="whh_input" name="projectName"  />
				                 	</div>
				                 	<div class="temre">
				                 		<label class="lableclass">角色：</label>
				                 		<select name="role">
				                          <option value="0">请选择</option>
				                          <c:forEach items="${prorolelist}" var="info">
				                           <option value='${info.id}'>${info.name}</option>
				                          </c:forEach>
				                        </select>
				                     </div>
				                     <div class="temre">
				                 		<label>项目开始日期：</label>
				                 		<input type="text" class="whh_input" name="joinProjectTime" onclick="WdatePicker()" onblur="$(this).trigger('change')"/>
				                 	</div>
				                 	<div class="temre">	
				                 		<label>项目结束日期：</label>
				                 		<input type="text" class="whh_input" name="quitProjectTime" onclick="WdatePicker()" onblur="$(this).trigger('change')"/>
				                 	</div>
				                 	<div class="alltemre">
				                 		<label>软件环境：</label>
				                 		<c:forEach items="${softenvlist}" var="info">
			                   				<input type="checkbox" name="softwareEnvironment" value="${info.id}" />${info.name}
				                   		</c:forEach>
				                   	</div>
				                   	
				                   	<div class="alltemre">
				                   		<label>项目介绍：</label>
				                 		<textarea rows="6" style="width:82%;" name="projectIntroduction"></textarea>
				                 	</div>
				                 	<div class="alltemre">	
				                 		<label>技术类型：</label>
				                 		<c:forEach items="${tectypelist}" var="info">
			                   				<input type="checkbox" name="technologyType" value="${info.id}" />${info.name}
				                   		</c:forEach>
				                   	</div>	
				                   	<div class="alltemre">	
				                   		<label>职责：</label>
				                 		<textarea rows="6" style="width:82%;" name="duty"></textarea>
				                 	</div>
				                 </div>
			                 </div>
			              <p style="text-align:center;">
			               <input id="submitform" type="submit" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" /></p>
			          </div>
			       </div>
			   </form>
          </div>
        </div>
  </div>
</div>
</body>
</html>