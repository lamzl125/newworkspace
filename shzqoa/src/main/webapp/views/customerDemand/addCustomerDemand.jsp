<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>添加客户需求</title>
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
<link rel="stylesheet" href="/views/common/css/uploadify.css">
<link rel="stylesheet" href="/views/common/css/combo.select.css">
<link rel="stylesheet" href="/views/common/css/otherstyle.css">


<script src="/views/common/js/jquery.min.js"></script>
<script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/common/js/initMenu.js" type="text/javascript"></script>
<script src="/views/common/js/bootstrap.min.js"></script>
<script src="/views/common/js/matrix.js"></script>
<script src="/views/common/js/my97/WdatePicker.js"
	type="text/javascript"></script>
<script src="/views/common/js/jquery.uploadify.min.js"></script>
<script src="/views/common/js/jquery.combo.select.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	initMemu(1,2);
	$('select[name="corpcode"]').comboSelect();
	$('select[name="technologydirection"]').comboSelect();
	$('select[name="projectlocation"]').comboSelect();
	$('select[name="demandyears"]').comboSelect();
	$('select[name="importantlevel"]').comboSelect();
	$('select[name="industry"]').comboSelect();
	
	  $(".zyh_buxian").click(function(){
	  $(".xuqiu").toggle();
	  });
 });
$("#submitform").click(function(){
	 $("#submitform").disabled= "disabled";
	  return true;
 });
$(function (){
	 $("#demandForm").validate({
	      rules: {
	    	  corpcode:{
	    		  required: true
	    	  },
	    	  technologydirection:{
	    		  required: true
	    	  },
	    	  projectlocation:{
	    		  required:true
	    	  },
	    	  demandyears:{
	    		  required: true
	    	  },
	    	  education:{
	    		  required: true
	    	  },
	    	  demandnumber:{
	    		  required:true
	    	  },
	    	  projecttype:{
	    		  required: true
	    	  },
	    	  specificrequirement:{
	    		  required: true
	    	  },
	    	  address:{
	    		  required: true
	    	  },
	    	  importantlevel:{
	    		  required: true
	    	  },
	    	  industry:{
			       required: true
			  },
			  technicalRequirement:{
			       required: true
			  },
			  directWorkLife:{
			       required: true
			  }
	      },
	      messages: {
	    	  corpcode: {
	              required: "请选择客户公司！"
	            },
	            technologydirection:{
	              required: "请选择技术方向！"
		    	},
		    	projectlocation:{
		    	  required:"请选择项目地点！"
		    	},
		    	demandyears: {
		          required: "请填写需求年限！"
		        },
		        education:{
		           required: "请填写学历要求！"
			    },
			    demandnumber:{
			       required:"请填写需求人数！"
			    },
			    projecttype: {
			       required: "请填写需求名称！"
			    },
			    specificrequirement:{
			       required: "请填写具体要求！"
				},
			    address:{
			       required: "请填写具体地址！"
				},
				importantlevel:{
			       required: "请选择重要级别！"
				},
				industry:{
			       required: "请选择行业！"
				},
				technicalRequirement:{
			       required: "请选择技术类型！"
				},
				directWorkLife:{
			       required: "请填写工作年限要求！"
				}
	      },
	      submitHandler : function(){
	    	  var data = $('#demandForm').serialize();
	    	  $.ajax({
	    		  url:'/customerDemand/saveCustomerDemand.do',
	    		  dataType:'json',
	    		  type:'post',
	    		  data:data,
	    		  success:function(result,status){
	    			  if(result.status==0){
	    					 alert(result.msg);
	    					 sessionStorage.clear();//清空缓存
	    					 document.getElementById('demandForm').reset();//清空表单临时数据
	    				      window.location="/customerDemand/addCustomerDemand.do";
	    				 }else{
	    					 alert(result.msg);
	    				 }
	    		  },
	    	     error:function(){
	    	    	 alert("添加失败！");
	    	     }
	    	  })
	      }
	 })
});

function modifyarea(){
	var earacode = $("select[name='projectlocation']").val();
	if(earacode!=null && earacode!=''){
		var earaname = $("select[name='projectlocation'] option:selected").text();
		$("input[name='projecttype']").val(earaname+"-");
	}else{
		$("input[name='projecttype']").val("");
	}
}
</script>
</head>
<body>
	<jsp:include page="/views/common/Top.jsp"></jsp:include>
	<jsp:include page="/views/common/Left.jsp"></jsp:include>
	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index.html" title="待招人员" class="tip-bottom"><i class="icon-home"></i>待招人员</a> 
				<a href="" title="录入需求" class="current">录入需求</a>
			</div>
		</div>
		<div class="container-fluid">
			<div class="widget-box">
				<div class="widget-title">
					<span class="icon"> <i class="icon-th"></i></span>
					<h5>录入需求</h5>
				</div>
				<div class="widget-content clearfix">
					<form name="demandForm" method="post" id="demandForm" class="form-inline">
						<div class="whh_content whh_content_border">
							<div class="whh_tab_bor">
								<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
									<tbody>
										<tr>
											<td width="20%" class="whh_right"><span class="xing">*</span>选择客户：</td>
											<td width="30%">
												<select class="whh_sel" name="corpcode">
													<option selected value="">请选择客户</option>
													<c:forEach items="${corpList}" var="corp">
														<option value='${corp.corpcode}'>${corp.corpname}</option>
													</c:forEach>
												</select>
											</td>
											<td width="20%" class="whh_right"><span class="xing">*</span>技术方向：</td>
											<td width="30%"><select class="whh_sel" name="technologydirection">
													<option selected value="">请选择技术</option>
													<c:forEach items="${professList}" var="info">
														<option value='${info.id}'>${info.name}</option>
													</c:forEach>
											</select></td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>项目地点：</td>
											<td><select class="whh_sel" name="projectlocation" onchange="modifyarea()">
													<option selected value="">请选择区域</option>
													<c:forEach items="${areaList}" var="area">
														<option value='${area.areaid}'>${area.areaname}</option>
													</c:forEach>
											</select></td>
											<td class="whh_right"><span class="xing">*</span>级别：</td>
											<td><select class="whh_sel" name="demandyears">
													<option selected value="">请选择级别</option>
													<c:forEach items="${gradList}" var="info">
														<option value='${info.id}'>${info.gradename}</option>
													</c:forEach>
											</select></td>
										</tr>

										<tr>
											<td class="whh_right"><span class="xing">*</span>学历要求：</td>
											<td><input type="text" name="education" class="whh_input" placeholder="请输入学历" /></td>
											<td class="whh_right"><span class="xing">*</span>需求人数：</td>
											<td>
												<label class="whh_label"> <input type="text" name="demandnumber" class="whh_input xuqiu" onkeyup='this.value=this.value.replace(/\D/gi,"")' placeholder="请输入人数或选择不限" style="width: 160px;" /></label> 
												<label><input type="checkbox" value="不限" class="zyh_buxian">不限</label>
											</td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>需求名称：</td>
											<td><input type="text" name="projecttype" class="whh_input" placeholder="请输入类型" /></td>
											<td class="whh_right"><span class="xing">*</span>重要级别：</td>
											<td>
												<select class="whh_sel" name="importantlevel">
													<option selected value="">请选择级别</option>
													<c:forEach items="${imporList}" var="important">
														<option value="${important.id}">${important.name}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>具体要求：</td>
											<td>
												<textarea rows="12" style="width: 300px; max-width: 300px; border: 1px solid #a7b6c4; border-radius: 3px;" name="specificrequirement"></textarea>
											</td>
											<td class="whh_right"><span class="xing">*</span>详细地址：</td>
											<td>
												<textarea rows="12" style="width: 300px; max-width: 300px; border: 1px solid #a7b6c4; border-radius: 3px;" name="address"></textarea>
											</td>
										</tr>
										<tr>
											<td class="whh_right">备注其他：</td>
											<td>
												<textarea rows="6" style="width: 300px; max-width: 300px; border: 1px solid #a7b6c4; border-radius: 3px;" name="remarks"></textarea>
											</td>
											<td class="whh_right"><span class="xing">*</span>行业：</td>
											<td>
												<select class="whh_sel" name="industry">
													<option selected value="">请选择行业</option>
													<c:forEach items="${proindlist}" var="important">
														<option value="${important.id}">${important.name}</option>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<td class="whh_right"><span class="xing">*</span>技术类型：</td>
											<td colspan="3">
												<c:forEach items="${tectypelist}" var="info">
													<div style="float:left;width:150px;">
					                   					<input type="checkbox" name="technicalRequirement" value="${info.id}" />${info.name}
					                   				</div>
						                   		</c:forEach>
											</td>
										</tr>
										<tr>
											<td class="whh_right">工作年限要求：</td>
											<td>
												<input type="text" name="directWorkLife" class="whh_input"  />
											</td>
										</tr>
									</tbody>
								</table>

								<p style="text-align: center;">
									<input id="submitform" type="submit" class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存" />
								</p>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>