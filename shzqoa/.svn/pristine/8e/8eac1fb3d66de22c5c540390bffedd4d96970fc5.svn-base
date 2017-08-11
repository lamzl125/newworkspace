<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>跟踪财务收费</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/css/zyh_style.css">
<script src="/views/resource/js/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<script src="/views/resource/js/jquery.form.js" type="text/javascript"></script>
<script src="/views/resource/my97/WdatePicker.js" type="text/javascript"></script>
<script src="/views/resource/layer/layer.js"></script>
<script type="text/javascript">
	function save() {
		var CorpCode=$("#CorpCode").val();
		var ServicePayMonth=$("#ServicePayMonth").val();
		var ServicePayYearr=$("#ServicePayYearr").val(); 
		 var ServiceTitle=$("#ServicePayYearr").val()+"年"+$("#ServicePayMonth").val()+"月费用";
		 var Amount=$("#Amount").val();
		var PlanrRceivedPaymentsDate=$("#PlanrRceivedPaymentsDate").val();
		var IsSureReceivedDate=$("#IsSureReceivedDate option:selected").val();
		var FollowContent=$("#FollowContent").val();
		var IsReceivedPayments=$("#IsReceivedPayments option:selected").val();
		var RceivedPayments=$("#RceivedPayments").val();
		var AccountReceivable=$("#AccountReceivable option:selected").val();
		var PaymentContent=$("#PaymentContent").val();
		var PaymentDate=$("#PaymentDate").val();
		var Remark=$("#Remark").val(); 

		 var data= {
			  	"CorpCode":CorpCode,
			  	"ServicePayMonth": ServicePayMonth,
			  	"ServicePayYearr": ServicePayYearr,
			  	"ServiceTitle": ServiceTitle,
			  	"Amount": Amount,
			  	"PlanrRceivedPaymentsDate": PlanrRceivedPaymentsDate,
			  	"IsSureReceivedDate": IsSureReceivedDate,
			  	"FollowContent": FollowContent,
			  	"IsReceivedPayments": IsReceivedPayments,
			  	"RceivedPayments": RceivedPayments,
			  	"AccountReceivable": AccountReceivable,
			  	"PaymentContent": PaymentContent,
			  	"PaymentDate": PaymentDate,
			  	"Remark": Remark,
		}
		$.ajax({
			type : "post",
			url : "/servicepaysummary/saveservicepayfollow.do",
			data : data,
			dateType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.msg);
					parent.location.reload();
				} else {
					alert(result.msg);
				}
			}
		})
	}
	/* var i = 0;
	function addresume() {
		var sourceNode = document.getElementById("resume"); // 获得被克隆的节点对象 
		var clonedNode = sourceNode.cloneNode(true); // 克隆节点 
		clonedNode.setAttribute("id", "div-" + i); // 修改一下id 值，避免id 重复 
		sourceNode.parentNode.appendChild(clonedNode); // 在父节点插入克隆的节点 
		i++;
	} */
	//添加意向
	function addintent(obj) {
		/*var ele = $(obj).parent().parent().parent().clone(true);
		ele.attr("id", "");
		ele.find("div[data-name='closeFlag']").css("display", "block");
		ele.find("div[data-name='addFlag']").css("display", "none");
		ele.appendTo($(obj).parent().parent().parent().parent());*/
		var ele=$("#intentTemp").clone(true);
		ele.attr("id", "intent"+Math.random());
		ele.attr("display", "block");
		ele.appendTo($("#divIntention"));
	}
	//移除意向
	function closeintent(obj) {
		$(obj).parent().parent().remove();
	}
	function suresalary(obj){
		var ServicePayMonth=$("#ServicePayMonth").val();
		var ServicePayYearr=$("#ServicePayYearr").val(); 
		 var Amount=$("#Amount").val();
		
		
		var CorpCode=$("#CorpCode").val();
		var monthpayremark=$("#monthpayremark").val();
		var SubPay= $(obj).parent().parent().find(":input:eq(1)").val();
		var CustomerCode= $(obj).parents('tr').find('select').val();
		var data = {
			  	"CorpCode": CorpCode,
			  	"SubPay": SubPay,
			  	"CustomerCode": CustomerCode,
			  	"monthpayremark": monthpayremark,
			  	"ServicePayMonth": ServicePayMonth,
			  	"ServicePayYearr": ServicePayYearr,
			  	"Amount": Amount,
			  	}
		$.ajax({
			type : "post",
			url : "/servicepaysummary/suresalary.do",
			data : data,
			dateType : "json",
			success : function(result) {
				if (result.status == 0) {
					alert(result.msg);
				} else {
					alert(result.msg);
				}
			}
		})
	}
</script>
</head>
<body>
		<form id="form1" method="post" name="form1">
		<div class="whh_tab_bor">
			 <div class="whh_tab_bor">
				 <input type="hidden" value="${CorpCode}"name="corpCode" id="CorpCode"/> 
				 <input type="hidden" value="${ServicePayYearr}" name="servicePayYearr" id="ServicePayYearr"/> 
				 <input type="hidden" value="${ServicePayMonth}" name="servicePayMonth" id="ServicePayMonth"/> 
				 <input type="hidden" value="${Amount}" name="amount" id="Amount"/> 
				  <input type="hidden" value="${string1}" name="string1" id="string1"/>
				 <input type="hidden" value="${string2}" name="string2" id="string2"/> 
					 <div class="zyh_sos">
						<span>计划回款日期：</span> 
						  <input  type="text"  id="PlanrRceivedPaymentsDate" name="planrRceivedPaymentsDate" onclick="WdatePicker()"  onblur="$(this).trigger('change')" />  
							<span>&nbsp;&nbsp;是否已确定回款日</span>
						<select class="zyh_sel zyh_k_heigth whh_sel" id="IsSureReceivedDate" name="isSureReceivedDate" style="width: 65px;">
							<option value="">请选择</option>
							<option value="1">确定</option>
							<option value="2">不确定</option>
						</select> 
						

					</div> 
					 <div class="zyh_sos">
						<span>回款日期:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<input id="PaymentDate" type="text"  name="paymentDate"value="" placeholder="请输入日期" name="gzsj" onclick="WdatePicker()"readonly /> 
						
						<span>&nbsp;&nbsp;是否回款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
						<select class="zyh_sel zyh_k_heigth whh_sel" id="IsReceivedPayments" name="isReceivedPayments" style="width: 65px;">
							<option value="">请选择</option>
							<option value="0">否</option>
							<option value="1">是</option>
						</select>
						
					</div> 
					<div class="zyh_sos">
					<span>回款金额&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
						<input type="text" value=""id="RceivedPayments" name="rceivedPayments" /> 
						<span>&nbsp;&nbsp;收款帐号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<select class="zyh_sel zyh_k_heigth whh_sel"name="accountReceivable" id="AccountReceivable"style="width: 65px;">
							<option value="">请选择</option>
							<option value="1">总公司</option>
							<option value="2">分公司</option>
							<option value="3">个人卡</option>
						</select>
					</div> 
					 <div class="zyh_sos">
						<span>回款备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<textarea rows="2" cols="48" id="PaymentContent"
							name="paymentContent"></textarea>
					</div>
					<div class="zyh_sos">
					<span>跟踪情况&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<textarea rows="2" cols="48" name="followContent"
							id="FollowContent"></textarea>
					</div>
					<div class="zyh_sos">
					<span>备注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
						<textarea rows="2" cols="48" name="remark" id="Remark"></textarea>
					</div>
				 <div class="zyh_sos" id="pre">	
		<table> <!-- style="margin-top:3px;width:100%" -->
								<tbody>
										<tr id="intentTemp">
										<td>简历&nbsp;</td>
										<td><select class="form-control" name="demandresume" id="">
													<option value="">请选择</option>
														<c:forEach var="info" items="${list1}">
															<option value="${info.CustomerCode}">${info.CustomerName}</option>
														</c:forEach>
												</select>
										</td>
										<td align="right">&nbsp;金额&nbsp;</td>
										<td>
										<input style="width:50px;" type="text" id="resumeamount" name="resumeamount" />
										</td>
										<td>备注:
										<input type="text" id="monthpayremark" name="monthpayremark" />
										</td>
										<td style="width:40px;"><input type="button" value="扣除金额已确认" onclick="suresalary(this)"/></td>
										<td style="width:20px;">
										<div class="closeLayer" onclick="addintent(this)" data-name="addFlag">
											<input type="button" value="+"/>
										</div>
										<div class="closeLayer" onclick="closeintent(this)"  data-name="closeFlag">
											<!-- <img src="/images/details_close.png"> -->
											<input type="button" value="-&nbsp;"/>
										</div>
										
										</td>
										</tr>
										</tbody>
										<tfoot id="divIntention">
										</tfoot>
										</table>			
					</div> 
					
					
					<%-- <div class="zyh_sos" id="pre">
						<input type="button" value="新增客户简历" onclick="addresume();" />
						<div class="zyh_sos" id="resume">
							<span>简历</span> <select class="zyh_sel zyh_k_heigth whh_sel"
								id="AccountReceivable" name="demandresume" style="width: 65px;">
								<option value="">请选择</option>
								<c:forEach var="info" items="${list1}">
									<option value="${info.customercode}">${info.customername}</option>
								</c:forEach>
							</select> <span>金额</span> <input type="text" id="resumeamount"
								name="resumeamount" />
						</div>
					</div> --%>
					<div style="text-align: center; vertical-align: middel;">
						<input type="button" value="保存" onclick="save()" />
					</div>
			</div> 
		</div>
	</form>
</body>
</html>