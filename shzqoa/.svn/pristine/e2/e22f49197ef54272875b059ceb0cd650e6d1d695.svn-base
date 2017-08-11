<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>录入考勤信息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/css/uploadify.css">
<script src="/views/resource/js/jquery-1.11.1.js" type="text/javascript"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script src="/views/resource/js/jquery.validate.js"></script>

<script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
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

.whh_tab_bor {
	width: 560px;
	padding: 20px;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	 $(function(){
		$("#signupForm").validate({
			submitHandler : function() {
				$.ajax({
					url : '/CustomerInfoKq/update.do',
					dataType : 'json',
					type : 'post',
					data : $('#signupForm').serialize(),
					success : function(result, status) {
						if (result.status == 0) {
							alert(result.msg);
						} else {
							alert(result.msg);
						}
					},
					error : function() {
						alert("修改失败！");
					}
				})
			}
		})
	});
</script>
</head>
<body>
	<jsp:include page="/views/Top.jsp"></jsp:include>
	<div class="whh_wraper">
		<form name="signupForm" method="post" id="signupForm">
			<div class="whh_content whh_content_border">
				<h2 class="whh_h2_bg">
					<span>修改考勤信息</span>
				</h2>
				<div class="whh_tab_bor">
				<input type="hidden" value="${customerInfoKq.id }" id="id"/>
					<table cellpadding="0" cellspacing="0" border="0" width="100%"
						class="whh_table">
						<tbody>
							<tr>
								<td class="whh_right"><span class="xing">*</span>选择人员：</td>
								<td>
								<c:if test="${customerInfoKq != null }">
									<select class="whh_sel" id="customerCode"
									name="customerCode" disabled="disabled">
										<c:forEach items="${customerInfos }" var="item">
											<option value=${customerInfoKq.customerCode } <c:if test="${item.customercode == customerInfoKq.customerCode  }">selected='selected'</c:if>>
											${item.customername }</option>
										</c:forEach>
								</select>
								</c:if>
								</td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>是否转正：</td>
								<td>
								<c:if test="${customerInfoKq != null }">
									<select class="whh_sel" name="ifZZ" id="ifZZ">
										<option value="">--请选择--</option>
										<option value=1>已转正</option>
										<option value=2>未转正</option>
										<option value=3>本月转正</option>
								</select>
								</c:if>
								</td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>闲置出勤天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.xzTime }" name="xzTime" id="xzTime" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>闲置法定出勤天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.xzFdTime }" name="xzFdTime" id="xzFdTime" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>加班小时：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.jbHover }" id="jbHover" name="jbHover" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>请假天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.qjTime }" name="qjTime" id="qjTime"/></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>迟到早退天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.cdTime }" name="cdTime" id="cdTime"/></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>入项实际出勤天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.sjTime }" name="sjTime" id="sjTime" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>入项法定出勤天数：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.fdTime }" name="fdTime" id="fdTime" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>税金：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.sj }" name="sj" id="sj" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>扣借款：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.kjk }" name="kjk" id="kjk"/></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>扣住宿：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.kzs }" id="kzs" name="kzs" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>报销：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.bxiao }" name="bxiao" id="bxiao" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>保险：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.bxian }" name="bxian" id="bxian" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>补助：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.bz }" id="bz" name="bz" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>新入职员工试用期实际时间：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.syqTime }" id="syqTime" name="syqTime" /></label></td>
							</tr>
							<tr>
								<td class="whh_right"><span class="xing">*</span>试用期法定工作时间：</td>
								<td><label class="whh_label"><input type="text"
										class="whh_input" value="${customerInfoKq.syqFdTime }" id="syqFdTime" name="syqFdTime" /></label></td>
							</tr>
						</tbody>
					</table>
					<p style="text-align: center;">
						<input type="button"
							class="whh_btn whh_btn_big mt20 whh_btn_big_blue"  value="保存" onclick="updata();">
					</p>
				</div>

			</div>
		</form>
	</div>
</body>
</html>